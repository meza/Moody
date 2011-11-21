package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.WeatherDataFetcher;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.mockito.Mockito;

import android.location.Location;

public class WeatherDataFetcherTest {

	private static String SERVICE_URL = "http://free.worldweatheronline.com/feed/weather.ashx";
	private static String API_KEY = "aabc1040d0162127111611";
	
	@Test
	public void test() throws ClientProtocolException, IOException, URISyntaxException {
		String url = SERVICE_URL+"?q=47.50,19.04&format=json&num_of_days=2&key="+API_KEY;
		String expected = "lófaszjésonszting";
		HttpGet request = Mockito.mock(HttpGet.class);
        HttpResponse resp = Mockito.mock(HttpResponse.class);
		HttpClient client = Mockito.mock(HttpClient.class);
		Mockito.when(client.execute(request)).thenReturn(resp);
		WeatherDataFetcher object = new WeatherDataFetcher(client);
		Location testLocation = Mockito.mock(Location.class);
		String actual = object.getPredictionForLocation(testLocation);
		String urlX = String.format("{0}?0={1},{2}&format=json&num_of_days=2&key={3}", SERVICE_URL, testLocation.getLongitude(), testLocation.getLatitude(), API_KEY);
		//Mockito.verify(request, Mockito.times(1)).setURI(new URI(SERVICE_URL));
	}

}
