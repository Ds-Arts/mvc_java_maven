package model;

public class DaviplataVo {
    private int id;
    private int saldo;
    private String nombre;
    private String contrasena;
    private boolean estado;

    

    public DaviplataVo() {

    }
    public DaviplataVo(int id, int saldo, String nombre, String contrasena, boolean estado) {
        this.id = id;
        this.saldo = saldo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public boolean getEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    
}
