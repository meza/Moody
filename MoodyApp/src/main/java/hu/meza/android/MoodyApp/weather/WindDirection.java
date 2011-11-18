package hu.meza.android.MoodyApp.weather;

public enum WindDirection
{
	N,
	NbE,
	NNE,
	NEbN,
	NE,
	NEbE,
	ENE,
	EbN,
	E,
	EbS,
	ESE,
	SEbE,
	SE,
	SEbS,
	SSE,
	SbE,
	NULL;

	public static WindDirection getByString(String d)
	{
		if (d.isEmpty()) {
			return WindDirection.NULL;
		}
		return WindDirection.valueOf(d);
	}
}
