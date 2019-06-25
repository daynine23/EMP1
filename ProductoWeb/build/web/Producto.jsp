<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html">
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Consultar Producto</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
      $("#btnConsultar").click(function(){
         var nombre = $("#txtConsultarNombre").val();
          $.ajax({
                method: "POST",
                url: "ProductoController",
                data: {accion: "consultarPorNomb", "txtConsultarNombre": nombre},
                success: function(result){
                $("#resultado").html(result);
                 }
            });
         
      });
    });
    </script>
    <script type="text/javascript" >

      function nuevo(){
          var frm = document.getElementById("frmConsultar");
          var accion = document.getElementById("accion");
          accion.value = "abrirNuevoCliente";
          frm.submit();
      }
      
      function consultar(){
          var frm = document.getElementById("frmConsultar");
          var accion = document.getElementById("accion");
          accion.value = "consultarPorNomb";
          frm.submit();
      }
      
      function modificar(){
          var frm = document.getElementById("frmConsultar");
          var accion = document.getElementById("accion");
          accion.value = "modificarProducto";
          frm.submit();
      }
      function eliminar(){
          var frm = document.getElementById("frmConsultar");
          var accion = document.getElementById("accion");
          accion.value = "eliminarProducto";
          frm.submit();
      }
      
  </script>
  </head>
  <body>
    <div class="jumbotron text-center">
    <center>
    <h1>Sistema Store</h1>
    <h2>Consultar Producto</h2>
    </center>
    </div>

     <!-- FORMULARIO DE CONSULTA -->
 
      <form method="post" id="frmConsultar" name="frmConsultar" action="ProductoController">
          <center>
     <input type="hidden" id="accion" name="accion" value="" />    
     <label for="">Nombre: </label>
     <input type="text" name="txtConsultarNombre" id="txtConsultarNombre" value="${nombre}" />    
 
     <input type="button" id="btnConsultar" class="btn btn-primary btn-md" value="Consultar" />

        <a href="ProductoController?accion=abrirNuevoProducto" class="btn btn-success" role="button">Nuevo Producto</a>

        <a href="cabecera.jsp" class="btn btn-info" role="button">Nueva Categoria Producto</a>
         
          </center>
<!-- TABLA-->
  <div id="resultado" class="container">
           <table class="table">
            <thead>
              <tr>
              <th scope="col">Codigo</th>
              <th scope="col">Nombre</th>
              <th scope="col">Stock</th>
              <th scope="col">Precio</th>
              <th scope="col">Categoria</th>
              </tr>
            </thead>
           </table>                                                                             
  
</div>

        </form>
	
  </body>
</html>
