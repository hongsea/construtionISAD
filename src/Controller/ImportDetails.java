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
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vatha
 */
public class ImportDetails {

    Connection con = Application.getConnection();
    
    public void getSelectTableImportDetial(JComboBox ceImportDetails,JTextField unitPriceImportDetails, JTextField importId_Detail, JTextField amountImportDetails, JTextField importQtyImportDetails, JTable tableimportdetail){
        try{
            int i = tableimportdetail.getSelectedRow();
             TableModel tm = tableimportdetail.getModel();
             String id = tm.getValueAt(i, 0).toString();
             String viewqurey = "select * from tbImportDetail where id=?";
             PreparedStatement ps = con.prepareStatement(viewqurey);
             ps.setString(1, id);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
                 importQtyImportDetails.setText(rs.getString(2));
                 unitPriceImportDetails.setText(rs.getString(3));
                 amountImportDetails.setText(rs.getString(4));               
                 importId_Detail.setText(rs.getString(5));

                int getceid = rs.getInt(6);
                String selectceID = "select name from tbCustractionEquipment where id='" + getceid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectceID);
                while (rss.next()){
                    ceImportDetails.setSelectedItem(rss.getString(1));
                }                 
                 

             }            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void clearImportDetail(JComboBox ceImportDetails,JTextField unitPriceImportDetails, JTextField importId_Detail, JTextField amountImportDetails, JTextField importQtyImportDetails, JTable tableimportdetail ){
        ceImportDetails.removeAllItems();
        ceImportDetails.addItem("select");
        ceImportDetails.setSelectedItem("select");
        
        unitPriceImportDetails.setText("");
        importId_Detail.setText("");
        amountImportDetails.setText("");
        importQtyImportDetails.setText("");
    }
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
                int getceid = rst.getInt(6);
                String selectceID = "select name from tbCustractionEquipment where id='" + getceid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectceID);
                while (rss.next()){
                    model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rss.getString(1)});
                }
            }
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void update(int importQty, double unitPrice, double amount, int importId, int ceId, JTable tableName){
        int s = tableName.getSelectedRow();
        try{
            String value = (tableName.getModel().getValueAt(s, 0).toString());
            String importDetail = "update tbImportDetail SET import_qty=?, unit_price=?, amount=?, import_id=?, CE_id=? where id=" + value;
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
