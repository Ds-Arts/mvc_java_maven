package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioDao;
import model.UsuarioVo;

public class Usuario extends HttpServlet {
    UsuarioVo U=new UsuarioVo();
    UsuarioDao D=new UsuarioDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "abrirFormu":
                abrirForm(req,resp);
            break;
            case "listar":
                listar(req,resp);
            break;
            case "modificarForm":
            modificar(req,resp);
            System.out.println("modificacion completa");
            break;
            case "daviplata":
                daviplata(req,resp);
                System.out.println("daviplata completa");
            break;
            case "nequi":
                nequi(req,resp);
                System.out.println("modificacion completa");
            break;

        
    }
        }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "iniciar":
                iniciar(req,resp);
                System.out.println(" completa");
            break;
            case "add":
                add(req,resp);
                System.out.println("hola");
            break;
            case "modificarU":
            modificaru(req,resp);
            System.out.println("Entro al modificar");
            break;
        }
    }
    //doGet
    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Registrar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario=D.listar();
            req.setAttribute("usuarios", usuario);
            req.getRequestDispatcher("views/Listar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    private void modificar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/ModificarU.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void daviplata(HttpServletRequest req, HttpServletResponse resp) {
    try{
        req.getRequestDispatcher("views/loginD.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
    }

    private void nequi(HttpServletRequest req, HttpServletResponse resp) {
    try{
        req.getRequestDispatcher("views/loginN.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
    }
    
    //doPost
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("usu_nombre")!=null){
            U.setNombre(req.getParameter("usu_nombre"));
        }
        if(req.getParameter("usu_contrasena")!=null){
            U.setContrasena(req.getParameter("usu_contrasena"));
        }
        if(req.getParameter("usu_telefono")!=null){
            U.setTelefono( Integer.parseInt(req.getParameter("usu_telefono")));;
        }
        if(req.getParameter("usu_direccion")!=null){
            U.setDireccion(req.getParameter("usu_direccion"));
        }        
        if(req.getParameter("usu_email")!=null){
            U.setEmail(req.getParameter("usu_email"));
        }

        if(req.getParameter("chkestado")!=null){
            U.setEstado(true);
        }else{
            U.setEstado(false);
        }
        
        try {
            D.crear(U);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("views/Listar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    
    
    private void modificaru(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("usu_id")!=null){
            U.setIdUsuario(Integer.parseInt(req.getParameter("usu_id"))); 
        }
        if(req.getParameter("usu_nombre")!=null){
            U.setNombre(req.getParameter("usu_nombre"));
        }
        if(req.getParameter("usu_contrasena")!=null){
            U.setContrasena(req.getParameter("usu_contrasena"));
        }
        if(req.getParameter("usu_telefono")!=null){
            U.setTelefono( Integer.parseInt(req.getParameter("usu_telefono")));;
        }
        if(req.getParameter("usu_direccion")!=null){
            U.setDireccion(req.getParameter("usu_direccion"));
        }        
        if(req.getParameter("usu_email")!=null){
            U.setEmail(req.getParameter("usu_email"));
        }

        if(req.getParameter("chkestado")!=null){
            U.setEstado(true);
        }else{
            U.setEstado(false);
        }
        
        try {
            D.modificar(U);
            System.out.println("modificado correctamente");
            req.getRequestDispatcher("views/Listar.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en  la modificacion"+e.getMessage().toString());
        }
    }
    public void iniciar(HttpServletRequest req, HttpServletResponse resp) {
    System.out.println("entro al inicio");
    String nombre = req.getParameter("usu_nombre");
    String contrasena = req.getParameter("usu_contrasena");
    try {
    UsuarioVo usuario = D.obtenerUsuario(nombre, contrasena);


    if (usuario != null) {
    // Usuario válido, realizar acciones apropiadas, como iniciar sesión.
    System.out.println("Inicio de sesión exitoso");
    } else {
    // Usuario no válido, realizar acciones apropiadas, como mostrar un mensaje de error.
    System.out.println("Nombre de usuario o contraseña incorrectos");
    }
    } catch (SQLException e) {
        // Manejar cualquier excepción que ocurra durante el proceso de validación.
        System.out.println("Error al validar el usuario: " + e.getMessage());
    }
}

}



    

