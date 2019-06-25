
<%@page import="java.util.List"%>
<%@page import="entities.CategoriaProducto"%>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>Nuevo Producto </title>
</head>

  <body>
    <div class="jumbotron text-center">
        <center>
    <h1>Sistema Store</h1>
    <h2>Producto Nuevo</h2>
        </center>
    </div>  
	      
	 
    <div class="d-flex justify-content-around">
      
        <div class="p-2">
        <a href="#" class="btn btn-info" role="button">Nueva Categoria Producto</a>
    	  </div>
        
        <div class="p-2">
        <a href="ProductoController?accion=abrirConsultarPorNombre" class="btn btn-info" role="button">Productos</a>
    	  </div>
        
      
    </div>
	 <center>
   <br>

  

   <form class="form-horizontal" action="ProductoController" method="post"> <%-- IMPORTANTE TENER ESTO EN EL FORM--%>
      <input type="hidden" value="insertar" name="accion" >
   
    <div class="form-group form-group-lg">
      <label for="txtCodigo" class="col-sm-2 control-label" for="lg">Codigo</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" id="lg" id="txtCodigo" name="txtCodigo">
      </div>
    </div>

    <div class="form-group form-group-lg">
      <label for="txtNombre" class="col-sm-2 control-label" for="lg">Nombre</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" id="lg" id="txtNombre" name="txtNombre">
      </div>
    </div>

    <div class="form-group form-group-lg">
      <label for="txtStock" class="col-sm-2 control-label" for="lg">Stock</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" id="lg" id="txtStock" name="txtStock">
      </div>
    </div>

    <div class="form-group form-group-lg">
      <label for="txtPrecio" class="col-sm-2 control-label" for="lg">Precio</label>
      <div class="col-sm-4">
        <input class="form-control" type="text" id="lg" id="txtPrecio" name="txtPrecio">
      </div>
    </div>
 
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="lg" for="cboCategoriaProducto" >Categoria</label>
        <div class="col-sm-4">   
            
        <select class="form-control" id="cboCategoriaProducto" name="cboCategoriaProducto">
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
  
  	</center>  






    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
