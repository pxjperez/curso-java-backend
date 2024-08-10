package edu.cibertec.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Integer idProducto;    
    private String nomProducto;
    private CategoriaDTO categoria;
    private Double preProducto;
    private Double antPreProducto;
    private Integer nueProducto;
    private String imgProducto;
}
