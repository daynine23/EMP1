/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.CategoriaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

/**
 *
 * @author LENOVO
 */
public class CategoriaProductoDAO {
    public void insertar( CategoriaProducto categoriaProducto){
        Connection cnn = null;
        PreparedStatement pstm = null;
        String SQL=null;
        try{
            cnn = ConexionBD.getConnection();
            SQL = "INSERT INTO tb_categoria_producto (cat_pronom) VALUES(?)";
            pstm = cnn.prepareStatement(SQL);
            pstm.setString(1, categoriaProducto.getNombre());
            pstm.executeUpdate();
            System.out.println("insertar ok");
        }catch(Exception ex){
        System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
        }
    }
    
    public List<CategoriaProducto> consultarTodo(){
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String SQL=null;
        List<CategoriaProducto> listaCategoriaProducto = new ArrayList<CategoriaProducto>();
        try{
            cnn = ConexionBD.getConnection();
            SQL = "SELECT * FROM tb_categoria_producto";
            pstm = cnn.prepareStatement(SQL);
            rs  = pstm.executeQuery();
            while(rs.next()){
                CategoriaProducto categoriaProducto = new CategoriaProducto();
                categoriaProducto.setId(rs.getInt("cat_proid"));
                categoriaProducto.setNombre(rs.getString("cat_pronom"));
                listaCategoriaProducto.add(categoriaProducto);
            }
        }catch(Exception ex){
        System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(rs);
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
        }
        return listaCategoriaProducto;
    }
    
    public void actualizar( CategoriaProducto categoriaProducto){
        //Conexion BD
    }
    
    public void eliminar( CategoriaProducto categoriaProducto){
        //Conexion BD
    }
    
    public void consultar( CategoriaProducto categoriaProducto){
        //Conexion BD
    }
}
