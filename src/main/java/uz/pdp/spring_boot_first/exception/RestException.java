package uz.pdp.spring_boot_first.exception;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 21:05
 **/
public class RestException extends RuntimeException {

    public static RestException notFound(String message, Object id) {
        if (id == null) {
            return new RestException(message);
        } else {
            return new RestException(message + " with id " + id);
        }
    }

    public RestException(String message) {
        super(message);
    }
}
