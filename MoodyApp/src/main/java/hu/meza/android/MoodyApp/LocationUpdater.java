package hu.meza.android.MoodyApp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class LocationUpdater implements LocationListener {
	MoodyActivity target;

	public LocationUpdater(MoodyActivity target) {
		this.target = target;
	}

	@Override
	public void onLocationChanged(Location location) {
		String locationString = String.format("%2.7f, %2.7f",
				location.getLatitude(), location.getLongitude());
		target.updateLocation(locationString);
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