package hu.meza.android.MoodyTest;

import hu.meza.android.MoodyApp.MoodyActivity;
import hu.meza.android.MoodyApp.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.LocationManager;
import android.test.ActivityUnitTestCase;
import android.test.IsolatedContext;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.EditText;

public class MoodyTest extends ActivityUnitTestCase<MoodyActivity>
{

	public static final String TAG = "MoodyTest";
	private Intent mStartIntent;
	private Context mcontext;
	private LocationFaker locationFaker;
	private EditText field;


	public MoodyTest()
	{
		super(MoodyActivity.class);
	}


	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		locationFaker = new LocationFaker(
			(LocationManager) getInstrumentation().getTargetContext()
				.getSystemService(Context.LOCATION_SERVICE));
		locationFaker.createTestProvider(
			MoodyActivity.TEST_PROVIDER,
			System.currentTimeMillis());

		mcontext = new IsolatedContext(null, getInstrumentation().getContext())
		{
			@Override
			public Object getSystemService(final String pName)
			{
				if (pName.equals(Context.LOCATION_SERVICE)) {
					return locationFaker.getFakedManager();
				}
				return getInstrumentation().getTargetContext()
					.getSystemService(pName);
			}
		};
		mStartIntent = new Intent(mcontext, MoodyActivity.class);
	}


	@MediumTest
	public void testThatTheTestProviderIsInUse()
	{
		bootActvity();
		assertEquals(
			"Test provider not injected",
			MoodyActivity.TEST_PROVIDER,
			getActivity().getBestProvider());
		getActivity().onDestroy();
	}


	@MediumTest
	public void testIfMyLocationIsProperlyResolved()
	{
		bootActvity();
		testForLocation(37.7827, -122.421);
		getActivity().onDestroy();
	}


	@MediumTest
	public void testIfMyLocationIsProperlyResolvedInPortraitMode()
	{
		bootActvity();
		getActivity().setRequestedOrientation(
			ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		testForLocation(47.49897, 19.0407);
		getActivity().onDestroy();
	}


	@MediumTest
	public void testIfMyLocationIsProperlyResolvedInLandscapeMode()
	{
		bootActvity();
		getActivity().setRequestedOrientation(
			ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		testForLocation(47.7827, 12.4234);
		getActivity().onDestroy();
	}


	private void testForLocation(double latitude, double longitude)
	{
		field = (EditText) getActivity().findViewById(R.id.locationInput);
		setMyLatLong(latitude, longitude);
		String actual = field.getText().toString();
		String expected = String.format("%2.7f, %2.7f", latitude, longitude);
		assertEquals(expected, actual);
	}


	private void bootActvity()
	{
		startActivity(mStartIntent, null, null);
		setActivityContext(mcontext);
		getActivity().onCreate(null);
	}


	private void setMyLatLong(double latitude, double longitude)
	{

		TestLocationListener testListener = new TestLocationListener();
		final LocationManager locationManager = (LocationManager) locationFaker.getFakedManager();
		locationManager.requestLocationUpdates(
			MoodyActivity.TEST_PROVIDER,
			0,
			0,
			testListener,
			getActivity().getMainLooper());

		locationFaker.publishMockLocation(
			MoodyActivity.TEST_PROVIDER,
			latitude,
			longitude,
			System.currentTimeMillis());
		try {
			Thread.sleep(1000);
			// Verify that the listener receives the location
			assertNotNull(
				"Location not received",
				testListener.receivedLocation());
		} catch (InterruptedException e) {
			fail("Waiting for location has been interrupted");
		}
	}

}
