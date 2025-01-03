package com.javawebControlleAdiver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.api.ErroReponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
	    public ResponseEntity<Object> handleAritheticExceptionHandel(
	            ArithmeticException ex, WebRequest headers) {
    			
    	
    		ErroReponseDTO erroReponseDTO = new ErroReponseDTO();
    		erroReponseDTO.setError(ex.getMessage());
    		List<String> details = new ArrayList<>();
    		details.add("Số Nguyên Làm Sao Chia Hết Cho 0 Được!");
    		erroReponseDTO.setDateil(details);
	        return new ResponseEntity<>(erroReponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
