package edu.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.ProductoEntity;

@Repository
public interface ProductoRepository  extends JpaRepository<ProductoEntity,Integer>{
    public List<ProductoEntity> findByNueProducto(int estado);

    @Query(value="SELECT * FROM producto WHERE nueproducto=? AND idcategoria=?", nativeQuery = true)
    public List<ProductoEntity> findByNueProductoAndCategoria(int estado, int categoria);
}
