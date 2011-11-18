package hu.meza.android.MoodyApp.weather;

import com.google.gson.Gson;

public class WeatherDataFactory
{

	public WeatherPrediction createWeatherDataFromJSON(final String json)
	{
		WeatherPrediction result = new Gson().fromJson(
			json,
			WeatherPrediction.class);
		return result;
	}

}
