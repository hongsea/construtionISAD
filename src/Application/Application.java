/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vatha
 */
public class Application {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dev_construction;user=sa;password=123");
            System.out.println("connected.");
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return con;
    }
}
