/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CategoriaProductoDAO;
import dao.ProductoDAO;
import entities.CategoriaProducto;
import entities.Producto;
import java.util.List;


public class ProductoServices {
    
    public void insertar(Producto producto){        
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.insertar(producto);        
    }
    
    public void modificar(Producto producto){        
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.modificar(producto);        
    }
    
    public List<CategoriaProducto> consultarTodo(){
        CategoriaProductoDAO categoriaProductoDAO = new CategoriaProductoDAO();
        return categoriaProductoDAO.consultarTodo();
    }
    
    public List<Producto> consultarPorNombre(String nombre){
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.consultarPorNombre(nombre);
    }
    
    public List<Producto> consultarPorCodigo(String codigo){
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.consultarPorCodigo(codigo);
    }
    
    public void eliminar(String codigo) {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.eliminar(codigo);
    }
}
