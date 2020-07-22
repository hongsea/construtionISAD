/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Application;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class Import {
     Connection con = Application.getConnection();
     
     public void getImport(JTable tableName){
         try{
            
            String importQuery = "select * from tbImport";
            PreparedStatement pst = con.prepareStatement(importQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            tableName.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Staff ID");
            model.addColumn("Supplier ID");
            model.addColumn("Import Qty");
            model.addColumn("Total Amount");
           
                                    
            while (rst.next()){
                model.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)});
            }
            con.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     public void createImport(){
         
     }
    
}
