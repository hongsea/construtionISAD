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
public class Customer {

    Connection con = Application.getConnection();

    public void clear(JTextField id,JTextField name , String gender, JTextField phone, JTextField address, JComboBox staff_id){
        id.setText("");
        name.setText("");
        gender="";
        phone.setText("");
        address.setText("");
        
        staff_id.removeAllItems();
        staff_id.addItem("select");
        staff_id.setSelectedItem("select");
    }
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
                model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void create(JTextField name , String gender, JTextField phone, JTextField address, int staffID, JLabel labelName, JTable tableName) {
        try {
            String customer = "insert into tbCustomer(name , gender, phone , address,staff_id)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(customer);

            pst.setString(1, name.getText().trim()); 
            pst.setString(2, gender.trim()); 
            pst.setString(3, phone.getText().trim()); 
            pst.setString(4, address.getText().trim());
            pst.setInt(5, staffID);
            
            pst.executeUpdate();
            getCustomer(tableName);
            labelName.setText("create customer success");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
