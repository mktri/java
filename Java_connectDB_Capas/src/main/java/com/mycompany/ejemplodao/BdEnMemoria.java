/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
class BdEnMemoria implements PersonaDao {

    private final List<Persona> personas;
    private Connection connectDB;
    Statement stmt = null;
    PreparedStatement preparedStatement = null;

    //constructor
    BdEnMemoria() {
        this.personas = new ArrayList<>();
        
        //crear la conexion
        try {
            connectDB = DriverManager.getConnection("jdbc:derby://localhost:1527/curso", "app", "app");
            System.out.println("Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(BdEnMemoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Persona nueva(Persona p) {

        Long id = p.getId();
        String nombre = p.getNombre();
        
        //crear statement
        try {
            stmt = connectDB.createStatement();
//          final String orden = "insert into personas values (%d,'%s')";
//          String formateada = String.format(orden, id,nombre);
//          stmt.executeUpdate(formateada);
            stmt.executeUpdate("insert into Personas values(" + id + "," + "'" + nombre + "'" + ")");
            preparedStatement = connectDB.prepareStatement(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(BdEnMemoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Persona> todos() {

        //consultar
        ResultSet rset;
        ArrayList<Persona> pers = new ArrayList<>();
        try {
            stmt = connectDB.createStatement();
            rset = stmt.executeQuery("select * from Personas");
            
            while (rset.next()) {
                pers.add(new Persona(rset.getLong(1), rset.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BdEnMemoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pers;
    }

}
