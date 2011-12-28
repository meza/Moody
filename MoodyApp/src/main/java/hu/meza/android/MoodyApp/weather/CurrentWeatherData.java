package hu.meza.android.MoodyApp.weather;

import com.google.gson.annotations.SerializedName;

public class CurrentWeatherData
{

	@SerializedName("cloudcover")
	private int cloudCover = 0;
	private int humidity = 0;
	private int pressure = 0;
	@SerializedName("temp_C")
	private int temp = 0;
	private int visibility = 0;
	private int weatherCode = 0;
	private int winddirDegree = 0;
	@SerializedName("windspeedKmph")
	private int windspeed = 0;
	private double precipMM = 0.0;
	private String winddir16Point = "";


	public CurrentWeatherData(int cloudCover,
		int humidity,
		double precipMM,
		int pressure,
		int temp,
		int visibility,
		int weatherCode,
		String winddir16Point,
		int winddirDegree,
		int windspeed)
	{
		this.cloudCover = cloudCover;
		this.humidity = humidity;
		this.precipMM = precipMM;
		this.pressure = pressure;
		this.temp = temp;
		this.visibility = visibility;
		this.weatherCode = weatherCode;
		this.winddir16Point = winddir16Point;
		this.winddirDegree = winddirDegree;
		this.windspeed = windspeed;
	}


	public CurrentWeatherData()
	{}


	public int cloudCover()
	{
		return cloudCover;
	}


	public int humidity()
	{
		return humidity;
	}


	public double precipMM()
	{
		return precipMM;
	}


	public int pressure()
	{
		return pressure;
	}


	public int temp()
	{
		return temp;
	}


	public int visibility()
	{
		return visibility;
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


	public int hashCode()
	{
		String format = "%s%s%s%s%s%s%s%s%s%s";
		String op = String.format(
			format,
			this.cloudCover,
			this.humidity,
			this.precipMM,
			this.pressure,
			this.temp,
			this.visibility,
			this.weatherCode,
			this.winddir16Point,
			this.winddirDegree,
			this.windspeed);
		return op.hashCode();
	}

}
