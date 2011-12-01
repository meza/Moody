package hu.meza.android.MoodyApp.weather;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class WeatherDataFetcher
{

	public static String SERVICE_URL = "http://free.worldweatheronline.com/feed/weather.ashx";
	public static String API_KEY = "aaabbbccceeedddedededede";

	private HttpClient client = null;


	public WeatherDataFetcher(HttpClient client)
	{
		this.client = client;
	}


	public void getPredictionForLocation(int longitude, int latitude)
		throws ClientProtocolException, IOException
	{
		HttpGet request = new HttpGet();
		try {
			String finalUri = String.format(
				"%s?0=%s,%s&format=json&num_of_days=2&key=%s",
				SERVICE_URL,
				longitude,
				latitude,
				API_KEY);
			request.setURI(new URI(finalUri));
		} catch (URISyntaxException e1) {
			throw new RuntimeException("Syntax error in test");
		}
		client.execute(request);
	}

}
