package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.WeatherDataFetcher;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class WeatherDataFetcherTest
{

	private HttpClient client;
	private ArgumentCaptor<HttpClient> argument;
	private WeatherDataFetcher object;


	@Before
	public void setUp()
	{
		client = Mockito.mock(HttpClient.class);
		argument = ArgumentCaptor.forClass(HttpClient.class);
		object = new WeatherDataFetcher(client);
	}


	@Test
	public void testThatCorrectURLIsCalled()
		throws ClientProtocolException, IOException, URISyntaxException
	{
		int longitude = 10;
		int latitude = 21;

		object.getPredictionForLocation(longitude, latitude);

		// Fetch the request object
		Mockito.verify(client).execute((HttpGet) argument.capture());

		String finalUri = String.format(
			"%s?0=%s,%s&format=json&num_of_days=2&key=%s",
			WeatherDataFetcher.SERVICE_URL,
			longitude,
			latitude,
			WeatherDataFetcher.API_KEY);
		Assert.assertEquals(finalUri, ((HttpGet) argument.getValue()).getURI()
			.toString());
	}

}
