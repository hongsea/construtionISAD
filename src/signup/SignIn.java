package signup;

import Application.Application;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import MainForm.Main;

public class SignIn extends javax.swing.JFrame {
    
    Connection con = Application.getConnection();
    public String gnl;
    
    public SignIn() {
        initComponents();
        setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btncreatenewuser = new javax.swing.JButton();
        btnsignin = new javax.swing.JButton();
        usernamelable = new javax.swing.JLabel();
        passwordlable = new javax.swing.JLabel();
        sucessfullylable = new javax.swing.JLabel();
        faillable = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnsignin1 = new javax.swing.JButton();
        labelnamelogo = new javax.swing.JLabel();
        labellogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lablepicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 730));

        jPanel2.setPreferredSize(new java.awt.Dimension(1300, 700));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 51, 255)));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameKeyReleased(evt);
            }
        });
        kGradientPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 260, 37));

        jLabel4.setFont(new java.awt.Font("MACGrande", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 255));
        jLabel4.setText("Username");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 98, 23));

        jLabel5.setFont(new java.awt.Font("MACGrande", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 255));
        jLabel5.setText("Password");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 255));
        jLabel2.setText("SIGN IN");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 90, 32));

        btncreatenewuser.setBackground(new java.awt.Color(0, 124, 154));
        btncreatenewuser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btncreatenewuser.setText("Create New User");
        btncreatenewuser.setBorder(null);
        btncreatenewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreatenewuserActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btncreatenewuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 220, 30));

        btnsignin.setBackground(new java.awt.Color(0, 102, 153));
        btnsignin.setFont(new java.awt.Font("LucidaMacBold", 0, 12)); // NOI18N
        btnsignin.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin.setText("SIGN IN");
        btnsignin.setBorder(null);
        btnsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsigninActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 95, 31));

        usernamelable.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        usernamelable.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(usernamelable, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 240, 110, 20));

        passwordlable.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        passwordlable.setForeground(new java.awt.Color(255, 51, 51));
        kGradientPanel1.add(passwordlable, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 340, 110, 20));

        sucessfullylable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sucessfullylable.setForeground(new java.awt.Color(0, 204, 0));
        kGradientPanel1.add(sucessfullylable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 124, 19));

        faillable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        faillable.setForeground(new java.awt.Color(255, 51, 0));
        kGradientPanel1.add(faillable, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 470, 100, 19));

        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));
        kGradientPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 260, 40));

        btnsignin1.setBackground(new java.awt.Color(102, 102, 255));
        btnsignin1.setFont(new java.awt.Font("LucidaMacBold", 0, 12)); // NOI18N
        btnsignin1.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin1.setText("CANCEL");
        btnsignin1.setBorder(null);
        btnsignin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignin1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnsignin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 95, 31));

        labelnamelogo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelnamelogo.setForeground(new java.awt.Color(0, 153, 153));
        labelnamelogo.setText("CONSTRUCTION SOFTWARE");
        kGradientPanel1.add(labelnamelogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 280, 30));

        labellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/building.png"))); // NOI18N
        kGradientPanel1.add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jPanel2.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 380, 530));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                WELCOME");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 610, 90));

        jLabel3.setFont(new java.awt.Font("MACGrande", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html> <body> <h3>One software system for businesses, small and large enterprises,</h3> <h3>schools,  hospitals,  construction  companies  and  factories, with</h3> <h3>modules such as human resources management, payroll and many more.</h3> </body> </html>");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 610, 140));

        lablepicture.setBackground(new java.awt.Color(102, 255, 102));
        lablepicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backugroud1.jpg"))); // NOI18N
        jPanel2.add(lablepicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(-490, 0, 1790, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    private void btnsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsigninActionPerformed
        try{
            String sql = "Select * from tbUser where username=? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username.getText().trim());
            String user = username.getText().trim().toString();
            //pst.setString(2, password.getText().trim());
            pst.setString(2,String.valueOf(jPasswordField1.getPassword()));
            
            if(username.getText().trim().isEmpty() && String.valueOf(jPasswordField1.getPassword()).trim().isEmpty()){
                usernamelable.setText("Username is required.");
                passwordlable.setText("Password is required.");
                username.requestFocus();
            }
            else if (username.getText().trim().isEmpty()){
                usernamelable.setText("Username is required.");
                username.requestFocus();
            }
            else if (String.valueOf(jPasswordField1.getPassword()).trim().isEmpty()){
                passwordlable.setText("Password is required.");
                jPasswordField1.requestFocus();
            }
            else{
                ResultSet rs = pst.executeQuery();
                if(rs.next()){      
                    
                    Main ma = new Main();
                    ma.setVisible(true);
                    ma.openhome();
                    ma.closeuser();
                    this.setVisible(true);
                    this.setVisible(false);
                    ma.getusername(user);
                    
                    //sucessfullylable.setText("Sign in sucessfully.");
                    
                }
                else{
                    faillable.setText("Sign in failed.");
                    username.setText("");
                    jPasswordField1.setText("");
                    username.requestFocus();
                }
            }
//            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsigninActionPerformed

    private void btncreatenewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreatenewuserActionPerformed
        Main ma = new Main();
        ma.setVisible(true);
        ma.create();
        this.setVisible(false);
        
    }//GEN-LAST:event_btncreatenewuserActionPerformed

    private void usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyReleased
        usernamelable.setText("");
        sucessfullylable.setText("");
        faillable.setText("");
    }//GEN-LAST:event_usernameKeyReleased

    private void btnsignin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsignin1ActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncreatenewuser;
    private javax.swing.JButton btnsignin;
    private javax.swing.JButton btnsignin1;
    private javax.swing.JLabel faillable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labelnamelogo;
    private javax.swing.JLabel lablepicture;
    private javax.swing.JLabel passwordlable;
    private javax.swing.JLabel sucessfullylable;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernamelable;
    // End of variables declaration//GEN-END:variables
}
