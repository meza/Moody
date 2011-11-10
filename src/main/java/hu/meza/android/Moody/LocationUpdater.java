package hu.meza.android.Moody;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

class LocationUpdater implements LocationListener
{
	EditText field;
	public LocationUpdater(EditText field)
	{
		this.field = field;
		Log.i("APP_MAIN", "Listener booting");
	}
	
	@Override
	public void onLocationChanged(Location location)
	{
		String locationString = String.format("%2.7f, %2.7f", location.getLatitude(), location.getLongitude());
		Log.i("APP_MAIN", "And I received from my provider the following string: "+locationString);
		field.setText(locationString);
	}


	@Override
	public void onProviderDisabled(String provider)
	{
		Log.i("APP_MAIN", "My provider has been disabled: "+provider);
	}


	@Override
	public void onProviderEnabled(String provider)
	{
		Log.i("APP_MAIN", "My provider has been enabled: "+provider);
	}


	@Override
	public void onStatusChanged(String provider,
		int status,
		Bundle extras)
	{
		Log.i("APP_MAIN", "My provider has changed status: "+provider);
	}
}