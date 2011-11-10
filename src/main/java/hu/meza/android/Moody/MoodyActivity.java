package hu.meza.android.Moody;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LocationListener locationListener = new LocationUpdater((EditText) findViewById(R.id.locationInput));
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = getBestProvider();
		Log.i("APP_MAIN", "I will use: "+locationProvider+" as provider");
		Log.i("APP_MAIN", "Location manager is: "+Integer.toString(locationManager.hashCode()));
		locationManager.requestLocationUpdates(locationProvider, 1000, 1000, locationListener);
		Log.i("APP_MAIN", "I have set up the listener");
	}

	private String getBestProvider()
	{
		if(locationManager.getProviders(true).contains(TEST_PROVIDER)) {
			return TEST_PROVIDER;
		}
		return locationManager.getBestProvider(new Criteria(), true);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		Log.i("APP_MAIN", "I AM PAUSED BABY!");
		if(locationManager.getProviders(true).contains(TEST_PROVIDER)) {
			locationManager.removeTestProvider(TEST_PROVIDER);
		}
	}
}