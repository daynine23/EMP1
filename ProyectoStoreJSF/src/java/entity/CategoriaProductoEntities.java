
package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@RequestScoped
@Entity
@Table (name = "tb_categoria_producto")
public class CategoriaProductoEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cat_proid")
    private Integer id;
    @Column (name = "cat_pronom")
    private String nombre;

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
