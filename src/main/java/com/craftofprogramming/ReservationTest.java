package com.craftofprogramming;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	void test() {
		final Reservation reservation=mock(Reservation.class);
		verify(reservation).setId(0l);
	}

}
