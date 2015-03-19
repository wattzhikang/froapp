package org.table2table.froapp.model;

public class CalculationModel {

	private int pounds = 0;
	private int quantity = 1;
	private boolean remainder = false;
	private boolean receiving = true;
	private int prevPounds = 0;
	private int prevQuantity = 1;
	private CategoryModel category;

	public CalculationModel(CategoryModel category) {
		this.category = category;
	}
	
	public CalculationModel(CategoryModel category, boolean receiving) {
		this.category = category;
		this.receiving = receiving;
	}

	public void setQuantity(int quantity) {
		this.quantity = Math.abs(quantity);
	}

	public void setPounds(int pounds) {
		this.pounds = Math.abs(pounds);
	}

	public void setRemainder(boolean remainder) {
		this.remainder = remainder;
		update();
	}

	public boolean update() {
		int total = getTotal();
		int change = total - prevPounds * prevQuantity;
		if (receiving){
			change = -change;
		}
		if (category.addRelative(change)) {
			prevQuantity = quantity;
			prevPounds = pounds;
		} else {
			this.pounds = prevPounds;
			this.quantity = prevQuantity;
			return false;
		}

		return true;
	}

	public int getTotal() {
		if (remainder) {
			if (!receiving) {
				return category.getPounds();
			}
		}
		return quantity * pounds;
	}
}