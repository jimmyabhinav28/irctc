package dev.abhinav.IRCTC.errorController;

import dev.abhinav.IRCTC.dto.ErrorResponse;
import dev.abhinav.IRCTC.exceptions.BookingException;
import dev.abhinav.IRCTC.exceptions.CancellationException;
import dev.abhinav.IRCTC.exceptions.SearchParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;


@ControllerAdvice
public class GlobalExceprtionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(SearchParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handle(SearchParametersException searchParametersException) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(searchParametersException.getMessage());
        return response;
    }

    @ExceptionHandler(BookingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handle(BookingException bookingException) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(bookingException.getMessage());
        return response;
    }

    @ExceptionHandler(CancellationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handle(CancellationException cancellationException) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(cancellationException.getMessage());
        return response;
    }
}
