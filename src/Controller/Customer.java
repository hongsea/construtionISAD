
package Controller;

import Application.Application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vatha
 */
public class Customer {

    Connection con = Application.getConnection();

    public String getAllcustomer(JTextField id,JTextField name , JTextField phone, JTextField address, JComboBox staffName,JTable TableCustomer){
        String getgender = null;
        try{
            int i = TableCustomer.getSelectedRow();
            TableModel tm = TableCustomer.getModel();
            id.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbCustomer where id=?";
            PreparedStatement ps = con.prepareStatement(viewqurey);
            ps.setString(1, id.getText().trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                name.setText(rs.getString(2));
                getgender = rs.getString(3);                
                phone.setText(rs.getString(4));
                address.setText(rs.getString(5));
                
                int getidstaff = rs.getInt(6);

                String selectstaffID = "select name from tbStaff where id='" + getidstaff + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffID);                    
                while(rss.next()){
                    staffName.setSelectedItem(rss.getString(1));
                } 
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return getgender;
    }

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
            model.addColumn("Create by Staff");

            while (rst.next()) {
                int getidstaff = rst.getInt(6);
                String selectstaffID = "select name from tbStaff where id='" + getidstaff + "'";
                Statement ps = con.createStatement();
                ResultSet rs = ps.executeQuery(selectstaffID); 
                while (rs.next()){
                    model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rs.getString(1)});
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void update (JTextField name , String gender, JTextField phone, JTextField address, int staffID,JLabel lbMessageCustomer, JTable tableName){
        int s = tableName.getSelectedRow();
        try{
            String value = (tableName.getModel().getValueAt(s, 0).toString());
            String updateCustomer = "update tbCustomer SET name=?, gender=?, phone=?, address=?, staff_id=? where id=" + value;
            PreparedStatement psc = con.prepareStatement(updateCustomer);
            
            psc.setString(1, name.getText().trim());
            System.out.println("Gender: " + gender);
            psc.setString(2, gender);
            psc.setString(3, phone.getText().trim());
            psc.setString(4, address.getText().trim());
            psc.setInt(5, staffID);
            
            
            psc.executeUpdate();
            getCustomer(tableName);
            lbMessageCustomer.setText("Update Customer success");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void create(JTextField name , String gender, JTextField phone, JTextField address, int staffID, JLabel labelName, JTable tableName) {
        try {
            String customer = "insert into tbCustomer(name , gender, phone , address,staff_id)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(customer);

            pst.setString(1, name.getText().trim()); 
            pst.setString(2, gender); 
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
