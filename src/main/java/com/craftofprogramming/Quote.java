package com.craftofprogramming;

import java.math.BigDecimal;

public class Quote {
    static int idGenerator = 1;

    // request fields
    String fromCity;

	String toCity;
    String fromDate;
    String toDate;
    String tripType;
    String classType;

    // response fields
    long id;
    
	String text;
    BigDecimal price;
    int inboundSeatCount;
    String inboundAirlineName;
    String inboundDepartureTime;
    int outboundSeatCount;
    String outboundAirlineName;
    String outboundDepartureTime;

    Quote(String fromCity, String toCity, String fromDate, String toDate, String tripType,
          String classType) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.tripType = tripType;
        this.classType = classType;

        this.text = "Couldn't find any seats for the provided request parameters";
        this.id = getId();
    }
    public long getId() {
		return ++idGenerator;
	}
    public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public void setId(long id) {
		this.id = id;
	}
    boolean isString(String place) {
		if(place!="" && place!=null)
			return true;
		else
			return false;
	}
    boolean isDateString(String dates) {
    	if(dates!="" && dates!=null)
    		return true;
    	else
    		return false;
    }
    boolean tripDataType(String tripType) {
    	if(tripType!="" && tripType!=null)
    		return true;
    	else
    		return false;
    }
    boolean classDataType(String classType) {
    	if(classType!="" && classType!=null)
    		return true;
    	else
    		return false;
    }
    boolean getIdDataType() {
    	return ((Object)(this.getId())).getClass().getName()=="java.lang.Long";
    }
}

