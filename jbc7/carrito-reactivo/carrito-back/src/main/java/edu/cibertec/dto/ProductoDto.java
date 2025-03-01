package edu.cibertec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaDto categoria;
    private Double precioProducto;
    private Double precioAnteriorProducto;
    private Integer nuevoProducto;
    private String imagenProducto;
}
