package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaviplataDao {
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
            public int crear(DaviplataVo Daviplata) throws SQLException{
        sql="INSERT INTO Daviplata(nombreCuenta,contrasenaCuenta,estadoCuenta,saldoDaviplata) values(?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println("entro al registro");
            
            ps.setString(1, Daviplata.getNombre());
            ps.setString(2, Daviplata.getContrasena());
            ps.setInt(3, Daviplata.getSaldo());
            ps.setBoolean(4, Daviplata.getEstado());

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
    public int recargar(DaviplataVo Daviplata) throws SQLException{
        sql="UPDATE Nequi SET saldoNequi=? WHERE idNequi=?";
                try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, Daviplata.getSaldo());

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
