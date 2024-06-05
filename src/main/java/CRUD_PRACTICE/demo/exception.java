package CRUD_PRACTICE.demo;

import CRUD_PRACTICE.demo.service.DBUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class exception {
    @ExceptionHandler(DBUserService.DuplicateUserException.class)
    public ResponseEntity<String> handleDuplicateUserException(DBUserService.DuplicateUserException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
