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
            String importDetails = "insert into tbImportDetails(import_qty , unit_price, amount, import_id, CE_id )values(?,?,?,?,?)";
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

            String importDetails = "select * from tbImport where id=" + importId;
            PreparedStatement pst = con.prepareStatement(importDetails);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);

            model.addColumn("ID");
            model.addColumn("Import ID");
            model.addColumn("Supplier ID");
            model.addColumn("Import Date");
            model.addColumn("Total Amount");

            while (rst.next()) {
                model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)});
            }
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
