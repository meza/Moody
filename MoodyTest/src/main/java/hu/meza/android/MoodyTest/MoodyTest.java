package hu.meza.android.MoodyTest;

import hu.meza.android.MoodyApp.MoodyActivity;
import hu.meza.android.MoodyApp.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.test.IsolatedContext;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.widget.EditText;

public class MoodyTest extends ActivityUnitTestCase<MoodyActivity> {

	public static final String TAG = "MoodyTest";
	private Intent mStartIntent;
	private Context mcontext;
	private LocationFaker locationFaker;
	private EditText field;

	public MoodyTest() {
		super(MoodyActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		locationFaker = new LocationFaker(
				(LocationManager) getInstrumentation().getTargetContext()
						.getSystemService(Context.LOCATION_SERVICE));
		locationFaker.createTestProvider(MoodyActivity.TEST_PROVIDER,
				System.currentTimeMillis());

		mcontext = new IsolatedContext(null, getInstrumentation().getContext()) {
			@Override
			public Object getSystemService(final String pName) {
				if (pName.equals(Context.LOCATION_SERVICE)) {
					return locationFaker.getFakedManager();
				}
				return getInstrumentation().getTargetContext()
						.getSystemService(pName);
			}
		};
		mStartIntent = new Intent(mcontext, MoodyActivity.class);
	}
	
	@SmallTest
	public void testThatTheTestProviderIsInUse() {
		bootActvity();
		assertEquals("Test provider not injected", MoodyActivity.TEST_PROVIDER,
				getActivity().getBestProvider());
		getActivity().onDestroy();
	}

	@MediumTest
	public void testIfMyLocationIsProperlyResolved() {
		bootActvity();
		testForLocation(37.7827, -122.421);
		getActivity().onDestroy();
	}

	@MediumTest
	public void testIfMyLocationIsProperlyResolvedInPortraitMode() {
		bootActvity();
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		testForLocation(47.49897, 19.0407);
		getActivity().onDestroy();
	}
	
	@MediumTest
	public void testIfMyLocationIsProperlyResolvedInLandscapeMode()
	{
		bootActvity();
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		testForLocation(47.7827, 12.4234);
		getActivity().onDestroy();
	}

	private void testForLocation(double latitude, double longitude) {
		field = (EditText) getActivity()
				.findViewById(R.id.locationInput);
		setMyLatLong(latitude, longitude);
		String actual = field.getText().toString();
		String expected = String.format("%2.7f, %2.7f", latitude, longitude);
		assertEquals(expected, actual);
	}

	private void bootActvity() {
		startActivity(mStartIntent, null, null);
		setActivityContext(mcontext);
		getActivity().onCreate(null);
	}

	private void setMyLatLong(double latitude, double longitude) {

		class MyListener implements LocationListener {
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
		MyListener ll = new MyListener();

		((LocationManager) locationFaker.getFakedManager())
				.requestSingleUpdate(MoodyActivity.TEST_PROVIDER, ll, getActivity().getMainLooper());
	
		locationFaker.publishMockLocation(MoodyActivity.TEST_PROVIDER,
				latitude, longitude, System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			assertNotNull("Location not received", ll.receivedLocation());
		} catch (InterruptedException e) {
			fail("Waiting for location has been interrupted");
		}
	}

}
