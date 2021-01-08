package com.craftofprogramming;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

import org.hamcrest.number.IsNaN;

public class ClassSeat {
    String airlineName;
	int availableCount;
    String departureTime;
    BigDecimal price;
    Random random = new Random();

    ClassSeat(String airline, int seats) {
         this.airlineName = airline;
        this.availableCount = seats;
        this.departureTime = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        this.price = BigDecimal.valueOf(random.nextDouble() * 1000).setScale(0, RoundingMode.HALF_EVEN);
    }
    
    public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}


	
	
    static ClassSeat valueOf(String airline, int seats) {
        return new ClassSeat(airline, seats);
    }

    @Override
    public String toString() {
        return String.format("Airline:%s| Seats:%d | Departure-time=%s | Price-per-seat:%s", airlineName,
                availableCount, departureTime, price);
    }
    
    public boolean isAirlineValid() {
    	if(this.getAirlineName()!="" && this.getAirlineName()!=null) {
    		return true;
    	}
    	return false;
    }
    public boolean areSeatsValid() {
    	if(this.getAvailableCount()<0 )
    		return false;
    	else 
    		return true;
    }
    public boolean departureType() {
    	if(this.getDepartureTime()!="" && this.getDepartureTime()!=null)
    		return true;
    	else 
    		return false;
    	
    }
    public boolean priceType() {
    	if ((this.getPrice()) instanceof BigDecimal)
    		return true;
    	else
    		return false;
    }
}
