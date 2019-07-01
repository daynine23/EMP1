package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ManagedBean
@RequestScoped
@Entity
@Table (name = "tb_producto")
public class ProductoEntities {
    @Id
    @Column(name = "pro_cod")
    private String codigo;
    @Column(name = "pro_nom")
    private String nombre;
    @Column(name = "pro_stock")
    private Integer stock;
    @Column(name = "pro_pre")
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "cat_proid")
    private CategoriaProductoEntities categoriaProductoEntities;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public CategoriaProductoEntities getCategoriaProductoEntities() {
        return categoriaProductoEntities;
    }

    public void setCategoriaProductoEntities(CategoriaProductoEntities categoriaProductoEntities) {
        this.categoriaProductoEntities = categoriaProductoEntities;
    }
    
    
}
