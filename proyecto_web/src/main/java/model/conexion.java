package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    private static final String bbdd="jdbc:mysql://localhost:3306/bolsillo";
    private static final String usuario="root";
    private static final String clave="";
    private static Connection con;

    public static Connection conectar() {

        try {
        //nombre del driver de jdbc para mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(bbdd,usuario,clave);
        System.out.println("Conexión Exitosa");
        
        }catch(Exception e) {
        
        System.out.println("Error de conexión a la base de datos "+e.getMessage().toString());
        }
        return con;
}
public static void main(String[] args) {
    conexion.conectar();
}
}
