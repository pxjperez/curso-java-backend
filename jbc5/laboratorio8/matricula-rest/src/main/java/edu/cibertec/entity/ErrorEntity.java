package edu.cibertec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorEntity {
    private String estatus;
    private String mensaje;
    private String error;
}
