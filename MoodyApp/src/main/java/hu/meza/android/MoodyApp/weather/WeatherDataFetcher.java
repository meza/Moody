package hu.meza.android.MoodyApp.weather;

import org.apache.http.client.HttpClient;

import android.location.Location;

public class WeatherDataFetcher {

	private HttpClient client = null;
	
	public WeatherDataFetcher(HttpClient client) {
		this.client = client;
	}
	
	public String getPredictionForLocation(Location testLocation) {
		return "";
		
	}

}
