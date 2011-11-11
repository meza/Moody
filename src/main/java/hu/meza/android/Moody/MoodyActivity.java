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
	private static String TAG = MoodyActivity.class.getSimpleName();
	LocationManager locationManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LocationListener locationListener = new LocationUpdater(this);
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = getBestProvider();
		Log.i(TAG, "I will use: "+locationProvider+" as provider");
		Log.i(TAG, "Location manager is: "+Integer.toString(locationManager.hashCode()));
		locationManager.requestLocationUpdates(locationProvider, 1000, 1000, locationListener);
		Log.i(TAG, "I have set up the listener");
	}

	public void updateLocation(String location)
	{
		EditText field = (EditText) this.findViewById(R.id.locationInput);
		field.setText(location);
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
		Log.i(TAG, "I AM PAUSED BABY!");
		if(locationManager.getProviders(true).contains(TEST_PROVIDER)) {
			locationManager.removeTestProvider(TEST_PROVIDER);
		}
	}
}