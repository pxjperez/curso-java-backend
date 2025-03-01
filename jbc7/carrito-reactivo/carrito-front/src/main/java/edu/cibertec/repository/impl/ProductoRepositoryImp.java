package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import edu.cibertec.bean.ProductoBean;
import edu.cibertec.repository.ProductoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductoRepositoryImp implements ProductoRepository {


    @Value("${carrito.back}")
    private String carritoBack;
    
    private RestTemplate restTemplate= new RestTemplate();
    
    @Override
    public Flux<ProductoBean> listarProductos() {
        Flux<ProductoBean> bloque1 = WebClient.create(carritoBack + "/api/v1/productos").get().retrieve().bodyToFlux(ProductoBean.class);
        Flux<ProductoBean> bloque2 = WebClient.create(carritoBack + "/api/v1/productos").get().retrieve().bodyToFlux(ProductoBean.class);
        Flux<ProductoBean> bloque3 = WebClient.create(carritoBack + "/api/v1/productos").get().retrieve().bodyToFlux(ProductoBean.class);
        return Flux.merge(bloque1, bloque2, bloque3);
    }

    @Override
    public Mono<ProductoBean> obtenerProductoPorId(Integer idProducto) {
        return WebClient.create(carritoBack + "/api/v1/productos/" + idProducto).get().retrieve().bodyToMono(ProductoBean.class);
    }

    @Override
    public boolean registrarProducto(ProductoBean producto) {
        ProductoBean productoRegistrado = restTemplate.postForObject(carritoBack + "/api/v1/productos", producto, ProductoBean.class);
        return productoRegistrado != null;
    }

    @Override
    public boolean actualizarProducto(ProductoBean producto) {
        try {
            restTemplate.put(carritoBack + "/api/v1/productos/" + producto.getIdProducto(), producto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(Integer idProducto) {
        try {
            restTemplate.delete(carritoBack + "/api/v1/productos/" + idProducto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }   
    
}
