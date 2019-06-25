/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.CategoriaProducto;
import entities.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

/**
 *
 * @author LENOVO
 */
public class ProductoDAO {
    public void insertar(Producto producto){
    Connection cnn = null;
        PreparedStatement pstm = null;
        String SQL=null;
        try{
            cnn = ConexionBD.getConnection();
            SQL = "INSERT INTO tb_producto VALUES(?,?,?,?,?)";
            pstm = cnn.prepareStatement(SQL);
            pstm.setString(1, producto.getCodigo());
            pstm.setString(2, producto.getNombre());
            pstm.setInt(3, producto.getStock());
            pstm.setDouble(4, producto.getPrecio());
            pstm.setInt(5, producto.getCategoriaProducto().getId());
            pstm.executeUpdate();
            System.out.println("insertar ok");
        }catch(Exception ex){
        System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
        }
    }
    public List<Producto> consultarPorNombre(String nombre){
        Connection cnn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        String SQL = null;        
        List<Producto> listaProducto = new ArrayList<Producto>();
        try{
            cnn = ConexionBD.getConnection();
            SQL = "{CALL usp_producto_consultar_por_nombre(?)}";            
            cstm = cnn.prepareCall(SQL);
            
            cstm.setString(1, nombre);
            
            rs = cstm.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setCodigo(rs.getString("pro_cod"));
                producto.setNombre(rs.getString("pro_nom"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setPrecio(rs.getDouble("pro_pre"));
                producto.setCategoriaProducto(
                        new CategoriaProducto(rs.getInt("cat_proid"),
                        rs.getString("cat_pronom")));
                
                listaProducto.add(producto);
            }            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(rs);
            ConexionBD.close(cstm);
            ConexionBD.close(cnn);
        }     
        return listaProducto;
    }
    
    public List<Producto> consultarPorCodigo(String codigo){
        Connection cnn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        String SQL = null;        
        List<Producto> listaProducto = new ArrayList<Producto>();
        try{
            cnn = ConexionBD.getConnection();
            SQL = "{CALL usp_producto_consultar_por_codigo(?)}";            
            cstm = cnn.prepareCall(SQL);
            
            cstm.setString(1, codigo);
            
            rs = cstm.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setCodigo(rs.getString("pro_cod"));
                producto.setNombre(rs.getString("pro_nom"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setPrecio(rs.getDouble("pro_pre"));
                producto.setCategoriaProducto(
                        new CategoriaProducto(rs.getInt("cat_proid"),
                        rs.getString("cat_pronom")));
                
                listaProducto.add(producto);
            }            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(rs);
            ConexionBD.close(cstm);
            ConexionBD.close(cnn);
        }     
        return listaProducto;
    }
    
    
    public void eliminar(String codigo){
        Connection cnn = null;
        PreparedStatement pstm = null;
        String SQL = null;        
        try{
            cnn = ConexionBD.getConnection();
            SQL = "DELETE FROM tb_producto WHERE pro_cod = ?";            
            pstm = cnn.prepareStatement(SQL);
            pstm.setString(1, codigo);
            pstm.executeUpdate();
            System.out.println("eliminar ok");
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
        }          
    }
    
    public void modificar(Producto producto){
        Connection cnn = null;
        PreparedStatement pstm = null;
        String SQL = null;        
        try{
            cnn = ConexionBD.getConnection();
            SQL = "UPDATE tb_producto SET pro_nom = ?, pro_stock = ?, pro_pre = ?, cat_proid = ? "
                    + " WHERE pro_cod = ? ";            
            
            pstm = cnn.prepareStatement(SQL);
            
            pstm.setString(1, producto.getNombre());
            pstm.setInt(2, producto.getStock());
            pstm.setDouble(3, producto.getPrecio());
            pstm.setInt(4, producto.getCategoriaProducto().getId());
            pstm.setString(5, producto.getCodigo());
            
            pstm.executeUpdate();
            System.out.println("modificar ok");
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
        }          
    }
}
