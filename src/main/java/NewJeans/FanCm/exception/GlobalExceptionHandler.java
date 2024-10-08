package NewJeans.FanCm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //BAD_REQUEST
    @ExceptionHandler(ExceptionResponse.class)
    public ResponseEntity<ErrorResponse> handleunexistException(ExceptionResponse ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(ex.getStatus())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.valueOf(ex.getStatus())).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        // 예외 스택 트레이스 출력
        ex.printStackTrace();

        // 에러 응답 객체 생성
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(500)
                .code("SERVER_ERROR")
                .message("서버 오류")
                .build();

        // 500 상태 코드와 함께 응답 반환
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
