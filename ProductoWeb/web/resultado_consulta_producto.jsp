<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <tbody>


   <c:forEach var="producto" items="${listaProducto}">
    <tr>
      <th scope="row">${producto.codigo}</th>
      <td>${producto.nombre}</td>
      <td>${producto.stock}</td>
      <td>${producto.precio}</td>
      <td>${producto.categoriaProducto.nombre}</td>
      <td>
          <button onclick="modificar()" class="btn btn-warning" name="codigo" value="${producto.codigo}">Editar</button>
          <button onclick="eliminar()" class="btn btn-danger" name="codigo" value="${producto.codigo}">Eliminar</button>
      </td>
    </tr>
   </c:forEach>
  </tbody>
  </table>