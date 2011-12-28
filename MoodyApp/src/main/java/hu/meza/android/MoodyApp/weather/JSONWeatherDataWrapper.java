package hu.meza.android.MoodyApp.weather;

import java.util.ArrayList;
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


	public void setData(CurrentWeatherData current,
		ForecastWeatherData[] forecastData)
	{
		currentCondition = new ArrayList<CurrentWeatherData>();
		forecast = new ArrayList<ForecastWeatherData>();
		currentCondition.add(current);
		for (ForecastWeatherData f : forecastData) {
			forecast.add(f);
		}
	}


	public int hashCode()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(current().hashCode());
		for (ForecastWeatherData f : forecast) {
			sb.append(f.hashCode());
		}
		return sb.toString().hashCode();
	}
}
