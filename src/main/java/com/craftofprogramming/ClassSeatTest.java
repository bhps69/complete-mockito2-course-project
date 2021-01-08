package com.craftofprogramming;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Constructor;
import java.util.regex.Pattern;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ClassSeatTest {
	ClassSeat clasSeat;
	@Test
public void testMethod() throws NoSuchMethodException, SecurityException {
	final ClassSeat classSeat= mock(ClassSeat.class);
	
	//airLine is empty
	when(classSeat.getAirlineName()).thenThrow(RuntimeException.class);
	RuntimeException airlineException=Assertions.assertThrows(RuntimeException.class, ()->{(classSeat.getAirlineName()).isEmpty();});
	MatcherAssert.assertThat(RuntimeException.class, is(equalTo(airlineException.getClass())));
	
	/*airline is a string
	when(classSeat.getAirlineName()).thenThrow(RuntimeException.class);
	RuntimeException airlineStringException = Assertions.assertThrows(RuntimeException.class, ()->{airlineString(classSeat.getAirlineName());});
	MatcherAssert.assertThat(RuntimeException.class, is(equalTo(airlineStringException.getClass())));
	*/
	
	when(classSeat.getAvailableCount()).thenThrow(RuntimeException.class);
	RuntimeException countException= Assertions.assertThrows(RuntimeException.class, ()->{countAvailable(classSeat.getAvailableCount());});
	MatcherAssert.assertThat(RuntimeException.class, is(equalTo(countException.getClass())));
//	Constructor<?>[] arr;
//	arr=
	when(classSeat).thenThrow(RuntimeException.class);
	RuntimeException deptPriceException = Assertions.assertThrows(RuntimeException.class, ()->{DeptPrice(classSeat.getAirlineName(),classSeat.getAvailableCount());});
	MatcherAssert.assertThat(RuntimeException.class, is(equalTo(deptPriceException.getClass())));
	}
	
	public boolean countAvailable(int x) {
		if(x>=0)
			return true;
		else
			return false;
	}
	
	public boolean airlineString(String string) {
			return string!=null;
	}
	
	public boolean DeptPrice(String string, Integer count) {
		if(string =="" && count<=0)
			return false;
		else
			return true;
	}
	
}
