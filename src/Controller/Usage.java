/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vatha
 */
public class Usage {
    Connection con = Application.getConnection();
    
    public void getSelectTableUsage(JComboBox StaffUsage, JComboBox CEUsage, JTextField dateUse,JTextField totalQtyUsae, JTable tbUsage){
        try{
            int i = tbUsage.getSelectedRow();
            TableModel tm = tbUsage.getModel();
            String id = tm.getValueAt(i, 0).toString();
            String viewqurey = "select * from tbUsage where id=?";
            PreparedStatement ps = con.prepareStatement(viewqurey);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                int getstaffid = rs.getInt(4);

                String selectstaffID = "select name from tbStaff where id='" + getstaffid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffID);
                while (rss.next()){                    
                    StaffUsage.setSelectedItem(rss.getString(1));
                }     
                
                int  getceid = rs.getInt(5);
                String selectceID = "select name from tbCustractionEquipment where id='" + getceid + "'";
                Statement psu = con.createStatement();
                ResultSet rsu = psu.executeQuery(selectceID);
                while (rsu.next()){                   
                    CEUsage.setSelectedItem(rsu.getString(1));
                }
                
                dateUse.setText(rs.getString(2));
                totalQtyUsae.setText(rs.getString(3));
                
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void ClearUsage(JComboBox StaffUsage, JComboBox CEUsage,JTextField totalQtyUsae){
        StaffUsage.removeAllItems();
        StaffUsage.addItem("select");
        StaffUsage.setSelectedItem("select");

        Staff staff = new Staff();
        for (String staffList : staff.getAllStaff()) {
            StaffUsage.addItem(staffList);
        }
        
        CEUsage.removeAllItems();
        CEUsage.addItem("select");
        CEUsage.setSelectedItem("select");

        ConstractionEquiment ce = new ConstractionEquiment();
        for (String ceList : ce.getAllCE()){
            CEUsage.addItem(ceList);
        }
       
        totalQtyUsae.setText("");
    }
    public void getUsage(JTable tableName){
        try{
            
            String usageQuery = "select * from tbUsage";
            PreparedStatement pst = con.prepareStatement(usageQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Staff Name");
            model.addColumn("CE Name");
            model.addColumn("Usage Date");
            model.addColumn("Total Qty");
           
                                    
            while (rst.next()){
                int  getceid = rst.getInt(5);
                String selectceID = "select name from tbCustractionEquipment where id='" + getceid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectceID);
                
                int getstaffid = rst.getInt(4);
                String selectstaffID = "select name from tbStaff where id='" + getstaffid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectstaffID);
                while (rss.next()){
                    while (rsss.next()) {
                        model.addRow(new Object[]{rst.getString(1),rsss.getString(1),rss.getString(1),rst.getString(2),rst.getString(3)});
                    }
                }
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void create(Date usageDate, int totalQty, int staffId, int ceId){
        try {
            String usage = "insert into tbUsage(usage_date , total_qty, staff_id, CE_id )values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(usage);  
            
            pst.setDate(1, usageDate);
            pst.setInt(2, totalQty);
            pst.setInt(3, staffId);
            pst.setInt(4, ceId);

            pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void upadte(Date usageDate, int totalQty, int staffId, int ceId, JTable tableName){
        int s = tableName.getSelectedRow();
        try{
            String value = (tableName.getModel().getValueAt(s, 0).toString());
            String usage = "update tbUsage SET usage_date=?, total_qty=?, staff_id=?, CE_id=? where id=" + value;
            PreparedStatement psc = con.prepareStatement(usage);
            
            psc.setDate(1, usageDate);
            psc.setInt(2, totalQty);
            psc.setInt(3, staffId);
            psc.setInt(4, ceId);
        
            psc.executeUpdate();
          
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
