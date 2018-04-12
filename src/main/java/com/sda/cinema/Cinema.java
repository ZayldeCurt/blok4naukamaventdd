package com.sda.cinema;

import com.sda.cinema.model.*;

public class Cinema {
    private final CinemaBookingService cinemaBookingService;
    private final CinemaNotifier cinemaNotifier;

    public Cinema(CinemaBookingService cinemaBookingService, CinemaNotifier cinemaNotifier) {
        this.cinemaBookingService = cinemaBookingService;
        this.cinemaNotifier = cinemaNotifier;
    }

    public CinemaBookingResponse bookMovie(CinemaMovie movie, int seating, CinemaUser user, CinemaChannnel channel){
        CinemaBookingStatus status = cinemaBookingService.bookSeating(movie, seating);
        if(!status.isStatus()){
            CinemaBookingResponse failureResponse = new CinemaBookingResponse();
            switch(status.getStatusCode()){
                case WRONG_SEATING_ID:
                    failureResponse.setMessage("Wybrano nie poprawny numer miesjca");
                    break;
                case INVALID_SEATING_TYPE:
                    failureResponse.setMessage("Wybrane miejsce jest już zajęte");
                    break;
                case SEATING_ALREADY_BOOKED:
                    failureResponse.setMessage("To miejsce nie jest przeznaczone dla takiej osoby jak ty");
                    break;
            }
            return failureResponse;
        }
        cinemaNotifier.notify(user,channel,"Numer Twojego biletu to : 123456789");
        return new CinemaBookingResponse(true,"Miejsce zarezerwowane, za chwile dostaniesz biler");
    }

}
