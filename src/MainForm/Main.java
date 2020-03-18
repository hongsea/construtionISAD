
package MainForm;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import Application.Application;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import signup.SignIn;

public class Main extends javax.swing.JFrame {
    
    Connection con = Application.getConnection();
    Color paneldefault;
    Color panelclick;
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        
        paneldefault = new Color(0,204,204);
        panelclick = new Color(0,255,0);
        panelclicked1.setBackground(panelclick);
        panelclicked2.setBackground(paneldefault);
        showlableonclickedmenu.setText("HOME");
        
   }
    public void getusername(String user){
        lableshownamelogin.setHorizontalAlignment(SwingConstants.CENTER);
        lableshownamelogin.setText(" " + user);
    }
    
    public void refreshtable() {
        try {
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
        panelmenworker1.setVisible(false);
        panelmenworker2.setVisible(false);
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
        panelmenworker1 = new javax.swing.JPanel();
        panelclicked4 = new javax.swing.JPanel();
        staffmenulable2 = new javax.swing.JLabel();
        panelmenworker2 = new javax.swing.JPanel();
        panelclicked5 = new javax.swing.JPanel();
        staffmenulable3 = new javax.swing.JLabel();
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
        menustaff = new javax.swing.JInternalFrame();
        panelstaffmenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbstaff = new javax.swing.JTable();
        panelstaffinfomation = new javax.swing.JPanel();
        txtstaffID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtstaffName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNationlity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        txtHiredDate = new com.toedter.calendar.JDateChooser();
        cboGender = new javax.swing.JComboBox<String>();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cboroleID = new javax.swing.JComboBox<String>();
        cboStatus = new javax.swing.JComboBox<String>();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        menuworker = new javax.swing.JInternalFrame();
        panelworker = new javax.swing.JPanel();
        menuuser = new javax.swing.JInternalFrame();
        panelcreateuser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboSearch = new javax.swing.JComboBox<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbviewuser = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtuserID = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbostaffName = new javax.swing.JComboBox<String>();
        jLabel27 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cboposition = new javax.swing.JComboBox<String>();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbar.setBackground(new java.awt.Color(255, 204, 102));
        panelbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lableshownamelogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lableshownamelogin.setForeground(new java.awt.Color(0, 0, 0));
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
        showlableonclickedmenu.setForeground(new java.awt.Color(0, 0, 0));
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

        panelmenworker1.setBackground(new java.awt.Color(0, 204, 204));
        panelmenworker1.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenworker1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenworker1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenworker1MouseClicked(evt);
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

        javax.swing.GroupLayout panelmenworker1Layout = new javax.swing.GroupLayout(panelmenworker1);
        panelmenworker1.setLayout(panelmenworker1Layout);
        panelmenworker1Layout.setHorizontalGroup(
            panelmenworker1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenworker1Layout.createSequentialGroup()
                .addComponent(panelclicked4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenworker1Layout.setVerticalGroup(
            panelmenworker1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenworker2.setBackground(new java.awt.Color(0, 204, 204));
        panelmenworker2.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenworker2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenworker2MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenworker2MouseClicked(evt);
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

        javax.swing.GroupLayout panelmenworker2Layout = new javax.swing.GroupLayout(panelmenworker2);
        panelmenworker2.setLayout(panelmenworker2Layout);
        panelmenworker2Layout.setHorizontalGroup(
            panelmenworker2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenworker2Layout.createSequentialGroup()
                .addComponent(panelclicked5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelmenworker2Layout.setVerticalGroup(
            panelmenworker2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelmenustaff, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenworker, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenworker1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenworker2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(panelmenuuser, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(panelmenworker1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenworker2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenuuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
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
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
                            .addComponent(panelstaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(panelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        menuhome.getContentPane().add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1050, 750));

        DesktopPane.add(menuhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menustaff.setVisible(false);
        menustaff.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("                                                                                 STAFF");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        jtbstaff.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtbstaff);

        panelstaffinfomation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtstaffID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtstaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 230, 29));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Staff Name");
        panelstaffinfomation.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 104, 20));

        txtstaffName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtstaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 230, 29));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Gender");
        panelstaffinfomation.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, 20));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Nationality");
        panelstaffinfomation.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        txtNationlity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtNationlity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, 29));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Birthday");
        panelstaffinfomation.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Hired Date");
        panelstaffinfomation.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 20));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Salary");
        panelstaffinfomation.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 50, 20));

        txtSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 250, 29));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Phone");
        panelstaffinfomation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 80, 20));

        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 250, 29));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Address");
        panelstaffinfomation.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, 20));

        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 580, 29));

        txtBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 29));

        txtHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 29));

        cboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cboGender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 230, 29));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Status");
        panelstaffinfomation.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 60, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Role ID");
        panelstaffinfomation.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, -1, 20));

        jLabel21.setText("         Photo");
        jLabel21.setBorder(new javax.swing.border.MatteBorder(null));
        panelstaffinfomation.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 140, 140));

        cboroleID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cboroleID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboroleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 180, 29));

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cboStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(cboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 180, 29));

        btnNew.setBackground(new java.awt.Color(0, 153, 153));
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New");
        panelstaffinfomation.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 90, 30));

        btnSave.setBackground(new java.awt.Color(0, 153, 153));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        panelstaffinfomation.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 90, 30));

        btnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        panelstaffinfomation.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 90, 30));

        btnCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        panelstaffinfomation.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 90, 30));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("Staff ID");
        panelstaffinfomation.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 20));

        jButton2.setText("Choose Photo");
        panelstaffinfomation.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 140, 20));

        jLabel23.setText("Staff Information");

        javax.swing.GroupLayout panelstaffmenuLayout = new javax.swing.GroupLayout(panelstaffmenu);
        panelstaffmenu.setLayout(panelstaffmenuLayout);
        panelstaffmenuLayout.setHorizontalGroup(
            panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelstaffmenuLayout.createSequentialGroup()
                        .addGroup(panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addComponent(panelstaffinfomation, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelstaffmenuLayout.setVerticalGroup(
            panelstaffmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenuLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelstaffinfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
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
        cboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        cboSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel1.add(cboSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 160, 30));

        tbviewuser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbviewuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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
        cbostaffName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "user0", "user1", "user2", "user3" }));
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
        cboposition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "IT", "Manager", "Admin", "Staff" }));
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
                .addContainerGap(47, Short.MAX_VALUE))
        );

        menuuser.getContentPane().add(panelcreateuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1040, 730));

        DesktopPane.add(menuuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        getContentPane().add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 1040, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
       int x,y;
    private void panelmenuhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMousePressed
        panelclicked1.setBackground(panelclick);
        panelclicked2.setBackground(paneldefault);
    }//GEN-LAST:event_panelmenuhomeMousePressed

    private void panelmenuhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMouseClicked
        menustaff.setVisible(false);
        menuhome.setVisible(true);
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("HOME");
    }//GEN-LAST:event_panelmenuhomeMouseClicked

    private void panelmenustaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMouseClicked
        menuhome.setVisible(false);
        menustaff.setVisible(true);
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("STAFF");
    }//GEN-LAST:event_panelmenustaffMouseClicked

    private void panelmenustaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMousePressed
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(panelclick);
    }//GEN-LAST:event_panelmenustaffMousePressed

    private void panelmenworkerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworkerMousePressed

    private void panelmenworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworkerMouseClicked

    private void panelmenworker1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworker1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworker1MousePressed

    private void panelmenworker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworker1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworker1MouseClicked

    private void panelmenworker2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworker2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworker2MousePressed

    private void panelmenworker2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworker2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenworker2MouseClicked

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

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String UserName = "";
        try {
            Statement stat = con.createStatement();
            String selectquery = "Select * from tbUser where username='" + txtUsername.getText().trim() + "'";
            ResultSet rs = stat.executeQuery(selectquery);
            if (rs.next() == true) {
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
                if (txtUsername.getText().trim().isEmpty() && txtpassword.getText().trim().isEmpty() && txtconfirmpassword.getText().trim().isEmpty()) {
                    staffnamerror.setText("Required.");
                    usernameerror.setText("Require.d");
                    positionerror.setText("Required.");
                    passworderror.setText("Required.");
                    conpassworderror.setText("Required.");
                    txtuserID.requestFocus();
                } else {
                    pst.executeUpdate();
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

            Statement stat = con.createStatement();
            String selectquery = "Select * from tbUser where username='" + txtUsername.getText().trim() + "'";
            ResultSet rs = stat.executeQuery(selectquery);
            psu.executeUpdate();
            refreshtable();
            JOptionPane.showMessageDialog(null, "update sucessfully.");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void panelmenuuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuuserMouseClicked
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
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnsignin;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboposition;
    private javax.swing.JComboBox<String> cboroleID;
    private javax.swing.JComboBox<String> cbostaffName;
    private javax.swing.JLabel conpassworderror;
    private javax.swing.JLabel homemenulable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtbstaff;
    private javax.swing.JLabel labelclient;
    private javax.swing.JLabel labelproject;
    private javax.swing.JLabel labelstaff;
    private javax.swing.JLabel labelsuppliers;
    private javax.swing.JLabel labeltotalclient;
    private javax.swing.JLabel labeltotalproject;
    private javax.swing.JLabel labeltotalstaff;
    private javax.swing.JLabel labeltotalsuppliers;
    private javax.swing.JLabel lableshownamelogin;
    private javax.swing.JLabel lablewelcome;
    private javax.swing.JInternalFrame menuhome;
    private javax.swing.JInternalFrame menustaff;
    private javax.swing.JInternalFrame menuuser;
    private javax.swing.JInternalFrame menuworker;
    private javax.swing.JPanel panelbar;
    private javax.swing.JPanel panelclicked1;
    private javax.swing.JPanel panelclicked2;
    private javax.swing.JPanel panelclicked3;
    private javax.swing.JPanel panelclicked4;
    private javax.swing.JPanel panelclicked5;
    private javax.swing.JPanel panelclicked6;
    private javax.swing.JPanel panelcreateuser;
    private javax.swing.JPanel panelcustomer;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JPanel panelmenuhome;
    private javax.swing.JPanel panelmenustaff;
    private javax.swing.JPanel panelmenuuser;
    private javax.swing.JPanel panelmenworker;
    private javax.swing.JPanel panelmenworker1;
    private javax.swing.JPanel panelmenworker2;
    private javax.swing.JPanel panelproject;
    private javax.swing.JPanel panelstaff;
    private javax.swing.JPanel panelstaffinfomation;
    private javax.swing.JPanel panelstaffmenu;
    private javax.swing.JPanel panelsuppliers;
    private javax.swing.JPanel panelworker;
    private javax.swing.JLabel passworderror;
    private javax.swing.JLabel positionerror;
    private javax.swing.JLabel showlableonclickedmenu;
    private javax.swing.JLabel staffmenulable;
    private javax.swing.JLabel staffmenulable1;
    private javax.swing.JLabel staffmenulable2;
    private javax.swing.JLabel staffmenulable3;
    private javax.swing.JLabel staffmenulable4;
    private javax.swing.JLabel staffnamerror;
    private javax.swing.JLabel sucessfulllable;
    private javax.swing.JTable tbviewuser;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private com.toedter.calendar.JDateChooser txtHiredDate;
    private javax.swing.JTextField txtNationlity;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtconfirmpassword;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtstaffID;
    private javax.swing.JTextField txtstaffName;
    private javax.swing.JTextField txtuserID;
    private javax.swing.JLabel usernameerror;
    // End of variables declaration//GEN-END:variables
}
