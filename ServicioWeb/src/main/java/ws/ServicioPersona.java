/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;

/**
 *
 * @author gcoprea
 */
@WebService(serviceName = "ServicioPersona")
@Stateless

public class ServicioPersona {
    
    private EntityManager em;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public Persona hello(@WebParam(name = "name") String txt) {
        return new Persona(txt);
    }
    
    public Persona crear(String nombre) {
        Persona p = new Persona(nombre);
        em.persist(p);
        return p;
    }

    public List<Persona> todos() {
        return em.createQuery("select p from Persona p").getResultList();
    }
}
