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
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class Supplier {

    Connection con = Application.getConnection();

    public void getSupplier(JTable tableName) {
        try {

            String customerQuery = "select * from tbSupplier";
            PreparedStatement pst = con.prepareStatement(customerQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            tableName.setModel(model);

            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Gender");
            model.addColumn("Phone");
            model.addColumn("Address");

            while (rst.next()) {
                model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void createSupplier(JTextField name, String gender, JTextField phone, JTextField address, JLabel labelName) {
        try {
            String supplier = "insert into tbSupplier(name,gender,phone,address)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(supplier);

            pst.setString(1, name.getText().trim());
            pst.setString(2, gender.trim());
            pst.setString(3, phone.getText().trim());
            pst.setString(4, address.getText().trim());

            pst.executeUpdate();
            labelName.setText("Create supplier sucessfully.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
