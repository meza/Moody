package hu.meza.android.MoodyApp.weather;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WeatherPrediction
{

	public static final int DAY_1 = 0;
	public static final int DAY_2 = 1;
	public static final int DAY_3 = 2;
	public static final int DAY_4 = 3;
	public static final int DAY_5 = 4;

	@SerializedName("data")
	private JSONWeatherDataWrapper weatherData;


	public CurrentWeatherData currentWeatherData()
	{
		return weatherData.current();
	}


	public ForecastWeatherData forecastFor(int dayIndex)
	{
		return weatherData.forecastFor(dayIndex);
	}


	public void setData(CurrentWeatherData current,
		ForecastWeatherData[] forecast)
	{
		weatherData = new JSONWeatherDataWrapper();
		weatherData.setData(current, forecast);
	}


	public String asJSON()
	{
		return new Gson().toJson(this);
	}


	public int hashCode()
	{
		return weatherData.hashCode();
	}


	public boolean equals(WeatherPrediction other)
	{
		return (this.hashCode() == other.hashCode());
	}
}
