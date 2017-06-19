/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.ManyToOne;

/**
 *
 * @author gcoprea
 */
public class Rol {
    
    private String nombre;
    private Long id;
    @ManyToOne
    private Usuario usuario;

    public Rol() {
    }

    
    public Rol(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Rol{" + "nombre=" + nombre + ", id=" + id + ", usuario=" + usuario + '}';
    }
    
    
}
