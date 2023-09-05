package telran.community.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.CONFLICT)
public class CommunityExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 4213097092072398537L;
}
