package hu.meza.android.MoodyTest;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

class TestLocationListener implements LocationListener {
	
	private final static String TAG = "MyListener";
	
	private Location receivedLocation = null;

	public Location receivedLocation() {
		return receivedLocation;
	}

	@Override
	public void onLocationChanged(Location location) {
		receivedLocation = location;
		Log.d(TAG, String.format("onLocationChanged -> [lat:%f|long:%f]", location.getLatitude(),location.getLongitude()));
	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.d(TAG, String.format("onProviderDisabled: %s", provider));
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.d(TAG, String.format("onProviderEnabled: %s", provider));

	}

	@Override
	public void onStatusChanged(String provider, int status,
			Bundle extras) {
		// TODO Auto-generated method stub

	}
}