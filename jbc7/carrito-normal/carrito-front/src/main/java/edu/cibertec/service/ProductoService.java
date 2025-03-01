package edu.cibertec.service;

import java.util.List;

import edu.cibertec.bean.ProductoBean;

public interface ProductoService {
    public List<ProductoBean> listarProductos();
    public ProductoBean obtenerProductoPorId(Integer idProducto);
    public boolean registrarProducto(ProductoBean producto);
    public boolean actualizarProducto(ProductoBean producto);
    public boolean eliminarProducto(Integer idProducto);    
}
