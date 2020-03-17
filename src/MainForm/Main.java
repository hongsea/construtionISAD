
package MainForm;

import java.awt.Color;

public class Main extends javax.swing.JFrame {
    
    Color paneldefault;
    Color panelclick;
    public Main() {
        initComponents();
        
        paneldefault = new Color(0,204,204);
        panelclick = new Color(0,255,0);
        panelclicked1.setBackground(panelclick);
        panelclicked2.setBackground(paneldefault);
        
        menustaff.setVisible(false);
        menuhome.setVisible(true);
        showlableonclickedmenu.setText("HOME");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelbar = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        showlableonclickedmenu = new javax.swing.JLabel();
        panelmenu = new javax.swing.JPanel();
        panelmenuhome = new javax.swing.JPanel();
        panelclicked1 = new javax.swing.JPanel();
        homemenulable = new javax.swing.JLabel();
        panelmenustaff = new javax.swing.JPanel();
        panelclicked2 = new javax.swing.JPanel();
        staffmenulable = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();
        menuhome = new javax.swing.JInternalFrame();
        panelhome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelproject = new javax.swing.JPanel();
        labelproject = new javax.swing.JLabel();
        labeltotalproject = new javax.swing.JLabel();
        panelclient = new javax.swing.JPanel();
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
        cboGender = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cboroleID = new javax.swing.JComboBox<>();
        cboStatus = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        menuworker = new javax.swing.JInternalFrame();
        panelworker = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbar.setBackground(new java.awt.Color(255, 204, 102));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("   Admin");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("LOGOUT");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/building.png"))); // NOI18N
        jLabel15.setText("CONSTRUCTION SOFTWARE");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        showlableonclickedmenu.setBackground(new java.awt.Color(51, 255, 102));
        showlableonclickedmenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showlableonclickedmenu.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelbarLayout = new javax.swing.GroupLayout(panelbar);
        panelbar.setLayout(panelbarLayout);
        panelbarLayout.setHorizontalGroup(
            panelbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbarLayout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                .addComponent(showlableonclickedmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton1))
        );
        panelbarLayout.setVerticalGroup(
            panelbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(showlableonclickedmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

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

        homemenulable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        homemenulable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/homes.png"))); // NOI18N
        homemenulable.setText("   HOME");

        javax.swing.GroupLayout panelmenuhomeLayout = new javax.swing.GroupLayout(panelmenuhome);
        panelmenuhome.setLayout(panelmenuhomeLayout);
        panelmenuhomeLayout.setHorizontalGroup(
            panelmenuhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuhomeLayout.createSequentialGroup()
                .addComponent(panelclicked1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homemenulable, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        staffmenulable.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        staffmenulable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        staffmenulable.setText("  STAFF");
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

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 255));
        jLabel16.setText("           WELCOME");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelmenustaff, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenustaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(552, Short.MAX_VALUE))
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
        panelproject.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

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

        panelclient.setBackground(new java.awt.Color(255, 255, 255));
        panelclient.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
        panelclient.setPreferredSize(new java.awt.Dimension(215, 92));

        labelclient.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelclient.setForeground(new java.awt.Color(102, 102, 255));
        labelclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client.png"))); // NOI18N
        labelclient.setText("       CLIENT");
        labelclient.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalclient.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalclient.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalclient.setText("10");

        javax.swing.GroupLayout panelclientLayout = new javax.swing.GroupLayout(panelclient);
        panelclient.setLayout(panelclientLayout);
        panelclientLayout.setHorizontalGroup(
            panelclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelclientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelclient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelclientLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labeltotalclient, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        panelclientLayout.setVerticalGroup(
            panelclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelclientLayout.createSequentialGroup()
                .addComponent(labelclient, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(labeltotalclient, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelstaff.setBackground(new java.awt.Color(255, 255, 255));
        panelstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
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
        panelsuppliers.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
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
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

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
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
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
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(0, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

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
                            .addComponent(panelclient, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
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
                    .addComponent(panelclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(292, Short.MAX_VALUE))
        );

        menuhome.getContentPane().add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1050, 740));

        DesktopPane.add(menuhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menustaff.setVisible(false);
        menustaff.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("                                                                                 STAFF");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

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

        panelstaffinfomation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 255)));
        panelstaffinfomation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelstaffinfomation.add(txtstaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 230, 29));

        jLabel3.setText("Staff Name");
        panelstaffinfomation.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 104, -1));
        panelstaffinfomation.add(txtstaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 230, 29));

        jLabel4.setText("Gender");
        panelstaffinfomation.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel20.setText("Nationality");
        panelstaffinfomation.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));
        panelstaffinfomation.add(txtNationlity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, 29));

        jLabel7.setText("Birthday");
        panelstaffinfomation.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel8.setText("Hired Date");
        panelstaffinfomation.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel6.setText("Salary");
        panelstaffinfomation.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));
        panelstaffinfomation.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 250, 29));

        jLabel5.setText("Phone");
        panelstaffinfomation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 80, -1));
        panelstaffinfomation.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 250, 29));

        jLabel19.setText("Address");
        panelstaffinfomation.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));
        panelstaffinfomation.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 580, 29));
        panelstaffinfomation.add(txtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 29));
        panelstaffinfomation.add(txtHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 29));

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelstaffinfomation.add(cboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 230, 29));

        jLabel17.setText("Status");
        panelstaffinfomation.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, -1, -1));

        jLabel9.setText("Role ID");
        panelstaffinfomation.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, -1));

        jLabel21.setText("         Photo");
        jLabel21.setBorder(new javax.swing.border.MatteBorder(null));
        panelstaffinfomation.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 111, 127));

        cboroleID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelstaffinfomation.add(cboroleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 180, 29));

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelstaffinfomation.add(cboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 180, 29));

        btnNew.setText("New");
        panelstaffinfomation.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 90, 30));

        btnSave.setText("Save");
        panelstaffinfomation.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 90, 30));

        btnUpdate.setText("Update");
        panelstaffinfomation.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 90, 30));

        btnCancel.setText("Cancel");
        panelstaffinfomation.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 90, 30));

        jLabel22.setText("Staff ID");
        panelstaffinfomation.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel32.setText("Choose Photo");
        panelstaffinfomation.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, -1, -1));

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
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboroleID;
    private javax.swing.JLabel homemenulable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbstaff;
    private javax.swing.JLabel labelclient;
    private javax.swing.JLabel labelproject;
    private javax.swing.JLabel labelstaff;
    private javax.swing.JLabel labelsuppliers;
    private javax.swing.JLabel labeltotalclient;
    private javax.swing.JLabel labeltotalproject;
    private javax.swing.JLabel labeltotalstaff;
    private javax.swing.JLabel labeltotalsuppliers;
    private javax.swing.JInternalFrame menuhome;
    private javax.swing.JInternalFrame menustaff;
    private javax.swing.JInternalFrame menuworker;
    private javax.swing.JPanel panelbar;
    private javax.swing.JPanel panelclicked1;
    private javax.swing.JPanel panelclicked2;
    private javax.swing.JPanel panelclient;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JPanel panelmenuhome;
    private javax.swing.JPanel panelmenustaff;
    private javax.swing.JPanel panelproject;
    private javax.swing.JPanel panelstaff;
    private javax.swing.JPanel panelstaffinfomation;
    private javax.swing.JPanel panelstaffmenu;
    private javax.swing.JPanel panelsuppliers;
    private javax.swing.JPanel panelworker;
    private javax.swing.JLabel showlableonclickedmenu;
    private javax.swing.JLabel staffmenulable;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private com.toedter.calendar.JDateChooser txtHiredDate;
    private javax.swing.JTextField txtNationlity;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtstaffID;
    private javax.swing.JTextField txtstaffName;
    // End of variables declaration//GEN-END:variables
}
