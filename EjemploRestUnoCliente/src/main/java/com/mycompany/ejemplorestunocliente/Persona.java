/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplorestunocliente;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gcoprea
 */
@XmlRootElement
public class Persona {
    
    private Long id;
    private String nombre;

    public Persona() {
    }

    public Persona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
