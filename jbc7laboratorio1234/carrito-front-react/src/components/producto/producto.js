import React, { useState, useEffect } from 'react';
import './producto.css';
import {
  crearProducto,
  actualizarProducto,
  eliminarProducto,
  listarProducto,
  obtenerProducto,
  listarProductoActivos,
  listarProductoDesactivos
} from '../../services/productoService';

function Producto() {
/** INICIO DE LA LOGICA DEL COMPONENTE */ 
  //Primer odefinos las variables que voy a utilizar tanto de la lista como del objeto
  const [productos, setProductos] = useState([]);
  const [nomProducto, setNomProducto] = useState('');
  const [preProducto, setPreProducto] = useState('');
  const [productoActualizadoId, setProductoActualizadoId] = useState(null);
  const [isChecked, setIsChecked] = useState(false);


  //Crear variable que obtiene el listado de datos 
  const listarProductos = async () => {
    const response = await listarProductoActivos();   
    setProductos(response);
  };

  //Crear variable para limpiar datos 
  const limpiarFormulario = () => {
    setNomProducto('');
    setPreProducto('');
  };

  //Invocar la carga de datos al momento de cargar la pagina
  useEffect(() => {
    listarProductos();
  }, []);

  //Acciones (Helder)  
  const accionEnviar = async (e) => {
    e.preventDefault();    
    if (productoActualizadoId) {
      await actualizarProducto(productoActualizadoId, {
                                                        nomProducto,
                                                        preProducto,
                                                      });      
      setProductoActualizadoId(null); // Restablecer el ID de producto actualizado
     }else {
      const nuevoProducto = {
        nomProducto,
        preProducto,
      };
      
      await crearProducto(nuevoProducto);
    }

    listarProductos();
    limpiarFormulario();
  };

  

  const accionSeleccionar = (id) => {
    const productoEditado = productos.find((elemento) => elemento.id === id);
    if (productoEditado) {
      setNomProducto(productoEditado.nomProducto);
      setPreProducto(productoEditado.preProducto);
      setProductoActualizadoId(id);
    }
  };

  const accionEliminar = async (id) => {
    await eliminarProducto(id);
    listarProductos();
  };
  
  const accionMostrarEliminados = async (e) => {
    setIsChecked(e.target.checked); // Actualiza el estado cuando el campo de verificación cambia
    let response =listarProducto();
    if (isChecked) {
      response = await listarProductoActivos();
    }else{
       response = await listarProductoDesactivos();
    }    
    setProductos(response);
  };
/** FIN DE LA LOGICA DEL COMPONENTE */ 

  //La cracion del componente
  return (
    <div className="row">
      <div className="row">
        <h2>CRUD de Productos</h2>
        <form onSubmit={accionEnviar} className="form-control">
          <div className="col">
            <label className="form-label">NOMBRE</label>
            <input
              className="form-control"
              type="text"
              placeholder="Nombre"
              value={nomProducto}
              onChange={(e) => setNomProducto(e.target.value)}
            />
            <br></br>
          </div> 
          <div className="col">
            <label className="form-label">PRECIO</label>
            <input
              className="form-control"
              type="number"
              placeholder="Precio"
              value={preProducto}
              onChange={(e) => setPreProducto(e.target.value)}
            />
            <br></br>
          </div> 
          <div className="col">
            <button className="btn btn-primary" type="submit">
              {productoActualizadoId ? 'Actualizar Producto' : 'Crear Producto'}
            </button>
            <br></br>
          </div>
        </form>
      </div>
      <div className="row">
        <br></br>
        <h3>Lista de Productos</h3>
        <br></br>
        <table>
          <thead>
            <tr>
              <td className="tamanioTD"><label className="form-label">MOSTRAR ELIMINADOS</label></td>
              <td>
                  <input
                    className="form-check-input"
                    type="checkbox"  // Usamos type="checkbox" para crear un campo de verificación
                    checked={isChecked}  // Asignamos el estado al atributo "checked" del campo
                    onChange={accionMostrarEliminados} // Manejador para el cambio en el campo de verificación
                  />
              </td>
            </tr>
          </thead>
        </table>
        <table className='table table-bordered'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>PRECIO</th>
                </tr>
            </thead>
            <tbody>
                {
                  
                  Array.isArray(productos) && productos.map((elemento) => (
                    <tr key={elemento.idProducto}>
                      <td>{elemento.idProducto}</td>
                      <td>{elemento.nomProducto}</td>
                      <td>{elemento.preProducto.toFixed(2)}</td>
                    </tr>
                  ))        
                }
            </tbody>
        </table>
      </div>
    </div>
  );
}


export default Producto;
