
package MainForm;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import Application.Application;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    String filename = null;
    byte[] staff_image = null;
    byte[] worker_image = null;
        
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
        
        txtstaffID.setEditable(false);
        txtworkerID.setEnabled(false);
        
      
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
        panelmenprojectplanlist1 = new javax.swing.JPanel();
        panelclicked9 = new javax.swing.JPanel();
        staffmenulable7 = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();
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
        menutableworker = new javax.swing.JInternalFrame();
        paneltablestaff1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbworkerview = new javax.swing.JTable();
        labelgidelineoftalebworker = new javax.swing.JLabel();
        btnopenmenuworker = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnEdittableworker = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        menuworker = new javax.swing.JInternalFrame();
        panelstaffmenu1 = new javax.swing.JPanel();
        labelgidelineofmenuWorker = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbworker = new javax.swing.JTable();
        panelstaffinfomation1 = new javax.swing.JPanel();
        txtworkerID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtworkerName = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtworkerSalary = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtworkerPhone = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtworkerAddress = new javax.swing.JTextField();
        txtworkerBirthday = new com.toedter.calendar.JDateChooser();
        txtworkerHiredDate = new com.toedter.calendar.JDateChooser();
        cboworkerGender = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        labelpictureworker = new javax.swing.JLabel();
        cboworkerStatus = new javax.swing.JComboBox<>();
        btnworkerNew = new javax.swing.JButton();
        btnworkerUpdate = new javax.swing.JButton();
        btnworkerCancel = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        btnWorkerChoosepicture = new javax.swing.JButton();
        labelmessageworker = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        cboworkerroleID = new javax.swing.JComboBox<>();
        labelworkerroleidrequired = new javax.swing.JLabel();
        labelworkerNamerequired = new javax.swing.JLabel();
        labelworkercreatebystaff = new javax.swing.JLabel();
        labelworkergenderrequired = new javax.swing.JLabel();
        labelworkerbirthrequired = new javax.swing.JLabel();
        labelworkerhirdrequired = new javax.swing.JLabel();
        labelworkersaryequired = new javax.swing.JLabel();
        labelworkerphonerequired = new javax.swing.JLabel();
        labelworkeraddrerequired = new javax.swing.JLabel();
        labelworkerstaturequired = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        cboworkercreatebystaff = new javax.swing.JComboBox<>();
        menucustomer = new javax.swing.JInternalFrame();
        menupayment = new javax.swing.JInternalFrame();
        panelstaffmenu2 = new javax.swing.JPanel();
        labelgidelineofmenuPayment = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbPayment = new javax.swing.JTable();
        panelstaffinfomation2 = new javax.swing.JPanel();
        txtPaymentID = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtPaymentPaidAmount = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtPaymentDate = new com.toedter.calendar.JDateChooser();
        cboPaymentCutomerName = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        btnPaymentNew = new javax.swing.JButton();
        btnPaymentUpdate = new javax.swing.JButton();
        btnPaymentCancel = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        labelmessageworker1 = new javax.swing.JLabel();
        labelworkerroleidrequired1 = new javax.swing.JLabel();
        labelpaymentNamerequired = new javax.swing.JLabel();
        labelpaymentcreatebystaff = new javax.swing.JLabel();
        labelpaymentgenderrequired = new javax.swing.JLabel();
        labelpaymentdatehirdrequired = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtPaymentCreatebystaff = new javax.swing.JComboBox<>();
        menuinvoice = new javax.swing.JInternalFrame();
        panelstaffmenu3 = new javax.swing.JPanel();
        labelgidelineofmenuPayment1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbInvoice = new javax.swing.JTable();
        panelstaffinfomation3 = new javax.swing.JPanel();
        txtPaymentID1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtPaymentDate1 = new com.toedter.calendar.JDateChooser();
        cboPaymentCutomerName1 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        btnInvoiceNew = new javax.swing.JButton();
        btnInvoiceUpdate = new javax.swing.JButton();
        btnInvoiceCancel = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        labelmessageworker2 = new javax.swing.JLabel();
        labelworkerroleidrequired2 = new javax.swing.JLabel();
        labelpaymentNamerequired1 = new javax.swing.JLabel();
        labelpaymentcreatebystaff1 = new javax.swing.JLabel();
        labelpaymentgenderrequired1 = new javax.swing.JLabel();
        labelpaymentdatehirdrequired1 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtPaymentCreatebystaff1 = new javax.swing.JComboBox<>();
        cboPaymentCutomerName2 = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        cboPaymentCutomerName3 = new javax.swing.JComboBox<>();
        labelpaymentgenderrequired2 = new javax.swing.JLabel();
        txtPaymentID2 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtPaymentID3 = new javax.swing.JTextField();
        menuprojectplan = new javax.swing.JInternalFrame();
        panelstaffmenu4 = new javax.swing.JPanel();
        labelgidelineofmenuPayment2 = new javax.swing.JLabel();
        panelstaffinfomation4 = new javax.swing.JPanel();
        txtPaymentID4 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        cboPaymentCutomerName4 = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        btnInvoiceNew1 = new javax.swing.JButton();
        btnInvoiceUpdate1 = new javax.swing.JButton();
        btnInvoiceCancel1 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        labelmessageworker3 = new javax.swing.JLabel();
        labelworkerroleidrequired3 = new javax.swing.JLabel();
        labelpaymentNamerequired2 = new javax.swing.JLabel();
        labelpaymentcreatebystaff2 = new javax.swing.JLabel();
        labelpaymentgenderrequired3 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtPaymentCreatebystaff2 = new javax.swing.JComboBox<>();
        cboPaymentCutomerName5 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        cboPaymentCutomerName6 = new javax.swing.JComboBox<>();
        labelpaymentgenderrequired4 = new javax.swing.JLabel();
        txtPaymentID5 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbInvoice1 = new javax.swing.JTable();
        menuprojectplanList = new javax.swing.JInternalFrame();
        panelstaffmenu5 = new javax.swing.JPanel();
        labelgidelineofmenuPayment3 = new javax.swing.JLabel();
        panelstaffinfomation5 = new javax.swing.JPanel();
        txtPaymentID6 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtPaymentDate2 = new com.toedter.calendar.JDateChooser();
        jLabel75 = new javax.swing.JLabel();
        btnInvoiceNew2 = new javax.swing.JButton();
        btnInvoiceUpdate2 = new javax.swing.JButton();
        btnInvoiceCancel2 = new javax.swing.JButton();
        labelmessageworker4 = new javax.swing.JLabel();
        labelworkerroleidrequired4 = new javax.swing.JLabel();
        labelpaymentNamerequired3 = new javax.swing.JLabel();
        labelpaymentcreatebystaff3 = new javax.swing.JLabel();
        labelpaymentgenderrequired5 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        cboPaymentCutomerName8 = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        labelpaymentgenderrequired6 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txtPaymentID8 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        labelpaymentgenderrequired7 = new javax.swing.JLabel();
        labelpaymentgenderrequired8 = new javax.swing.JLabel();
        labelpaymentgenderrequired9 = new javax.swing.JLabel();
        panelstaffinfomation6 = new javax.swing.JPanel();
        txtPaymentID7 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtPaymentDate4 = new com.toedter.calendar.JDateChooser();
        jLabel83 = new javax.swing.JLabel();
        btnInvoiceNew3 = new javax.swing.JButton();
        btnInvoiceUpdate3 = new javax.swing.JButton();
        btnInvoiceCancel3 = new javax.swing.JButton();
        labelmessageworker5 = new javax.swing.JLabel();
        labelworkerroleidrequired5 = new javax.swing.JLabel();
        labelpaymentNamerequired4 = new javax.swing.JLabel();
        labelpaymentcreatebystaff4 = new javax.swing.JLabel();
        labelpaymentgenderrequired10 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtPaymentCreatebystaff5 = new javax.swing.JComboBox<>();
        cboPaymentCutomerName9 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        labelpaymentgenderrequired11 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        txtPaymentID10 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        txtPaymentDate5 = new com.toedter.calendar.JDateChooser();
        labelpaymentgenderrequired12 = new javax.swing.JLabel();
        labelpaymentgenderrequired13 = new javax.swing.JLabel();
        labelpaymentgenderrequired14 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbInvoice3 = new javax.swing.JTable();
        txtPaymentID11 = new javax.swing.JTextField();
        txtPaymentCreatebystaff6 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        txtPaymentCreatebystaff7 = new javax.swing.JComboBox<>();
        txtPaymentDate6 = new com.toedter.calendar.JDateChooser();
        txtPaymentCreatebystaff8 = new javax.swing.JComboBox<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbInvoice4 = new javax.swing.JTable();
        txtPaymentCreatebystaff9 = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        txtPaymentID14 = new javax.swing.JTextField();
        txtPaymentID12 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtPaymentDate3 = new com.toedter.calendar.JDateChooser();
        txtPaymentCreatebystaff3 = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbInvoice2 = new javax.swing.JTable();
        btnInvoiceNew4 = new javax.swing.JButton();
        btnInvoiceUpdate4 = new javax.swing.JButton();
        btnInvoiceCancel4 = new javax.swing.JButton();
        txtPaymentCreatebystaff4 = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
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
        menuprojectplanlist1111 = new javax.swing.JInternalFrame();
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
        menuaddprojectplandetail = new javax.swing.JInternalFrame();

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

        btnlogout.setBackground(new java.awt.Color(255, 204, 102));
        btnlogout.setForeground(new java.awt.Color(0, 255, 0));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        btnlogout.setBorder(null);
        btnlogout.setPreferredSize(new java.awt.Dimension(60, 30));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        panelbar.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1258, 0, 40, 30));

        getContentPane().add(panelbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 30));

        panelmenu.setBackground(new java.awt.Color(0, 153, 153));

        panelmenuhome.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuhomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuhomeMousePressed(evt);
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
                .addContainerGap(91, Short.MAX_VALUE))
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenustaffMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenustaffMousePressed(evt);
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
        lablewelcome.setForeground(new java.awt.Color(255, 255, 255));
        lablewelcome.setText("                   WELCOME");
        lablewelcome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        panelmenworker.setBackground(new java.awt.Color(0, 204, 204));
        panelmenworker.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenworker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenworkerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenworkerMousePressed(evt);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmencutomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmencutomerMousePressed(evt);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmensupplierMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmensupplierMousePressed(evt);
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
        staffmenulable3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pay.png"))); // NOI18N
        staffmenulable3.setText("   PAYMENT");
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuprojectplanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuprojectplanMousePressed(evt);
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
        staffmenulable5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        staffmenulable5.setText("   INVOICE");
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlistMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlistMousePressed(evt);
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
        staffmenulable6.setText("   PROJECT PLAN");
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

        panelmenprojectplanlist1.setBackground(new java.awt.Color(0, 204, 204));
        panelmenprojectplanlist1.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenprojectplanlist1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlist1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenprojectplanlist1MousePressed(evt);
            }
        });

        panelclicked9.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked9.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked9Layout = new javax.swing.GroupLayout(panelclicked9);
        panelclicked9.setLayout(panelclicked9Layout);
        panelclicked9Layout.setHorizontalGroup(
            panelclicked9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked9Layout.setVerticalGroup(
            panelclicked9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable7.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier1.png"))); // NOI18N
        staffmenulable7.setText("   PROJECT PLAN LIST");
        staffmenulable7.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenprojectplanlist1Layout = new javax.swing.GroupLayout(panelmenprojectplanlist1);
        panelmenprojectplanlist1.setLayout(panelmenprojectplanlist1Layout);
        panelmenprojectplanlist1Layout.setHorizontalGroup(
            panelmenprojectplanlist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenprojectplanlist1Layout.createSequentialGroup()
                .addComponent(panelclicked9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelmenprojectplanlist1Layout.setVerticalGroup(
            panelmenprojectplanlist1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelmenustaff, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmenworker, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmencutomer, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmensupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmenuuser, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmenuprojectplan, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(panelmenprojectplanlist1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(panelmenuLayout.createSequentialGroup()
                        .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelmenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(panelmencutomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmensupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenuprojectplan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmenprojectplanlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(panelmenuuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );

        getContentPane().add(panelmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 700));

        DesktopPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addComponent(labelclient, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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
                .addGap(0, 10, Short.MAX_VALUE))
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
                .addComponent(labelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
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
                            .addComponent(panelstaff, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
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
        panelstaffinfomation.add(txtStaffAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 900, 29));

        txtStaffBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation.add(txtStaffBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 29));

        txtStaffHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
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
        panelstaffinfomation.add(btnStaffNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 90, 30));

        btnStaffUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnStaffUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffUpdate.setText("Update");
        btnStaffUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 90, 30));

        btnStaffCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnStaffCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnStaffCancel.setText("Cancel");
        btnStaffCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, 90, 30));

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
                    .addComponent(panelstaffinfomation, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
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

        menutableworker.setVisible(false);
        menutableworker.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneltablestaff1.setBackground(new java.awt.Color(255, 255, 255));
        paneltablestaff1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbworkerview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tbworkerview);

        paneltablestaff1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        labelgidelineoftalebworker.setBackground(new java.awt.Color(255, 0, 51));
        labelgidelineoftalebworker.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        paneltablestaff1.add(labelgidelineoftalebworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnopenmenuworker.setBackground(new java.awt.Color(0, 153, 153));
        btnopenmenuworker.setForeground(new java.awt.Color(255, 255, 255));
        btnopenmenuworker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnopenmenuworker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnopenmenuworkerMouseClicked(evt);
            }
        });
        paneltablestaff1.add(btnopenmenuworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        paneltablestaff1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittableworker.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittableworker.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittableworker.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittableworker.setText("Edit");
        btnEdittableworker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittableworkerMouseClicked(evt);
            }
        });
        paneltablestaff1.add(btnEdittableworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setText("Search");
        paneltablestaff1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        menutableworker.getContentPane().add(paneltablestaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(menutableworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuworker.setVisible(false);
        menuworker.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu1.setBackground(new java.awt.Color(255, 255, 255));

        labelgidelineofmenuWorker.setAlignmentX(0.5F);
        labelgidelineofmenuWorker.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbworker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbworker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbworkerMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbworker);

        panelstaffinfomation1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtworkerID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setText("Gender");
        panelstaffinfomation1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 230, 20));

        txtworkerName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel45.setText("Birthday");
        panelstaffinfomation1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 20));

        jLabel46.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel46.setText("Hired Date");
        panelstaffinfomation1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, 20));

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel47.setText("Salary");
        panelstaffinfomation1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 50, 20));

        txtworkerSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 250, 29));

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel48.setText("Phone");
        panelstaffinfomation1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 80, 20));

        txtworkerPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 250, 29));

        jLabel49.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel49.setText("Address");
        panelstaffinfomation1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));

        txtworkerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 940, 29));

        txtworkerBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 250, 29));

        txtworkerHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(txtworkerHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 250, 29));

        cboworkerGender.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkerGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboworkerGender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(cboworkerGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 230, 29));

        jLabel50.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel50.setText("Status");
        panelstaffinfomation1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 230, 20));

        jLabel51.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel51.setText("Worker Name");
        panelstaffinfomation1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        labelpictureworker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        panelstaffinfomation1.add(labelpictureworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 120, 120));

        cboworkerStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkerStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Working", "Stoped" }));
        cboworkerStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(cboworkerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 230, 29));

        btnworkerNew.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerNew.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerNew.setText("New");
        btnworkerNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerNewMouseClicked(evt);
            }
        });
        panelstaffinfomation1.add(btnworkerNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 90, 30));

        btnworkerUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerUpdate.setText("Update");
        btnworkerUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation1.add(btnworkerUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 90, 30));

        btnworkerCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerCancel.setText("Cancel");
        btnworkerCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation1.add(btnworkerCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 90, 30));

        jLabel52.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel52.setText("Worker ID");
        panelstaffinfomation1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        btnWorkerChoosepicture.setText("Choose Photo");
        btnWorkerChoosepicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWorkerChoosepictureMouseClicked(evt);
            }
        });
        btnWorkerChoosepicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkerChoosepictureActionPerformed(evt);
            }
        });
        panelstaffinfomation1.add(btnWorkerChoosepicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 120, 20));

        labelmessageworker.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation1.add(labelmessageworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        jLabel53.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel53.setText("Role");
        panelstaffinfomation1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 230, 20));

        cboworkerroleID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkerroleID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboworkerroleID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(cboworkerroleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 230, 29));

        labelworkerroleidrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkerroleidrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelworkerNamerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerNamerequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation1.add(labelworkerNamerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 20));

        labelworkercreatebystaff.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkercreatebystaff.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkercreatebystaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 20));

        labelworkergenderrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkergenderrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkergenderrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 230, 20));

        labelworkerbirthrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerbirthrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkerbirthrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 190, 20));

        labelworkerhirdrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerhirdrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkerhirdrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 190, 20));

        labelworkersaryequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkersaryequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkersaryequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 250, 20));

        labelworkerphonerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerphonerequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkerphonerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 250, 20));

        labelworkeraddrerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkeraddrerequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkeraddrerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 20));

        labelworkerstaturequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerstaturequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation1.add(labelworkerstaturequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 230, 20));

        jLabel54.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel54.setText("Create by Staff Name");
        panelstaffinfomation1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        cboworkercreatebystaff.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkercreatebystaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboworkercreatebystaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation1.add(cboworkercreatebystaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 29));

        javax.swing.GroupLayout panelstaffmenu1Layout = new javax.swing.GroupLayout(panelstaffmenu1);
        panelstaffmenu1.setLayout(panelstaffmenu1Layout);
        panelstaffmenu1Layout.setHorizontalGroup(
            panelstaffmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelgidelineofmenuWorker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        panelstaffmenu1Layout.setVerticalGroup(
            panelstaffmenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenuWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuworker.getContentPane().add(panelstaffmenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menucustomer.setVisible(true);

        javax.swing.GroupLayout menucustomerLayout = new javax.swing.GroupLayout(menucustomer.getContentPane());
        menucustomer.getContentPane().setLayout(menucustomerLayout);
        menucustomerLayout.setHorizontalGroup(
            menucustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        menucustomerLayout.setVerticalGroup(
            menucustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        DesktopPane.add(menucustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menupayment.setVisible(false);
        menupayment.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu2.setBackground(new java.awt.Color(255, 255, 255));

        labelgidelineofmenuPayment.setText("PAYMENT / CREATE");
        labelgidelineofmenuPayment.setAlignmentX(0.5F);
        labelgidelineofmenuPayment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPaymentMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbPayment);

        panelstaffinfomation2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaymentID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(txtPaymentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel44.setText("Customer Name");
        panelstaffinfomation2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        txtPaymentPaidAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(txtPaymentPaidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel56.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel56.setText("Payment Date");
        panelstaffinfomation2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 250, 20));

        txtPaymentDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(txtPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        cboPaymentCutomerName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(cboPaymentCutomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel61.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel61.setText("Paid Amount");
        panelstaffinfomation2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnPaymentNew.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentNew.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentNew.setText("New");
        btnPaymentNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentNewMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 90, 30));

        btnPaymentUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentUpdate.setText("Update");
        btnPaymentUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 90, 30));

        btnPaymentCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentCancel.setText("Cancel");
        btnPaymentCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 90, 30));

        jLabel62.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel62.setText("Payment ID");
        panelstaffinfomation2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker1.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation2.add(labelmessageworker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired1.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelworkerroleidrequired1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentNamerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentNamerequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation2.add(labelpaymentNamerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 20));

        labelpaymentcreatebystaff.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentcreatebystaff.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentcreatebystaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 230, 20));

        labelpaymentgenderrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentgenderrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelpaymentdatehirdrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentdatehirdrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentdatehirdrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 230, 20));

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel64.setText("Create by Staff Name");
        panelstaffinfomation2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        txtPaymentCreatebystaff.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(txtPaymentCreatebystaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 220, 29));

        javax.swing.GroupLayout panelstaffmenu2Layout = new javax.swing.GroupLayout(panelstaffmenu2);
        panelstaffmenu2.setLayout(panelstaffmenu2Layout);
        panelstaffmenu2Layout.setHorizontalGroup(
            panelstaffmenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelgidelineofmenuPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation2, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        panelstaffmenu2Layout.setVerticalGroup(
            panelstaffmenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenuPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        menupayment.getContentPane().add(panelstaffmenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menupayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuinvoice.setVisible(false);
        menuinvoice.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu3.setBackground(new java.awt.Color(255, 255, 255));

        labelgidelineofmenuPayment1.setText("INVOICE / CREATE");
        labelgidelineofmenuPayment1.setAlignmentX(0.5F);
        labelgidelineofmenuPayment1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoiceMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbInvoice);

        panelstaffinfomation3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaymentID1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtPaymentID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel55.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel55.setText("Create Staff Name");
        panelstaffinfomation3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        jLabel57.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel57.setText("Invoice Date");
        panelstaffinfomation3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 230, 20));

        txtPaymentDate1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtPaymentDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 230, 29));

        cboPaymentCutomerName1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(cboPaymentCutomerName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel63.setText("Payment ID");
        panelstaffinfomation3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnInvoiceNew.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceNew.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceNew.setText("New");
        btnInvoiceNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceNewMouseClicked(evt);
            }
        });
        panelstaffinfomation3.add(btnInvoiceNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 90, 30));

        btnInvoiceUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceUpdate.setText("Update");
        btnInvoiceUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation3.add(btnInvoiceUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 90, 30));

        btnInvoiceCancel.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceCancel.setText("Cancel");
        btnInvoiceCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation3.add(btnInvoiceCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 90, 30));

        jLabel65.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel65.setText("Invoice ID");
        panelstaffinfomation3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker2.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation3.add(labelmessageworker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired2.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelworkerroleidrequired2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentNamerequired1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentNamerequired1.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation3.add(labelpaymentNamerequired1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 20));

        labelpaymentcreatebystaff1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentcreatebystaff1.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelpaymentcreatebystaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 230, 20));

        labelpaymentgenderrequired1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired1.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelpaymentgenderrequired1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelpaymentdatehirdrequired1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentdatehirdrequired1.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelpaymentdatehirdrequired1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 230, 20));

        jLabel66.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel66.setText("Customer Name");
        panelstaffinfomation3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        txtPaymentCreatebystaff1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtPaymentCreatebystaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 220, 29));

        cboPaymentCutomerName2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(cboPaymentCutomerName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel58.setText("Total Amount");
        panelstaffinfomation3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        cboPaymentCutomerName3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(cboPaymentCutomerName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        labelpaymentgenderrequired2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired2.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelpaymentgenderrequired2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 230, 20));

        txtPaymentID2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtPaymentID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 230, 29));

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel67.setText("Paid Amount");
        panelstaffinfomation3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 20));

        jLabel68.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel68.setText("Owes Amount");
        panelstaffinfomation3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        txtPaymentID3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtPaymentID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 29));

        javax.swing.GroupLayout panelstaffmenu3Layout = new javax.swing.GroupLayout(panelstaffmenu3);
        panelstaffmenu3.setLayout(panelstaffmenu3Layout);
        panelstaffmenu3Layout.setHorizontalGroup(
            panelstaffmenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelgidelineofmenuPayment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation3, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        panelstaffmenu3Layout.setVerticalGroup(
            panelstaffmenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenuPayment1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuinvoice.getContentPane().add(panelstaffmenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuinvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuprojectplan.setVisible(false);
        menuprojectplan.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu4.setBackground(new java.awt.Color(255, 255, 255));

        labelgidelineofmenuPayment2.setText("PROJECTPLAN / CREATE");
        labelgidelineofmenuPayment2.setAlignmentX(0.5F);
        labelgidelineofmenuPayment2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        panelstaffinfomation4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaymentID4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(txtPaymentID4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel59.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel59.setText("Project Information Name");
        panelstaffinfomation4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        cboPaymentCutomerName4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(cboPaymentCutomerName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel69.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel69.setText("Time Line");
        panelstaffinfomation4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnInvoiceNew1.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceNew1.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceNew1.setText("New");
        btnInvoiceNew1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceNew1MouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnInvoiceNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 90, 30));

        btnInvoiceUpdate1.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceUpdate1.setText("Update");
        btnInvoiceUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceUpdate1MouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnInvoiceUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 90, 30));

        btnInvoiceCancel1.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceCancel1.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceCancel1.setText("Cancel");
        btnInvoiceCancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceCancel1MouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnInvoiceCancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 90, 30));

        jLabel70.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel70.setText("ProjectPlan ID");
        panelstaffinfomation4.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker3.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation4.add(labelmessageworker3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelworkerroleidrequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentNamerequired2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentNamerequired2.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation4.add(labelpaymentNamerequired2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 20));

        labelpaymentcreatebystaff2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentcreatebystaff2.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelpaymentcreatebystaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 230, 20));

        labelpaymentgenderrequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelpaymentgenderrequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel71.setText("ProjectPlan Name");
        panelstaffinfomation4.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        txtPaymentCreatebystaff2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(txtPaymentCreatebystaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 230, 29));

        cboPaymentCutomerName5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(cboPaymentCutomerName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel72.setText("Location");
        panelstaffinfomation4.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        cboPaymentCutomerName6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(cboPaymentCutomerName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        labelpaymentgenderrequired4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired4.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelpaymentgenderrequired4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 230, 20));

        txtPaymentID5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(txtPaymentID5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 230, 29));

        jLabel73.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel73.setText("Status");
        panelstaffinfomation4.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 20));

        tbInvoice1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbInvoice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoice1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tbInvoice1);

        panelstaffinfomation4.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 990, 350));

        javax.swing.GroupLayout panelstaffmenu4Layout = new javax.swing.GroupLayout(panelstaffmenu4);
        panelstaffmenu4.setLayout(panelstaffmenu4Layout);
        panelstaffmenu4Layout.setHorizontalGroup(
            panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelgidelineofmenuPayment2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelstaffmenu4Layout.setVerticalGroup(
            panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenuPayment2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        menuprojectplan.getContentPane().add(panelstaffmenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuprojectplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuprojectplanList.setVisible(false);
        menuprojectplanList.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu5.setBackground(new java.awt.Color(255, 255, 255));
        panelstaffmenu5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelgidelineofmenuPayment3.setText("INVOICE / CREATE");
        labelgidelineofmenuPayment3.setAlignmentX(0.5F);
        labelgidelineofmenuPayment3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelstaffmenu5.add(labelgidelineofmenuPayment3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 37, 1012, 24));

        panelstaffinfomation5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaymentID6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentID6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel60.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel60.setText("ProjectPlan Name");
        panelstaffinfomation5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        txtPaymentDate2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 230, 29));

        jLabel75.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel75.setText("ProjectPlanList Name");
        panelstaffinfomation5.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 20));

        btnInvoiceNew2.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceNew2.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceNew2.setText("New");
        btnInvoiceNew2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceNew2MouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnInvoiceNew2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 90, 30));

        btnInvoiceUpdate2.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceUpdate2.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceUpdate2.setText("Update");
        btnInvoiceUpdate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceUpdate2MouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnInvoiceUpdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 90, 30));

        btnInvoiceCancel2.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceCancel2.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceCancel2.setText("Cancel");
        btnInvoiceCancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceCancel2MouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnInvoiceCancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 90, 30));

        labelmessageworker4.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation5.add(labelmessageworker4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired4.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelworkerroleidrequired4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentNamerequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentNamerequired3.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation5.add(labelpaymentNamerequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 20, 30));

        labelpaymentcreatebystaff3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentcreatebystaff3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentcreatebystaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 20, 30));

        labelpaymentgenderrequired5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired5.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 20, 30));

        jLabel77.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel77.setText("Create by Staff");
        panelstaffinfomation5.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 220, 20));

        cboPaymentCutomerName8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(cboPaymentCutomerName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel78.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel78.setText("Start Date");
        panelstaffinfomation5.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 230, 20));

        labelpaymentgenderrequired6.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired6.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 30, 30));

        jLabel79.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel79.setText("Finish Date");
        panelstaffinfomation5.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 230, 20));

        jLabel80.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel80.setText("Status");
        panelstaffinfomation5.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

        txtPaymentID8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentID8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 29));

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel81.setText("ProjectPlanList ID");
        panelstaffinfomation5.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 20));

        labelpaymentgenderrequired7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired7.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 20, 30));

        labelpaymentgenderrequired8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired8.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 20, 30));

        labelpaymentgenderrequired9.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired9.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 20, 30));

        panelstaffinfomation6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaymentID7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentID7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel74.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel74.setText("ProjectPlan Name");
        panelstaffinfomation6.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        txtPaymentDate4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 230, 29));

        jLabel83.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel83.setText("ProjectPlanList Name");
        panelstaffinfomation6.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 20));

        btnInvoiceNew3.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceNew3.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceNew3.setText("New");
        btnInvoiceNew3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceNew3MouseClicked(evt);
            }
        });
        panelstaffinfomation6.add(btnInvoiceNew3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 90, 30));

        btnInvoiceUpdate3.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceUpdate3.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceUpdate3.setText("Update");
        btnInvoiceUpdate3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceUpdate3MouseClicked(evt);
            }
        });
        panelstaffinfomation6.add(btnInvoiceUpdate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 90, 30));

        btnInvoiceCancel3.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceCancel3.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceCancel3.setText("Cancel");
        btnInvoiceCancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceCancel3MouseClicked(evt);
            }
        });
        panelstaffinfomation6.add(btnInvoiceCancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 90, 30));

        labelmessageworker5.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation6.add(labelmessageworker5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired5.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelworkerroleidrequired5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentNamerequired4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentNamerequired4.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation6.add(labelpaymentNamerequired4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

        labelpaymentcreatebystaff4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentcreatebystaff4.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentcreatebystaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 230, 20));

        labelpaymentgenderrequired10.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired10.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentgenderrequired10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 230, 20));

        jLabel84.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel84.setText("Customer Name");
        panelstaffinfomation6.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 220, 20));

        txtPaymentCreatebystaff5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentCreatebystaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 230, 30));

        cboPaymentCutomerName9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboPaymentCutomerName9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(cboPaymentCutomerName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel85.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel85.setText("Start Date");
        panelstaffinfomation6.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 230, 20));

        labelpaymentgenderrequired11.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired11.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentgenderrequired11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        jLabel86.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel86.setText("Finish Date");
        panelstaffinfomation6.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 230, 20));

        jLabel87.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel87.setText("Status");
        panelstaffinfomation6.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 20));

        txtPaymentID10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentID10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 230, 29));

        jLabel88.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel88.setText("ProjectPlanList ID");
        panelstaffinfomation6.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 20));

        txtPaymentDate5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 230, 29));

        labelpaymentgenderrequired12.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired12.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentgenderrequired12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 230, 20));

        labelpaymentgenderrequired13.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired13.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentgenderrequired13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelpaymentgenderrequired14.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired14.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation6.add(labelpaymentgenderrequired14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 230, 20));

        tbInvoice3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbInvoice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoice3MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tbInvoice3);

        panelstaffinfomation6.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 970, 150));

        txtPaymentID11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentID11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 230, 29));

        txtPaymentCreatebystaff6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation6.add(txtPaymentCreatebystaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 230, 30));

        jLabel89.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel89.setText("ProjectPlan Name");
        panelstaffinfomation6.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 120, 30));

        panelstaffinfomation5.add(panelstaffinfomation6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 1012, 70));

        txtPaymentCreatebystaff7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentCreatebystaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 230, 30));

        txtPaymentDate6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentDate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 29));

        txtPaymentCreatebystaff8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentCreatebystaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 30));

        tbInvoice4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbInvoice4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbInvoice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoice4MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tbInvoice4);

        panelstaffinfomation5.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 970, 170));

        txtPaymentCreatebystaff9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtPaymentCreatebystaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 230, 20));

        jLabel95.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel95.setText("ProjectPlan Name");
        panelstaffinfomation5.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 120, 20));

        panelstaffmenu5.add(panelstaffinfomation5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 1020, 380));

        jLabel76.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel76.setText("ProjectPlan List Detail");
        panelstaffmenu5.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 1010, 20));

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel92.setText("ProjectPlanList Name");
        jPanel4.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 20));

        txtPaymentID14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentID14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 29));

        txtPaymentID12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentID12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel91.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel91.setText("ProjectPlanList ID");
        jPanel4.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 20));

        jLabel93.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel93.setText("ProjectPlan List Detail Name");
        jPanel4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

        jLabel94.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel94.setText("Date Line");
        jPanel4.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 20));

        txtPaymentDate3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, 29));

        txtPaymentCreatebystaff3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentCreatebystaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 30));

        tbInvoice2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbInvoice2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbInvoice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvoice2MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tbInvoice2);

        jPanel4.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 750, 160));

        btnInvoiceNew4.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceNew4.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceNew4.setText("New");
        btnInvoiceNew4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceNew4MouseClicked(evt);
            }
        });
        jPanel4.add(btnInvoiceNew4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 90, 30));

        btnInvoiceUpdate4.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceUpdate4.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceUpdate4.setText("Update");
        btnInvoiceUpdate4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceUpdate4MouseClicked(evt);
            }
        });
        jPanel4.add(btnInvoiceUpdate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 90, 30));

        btnInvoiceCancel4.setBackground(new java.awt.Color(0, 153, 153));
        btnInvoiceCancel4.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoiceCancel4.setText("Cancel");
        btnInvoiceCancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvoiceCancel4MouseClicked(evt);
            }
        });
        jPanel4.add(btnInvoiceCancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 90, 30));

        txtPaymentCreatebystaff4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentCreatebystaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 230, 20));

        jLabel82.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel82.setText("ProjectPlan List Name");
        jPanel4.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 150, 20));

        panelstaffmenu5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 1020, 250));

        jLabel90.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel90.setText("ProjectPlan List");
        panelstaffmenu5.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1010, 20));

        menuprojectplanList.getContentPane().add(panelstaffmenu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuprojectplanList, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

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

        menuprojectplanlist1111.setVisible(false);
        menuprojectplanlist1111.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        menuprojectplanlist1111.getContentPane().add(panelprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, -1));

        DesktopPane.add(menuprojectplanlist1111, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

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

        menuaddprojectplandetail.setVisible(false);

        javax.swing.GroupLayout menuaddprojectplandetailLayout = new javax.swing.GroupLayout(menuaddprojectplandetail.getContentPane());
        menuaddprojectplandetail.getContentPane().setLayout(menuaddprojectplandetailLayout);
        menuaddprojectplandetailLayout.setHorizontalGroup(
            menuaddprojectplandetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
        );
        menuaddprojectplandetailLayout.setVerticalGroup(
            menuaddprojectplandetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        DesktopPane.add(menuaddprojectplandetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

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
        
        menuhome.setVisible(true);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
        
        
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("HOME");
    }//GEN-LAST:event_panelmenuhomeMouseClicked

    private void panelmenustaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMouseClicked

        menuhome.setVisible(false);
        menutablestaff.setVisible(true);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
        
        showlableonclickedmenu.setText("");
        labelgidelineoftalestaff.setText("EMPLOYEE / STAFF / VIEW");
        getroleIDNrefreshtablestaff();
        
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("STAFF");
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
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(true);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
        
        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("WORKER");
        
        labelgidelineoftalebworker.setText("EMPLOYEE / WORKER / VIEW");
        getroleIDNrefreshtableworker();
        
        
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
        menuhome.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
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
        menuhome.setVisible(true);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(true);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
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
        menuhome.setVisible(true);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(true);
        menuprojectplan.setVisible(false);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
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
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(true);
        menutableprojectplanlist.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(false);
    }//GEN-LAST:event_panelmenprojectplanlistMouseClicked

    private void btnviewProjectplanlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewProjectplanlistMouseClicked
        menuprojectplanlist1111.setVisible(false);    
        menutableprojectplanlist.setVisible(true);  
    }//GEN-LAST:event_btnviewProjectplanlistMouseClicked

    private void btnProplanlistAddnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProplanlistAddnewMouseClicked
        menutableprojectplanlist.setVisible(false);
        menuprojectplanlist1111.setVisible(true);
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
        cboStaffroleID.removeAllItems();
        cboStaffroleID.addItem("None");
        cboStaffroleID.setSelectedItem("None");
        cboStaffStatus.setSelectedItem("None");
        labelpictureStaff.setIcon(null);
        
        try{
           
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
            model.addColumn("Role");
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
    public void getroleIDNrefreshtableworker(){
        txtworkerID.setText("");
        txtworkerName.setText("");
        cboworkercreatebystaff.removeAllItems();
        cboworkercreatebystaff.addItem("select");
        cboworkercreatebystaff.setSelectedItem("select");
        cboworkercreatebystaff.setSelectedItem("select");
        cboworkerGender.setSelectedItem("select");
        txtworkerAddress.setText("");
        txtworkerBirthday.setDate(null);
        txtworkerHiredDate.setDate(null);
        txtworkerPhone.setText("");
        txtworkerSalary.setText("");
        cboworkerroleID.removeAllItems();
        cboworkerroleID.addItem("select");
        cboworkerroleID.setSelectedItem("select");
        cboworkerStatus.setSelectedItem("select");
        labelpictureworker.setIcon(null);
        txtworkerName.requestFocus();
        
        try{
           
            //getroleID
            String selectroleid = "select id from tbRole";
            PreparedStatement pss = con.prepareStatement(selectroleid);
            ResultSet rss = pss.executeQuery();
            while (rss.next()){
                cboworkerroleID.addItem(rss.getString(1));
            }
            
            //getstaffname
            String selectstaffname = "select id from tbStaff";
            PreparedStatement psw = con.prepareStatement(selectstaffname);
            ResultSet rsw = psw.executeQuery();
            while (rsw.next()){
                cboworkercreatebystaff.addItem(rsw.getString(1));
            }
            
            //refreshtableWorker
            String selectalltbWorker = "select * from tbWorker";
            PreparedStatement pst = con.prepareStatement(selectalltbWorker);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbworker.setModel(model);
            tbworkerview.setModel(model);
            
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Gender");
            model.addColumn("Birthday");
            model.addColumn("Hired Date");
            model.addColumn("Salary");
            model.addColumn("Phone Number");
            model.addColumn("Address");
            model.addColumn("Role");
            model.addColumn("Staff Name");
            model.addColumn("Status");
                                    
            while (rst.next()){
                model.addRow(new Object[]{rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),
                            rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(10),rst.getString(11),rst.getString(12)});
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
            labelmessagestaff.setText("Update staff successfully.");
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

    private void btnopenmenuworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnopenmenuworkerMouseClicked
        menuworker.setVisible(true);
        getroleIDNrefreshtableworker();
        labelgidelineofmenuWorker.setText("EMPLOYEE / WORKER / CREATE");
    }//GEN-LAST:event_btnopenmenuworkerMouseClicked

    private void btnEdittableworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittableworkerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittableworkerMouseClicked

    private void tbworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbworkerMouseClicked
        try{
            int i = tbworker.getSelectedRow();
            TableModel tm = tbworker.getModel();
            txtworkerID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey  = "select * from tbWorker where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtworkerID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txtworkerName.setText(rs.getString(2));
                cboworkercreatebystaff.setSelectedItem(rs.getString(11));
                cboworkerGender.setSelectedItem(rs.getString(3));
                
                String str = rs.getString(4);
                String str1 = rs.getString(5);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date bdate = formatter.parse(str);
                java.util.Date hdate = formatter.parse(str1);
                
                txtworkerBirthday.setDate(bdate);
                txtworkerHiredDate.setDate(hdate);
                txtworkerSalary.setText(rs.getString(6));
                txtworkerPhone.setText(rs.getString(7));
                txtworkerAddress.setText(rs.getString(8));
                
                                
                Blob im = rs.getBlob(9);
                byte[] imbyte  = im.getBytes(1, (int)im.length());
                InputStream in = new ByteArrayInputStream(imbyte);
                BufferedImage imgFromDb = ImageIO.read(in);
                Image scaledImage = imgFromDb.getScaledInstance(labelpictureworker.getWidth(), labelpictureworker.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);              
                labelpictureworker.setIcon(icon);
                
                cboworkerroleID.setSelectedItem(rs.getString(10));
                cboworkerStatus.setSelectedItem(rs.getString(12));

            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbworkerMouseClicked

    private void btnworkerNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerNewMouseClicked
        if (txtworkerName.getText().trim().isEmpty() && cboworkercreatebystaff.getSelectedItem() == "select" && cboworkerGender.getSelectedItem() == "select" &&
            txtworkerAddress.getText().trim().isEmpty() && txtworkerBirthday.getDate() == null && txtworkerHiredDate.getDate() == null && txtworkerSalary.getText().trim().isEmpty() && 
            txtworkerPhone.getText().trim().isEmpty() && cboworkerroleID.getSelectedItem() == "select" && cboworkerStatus.getSelectedItem() == "select" ){
            
            labelworkerNamerequired.setText("required.");
            labelworkercreatebystaff.setText("required.");
            labelworkergenderrequired.setText("required.");
            labelworkeraddrerequired.setText("required.");
            labelworkerbirthrequired.setText("required.");
            labelworkerhirdrequired.setText("required.");
            labelworkersaryequired.setText("required.");
            labelworkerphonerequired.setText("required.");
            labelworkerroleidrequired.setText("required.");
            labelworkerstaturequired.setText("required.");
            txtworkerName.requestFocus();
            
        }
                
        else if (txtworkerName.getText().trim().isEmpty() ){
            labelworkerNamerequired.setText("required.");
            txtworkerName.requestFocus();
        }             
        else if (cboworkercreatebystaff.getSelectedItem() == "select"){
            labelworkercreatebystaff.setText("required.");
            cboworkercreatebystaff.requestFocus();
            }
        else if (cboworkerGender.getSelectedItem() == "select"){
            labelworkergenderrequired.setText("required.");
            cboworkerGender.requestFocus();
            }
        else if (txtworkerAddress.getText().trim().isEmpty()){
            labelworkeraddrerequired.setText("required.");
            txtworkerAddress.requestFocus();
        }
        else if (txtworkerBirthday.getDate() == null){
            labelworkerbirthrequired.setText("required.");
            txtworkerBirthday.requestFocus();
        }
        else if (txtworkerHiredDate.getDate() == null ){
            labelworkerhirdrequired.setText("required.");
            txtworkerHiredDate.requestFocus();
        }
        else if (txtworkerPhone.getText().trim().isEmpty()){
            labelworkerphonerequired.setText("required.");
            txtworkerPhone.requestFocus();
        }
        else if (cboworkerroleID.getSelectedItem() == "None"){
            labelworkerroleidrequired.setText("required.");
            cboworkerroleID.requestFocus();
        }
        else if(cboworkerStatus.getSelectedItem() == "None"){
            labelworkerstaturequired.setText("required.");
            cboworkerStatus.requestFocus();
        }
        else{
       
            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbWorker where name='" + txtworkerName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true){
                    labelmessageworker.setText("worker Create already.");
                }
                else{
                    String queryworker = "insert into tbWorker(name,gender,birthday,hired_date,salary,phone,address,photo,role_id,staff_id,status)values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(queryworker);

                    pst.setString(1, txtworkerName.getText().trim());
                    pst.setString(2, cboworkerGender.getSelectedItem().toString());

                    pst.setString(3,((JTextField)txtworkerBirthday.getDateEditor().getUiComponent()).getText());
                    pst.setString(4,((JTextField)txtworkerHiredDate.getDateEditor().getUiComponent()).getText());

                    pst.setString(5, txtworkerSalary.getText().trim());
                    pst.setString(6, txtworkerPhone.getText().trim());
                    pst.setString(7, txtworkerAddress.getText().trim());

                    pst.setBytes(8, worker_image);

                    pst.setString(9,cboworkerroleID.getSelectedItem().toString());
                    pst.setString(10,cboworkercreatebystaff.getSelectedItem().toString());
                    pst.setString(11, cboworkerStatus.getSelectedItem().toString());
                    
                    pst.executeUpdate();
                    labelmessageworker.setText("Create worker sucessfully.");
                    getroleIDNrefreshtableworker();

                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
    }//GEN-LAST:event_btnworkerNewMouseClicked

    private void btnworkerUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerUpdateMouseClicked
  
        int s = tbworker.getSelectedRow();
        try{
            String value=(tbworker.getModel().getValueAt(s, 0).toString());
            String updateworker = "update tbWorker SET name=?, gender=?, birthday=?, hired_date=?, salary=?, phone=?, address=?, photo=?, role_id=?,staff_id=?, status=?  where id="+value;
            PreparedStatement psf = con.prepareStatement(updateworker);
            
            psf.setString(1, txtworkerName.getText().trim());
            psf.setString(2, cboworkerGender.getSelectedItem().toString());
            
            psf.setString(3,((JTextField)txtworkerBirthday.getDateEditor().getUiComponent()).getText());
            psf.setString(4,((JTextField)txtworkerHiredDate.getDateEditor().getUiComponent()).getText());
            
            psf.setString(5, txtworkerSalary.getText().trim());
            psf.setString(6, txtworkerPhone.getText().trim());
            psf.setString(7, txtworkerAddress.getText().trim());
            
            psf.setBytes(8, worker_image);
            
            psf.setString(9, cboworkerroleID.getSelectedItem().toString());
            psf.setString(10, cboworkercreatebystaff.getSelectedItem().toString());
            psf.setString(11, cboworkerStatus.getSelectedItem().toString());
            psf.executeUpdate();
            labelmessageworker.setText("Update worker successfully.");
            getroleIDNrefreshtableworker();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnworkerUpdateMouseClicked

    private void btnworkerCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerCancelMouseClicked
        txtworkerID.setText("");
        txtworkerName.setText("");
        cboworkercreatebystaff.removeAllItems();
        cboworkercreatebystaff.addItem("select");
        cboworkercreatebystaff.setSelectedItem("select");
        cboworkercreatebystaff.setSelectedItem("select");
        cboworkerGender.setSelectedItem("select");
        txtworkerAddress.setText("");
        txtworkerBirthday.setDate(null);
        txtworkerHiredDate.setDate(null);
        txtworkerPhone.setText("");
        txtworkerSalary.setText("");
        cboworkerroleID.removeAllItems();
        cboworkerroleID.addItem("select");
        cboworkerroleID.setSelectedItem("select");
        cboworkerStatus.setSelectedItem("select");
        labelpictureworker.setIcon(null);
        txtworkerName.requestFocus();
    }//GEN-LAST:event_btnworkerCancelMouseClicked

    private void btnWorkerChoosepictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWorkerChoosepictureMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(labelpictureworker.getWidth(),labelpictureworker.getHeight(),Image.SCALE_SMOOTH));
        labelpictureworker.setIcon(imageIcon);
        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum;(readNum=fis.read(buf)) !=-1;){
                bos.write(buf,0,readNum);
            }
            worker_image=bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }//GEN-LAST:event_btnWorkerChoosepictureMouseClicked

    private void btnWorkerChoosepictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkerChoosepictureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWorkerChoosepictureActionPerformed

    private void tbPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPaymentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPaymentMouseClicked

    private void btnPaymentCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentCancelMouseClicked

    private void btnPaymentUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentUpdateMouseClicked

    private void btnPaymentNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentNewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentNewMouseClicked

    private void tbInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoiceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbInvoiceMouseClicked

    private void btnInvoiceNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceNewMouseClicked

    private void btnInvoiceUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceUpdateMouseClicked

    private void btnInvoiceCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceCancelMouseClicked

    private void tbInvoice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoice1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbInvoice1MouseClicked

    private void btnInvoiceNew1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNew1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceNew1MouseClicked

    private void btnInvoiceUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdate1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceUpdate1MouseClicked

    private void btnInvoiceCancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceCancel1MouseClicked

    private void tbInvoice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoice2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbInvoice2MouseClicked

    private void btnInvoiceNew2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNew2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceNew2MouseClicked

    private void btnInvoiceUpdate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdate2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceUpdate2MouseClicked

    private void btnInvoiceCancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceCancel2MouseClicked

    private void btnInvoiceNew3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNew3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceNew3MouseClicked

    private void btnInvoiceUpdate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdate3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceUpdate3MouseClicked

    private void btnInvoiceCancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceCancel3MouseClicked

    private void tbInvoice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoice3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbInvoice3MouseClicked

    private void tbInvoice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoice4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbInvoice4MouseClicked

    private void btnInvoiceNew4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNew4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceNew4MouseClicked

    private void btnInvoiceUpdate4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdate4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceUpdate4MouseClicked

    private void btnInvoiceCancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvoiceCancel4MouseClicked

    private void panelmenprojectplanlist1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlist1MouseClicked
        menuhome.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menuuser.setVisible(false);
        menutableprojectplanlistdetail.setVisible(false);
        menuprojectplanList.setVisible(true);
    }//GEN-LAST:event_panelmenprojectplanlist1MouseClicked

    private void panelmenprojectplanlist1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlist1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenprojectplanlist1MousePressed
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
    private javax.swing.JButton btnEdittableworker;
    private javax.swing.JButton btnInvoiceCancel;
    private javax.swing.JButton btnInvoiceCancel1;
    private javax.swing.JButton btnInvoiceCancel2;
    private javax.swing.JButton btnInvoiceCancel3;
    private javax.swing.JButton btnInvoiceCancel4;
    private javax.swing.JButton btnInvoiceNew;
    private javax.swing.JButton btnInvoiceNew1;
    private javax.swing.JButton btnInvoiceNew2;
    private javax.swing.JButton btnInvoiceNew3;
    private javax.swing.JButton btnInvoiceNew4;
    private javax.swing.JButton btnInvoiceUpdate;
    private javax.swing.JButton btnInvoiceUpdate1;
    private javax.swing.JButton btnInvoiceUpdate2;
    private javax.swing.JButton btnInvoiceUpdate3;
    private javax.swing.JButton btnInvoiceUpdate4;
    private javax.swing.JButton btnPaymentCancel;
    private javax.swing.JButton btnPaymentNew;
    private javax.swing.JButton btnPaymentUpdate;
    private javax.swing.JButton btnProplanlistAddPlanDetail;
    private javax.swing.JButton btnProplanlistAddnew;
    private javax.swing.JButton btnProplanlistEdit;
    private javax.swing.JButton btnStaffCancel;
    private javax.swing.JButton btnStaffChoosepicture;
    private javax.swing.JButton btnStaffNew;
    private javax.swing.JButton btnStaffUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnViewprojectplandetail;
    private javax.swing.JButton btnWorkerChoosepicture;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnopenmenustaffaddnew;
    private javax.swing.JButton btnopenmenuworker;
    private javax.swing.JButton btnsignin;
    private javax.swing.JButton btnupdateprojectplandetail1;
    private javax.swing.JButton btnupdateprojectplanlist;
    private javax.swing.JButton btnviewProjectplanlist;
    private javax.swing.JButton btnworkerCancel;
    private javax.swing.JButton btnworkerNew;
    private javax.swing.JButton btnworkerUpdate;
    private javax.swing.JComboBox<String> cboPaymentCutomerName;
    private javax.swing.JComboBox<String> cboPaymentCutomerName1;
    private javax.swing.JComboBox<String> cboPaymentCutomerName2;
    private javax.swing.JComboBox<String> cboPaymentCutomerName3;
    private javax.swing.JComboBox<String> cboPaymentCutomerName4;
    private javax.swing.JComboBox<String> cboPaymentCutomerName5;
    private javax.swing.JComboBox<String> cboPaymentCutomerName6;
    private javax.swing.JComboBox<String> cboPaymentCutomerName8;
    private javax.swing.JComboBox<String> cboPaymentCutomerName9;
    private javax.swing.JComboBox cboProplanlistsearch;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JComboBox<String> cboStaffGender;
    private javax.swing.JComboBox<String> cboStaffStatus;
    private javax.swing.JComboBox<String> cboStaffroleID;
    private javax.swing.JComboBox<String> cboposition;
    private javax.swing.JComboBox cboprojectplanIDFK;
    private javax.swing.JComboBox cbostaffIDFK;
    private javax.swing.JComboBox<String> cbostaffName;
    private javax.swing.JComboBox<String> cboworkerGender;
    private javax.swing.JComboBox<String> cboworkerStatus;
    private javax.swing.JComboBox<String> cboworkercreatebystaff;
    private javax.swing.JComboBox<String> cboworkerroleID;
    private javax.swing.JLabel conpassworderror;
    private javax.swing.JLabel homemenulable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelclient;
    private javax.swing.JLabel labelerrorfinishdate;
    private javax.swing.JLabel labelerrorprojectplan;
    private javax.swing.JLabel labelerrorprojectplanID;
    private javax.swing.JLabel labelerrorprojectplanlistID;
    private javax.swing.JLabel labelerrorstaffID;
    private javax.swing.JLabel labelerrorstartdate;
    private javax.swing.JLabel labelgidelineofmenuPayment;
    private javax.swing.JLabel labelgidelineofmenuPayment1;
    private javax.swing.JLabel labelgidelineofmenuPayment2;
    private javax.swing.JLabel labelgidelineofmenuPayment3;
    private javax.swing.JLabel labelgidelineofmenuWorker;
    private javax.swing.JLabel labelgidelineofmenustaff;
    private javax.swing.JLabel labelgidelineoftalebworker;
    private javax.swing.JLabel labelgidelineoftalestaff;
    private javax.swing.JLabel labelmessagestaff;
    private javax.swing.JLabel labelmessageworker;
    private javax.swing.JLabel labelmessageworker1;
    private javax.swing.JLabel labelmessageworker2;
    private javax.swing.JLabel labelmessageworker3;
    private javax.swing.JLabel labelmessageworker4;
    private javax.swing.JLabel labelmessageworker5;
    private javax.swing.JLabel labelpaymentNamerequired;
    private javax.swing.JLabel labelpaymentNamerequired1;
    private javax.swing.JLabel labelpaymentNamerequired2;
    private javax.swing.JLabel labelpaymentNamerequired3;
    private javax.swing.JLabel labelpaymentNamerequired4;
    private javax.swing.JLabel labelpaymentcreatebystaff;
    private javax.swing.JLabel labelpaymentcreatebystaff1;
    private javax.swing.JLabel labelpaymentcreatebystaff2;
    private javax.swing.JLabel labelpaymentcreatebystaff3;
    private javax.swing.JLabel labelpaymentcreatebystaff4;
    private javax.swing.JLabel labelpaymentdatehirdrequired;
    private javax.swing.JLabel labelpaymentdatehirdrequired1;
    private javax.swing.JLabel labelpaymentgenderrequired;
    private javax.swing.JLabel labelpaymentgenderrequired1;
    private javax.swing.JLabel labelpaymentgenderrequired10;
    private javax.swing.JLabel labelpaymentgenderrequired11;
    private javax.swing.JLabel labelpaymentgenderrequired12;
    private javax.swing.JLabel labelpaymentgenderrequired13;
    private javax.swing.JLabel labelpaymentgenderrequired14;
    private javax.swing.JLabel labelpaymentgenderrequired2;
    private javax.swing.JLabel labelpaymentgenderrequired3;
    private javax.swing.JLabel labelpaymentgenderrequired4;
    private javax.swing.JLabel labelpaymentgenderrequired5;
    private javax.swing.JLabel labelpaymentgenderrequired6;
    private javax.swing.JLabel labelpaymentgenderrequired7;
    private javax.swing.JLabel labelpaymentgenderrequired8;
    private javax.swing.JLabel labelpaymentgenderrequired9;
    private javax.swing.JLabel labelpictureStaff;
    private javax.swing.JLabel labelpictureworker;
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
    private javax.swing.JLabel labelworkerNamerequired;
    private javax.swing.JLabel labelworkeraddrerequired;
    private javax.swing.JLabel labelworkerbirthrequired;
    private javax.swing.JLabel labelworkercreatebystaff;
    private javax.swing.JLabel labelworkergenderrequired;
    private javax.swing.JLabel labelworkerhirdrequired;
    private javax.swing.JLabel labelworkerphonerequired;
    private javax.swing.JLabel labelworkerroleidrequired;
    private javax.swing.JLabel labelworkerroleidrequired1;
    private javax.swing.JLabel labelworkerroleidrequired2;
    private javax.swing.JLabel labelworkerroleidrequired3;
    private javax.swing.JLabel labelworkerroleidrequired4;
    private javax.swing.JLabel labelworkerroleidrequired5;
    private javax.swing.JLabel labelworkersaryequired;
    private javax.swing.JLabel labelworkerstaturequired;
    private javax.swing.JLabel lablegidelineprojectplanlist;
    private javax.swing.JLabel lableshownamelogin;
    private javax.swing.JLabel lablewelcome;
    private javax.swing.JInternalFrame menuaddprojectplandetail;
    private javax.swing.JInternalFrame menucustomer;
    private javax.swing.JInternalFrame menuhome;
    private javax.swing.JInternalFrame menuinvoice;
    private javax.swing.JInternalFrame menupayment;
    private javax.swing.JInternalFrame menuprojectplan;
    private javax.swing.JInternalFrame menuprojectplanList;
    private javax.swing.JInternalFrame menuprojectplanlist1111;
    private javax.swing.JInternalFrame menustaff;
    private javax.swing.JInternalFrame menutableprojectplanlist;
    private javax.swing.JInternalFrame menutableprojectplanlistdetail;
    private javax.swing.JInternalFrame menutablestaff;
    private javax.swing.JInternalFrame menutableworker;
    private javax.swing.JInternalFrame menuuser;
    private javax.swing.JInternalFrame menuworker;
    private javax.swing.JPanel panelbar;
    private javax.swing.JPanel panelclicked1;
    private javax.swing.JPanel panelclicked2;
    private javax.swing.JPanel panelclicked3;
    private javax.swing.JPanel panelclicked4;
    private javax.swing.JPanel panelclicked5;
    private javax.swing.JPanel panelclicked6;
    private javax.swing.JPanel panelclicked7;
    private javax.swing.JPanel panelclicked8;
    private javax.swing.JPanel panelclicked9;
    private javax.swing.JPanel panelcreateuser;
    private javax.swing.JPanel panelcustomer;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelmencutomer;
    private javax.swing.JPanel panelmenprojectplanlist;
    private javax.swing.JPanel panelmenprojectplanlist1;
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
    private javax.swing.JPanel panelstaffinfomation1;
    private javax.swing.JPanel panelstaffinfomation2;
    private javax.swing.JPanel panelstaffinfomation3;
    private javax.swing.JPanel panelstaffinfomation4;
    private javax.swing.JPanel panelstaffinfomation5;
    private javax.swing.JPanel panelstaffinfomation6;
    private javax.swing.JPanel panelstaffmenu;
    private javax.swing.JPanel panelstaffmenu1;
    private javax.swing.JPanel panelstaffmenu2;
    private javax.swing.JPanel panelstaffmenu3;
    private javax.swing.JPanel panelstaffmenu4;
    private javax.swing.JPanel panelstaffmenu5;
    private javax.swing.JPanel panelsuppliers;
    private javax.swing.JPanel paneltableprojectplanlist;
    private javax.swing.JPanel paneltablestaff;
    private javax.swing.JPanel paneltablestaff1;
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
    private javax.swing.JLabel staffmenulable7;
    private javax.swing.JLabel staffnamerror;
    private javax.swing.JLabel sucessfulllable;
    private javax.swing.JTable tbInvoice;
    private javax.swing.JTable tbInvoice1;
    private javax.swing.JTable tbInvoice2;
    private javax.swing.JTable tbInvoice3;
    private javax.swing.JTable tbInvoice4;
    private javax.swing.JTable tbPayment;
    private javax.swing.JTable tbProjectplanlistview;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTable tblistprojectplan;
    private javax.swing.JTable tbprojectlanlistdetail;
    private javax.swing.JTable tbprojectplanlist;
    private javax.swing.JTable tbstaffview;
    private javax.swing.JTable tbviewuser;
    private javax.swing.JTable tbworker;
    private javax.swing.JTable tbworkerview;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff1;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff2;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff3;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff4;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff5;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff6;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff7;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff8;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff9;
    private com.toedter.calendar.JDateChooser txtPaymentDate;
    private com.toedter.calendar.JDateChooser txtPaymentDate1;
    private com.toedter.calendar.JDateChooser txtPaymentDate2;
    private com.toedter.calendar.JDateChooser txtPaymentDate3;
    private com.toedter.calendar.JDateChooser txtPaymentDate4;
    private com.toedter.calendar.JDateChooser txtPaymentDate5;
    private com.toedter.calendar.JDateChooser txtPaymentDate6;
    private javax.swing.JTextField txtPaymentID;
    private javax.swing.JTextField txtPaymentID1;
    private javax.swing.JTextField txtPaymentID10;
    private javax.swing.JTextField txtPaymentID11;
    private javax.swing.JTextField txtPaymentID12;
    private javax.swing.JTextField txtPaymentID14;
    private javax.swing.JTextField txtPaymentID2;
    private javax.swing.JTextField txtPaymentID3;
    private javax.swing.JTextField txtPaymentID4;
    private javax.swing.JTextField txtPaymentID5;
    private javax.swing.JTextField txtPaymentID6;
    private javax.swing.JTextField txtPaymentID7;
    private javax.swing.JTextField txtPaymentID8;
    private javax.swing.JTextField txtPaymentPaidAmount;
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
    private javax.swing.JTextField txtworkerAddress;
    private com.toedter.calendar.JDateChooser txtworkerBirthday;
    private com.toedter.calendar.JDateChooser txtworkerHiredDate;
    private javax.swing.JTextField txtworkerID;
    private javax.swing.JTextField txtworkerName;
    private javax.swing.JTextField txtworkerPhone;
    private javax.swing.JTextField txtworkerSalary;
    private javax.swing.JLabel usernameerror;
    // End of variables declaration//GEN-END:variables
}
