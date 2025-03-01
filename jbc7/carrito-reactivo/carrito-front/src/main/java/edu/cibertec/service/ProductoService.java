package edu.cibertec.service;


import edu.cibertec.bean.ProductoBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    public Flux<ProductoBean> listarProductos();
    public Mono<ProductoBean> obtenerProductoPorId(Integer idProducto);
    public boolean registrarProducto(ProductoBean producto);
    public boolean actualizarProducto(ProductoBean producto);
    public boolean eliminarProducto(Integer idProducto);    
}
