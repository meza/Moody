package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.CurrentWeatherData;
import hu.meza.android.MoodyApp.weather.ForecastWeatherData;
import hu.meza.android.MoodyApp.weather.WeatherPrediction;
import hu.meza.android.MoodyApp.weather.WindDirection;
import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;

public class WeatherDataBuilderTest
{
	@Test
	public void testMyDataToJSONImplementation()
	{
		ForecastWeatherData fwd1 = new ForecastWeatherData(
			0.0,
			0,
			7,
			113,
			WindDirection.NE.toString(),
			34,
			WindDirection.NE.toString(),
			4);

		ForecastWeatherData fwd2 = new ForecastWeatherData(
			0.0,
			-1,
			7,
			113,
			WindDirection.SSE.toString(),
			149,
			WindDirection.SSE.toString(),
			5);

		CurrentWeatherData cwd = new CurrentWeatherData(
			0,
			86,
			0.0,
			1026,
			-1,
			3,
			143,
			WindDirection.NE.toString(),
			47,
			0);

		WeatherPrediction wp = new WeatherPrediction();
		ForecastWeatherData[] forecast = { fwd1, fwd2 };
		wp.setData(cwd, forecast);
		WeatherPrediction actual = new Gson().fromJson(
			wp.asJSON(),
			WeatherPrediction.class);
		Assert.assertTrue(wp.equals(actual));
	}
}
