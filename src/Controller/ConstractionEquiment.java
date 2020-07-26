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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class ConstractionEquiment {

    Connection con = Application.getConnection();

    public void getConstractionEquiment(JTable tableName) {
        try {

            String ceQuery = "select * from tbCustractionEquipment";
            PreparedStatement pst = con.prepareStatement(ceQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            tableName.setModel(model);

            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Stock Qty");
            model.addColumn("Unit Price");

            while (rst.next()) {
                model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)});
            }

            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void create(JTextField name, JTable tableName) {
        try {
            String ce = "insert into tbCustractionEquipment(name)values(?)";
            PreparedStatement pst = con.prepareStatement(ce);

            pst.setString(1, name.getText().trim());

            pst.executeUpdate();
            getConstractionEquiment(tableName);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
//        labelName.setText("Create CunstractionEquipment sucessfully.");
    }
    
    public int getCEByName (JComboBox cbName){
        int getCEId=0;
        try{
            String cEName = cbName.getSelectedItem().toString();
            String CE = "select id from tbCustractionEquipment where name='" + cEName + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(CE);                    
            while(rs.next()){
                getCEId = rs.getInt(1);
            }
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
         return getCEId;
    }

    public  ArrayList<String> getAllCE() {
        ArrayList<String> cEList = new ArrayList<>();
        try{
            String CE = "select name from tbCustractionEquipment";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(CE);  
            
            while(rs.next()){
                cEList.add(rs.getString(1));
            }
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }        
        return cEList;
    }
    
    public void update(int stockQty,double unitPrice,int ceId, JTable tableName){
 
        try{
       
            String updateImport = "update tbCustractionEquipment SET stock_qty=?, unit_price=? where id=" + ceId;
            PreparedStatement psc = con.prepareStatement(updateImport);
            
            psc.setInt(1, stockQty);
            psc.setDouble(2, unitPrice);
            
            
            psc.executeUpdate();
          
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
