
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class conexion {
    Connection miConexion;
    PreparedStatement ps;
    ResultSet rs;
    public conexion(){
        String ruta = "jdbc:mysql://localhost:3306/imperio_galáctico"; //Ruta de la base de datos local
        String usuario = "root"; //Usuario de la base de datos
        String password = "root";//Contraseña del usuario de la base de datos
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Crear la conexion
            miConexion = DriverManager.getConnection(ruta, usuario, password);                
        }catch(Exception ex){
            System.out.print("Problema de conexion");
            ex.printStackTrace();
        }
    }
    public Connection getConexion(){
       return miConexion;
    }
    
    public boolean ingresarImg(){
        return true;
    }
    
    public boolean statusConexion(){
        String sql ="SELECT 1+1;";
        try{
             ps = this.getConexion().prepareStatement(sql);

             rs = ps.executeQuery();
             
             if(rs.next()){
                 return true;
             }
             
        }catch(Exception e){

        }
        return false;
    }
    
    public boolean IngresarImg(int id, String name, String path){
        String sql = "INSERT INTO planetas(id,nombre,imagen_Planeta) value (?,?,?);";
        try {
            ps = this.getConexion().prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setString(3, path);
            
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            
        }
        return false;
    }
      
}
