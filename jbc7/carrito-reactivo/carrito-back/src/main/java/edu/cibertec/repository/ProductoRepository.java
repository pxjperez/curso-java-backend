package edu.cibertec.repository;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import edu.cibertec.entity.ProductoEntity;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<ProductoEntity, Integer> {
    
    public Flux <ProductoEntity> findByNuevoProducto(Integer estado);

    @Query(value = "SELECT * FROM producto WHERE nueproducto=?1 AND idcategoria=?2")
    public Flux <ProductoEntity> findByNuevoProductoAndCategoria(Integer estado, Integer idCategoria);
    
}
