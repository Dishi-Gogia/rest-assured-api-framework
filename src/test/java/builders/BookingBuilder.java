package builders;

import models.Booking;
import models.BookingDates;

public class BookingBuilder {

    public static Booking createBooking(
            String firstName,
            String lastName,
            int price,
            String checkIn,
            String checkOut,
            boolean depositPaid,
            String additionalNeeds) {

        BookingDates dates = new BookingDates();
        dates.setCheckin(checkIn);
        dates.setCheckout(checkOut);

        Booking booking = new Booking();

        booking.setFirstname(firstName);
        booking.setLastname(lastName);
        booking.setTotalprice(price);
        booking.setDepositpaid(depositPaid);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds(additionalNeeds);

        return booking;
    }

}
