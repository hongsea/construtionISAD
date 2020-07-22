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
public class Customer {

    Connection con = Application.getConnection();

    public void getCustomer(JTable tableName) {

        try {

            String customerQuery = "select * from tbCustomer";
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

    public void create(JTextField name , String gender, JTextField phone, JTextField address, JLabel labelName) {
        try {
            String customer = "insert into tbCustomer(name , gender, phone , address)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(customer);

            pst.setString(1, name.getText().trim()); 
            pst.setString(2, gender.trim()); 
            pst.setString(3, phone.getText().trim()); 
            pst.setString(4, address.getText().trim()); 
            
            pst.executeUpdate();
            labelName.setText("create customer success");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
