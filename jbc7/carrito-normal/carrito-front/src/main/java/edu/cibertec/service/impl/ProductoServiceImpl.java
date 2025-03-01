package edu.cibertec.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.bean.ProductoBean;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoBean> listarProductos() {
        List<ProductoBean> listaProductos = new ArrayList<>();
        listaProductos.addAll(productoRepository.listarProductos());
        listaProductos.addAll(productoRepository.listarProductos());
        listaProductos.addAll(productoRepository.listarProductos());
        return listaProductos;
    }

    @Override
    public ProductoBean obtenerProductoPorId(Integer idProducto) {
        return productoRepository.obtenerProductoPorId(idProducto);
    }

    @Override
    public boolean registrarProducto(ProductoBean producto) {
        return productoRepository.registrarProducto(producto);
    }

    @Override
    public boolean actualizarProducto(ProductoBean producto) {
        return productoRepository.actualizarProducto(producto);
    }

    @Override
    public boolean eliminarProducto(Integer idProducto) {
        return productoRepository.eliminarProducto(idProducto);
    }
    
    
}
