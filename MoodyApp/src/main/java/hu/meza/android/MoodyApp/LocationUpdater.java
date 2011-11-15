package hu.meza.android.MoodyApp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

class LocationUpdater implements LocationListener
{
	MoodyActivity target;
	private static String TAG = LocationUpdater.class.getSimpleName();
	public LocationUpdater(MoodyActivity target)
	{
		this.target = target;
		Log.i(TAG, "Listener booting");
	}
	
	@Override
	public void onLocationChanged(Location location)
	{
		String locationString = String.format("%2.7f, %2.7f", location.getLatitude(), location.getLongitude());
		Log.i(TAG, "And I received from my provider the following string: "+locationString);
		target.updateLocation(locationString);
	}


	@Override
	public void onProviderDisabled(String provider)
	{
		Log.i(TAG, "My provider has been disabled: "+provider);
	}


	@Override
	public void onProviderEnabled(String provider)
	{
		Log.i(TAG, "My provider has been enabled: "+provider);
	}


	@Override
	public void onStatusChanged(String provider,
		int status,
		Bundle extras)
	{
		Log.i(TAG, "My provider has changed status: "+provider);
	}
}