package org.inaetics.ails.impl.server.call_user_test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.inaetics.ails.api.common.model.AccessPoint;
import org.inaetics.ails.api.common.model.AccessPointMeasurement;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.inaetics.ails.api.server.user.service.UserService;

public class CallUserTest extends TimerTask {
	
	private enum Status {
			ADDING_USERS,
			ADDING_STREAMING_PROFILES,
			ADDING_LOCATION_PROFILES,
			LOCATING_USERS,
			CREATING_ACCESS_POINTS
	}
	
	private Status currentStatus = Status.ADDING_USERS;
	

    private volatile UserService us;
    private volatile StreamingProfileService sps;
    private volatile LocationProfileService lps;
    
    private Random rand = new Random();
    
    private List<AccessPoint> apList = new ArrayList<>();
    
    private int counter = 12;
    
    public void start() {
    	Timer timer = new Timer();
    	timer.schedule(this, 0, 1000);
    	
    }

	@Override
	public void run() {
		System.out.println("Doing something!");
		
		switch (this.currentStatus) {
		case ADDING_USERS:
			us.add("User #" + (us.getAll().size() + 1), Accuracy.BUILDING);
			us.add("User #" + (us.getAll().size() + 1), Accuracy.BUILDING);

			System.out.println("User service now has: " + us.getAll().size() + " users!");
	    	System.out.println(us.getAll().stream().map(x -> x.getName()).collect(Collectors.joining(",")));
			
			this.currentStatus = Status.CREATING_ACCESS_POINTS;
			break;
		case CREATING_ACCESS_POINTS:
			for (byte i = 0; i < 16; i++) {
				apList.add(new AccessPoint(new byte[]{i, i, i, i, i, i}));
			}
			
			this.currentStatus = Status.ADDING_STREAMING_PROFILES;
			break;
		case ADDING_STREAMING_PROFILES:
			UUIDWiFiProfile prof = new UUIDWiFiProfile(
					counter++,
					new WiFiProfile(Instant.now(), 
							apList.subList(rand.nextInt(6), rand.nextInt(6) + 11).stream()
								.map(x -> { 
									return new AccessPointMeasurement(x, rand.nextInt());
								}).collect(Collectors.toList())),
					us.getAll().get(rand.nextInt(us.getAll().size())).getUuid()
			);
			
			sps.add(prof);
			

			System.out.println("Added UUIDWiFiProfile: ");
			System.out.println(prof);
			
			this.currentStatus = Status.ADDING_LOCATION_PROFILES;			
			break;
		case ADDING_LOCATION_PROFILES:
			RawLocationProfile rawProf = new RawLocationProfile(
					counter++,
					new WiFiProfile(Instant.now(), 
							apList.subList(rand.nextInt(6), rand.nextInt(6) + 11).stream()
								.map(x -> { 
									return new AccessPointMeasurement(x, rand.nextInt());
								}).collect(Collectors.toList())),				
					new Location("Area#"+counter, "Building#"+counter, "Site#"+counter, "Organisation#"+counter)
			);		
			lps.add(rawProf);
			

			
			System.out.println("Added RawLocationProfile: ");
			System.out.println(rawProf);
			
			
			this.currentStatus = Status.LOCATING_USERS;
			break;
		case LOCATING_USERS:			
			User toLocate = us.getAll().get(rand.nextInt(us.getAll().size()));
			
			System.out.println(toLocate.getName() + " was at: " + us.locate(toLocate.getUuid()));		

			this.currentStatus = Status.ADDING_STREAMING_PROFILES;
			break;
		}  	
    	
	}
    
    

}
