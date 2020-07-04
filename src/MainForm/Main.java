
package MainForm;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import Application.Application;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import signup.SignIn;
import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JTextField;
//import sun.java2d.pipe.BufferedBufImgOps;

public class Main extends javax.swing.JFrame {
    
    Connection con = Application.getConnection();
    Color paneldefault;
    Color panelclick;
    String imagePath = null;
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        
        paneldefault = new Color(0,204,204);
        panelclick = new Color(0,255,0);
        
        panelclicked1.setBackground(panelclick);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
        
        showlableonclickedmenu.setText("HOME");
        
      
   }
    public void getusername(String user){
        lableshownamelogin.setHorizontalAlignment(SwingConstants.CENTER);
        lableshownamelogin.setText(" " + user);
    }
    
    public void refreshtable() {
        try {
            cboSearch.removeAllItems();
            String showquery = "Select * from tbUser ";
            PreparedStatement mpst = con.prepareStatement(showquery);
            ResultSet rsl = mpst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbviewuser.setModel(model);
            model.addColumn("User ID");
            model.addColumn("User Name");
            while (rsl.next()) {
                model.addRow(new Object[]{rsl.getString(1), rsl.getString(3)});
                String staffname = rsl.getString(2) + " " + rsl.getString(3);
                cboSearch.addItem(rsl.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void create(){
        panelmenuhome.setVisible(false);
        panelmenustaff.setVisible(false);
        panelmenworker.setVisible(false);
        panelmencutomer.setVisible(false);
        panelmensupplier.setVisible(false);
        lableshownamelogin.setVisible(false);
        btnlogout.setVisible(false);
        refreshtable();
        showlableonclickedmenu.setText("USER");
        menuuser.setVisible(true);
        
    }
    public void openhome(){
        menuhome.setVisible(true);
    }
    public void closeuser(){
        panelmenuuser.setVisible(false);
        menuuser.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelbar = new javax.swing.JPanel();
        lableshownamelogin = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        showlableonclickedmenu = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        panelmenu = new javax.swing.JPanel();
        panelmenuhome = new javax.swing.JPanel();
        panelclicked1 = new javax.swing.JPanel();
        homemenulable = new javax.swing.JLabel();
        panelmenustaff = new javax.swing.JPanel();
        panelclicked2 = new javax.swing.JPanel();
        staffmenulable = new javax.swing.JLabel();
        lablewelcome = new javax.swing.JLabel();
        panelmenworker = new javax.swing.JPanel();
        panelclicked3 = new javax.swing.JPanel();
        staffmenulable1 = new javax.swing.JLabel();
        panelmencutomer = new javax.swing.JPanel();
        panelclicked4 = new javax.swing.JPanel();
        staffmenulable2 = new javax.swing.JLabel();
        panelmensupplier = new javax.swing.JPanel();
        panelclicked5 = new javax.swing.JPanel();
        staffmenulable3 = new javax.swing.JLabel();
        panelmenuprojectplan = new javax.swing.JPanel();
        panelclicked7 = new javax.swing.JPanel();
        staffmenulable5 = new javax.swing.JLabel();
        panelmenprojectplanlist = new javax.swing.JPanel();
        panelclicked8 = new javax.swing.JPanel();
        staffmenulable6 = new javax.swing.JLabel();
        panelmenuuser = new javax.swing.JPanel();
        panelclicked6 = new javax.swing.JPanel();
        staffmenulable4 = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();
        menuhome = new javax.swing.JInternalFrame();
        panelhome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelproject = new javax.swing.JPanel();
        labelproject = new javax.swing.JLabel();
        labeltotalproject = new javax.swing.JLabel();
        panelcustomer = new javax.swing.JPanel();
        labelclient = new javax.swing.JLabel();
        labeltotalclient = new javax.swing.JLabel();
        panelstaff = new javax.swing.JPanel();
        labelstaff = new javax.swing.JLabel();
        labeltotalstaff = new javax.swing.JLabel();
        panelsuppliers = new javax.swing.JPanel();
        labelsuppliers = new javax.swing.JLabel();
        labeltotalsuppliers = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        menutablestaff = new javax.swing.JInternalFrame();
        paneltablestaff = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbstaffview = new javax.swing.JTable();
        labelgidelineoftalestaff = new javax.swing.JLabel();
        btnopenmenustaffaddnew = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnEdittablestaff = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        menustaff = new javax.swing.JInternalFrame();
        panelstaffmenu = new javax.swing.JPanel();
        labelgidelineofmenustaff = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbStaff = new javax.swing.JTable();
        panelstaffinfomation = new javax.swing.JPanel();
        txtstaffID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStaffSalary = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStaffPhone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtStaffAddress = new javax.swing.JTextField();
        txtStaffBirthday = new com.toedter.calendar.JDateChooser();
        txtStaffHiredDate = new com.toedter.calendar.JDateChooser();
        cboStaffGender = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelpictureStaff = new javax.swing.JLabel();
        cboStaffStatus = new javax.swing.JComboBox<>();
        btnStaffNew = new javax.swing.JButton();
        btnStaffUpdate = new javax.swing.JButton();
        btnStaffCancel = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnStaffChoosepicture = new javax.swing.JButton();
        labelmessagestaff = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cboStaffroleID = new javax.swing.JComboBox<>();
        txtStaffNationlity = new javax.swing.JTextField();
        labelstaffroleidrequired = new javax.swing.JLabel();
        labelstaffNamerequired = new javax.swing.JLabel();
        labelstaffidrequired = new javax.swing.JLabel();
        labelstaffgenderrequired = new javax.swing.JLabel();
        labelstaffnatrequired = new javax.swing.JLabel();
        labelstaffbirthrequired = new javax.swing.JLabel();
        labelstaffhirdrequired = new javax.swing.JLabel();
        labelstaffsarequired = new javax.swing.JLabel();
        labelstaffphonerequired = new javax.swing.JLabel();
        labelstaffaddrerequired = new javax.swing.JLabel();
        labelstaffstaturequired = new javax.swing.JLabel();
        menuworker = new javax.swing.JInternalFrame();
        panelworker = new javax.swing.JPanel();
        menuuser = new javax.swing.JInternalFrame();
        panelcreateuser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboSearch = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbviewuser = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtuserID = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbostaffName = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cboposition = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtconfirmpassword = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnsignin = new javax.swing.JButton();
        staffnamerror = new javax.swing.JLabel();
        usernameerror = new javax.swing.JLabel();
        positionerror = new javax.swing.JLabel();
        passworderror = new javax.swing.JLabel();
        conpassworderror = new javax.swing.JLabel();
        sucessfulllable = new javax.swing.JLabel();
        btnCancel2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        menutableprojectplanlist = new javax.swing.JInternalFrame();
        paneltableprojectplanlist = new javax.swing.JPanel();
        cboProplanlistsearch = new javax.swing.JComboBox();
        lablegidelineprojectplanlist = new javax.swing.JLabel();
        btnProplanlistAddnew = new javax.swing.JButton();
        btnProplanlistAddPlanDetail = new javax.swing.JButton();
        btnProplanlistEdit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProjectplanlistview = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        menuprojectplanlist = new javax.swing.JInternalFrame();
        panelprojectplanlist = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelerrorprojectplanlistID = new javax.swing.JLabel();
        labelerrorprojectplanID = new javax.swing.JLabel();
        labelerrorstaffID = new javax.swing.JLabel();
        labelerrorprojectplan = new javax.swing.JLabel();
        labelerrorstartdate = new javax.swing.JLabel();
        labelerrorfinishdate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cboprojectplanIDFK = new javax.swing.JComboBox();
        cbostaffIDFK = new javax.swing.JComboBox();
        txtprojectplan = new javax.swing.JTextField();
        txtstartdate = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        txtfinishdate = new com.toedter.calendar.JDateChooser();
        txtstatus = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        btnviewProjectplanlist = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbprojectplanlist = new javax.swing.JTable();
        btnAddNewprojectplanlist = new javax.swing.JButton();
        btnupdateprojectplanlist = new javax.swing.JButton();
        txtstatus1 = new javax.swing.JTextField();
        menutableprojectplanlistdetail = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblistprojectplan = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbprojectlanlistdetail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddNewprojectplandetail = new javax.swing.JButton();
        btnViewprojectplandetail = new javax.swing.JButton();
        btnupdateprojectplandetail1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        paneladdprojectplandetail = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        menuaddprojectplandetail = new javax.swing.JInternalFrame();
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbar.setBackground(new java.awt.Color(255, 204, 102));
        panelbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lableshownamelogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lableshownamelogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        lableshownamelogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(153, 0, 255)));
        panelbar.add(lableshownamelogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1076, 0, 144, 33));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/building.png"))); // NOI18N
        jLabel15.setText("CONSTRUCTION SOFTWARE");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        panelbar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 329, 30));

        showlableonclickedmenu.setBackground(new java.awt.Color(51, 255, 102));
        showlableonclickedmenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        panelbar.add(showlableonclickedmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 94, 33));

        btnlogout.setBackground(new java.awt.Color(204, 204, 204));
        btnlogout.setText("LOGOUT");
        btnlogout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        btnlogout.setPreferredSize(new java.awt.Dimension(60, 30));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        panelbar.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 68, 30));

        getContentPane().add(panelbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 30));

        panelmenu.setBackground(new java.awt.Color(0, 153, 153));

        panelmenuhome.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuhomeMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuhomeMouseClicked(evt);
            }
        });

        panelclicked1.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked1.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked1Layout = new javax.swing.GroupLayout(panelclicked1);
        panelclicked1.setLayout(panelclicked1Layout);
        panelclicked1Layout.setHorizontalGroup(
            panelclicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked1Layout.setVerticalGroup(
            panelclicked1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        homemenulable.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        homemenulable.setForeground(new java.awt.Color(0, 102, 255));
        homemenulable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/homes.png"))); // NOI18N
        homemenulable.setText("   HOME");

        javax.swing.GroupLayout panelmenuhomeLayout = new javax.swing.GroupLayout(panelmenuhome);
        panelmenuhome.setLayout(panelmenuhomeLayout);
        panelmenuhomeLayout.setHorizontalGroup(
            panelmenuhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuhomeLayout.createSequentialGroup()
                .addComponent(panelclicked1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homemenulable, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        panelmenuhomeLayout.setVerticalGroup(
            panelmenuhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuhomeLayout.createSequentialGroup()
                .addGroup(panelmenuhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelclicked1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homemenulable))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelmenustaff.setBackground(new java.awt.Color(0, 204, 204));
        panelmenustaff.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenustaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenustaffMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenustaffMouseClicked(evt);
            }
        });

        panelclicked2.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked2.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked2Layout = new javax.swing.GroupLayout(panelclicked2);
        panelclicked2.setLayout(panelclicked2Layout);
        panelclicked2Layout.setHorizontalGroup(
            panelclicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked2Layout.setVerticalGroup(
            panelclicked2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        staffmenulable.setText("  STAFFS");
        staffmenulable.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenustaffLayout = new javax.swing.GroupLayout(panelmenustaff);
        panelmenustaff.setLayout(panelmenustaffLayout);
        panelmenustaffLayout.setHorizontalGroup(
            panelmenustaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenustaffLayout.createSequentialGroup()
                .addComponent(panelclicked2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenustaffLayout.setVerticalGroup(
            panelmenustaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        lablewelcome.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lablewelcome.setForeground(new java.awt.Color(102, 102, 255));
        lablewelcome.setText("           WELCOME");
        lablewelcome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        panelmenworker.setBackground(new java.awt.Color(0, 204, 204));
        panelmenworker.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenworker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenworkerMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenworkerMouseClicked(evt);
            }
        });

        panelclicked3.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked3.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked3Layout = new javax.swing.GroupLayout(panelclicked3);
        panelclicked3.setLayout(panelclicked3Layout);
        panelclicked3Layout.setHorizontalGroup(
            panelclicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked3Layout.setVerticalGroup(
            panelclicked3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable1.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/worker.png"))); // NOI18N
        staffmenulable1.setText("   WORKERS");
        staffmenulable1.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenworkerLayout = new javax.swing.GroupLayout(panelmenworker);
        panelmenworker.setLayout(panelmenworkerLayout);
        panelmenworkerLayout.setHorizontalGroup(
            panelmenworkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenworkerLayout.createSequentialGroup()
                .addComponent(panelclicked3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenworkerLayout.setVerticalGroup(
            panelmenworkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmencutomer.setBackground(new java.awt.Color(0, 204, 204));
        panelmencutomer.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmencutomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmencutomerMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmencutomerMouseClicked(evt);
            }
        });

        panelclicked4.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked4.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked4Layout = new javax.swing.GroupLayout(panelclicked4);
        panelclicked4.setLayout(panelclicked4Layout);
        panelclicked4Layout.setHorizontalGroup(
            panelclicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked4Layout.setVerticalGroup(
            panelclicked4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable2.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client1.png"))); // NOI18N
        staffmenulable2.setText("   CUSTOMERS");
        staffmenulable2.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmencutomerLayout = new javax.swing.GroupLayout(panelmencutomer);
        panelmencutomer.setLayout(panelmencutomerLayout);
        panelmencutomerLayout.setHorizontalGroup(
            panelmencutomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmencutomerLayout.createSequentialGroup()
                .addComponent(panelclicked4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmencutomerLayout.setVerticalGroup(
            panelmencutomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmensupplier.setBackground(new java.awt.Color(0, 204, 204));
        panelmensupplier.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmensupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmensupplierMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmensupplierMouseClicked(evt);
            }
        });

        panelclicked5.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked5.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked5Layout = new javax.swing.GroupLayout(panelclicked5);
        panelclicked5.setLayout(panelclicked5Layout);
        panelclicked5Layout.setHorizontalGroup(
            panelclicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked5Layout.setVerticalGroup(
            panelclicked5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable3.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier1.png"))); // NOI18N
        staffmenulable3.setText("   SUPPLIERS");
        staffmenulable3.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmensupplierLayout = new javax.swing.GroupLayout(panelmensupplier);
        panelmensupplier.setLayout(panelmensupplierLayout);
        panelmensupplierLayout.setHorizontalGroup(
            panelmensupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmensupplierLayout.createSequentialGroup()
                .addComponent(panelclicked5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmensupplierLayout.setVerticalGroup(
            panelmensupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenuprojectplan.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuprojectplan.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenuprojectplan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuprojectplanMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuprojectplanMouseClicked(evt);
            }
        });

        panelclicked7.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked7.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked7Layout = new javax.swing.GroupLayout(panelclicked7);
        panelclicked7.setLayout(panelclicked7Layout);
        panelclicked7Layout.setHorizontalGroup(
            panelclicked7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked7Layout.setVerticalGroup(
            panelclicked7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable5.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier1.png"))); // NOI18N
        staffmenulable5.setText("   PROJECT PLAN");
        staffmenulable5.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenuprojectplanLayout = new javax.swing.GroupLayout(panelmenuprojectplan);
        panelmenuprojectplan.setLayout(panelmenuprojectplanLayout);
        panelmenuprojectplanLayout.setHorizontalGroup(
            panelmenuprojectplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuprojectplanLayout.createSequentialGroup()
                .addComponent(panelclicked7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenuprojectplanLayout.setVerticalGroup(
            panelmenuprojectplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenprojectplanlist.setBackground(new java.awt.Color(0, 204, 204));
        panelmenprojectplanlist.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenprojectplanlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlistMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlistMouseClicked(evt);
            }
        });

        panelclicked8.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked8.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked8Layout = new javax.swing.GroupLayout(panelclicked8);
        panelclicked8.setLayout(panelclicked8Layout);
        panelclicked8Layout.setHorizontalGroup(
            panelclicked8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked8Layout.setVerticalGroup(
            panelclicked8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable6.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier1.png"))); // NOI18N
        staffmenulable6.setText("   PROJECT PLAN LIST");
        staffmenulable6.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenprojectplanlistLayout = new javax.swing.GroupLayout(panelmenprojectplanlist);
        panelmenprojectplanlist.setLayout(panelmenprojectplanlistLayout);
        panelmenprojectplanlistLayout.setHorizontalGroup(
            panelmenprojectplanlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenprojectplanlistLayout.createSequentialGroup()
                .addComponent(panelclicked8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelmenprojectplanlistLayout.setVerticalGroup(
            panelmenprojectplanlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenuuser.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuuser.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenuuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuuserMouseClicked(evt);
            }
        });

        panelclicked6.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked6.setPreferredSize(new java.awt.Dimension(5, 38));
        panelclicked6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelclicked6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelclicked6Layout = new javax.swing.GroupLayout(panelclicked6);
        panelclicked6.setLayout(panelclicked6Layout);
        panelclicked6Layout.setHorizontalGroup(
            panelclicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked6Layout.setVerticalGroup(
            panelclicked6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable4.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client1.png"))); // NOI18N
        staffmenulable4.setText("   USER");
        staffmenulable4.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenuuserLayout = new javax.swing.GroupLayout(panelmenuuser);
        panelmenuuser.setLayout(panelmenuuserLayout);
        panelmenuuserLayout.setHorizontalGroup(
            panelmenuuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuuserLayout.createSequentialGroup()
                .addComponent(panelclicked6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenuuserLayout.setVerticalGroup(
            panelmenuuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelmenustaff, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenworker, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmencutomer, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmensupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenuuser, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenuprojectplan, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenustaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenworker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmencutomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmensupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenuprojectplan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(panelmenuuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );

        getContentPane().add(panelmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 700));

        DesktopPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuhome.setVisible(false);
        menuhome.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelhome.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setText("                          CONSTRUCTION MANAGEMENT SYSTEM");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        panelproject.setBackground(new java.awt.Color(255, 255, 255));
        panelproject.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        labelproject.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelproject.setForeground(new java.awt.Color(102, 102, 255));
        labelproject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/project.png"))); // NOI18N
        labelproject.setText("       PROJECTS");
        labelproject.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalproject.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalproject.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalproject.setText("10");

        javax.swing.GroupLayout panelprojectLayout = new javax.swing.GroupLayout(panelproject);
        panelproject.setLayout(panelprojectLayout);
        panelprojectLayout.setHorizontalGroup(
            panelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprojectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelproject, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelprojectLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltotalproject, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        panelprojectLayout.setVerticalGroup(
            panelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprojectLayout.createSequentialGroup()
                .addComponent(labelproject, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltotalproject, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        panelcustomer.setBackground(new java.awt.Color(255, 255, 255));
        panelcustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
        panelcustomer.setPreferredSize(new java.awt.Dimension(215, 92));

        labelclient.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelclient.setForeground(new java.awt.Color(102, 102, 255));
        labelclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client.png"))); // NOI18N
        labelclient.setText("       CUSTOMERS");
        labelclient.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalclient.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalclient.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalclient.setText("10");

        javax.swing.GroupLayout panelcustomerLayout = new javax.swing.GroupLayout(panelcustomer);
        panelcustomer.setLayout(panelcustomerLayout);
        panelcustomerLayout.setHorizontalGroup(
            panelcustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelclient, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltotalclient, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        panelcustomerLayout.setVerticalGroup(
            panelcustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcustomerLayout.createSequentialGroup()
                .addComponent(labelclient, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(labeltotalclient, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelstaff.setBackground(new java.awt.Color(255, 255, 255));
        panelstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
        panelstaff.setPreferredSize(new java.awt.Dimension(215, 92));

        labelstaff.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelstaff.setForeground(new java.awt.Color(102, 102, 255));
        labelstaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff1.png"))); // NOI18N
        labelstaff.setText("       STAFF");
        labelstaff.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalstaff.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalstaff.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalstaff.setText("10");

        javax.swing.GroupLayout panelstaffLayout = new javax.swing.GroupLayout(panelstaff);
        panelstaff.setLayout(panelstaffLayout);
        panelstaffLayout.setHorizontalGroup(
            panelstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelstaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelstaff, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelstaffLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltotalstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        panelstaffLayout.setVerticalGroup(
            panelstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffLayout.createSequentialGroup()
                .addComponent(labelstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltotalstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        panelsuppliers.setBackground(new java.awt.Color(255, 255, 255));
        panelsuppliers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
        panelsuppliers.setPreferredSize(new java.awt.Dimension(215, 95));

        labelsuppliers.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelsuppliers.setForeground(new java.awt.Color(102, 102, 255));
        labelsuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier.png"))); // NOI18N
        labelsuppliers.setText("     SUPPLIERS");
        labelsuppliers.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalsuppliers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalsuppliers.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalsuppliers.setText("10");

        javax.swing.GroupLayout panelsuppliersLayout = new javax.swing.GroupLayout(panelsuppliers);
        panelsuppliers.setLayout(panelsuppliersLayout);
        panelsuppliersLayout.setHorizontalGroup(
            panelsuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelsuppliersLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(labeltotalsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelsuppliersLayout.setVerticalGroup(
            panelsuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuppliersLayout.createSequentialGroup()
                .addComponent(labelsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltotalsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/project.png"))); // NOI18N
        jLabel10.setText("     SUPPLIERS");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("10");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/project.png"))); // NOI18N
        jLabel12.setText("     SUPPLIERS");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setText("10");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelhomeLayout = new javax.swing.GroupLayout(panelhome);
        panelhome.setLayout(panelhomeLayout);
        panelhomeLayout.setHorizontalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelhomeLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelcustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                        .addGap(102, 102, 102)
                        .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelstaff, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelhomeLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelhomeLayout.setVerticalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap(303, Short.MAX_VALUE))
        );

        menuhome.getContentPane().add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1050, 750));

        DesktopPane.add(menuhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menutablestaff.setVisible(false);
        menutablestaff.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltablestaff.setBackground(new java.awt.Color(255, 255, 255));
        paneltablestaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbstaffview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbstaffview);

        paneltablestaff.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        labelgidelineoftalestaff.setBackground(new java.awt.Color(255, 0, 51));
        labelgidelineoftalestaff.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        paneltablestaff.add(labelgidelineoftalestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnopenmenustaffaddnew.setBackground(new java.awt.Color(0, 153, 153));
        btnopenmenustaffaddnew.setForeground(new java.awt.Color(255, 255, 255));
        btnopenmenustaffaddnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnopenmenustaffaddnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnopenmenustaffaddnewMouseClicked(evt);
            }
        });
        paneltablestaff.add(btnopenmenustaffaddnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        paneltablestaff.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff.setText("Edit");
        btnEdittablestaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaffMouseClicked(evt);
            }
        });
        paneltablestaff.add(btnEdittablestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setText("Search");
        paneltablestaff.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        menutablestaff.getContentPane().add(paneltablestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(menutablestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menustaff.setVisible(false);
        menustaff.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu.setBackground(new java.awt.Color(255, 255, 255));

        labelgidelineofmenustaff.setAlignmentX(0.5F);
        labelgidelineofmenustaff.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStaffMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbStaff);

        panelstaffinfomation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtstaffID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtstaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 230, 29));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Gender");
        panelstaffinfomation.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, 20));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Nationality");
        panelstaffinfomation.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        txtStaffName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 29));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Birthday");
        panelstaffinfomation.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Hired Date");
        panelstaffinfomation.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 20));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Salary");
        panelstaffinfomation.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 50, 20));

        txtStaffSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 250, 29));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Phone");
        panelstaffinfomation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 80, 20));

        txtStaffPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 250, 29));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Address");
        panelstaffinfomation.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, 20));

        txtStaffAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 850, 29));

        txtStaffBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffBirthday.setDateFormatString("yyyy-mm-dd");
        panelstaffinfomation.add(txtStaffBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 29));

        txtStaffHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffHiredDate.setDateFormatString("yyyy-mm-dd");
        panelstaffinfomation.add(txtStaffHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 29));

        cboStaffGender.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Male", "Female" }));
        cboStaffGender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboStaffGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 230, 29));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Status");
        panelstaffinfomation.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 60, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Staff Name");
        panelstaffinfomation.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 20));

        labelpictureStaff.setText("         Photo");
        labelpictureStaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        panelstaffinfomation.add(labelpictureStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 120, 120));

        cboStaffStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Working", "Stoped" }));
        cboStaffStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboStaffStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 230, 29));

        btnStaffNew.setBackground(new java.awt.Color(0, 153, 153));
        btnStaffNew.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffNew.setText("New");
        btnStaffNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffNewMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 90, 30));

        btnStaffUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnStaffUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffUpdate.setText("Update");
        btnStaffUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, 30));

        btnStaffCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnStaffCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffCancel.setText("Cancel");
        btnStaffCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 90, 30));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("Staff ID");
        panelstaffinfomation.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 20));

        btnStaffChoosepicture.setText("Choose Photo");
        btnStaffChoosepicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffChoosepictureMouseClicked(evt);
            }
        });
        btnStaffChoosepicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffChoosepictureActionPerformed(evt);
            }
        });
        panelstaffinfomation.add(btnStaffChoosepicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 120, 20));
        panelstaffinfomation.add(labelmessagestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 210, 20));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setText("Role ID");
        panelstaffinfomation.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, 20));

        cboStaffroleID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffroleID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cboStaffroleID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboStaffroleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 230, 29));

        txtStaffNationlity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffNationlity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 230, 29));

        labelstaffroleidrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffroleidrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffroleidrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 190, 20));

        labelstaffNamerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffNamerequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation.add(labelstaffNamerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 190, 20));

        labelstaffidrequired.setBackground(new java.awt.Color(255, 255, 255));
        labelstaffidrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffidrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffidrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 190, 20));

        labelstaffgenderrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffgenderrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffgenderrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 190, 20));

        labelstaffnatrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffnatrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffnatrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 190, 20));

        labelstaffbirthrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffbirthrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffbirthrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 190, 20));

        labelstaffhirdrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffhirdrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffhirdrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 190, 20));

        labelstaffsarequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffsarequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffsarequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 190, 20));

        labelstaffphonerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffphonerequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffphonerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 190, 20));

        labelstaffaddrerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffaddrerequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffaddrerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 190, 20));

        labelstaffstaturequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffstaturequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffstaturequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 190, 20));

        javax.swing.GroupLayout panelstaffmenuLayout = new javax.swing.GroupLayout(panelstaffmenu);
        panelstaffmenu.setLayout(panelstaffmenuLayout);
        panelstaffmenuLayout.setHorizontalGroup(
            panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelgidelineofmenustaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panelstaffmenuLayout.setVerticalGroup(
            panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenuLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenustaff, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        menustaff.getContentPane().add(panelstaffmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menustaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuworker.setVisible(false);
        menuworker.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelworker.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuworker.getContentPane().add(panelworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 710));

        DesktopPane.add(menuworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuuser.setVisible(false);
        menuuser.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelcreateuser.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(java.awt.SystemColor.window);
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setText("Search by name :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 30));

        cboSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cboSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel1.add(cboSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 160, 30));

        tbviewuser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbviewuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbviewuser.setRowHeight(20);
        tbviewuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbviewuserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbviewuser);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 290, 360));

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel25.setText("User ID");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 102, 20));

        txtuserID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtuserID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel1.add(txtuserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 200, 30));

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel26.setText("Staff Name");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 102, 20));

        cbostaffName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbostaffName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cbostaffName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cbostaffName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbostaffNameItemStateChanged(evt);
            }
        });
        jPanel1.add(cbostaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 197, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setText("User Name");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 102, -1));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 197, 30));

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel28.setText("Position");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 102, 20));

        cboposition.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cboposition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "IT", "Manager", "Admin", "Staff" }));
        cboposition.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboposition.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbopositionItemStateChanged(evt);
            }
        });
        jPanel1.add(cboposition, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 197, 30));

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel29.setText("Password");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 102, 20));

        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 197, 30));

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel30.setText("Confirm Password");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 140, 20));

        txtconfirmpassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtconfirmpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtconfirmpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconfirmpasswordKeyReleased(evt);
            }
        });
        jPanel1.add(txtconfirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 197, 30));

        btnCreate.setBackground(new java.awt.Color(0, 153, 153));
        btnCreate.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 104, 31));

        btnUpdate1.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdate1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 98, 31));

        btnsignin.setBackground(new java.awt.Color(0, 153, 153));
        btnsignin.setForeground(new java.awt.Color(255, 255, 255));
        btnsignin.setText("Sign In");
        btnsignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsigninMouseClicked(evt);
            }
        });
        jPanel1.add(btnsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 92, 31));

        staffnamerror.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        staffnamerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(staffnamerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 150, 20));

        usernameerror.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        usernameerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(usernameerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 20));

        positionerror.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        positionerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(positionerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 150, 20));

        passworderror.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        passworderror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(passworderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 140, 20));

        conpassworderror.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        conpassworderror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(conpassworderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 20));

        sucessfulllable.setForeground(new java.awt.Color(0, 204, 51));
        jPanel1.add(sucessfulllable, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 220, 20));

        btnCancel2.setBackground(new java.awt.Color(0, 153, 153));
        btnCancel2.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel2.setText("Cancel");
        jPanel1.add(btnCancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 92, 31));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("                                                              CREATE NEW USER ACCOUNT");
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        jLabel31.setText("User Information");

        javax.swing.GroupLayout panelcreateuserLayout = new javax.swing.GroupLayout(panelcreateuser);
        panelcreateuser.setLayout(panelcreateuserLayout);
        panelcreateuserLayout.setHorizontalGroup(
            panelcreateuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcreateuserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelcreateuserLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(panelcreateuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelcreateuserLayout.setVerticalGroup(
            panelcreateuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcreateuserLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        menuuser.getContentPane().add(panelcreateuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1040, 730));

        DesktopPane.add(menuuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menutableprojectplanlist.setVisible(false);
        menutableprojectplanlist.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltableprojectplanlist.setBackground(new java.awt.Color(255, 255, 255));
        paneltableprojectplanlist.setPreferredSize(new java.awt.Dimension(1050, 740));
        paneltableprojectplanlist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboProplanlistsearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        paneltableprojectplanlist.add(cboProplanlistsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 870, 30));

        lablegidelineprojectplanlist.setText("PROJECTPLANLIST / VIEW");
        lablegidelineprojectplanlist.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        paneltableprojectplanlist.add(lablegidelineprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1000, 20));

        btnProplanlistAddnew.setBackground(new java.awt.Color(0, 153, 153));
        btnProplanlistAddnew.setForeground(new java.awt.Color(255, 255, 255));
        btnProplanlistAddnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnProplanlistAddnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProplanlistAddnewMouseClicked(evt);
            }
        });
        paneltableprojectplanlist.add(btnProplanlistAddnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 40, 30));

        btnProplanlistAddPlanDetail.setBackground(new java.awt.Color(0, 153, 153));
        btnProplanlistAddPlanDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnProplanlistAddPlanDetail.setText("Add Plan Detail");
        btnProplanlistAddPlanDetail.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnProplanlistAddPlanDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProplanlistAddPlanDetailMouseClicked(evt);
            }
        });
        paneltableprojectplanlist.add(btnProplanlistAddPlanDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, 130, 30));

        btnProplanlistEdit.setBackground(new java.awt.Color(0, 153, 153));
        btnProplanlistEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnProplanlistEdit.setText("Edit");
        paneltableprojectplanlist.add(btnProplanlistEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 690, 130, 30));

        tbProjectplanlistview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dd", "dd", "dd", "dd", "dd",  new Boolean(true)}
            },
            new String [] {
                "ProjectPlanListID", "ProjectPlanID", "StaffID", "Start Date", "Finish Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbProjectplanlistview.setRowHeight(20);
        jScrollPane4.setViewportView(tbProjectplanlistview);

        paneltableprojectplanlist.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1010, 570));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setText("Search");
        paneltableprojectplanlist.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 30));

        menutableprojectplanlist.getContentPane().add(paneltableprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1050, 760));

        DesktopPane.add(menutableprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuprojectplanlist.setVisible(false);
        menuprojectplanlist.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelprojectplanlist.setBackground(new java.awt.Color(255, 255, 255));
        panelprojectplanlist.setPreferredSize(new java.awt.Dimension(1050, 740));
        panelprojectplanlist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("PROJECTPLANLIST / ADD NEW");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelprojectplanlist.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1010, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelerrorprojectplanlistID.setText("jLabel3");
        jPanel2.add(labelerrorprojectplanlistID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 20));

        labelerrorprojectplanID.setText("jLabel3");
        jPanel2.add(labelerrorprojectplanID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, 20));

        labelerrorstaffID.setText("jLabel3");
        jPanel2.add(labelerrorstaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 200, 20));

        labelerrorprojectplan.setText("jLabel3");
        jPanel2.add(labelerrorprojectplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 200, 20));

        labelerrorstartdate.setText("jLabel3");
        jPanel2.add(labelerrorstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 200, 20));

        labelerrorfinishdate.setText("jLabel3");
        jPanel2.add(labelerrorfinishdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 200, 20));

        jLabel14.setText("ProjectPlanList ID");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 20));

        jLabel16.setText("ProjectPlan ID");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 20));

        jLabel34.setText("Project Plan");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 200, 20));

        jLabel32.setText("Staff ID");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 200, 20));

        jLabel38.setText("Finish Date");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 200, 20));

        jLabel40.setText("Status");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 200, 20));

        cboprojectplanIDFK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboprojectplanIDFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 250, 30));

        cbostaffIDFK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbostaffIDFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 250, 30));

        txtprojectplan.setText("jTextField1");
        jPanel2.add(txtprojectplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 250, 30));

        txtstartdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel2.add(txtstartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 250, 29));

        jLabel36.setText("Start Date");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 200, 20));

        txtfinishdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel2.add(txtfinishdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 250, 29));

        txtstatus.setText("jTextField1");
        jPanel2.add(txtstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 250, 30));

        jLabel41.setText("jLabel3");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 200, 20));

        btnviewProjectplanlist.setBackground(new java.awt.Color(0, 153, 153));
        btnviewProjectplanlist.setForeground(new java.awt.Color(255, 255, 255));
        btnviewProjectplanlist.setText("View");
        btnviewProjectplanlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnviewProjectplanlistMouseClicked(evt);
            }
        });
        jPanel2.add(btnviewProjectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 90, 30));

        tbprojectplanlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbprojectplanlist);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 990, 300));

        btnAddNewprojectplanlist.setBackground(new java.awt.Color(0, 153, 153));
        btnAddNewprojectplanlist.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewprojectplanlist.setText("Add");
        jPanel2.add(btnAddNewprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 90, 30));

        btnupdateprojectplanlist.setBackground(new java.awt.Color(0, 153, 153));
        btnupdateprojectplanlist.setForeground(new java.awt.Color(255, 255, 255));
        btnupdateprojectplanlist.setText("Update");
        jPanel2.add(btnupdateprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 90, 30));

        txtstatus1.setText("jTextField1");
        jPanel2.add(txtstatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 250, 30));

        panelprojectplanlist.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1010, 650));

        menuprojectplanlist.getContentPane().add(panelprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, -1));

        DesktopPane.add(menuprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menutableprojectplanlistdetail.setVisible(false);
        menutableprojectplanlistdetail.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1050, 740));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblistprojectplan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Projectplan Name", "Date", "Status"
            }
        ));
        jScrollPane7.setViewportView(tblistprojectplan);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 530, 610));

        tbprojectlanlistdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "N", "Project plan list Detail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbprojectlanlistdetail.setMinimumSize(new java.awt.Dimension(10, 64));
        jScrollPane6.setViewportView(tbprojectlanlistdetail);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 360, 610));

        jLabel3.setText("PROJECTPLANLIST / PLAN LIST DETAIL");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1000, 20));

        btnAddNewprojectplandetail.setBackground(new java.awt.Color(0, 153, 153));
        btnAddNewprojectplandetail.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewprojectplandetail.setText("Add New");
        btnAddNewprojectplandetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNewprojectplandetailMouseClicked(evt);
            }
        });
        jPanel3.add(btnAddNewprojectplandetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 100, 30));

        btnViewprojectplandetail.setBackground(new java.awt.Color(0, 153, 153));
        btnViewprojectplandetail.setForeground(new java.awt.Color(255, 255, 255));
        btnViewprojectplandetail.setText("View");
        btnViewprojectplandetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewprojectplandetailMouseClicked(evt);
            }
        });
        jPanel3.add(btnViewprojectplandetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 100, 30));

        btnupdateprojectplandetail1.setBackground(new java.awt.Color(0, 153, 153));
        btnupdateprojectplandetail1.setForeground(new java.awt.Color(255, 255, 255));
        btnupdateprojectplandetail1.setText("Update");
        jPanel3.add(btnupdateprojectplandetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 100, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 460, 30));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setText("Search");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 30));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jTextField2.setText("jTextField2");
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 49, 360, 30));

        menutableprojectplanlistdetail.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 710));

        DesktopPane.add(menutableprojectplanlistdetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        paneladdprojectplandetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setText("Add Plan Detail");
        paneladdprojectplandetail.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 20));

        jTextField1.setText("jTextField1");
        paneladdprojectplandetail.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 450, 30));

        jButton1.setText("Cancel");
        paneladdprojectplandetail.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 90, -1));

        jButton3.setText("Update");
        paneladdprojectplandetail.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 90, -1));

        jButton4.setText("Add");
        paneladdprojectplandetail.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 100, -1));

        DesktopPane.add(paneladdprojectplandetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        menuaddprojectplandetail.setVisible(false);

        javax.swing.GroupLayout menuaddprojectplandetailLayout = new javax.swing.GroupLayout(menuaddprojectplandetail.getContentPane());
        menuaddprojectplandetail.getContentPane().setLayout(menuaddprojectplandetailLayout);
        menuaddprojectplandetailLayout.setHorizontalGroup(
            menuaddprojectplandetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        menuaddprojectplandetailLayout.setVerticalGroup(
            menuaddprojectplandetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        DesktopPane.add(menuaddprojectplandetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        DesktopPane.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        getContentPane().add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 1040, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
       int x,y;
    private void panelmenuhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMousePressed
        panelclicked1.setBackground(panelclick);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmenuhomeMousePressed

    private void panelmenuhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMouseClicked
        
        menustaff.setVisible(false);
        menutablestaff.setVisible(false);
        menuuser.setVisible(false);
        menuworker.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuhome.setVisible(true);
        
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("HOME");
    }//GEN-LAST:event_panelmenuhomeMouseClicked

    private void panelmenustaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMouseClicked

        menuhome.setVisible(false);
        menutablestaff.setVisible(false);
        menuuser.setVisible(false);
        menuworker.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(true);
        
        showlableonclickedmenu.setText("");
        //showlableonclickedmenu.setText("STAFF");
        labelgidelineoftalestaff.setText("EMPLOYEE / STAFF / VIEW");
        getroleIDNrefreshtablestaff();
    }//GEN-LAST:event_panelmenustaffMouseClicked

    private void panelmenustaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(panelclick);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmenustaffMousePressed

    private void panelmenworkerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(panelclick);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmenworkerMousePressed

    private void panelmenworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMouseClicked
        
        menuhome.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuworker.setVisible(true);
        
    }//GEN-LAST:event_panelmenworkerMouseClicked

    private void panelmencutomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmencutomerMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(panelclick);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmencutomerMousePressed

    private void panelmencutomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmencutomerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmencutomerMouseClicked

    private void panelmensupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmensupplierMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(panelclick);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmensupplierMousePressed

    private void panelmensupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmensupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmensupplierMouseClicked

    private void tbviewuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbviewuserMouseClicked
        try {
            int i = tbviewuser.getSelectedRow();
            TableModel tm = tbviewuser.getModel();
            txtuserID.setText(tm.getValueAt(i, 0).toString());
            String viewtxtquery = "select * from tbUser where id=?";
            PreparedStatement tmpst = con.prepareStatement(viewtxtquery);
            tmpst.setString(1, txtuserID.getText().trim());
            ResultSet rsLL = tmpst.executeQuery();
            if (rsLL.next()) {
                cbostaffName.setSelectedItem(rsLL.getString(2));
                txtUsername.setText(rsLL.getString(3));
                cboposition.setSelectedItem(rsLL.getString(4));
                txtpassword.setText(rsLL.getString(5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbviewuserMouseClicked

    private void cbostaffNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbostaffNameItemStateChanged
        staffnamerror.setText("");
    }//GEN-LAST:event_cbostaffNameItemStateChanged

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        usernameerror.setText("");
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void cbopositionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbopositionItemStateChanged
        positionerror.setText("");
    }//GEN-LAST:event_cbopositionItemStateChanged

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        passworderror.setText("");
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void txtconfirmpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconfirmpasswordKeyReleased
        conpassworderror.setText("");
    }//GEN-LAST:event_txtconfirmpasswordKeyReleased

    public void cbogetstaffname(){
        try{
            Statement stat = con.createStatement();
            String selectstaffname = "select name from tbStaff";
            PreparedStatement mpst = con.prepareStatement(selectstaffname);
            ResultSet rsl = mpst.executeQuery();
            while (rsl.next()){
                cbostaffName.addItem(rsl.getString(1));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        try {
            Statement stat = con.createStatement();
            String selectquery = "Select * from tbUser where username='" + txtUsername.getText().trim() + "'";
            ResultSet rs = stat.executeQuery(selectquery);
            if (rs.next() == true) {
                System.out.println("username" + rs);
                sucessfulllable.setText("User Created Already.");
            } else {
                String query = "insert into tbUser(staff_name,username,position,password)values(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                // pst.setString(1, txtuserID.getText().trim());
                pst.setString(1, cbostaffName.getSelectedItem().toString());
                pst.setString(2, txtUsername.getText().trim());
                pst.setString(3, cboposition.getSelectedItem().toString());
                pst.setString(4, txtpassword.getText().trim());
                //pst.setString(6,txtconfirmpassword.getText().trim());
                if (cbostaffName.getSelectedItem() == "None"  && txtUsername.getText().trim().isEmpty() && cboposition.getSelectedItem() == "None" && txtpassword.getText().trim().isEmpty() && txtconfirmpassword.getText().trim().isEmpty()) {
                    staffnamerror.setText("Required.");
                    usernameerror.setText("Require.d");
                    positionerror.setText("Required.");
                    passworderror.setText("Required.");
                    conpassworderror.setText("Required.");
                    txtuserID.requestFocus();
                } 
                else if (cbostaffName.getSelectedItem() == "None"){
                    staffnamerror.setText("Required.");
                    cbostaffName.requestFocus();
                }
                else if (txtUsername.getText().trim().isEmpty()){
                    usernameerror.setText("Required");
                    txtUsername.requestFocus();
                }
                else if (txtpassword.getText().trim().isEmpty()){
                    passworderror.setText("Required.");
                    txtpassword.requestFocus();
                }
                else if (cboposition.getSelectedItem() == "None"){
                    positionerror.setText("Required");
                    cboposition.requestFocus();
                }
                else if (txtconfirmpassword.getText().trim().isEmpty()){
                    conpassworderror.setText("Required");
                    txtconfirmpassword.requestFocus();
                }
                else {
                    pst.executeUpdate();
                    cbostaffName.setSelectedItem("None");
                    txtUsername.setText("");
                    cboposition.setSelectedItem("None");
                    txtpassword.setText("");
                    txtconfirmpassword.setText("");
                    sucessfulllable.setText("Create user sucessfully.");
                    refreshtable();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        int i = tbviewuser.getSelectedRow();
        try{
            String value=(tbviewuser.getModel().getValueAt(i, 0).toString());
            String updatequery = "update tbUser SET staff_name=?, username=?, position=?,password=? where id="+value;
            PreparedStatement psu = con.prepareStatement(updatequery);
            //psu.setString(1,txtuserID.getText().trim());
            psu.setString(1, cbostaffName.getSelectedItem().toString());
            psu.setString(2, txtUsername.getText().trim());
            psu.setString(3, cboposition.getSelectedItem().toString());
            psu.setString(4, txtpassword.getText().trim());

//            if ( cbostaffName.getSelectedItem().)
//            Statement stat = con.createStatement();
//            String selectquery = "Select * from tbUser where username='" + txtUsername.getText().trim() + "'";
//            ResultSet rs = stat.executeQuery(selectquery);
            psu.executeUpdate();
            refreshtable();
            txtuserID.setText("");
            cbostaffName.setSelectedItem("None");
            txtUsername.setText("");
            cboposition.setSelectedItem("None");
            txtpassword.setText("");
            txtconfirmpassword.setText("");
            JOptionPane.showMessageDialog(null, "update sucessfully.");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void panelmenuuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuuserMouseClicked
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menuhome.setVisible(false);
        menuuser.setVisible(true);
    }//GEN-LAST:event_panelmenuuserMouseClicked

    private void panelclicked6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelclicked6MousePressed
        panelclicked6.setBackground(panelclick);
    }//GEN-LAST:event_panelclicked6MousePressed

    private void btnsigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsigninMouseClicked
        SignIn si = new SignIn();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnsigninMouseClicked

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        SignIn si = new SignIn();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void btnStaffChoosepictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffChoosepictureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStaffChoosepictureActionPerformed

    private void btnopenmenustaffaddnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnopenmenustaffaddnewMouseClicked
        menuhome.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(true);
        labelgidelineofmenustaff.setText("EMPLOYEE / STAFF / ADD NEW ");
    }//GEN-LAST:event_btnopenmenustaffaddnewMouseClicked

    private void btnStaffCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffCancelMouseClicked
        menuhome.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(true);
        labelgidelineoftalestaff.setText("EMPLOYEE / STAFF / VIEW");
        getroleIDNrefreshtablestaff();
    }//GEN-LAST:event_btnStaffCancelMouseClicked

    private void btnEdittablestaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaffMouseClicked
        menutablestaff.setVisible(false);
        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menustaff.setVisible(true);
        labelgidelineofmenustaff.setText("");
        labelgidelineofmenustaff.setText("EMPLOYEE / STAFF / EDIT");
    }//GEN-LAST:event_btnEdittablestaffMouseClicked

    private void panelmenuprojectplanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuprojectplanMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(panelclick);
        panelclicked8.setBackground(paneldefault);
    }//GEN-LAST:event_panelmenuprojectplanMousePressed

    private void panelmenuprojectplanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuprojectplanMouseClicked
        
        menuhome.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(false);
        menuuser.setVisible(false);
        menuworker.setVisible(false);
        menutableprojectplanlist.setVisible(false);
    }//GEN-LAST:event_panelmenuprojectplanMouseClicked

    private void panelmenprojectplanlistMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlistMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(panelclick);
    }//GEN-LAST:event_panelmenprojectplanlistMousePressed

    private void panelmenprojectplanlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlistMouseClicked

        menuhome.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(false);
        menuuser.setVisible(false);
        menuworker.setVisible(false);
        menutableprojectplanlist.setVisible(true);
    }//GEN-LAST:event_panelmenprojectplanlistMouseClicked

    private void btnviewProjectplanlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewProjectplanlistMouseClicked
        menuprojectplanlist.setVisible(false);    
        menutableprojectplanlist.setVisible(true);  
    }//GEN-LAST:event_btnviewProjectplanlistMouseClicked

    private void btnProplanlistAddnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProplanlistAddnewMouseClicked
        menutableprojectplanlist.setVisible(false);
        menuprojectplanlist.setVisible(true);
    }//GEN-LAST:event_btnProplanlistAddnewMouseClicked

    private void btnProplanlistAddPlanDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProplanlistAddPlanDetailMouseClicked
        menutableprojectplanlist.setVisible(false);
        menutableprojectplanlistdetail.setVisible(true);
    }//GEN-LAST:event_btnProplanlistAddPlanDetailMouseClicked

    private void btnViewprojectplandetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewprojectplandetailMouseClicked
        menutableprojectplanlistdetail.setVisible(false);
        menutableprojectplanlist.setVisible(true);
    }//GEN-LAST:event_btnViewprojectplandetailMouseClicked

    private void btnAddNewprojectplandetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewprojectplandetailMouseClicked
        paneladdprojectplandetail.setVisible(true);
    }//GEN-LAST:event_btnAddNewprojectplandetailMouseClicked

    public void getroleIDNrefreshtablestaff(){
        
        txtstaffID.setText("");
        txtStaffName.setText("");
        cboStaffGender.setSelectedItem("None");
        txtStaffNationlity.setText("");
        txtStaffBirthday.setDate(null);
        txtStaffHiredDate.setDate(null);
        txtStaffSalary.setText("");
        txtStaffPhone.setText("");
        txtStaffAddress.setText("");
        cboStaffroleID.setSelectedItem("None");
        cboStaffStatus.setSelectedItem("None");
        labelpictureStaff.removeAll();
                
        try{
            //Statement stat = con.createStatement();
            
            //getroleID
            String selectroleid = "select id from tbRole";
            PreparedStatement pss = con.prepareStatement(selectroleid);
            ResultSet rsl = pss.executeQuery();
            while (rsl.next()){
                cboStaffroleID.addItem(rsl.getString(1));
            }
            
            //refreshtablestaff
            String selectalltbStaff = "select * from tbStaff";
            PreparedStatement pst = con.prepareStatement(selectalltbStaff);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbStaff.setModel(model);
            tbstaffview.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Gender");
            model.addColumn("Nationality");
            model.addColumn("Birthday");
            model.addColumn("Hired Date");
            model.addColumn("Salary");
            model.addColumn("Phone Number");
            model.addColumn("Address");
            model.addColumn("Role ID");
            model.addColumn("Status");
                                    
            while (rst.next()){
                model.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),
                            rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(11),
                            rst.getString(12)});
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void btnStaffNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffNewMouseClicked
        
        if (txtStaffName.getText().trim().isEmpty() && cboStaffGender.getSelectedItem() == "None" && txtStaffNationlity.getText().trim().isEmpty() &&
                txtStaffBirthday.getDate() == null && txtStaffHiredDate.getDate() == null && txtStaffSalary.getText().trim().isEmpty() && 
                txtStaffPhone.getText().trim().isEmpty() && txtStaffAddress.getText().trim().isEmpty() && cboStaffroleID.getSelectedItem() == "None" &&
                cboStaffStatus.getSelectedItem() == "None" ){
            
            labelstaffNamerequired.setText("required.");
            labelstaffgenderrequired.setText("required.");
            labelstaffnatrequired.setText("required.");
            labelstaffbirthrequired.setText("required.");
            labelstaffhirdrequired.setText("required.");
            labelstaffsarequired.setText("required.");
            labelstaffphonerequired.setText("required.");
            labelstaffaddrerequired.setText("required.");
            labelstaffroleidrequired.setText("required.");
            labelstaffstaturequired.setText("required.");
            txtStaffName.requestFocus();            
        }
                
        else if (txtStaffName.getText().trim().isEmpty() ){
            labelstaffNamerequired.setText("required.");
            txtStaffName.requestFocus();
        }             
        else if (cboStaffGender.getSelectedItem() == "None"){
            labelstaffgenderrequired.setText("required.");
            cboStaffGender.requestFocus();
            }
        else if (txtStaffNationlity.getText().trim().isEmpty()){
            labelstaffnatrequired.setText("required.");
            txtStaffNationlity.requestFocus();
            }
        else if (txtStaffBirthday.getDate() == null){
            labelstaffbirthrequired.setText("required.");
            txtStaffBirthday.requestFocus();
        }
        else if (txtStaffHiredDate.getDate() == null){
            labelstaffhirdrequired.setText("required.");
            txtStaffHiredDate.requestFocus();
        }
        else if (txtStaffSalary.getText().trim().isEmpty()){
            labelstaffsarequired.setText("required.");
            txtStaffSalary.requestFocus();
        }
        else if (txtStaffPhone.getText().trim().isEmpty()){
            labelstaffphonerequired.setText("required.");
            txtStaffPhone.requestFocus();
        }
        else if (txtStaffAddress.getText().trim().isEmpty()){
            labelstaffaddrerequired.setText("required.");
            txtStaffAddress.requestFocus();
        }
        else if (cboStaffroleID.getSelectedItem() == "None"){
            labelstaffroleidrequired.setText("required.");
            cboStaffroleID.requestFocus();
        }
        else if(cboStaffStatus.getSelectedItem() == "None"){
            labelstaffstaturequired.setText("required.");
            cboStaffStatus.requestFocus();
        }
        else{
       
            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbStaff where name='" + txtStaffName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true){
                    labelmessagestaff.setText("Staff Create already.");
                }
                else{
                    String querystaff = "insert into tbStaff(name,gender,nationality,birthday,hired_date,salary,phone,address,photo,role_id,status)values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(querystaff);

                    //pst.setString(1, txtstaffID.getText().toString().trim());
                    pst.setString(1, txtStaffName.getText().trim());
                    pst.setString(2, cboStaffGender.getSelectedItem().toString());
                    pst.setString(3, txtStaffNationlity.getText().trim());

                    pst.setString(4,((JTextField)txtStaffBirthday.getDateEditor().getUiComponent()).getText());
                    pst.setString(5,((JTextField)txtStaffHiredDate.getDateEditor().getUiComponent()).getText());

                    pst.setString(6, txtStaffSalary.getText().trim());
                    pst.setString(7, txtStaffPhone.getText().trim());
                    pst.setString(8, txtStaffAddress.getText().trim());

                    InputStream img = new FileInputStream(new File(imagePath));
                    pst.setBlob(9, img);

                    pst.setString(10,cboStaffroleID.getSelectedItem().toString());
                    pst.setString(11,cboStaffStatus.getSelectedItem().toString());

                    pst.executeUpdate();
                    labelmessagestaff.setText("Create staff sucessfully.");
                    getroleIDNrefreshtablestaff();

                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnStaffNewMouseClicked
    public ImageIcon resizePic(String picPath){
        
        ImageIcon myImg = new ImageIcon(picPath);
        Image img = myImg.getImage().getScaledInstance(labelpictureStaff.getWidth(), labelpictureStaff.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    private void btnStaffChoosepictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffChoosepictureMouseClicked
        JFileChooser fc = new JFileChooser();
        //fc.showOpenDialog(null);
        
        //file extension
        FileNameExtensionFilter filefilter = new FileNameExtensionFilter("*image","png","jpg","gif","svg");
        fc.addChoosableFileFilter(filefilter);
        
        int fileState  = fc.showSaveDialog(null);
                
        if(fileState == JFileChooser.APPROVE_OPTION){
            
            File selectedFile = fc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imagePath = path;
            //display the image in the lablepicturestaff
            //labelpictureStaff.setIcon(new ImageIcon(path));
            
            labelpictureStaff.setIcon(resizePic(path));
        }
        
        //if the user cancel
        else if (fileState == JFileChooser.CANCEL_OPTION){
            System.out.println("No Image Selected");
        }
        //ImageIcon staffpicture = new ImageIcon(f.getAbsolutePath());
        
    }//GEN-LAST:event_btnStaffChoosepictureMouseClicked

    private void btnStaffUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffUpdateMouseClicked
  
        int s = tbStaff.getSelectedRow();
        try{
            String value=(tbStaff.getModel().getValueAt(s, 0).toString());
            String updatestaff = "update tbStaff SET name=?, gender=?, nationality=?, birthday=?, hired_date=?, salary=?, phone=?, address=?, photo=?, role_id=?, status=?  where id="+value;
            PreparedStatement psf = con.prepareStatement(updatestaff);
            
            psf.setString(1, txtStaffName.getText().trim());
            psf.setString(2, cboStaffGender.getSelectedItem().toString());
            psf.setString(3, txtStaffNationlity.getText().trim());
            
             psf.setString(4,((JTextField)txtStaffBirthday.getDateEditor().getUiComponent()).getText());
             psf.setString(5,((JTextField)txtStaffHiredDate.getDateEditor().getUiComponent()).getText());
            
            psf.setString(6, txtStaffSalary.getText().trim());
            psf.setString(7, txtStaffPhone.getText().trim());
            psf.setString(8, txtStaffAddress.getText().trim());
            
            InputStream img = new FileInputStream(new File(imagePath));
            psf.setBlob(9, img);
            
            psf.setString(10, cboStaffroleID.getSelectedItem().toString());
            psf.setString(11, cboStaffStatus.getSelectedItem().toString());
            psf.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update sucessfully.");
            getroleIDNrefreshtablestaff();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnStaffUpdateMouseClicked

    private void tbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaffMouseClicked
        try{
            int i = tbStaff.getSelectedRow();
            TableModel tm = tbStaff.getModel();
            txtstaffID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey  = "select * from tbStaff where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtstaffID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txtStaffName.setText(rs.getString(2));
                cboStaffGender.setSelectedItem(rs.getString(3));
                txtStaffNationlity.setText(rs.getString(4));
                
                String str = rs.getString(5);
                String str1 = rs.getString(6);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date bdate = formatter.parse(str);
                java.util.Date hdate = formatter.parse(str1);
                
                txtStaffBirthday.setDate(bdate);
                txtStaffHiredDate.setDate(hdate);
                txtStaffSalary.setText(rs.getString(7));
                txtStaffPhone.setText(rs.getString(8));
                txtStaffAddress.setText(rs.getString(9));
                
                                
                Blob im = rs.getBlob(10);
                byte[] imbyte  = im.getBytes(1, (int)im.length());
                InputStream in = new ByteArrayInputStream(imbyte);
                BufferedImage imgFromDb = ImageIO.read(in);
                Image scaledImage = imgFromDb.getScaledInstance(labelpictureStaff.getWidth(), labelpictureStaff.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);              
                labelpictureStaff.setIcon(icon);
                
                cboStaffroleID.setSelectedItem(rs.getString(11));
                cboStaffStatus.setSelectedItem(rs.getString(12));

            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbStaffMouseClicked
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JButton btnAddNewprojectplandetail;
    private javax.swing.JButton btnAddNewprojectplanlist;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdittablestaff;
    private javax.swing.JButton btnProplanlistAddPlanDetail;
    private javax.swing.JButton btnProplanlistAddnew;
    private javax.swing.JButton btnProplanlistEdit;
    private javax.swing.JButton btnStaffCancel;
    private javax.swing.JButton btnStaffChoosepicture;
    private javax.swing.JButton btnStaffNew;
    private javax.swing.JButton btnStaffUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnViewprojectplandetail;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnopenmenustaffaddnew;
    private javax.swing.JButton btnsignin;
    private javax.swing.JButton btnupdateprojectplandetail1;
    private javax.swing.JButton btnupdateprojectplanlist;
    private javax.swing.JButton btnviewProjectplanlist;
    private javax.swing.JComboBox cboProplanlistsearch;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JComboBox<String> cboStaffGender;
    private javax.swing.JComboBox<String> cboStaffStatus;
    private javax.swing.JComboBox<String> cboStaffroleID;
    private javax.swing.JComboBox<String> cboposition;
    private javax.swing.JComboBox cboprojectplanIDFK;
    private javax.swing.JComboBox cbostaffIDFK;
    private javax.swing.JComboBox<String> cbostaffName;
    private javax.swing.JLabel conpassworderror;
    private javax.swing.JLabel homemenulable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelclient;
    private javax.swing.JLabel labelerrorfinishdate;
    private javax.swing.JLabel labelerrorprojectplan;
    private javax.swing.JLabel labelerrorprojectplanID;
    private javax.swing.JLabel labelerrorprojectplanlistID;
    private javax.swing.JLabel labelerrorstaffID;
    private javax.swing.JLabel labelerrorstartdate;
    private javax.swing.JLabel labelgidelineofmenustaff;
    private javax.swing.JLabel labelgidelineoftalestaff;
    private javax.swing.JLabel labelmessagestaff;
    private javax.swing.JLabel labelpictureStaff;
    private javax.swing.JLabel labelproject;
    private javax.swing.JLabel labelstaff;
    private javax.swing.JLabel labelstaffNamerequired;
    private javax.swing.JLabel labelstaffaddrerequired;
    private javax.swing.JLabel labelstaffbirthrequired;
    private javax.swing.JLabel labelstaffgenderrequired;
    private javax.swing.JLabel labelstaffhirdrequired;
    private javax.swing.JLabel labelstaffidrequired;
    private javax.swing.JLabel labelstaffnatrequired;
    private javax.swing.JLabel labelstaffphonerequired;
    private javax.swing.JLabel labelstaffroleidrequired;
    private javax.swing.JLabel labelstaffsarequired;
    private javax.swing.JLabel labelstaffstaturequired;
    private javax.swing.JLabel labelsuppliers;
    private javax.swing.JLabel labeltotalclient;
    private javax.swing.JLabel labeltotalproject;
    private javax.swing.JLabel labeltotalstaff;
    private javax.swing.JLabel labeltotalsuppliers;
    private javax.swing.JLabel lablegidelineprojectplanlist;
    private javax.swing.JLabel lableshownamelogin;
    private javax.swing.JLabel lablewelcome;
    private javax.swing.JInternalFrame menuaddprojectplandetail;
    private javax.swing.JInternalFrame menuhome;
    private javax.swing.JInternalFrame menuprojectplanlist;
    private javax.swing.JInternalFrame menustaff;
    private javax.swing.JInternalFrame menutableprojectplanlist;
    private javax.swing.JInternalFrame menutableprojectplanlistdetail;
    private javax.swing.JInternalFrame menutablestaff;
    private javax.swing.JInternalFrame menuuser;
    private javax.swing.JInternalFrame menuworker;
    private javax.swing.JPanel paneladdprojectplandetail;
    private javax.swing.JPanel panelbar;
    private javax.swing.JPanel panelclicked1;
    private javax.swing.JPanel panelclicked2;
    private javax.swing.JPanel panelclicked3;
    private javax.swing.JPanel panelclicked4;
    private javax.swing.JPanel panelclicked5;
    private javax.swing.JPanel panelclicked6;
    private javax.swing.JPanel panelclicked7;
    private javax.swing.JPanel panelclicked8;
    private javax.swing.JPanel panelcreateuser;
    private javax.swing.JPanel panelcustomer;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelmencutomer;
    private javax.swing.JPanel panelmenprojectplanlist;
    private javax.swing.JPanel panelmensupplier;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JPanel panelmenuhome;
    private javax.swing.JPanel panelmenuprojectplan;
    private javax.swing.JPanel panelmenustaff;
    private javax.swing.JPanel panelmenuuser;
    private javax.swing.JPanel panelmenworker;
    private javax.swing.JPanel panelproject;
    private javax.swing.JPanel panelprojectplanlist;
    private javax.swing.JPanel panelstaff;
    private javax.swing.JPanel panelstaffinfomation;
    private javax.swing.JPanel panelstaffmenu;
    private javax.swing.JPanel panelsuppliers;
    private javax.swing.JPanel paneltableprojectplanlist;
    private javax.swing.JPanel paneltablestaff;
    private javax.swing.JPanel panelworker;
    private javax.swing.JLabel passworderror;
    private javax.swing.JLabel positionerror;
    private javax.swing.JLabel showlableonclickedmenu;
    private javax.swing.JLabel staffmenulable;
    private javax.swing.JLabel staffmenulable1;
    private javax.swing.JLabel staffmenulable2;
    private javax.swing.JLabel staffmenulable3;
    private javax.swing.JLabel staffmenulable4;
    private javax.swing.JLabel staffmenulable5;
    private javax.swing.JLabel staffmenulable6;
    private javax.swing.JLabel staffnamerror;
    private javax.swing.JLabel sucessfulllable;
    private javax.swing.JTable tbProjectplanlistview;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTable tblistprojectplan;
    private javax.swing.JTable tbprojectlanlistdetail;
    private javax.swing.JTable tbprojectplanlist;
    private javax.swing.JTable tbstaffview;
    private javax.swing.JTable tbviewuser;
    private javax.swing.JTextField txtStaffAddress;
    private com.toedter.calendar.JDateChooser txtStaffBirthday;
    private com.toedter.calendar.JDateChooser txtStaffHiredDate;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtStaffNationlity;
    private javax.swing.JTextField txtStaffPhone;
    private javax.swing.JTextField txtStaffSalary;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtconfirmpassword;
    private com.toedter.calendar.JDateChooser txtfinishdate;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtprojectplan;
    private javax.swing.JTextField txtstaffID;
    private com.toedter.calendar.JDateChooser txtstartdate;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txtstatus1;
    private javax.swing.JTextField txtuserID;
    private javax.swing.JLabel usernameerror;
    // End of variables declaration//GEN-END:variables
}
