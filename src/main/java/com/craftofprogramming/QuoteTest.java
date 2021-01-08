package com.craftofprogramming;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuoteTest {
	@Test
	void testMethod() throws NoSuchMethodException, SecurityException {

		final Quote quote = mock(Quote.class);
		//exception for to and from places
		when(quote.isString(anyString())).thenThrow(new RuntimeException());
		RuntimeException runtimeException= org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, ()->{quote.isString("j");});
		MatcherAssert.assertThat(runtimeException.getClass(),is(equalTo(RuntimeException.class)));
		//exeption for to and from dates
		when(quote.isDateString(anyString())).thenThrow(new RuntimeException());
		RuntimeException dateException=Assertions.assertThrows(RuntimeException.class, ()->{quote.isDateString("");});
		MatcherAssert.assertThat(dateException.getClass(), is(equalTo(RuntimeException.class)));
		//exception for TripType
		when(quote.tripDataType(anyString())).thenThrow(new RuntimeException());
		RuntimeException tripException = Assertions.assertThrows(RuntimeException.class, ()->{quote.tripDataType("");});
		MatcherAssert.assertThat(tripException.getClass(), is(equalTo(RuntimeException.class)));
		//exception for class type
		when(quote.classDataType(anyString())).thenThrow(new RuntimeException());
		RuntimeException classTypeException= Assertions.assertThrows(RuntimeException.class, ()->{quote.classDataType("");});
		MatcherAssert.assertThat(runtimeException.getClass(), is(equalTo(RuntimeException.class)));
		/*exception for the constructor
		when(quote.getClass()).thenThrow(RuntimeException.class);
		RuntimeException constException = Assertions.assertThrows(RuntimeException.class, ()->{ this.idGeneration(quote.getFromCity(), quote.getToCity(),quote.getFromDate(), quote.getToDate(),quote.getTripType(), quote.getClassType());});
		MatcherAssert.assertThat(runtimeException.getClass(), is(equalTo(RuntimeException.class)));*/
	}
	public boolean idGeneration(String fromCity,String toCity,String fromDate, String toDate, String tripType,String classType) {
		if(fromCity!="" && toCity!="" && fromDate!="" && toDate!="" && tripType!="" && classType!="") 
			return true;
		else
			return false;
		
	}
}
