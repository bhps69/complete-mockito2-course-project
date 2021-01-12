package com.craftofprogramming;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Nilton Santos 7/14/2019
 */
public class DAO {
	private final Map<Long, Reservation> reservationIdToReservations = new HashMap<>();
	private final Map<Long, Quote> quoteIdToQuotes = new HashMap<>();
    // Date to CityPairKey to ClassType to (ascending price ordered) List of ClassSeat map!
    private final Map<LocalDate, Map<CityPairKey, Map<String, List<ClassSeat>>>> data = new HashMap<>();

	
	Reservation saveReservation(Long quoteId, List<Passenger> passengers) {
        //requireNonNullAndNonEmpty(quoteId);
        //requireNonNullAndNonEmpty(passengers);
        if (passengers.isEmpty()) {
            throw new RuntimeException(String.format("Supplied passengers list is empty for quoteId '%d'", quoteId));
        }
        Quote quote = this.quoteIdToQuotes.get(quoteId);
        if (quote == null) {
            throw new RuntimeException(String.format("Unable to find quote with id:%d", quoteId));
        }
        final Reservation reservation = new Reservation(quote, passengers);
         this.reservationIdToReservations.put(reservation.id, reservation);
         return reservation;
	}

    public Quote searchFlights(String fromCity, String toCity, String fromDate, String toDate, String tripType,
            String classType) {
		// make sure all input parameters are non-null and non-empty
		requireNonNullAndNonEmpty(fromCity);
		requireNonNullAndNonEmpty(fromDate);
		requireNonNullAndNonEmpty(tripType);
		requireNonNullAndNonEmpty(classType);
		if (tripType.equalsIgnoreCase("roundTrip")) {
		requireNonNullAndNonEmpty(toCity);
		requireNonNullAndNonEmpty(toDate);
		}
		
		final Quote resp = new Quote(fromCity, toCity, fromDate, toDate, tripType, classType);
		
		Map<CityPairKey, Map<String, List<ClassSeat>>> cityToClassTypeMap = data.get(LocalDate.parse(fromDate));
		
		if (cityToClassTypeMap == null) {
		resp.text = String.format("No seats available for the outbound flight on the date(s): %s",
		        fromDate);
		return resp;
		}
		
		Map<String, List<ClassSeat>> classTypeToSeatMap = cityToClassTypeMap.get(CityPairKey.valueOf(fromCity,toCity));
		
		if (classTypeToSeatMap == null) {
		resp.text = String.format("No seats available for the outbound flight for the city: %s",
		        fromCity);
		return resp;
		}
		
		List<ClassSeat> seatList = classTypeToSeatMap.get(classType);
		
		if (seatList == null) {
		resp.text = String.format("No seats available for the outbound flight on the classType: %s",
		        classType);
		return resp;
		}
		
		boolean found = false;
		for (final ClassSeat seat : seatList) {
		if (seat.availableCount > 0) {
		    resp.price = seat.price;
		    resp.inboundAirlineName = seat.airlineName;
		    resp.inboundSeatCount = seat.availableCount;
		    resp.inboundDepartureTime = seat.departureTime;
		
		    resp.text = "Found seats for the provided requested parameters";
		
		    found = true;
		}
		}
		
		if (!found || "OneWay".equalsIgnoreCase(tripType)) {
		return resp;
		}
		
		cityToClassTypeMap = data.get(LocalDate.parse(toDate));
		
		if (cityToClassTypeMap == null) {
		resp.text = String.format("No seats available for the return flight on the date(s): %s", toDate);
		return resp;
		}
		
		classTypeToSeatMap = cityToClassTypeMap.get(toCity);
		
		if (classTypeToSeatMap == null) {
		resp.text = String.format("No seats available for the return flight from the city: %s", toCity);
		return resp;
		}
		
		seatList = classTypeToSeatMap.get(classType);
		
		if (seatList == null) {
		resp.text = String.format("No seats available for the return flight on the classType: %s", classType);
		return resp;
		}
		
		for (final ClassSeat seat : seatList) {
		if (seat.availableCount > 0) {
		    resp.price = resp.price.add(seat.price);
		    resp.outboundAirlineName = seat.airlineName;
		    resp.outboundSeatCount = seat.availableCount;
		    resp.outboundDepartureTime = seat.departureTime;
		
		    resp.text = "Found seats for the provided requested parameters";
		
		    return resp;
		}
		}
		
		return resp;
		}
    
    private static void requireNonNullAndNonEmpty(Object o) {
        Objects.requireNonNull(o);
        if (o instanceof String) {
            String s = (String) o;
            if (s.isEmpty()) {
                throw new RuntimeException("Can't be empty");
            }
        }
    }


}
