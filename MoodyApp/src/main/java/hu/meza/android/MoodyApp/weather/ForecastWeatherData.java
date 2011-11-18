package hu.meza.android.MoodyApp.weather;

import com.google.gson.annotations.SerializedName;

public class ForecastWeatherData
{
	@SerializedName("tempMinC")
	private int tempMin = 0;
	@SerializedName("tempMaxC")
	private int tempMax = 0;
	private int weatherCode = 0;
	private int winddirDegree = 0;
	@SerializedName("windspeedKmph")
	private int windspeed = 0;
	private double precipMM = 0.0;
	private String winddir16Point = "";
	private String winddirection = "";


	public ForecastWeatherData(double precipMM,
		int tempMin,
		int tempMax,
		int weatherCode,
		String winddir16Point,
		int winddirDegree,
		String winddirection,
		int windspeed)
	{
		this.precipMM = precipMM;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.weatherCode = weatherCode;
		this.winddir16Point = winddir16Point;
		this.winddirDegree = winddirDegree;
		this.winddirection = winddirection;
		this.windspeed = windspeed;
	}


	public ForecastWeatherData()
	{}


	public double precipMM()
	{
		return precipMM;
	}


	public int tempMin()
	{
		return tempMin;
	}


	public int tempMax()
	{
		return tempMax;
	}


	public int weatherCode()
	{
		return weatherCode;
	}


	public WindDirection winddir16Point()
	{
		return WindDirection.getByString(winddir16Point);
	}


	public int winddirDegree()
	{
		return winddirDegree;
	}


	public int windspeed()
	{
		return windspeed;
	}


	public WindDirection windDirection()
	{
		return WindDirection.getByString(winddirection);
	}
}
