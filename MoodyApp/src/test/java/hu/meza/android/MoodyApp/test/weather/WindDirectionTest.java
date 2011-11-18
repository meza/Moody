package hu.meza.android.MoodyApp.test.weather;

import hu.meza.android.MoodyApp.weather.WindDirection;
import junit.framework.Assert;
import org.junit.Test;

public class WindDirectionTest
{

	@Test
	public void testGetByString()
	{
		Assert.assertEquals(WindDirection.N, WindDirection.getByString("N"));
		Assert.assertEquals(WindDirection.E, WindDirection.getByString("E"));
		Assert.assertEquals(WindDirection.SSE, WindDirection.getByString("SSE"));
	}
}
