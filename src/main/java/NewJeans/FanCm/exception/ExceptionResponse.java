package NewJeans.FanCm.exception;

import lombok.Getter;

@Getter
public class ExceptionResponse extends RuntimeException {
    private final int status;
    private final String code;

    public ExceptionResponse(int status, String message, String code){
        super(message);
        this.code = code;
        this.status = status;
    }
}