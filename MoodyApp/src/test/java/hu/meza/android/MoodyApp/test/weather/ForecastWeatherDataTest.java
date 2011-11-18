package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.ForecastWeatherData;
import hu.meza.android.MoodyApp.weather.WindDirection;
import org.junit.Assert;
import org.junit.Test;

public class ForecastWeatherDataTest
{

	double precipMM = 0.0;
	int tempMin = -1;
	int tempMax = -1;
	int weatherCode = 143;
	WindDirection winddir16Point = WindDirection.NE;
	int winddirDegree = 47;
	WindDirection windDirection = WindDirection.NE;
	int windspeed = 0;


	@Test
	public void testTheFrigginGetters()
	{
		ForecastWeatherData object = createWeatherData();
		Assert.assertEquals(precipMM, object.precipMM(), 0);
		Assert.assertEquals(tempMin, object.tempMin());
		Assert.assertEquals(tempMax, object.tempMax());
		Assert.assertEquals(weatherCode, object.weatherCode());
		Assert.assertEquals(winddir16Point, object.winddir16Point());
		Assert.assertEquals(winddirDegree, object.winddirDegree());
		Assert.assertEquals(windDirection, object.windDirection());
		Assert.assertEquals(windspeed, object.windspeed());

	}


	@Test
	public void testNullObject()
	{
		ForecastWeatherData object = createNullWeatherData();
		Assert.assertEquals(0.0, object.precipMM(), 0);
		Assert.assertEquals(0, object.tempMin());
		Assert.assertEquals(0, object.tempMax());
		Assert.assertEquals(0, object.weatherCode());
		Assert.assertEquals(WindDirection.NULL, object.winddir16Point());
		Assert.assertEquals(0, object.winddirDegree());
		Assert.assertEquals(WindDirection.NULL, object.windDirection());
		Assert.assertEquals(0, object.windspeed());

	}


	private ForecastWeatherData createNullWeatherData()
	{
		ForecastWeatherData object = new ForecastWeatherData();
		return object;
	}


	private ForecastWeatherData createWeatherData()
	{

		ForecastWeatherData object = new ForecastWeatherData(
			precipMM,
			tempMin,
			tempMax,
			weatherCode,
			winddir16Point.toString(),
			winddirDegree,
			windDirection.toString(),
			windspeed);
		Assert.assertNotNull(object);
		return object;
	}
}
