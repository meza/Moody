package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.CurrentWeatherData;
import hu.meza.android.MoodyApp.weather.WindDirection;
import org.junit.Assert;
import org.junit.Test;

public class WeatherDataObjectTest
{

	int cloudCover = 0;
	int humidity = 86;
	double precipMM = 0.0;
	int pressure = 1026;
	int tempMin = 0;
	int temp = -1;
	int tempMax = 7;
	int visibility = 3;
	int weatherCode = 143;
	WindDirection winddir16Point = WindDirection.NE;
	int winddirDegree = 47;
	WindDirection winddirection = WindDirection.SE;
	int windspeed = 0;


	@Test
	public void testTheFrigginGetters()
	{
		CurrentWeatherData object = createWeatherData();
		Assert.assertEquals(cloudCover, object.cloudCover());
		Assert.assertEquals(humidity, object.humidity());
		Assert.assertEquals(precipMM, object.precipMM(), 0);
		Assert.assertEquals(pressure, object.pressure());
		Assert.assertEquals(temp, object.temp());
		Assert.assertEquals(visibility, object.visibility());
		Assert.assertEquals(weatherCode, object.weatherCode());
		Assert.assertEquals(winddir16Point, object.winddir16Point());
		Assert.assertEquals(winddirDegree, object.winddirDegree());
		Assert.assertEquals(windspeed, object.windspeed());

	}


	@Test
	public void testNullObject()
	{
		CurrentWeatherData object = createNullWeatherData();
		Assert.assertEquals(0, object.cloudCover());
		Assert.assertEquals(0, object.humidity());
		Assert.assertEquals(0.0, object.precipMM(), 0);
		Assert.assertEquals(0, object.pressure());
		Assert.assertEquals(0, object.temp());
		Assert.assertEquals(0, object.visibility());
		Assert.assertEquals(0, object.weatherCode());
		Assert.assertEquals(WindDirection.NULL, object.winddir16Point());
		Assert.assertEquals(0, object.winddirDegree());
		Assert.assertEquals(0, object.windspeed());

	}


	private CurrentWeatherData createNullWeatherData()
	{
		CurrentWeatherData object = new CurrentWeatherData();
		return object;
	}


	private CurrentWeatherData createWeatherData()
	{

		CurrentWeatherData object = new CurrentWeatherData(
			cloudCover,
			humidity,
			precipMM,
			pressure,
			temp,
			visibility,
			weatherCode,
			winddir16Point.toString(),
			winddirDegree,
			windspeed);
		Assert.assertNotNull(object);
		return object;
	}

}
