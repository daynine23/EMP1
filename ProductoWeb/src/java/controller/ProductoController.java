/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductoDAO;
import entities.CategoriaProducto;
import entities.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProductoServices;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {
        
   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        
        String accion=request.getParameter("accion");
        
        switch(accion){
            case"abrirNuevoProducto":
                abrirNuevoProducto(request,response);
                break;
            case "insertar":
                insertar(request,response);
                break;
            case"consultarPorNomb":
                consultarPorNomb(request,response);
                break;
            case"abrirConsultarPorNombre":
                abrirConsultarPorNombre(request,response);
                break;
            case"modificarProducto":
                modificarProducto(request,response);
                break;
            case"eliminarProducto":
                eliminarProducto(request,response);
                break;
        }  
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoServices productoServices = new ProductoServices();
        
        List<CategoriaProducto> listaCategoriaProducto = productoServices.consultarTodo(); 
        request.setAttribute("categorias", listaCategoriaProducto);// atributo del select , nombre de la lista
        request.getRequestDispatcher("NuevoProducto.jsp").forward(request, response);

        
        Producto producto =new Producto();
        producto.setCodigo(request.getParameter("txtCodigo"));
        producto.setNombre(request.getParameter("txtNombre"));
        producto.setStock(Integer.parseInt(request.getParameter("txtStock")));
        producto.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        
        CategoriaProducto categoriaProducto=new CategoriaProducto();
        categoriaProducto.setId(Integer.parseInt(request.getParameter("cboCategoriaProducto")));
        producto.setCategoriaProducto(categoriaProducto);
        
        productoServices.insertar(producto);
        
        
       
    }
    protected void consultarPorNomb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("txtConsultarNombre");
        ProductoServices productoServices = new ProductoServices();
        
        List<Producto> listaProducto=productoServices.consultarPorNombre(nombre);
        
        //request.setAttribute("nombre", nombre);
        request.setAttribute("listaProducto", listaProducto);
        
        //abrirConsultarPorNombre(request, response);
        request.getRequestDispatcher("resultado_consulta_producto.jsp")
                .forward(request, response);
    }
    
    protected void modificarProducto (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codTemp = request.getParameter("codigo");
        ProductoServices productoServices = new ProductoServices();
        request.setAttribute("getProductoById", productoServices.consultarPorCodigo(codTemp));
        List<CategoriaProducto> listaCategoriaProducto = productoServices.consultarTodo(); 
        request.setAttribute("categorias", listaCategoriaProducto);
        RequestDispatcher rd = request.getRequestDispatcher("EditProducto.jsp");
        rd.forward(request, response);
    }
    
    
    protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codTemp = request.getParameter("codigo");
        ProductoServices productoServices = new ProductoServices();
        productoServices.eliminar(codTemp);
        response.sendRedirect("Producto.jsp");

    }
    
    
    protected void abrirConsultarPorNombre(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Producto.jsp").forward(request, response);
       
    }
    
    protected void abrirModificarPorCodigo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("EditProducto.jsp").forward(request, response);
       
    }
    
    protected void abrirNuevoProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TRAER DATOS CATEGORIA PRODUCTO EN EL OBJETO LISTA/////////////////////////////////
        ProductoServices productoServices = new ProductoServices();
        
        List<CategoriaProducto> listaCategoriaProducto = productoServices.consultarTodo(); 
        request.setAttribute("categorias", listaCategoriaProducto);
        // en que JSP esta el combobox
        request.getRequestDispatcher("NuevoProducto.jsp").forward(request, response);
       
    }
}
