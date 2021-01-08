package com.craftofprogramming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

  class Reservation {
    static long idGenerator =1;
    long id;
    Quote quote;
    List<Passenger> passengers;
    BigDecimal totalPrice;

    /**
	 * @return the quote
	 */
	public Quote getQuote() {
		return quote;
	}

	/**
	 * @param quote the quote to set
	 */
	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	/**
	 * @return the passengers
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	Reservation(Quote quote, List<Passenger> passengers) {
        this.id = ++idGenerator + quote.id;
        this.passengers = new ArrayList<>(passengers);
        this.quote = quote;
        this.totalPrice = quote.price.multiply(BigDecimal.valueOf(passengers.size()));
    }
}
