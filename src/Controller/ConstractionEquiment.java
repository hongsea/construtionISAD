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
}
