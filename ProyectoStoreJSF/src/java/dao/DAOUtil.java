
package dao;

import entity.CategoriaProductoEntities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConexionBD;


public class DAOUtil {
    
    public CategoriaProductoEntities GetCat (int id){
        CategoriaProductoEntities c = new CategoriaProductoEntities();
        ResultSet rs = null;
        Connection cnn = null;
        PreparedStatement pstm = null;
        String SQL = null;
        try{
            cnn = ConexionBD.getConnection();
            SQL = "SELECT * FROM store.tb_categoria_producto WHERE cat_proid = " + id;            
            pstm = cnn.prepareStatement(SQL);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("cat_proid"));
                c.setNombre(rs.getString("cat_pronom"));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }finally{
            ConexionBD.close(pstm);
            ConexionBD.close(cnn);
    }
        return c;
        
}
    }
