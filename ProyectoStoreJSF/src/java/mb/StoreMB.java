package mb;

import entity.CategoriaProductoEntities;
import entity.ProductoEntities;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ManagedBean
@RequestScoped
public class StoreMB {
    
    private ProductoEntities p = new ProductoEntities();
    
     public void crearProducto(ProductoEntities productoEntities){
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        em.getTransaction().begin();
        em.persist(productoEntities);
        em.getTransaction().commit();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Se guardo con exito..!");
        fc.addMessage(null, fm);
    }

    public static List<ProductoEntities> consultarPorNombre(String nombre){
        List<ProductoEntities> listaProducto = null;
        
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        listaProducto = em.createQuery("From ProductoEntities c Where c.nombre like :nombre", ProductoEntities.class)
                .setParameter("nombre", nombre + "%")
                .getResultList();
        for (ProductoEntities p : listaProducto ){
            p.getCodigo();
            p.getNombre();
            p.getStock();
            p.getPrecio();
            p.getCategoriaProductoEntities();
        }
        return listaProducto;
    }
    
    public void buscarPorNombre(){
        List<ProductoEntities> listaProducto = StoreMB.consultarPorNombre(p.getNombre());
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
    
    
    
}
