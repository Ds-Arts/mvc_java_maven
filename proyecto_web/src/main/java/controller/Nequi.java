package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.NequiDao;
import model.NequiVo;

public class Nequi extends HttpServlet{
    NequiVo U=new NequiVo();
    NequiDao D=new NequiDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");
        switch(a){       
                        case "cuenta":
            cuenta(req,resp);
            System.out.println("daviplata completa");
            break;      
            case "dashboard":
            daviplata(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Nrecargar":
            recargar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Nretirar":
            retirar(req,resp);
            System.out.println("daviplata completa");
            break;
            case "Nconsultar":
            consultar(req,resp);
            System.out.println("daviplata completa");
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "add":
                add(req,resp);
            break;
        }
    }


        private void consultar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nconsultar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    private void retirar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nretirar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


    private void recargar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nrecargar.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void daviplata(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }


        private void cuenta(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Cuenta.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreCuenta")!=null){
            U.setNombre(req.getParameter("nombreCuenta"));
        }
        if(req.getParameter("contrasenaCuenta")!=null){
            U.setContrasena(req.getParameter("contrasenaCuenta"));
        }
        if(req.getParameter("saldoNequi")!=null){
            U.setSaldo( Integer.parseInt(req.getParameter("saldoNequi")));;
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
}
