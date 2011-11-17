package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.WeatherData;
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
	String winddir16Point = "NE";
	int winddirDegree = 47;
	int windspeed = 0;


	@Test
	public void testTheFrigginGetters()
	{
		WeatherData object = createWeatherData();
		Assert.assertEquals(cloudCover, object.cloudCover());
		Assert.assertEquals(humidity, object.humidity());
		Assert.assertEquals(precipMM, object.precipMM(), 0);
		Assert.assertEquals(pressure, object.pressure());
		Assert.assertEquals(tempMin, object.tempMin());
		Assert.assertEquals(temp, object.temp());
		Assert.assertEquals(tempMax, object.tempMax());
		Assert.assertEquals(visibility, object.visibility());
		Assert.assertEquals(weatherCode, object.weatherCode());
		Assert.assertEquals(winddir16Point, object.winddir16Point());
		Assert.assertEquals(winddirDegree, object.winddirDegree());
		Assert.assertEquals(windspeed, object.windspeed());

	}


	@Test
	public void testNullObject()
	{
		WeatherData object = createNullWeatherData();
		Assert.assertEquals(0, object.cloudCover());
		Assert.assertEquals(0, object.humidity());
		Assert.assertEquals(0.0, object.precipMM(), 0);
		Assert.assertEquals(0, object.pressure());
		Assert.assertEquals(0, object.tempMin());
		Assert.assertEquals(0, object.temp());
		Assert.assertEquals(0, object.tempMax());
		Assert.assertEquals(0, object.visibility());
		Assert.assertEquals(0, object.weatherCode());
		Assert.assertEquals("", object.winddir16Point());
		Assert.assertEquals(0, object.winddirDegree());
		Assert.assertEquals(0, object.windspeed());

	}


	private WeatherData createNullWeatherData()
	{
		WeatherData object = new WeatherData();
		return object;
	}


	private WeatherData createWeatherData()
	{

		WeatherData object = new WeatherData(
			cloudCover,
			humidity,
			precipMM,
			pressure,
			tempMin,
			temp,
			tempMax,
			visibility,
			weatherCode,
			winddir16Point,
			winddirDegree,
			windspeed);
		Assert.assertNotNull(object);
		return object;
	}

}
