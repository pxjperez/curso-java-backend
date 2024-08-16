package edu.cibertec.apimatricula.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorEntity {
    private String status;
    private String error;
    private String mensage;
}
