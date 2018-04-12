package com.sda.cinema;

import com.sda.cinema.model.CinemaBookingResponse;
import com.sda.cinema.model.CinemaBookingStatus;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import sun.misc.ASCIICaseInsensitiveComparator;

public class CinemaTest {

    @Test
    public void userCanReserveMovieAndReciveNotificationWithTicket(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeating(Mockito.any(),Mockito.anyInt()))
                .then(e->new CinemaBookingStatus(true,null));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        //mock ma domyślne implementacje

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);


        //then
        Assert.assertEquals("Miejsce zarezerwowane, za chwile dostaniesz biler",response.getMessage());
        Assert.assertTrue(response.isStatus());

    }
}
