package com.craftofprogramming;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
F * 1) Add Javadoc
 * 2)
 *
 *
 * @author Nilton Santos 7/14/2019
 */
public class ReservationManager {
	
	private final DAO dao;

	public ReservationManager(DAO dao) {
		this.dao=dao;// TODO Auto-generated constructor stub
	}
    
    


    public Reservation book(Long quoteId, List<Passenger> passengers) {
    	
    	Reservation reservation=dao.saveReservation( quoteId, passengers);
        return reservation;
    }


    
    // static class for generating city-key pair
    
    //static class to store passenger
   

    //static class for reserving (passenger-citykeypair
    
    //static class to get quote
        // one for each: economy, business, first
    }
