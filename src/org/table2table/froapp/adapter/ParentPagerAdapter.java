package org.table2table.froapp.adapter;

import org.table2table.froapp.fragment.DepartureFragment;
import org.table2table.froapp.fragment.QuantityFragment;
import org.table2table.froapp.fragment.StoreFragment;
import org.table2table.froapp.fragment.SubmitFragment;
import org.table2table.froapp.model.SiteModel;
import org.table2table.froapp.model.TripModel;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class ParentPagerAdapter extends FragmentPagerAdapter {

	private TripModel tm;

	public ParentPagerAdapter(FragmentManager fm, TripModel tm) {
		super(fm);
		this.tm = tm;
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment;
		
		switch (arg0) {
		case 0:
			fragment = new DepartureFragment();
			break;
		default:
			int index = (arg0 - 1)/2;
			
			if(index >= tm.getNumSites()){
				return new SubmitFragment(tm.getCategories());
			}

			SiteModel site = tm.getSite(index);
			if(arg0%2 == 0){
				fragment = new QuantityFragment(site.getQuantities());
			} else {
				fragment = new StoreFragment(site);
			}
			break;
		}

		return fragment;
	}

	@Override
	public int getCount() {
		return tm.getNumSites()*2 + 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title;
		switch (position) {
		case 0:
			title = "Predeparture";
			break;
		default:
			int index = (position - 1)/2;
			if(index >= tm.getNumSites()){
				return "Postreturn";
			}

			SiteModel site = tm.getSite(index);
			
			if(position%2 == 0){
				if(site.isPickup()){
					title = "Pickup";
				} else {
					title = "Drop Off";
				}
			} else {
				title = site.getName();
			}
		}
		return title;
	}

}
