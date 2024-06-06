package CRUD_PRACTICE.demo.exceptionError;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg){
        super(msg);
    }
}
