<%-- 
    Document   : ManagerEditProducto
    Created on : 17-jun-2019, 22:08:02
    Author     : LENOVO
--%>

<%@page import="entities.Producto"%>
<%@page import="services.ProductoServices"%>
<%@page import="entities.CategoriaProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        
        ProductoServices productoServices = new ProductoServices();
        Producto producto =new Producto();
        producto.setCodigo(request.getParameter("txtCodigo"));
        producto.setNombre(request.getParameter("txtNombre"));
        producto.setStock(Integer.parseInt(request.getParameter("txtStock")));
        producto.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        
        CategoriaProducto categoriaProducto=new CategoriaProducto();
        categoriaProducto.setId(Integer.parseInt(request.getParameter("cboCategoriaProducto")));
        producto.setCategoriaProducto(categoriaProducto);
        
        
        productoServices.modificar(producto);
            
        response.sendRedirect("ProductoController?accion=abrirConsultarPorNombre");
         %>
    </body>
</html>
