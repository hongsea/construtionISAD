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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
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
public class Import {
     Connection con = Application.getConnection();
     
     public void getImportID(JTextField importid, JTable tbgetimport){
         try{
             int i = tbgetimport.getSelectedRow();
             TableModel tm = tbgetimport.getModel();
             String id = tm.getValueAt(i, 0).toString();
             String viewqurey = "select * from tbImport where id=?";
             PreparedStatement ps = con.prepareStatement(viewqurey);
             importid.setText(id);
              
             
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
     }
     public void getSelecttbImport(JTextField impoDate , JComboBox staffId, JComboBox supplierId, JTable tbgetimport){
        
         try{
             int i = tbgetimport.getSelectedRow();
             TableModel tm = tbgetimport.getModel();
             String id = tm.getValueAt(i, 0).toString();
             String viewqurey = "select * from tbImport where id=?";
             PreparedStatement ps = con.prepareStatement(viewqurey);
              ps.setString(1, id);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
                impoDate.setText(rs.getString(2));
                 
                //get staff name
                int getidstaff = rs.getInt(3);
                String selectstaffID = "select name from tbStaff where id='" + getidstaff + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffID);                    
                while(rss.next()){
                    staffId.setSelectedItem(rss.getString(1));
                }
                
                //get supplier name
                int getidsupplier = rs.getInt(4);
                String selectsupplierID = "select name from tbSupplier where id='" + getidsupplier + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectsupplierID);                    
                while(rsss.next()){
                    supplierId.setSelectedItem(rsss.getString(1));
                }                 
             }
             
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
     }
     public void getImport(JTable tableName){
         try{
            
            String importQuery = "select * from tbImport";
            PreparedStatement pst = con.prepareStatement(importQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);

            model.addColumn("ID");
            model.addColumn("Staff Name");
            model.addColumn("Supplier Name");
            model.addColumn("Import Date");
            model.addColumn("Total Amount");
           
                                    
            while (rst.next()){
                
                //get staff name
                int getidstaff = rst.getInt(3);
                String selectstaffID = "select name from tbStaff where id='" + getidstaff + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffID);  
                
                
                 //get supplier name
                int getidsupplier = rst.getInt(4);
                String selectsupplierID = "select name from tbSupplier where id='" + getidsupplier + "'";
                Statement psss = con.createStatement();
                ResultSet rssu = psss.executeQuery(selectsupplierID);                    
                
                while(rss.next()){
                    while (rssu.next()) {
                       model.addRow(new Object[]{rst.getString(1),rss.getString(1),rssu.getString(1),rst.getString(2),rst.getString(5)});  
                    }
                }
            }
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void createImport(Date impoDate, int staffId, int supplierId) {
        try {
            String importQ = "insert into tbImport(import_date , staff_id, supplier_id )values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(importQ);

            pst.setDate(1, impoDate);
            pst.setInt(2, staffId);
            pst.setInt(3, supplierId);

            pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void clear(JTextField importDate, JComboBox cbName, JComboBox cbName2) {

        importDate.setText(" ");

        cbName.removeAllItems();
        cbName.addItem("select");
        cbName.setSelectedItem("select");

        cbName2.removeAllItems();
        cbName2.addItem("select");
        cbName2.setSelectedItem("select");
    }
    
    
     public void update (int staffID,int supplierID, JLabel lbMessageCustomer, JTable tableName){
        int s = tableName.getSelectedRow();
        try{
            String value = (tableName.getModel().getValueAt(s, 0).toString());
            String updateImport = "update tbImport SET staff_id=?, supplier_id=? where id=" + value;
            PreparedStatement psc = con.prepareStatement(updateImport);
            
            psc.setInt(1, staffID);
            psc.setInt(2, supplierID);
            
            
            psc.executeUpdate();
            lbMessageCustomer.setText("Update Import success");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
