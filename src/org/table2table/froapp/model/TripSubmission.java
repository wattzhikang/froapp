package org.table2table.froapp.model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.table2table.froserver.model.MileageEntry;
import org.table2table.froserver.model.PoundEntry;
import org.table2table.froserver.model.SiteEntry;
import org.table2table.froserver.service.AddTripCommand;
import org.table2table.froserver.service.ClientMessage;
import org.table2table.froserver.service.CloseCommand;
import org.table2table.froserver.service.GetRoutesCommand;
import org.table2table.froserver.service.GetSitesCommand;

import android.os.AsyncTask;

public class TripSubmission {
	/*
	private volatile String ip;
	private volatile TripModel trip; 

	public TripSubmission(String IPAddress) {
		ip = IPAddress;
	}
	
	public void submitTrip (TripModel inputTrip) {
		trip = inputTrip;
		Submitter submitter = new Submitter();
		submitter.execute(null, null, null);
		try {
			submitter.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class Submitter extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Socket client = new Socket(hostName, org.table2table.froserver.Main.portNumber);
				
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
				
				output.writeObject(new AddTripCommand());
				
				output.writeObject(new MileageEntry(trip.getVanID(), Date.today(), trip.getID(), trip.getVanMileage()));
				
				List<PoundEntry> pounds = new LinkedList<PoundEntry>();
				List<SiteModel> sites = trip.getAllSites();
				for (SiteModel site : sites) {
					
				}
				
				output.close();
				input.close();
				client.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	}
*/
}
