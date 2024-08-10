package edu.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @Column(name = "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer idProducto;    
    @Column(name = "nomproducto")
    private String nomProducto;
    @OneToOne
    @JoinColumn(name = "idcategoria",referencedColumnName = "idcategoria")
    private CategoriaEntity categoria;
    @Column(name = "preproducto")
    private Double preProducto;
    @Column(name = "antpreproducto")
    private Double antPreProducto;
    @Column(name = "nueproducto")
    private Integer nueProducto;
    @Column(name = "imgproducto")
    private String imgProducto;
}
