/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona(99L,"CATALIN");
        PersonaDao servicio = FactoriaPersonaDao.get();        
        servicio.nueva(p);
    }

}