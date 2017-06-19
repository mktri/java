/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatenuevo;

/**
 *
 * @author Chema
 */
public class HibernateHook extends Thread {

    @Override
    public void run() {
        HibernateUtil.getSessionFactory().close();
        System.out.println("Factoría de sesiones cerrada");
    }

}
