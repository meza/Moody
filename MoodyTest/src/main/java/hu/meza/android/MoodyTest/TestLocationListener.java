package hu.meza.android.MoodyTest;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class TestLocationListener implements LocationListener {

	private Location receivedLocation = null;

	public Location receivedLocation() {
		return receivedLocation;
	}

	@Override
	public void onLocationChanged(Location location) {
		receivedLocation = location;
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}
}