package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NequiDao {
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

        public int crear(NequiVo nequi) throws SQLException{
        sql="INSERT INTO Nequi(nombreCuenta,contrasenaCuenta,estadoCuenta,saldoNequi) values(?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println("entro al registro");
            
            ps.setString(1, nequi.getNombre());
            ps.setString(2, nequi.getContrasena());
            ps.setInt(3, nequi.getSaldo());
            ps.setBoolean(4, nequi.getEstado());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el usuario correctamente");
        }catch(Exception e){

        }finally{
            con.close();//cerrando conexión
        }
        return r;
    }
    public int recargar(NequiVo nequi) throws SQLException{
        sql="UPDATE Nequi SET saldoNequi=? WHERE idNequi=?";
                try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, nequi.getSaldo());

    // establecer el ID para la cláusula WHERE

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }


    return r;
}
}
