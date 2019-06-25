
package entities;

public class CategoriaProducto {
        private Integer id;
        private String nombre;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
}
