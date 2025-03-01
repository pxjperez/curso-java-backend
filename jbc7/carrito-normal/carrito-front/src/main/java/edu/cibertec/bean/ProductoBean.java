package edu.cibertec.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoBean {
    private Integer idProducto;
    private String nombreProducto;
    private CategoriaBean categoria;
    private Double precioProducto;
    private Double precioAnteriorProducto;
    private Integer nuevoProducto;
    private String imagenProducto;
}
