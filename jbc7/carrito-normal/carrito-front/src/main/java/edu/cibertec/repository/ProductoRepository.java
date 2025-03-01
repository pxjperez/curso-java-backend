package edu.cibertec.repository;

import java.util.List;

import edu.cibertec.bean.ProductoBean;

public interface ProductoRepository{
    public List<ProductoBean> listarProductos();
    public ProductoBean obtenerProductoPorId(Integer idProducto);
    public boolean registrarProducto(ProductoBean producto);
    public boolean actualizarProducto(ProductoBean producto);
    public boolean eliminarProducto(Integer idProducto);
}
