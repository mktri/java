/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplorestunocliente;

import com.mycompany.ejemplorestunocliente.cliente.NewJerseyClient;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

/**
 *
 * @author gcoprea
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewJerseyClient cliente = new NewJerseyClient();
        
        cliente.putXml("Procesando...");
        cliente.putXml(new Persona(1993L,"Catalin"));
        Persona persona = cliente.getXml(Persona.class);
        System.out.println(persona);
        
        persona = cliente.getById(Persona.class, "1993");
        System.out.println(persona);
        System.out.println("Fin");
        
        
        /*String result= cliente.getXml();
        System.out.println(result);*/
        
        
        
    }
    
}
