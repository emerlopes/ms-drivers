package com.techchallenge.msdrivers.application.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            }
        });

        Map<String, String> response = new HashMap<>();
        response.put("error", "Validação falhou");
        response.put("message", "Campos inválidos no DTO");
        response.put("errors", errors.toString());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleUUIDFormatException(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof IllegalArgumentException && cause.getMessage().contains("UUID")) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Formato de UUID inválido");
            response.put("message", "UUID deve ser representado pelo padrão de 36 caracteres");
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.status(500).body(Map.of("error", "Erro na leitura da mensagem HTTP"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = ex.getMostSpecificCause().getMessage();

        if (message != null && message.contains("NULL not allowed for column")) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Violação de Integridade de Dados");
            response.put("message", "externalId nao encontrado " + message);
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.status(500).body(Map.of("error", "Erro de Integridade de Dados", "message", "Erro desconhecido de integridade de dados"));
    }
}