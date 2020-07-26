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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class ImportDetails {

    Connection con = Application.getConnection();

    public void create(int importQty, int unitPrice, Double amount, int impotId, int ceId) {
        try {
            String importDetails = "insert into tbImportDetail(import_qty , unit_price, amount, import_id, CE_id )values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(importDetails);

            pst.setInt(1, importQty);
            pst.setInt(2, unitPrice);
            pst.setDouble(3, amount);
            pst.setInt(4, impotId);
            pst.setInt(5, ceId);

            pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void getImportDetailsByImportId(int importId , JTable tableName){
        try {

            String importDetails = "select * from tbImportDetail where import_id=" + importId;
            PreparedStatement pst = con.prepareStatement(importDetails);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);

            model.addColumn("ID");
            model.addColumn("Import Qty");
            model.addColumn("unit_price");
            model.addColumn("Amount");
            model.addColumn("Import ID");
            model.addColumn("CE ID");

            while (rst.next()) {
                model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)});
            }
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void update(int importQty, double unitPrice, double amount, int importId, int ceId){
        try{
       
            String importDetail = "update tbImportDetail SET import_qty=?, unit_price=? amount=? import_id=? CE_id=? where id=" + ceId;
            PreparedStatement psc = con.prepareStatement(importDetail);
            
            psc.setInt(1, importQty);
            psc.setDouble(2, unitPrice);
            psc.setDouble(3, amount);
            psc.setInt(4, importId);
            psc.setInt(5, ceId);
            
            psc.executeUpdate();
          
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
