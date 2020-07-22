/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class ProjectInforamtion {
    Connection con = Application.getConnection();
    
    public void getProjectInformation(JTable tableName){
        try{
            
            String pIQuery = "select * from tbProjectInformation";
            PreparedStatement pst = con.prepareStatement(pIQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            tableName.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Path");
            model.addColumn("File Name");
           
           
                                    
            while (rst.next()){
                model.addRow(new Object[]{rst.getString(1),rst.getString(2)});
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
