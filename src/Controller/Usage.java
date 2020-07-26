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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vatha
 */
public class Usage {
    Connection con = Application.getConnection();
    
    public void getUsage(JTable tableName){
        try{
            
            String usageQuery = "select * from tbUsage";
            PreparedStatement pst = con.prepareStatement(usageQuery);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tableName.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Staff ID");
            model.addColumn("CE ID");
            model.addColumn("Usage Date");
            model.addColumn("Total Qty");
           
                                    
            while (rst.next()){
                model.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)});
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
