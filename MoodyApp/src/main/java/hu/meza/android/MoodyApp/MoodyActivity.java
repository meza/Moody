package hu.meza.android.MoodyApp;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.EditText;

public class MoodyActivity extends Activity
{

	public static final String TEST_PROVIDER = "testProvider";
	LocationManager locationManager;


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LocationListener locationListener = new LocationUpdater(this);
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = getBestProvider();
		locationManager.requestLocationUpdates(
			locationProvider,
			0,
			0,
			locationListener,
			getMainLooper());
	}


	public void updateLocation(String location)
	{
		EditText field = (EditText) this.findViewById(R.id.locationInput);
		field.setText(location);
	}


	public String getBestProvider()
	{
		if (locationManager.getProviders(true).contains(TEST_PROVIDER)) {
			return TEST_PROVIDER;
		}
		return locationManager.getBestProvider(new Criteria(), true);
	}


	@Override
	public void onDestroy()
	{
		super.onPause();
		if (locationManager.getProviders(true).contains(TEST_PROVIDER)) {
			locationManager.removeTestProvider(TEST_PROVIDER);
		}
	}
}
