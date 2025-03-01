package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.cibertec.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    
    public List <ProductoEntity> findByNuevoProducto(Integer estado);

    @Query(value = "SELECT * FROM producto WHERE nueproducto=?1 AND idcategoria=?2", nativeQuery = true)
    public List <ProductoEntity> findByNuevoProductoAndCategoria(Integer estado, Integer idCategoria);
    
}
