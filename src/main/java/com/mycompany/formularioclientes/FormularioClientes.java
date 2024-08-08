/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.formularioclientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar Fonseca
 */
public class FormularioClientes {

    public static void main(String[] args) {
        String usuario = "root";
        String passwort = "";
        String url = "jdbc:mysql://localhost/datos";
        Connection conexion = null;
        Statement Statement = null; 
        ResultSet rs;

        try {
            conexion = DriverManager.getConnection(url, usuario, passwort);
            Statement = conexion.createStatement();
            rs = Statement.executeQuery("SELECT * FROM `informacion`");
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRE")); 
            }
            // Insertar datos 
            Statement.execute("INSERT INTO `informacion` (`ID`, `NOMBRE`, `APELLIDO`, `CEDULA`, `CORREO`, `TELEFONO`) VALUES (NULL, 'jhon', 'linares', '203227563', 'jhon2032gmail.com', '322456778');");
            System.out.println();
            rs = Statement.executeQuery("SELECT * FROM `informacion`");
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRE")); 
            }
            // Actualizar datos
            Statement.execute("UPDATE `informacion` SET `NOMBRE` = 'Maria', `APELLIDO` = 'alvares', `CEDULA` = '102332275', `CORREO` = 'maria2002@gmail.com', `TELEFONO` = '387666567' WHERE `informacion`.`ID` = 6;");
            System.out.println();
            rs = Statement.executeQuery("SELECT * FROM `informacion`");
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRE")); 
            }
            // Borrar datos
            Statement.execute("DELETE FROM informacion WHERE `informacion`.`ID` = 9");
            System.out.println();
            rs = Statement.executeQuery("SELECT * FROM `informacion`");
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRE")); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (Statement != null) {
                try {
                    Statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}