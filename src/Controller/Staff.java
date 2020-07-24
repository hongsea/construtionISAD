
package Controller;

import Application.Application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Staff {
    Connection con = Application.getConnection();
    
    public int getStaffIdByName (JComboBox StaffName){
        int getstaffid=0;
        try{
            String staffName = StaffName.getSelectedItem().toString();
            String selectstaffID = "select id from tbStaff where name='" + staffName + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectstaffID);                    
            while(rs.next()){
                getstaffid = rs.getInt(1);
            }
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
         return getstaffid;
    }

    public  ArrayList<String> getAllStaff() {
        ArrayList<String> stafflist = new ArrayList<>();
        try{
            String selectstaffID = "select name from tbStaff";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectstaffID);  
            
            while(rs.next()){
                stafflist.add(rs.getString(1));
            }
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }        
        return stafflist;
    }
}

