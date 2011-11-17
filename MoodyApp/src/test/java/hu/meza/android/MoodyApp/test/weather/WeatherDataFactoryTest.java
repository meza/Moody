package hu.meza.android.MoodyApp.test.weather;

import javax.annotation.Generated;
import hu.meza.android.MoodyApp.weather.WeatherData;
import hu.meza.android.MoodyApp.weather.WeatherDataFactory;
import hu.meza.android.MoodyApp.weather.WeatherPrediction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WeatherDataFactoryTest
{

	private WeatherDataFactory factory;


	@Before
	public void setUp()
	{
		factory = new WeatherDataFactory();
	}


	@Test
	public void testAParse()
	{
		final String json = "{ \"data\": { \"current_condition\": [ {\"cloudcover\": \"0\", \"humidity\": \"86\", \"observation_time\": \"04:45 PM\", \"precipMM\": \"0.0\", \"pressure\": \"1026\", \"temp_C\": \"-1\", \"temp_F\": \"30\", \"visibility\": \"3\", \"weatherCode\": \"143\",  \"weatherDesc\": [ {\"value\": \"Mist\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0006_mist.png\" } ], \"winddir16Point\": \"NE\", \"winddirDegree\": \"47\", \"windspeedKmph\": \"0\", \"windspeedMiles\": \"0\" } ],  \"request\": [ {\"query\": \"Lat 47.50 and Lon 19.04\", \"type\": \"LatLon\" } ],  \"weather\": [ {\"date\": \"2011-11-16\", \"precipMM\": \"0.0\", \"tempMaxC\": \"7\", \"tempMaxF\": \"44\", \"tempMinC\": \"0\", \"tempMinF\": \"32\", \"weatherCode\": \"113\",  \"weatherDesc\": [ {\"value\": \"Sunny\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\" } ], \"winddir16Point\": \"NE\", \"winddirDegree\": \"34\", \"winddirection\": \"NE\", \"windspeedKmph\": \"4\", \"windspeedMiles\": \"3\" }, {\"date\": \"2011-11-17\", \"precipMM\": \"0.0\", \"tempMaxC\": \"7\", \"tempMaxF\": \"44\", \"tempMinC\": \"-1\", \"tempMinF\": \"30\", \"weatherCode\": \"113\",  \"weatherDesc\": [ {\"value\": \"Sunny\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\" } ], \"winddir16Point\": \"SSE\", \"winddirDegree\": \"149\", \"winddirection\": \"SSE\", \"windspeedKmph\": \"5\", \"windspeedMiles\": \"3\" } ] }}";
		WeatherPrediction actual = getActualFromJSON(json);

		WeatherData current = actual.currentWeatherData();

		Assert.assertEquals(0, current.cloudCover());
	}


	public void testAnotherParse() // WIP
	{
		final String json = "{ \"data\": { \"current_condition\": [ {\"cloudcover\": \"10\", \"humidity\": \"56\", \"observation_time\": \"11:46 AM\", \"precipMM\": \"0.0\", \"pressure\": \"1028\", \"temp_C\": \"6\", \"temp_F\": \"43\", \"visibility\": \"8\", \"weatherCode\": \"113\",  \"weatherDesc\": [ {\"value\": \"Sunny\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\" } ], \"winddir16Point\": \"S\", \"winddirDegree\": \"181\", \"windspeedKmph\": \"0\", \"windspeedMiles\": \"0\" } ],  \"request\": [ {\"query\": \"Lat 47.50 and Lon 19.04\", \"type\": \"LatLon\" } ],  \"weather\": [ {\"date\": \"2011-11-17\", \"precipMM\": \"0.0\", \"tempMaxC\": \"6\", \"tempMaxF\": \"43\", \"tempMinC\": \"-3\", \"tempMinF\": \"27\", \"weatherCode\": \"113\",  \"weatherDesc\": [ {\"value\": \"Sunny\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\" } ], \"winddir16Point\": \"S\", \"winddirDegree\": \"181\", \"winddirection\": \"S\", \"windspeedKmph\": \"5\", \"windspeedMiles\": \"3\" }, {\"date\": \"2011-11-18\", \"precipMM\": \"0.0\", \"tempMaxC\": \"8\", \"tempMaxF\": \"47\", \"tempMinC\": \"-2\", \"tempMinF\": \"28\", \"weatherCode\": \"113\",  \"weatherDesc\": [ {\"value\": \"Sunny\" } ],  \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/www.worldweatheronline.com\\/images\\/wsymbols01_png_64\\/wsymbol_0001_sunny.png\" } ], \"winddir16Point\": \"W\", \"winddirDegree\": \"262\", \"winddirection\": \"W\", \"windspeedKmph\": \"5\", \"windspeedMiles\": \"3\" } ] }}";
		WeatherPrediction actual = getActualFromJSON(json);

		WeatherData current = actual.currentWeatherData();

		Assert.assertEquals(10, current.cloudCover());
	}


	private WeatherPrediction getActualFromJSON(final String json)
	{
		WeatherPrediction actual = factory.createWeatherDataFromJSON(json);
		Assert.assertNotNull("Weather prediction was never created", actual);
		Assert.assertNotNull(
			"Weather prediction does not contain a current weather data",
			actual.currentWeatherData());
		Assert.assertEquals("WeatherData", actual.currentWeatherData()
			.getClass()
			.getSimpleName());
		Assert.assertNotNull(
			"No forecast persent in prediction",
			actual.forecast());
		Assert.assertEquals("WeatherForecast", actual.forecast()
			.getClass()
			.getSimpleName());
		return actual;
	}
}
