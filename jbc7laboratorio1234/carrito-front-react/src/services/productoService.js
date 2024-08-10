import axios from 'axios';
const url_api="http://localhost:8081/api/v1";

export const crearProducto = async(productoData)=>{
    try{
        const response = await axios.post(url_api+"/productos",productoData);
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio crear producto:', exception);
    }
}

export const actualizarProducto = async(idProducto, productoData)=>{
    try{
        const response = await axios.put(url_api+"/productos/"+idProducto,productoData);
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio actualizar producto:', exception);
    }
}

export const eliminarProducto = async(idProducto)=>{
    try{
        const response = await axios.delete(url_api+"/productos/"+idProducto);
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio eliminar producto:', exception);
    }
}

export const listarProducto = async()=>{
    try{
        
        const response = await axios.get(url_api+"/productos");
        console.log(JSON.stringify(response.data));
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio listar productos:', exception);
    }
}

export const obtenerProducto = async(idProducto)=>{
    try{
        const response = await axios.get(url_api+"/productos/"+idProducto);
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio obtener producto:', exception);
    }
}

export const listarProductoActivos = async()=>{
    try{
        const response = await axios.get(url_api+"/productos");
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio listar productos activos:', exception);
    }
}

export const listarProductoDesactivos = async()=>{
    try{
        const response = await axios.get(url_api+"/productos");
        return response.data;
    }catch(exception){
        console.error('Error al consumir el servicio listar productos desactivos:', exception);
    }
}
