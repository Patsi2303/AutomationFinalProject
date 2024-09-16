package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.BookingEndpoints;
import entities.Booking;
import entities.BookingDates;
import entities.IncompleteBooking;
import entities.WrongBooking;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.Request;

import java.util.List;

import static org.hamcrest.Matchers.not;

public class BookingSteps {

    Response response;

    @Given("I perform a GET call to the bookings endpoint with id {string}")
    public void getBookingById(String id){
        response = Request.getById(BookingEndpoints.GET_BOOKING, id);
    }

    @And("I verify that the status code is {int}")
    public void verifyStatusCode(int statusCode){
        response.then().assertThat().statusCode(statusCode);
    }

    @And("I verify that the body does not have size {int}")
    public void verifyResponseSize(int size){
        response.then().assertThat().body("size()", not(size));
    }

    @And("The booking firstname is {string}")
    public void verifyBookingFirstname(String bookingFirstname){
        response.then().assertThat().body("firstname", Matchers.equalTo(bookingFirstname));
    }

    @And("The booking lastname is {string}")
    public void verifyBookingLastname(String bookingLastname){
        response.then().assertThat().body("lastname", Matchers.equalTo(bookingLastname));
    }

    @And("I perform a POST call to the create endpoint with the following data")
    public void postBooking(DataTable bookingInfo) throws JsonProcessingException {
        List<String> data = bookingInfo.transpose().asList(String.class);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(data.get(4));
        bookingDates.setCheckout(data.get(5));
        Booking booking = new Booking();
        booking.setFirstname(data.get(0));
        booking.setLastname(data.get(1));
        booking.setTotalprice(Integer.valueOf(data.get(2)));
        boolean depositPaid = Boolean.parseBoolean(data.get(3));
        booking.setDepositpaid(depositPaid);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(data.get(6));

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);

        response = Request.post(BookingEndpoints.POST_BOOKING, payload);
    }

    @And("I verify the following data in the body response")
    public void verifyBookingData(DataTable bookingInfo){
        List<String> data = bookingInfo.transpose().asList(String.class);
        response.then().assertThat().body("booking.firstname", Matchers.equalTo(data.get(0)));
        response.then().assertThat().body("booking.lastname", Matchers.equalTo(data.get(1)));
        response.then().assertThat().body("booking.totalprice", Matchers.equalTo(Integer.valueOf(data.get(2))));
        boolean depositPaid = Boolean.parseBoolean(data.get(3));
        response.then().assertThat().body("booking.depositpaid", Matchers.equalTo(depositPaid));
        response.then().assertThat().body("booking.bookingdates.checkin", Matchers.equalTo(data.get(4)));
        response.then().assertThat().body("booking.bookingdates.checkout", Matchers.equalTo(data.get(5)));
        response.then().assertThat().body("booking.additionalneeds", Matchers.equalTo(data.get(6)));
    }

    @And("I perform a POST call to the create endpoint with the following incomplete data")
    public void postIncompleteBooking(DataTable bookingInfo) throws JsonProcessingException {
        List<String> data = bookingInfo.transpose().asList(String.class);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(data.get(3));
        bookingDates.setCheckout(data.get(4));
        IncompleteBooking booking = new IncompleteBooking();
        booking.setFirstname(data.get(0));
        booking.setTotalprice(Integer.valueOf(data.get(1)));
        boolean depositPaid = Boolean.parseBoolean(data.get(2));
        booking.setDepositpaid(depositPaid);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(data.get(5));

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);

        response = Request.post(BookingEndpoints.POST_BOOKING, payload);
    }

    @And("I perform a POST call to the create endpoint with the following data with additional info")
    public void postAddtionalInfoBooking(DataTable bookingInfo) throws JsonProcessingException {
        List<String> data = bookingInfo.transpose().asList(String.class);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(data.get(4));
        bookingDates.setCheckout(data.get(5));
        WrongBooking booking = new WrongBooking();
        booking.setFirstname(data.get(0));
        booking.setLastname(data.get(1));
        booking.setTotalprice(Integer.valueOf(data.get(2)));
        boolean depositPaid = Boolean.parseBoolean(data.get(3));
        booking.setDepositpaid(depositPaid);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds(data.get(6));
        booking.setEmail(data.get(7));

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);

        response = Request.post(BookingEndpoints.POST_BOOKING, payload);
    }
}
