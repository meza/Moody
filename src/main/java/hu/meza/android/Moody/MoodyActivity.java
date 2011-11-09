package hu.meza.android.Moody;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MoodyActivity extends Activity {

	public static final String TEST_PROVIDER = "testProvider";
	LocationManager locationManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		LocationListener locationListener = new LocationListener() {

			@Override
			public void onLocationChanged(Location location)
			{
				EditText field = (EditText) findViewById(R.id.locationInput);
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
			
		};
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = getBestProvider();
		Log.i("APP_MAIN", "I will use: "+locationProvider+" as provider");
		Log.i("APP_MAIN", "Location manager is: "+Integer.toString(locationManager.hashCode()));
		locationManager.requestLocationUpdates(locationProvider, 10, 0, locationListener);
		Log.i("APP_MAIN", "I have set up the listener");
	}
	
	private String getBestProvider()
	{
		if(locationManager.getProviders(true).contains("testProvider")) {
			return "testProvider";
		}
		return locationManager.getBestProvider(new Criteria(), true);
	}	
	
	@Override
	public void onPause()
	{
		super.onPause();
		Log.i("APP_MAIN", "I AM PAUSED BABY!");
		locationManager.removeTestProvider(TEST_PROVIDER);
	}
}