package hu.meza.android.MoodyTest;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;

public class LocationFaker {

	private LocationManager lm;

	private static final boolean REQUIRES_NETWORK = false;
	private static final boolean REQUIRES_SATELLITE = false;
	private static final boolean REQUIRES_CELL = false;
	private static final boolean HAS_MONETARY_COST = false;
	private static final boolean SUPPORTS_ALTITUDE = true;
	private static final boolean SUPPORTS_SPEED = true;
	private static final boolean SUPPORTS_BEARING = true;
	private static String TAG = LocationFaker.class.getSimpleName();

	public LocationFaker(LocationManager locationManager) {
		lm = locationManager;
	}

	public Object getFakedManager() {
		return lm;
	}

	public void createTestProvider(String testProvider, long time) {
		if (!hasTestProvider(testProvider)) {
			lm.addTestProvider(testProvider, REQUIRES_NETWORK,
					REQUIRES_SATELLITE, REQUIRES_CELL, HAS_MONETARY_COST,
					SUPPORTS_ALTITUDE, SUPPORTS_SPEED, SUPPORTS_BEARING,
					android.location.Criteria.POWER_LOW,
					android.location.Criteria.ACCURACY_COARSE);
			lm.setTestProviderEnabled(testProvider, true);
			lm.setTestProviderStatus(testProvider, LocationProvider.AVAILABLE,
					null, time);
		}
		lm.setTestProviderStatus(testProvider, LocationProvider.AVAILABLE,
				null, time);
	}

	private boolean hasTestProvider(String testProvider) {
		return lm.getAllProviders().contains(testProvider);
	}

	public void publishMockLocation(String testProvider, double latitude,
			double longitude, long time) {
		lm.setTestProviderEnabled(testProvider, true);
		Location newLocation = new Location(testProvider);

		newLocation.setLatitude(latitude);
		newLocation.setLongitude(longitude);
		newLocation.setTime(time);
		newLocation.setAccuracy(0);
		lm.setTestProviderLocation(testProvider, newLocation);

	}
}