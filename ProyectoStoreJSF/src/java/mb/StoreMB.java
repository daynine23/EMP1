package mb;

import dao.DAOUtil;
import entity.CategoriaProductoEntities;
import entity.ProductoEntities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import util.ConexionBD;

@ManagedBean
@RequestScoped
public class StoreMB {
    
    private ProductoEntities p = new ProductoEntities();
    
    private CategoriaProductoEntities cat = new CategoriaProductoEntities();
    
     public void crearProducto(ProductoEntities productoEntities){
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        em.getTransaction().begin();
        em.persist(productoEntities);
        em.getTransaction().commit();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Se guardo con exito..!");
        fc.addMessage(null, fm);
    }

    public List<ProductoEntities> consultarPorNombre(String nombre){
        List<ProductoEntities> listaProducto = null;
        
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        listaProducto = em.createQuery("From ProductoEntities c Where c.nombre like :nombre", ProductoEntities.class)
                .setParameter("nombre", nombre + "%")
                .getResultList();
        
        return listaProducto;
    }
    
    public void traerProductos() {
        List<ProductoEntities> listaProducto  = consultarPorNombre(p.getNombre());
        for (ProductoEntities p : listaProducto ){
            p.getCodigo();
            p.getNombre();
            p.getStock();
            p.getPrecio();
            p.getCategoriaProductoEntities();
        }
    }
    
    public List<CategoriaProductoEntities> GetCat (int id){
        List<CategoriaProductoEntities> listaCategoria = null;
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        listaCategoria = em.createQuery("From CategoriaProductoEntities c Where c.id like :id", CategoriaProductoEntities.class)
                .setParameter("id", id + "%")
                .getResultList();
        for (CategoriaProductoEntities cat : listaCategoria ){
            cat.getId();
            cat.getNombre();
        }
        return listaCategoria;
        
}
    
   
    
    
    public List<CategoriaProductoEntities> consultaCategoria () {
        List<CategoriaProductoEntities> listaCategoria = null;
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        listaCategoria = em.createQuery("From CategoriaProductoEntities c", CategoriaProductoEntities.class)
                .setParameter("listaCategoria", listaCategoria)
                .getResultList();
        
        return listaCategoria;
    }

    public ProductoEntities getP() {
        return p;
    }

    public void setP(ProductoEntities p) {
        this.p = p;
    }

    public CategoriaProductoEntities getCat() {
        return cat;
    }

    public void setCat(CategoriaProductoEntities cat) {
        this.cat = cat;
    }
    
    
    
}
