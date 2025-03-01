package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.bean.ProductoBean;
import edu.cibertec.repository.ProductoRepository;

@Repository
public class ProductoRepositoryImp implements ProductoRepository {


    @Value("${carrito.back}")
    private String carritoBack;

    
    private RestTemplate restTemplate= new RestTemplate();
    
    @Override
    public List<ProductoBean> listarProductos() {
        return restTemplate.getForObject(carritoBack + "/api/v1/productos", List.class);
    }

    @Override
    public ProductoBean obtenerProductoPorId(Integer idProducto) {
        return restTemplate.getForObject(carritoBack + "/api/v1/productos/" + idProducto, ProductoBean.class);
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
