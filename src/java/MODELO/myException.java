/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author maria
 */
public class myException extends Exception{
    private int codigo;
    private String mensaje;
    private String ubicacion;
    private String url;

    public myException(int codigo, String mensaje, String ubicacion, String url) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.ubicacion = ubicacion;
        this.url = url;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
 
    
}
