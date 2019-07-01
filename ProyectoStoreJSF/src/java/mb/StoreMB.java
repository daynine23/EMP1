package mb;

import entity.CategoriaProductoEntities;
import entity.ProductoEntities;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ManagedBean
@RequestScoped
public class StoreMB {
    
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
        listaProducto = em.createQuery("From Producto c Where c.nombre like :nombre", ProductoEntities.class)
                .setParameter("nombre", nombre + "%")
                .getResultList();
        
        return listaProducto;
    }
    
    public List<CategoriaProductoEntities> consultaCategoria () {
        List<CategoriaProductoEntities> listaCategoria = null;
        EntityManager em= Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        listaCategoria = em.createQuery("From CategoriaProductoEntities c", CategoriaProductoEntities.class)
                .setParameter("listaCategoria", listaCategoria)
                .getResultList();
        
        return listaCategoria;
    }
}
