package main;

import entity.CategoriaCliente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Demo01 {

    public static void main(String[] args) {
        
        CategoriaCliente categoriaCliente = new CategoriaCliente();
        categoriaCliente.setNombre("DIAMANTE");
        
        crearCategoriaCliente(categoriaCliente);
        System.out.println("OK registro insertadpo");
        
    }
    
    public static void crearCategoriaCliente(CategoriaCliente categoriaCliente){
        EntityManager em= Persistence.createEntityManagerFactory("VentasPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(categoriaCliente);
        em.getTransaction().commit();
    }
}
