package user.userrestapi.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import java.util.List;

@RestControllerAdvice
public class ApplicationControllerAdvice {

     /*
        Validação de campos obrigatórios
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException  ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return new ApiErrors(messages);
    }

    /*
       Lançamento de excessão atraves do throws
    */
    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ApiErrors> handleCustomException(Exception ex, WebRequest request){
        ApiErrors apiErrors = new ApiErrors(ex.getMessage());
        return new ResponseEntity<>(apiErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
       Tratamento de campos com unicidade
    */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiErrors> handleUniqueException(Exception ex, WebRequest request){
        String message = ex.getCause().getCause().getLocalizedMessage();
        ApiErrors apiErrors = new ApiErrors(FormatExceptions.formatUniqueException(message));
        return new ResponseEntity<>(apiErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
