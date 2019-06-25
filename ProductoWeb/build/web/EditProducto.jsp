<%-- 
    Document   : EditProducto
    Created on : 15-jun-2019, 20:03:53
    Author     : LENOVO
--%>

<%@page import="java.util.List"%>
<%@page import="entities.CategoriaProducto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Editar Producto</title>
    </head>
    <body>
        <center>
   <br>
   <h2 class="col-sm-4">Editar Producto</h2>
  
   <c:forEach items="${getProductoById}" var="producto">
   <form class="form-horizontal" action="ManagerEditProducto.jsp" method="post"> <%-- IMPORTANTE TENER ESTO EN EL FORM--%>
      <input type="hidden" value="${producto.codigo}" name="txtCodigo">
   
    <div class="form-group form-group-lg">
      <label for="txtNombre" class="col-sm-2 control-label" for="lg">Nombre</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" value="${producto.nombre}" id="lg" id="txtNombre" name="txtNombre">
      </div>
    </div>

    <div class="form-group form-group-lg">
      <label for="txtStock" class="col-sm-2 control-label" for="lg">Stock</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" value="${producto.stock}" id="lg" id="txtStock" name="txtStock">
      </div>
    </div>

    <div class="form-group form-group-lg">
      <label for="txtPrecio" class="col-sm-2 control-label" for="lg">Precio</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" value="${producto.precio}" id="lg" id="txtPrecio" name="txtPrecio">
      </div>
    </div>
 
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="lg" for="cboCategoriaProducto" >Categoria</label>
        <div class="col-sm-4">   
            
        <select class="form-control" id="cboCategoriaProducto" name="cboCategoriaProducto">
        <option value="${producto.categoriaProducto.id}">${producto.categoriaProducto.nombre}</option>
        <% List<CategoriaProducto> listaCategoriaProducto=(List<CategoriaProducto>)request.getAttribute("categorias");
        if(listaCategoriaProducto!=null)//ESTO TMBN ES IMPORTANTE 
        for(CategoriaProducto categoria:listaCategoriaProducto){%>
        <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
        <%} %>
        </select>
        
        </div>
    </div>
    <br> 
    
    <div class="col-sm-4">
    <button type="submit" class="btn btn-primary btn-lg">Guardar</button>
    </div>
  
  </form>
   </c:forEach>
  	</center>
    </body>
</html>
