package telran.community.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import telran.community.dto.exceptions.CommunityExistsException;
import telran.community.dto.exceptions.ExceptionDto;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CommunityExistsException.class)
    public ResponseEntity<Object> handleProfileExistsException(CommunityExistsException ex) {
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Bad Request");
        exceptionDto.setMessage("Community exists.");
        exceptionDto.setPath("/community/*");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
}
