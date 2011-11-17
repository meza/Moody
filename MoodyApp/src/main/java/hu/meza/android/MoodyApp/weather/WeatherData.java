package hu.meza.android.MoodyApp.weather;

public class WeatherData
{

	private int cloudCover = 0;
	private int humidity = 0;
	private int pressure = 0;
	private int tempMin = 0;
	private int temp = 0;
	private int tempMax = 0;
	private int visibility = 0;
	private int weatherCode = 0;
	private int winddirDegree = 0;
	private int windspeed = 0;
	private double precipMM = 0.0;
	private String winddir16Point = "";


	public WeatherData(int cloudCover,
		int humidity,
		double precipMM,
		int pressure,
		int tempMin,
		int temp,
		int tempMax,
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
		this.tempMin = tempMin;
		this.temp = temp;
		this.tempMax = tempMax;
		this.visibility = visibility;
		this.weatherCode = weatherCode;
		this.winddir16Point = winddir16Point;
		this.winddirDegree = winddirDegree;
		this.windspeed = windspeed;
	}


	public WeatherData()
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


	public int tempMin()
	{
		return tempMin;
	}


	public int temp()
	{
		return temp;
	}


	public int tempMax()
	{
		return tempMax;
	}


	public int visibility()
	{
		return visibility;
	}


	public int weatherCode()
	{
		return weatherCode;
	}


	public String winddir16Point()
	{
		return winddir16Point;
	}


	public int winddirDegree()
	{
		return winddirDegree;
	}


	public int windspeed()
	{
		return windspeed;
	}

}
