package hu.meza.android.MoodyApp.weather;

import java.util.List;
import com.google.gson.annotations.SerializedName;

class JSONWeatherDataWrapper
{
	@SerializedName("current_condition")
	private List<CurrentWeatherData> currentCondition;
	@SerializedName("weather")
	private List<ForecastWeatherData> forecast;


	public CurrentWeatherData current()
	{
		return currentCondition.get(0);
	}


	public ForecastWeatherData forecastFor(int dayIndex)
	{
		return forecast.get(dayIndex);
	}
}