package CRUD_PRACTICE.demo.exceptionError;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message) {
        super(message);
    }
}
