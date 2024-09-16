package entities;

import lombok.Getter;
import lombok.Setter;

public class IncompleteBooking {
    @Getter @Setter
    private String firstname;
    @Getter @Setter
    private int totalprice;
    @Getter @Setter
    private boolean depositpaid;
    @Getter @Setter
    private BookingDates bookingdates;
    @Getter @Setter
    private String additionalneeds;

}