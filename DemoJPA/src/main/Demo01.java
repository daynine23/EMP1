package main;

import entity.CategoriaCliente;
import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Demo01 {

    public static void main(String[] args) {
        
       /* CategoriaCliente categoriaCliente = new CategoriaCliente();
        categoriaCliente.setNombre("DIAMANTE");
        
        crearCategoriaCliente(categoriaCliente);
        System.out.println("OK registro insertadpo");*/
        
        /*Cliente cliente = new Cliente();
        cliente.setDocumento("71473214");
        cliente.setNombre("Andres Vera");
        cliente.setDireccion("Av. El Polo 78");
        
        CategoriaCliente categoriaCliente = new CategoriaCliente();
        categoriaCliente.setId(1);
        
        cliente.setCategoriaCliente(categoriaCliente);
        
        crearCliente(cliente);
        
        System.out.println("Ok registro insertado");*/
        
        List<Cliente> listaCliente  = consultarPorNombre("A");
        
        for(Cliente cliente:listaCliente){
            System.out.println(cliente.getDocumento() + " - " +
                    cliente.getNombre() + " - " +
                    cliente.getDireccion() + " - " +
                    cliente.getCategoriaCliente().getNombre());
        }
    }
    
    public static void crearCategoriaCliente(CategoriaCliente categoriaCliente){
        EntityManager em= Persistence.createEntityManagerFactory("VentasPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(categoriaCliente);
        em.getTransaction().commit();
    }
    
    public static void crearCliente(Cliente cliente){
        EntityManager em= Persistence.createEntityManagerFactory("VentasPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public static List<Cliente> consultarPorNombre(String nombre){
        List<Cliente> listaCliente = null;
        
        EntityManager em= Persistence.createEntityManagerFactory("VentasPU").createEntityManager();
        listaCliente = em.createQuery("From Cliente c Where c.nombre like :nombre", Cliente.class)
                .setParameter("nombre", nombre + "%")
                .getResultList();
        
        return listaCliente;
    }
}
