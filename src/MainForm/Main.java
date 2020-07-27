package MainForm;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import Application.Application;
import Controller.ConstractionEquiment;
import Controller.Customer;
import Controller.Import;
import Controller.ImportDetails;
import Controller.ProjectInforamtion;
import Controller.Staff;
import Controller.Supplier;
import Controller.Usage;
import DateConvert.SimpleFormat;
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
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
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

    public void setHideAllMenus(JPanel jpanelName) {
        panelmenuhome.setBackground(paneldefault);
        panelclicked1.setBackground(paneldefault);
        panelclicked2.setBackground(paneldefault);
        panelclicked3.setBackground(paneldefault);
        panelclicked4.setBackground(paneldefault);
        panelclicked5.setBackground(paneldefault);
        panelclicked6.setBackground(paneldefault);
        panelclicked7.setBackground(paneldefault);
        panelclicked8.setBackground(paneldefault);
        panelclicked9.setBackground(paneldefault);
        panelclicked10.setBackground(paneldefault);
        panelclicked11.setBackground(paneldefault);
        panelclicked12.setBackground(paneldefault);
        panelclicked13.setBackground(paneldefault);
        jpanelName.setBackground(panelclick);
    }

    public void showList(JInternalFrame jFrameName) {
//        menuhome.setVisible(false);
//        menuuser.setVisible(false);
//        menutablestaff.setVisible(false);
//        menustaff.setVisible(false);
//        menucustomer.setVisible(false);
//        menupayment.setVisible(false);
//        menuinvoice.setVisible(false);
//        menuprojectplan.setVisible(false);
//        menutableprojectview.setVisible(false);
//        menuprojectplanList.setVisible(false);
//        menuworker.setVisible(false);
//        menutableworker.setVisible(false);

        supplier_list.setVisible(false);
        customer_list.setVisible(false);
        import_list.setVisible(false);
        usage_list.setVisible(false);
        ce_list.setVisible(false);
        jFrameName.setVisible(true);
    }

    public Main() {
        initComponents();
        setLocationRelativeTo(null);

        paneldefault = new Color(0, 204, 204);
        panelclick = new Color(0, 255, 0);

        setHideAllMenus(panelmenuuser);

        showlableonclickedmenu.setText("HOME");

        txtstaffID.setEditable(false);
        txtworkerID.setEnabled(false);
        txtPaymentID.setEnabled(false);
        txtInvoiceId.setEnabled(false);
        txtInvoiceCustomer.setEnabled(false);
        txtInvoiceTotalAmount.setEnabled(false);
        txtInvoicePaidAmount.setEnabled(false);
        txtInvoiceOwesAmount.setEnabled(false);
        txtProjectPlanID.setEnabled(false);
        txtProjectPlanListID.setEnabled(false);
        txtProjectPlanDetailID.setEnabled(false);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        countAll();

    }

    public void countAll() {

        try {
            //count staff
            String countstaff = "select count(name) from tbStaff";
            PreparedStatement ps = con.prepareStatement(countstaff);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int counts = rs.getInt(1);
            labeltotalstaff.setHorizontalAlignment(SwingConstants.CENTER);
            labeltotalstaff.setText("Total: " + Integer.toString(counts));

            //count worker
            String countworker = "select count(name) from tbWorker";
            PreparedStatement psw = con.prepareStatement(countworker);
            ResultSet rss = psw.executeQuery();
            rss.next();
            int countw = rss.getInt(1);
            labeltotalworker.setHorizontalAlignment(SwingConstants.CENTER);
            labeltotalworker.setText("Total: " + Integer.toString(countw));
            //count customer

            //count payment
            String counpayment = "select count(id) from tbPayment";
            PreparedStatement psp = con.prepareStatement(counpayment);
            ResultSet rsp = psp.executeQuery();
            rsp.next();
            int countp = rsp.getInt(1);
            labeltotalpayment.setHorizontalAlignment(SwingConstants.CENTER);
            labeltotalpayment.setText("Total: " + Integer.toString(countp));

            //count invoice
            String countinvoice = "select count(id) from tbInvoice";
            PreparedStatement psi = con.prepareStatement(countinvoice);
            ResultSet rsi = psi.executeQuery();
            rsi.next();
            int counti = rsi.getInt(1);
            labeltotalinvoice.setHorizontalAlignment(SwingConstants.CENTER);
            labeltotalinvoice.setText("Total: " + Integer.toString(counti));
            //count worker
            String countprojectplan = "select count(id) from tbProjectPlan";
            PreparedStatement pspr = con.prepareStatement(countprojectplan);
            ResultSet rspr = pspr.executeQuery();
            rspr.next();
            int countpr = rspr.getInt(1);
            labeltotalprojectplan.setHorizontalAlignment(SwingConstants.CENTER);
            labeltotalprojectplan.setText("Total: " + Integer.toString(countpr));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void getusername(String user) {
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

    public void disablemenu() {
        panelmenuhome.setVisible(false);
        panelmenustaff.setVisible(false);
        panelmenworker.setVisible(false);
        panelmenpayment.setVisible(false);
        panelmenuinvoice.setVisible(false);
        panelmenprojectplan.setVisible(false);
        panelmenprojectplanlist.setVisible(false);
        panelmenprojectplanview.setVisible(false);
        panelmenuuser.setVisible(true);
    }

    public void create() {
        panelmenuhome.setVisible(false);
        panelmenustaff.setVisible(false);
        panelmenworker.setVisible(false);
        menuCustomer.setVisible(false);
        panelmenpayment.setVisible(false);
        panelmenuinvoice.setVisible(false);
        panelmenprojectplan.setVisible(false);
        panelmenprojectplanlist.setVisible(false);
        panelmenprojectplanview.setVisible(false);
        panelmenImport.setVisible(false);
        menuCE.setVisible(false);
        menuSupplier.setVisible(false);
        menuUsage.setVisible(false);
        panelmenuuser.setVisible(true);
        panelmenuuser.setBackground(paneldefault);
        panelclicked15.setBackground(panelclick);
        lableshownamelogin.setVisible(false);
        btnlogout.setVisible(false);       

        refreshtable();
        showlableonclickedmenu.setText("USER");
        menuuser.setVisible(true);

    }

    public void openhome() {
        menuhome.setVisible(true);
    }

    public void closeuser() {
        panelmenuuser.setVisible(false);
        menuuser.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelbar = new javax.swing.JPanel();
        lableshownamelogin = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        showlableonclickedmenu = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        panelmenu = new javax.swing.JPanel();
        lablewelcome = new javax.swing.JLabel();
        panelmenustaff = new javax.swing.JPanel();
        panelclicked2 = new javax.swing.JPanel();
        staffmenulable = new javax.swing.JLabel();
        panelmenworker = new javax.swing.JPanel();
        panelclicked3 = new javax.swing.JPanel();
        staffmenulable1 = new javax.swing.JLabel();
        menuCustomer = new javax.swing.JPanel();
        panelclicked4 = new javax.swing.JPanel();
        staffmenulable2 = new javax.swing.JLabel();
        panelmenpayment = new javax.swing.JPanel();
        panelclicked5 = new javax.swing.JPanel();
        staffmenulable3 = new javax.swing.JLabel();
        panelmenuinvoice = new javax.swing.JPanel();
        panelclicked6 = new javax.swing.JPanel();
        staffmenulable5 = new javax.swing.JLabel();
        panelmenprojectplan = new javax.swing.JPanel();
        panelclicked7 = new javax.swing.JPanel();
        staffmenulable6 = new javax.swing.JLabel();
        panelmenprojectplanlist = new javax.swing.JPanel();
        panelclicked8 = new javax.swing.JPanel();
        staffmenulable7 = new javax.swing.JLabel();
        panelmenprojectplanview = new javax.swing.JPanel();
        panelclicked9 = new javax.swing.JPanel();
        staffmenulable8 = new javax.swing.JLabel();
        panelmenImport = new javax.swing.JPanel();
        panelclicked10 = new javax.swing.JPanel();
        staffmenulable10 = new javax.swing.JLabel();
        menuCE = new javax.swing.JPanel();
        panelclicked11 = new javax.swing.JPanel();
        staffmenulable12 = new javax.swing.JLabel();
        menuSupplier = new javax.swing.JPanel();
        panelclicked12 = new javax.swing.JPanel();
        staffmenulable9 = new javax.swing.JLabel();
        menuUsage = new javax.swing.JPanel();
        panelclicked13 = new javax.swing.JPanel();
        staffmenulable11 = new javax.swing.JLabel();
        panelmenuuser = new javax.swing.JPanel();
        panelclicked15 = new javax.swing.JPanel();
        staffmenulable14 = new javax.swing.JLabel();
        panelmenuhome = new javax.swing.JPanel();
        panelclicked1 = new javax.swing.JPanel();
        homemenulable = new javax.swing.JLabel();
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
        jLabel18 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        menuhome = new javax.swing.JInternalFrame();
        panelhome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelproject = new javax.swing.JPanel();
        labelproject = new javax.swing.JLabel();
        labeltotalworker = new javax.swing.JLabel();
        panelcustomer = new javax.swing.JPanel();
        labelclient = new javax.swing.JLabel();
        labeltotalclient = new javax.swing.JLabel();
        panelstaff = new javax.swing.JPanel();
        labelstaff = new javax.swing.JLabel();
        labeltotalstaff = new javax.swing.JLabel();
        panelsuppliers = new javax.swing.JPanel();
        labelsuppliers = new javax.swing.JLabel();
        labeltotalpayment = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        labeltotalinvoice = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        labeltotalprojectplan = new javax.swing.JLabel();
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
        cboStaffroleID = new javax.swing.JComboBox<>();
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
        btnworkerNew = new javax.swing.JButton();
        cboworkerStatus = new javax.swing.JComboBox<>();
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
        btnPaymentclear = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        labelmessageworker1 = new javax.swing.JLabel();
        labelworkerroleidrequired1 = new javax.swing.JLabel();
        labelpaymentstaffrequire = new javax.swing.JLabel();
        labelpaymentCustomerrequired = new javax.swing.JLabel();
        labelpaymentPaymentrequired = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        cboPaymentCreatebystaff = new javax.swing.JComboBox<>();
        labelpaymentPaidrequired = new javax.swing.JLabel();
        labelpaymentresult = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txtPaymentTotalAmount = new javax.swing.JTextField();
        labelpaymentTotalrequired = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        txtPaymentOwesAmount = new javax.swing.JTextField();
        labelpaymentOwesrequired = new javax.swing.JLabel();
        menuinvoice = new javax.swing.JInternalFrame();
        panelstaffmenu3 = new javax.swing.JPanel();
        labelgidelineofmenuPayment1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbInvoice = new javax.swing.JTable();
        panelstaffinfomation3 = new javax.swing.JPanel();
        txtInvoiceId = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtInvoiceDate = new com.toedter.calendar.JDateChooser();
        cboInvoicePaymentID = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        btnInvoiceNew = new javax.swing.JButton();
        btnInvoiceUpdate = new javax.swing.JButton();
        btnInvoiceCancel = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        labelmessageworker2 = new javax.swing.JLabel();
        labelInvoicePaymentIDrequired = new javax.swing.JLabel();
        labelInvoicestaffrequired = new javax.swing.JLabel();
        labelInvoiceDatterequired = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        cboInvoicestaffrName = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        txtInvoiceTotalAmount = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtInvoiceCustomer = new javax.swing.JTextField();
        txtInvoicePaidAmount = new javax.swing.JTextField();
        txtInvoiceOwesAmount = new javax.swing.JTextField();
        labelInvoiceResult = new javax.swing.JLabel();
        menuprojectplan = new javax.swing.JInternalFrame();
        panelstaffmenu4 = new javax.swing.JPanel();
        labelgidelineofmenuPayment2 = new javax.swing.JLabel();
        panelstaffinfomation4 = new javax.swing.JPanel();
        txtProjectPlanID = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        btnProjectPlan = new javax.swing.JButton();
        btnProjectPlanUpdate = new javax.swing.JButton();
        btnProjectPlanClear = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        labelmessageworker3 = new javax.swing.JLabel();
        labelworkerroleidrequired3 = new javax.swing.JLabel();
        labelProjectPlanTimeLine = new javax.swing.JLabel();
        labelProjectPlanName = new javax.swing.JLabel();
        labelProjectPlanInfoName = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        cboProjectPlanInfoName = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        cboProjectPlanStatus = new javax.swing.JComboBox<>();
        labelProjectPlanLocation = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbProjectPlan = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtProjectPlanLocation = new javax.swing.JTextArea();
        txtProjectPlanTimeLine = new com.toedter.calendar.JDateChooser();
        labelProjectPlanStatus = new javax.swing.JLabel();
        txtProjectPlanName = new javax.swing.JTextField();
        labelProjectPlanResult = new javax.swing.JLabel();
        menuprojectplanList = new javax.swing.JInternalFrame();
        panelstaffmenu5 = new javax.swing.JPanel();
        labelgidelineofmenuPayment3 = new javax.swing.JLabel();
        panelstaffinfomation5 = new javax.swing.JPanel();
        txtProjectPlanListID = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtProjectPlanListFinishDate = new com.toedter.calendar.JDateChooser();
        jLabel75 = new javax.swing.JLabel();
        btnProjectPlanListNew = new javax.swing.JButton();
        btnProjectPlanListUpdate = new javax.swing.JButton();
        btnProjectPlanListClear = new javax.swing.JButton();
        labelmessageworker4 = new javax.swing.JLabel();
        labelworkerroleidrequired4 = new javax.swing.JLabel();
        labelPPLName = new javax.swing.JLabel();
        labelPPLStaff = new javax.swing.JLabel();
        labelPPLFinishDate = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        cboProjectPlanList_ProjectPlanName = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        labelPPL_PPName = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txtProjectPlanListName = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        labelPPLStartDate = new javax.swing.JLabel();
        labelpaymentgenderrequired8 = new javax.swing.JLabel();
        labelPPLStatus = new javax.swing.JLabel();
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
        cboProjectPlanListStaff = new javax.swing.JComboBox<>();
        txtProjectPlanListStartDate = new com.toedter.calendar.JDateChooser();
        cboProjectPlanListStatus = new javax.swing.JComboBox<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbProjectPlanList = new javax.swing.JTable();
        cboProjectPlanListSelectProjectPlan = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        labelPPLResult = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        txtProjectPlanDetailName = new javax.swing.JTextField();
        txtProjectPlanDetailID = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtProjectPlanDetailDateline = new com.toedter.calendar.JDateChooser();
        cboProjectPlanDetail_ListName = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbProjectPlanListDetail = new javax.swing.JTable();
        btnProjectPlanListDetailNew = new javax.swing.JButton();
        btnProjectPlanDetailUpdate = new javax.swing.JButton();
        btnProjectPlanDetailClear = new javax.swing.JButton();
        txtPaymentCreatebystaff4 = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        labelPPLDResult = new javax.swing.JLabel();
        labelPPLDProjectplanListName = new javax.swing.JLabel();
        labelPPLDDetailname = new javax.swing.JLabel();
        labelPPLDDateline = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        menutableprojectview = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbViewProjectPlanList = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbViewProjectPlanListDetail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cboViewProjectPlanName = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        menutableprojectview1 = new javax.swing.JInternalFrame();
        paneltableprojectplanlist = new javax.swing.JPanel();
        cboProplanlistsearch = new javax.swing.JComboBox();
        lablegidelineprojectplanlist = new javax.swing.JLabel();
        btnProplanlistAddnew = new javax.swing.JButton();
        btnProplanlistAddPlanDetail = new javax.swing.JButton();
        btnProplanlistEdit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProjectplanlistview = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        import_form = new javax.swing.JInternalFrame();
        panelstaffmenu9 = new javax.swing.JPanel();
        bracImportForm = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tbImport_form = new javax.swing.JTable();
        panelstaffinfomation10 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        btnImportNew = new javax.swing.JButton();
        btnImportUpdate = new javax.swing.JButton();
        btnworkerCancel4 = new javax.swing.JButton();
        jLabel113 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txtImportDate = new javax.swing.JTextField();
        cbSupplierNameImport = new javax.swing.JComboBox<>();
        cbStaffNameImport = new javax.swing.JComboBox<>();
        panelstaffinfomation12 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        btnImportDetailsNew = new javax.swing.JButton();
        btnImportDetialUpdate = new javax.swing.JButton();
        btnworkerCancel6 = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        txtImportQtyImportDetails = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txtUnitPriceImportDetails = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        txtAmountImportDetails = new javax.swing.JTextField();
        cbCEImportDetails = new javax.swing.JComboBox<>();
        jLabel140 = new javax.swing.JLabel();
        txtImportId_Detail = new javax.swing.JTextField();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbImport_form_detail = new javax.swing.JTable();
        import_list = new javax.swing.JInternalFrame();
        panelCustomer3 = new javax.swing.JPanel();
        jScrollImport = new javax.swing.JScrollPane();
        tbImport = new javax.swing.JTable();
        lbBracImportList = new javax.swing.JLabel();
        btnImport = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        btnEdittablestaff4 = new javax.swing.JButton();
        jLabel107 = new javax.swing.JLabel();
        supplier_form = new javax.swing.JInternalFrame();
        panelstaffmenu7 = new javax.swing.JPanel();
        bracSupplierForm = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbSupplier_form = new javax.swing.JTable();
        panelstaffinfomation8 = new javax.swing.JPanel();
        txtSupplierName = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        txtSupplierAddress = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        btnSupplierNew = new javax.swing.JButton();
        btnSupplierUpdate = new javax.swing.JButton();
        btnSupplierClear = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        txtSupplierId = new javax.swing.JTextField();
        male1 = new javax.swing.JRadioButton();
        female1 = new javax.swing.JRadioButton();
        lbMessageSupplier = new javax.swing.JLabel();
        txtSupplierPhone = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        supplier_list = new javax.swing.JInternalFrame();
        panelCustomer1 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        lbBracSupplierList = new javax.swing.JLabel();
        btnSupplierCreate = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        btnEdittablestaff2 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        ce_form = new javax.swing.JInternalFrame();
        panelstaffmenu8 = new javax.swing.JPanel();
        bracCEForm = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbCE_form = new javax.swing.JTable();
        panelstaffinfomation9 = new javax.swing.JPanel();
        txtStockQty = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        btnCENew = new javax.swing.JButton();
        btnECUpdate = new javax.swing.JButton();
        btnCECancel = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        labelmessageworker8 = new javax.swing.JLabel();
        labelworkerroleidrequired8 = new javax.swing.JLabel();
        labelworkercreatebystaff3 = new javax.swing.JLabel();
        labelworkergenderrequired3 = new javax.swing.JLabel();
        labelworkerbirthrequired3 = new javax.swing.JLabel();
        labelworkersaryequired3 = new javax.swing.JLabel();
        labelworkerphonerequired3 = new javax.swing.JLabel();
        labelworkeraddrerequired3 = new javax.swing.JLabel();
        labelworkerstaturequired3 = new javax.swing.JLabel();
        txtCEName = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        ce_list = new javax.swing.JInternalFrame();
        panelCustomer2 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tbCE = new javax.swing.JTable();
        lbBracCEList = new javax.swing.JLabel();
        btnCE = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        btnEdittablestaff3 = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        usage_list = new javax.swing.JInternalFrame();
        panelCustomer4 = new javax.swing.JPanel();
        jScrollImport1 = new javax.swing.JScrollPane();
        tbUsage = new javax.swing.JTable();
        lbBracUsageList = new javax.swing.JLabel();
        btnUsage = new javax.swing.JButton();
        jComboBox10 = new javax.swing.JComboBox<>();
        btnEdittablestaff5 = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        usage_form = new javax.swing.JInternalFrame();
        panelstaffmenu10 = new javax.swing.JPanel();
        bracUsageForm = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbUsage_form = new javax.swing.JTable();
        panelstaffinfomation11 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        cbStaffUsage = new javax.swing.JComboBox<>();
        jLabel119 = new javax.swing.JLabel();
        cbCEUsage = new javax.swing.JComboBox<>();
        jLabel124 = new javax.swing.JLabel();
        txtDateUse = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        txtTotalQtyUsae = new javax.swing.JTextField();
        btnNewUsage = new javax.swing.JButton();
        btnNewUsage1 = new javax.swing.JButton();
        btnUpdateUsage = new javax.swing.JButton();
        customer_list = new javax.swing.JInternalFrame();
        panelCustomer = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();
        lbBracCustomerList = new javax.swing.JLabel();
        btnCustomer = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        btnEdittablestaff1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        customer_form = new javax.swing.JInternalFrame();
        panelstaffmenu6 = new javax.swing.JPanel();
        bracCustomerForm = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tbCustomer_form = new javax.swing.JTable();
        panelstaffinfomation7 = new javax.swing.JPanel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        btnCustomerNew = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnworkerCancel1 = new javax.swing.JButton();
        lbMessageCustomer = new javax.swing.JLabel();
        txtCustomerId = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel129 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        cboCustomer_CreatebyStaff = new javax.swing.JComboBox<>();
        jLabel132 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnworkerNew2 = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbProjectInformation = new javax.swing.JTable();

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

        lablewelcome.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lablewelcome.setForeground(new java.awt.Color(255, 255, 255));
        lablewelcome.setText("                   WELCOME");
        lablewelcome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

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
                .addGap(0, 105, Short.MAX_VALUE))
        );
        panelmenustaffLayout.setVerticalGroup(
            panelmenustaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

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
                .addGap(0, 105, Short.MAX_VALUE))
        );
        panelmenworkerLayout.setVerticalGroup(
            panelmenworkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuCustomer.setBackground(new java.awt.Color(0, 204, 204));
        menuCustomer.setPreferredSize(new java.awt.Dimension(155, 50));
        menuCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCustomerMousePressed(evt);
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

        javax.swing.GroupLayout menuCustomerLayout = new javax.swing.GroupLayout(menuCustomer);
        menuCustomer.setLayout(menuCustomerLayout);
        menuCustomerLayout.setHorizontalGroup(
            menuCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCustomerLayout.createSequentialGroup()
                .addComponent(panelclicked4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        menuCustomerLayout.setVerticalGroup(
            menuCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenpayment.setBackground(new java.awt.Color(0, 204, 204));
        panelmenpayment.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenpayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenpaymentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenpaymentMousePressed(evt);
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

        javax.swing.GroupLayout panelmenpaymentLayout = new javax.swing.GroupLayout(panelmenpayment);
        panelmenpayment.setLayout(panelmenpaymentLayout);
        panelmenpaymentLayout.setHorizontalGroup(
            panelmenpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenpaymentLayout.createSequentialGroup()
                .addComponent(panelclicked5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        panelmenpaymentLayout.setVerticalGroup(
            panelmenpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenuinvoice.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuinvoice.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenuinvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuinvoiceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuinvoiceMousePressed(evt);
            }
        });

        panelclicked6.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked6.setPreferredSize(new java.awt.Dimension(5, 38));

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

        staffmenulable5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable5.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        staffmenulable5.setText("   INVOICE");
        staffmenulable5.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenuinvoiceLayout = new javax.swing.GroupLayout(panelmenuinvoice);
        panelmenuinvoice.setLayout(panelmenuinvoiceLayout);
        panelmenuinvoiceLayout.setHorizontalGroup(
            panelmenuinvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuinvoiceLayout.createSequentialGroup()
                .addComponent(panelclicked6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        panelmenuinvoiceLayout.setVerticalGroup(
            panelmenuinvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenprojectplan.setBackground(new java.awt.Color(0, 204, 204));
        panelmenprojectplan.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenprojectplan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenprojectplanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenprojectplanMousePressed(evt);
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

        staffmenulable6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable6.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/projectplan.png"))); // NOI18N
        staffmenulable6.setText("   PROJECT PLAN");
        staffmenulable6.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenprojectplanLayout = new javax.swing.GroupLayout(panelmenprojectplan);
        panelmenprojectplan.setLayout(panelmenprojectplanLayout);
        panelmenprojectplanLayout.setHorizontalGroup(
            panelmenprojectplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenprojectplanLayout.createSequentialGroup()
                .addComponent(panelclicked7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmenprojectplanLayout.setVerticalGroup(
            panelmenprojectplanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
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

        staffmenulable7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable7.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/projectplanlist.png"))); // NOI18N
        staffmenulable7.setText("   PROJECT PLAN LIST");
        staffmenulable7.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenprojectplanlistLayout = new javax.swing.GroupLayout(panelmenprojectplanlist);
        panelmenprojectplanlist.setLayout(panelmenprojectplanlistLayout);
        panelmenprojectplanlistLayout.setHorizontalGroup(
            panelmenprojectplanlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenprojectplanlistLayout.createSequentialGroup()
                .addComponent(panelclicked8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmenprojectplanlistLayout.setVerticalGroup(
            panelmenprojectplanlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenprojectplanview.setBackground(new java.awt.Color(0, 204, 204));
        panelmenprojectplanview.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenprojectplanview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenprojectplanviewMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenprojectplanviewMousePressed(evt);
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

        staffmenulable8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable8.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/project-planview.png"))); // NOI18N
        staffmenulable8.setText("   PROJECT PLAN VIEW");
        staffmenulable8.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenprojectplanviewLayout = new javax.swing.GroupLayout(panelmenprojectplanview);
        panelmenprojectplanview.setLayout(panelmenprojectplanviewLayout);
        panelmenprojectplanviewLayout.setHorizontalGroup(
            panelmenprojectplanviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenprojectplanviewLayout.createSequentialGroup()
                .addComponent(panelclicked9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelmenprojectplanviewLayout.setVerticalGroup(
            panelmenprojectplanviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenImport.setBackground(new java.awt.Color(0, 204, 204));
        panelmenImport.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenImportMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenImportMousePressed(evt);
            }
        });

        panelclicked10.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked10.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked10Layout = new javax.swing.GroupLayout(panelclicked10);
        panelclicked10.setLayout(panelclicked10Layout);
        panelclicked10Layout.setHorizontalGroup(
            panelclicked10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked10Layout.setVerticalGroup(
            panelclicked10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable10.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imort.png"))); // NOI18N
        staffmenulable10.setText("   IMPOART");
        staffmenulable10.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout panelmenImportLayout = new javax.swing.GroupLayout(panelmenImport);
        panelmenImport.setLayout(panelmenImportLayout);
        panelmenImportLayout.setHorizontalGroup(
            panelmenImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenImportLayout.createSequentialGroup()
                .addComponent(panelclicked10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        panelmenImportLayout.setVerticalGroup(
            panelmenImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelclicked10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(staffmenulable10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuCE.setBackground(new java.awt.Color(0, 204, 204));
        menuCE.setPreferredSize(new java.awt.Dimension(155, 50));
        menuCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCEMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCEMousePressed(evt);
            }
        });

        panelclicked11.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked11.setPreferredSize(new java.awt.Dimension(5, 38));
        panelclicked11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelclicked11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelclicked11Layout = new javax.swing.GroupLayout(panelclicked11);
        panelclicked11.setLayout(panelclicked11Layout);
        panelclicked11Layout.setHorizontalGroup(
            panelclicked11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked11Layout.setVerticalGroup(
            panelclicked11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable12.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/contruction.png"))); // NOI18N
        staffmenulable12.setText("   CONSTRUCTION");
        staffmenulable12.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout menuCELayout = new javax.swing.GroupLayout(menuCE);
        menuCE.setLayout(menuCELayout);
        menuCELayout.setHorizontalGroup(
            menuCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCELayout.createSequentialGroup()
                .addComponent(panelclicked11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        menuCELayout.setVerticalGroup(
            menuCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelclicked11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(staffmenulable12, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuSupplier.setBackground(new java.awt.Color(0, 204, 204));
        menuSupplier.setPreferredSize(new java.awt.Dimension(155, 50));
        menuSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSupplierMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuSupplierMousePressed(evt);
            }
        });

        panelclicked12.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked12.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked12Layout = new javax.swing.GroupLayout(panelclicked12);
        panelclicked12.setLayout(panelclicked12Layout);
        panelclicked12Layout.setHorizontalGroup(
            panelclicked12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked12Layout.setVerticalGroup(
            panelclicked12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable9.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client1.png"))); // NOI18N
        staffmenulable9.setText("   SUPPLIER");
        staffmenulable9.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout menuSupplierLayout = new javax.swing.GroupLayout(menuSupplier);
        menuSupplier.setLayout(menuSupplierLayout);
        menuSupplierLayout.setHorizontalGroup(
            menuSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSupplierLayout.createSequentialGroup()
                .addComponent(panelclicked12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        menuSupplierLayout.setVerticalGroup(
            menuSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked12, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuUsage.setBackground(new java.awt.Color(0, 204, 204));
        menuUsage.setPreferredSize(new java.awt.Dimension(155, 50));
        menuUsage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsageMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuUsageMousePressed(evt);
            }
        });

        panelclicked13.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked13.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked13Layout = new javax.swing.GroupLayout(panelclicked13);
        panelclicked13.setLayout(panelclicked13Layout);
        panelclicked13Layout.setHorizontalGroup(
            panelclicked13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked13Layout.setVerticalGroup(
            panelclicked13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        staffmenulable11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable11.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/usage.png"))); // NOI18N
        staffmenulable11.setText("   USAGE");
        staffmenulable11.setPreferredSize(new java.awt.Dimension(94, 26));

        javax.swing.GroupLayout menuUsageLayout = new javax.swing.GroupLayout(menuUsage);
        menuUsage.setLayout(menuUsageLayout);
        menuUsageLayout.setHorizontalGroup(
            menuUsageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuUsageLayout.createSequentialGroup()
                .addComponent(panelclicked13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffmenulable11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        menuUsageLayout.setVerticalGroup(
            menuUsageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(staffmenulable11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(panelclicked13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelmenuuser.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuuser.setPreferredSize(new java.awt.Dimension(155, 50));
        panelmenuuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuuserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuuserMousePressed(evt);
            }
        });
        panelmenuuser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelclicked15.setBackground(new java.awt.Color(0, 255, 0));
        panelclicked15.setPreferredSize(new java.awt.Dimension(5, 38));

        javax.swing.GroupLayout panelclicked15Layout = new javax.swing.GroupLayout(panelclicked15);
        panelclicked15.setLayout(panelclicked15Layout);
        panelclicked15Layout.setHorizontalGroup(
            panelclicked15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelclicked15Layout.setVerticalGroup(
            panelclicked15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelmenuuser.add(panelclicked15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        staffmenulable14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        staffmenulable14.setForeground(new java.awt.Color(0, 102, 255));
        staffmenulable14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        staffmenulable14.setText("   USER");
        staffmenulable14.setPreferredSize(new java.awt.Dimension(94, 26));
        panelmenuuser.add(staffmenulable14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 0, 112, 30));

        panelmenuhome.setBackground(new java.awt.Color(0, 204, 204));
        panelmenuhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelmenuhomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelmenuhomeMousePressed(evt);
            }
        });
        panelmenuhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelmenuhome.add(panelclicked1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        homemenulable.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        homemenulable.setForeground(new java.awt.Color(0, 102, 255));
        homemenulable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/homes.png"))); // NOI18N
        homemenulable.setText("   HOME");
        panelmenuhome.add(homemenulable, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 0, 145, -1));

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenustaff, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenworker, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(menuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenuinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenprojectplan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenprojectplanview, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenImport, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(menuCE, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(menuSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(menuUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelmenuuser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lablewelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelmenuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panelmenustaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenworker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenuinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenprojectplan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenprojectplanlist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panelmenprojectplanview, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panelmenImport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuCE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(menuUsage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(panelmenuuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jPanel1.add(btnsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 92, 31));

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
        jLabel1.setText("CONSTRUCTION MANAGEMENT SYSTEM");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        panelproject.setBackground(new java.awt.Color(255, 255, 255));
        panelproject.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        labelproject.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelproject.setForeground(new java.awt.Color(102, 102, 255));
        labelproject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/project.png"))); // NOI18N
        labelproject.setText("       WORKERS");
        labelproject.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalworker.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalworker.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalworker.setText("0");

        javax.swing.GroupLayout panelprojectLayout = new javax.swing.GroupLayout(panelproject);
        panelproject.setLayout(panelprojectLayout);
        panelprojectLayout.setHorizontalGroup(
            panelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprojectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelproject, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(labeltotalworker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelprojectLayout.setVerticalGroup(
            panelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprojectLayout.createSequentialGroup()
                .addComponent(labelproject, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltotalworker, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelcustomer.setBackground(new java.awt.Color(255, 255, 255));
        panelcustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));
        panelcustomer.setPreferredSize(new java.awt.Dimension(215, 92));

        labelclient.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelclient.setForeground(new java.awt.Color(102, 102, 255));
        labelclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/client1.png"))); // NOI18N
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
        labelstaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        labelstaff.setText("       STAFF");
        labelstaff.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalstaff.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalstaff.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalstaff.setText("0");

        javax.swing.GroupLayout panelstaffLayout = new javax.swing.GroupLayout(panelstaff);
        panelstaff.setLayout(panelstaffLayout);
        panelstaffLayout.setHorizontalGroup(
            panelstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelstaff, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(labeltotalstaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
        labelsuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pay.png"))); // NOI18N
        labelsuppliers.setText("     PAYMENTS");
        labelsuppliers.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalpayment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalpayment.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalpayment.setText("0");

        javax.swing.GroupLayout panelsuppliersLayout = new javax.swing.GroupLayout(panelsuppliers);
        panelsuppliers.setLayout(panelsuppliersLayout);
        panelsuppliersLayout.setHorizontalGroup(
            panelsuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltotalpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelsuppliersLayout.setVerticalGroup(
            panelsuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuppliersLayout.createSequentialGroup()
                .addComponent(labelsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(labeltotalpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        jLabel10.setText("     INVOICES");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalinvoice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalinvoice.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalinvoice.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(labeltotalinvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(labeltotalinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255), new java.awt.Color(153, 102, 255)));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/projectplan.png"))); // NOI18N
        jLabel12.setText("     PROJECTPLAN");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 255)));

        labeltotalprojectplan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labeltotalprojectplan.setForeground(new java.awt.Color(102, 102, 255));
        labeltotalprojectplan.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(labeltotalprojectplan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(labeltotalprojectplan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelhomeLayout = new javax.swing.GroupLayout(panelhome);
        panelhome.setLayout(panelhomeLayout);
        panelhomeLayout.setHorizontalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelhomeLayout.createSequentialGroup()
                        .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelproject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(panelcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(panelsuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelhomeLayout.setVerticalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelhomeLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelproject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelcustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelsuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(342, Short.MAX_VALUE))
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
        txtstaffID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtstaffIDMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtstaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 230, 29));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Gender");
        panelstaffinfomation.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 230, 20));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Nationality");
        panelstaffinfomation.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 230, -1));

        txtStaffName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffNameMousePressed(evt);
            }
        });
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
        txtStaffSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffSalaryMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 250, 29));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Phone");
        panelstaffinfomation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 80, 20));

        txtStaffPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffPhoneMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 250, 29));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Address");
        panelstaffinfomation.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 270, 20));

        txtStaffAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffAddressMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 900, 29));

        txtStaffBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffBirthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffBirthdayMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 29));

        txtStaffHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffHiredDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffHiredDateMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 29));

        cboStaffGender.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Male", "Female" }));
        cboStaffGender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboStaffGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStaffGenderActionPerformed(evt);
            }
        });
        panelstaffinfomation.add(cboStaffGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 230, 29));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Status");
        panelstaffinfomation.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 230, 20));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Staff Name");
        panelstaffinfomation.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 20));

        labelpictureStaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        panelstaffinfomation.add(labelpictureStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 120, 120));

        cboStaffStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Working", "Stoped" }));
        cboStaffStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboStaffStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboStaffStatusMousePressed(evt);
            }
        });
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
        btnStaffCancel.setText("Clear");
        btnStaffCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStaffCancelMouseClicked(evt);
            }
        });
        panelstaffinfomation.add(btnStaffCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, 90, 30));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("Staff ID");
        panelstaffinfomation.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 230, 20));

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
        panelstaffinfomation.add(labelmessagestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 210, 20));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setText("Role");
        panelstaffinfomation.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 230, 20));

        txtStaffNationlity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStaffNationlity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStaffNationlityMousePressed(evt);
            }
        });
        panelstaffinfomation.add(txtStaffNationlity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 230, 29));

        labelstaffroleidrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffroleidrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation.add(labelstaffroleidrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 190, 20));

        labelstaffNamerequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelstaffNamerequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation.add(labelstaffNamerequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 230, 20));

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

        cboStaffroleID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboStaffroleID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cboStaffroleID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboStaffroleID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboStaffroleIDMousePressed(evt);
            }
        });
        panelstaffinfomation.add(cboStaffroleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 230, 29));

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
        labelgidelineoftalebworker.setText("WORKER / VIEW");
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

        labelgidelineofmenuWorker.setText("WORKER / CREATE NEW");
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
        txtworkerName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerNameMousePressed(evt);
            }
        });
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
        txtworkerSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerSalaryMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(txtworkerSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 250, 29));

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel48.setText("Phone");
        panelstaffinfomation1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 80, 20));

        txtworkerPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtworkerPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerPhoneMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(txtworkerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 250, 29));

        jLabel49.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel49.setText("Address");
        panelstaffinfomation1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));

        txtworkerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtworkerAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerAddressMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(txtworkerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 940, 29));

        txtworkerBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtworkerBirthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerBirthdayMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(txtworkerBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 250, 29));

        txtworkerHiredDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtworkerHiredDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtworkerHiredDateMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(txtworkerHiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 250, 29));

        cboworkerGender.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkerGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female" }));
        cboworkerGender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboworkerGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboworkerGenderMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(cboworkerGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 230, 29));

        jLabel50.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel50.setText("Status");
        panelstaffinfomation1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 230, 20));

        jLabel51.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel51.setText("Worker Name");
        panelstaffinfomation1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        labelpictureworker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        panelstaffinfomation1.add(labelpictureworker, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 120, 120));

        btnworkerNew.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerNew.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerNew.setText("New");
        btnworkerNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerNewMouseClicked(evt);
            }
        });
        panelstaffinfomation1.add(btnworkerNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 90, 30));

        cboworkerStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboworkerStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Working", "Stoped" }));
        cboworkerStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboworkerStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboworkerStatusMousePressed(evt);
            }
        });
        panelstaffinfomation1.add(cboworkerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 230, 29));

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
        btnworkerCancel.setText("Clear");
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
        cboworkerroleID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboworkerroleIDMousePressed(evt);
            }
        });
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
        labelworkersaryequired.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelworkersaryequiredMousePressed(evt);
            }
        });
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
        cboworkercreatebystaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboworkercreatebystaffMousePressed(evt);
            }
        });
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
        txtPaymentPaidAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPaymentPaidAmountMousePressed(evt);
            }
        });
        panelstaffinfomation2.add(txtPaymentPaidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        jLabel56.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel56.setText("Payment Date");
        panelstaffinfomation2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 250, 20));

        txtPaymentDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtPaymentDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaymentDateMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(txtPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 29));

        cboPaymentCutomerName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCutomerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboPaymentCutomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(cboPaymentCutomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel61.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel61.setText("Paid Amount");
        panelstaffinfomation2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        btnPaymentNew.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentNew.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentNew.setText("New");
        btnPaymentNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentNewMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 90, 30));

        btnPaymentUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentUpdate.setText("Update");
        btnPaymentUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 90, 30));

        btnPaymentclear.setBackground(new java.awt.Color(0, 153, 153));
        btnPaymentclear.setForeground(new java.awt.Color(255, 255, 255));
        btnPaymentclear.setText("Clear");
        btnPaymentclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaymentclearMouseClicked(evt);
            }
        });
        panelstaffinfomation2.add(btnPaymentclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 90, 30));

        jLabel62.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel62.setText("Payment ID");
        panelstaffinfomation2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker1.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation2.add(labelmessageworker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired1.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelworkerroleidrequired1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelpaymentstaffrequire.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentstaffrequire.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentstaffrequire, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 230, 20));

        labelpaymentCustomerrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentCustomerrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentCustomerrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelpaymentPaymentrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentPaymentrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation2.add(labelpaymentPaymentrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 20));

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel64.setText("Create by Staff Name");
        panelstaffinfomation2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        cboPaymentCreatebystaff.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboPaymentCreatebystaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboPaymentCreatebystaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation2.add(cboPaymentCreatebystaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 230, 29));

        labelpaymentPaidrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentPaidrequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation2.add(labelpaymentPaidrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 230, 20));

        labelpaymentresult.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentresult.setForeground(new java.awt.Color(51, 255, 51));
        panelstaffinfomation2.add(labelpaymentresult, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 230, 20));

        jLabel96.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel96.setText("Total Amount");
        panelstaffinfomation2.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        txtPaymentTotalAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtPaymentTotalAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPaymentTotalAmountMousePressed(evt);
            }
        });
        panelstaffinfomation2.add(txtPaymentTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        labelpaymentTotalrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentTotalrequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation2.add(labelpaymentTotalrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 20));

        jLabel97.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel97.setText("Owes Amount");
        panelstaffinfomation2.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 20));

        txtPaymentOwesAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtPaymentOwesAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPaymentOwesAmountMousePressed(evt);
            }
        });
        panelstaffinfomation2.add(txtPaymentOwesAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 230, 29));

        labelpaymentOwesrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentOwesrequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation2.add(labelpaymentOwesrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 230, 20));

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
                .addComponent(panelstaffinfomation2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
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

        txtInvoiceId.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoiceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel55.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel55.setText("Create Staff Name");
        panelstaffinfomation3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 230, 20));

        jLabel57.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel57.setText("Invoice Date");
        panelstaffinfomation3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        txtInvoiceDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 29));

        cboInvoicePaymentID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboInvoicePaymentID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboInvoicePaymentID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboInvoicePaymentID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboInvoicePaymentIDMousePressed(evt);
            }
        });
        cboInvoicePaymentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboInvoicePaymentIDActionPerformed(evt);
            }
        });
        panelstaffinfomation3.add(cboInvoicePaymentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel63.setText("Payment ID");
        panelstaffinfomation3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

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
        btnInvoiceCancel.setText("Clear");
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

        labelInvoicePaymentIDrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelInvoicePaymentIDrequired.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation3.add(labelInvoicePaymentIDrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelInvoicestaffrequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelInvoicestaffrequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelInvoicestaffrequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 230, 20));

        labelInvoiceDatterequired.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelInvoiceDatterequired.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelInvoiceDatterequired, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 20));

        jLabel66.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel66.setText("Customer Name");
        panelstaffinfomation3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        cboInvoicestaffrName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboInvoicestaffrName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboInvoicestaffrName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboInvoicestaffrName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboInvoicestaffrNameMousePressed(evt);
            }
        });
        panelstaffinfomation3.add(cboInvoicestaffrName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 230, 29));

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel58.setText("Total Amount");
        panelstaffinfomation3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        txtInvoiceTotalAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoiceTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel67.setText("Paid Amount");
        panelstaffinfomation3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        jLabel68.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel68.setText("Owes Amount");
        panelstaffinfomation3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 20));

        txtInvoiceCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoiceCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 230, 29));

        txtInvoicePaidAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoicePaidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        txtInvoiceOwesAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation3.add(txtInvoiceOwesAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 230, 29));

        labelInvoiceResult.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelInvoiceResult.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation3.add(labelInvoiceResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 230, 20));

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
        panelstaffinfomation4.setForeground(new java.awt.Color(102, 255, 102));
        panelstaffinfomation4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProjectPlanID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation4.add(txtProjectPlanID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel59.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel59.setText("Project Information Name");
        panelstaffinfomation4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 230, 20));

        jLabel69.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel69.setText("Time Line");
        panelstaffinfomation4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        btnProjectPlan.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlan.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlan.setText("New");
        btnProjectPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanMouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnProjectPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 90, 30));

        btnProjectPlanUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanUpdate.setText("Update");
        btnProjectPlanUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnProjectPlanUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 90, 30));

        btnProjectPlanClear.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanClear.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanClear.setText("Clear");
        btnProjectPlanClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanClearMouseClicked(evt);
            }
        });
        panelstaffinfomation4.add(btnProjectPlanClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 90, 30));

        jLabel70.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel70.setText("ProjectPlan ID");
        panelstaffinfomation4.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker3.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation4.add(labelmessageworker3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelworkerroleidrequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelProjectPlanTimeLine.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanTimeLine.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation4.add(labelProjectPlanTimeLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 230, 20));

        labelProjectPlanName.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanName.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelProjectPlanName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 230, 20));

        labelProjectPlanInfoName.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanInfoName.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelProjectPlanInfoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 230, 20));

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel71.setText("ProjectPlan Name");
        panelstaffinfomation4.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        cboProjectPlanInfoName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanInfoName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboProjectPlanInfoName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanInfoName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanInfoNameMousePressed(evt);
            }
        });
        panelstaffinfomation4.add(cboProjectPlanInfoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 230, 29));

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel72.setText("Location");
        panelstaffinfomation4.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        cboProjectPlanStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Doing", "Done" }));
        cboProjectPlanStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanStatusMousePressed(evt);
            }
        });
        panelstaffinfomation4.add(cboProjectPlanStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 230, 29));

        labelProjectPlanLocation.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanLocation.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelProjectPlanLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 20));

        jLabel73.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel73.setText("Status");
        panelstaffinfomation4.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 230, 20));

        tbProjectPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProjectPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjectPlanMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tbProjectPlan);

        panelstaffinfomation4.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1000, 430));

        txtProjectPlanLocation.setColumns(20);
        txtProjectPlanLocation.setRows(3);
        txtProjectPlanLocation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanLocationMousePressed(evt);
            }
        });
        jScrollPane16.setViewportView(txtProjectPlanLocation);

        panelstaffinfomation4.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, -1));

        txtProjectPlanTimeLine.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanTimeLine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanTimeLineMousePressed(evt);
            }
        });
        panelstaffinfomation4.add(txtProjectPlanTimeLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        labelProjectPlanStatus.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanStatus.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation4.add(labelProjectPlanStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 230, 20));

        txtProjectPlanName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanNameMousePressed(evt);
            }
        });
        panelstaffinfomation4.add(txtProjectPlanName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        labelProjectPlanResult.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelProjectPlanResult.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation4.add(labelProjectPlanResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 230, 20));

        javax.swing.GroupLayout panelstaffmenu4Layout = new javax.swing.GroupLayout(panelstaffmenu4);
        panelstaffmenu4.setLayout(panelstaffmenu4Layout);
        panelstaffmenu4Layout.setHorizontalGroup(
            panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                .addGroup(panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelgidelineofmenuPayment2, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE))
                    .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelstaffinfomation4, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelstaffmenu4Layout.setVerticalGroup(
            panelstaffmenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelgidelineofmenuPayment2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation4, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );

        menuprojectplan.getContentPane().add(panelstaffmenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuprojectplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menuprojectplanList.setVisible(false);
        menuprojectplanList.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu5.setBackground(new java.awt.Color(255, 255, 255));
        panelstaffmenu5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelgidelineofmenuPayment3.setText("PROJECTPLAN LIST / CREATE");
        labelgidelineofmenuPayment3.setAlignmentX(0.5F);
        labelgidelineofmenuPayment3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelstaffmenu5.add(labelgidelineofmenuPayment3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 37, 1012, 24));

        panelstaffinfomation5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProjectPlanListID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(txtProjectPlanListID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel60.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel60.setText("ProjectPlan Name");
        panelstaffinfomation5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        txtProjectPlanListFinishDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanListFinishDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanListFinishDateMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(txtProjectPlanListFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 230, 29));

        jLabel75.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel75.setText("ProjectPlanList Name");
        panelstaffinfomation5.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 20));

        btnProjectPlanListNew.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanListNew.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanListNew.setText("New");
        btnProjectPlanListNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanListNewMouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnProjectPlanListNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 90, 30));

        btnProjectPlanListUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanListUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanListUpdate.setText("Update");
        btnProjectPlanListUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanListUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnProjectPlanListUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 90, 30));

        btnProjectPlanListClear.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanListClear.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanListClear.setText("Clear");
        btnProjectPlanListClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanListClearMouseClicked(evt);
            }
        });
        panelstaffinfomation5.add(btnProjectPlanListClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 90, 30));

        labelmessageworker4.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation5.add(labelmessageworker4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired4.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelworkerroleidrequired4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelPPLName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLName.setForeground(new java.awt.Color(255, 0, 51));
        panelstaffinfomation5.add(labelPPLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 30));

        labelPPLStaff.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLStaff.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelPPLStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 30, 30));

        labelPPLFinishDate.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLFinishDate.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelPPLFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 30, 30));

        jLabel77.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel77.setText("Create by Staff");
        panelstaffinfomation5.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 220, 20));

        cboProjectPlanList_ProjectPlanName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanList_ProjectPlanName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboProjectPlanList_ProjectPlanName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanList_ProjectPlanName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanList_ProjectPlanNameMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(cboProjectPlanList_ProjectPlanName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel78.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel78.setText("Start Date");
        panelstaffinfomation5.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 230, 20));

        labelPPL_PPName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPL_PPName.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelPPL_PPName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 30, 30));

        jLabel79.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel79.setText("Finish Date");
        panelstaffinfomation5.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 230, 20));

        jLabel80.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel80.setText("Status");
        panelstaffinfomation5.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

        txtProjectPlanListName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanListName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanListNameMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(txtProjectPlanListName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 29));

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel81.setText("ProjectPlanList ID");
        panelstaffinfomation5.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 20));

        labelPPLStartDate.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLStartDate.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelPPLStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 30, 30));

        labelpaymentgenderrequired8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelpaymentgenderrequired8.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelpaymentgenderrequired8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 20, 30));

        labelPPLStatus.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLStatus.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation5.add(labelPPLStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 30, 30));

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

        cboProjectPlanListStaff.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanListStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboProjectPlanListStaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanListStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanListStaffMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(cboProjectPlanListStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 230, 30));

        txtProjectPlanListStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanListStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanListStartDateMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(txtProjectPlanListStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 29));

        cboProjectPlanListStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanListStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Doing", "Done" }));
        cboProjectPlanListStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanListStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanListStatusMousePressed(evt);
            }
        });
        panelstaffinfomation5.add(cboProjectPlanListStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 30));

        tbProjectPlanList.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbProjectPlanList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProjectPlanList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjectPlanListMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tbProjectPlanList);

        panelstaffinfomation5.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 970, 170));

        cboProjectPlanListSelectProjectPlan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanListSelectProjectPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboProjectPlanListSelectProjectPlan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation5.add(cboProjectPlanListSelectProjectPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 230, 20));

        jLabel95.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel95.setText("ProjectPlan Name");
        panelstaffinfomation5.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 120, 20));

        labelPPLResult.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        labelPPLResult.setForeground(new java.awt.Color(102, 255, 102));
        panelstaffinfomation5.add(labelPPLResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 240, 20));

        panelstaffmenu5.add(panelstaffinfomation5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 1020, 380));

        jLabel76.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel76.setText("ProjectPlan List Detail");
        panelstaffmenu5.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 1010, 20));

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel92.setText("ProjectPlanList Name");
        jPanel4.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 20));

        txtProjectPlanDetailName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanDetailName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanDetailNameMousePressed(evt);
            }
        });
        jPanel4.add(txtProjectPlanDetailName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 230, 29));

        txtProjectPlanDetailID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtProjectPlanDetailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 30));

        jLabel91.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel91.setText("ProjectPlanList ID");
        jPanel4.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 20));

        jLabel93.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel93.setText("ProjectPlan List Detail Name");
        jPanel4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 230, 20));

        jLabel94.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel94.setText("Date Line");
        jPanel4.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 20));

        txtProjectPlanDetailDateline.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtProjectPlanDetailDateline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtProjectPlanDetailDatelineMousePressed(evt);
            }
        });
        jPanel4.add(txtProjectPlanDetailDateline, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, 29));

        cboProjectPlanDetail_ListName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboProjectPlanDetail_ListName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboProjectPlanDetail_ListName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        cboProjectPlanDetail_ListName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboProjectPlanDetail_ListNameMousePressed(evt);
            }
        });
        jPanel4.add(cboProjectPlanDetail_ListName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 30));

        tbProjectPlanListDetail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        tbProjectPlanListDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProjectPlanListDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjectPlanListDetailMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tbProjectPlanListDetail);

        jPanel4.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 730, 160));

        btnProjectPlanListDetailNew.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanListDetailNew.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanListDetailNew.setText("New");
        btnProjectPlanListDetailNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanListDetailNewMouseClicked(evt);
            }
        });
        jPanel4.add(btnProjectPlanListDetailNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 90, 30));

        btnProjectPlanDetailUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanDetailUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanDetailUpdate.setText("Update");
        btnProjectPlanDetailUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanDetailUpdateMouseClicked(evt);
            }
        });
        jPanel4.add(btnProjectPlanDetailUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 90, 30));

        btnProjectPlanDetailClear.setBackground(new java.awt.Color(0, 153, 153));
        btnProjectPlanDetailClear.setForeground(new java.awt.Color(255, 255, 255));
        btnProjectPlanDetailClear.setText("Clear");
        btnProjectPlanDetailClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProjectPlanDetailClearMouseClicked(evt);
            }
        });
        jPanel4.add(btnProjectPlanDetailClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 90, 30));

        txtPaymentCreatebystaff4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPaymentCreatebystaff4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        txtPaymentCreatebystaff4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel4.add(txtPaymentCreatebystaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 230, 20));

        jLabel82.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel82.setText("ProjectPlan List Name");
        jPanel4.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 150, 20));

        labelPPLDResult.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        labelPPLDResult.setForeground(new java.awt.Color(51, 255, 51));
        jPanel4.add(labelPPLDResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 180, 20));

        labelPPLDProjectplanListName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLDProjectplanListName.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(labelPPLDProjectplanListName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 30, 30));

        labelPPLDDetailname.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLDDetailname.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(labelPPLDDetailname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 30, 30));

        labelPPLDDateline.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelPPLDDateline.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(labelPPLDDateline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 30, 30));

        panelstaffmenu5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 1020, 250));

        jLabel90.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel90.setText("ProjectPlan List");
        panelstaffmenu5.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1010, 20));

        menuprojectplanList.getContentPane().add(panelstaffmenu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(menuprojectplanList, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menutableprojectview.setVisible(false);
        menutableprojectview.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1050, 740));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbViewProjectPlanList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbViewProjectPlanList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbViewProjectPlanListMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbViewProjectPlanList);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 510, 600));

        tbViewProjectPlanListDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbViewProjectPlanListDetail.setMinimumSize(new java.awt.Dimension(10, 64));
        jScrollPane6.setViewportView(tbViewProjectPlanListDetail);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 500, 600));

        jLabel3.setText("ProjectPlan List Detail");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 500, 20));

        cboViewProjectPlanName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboViewProjectPlanName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        cboViewProjectPlanName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboViewProjectPlanNameActionPerformed(evt);
            }
        });
        jPanel3.add(cboViewProjectPlanName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 960, 30));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setText("Search");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel14.setText("PROJECTPLANLIST / PLAN LIST DETAIL");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1000, 20));

        jLabel16.setText("ProjectPlan List");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 510, 20));

        menutableprojectview.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 710));

        DesktopPane.add(menutableprojectview, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        menutableprojectview1.setVisible(false);
        menutableprojectview1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        menutableprojectview1.getContentPane().add(paneltableprojectplanlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1050, 760));

        DesktopPane.add(menutableprojectview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        import_form.setVisible(false);
        import_form.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu9.setBackground(new java.awt.Color(255, 255, 255));

        bracImportForm.setAlignmentX(0.5F);
        bracImportForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbImport_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbImport_form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImport_formMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tbImport_form);

        panelstaffinfomation10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel112.setText("Supplier name");
        panelstaffinfomation10.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 20));

        btnImportNew.setBackground(new java.awt.Color(0, 153, 153));
        btnImportNew.setForeground(new java.awt.Color(255, 255, 255));
        btnImportNew.setText("New");
        btnImportNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportNewActionPerformed(evt);
            }
        });
        panelstaffinfomation10.add(btnImportNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 90, 30));

        btnImportUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnImportUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnImportUpdate.setText("Update");
        btnImportUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportUpdateActionPerformed(evt);
            }
        });
        panelstaffinfomation10.add(btnImportUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 90, 30));

        btnworkerCancel4.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerCancel4.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerCancel4.setText("Cancel");
        btnworkerCancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerCancel4MouseClicked(evt);
            }
        });
        panelstaffinfomation10.add(btnworkerCancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 90, 30));

        jLabel113.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel113.setText("Create by staff name ");
        panelstaffinfomation10.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        jLabel116.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel116.setText("Import Date");
        panelstaffinfomation10.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        txtImportDate.setEditable(false);
        txtImportDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation10.add(txtImportDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 29));

        panelstaffinfomation10.add(cbSupplierNameImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 230, 30));

        panelstaffinfomation10.add(cbStaffNameImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, 30));

        panelstaffinfomation12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel133.setText("Custraction Equipment Name");
        panelstaffinfomation12.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 20));

        btnImportDetailsNew.setBackground(new java.awt.Color(0, 153, 153));
        btnImportDetailsNew.setForeground(new java.awt.Color(255, 255, 255));
        btnImportDetailsNew.setText("New");
        btnImportDetailsNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportDetailsNewMouseClicked(evt);
            }
        });
        btnImportDetailsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportDetailsNewActionPerformed(evt);
            }
        });
        panelstaffinfomation12.add(btnImportDetailsNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 90, 30));

        btnImportDetialUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnImportDetialUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnImportDetialUpdate.setText("Update");
        btnImportDetialUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportDetialUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation12.add(btnImportDetialUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 90, 30));

        btnworkerCancel6.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerCancel6.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerCancel6.setText("Clear");
        btnworkerCancel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerCancel6MouseClicked(evt);
            }
        });
        panelstaffinfomation12.add(btnworkerCancel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 90, 30));

        jLabel136.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel136.setText("Import qty");
        panelstaffinfomation12.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 230, 20));

        txtImportQtyImportDetails.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation12.add(txtImportQtyImportDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 230, 29));

        jLabel138.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel138.setText("Unit price");
        panelstaffinfomation12.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 230, -1));

        txtUnitPriceImportDetails.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation12.add(txtUnitPriceImportDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 230, 30));

        jLabel139.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel139.setText("Amount");
        panelstaffinfomation12.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 230, -1));

        txtAmountImportDetails.setEditable(false);
        txtAmountImportDetails.setBackground(new java.awt.Color(204, 204, 204));
        txtAmountImportDetails.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation12.add(txtAmountImportDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 30));

        panelstaffinfomation12.add(cbCEImportDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, 30));

        jLabel140.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel140.setText("Import Id");
        panelstaffinfomation12.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 230, -1));

        txtImportId_Detail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation12.add(txtImportId_Detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 230, 30));

        tbImport_form_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbImport_form_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImport_form_detailMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tbImport_form_detail);

        javax.swing.GroupLayout panelstaffmenu9Layout = new javax.swing.GroupLayout(panelstaffmenu9);
        panelstaffmenu9.setLayout(panelstaffmenu9Layout);
        panelstaffmenu9Layout.setHorizontalGroup(
            panelstaffmenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane26)
                    .addComponent(panelstaffinfomation12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bracImportForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation10, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane24))
                .addContainerGap())
        );
        panelstaffmenu9Layout.setVerticalGroup(
            panelstaffmenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bracImportForm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelstaffinfomation12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        import_form.getContentPane().add(panelstaffmenu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(import_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        import_list.setVisible(false);
        import_list.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCustomer3.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollImport.setViewportView(tbImport);

        panelCustomer3.add(jScrollImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        lbBracImportList.setBackground(new java.awt.Color(255, 0, 51));
        lbBracImportList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelCustomer3.add(lbBracImportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnImport.setBackground(new java.awt.Color(0, 153, 153));
        btnImport.setForeground(new java.awt.Color(255, 255, 255));
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });
        panelCustomer3.add(btnImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelCustomer3.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff4.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff4.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff4.setText("Edit");
        btnEdittablestaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaff4MouseClicked(evt);
            }
        });
        panelCustomer3.add(btnEdittablestaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel107.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel107.setText("Search");
        panelCustomer3.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        import_list.getContentPane().add(panelCustomer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(import_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        supplier_form.setVisible(false);
        supplier_form.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu7.setBackground(new java.awt.Color(255, 255, 255));

        bracSupplierForm.setAlignmentX(0.5F);
        bracSupplierForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbSupplier_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbSupplier_form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplier_formMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tbSupplier_form);

        panelstaffinfomation8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSupplierName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation8.add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel98.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel98.setText("Supplier Name");
        panelstaffinfomation8.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 20));

        jLabel102.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel102.setText("Address");
        panelstaffinfomation8.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        txtSupplierAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation8.add(txtSupplierAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 940, 29));

        jLabel105.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel105.setText("Gender");
        panelstaffinfomation8.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnSupplierNew.setBackground(new java.awt.Color(0, 153, 153));
        btnSupplierNew.setForeground(new java.awt.Color(255, 255, 255));
        btnSupplierNew.setText("New");
        btnSupplierNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierNewActionPerformed(evt);
            }
        });
        panelstaffinfomation8.add(btnSupplierNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 90, 30));

        btnSupplierUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnSupplierUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnSupplierUpdate.setText("Update");
        btnSupplierUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierUpdateActionPerformed(evt);
            }
        });
        panelstaffinfomation8.add(btnSupplierUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 90, 30));

        btnSupplierClear.setBackground(new java.awt.Color(0, 153, 153));
        btnSupplierClear.setForeground(new java.awt.Color(255, 255, 255));
        btnSupplierClear.setText("Clear");
        btnSupplierClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierClearMouseClicked(evt);
            }
        });
        panelstaffinfomation8.add(btnSupplierClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 90, 30));

        jLabel106.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel106.setText("Supplier ID");
        panelstaffinfomation8.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        txtSupplierId.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtSupplierId.setEnabled(false);
        panelstaffinfomation8.add(txtSupplierId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        buttonGroup2.add(male1);
        male1.setActionCommand("Male");
        male1.setLabel("Male");
        male1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                male1ActionPerformed(evt);
            }
        });
        panelstaffinfomation8.add(male1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        buttonGroup2.add(female1);
        female1.setLabel("Felmale");
        female1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                female1ActionPerformed(evt);
            }
        });
        panelstaffinfomation8.add(female1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        lbMessageSupplier.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        panelstaffinfomation8.add(lbMessageSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 230, 20));

        txtSupplierPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation8.add(txtSupplierPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 230, 29));

        jLabel131.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel131.setText("Phone");
        panelstaffinfomation8.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 230, 20));

        javax.swing.GroupLayout panelstaffmenu7Layout = new javax.swing.GroupLayout(panelstaffmenu7);
        panelstaffmenu7.setLayout(panelstaffmenu7Layout);
        panelstaffmenu7Layout.setHorizontalGroup(
            panelstaffmenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bracSupplierForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation8, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane20))
                .addContainerGap())
        );
        panelstaffmenu7Layout.setVerticalGroup(
            panelstaffmenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bracSupplierForm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        supplier_form.getContentPane().add(panelstaffmenu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(supplier_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        supplier_list.setVisible(false);
        supplier_list.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCustomer1.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane19.setViewportView(tbSupplier);

        panelCustomer1.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        lbBracSupplierList.setBackground(new java.awt.Color(255, 0, 51));
        lbBracSupplierList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelCustomer1.add(lbBracSupplierList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnSupplierCreate.setBackground(new java.awt.Color(0, 153, 153));
        btnSupplierCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnSupplierCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnSupplierCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierCreateMouseClicked(evt);
            }
        });
        panelCustomer1.add(btnSupplierCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelCustomer1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff2.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff2.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff2.setText("Edit");
        btnEdittablestaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaff2MouseClicked(evt);
            }
        });
        panelCustomer1.add(btnEdittablestaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel99.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel99.setText("Search");
        panelCustomer1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        supplier_list.getContentPane().add(panelCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(supplier_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        ce_form.setVisible(false);
        ce_form.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu8.setBackground(new java.awt.Color(255, 255, 255));

        bracCEForm.setAlignmentX(0.5F);
        bracCEForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbCE_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCE_form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCE_formMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbCE_form);

        panelstaffinfomation9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStockQty.setBackground(new java.awt.Color(204, 204, 204));
        txtStockQty.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtStockQty.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtStockQty.setEnabled(false);
        txtStockQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockQtyActionPerformed(evt);
            }
        });
        panelstaffinfomation9.add(txtStockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel100.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel100.setText("Stock Qty");
        panelstaffinfomation9.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 20));

        jLabel108.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel108.setText("Name");
        panelstaffinfomation9.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnCENew.setBackground(new java.awt.Color(0, 153, 153));
        btnCENew.setForeground(new java.awt.Color(255, 255, 255));
        btnCENew.setText("New");
        btnCENew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCENewMouseClicked(evt);
            }
        });
        panelstaffinfomation9.add(btnCENew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 90, 30));

        btnECUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnECUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnECUpdate.setText("Update");
        btnECUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnECUpdateMouseClicked(evt);
            }
        });
        panelstaffinfomation9.add(btnECUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 90, 30));

        btnCECancel.setBackground(new java.awt.Color(0, 153, 153));
        btnCECancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCECancel.setText("Cancel");
        btnCECancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCECancelMouseClicked(evt);
            }
        });
        btnCECancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCECancelActionPerformed(evt);
            }
        });
        panelstaffinfomation9.add(btnCECancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 90, 30));

        jLabel109.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel109.setText("ID");
        panelstaffinfomation9.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        labelmessageworker8.setForeground(new java.awt.Color(0, 255, 51));
        panelstaffinfomation9.add(labelmessageworker8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 20));

        labelworkerroleidrequired8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerroleidrequired8.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkerroleidrequired8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 20));

        labelworkercreatebystaff3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkercreatebystaff3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkercreatebystaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, 20));

        labelworkergenderrequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkergenderrequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkergenderrequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 230, 20));

        labelworkerbirthrequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerbirthrequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkerbirthrequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 190, 20));

        labelworkersaryequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkersaryequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkersaryequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 250, 20));

        labelworkerphonerequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerphonerequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkerphonerequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 250, 20));

        labelworkeraddrerequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkeraddrerequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkeraddrerequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 20));

        labelworkerstaturequired3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelworkerstaturequired3.setForeground(new java.awt.Color(255, 0, 0));
        panelstaffinfomation9.add(labelworkerstaturequired3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 230, 20));

        txtCEName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation9.add(txtCEName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 29));

        txtCode.setBackground(new java.awt.Color(204, 204, 204));
        txtCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtCode.setEnabled(false);
        panelstaffinfomation9.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        jLabel110.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel110.setText("Unit price");
        panelstaffinfomation9.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, -1));

        txtUnitPrice.setBackground(new java.awt.Color(204, 204, 204));
        txtUnitPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtUnitPrice.setEnabled(false);
        panelstaffinfomation9.add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 230, 30));

        javax.swing.GroupLayout panelstaffmenu8Layout = new javax.swing.GroupLayout(panelstaffmenu8);
        panelstaffmenu8.setLayout(panelstaffmenu8Layout);
        panelstaffmenu8Layout.setHorizontalGroup(
            panelstaffmenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelstaffinfomation9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bracCEForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelstaffmenu8Layout.setVerticalGroup(
            panelstaffmenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bracCEForm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        ce_form.getContentPane().add(panelstaffmenu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(ce_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        ce_list.setVisible(false);
        ce_list.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCustomer2.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane22.setViewportView(tbCE);

        panelCustomer2.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        lbBracCEList.setBackground(new java.awt.Color(255, 0, 51));
        lbBracCEList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelCustomer2.add(lbBracCEList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnCE.setBackground(new java.awt.Color(0, 153, 153));
        btnCE.setForeground(new java.awt.Color(255, 255, 255));
        btnCE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCEMouseClicked(evt);
            }
        });
        panelCustomer2.add(btnCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelCustomer2.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff3.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff3.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff3.setText("Edit");
        btnEdittablestaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaff3MouseClicked(evt);
            }
        });
        panelCustomer2.add(btnEdittablestaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel101.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel101.setText("Search");
        panelCustomer2.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        ce_list.getContentPane().add(panelCustomer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(ce_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        usage_list.setVisible(false);
        usage_list.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCustomer4.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbUsage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollImport1.setViewportView(tbUsage);

        panelCustomer4.add(jScrollImport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        lbBracUsageList.setBackground(new java.awt.Color(255, 0, 51));
        lbBracUsageList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelCustomer4.add(lbBracUsageList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnUsage.setBackground(new java.awt.Color(0, 153, 153));
        btnUsage.setForeground(new java.awt.Color(255, 255, 255));
        btnUsage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnUsage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsageMouseClicked(evt);
            }
        });
        panelCustomer4.add(btnUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelCustomer4.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff5.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff5.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff5.setText("Edit");
        btnEdittablestaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaff5MouseClicked(evt);
            }
        });
        panelCustomer4.add(btnEdittablestaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel127.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel127.setText("Search");
        panelCustomer4.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        usage_list.getContentPane().add(panelCustomer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(usage_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        usage_form.setVisible(false);
        usage_form.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu10.setBackground(new java.awt.Color(255, 255, 255));

        bracUsageForm.setAlignmentX(0.5F);
        bracUsageForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbUsage_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsage_form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsage_formMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tbUsage_form);

        panelstaffinfomation11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel121.setText("Create by staff name");
        panelstaffinfomation11.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 20));

        panelstaffinfomation11.add(cbStaffUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, 30));

        jLabel119.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel119.setText("Custraction Equipment Name");
        panelstaffinfomation11.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 230, 20));

        panelstaffinfomation11.add(cbCEUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 230, 30));

        jLabel124.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel124.setText("Usage Date");
        panelstaffinfomation11.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        txtDateUse.setEditable(false);
        txtDateUse.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation11.add(txtDateUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 29));

        jLabel126.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel126.setText("Total qty");
        panelstaffinfomation11.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, -1));

        txtTotalQtyUsae.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        txtTotalQtyUsae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalQtyUsaeActionPerformed(evt);
            }
        });
        panelstaffinfomation11.add(txtTotalQtyUsae, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        btnNewUsage.setBackground(new java.awt.Color(0, 153, 153));
        btnNewUsage.setForeground(new java.awt.Color(255, 255, 255));
        btnNewUsage.setText("Cancel");
        btnNewUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUsageActionPerformed(evt);
            }
        });
        panelstaffinfomation11.add(btnNewUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 90, 30));

        btnNewUsage1.setBackground(new java.awt.Color(0, 153, 153));
        btnNewUsage1.setForeground(new java.awt.Color(255, 255, 255));
        btnNewUsage1.setText("New");
        btnNewUsage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUsage1ActionPerformed(evt);
            }
        });
        panelstaffinfomation11.add(btnNewUsage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 90, 30));

        btnUpdateUsage.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdateUsage.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUsage.setText("Update");
        btnUpdateUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUsageActionPerformed(evt);
            }
        });
        panelstaffinfomation11.add(btnUpdateUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 90, 30));

        javax.swing.GroupLayout panelstaffmenu10Layout = new javax.swing.GroupLayout(panelstaffmenu10);
        panelstaffmenu10.setLayout(panelstaffmenu10Layout);
        panelstaffmenu10Layout.setHorizontalGroup(
            panelstaffmenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bracUsageForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation11, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane25))
                .addContainerGap())
        );
        panelstaffmenu10Layout.setVerticalGroup(
            panelstaffmenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bracUsageForm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation11, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
        );

        usage_form.getContentPane().add(panelstaffmenu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(usage_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        customer_list.setVisible(false);
        customer_list.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCustomer.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane17.setViewportView(tbCustomer);

        panelCustomer.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 118, 1010, 570));

        lbBracCustomerList.setBackground(new java.awt.Color(255, 0, 51));
        lbBracCustomerList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        panelCustomer.add(lbBracCustomerList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1000, 20));

        btnCustomer.setBackground(new java.awt.Color(0, 153, 153));
        btnCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
        });
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        panelCustomer.add(btnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 40, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        panelCustomer.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 880, 30));

        btnEdittablestaff1.setBackground(new java.awt.Color(0, 153, 153));
        btnEdittablestaff1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdittablestaff1.setForeground(new java.awt.Color(255, 255, 255));
        btnEdittablestaff1.setText("Edit");
        btnEdittablestaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEdittablestaff1MouseClicked(evt);
            }
        });
        panelCustomer.add(btnEdittablestaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 100, 30));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setText("Search");
        panelCustomer.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 60, 30));

        customer_list.getContentPane().add(panelCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 750));

        DesktopPane.add(customer_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        customer_form.setVisible(false);
        customer_form.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelstaffmenu6.setBackground(new java.awt.Color(255, 255, 255));

        bracCustomerForm.setAlignmentX(0.5F);
        bracCustomerForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));

        tbCustomer_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCustomer_form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomer_formMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tbCustomer_form);

        panelstaffinfomation7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 230, 29));

        jLabel103.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel103.setText("Create By Staff");
        panelstaffinfomation7.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 150, 20));

        jLabel104.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel104.setText("Address");
        panelstaffinfomation7.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        txtCustomerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 940, 29));

        jLabel128.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel128.setText("Gender");
        panelstaffinfomation7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 230, 20));

        btnCustomerNew.setBackground(new java.awt.Color(0, 153, 153));
        btnCustomerNew.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomerNew.setText("New");
        btnCustomerNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerNewActionPerformed(evt);
            }
        });
        panelstaffinfomation7.add(btnCustomerNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 90, 30));

        btnUpdateCustomer.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdateCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCustomer.setText("Update");
        btnUpdateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateCustomerMouseClicked(evt);
            }
        });
        panelstaffinfomation7.add(btnUpdateCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 90, 30));

        btnworkerCancel1.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerCancel1.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerCancel1.setText("Cancel");
        btnworkerCancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerCancel1MouseClicked(evt);
            }
        });
        panelstaffinfomation7.add(btnworkerCancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 90, 30));

        lbMessageCustomer.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        panelstaffinfomation7.add(lbMessageCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 230, 20));

        txtCustomerId.setEditable(false);
        txtCustomerId.setForeground(new java.awt.Color(255, 0, 0));
        txtCustomerId.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.add(txtCustomerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 230, 29));

        buttonGroup1.add(male);
        male.setActionCommand("Male");
        male.setLabel("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        panelstaffinfomation7.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        buttonGroup1.add(female);
        female.setLabel("Felmale");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        panelstaffinfomation7.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel129.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel129.setText("Customer ID");
        panelstaffinfomation7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 230, 29));

        jLabel130.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel130.setText("Phone");
        panelstaffinfomation7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 20));

        cboCustomer_CreatebyStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        cboCustomer_CreatebyStaff.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        panelstaffinfomation7.add(cboCustomer_CreatebyStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 250, 30));

        jLabel132.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel132.setText("Customer Name");
        panelstaffinfomation7.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 150, 20));

        btnworkerNew2.setBackground(new java.awt.Color(0, 153, 153));
        btnworkerNew2.setForeground(new java.awt.Color(255, 255, 255));
        btnworkerNew2.setText("click upload here");
        btnworkerNew2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnworkerNew2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnworkerNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btnworkerNew2)
                .addContainerGap())
        );

        tbProjectInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProjectInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjectInformationMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tbProjectInformation);

        javax.swing.GroupLayout panelstaffmenu6Layout = new javax.swing.GroupLayout(panelstaffmenu6);
        panelstaffmenu6.setLayout(panelstaffmenu6Layout);
        panelstaffmenu6Layout.setHorizontalGroup(
            panelstaffmenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelstaffmenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23)
                    .addComponent(bracCustomerForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelstaffinfomation7, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jScrollPane18)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelstaffmenu6Layout.setVerticalGroup(
            panelstaffmenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelstaffmenu6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bracCustomerForm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelstaffinfomation7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customer_form.getContentPane().add(panelstaffmenu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1050, 740));

        DesktopPane.add(customer_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1050, 740));

        getContentPane().add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 1040, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
       int x, y;
    private void panelmenuhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMousePressed

        setHideAllMenus(panelclicked1);
    }//GEN-LAST:event_panelmenuhomeMousePressed

    private void panelmenuhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuhomeMouseClicked

        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menuhome.setVisible(true);

        countAll();

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("HOME");
    }//GEN-LAST:event_panelmenuhomeMouseClicked

    private void panelmenustaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMouseClicked

        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menustaff.setVisible(false);
        menutablestaff.setVisible(true);

        showlableonclickedmenu.setText("");
        labelgidelineoftalestaff.setText("EMPLOYEE / STAFF / VIEW");
        getroleIDNrefreshtablestaff();

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("STAFF");

    }//GEN-LAST:event_panelmenustaffMouseClicked

    private void panelmenustaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenustaffMousePressed
        setHideAllMenus(panelclicked2);
    }//GEN-LAST:event_panelmenustaffMousePressed

    private void panelmenworkerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMousePressed
        setHideAllMenus(panelclicked3);

    }//GEN-LAST:event_panelmenworkerMousePressed

    private void panelmenworkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenworkerMouseClicked

        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menuworker.setVisible(false);
        menutableworker.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("WORKER");

        labelgidelineoftalebworker.setText("EMPLOYEE / WORKER / VIEW");
        getroleIDNrefreshtableworker();


    }//GEN-LAST:event_panelmenworkerMouseClicked

    private void panelmenpaymentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenpaymentMousePressed
        setHideAllMenus(panelclicked5);

    }//GEN-LAST:event_panelmenpaymentMousePressed

    private void panelmenpaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenpaymentMouseClicked

        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menupayment.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("PAYMENT");

        getcustomerstaffNrefreshtablepayment();
    }//GEN-LAST:event_panelmenpaymentMouseClicked

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

    public void cbogetstaffname() {
        try {
            Statement stat = con.createStatement();
            String selectstaffname = "select name from tbStaff";
            PreparedStatement mpst = con.prepareStatement(selectstaffname);
            ResultSet rsl = mpst.executeQuery();
            while (rsl.next()) {
                cbostaffName.addItem(rsl.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

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
                if (cbostaffName.getSelectedItem() == "None" && txtUsername.getText().trim().isEmpty() && cboposition.getSelectedItem() == "None" && txtpassword.getText().trim().isEmpty() && txtconfirmpassword.getText().trim().isEmpty()) {
                    staffnamerror.setText("Required.");
                    usernameerror.setText("Require.d");
                    positionerror.setText("Required.");
                    passworderror.setText("Required.");
                    conpassworderror.setText("Required.");
                    txtuserID.requestFocus();
                } else if (cbostaffName.getSelectedItem() == "None") {
                    staffnamerror.setText("Required.");
                    cbostaffName.requestFocus();
                } else if (txtUsername.getText().trim().isEmpty()) {
                    usernameerror.setText("Required");
                    txtUsername.requestFocus();
                } else if (txtpassword.getText().trim().isEmpty()) {
                    passworderror.setText("Required.");
                    txtpassword.requestFocus();
                } else if (cboposition.getSelectedItem() == "None") {
                    positionerror.setText("Required");
                    cboposition.requestFocus();
                } else if (txtconfirmpassword.getText().trim().isEmpty()) {
                    conpassworderror.setText("Required");
                    txtconfirmpassword.requestFocus();
                } else {
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
        try {
            String value = (tbviewuser.getModel().getValueAt(i, 0).toString());
            String updatequery = "update tbUser SET staff_name=?, username=?, position=?,password=? where id=" + value;
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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

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

    private void panelmenuinvoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuinvoiceMousePressed
        setHideAllMenus(panelclicked6);

    }//GEN-LAST:event_panelmenuinvoiceMousePressed

    private void panelmenuinvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuinvoiceMouseClicked
        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menuinvoice.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("INVOICE");

        getPaymentInfoNrefreshtablepayment();
    }//GEN-LAST:event_panelmenuinvoiceMouseClicked

    private void panelmenprojectplanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanMousePressed
        setHideAllMenus(panelclicked7);
    }//GEN-LAST:event_panelmenprojectplanMousePressed

    private void panelmenprojectplanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanMouseClicked

        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(false);
        menuprojectplan.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("PROJECTPLAN");

        getProinfoNrefreshtableProjectPlan();
    }//GEN-LAST:event_panelmenprojectplanMouseClicked

    private void btnProplanlistAddnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProplanlistAddnewMouseClicked
        menutableprojectview1.setVisible(false);
    }//GEN-LAST:event_btnProplanlistAddnewMouseClicked

    private void btnProplanlistAddPlanDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProplanlistAddPlanDetailMouseClicked
        menutableprojectview1.setVisible(false);
        menutableprojectview.setVisible(true);
    }//GEN-LAST:event_btnProplanlistAddPlanDetailMouseClicked
    public void getProjectPlanName() {
        cboViewProjectPlanName.removeAllItems();
        cboViewProjectPlanName.addItem("select");
        cboViewProjectPlanName.setSelectedItem("select");
        try {
            //getprojectplanName
            String selectproplanname = "select projectplan_name from tbProjectPlan";
            PreparedStatement ps = con.prepareStatement(selectproplanname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboViewProjectPlanName.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getProPlanDetailNrefreshtableProjectPlanListDetail() {
        txtProjectPlanDetailID.setText("");
        cboProjectPlanDetail_ListName.removeAllItems();
        cboProjectPlanDetail_ListName.addItem("select");
        cboProjectPlanDetail_ListName.setSelectedItem("select");
        txtProjectPlanDetailDateline.setDate(null);

        txtProjectPlanDetailName.setText("");
        try {
            //getprojectplanlist
            String selectproplandetail = "select projectplanlist_name from tbProjectPlanList";
            PreparedStatement ps = con.prepareStatement(selectproplandetail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboProjectPlanDetail_ListName.addItem(rs.getString(1));
            }

            //refreshtableProjectPlanListdetail
            String selectalltbProjectPlanlistdetail = "select * from tbProjectPlanListDetail";
            PreparedStatement pst = con.prepareStatement(selectalltbProjectPlanlistdetail);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbProjectPlanListDetail.setModel(model);

            model.addColumn("ID");
            model.addColumn("ProjectPlanListDetail Name");
            model.addColumn("ProjectPlanList Name");
            model.addColumn("Date Line");

            while (rst.next()) {
                int getidprojectplanlist = rst.getInt(4);
                String selectprojectdetail = "select projectplanlist_name from tbProjectPlanList where id='" + getidprojectplanlist + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectprojectdetail);

                while (rss.next()) {
                    model.addRow(new Object[]{rst.getString(1), rst.getString(2), rss.getString(1), rst.getString(3)});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getProPlanNrefreshtableProjectPlanList() {

        txtProjectPlanListID.setText("");

        cboProjectPlanList_ProjectPlanName.removeAllItems();
        cboProjectPlanList_ProjectPlanName.addItem("select");
        cboProjectPlanList_ProjectPlanName.setSelectedItem("select");

        cboProjectPlanListStaff.removeAllItems();
        cboProjectPlanListStaff.addItem("select");
        cboProjectPlanListStaff.setSelectedItem("select");

        txtProjectPlanListName.setText("");
        txtProjectPlanListStartDate.setDate(null);
        txtProjectPlanListFinishDate.setDate(null);
        cboProjectPlanListStatus.setSelectedItem("select");

        try {
            //get projectplan name
            String selectproplan = "select projectplan_name from tbProjectPlan";
            PreparedStatement ps = con.prepareStatement(selectproplan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboProjectPlanList_ProjectPlanName.addItem(rs.getString(1));
            }
            //get staff name
            String selectstaff = "select name from tbstaff";
            PreparedStatement pss = con.prepareStatement(selectstaff);
            ResultSet rss = pss.executeQuery();
            while (rss.next()) {
                cboProjectPlanListStaff.addItem(rss.getString(1));
            }
            //refreshtableProjectPlanList
            String selectalltbProjectPlanlist = "select * from tbProjectPlanList";
            PreparedStatement pst = con.prepareStatement(selectalltbProjectPlanlist);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbProjectPlanList.setModel(model);

            model.addColumn("ID");
            model.addColumn("ProjectPlanList Name");
            model.addColumn("ProjectPlan Name");
            model.addColumn("Staff Name");
            model.addColumn("Start Date");
            model.addColumn("Finish Date");
            model.addColumn("Status");

            while (rst.next()) {
                int getidprojectplan = rst.getInt(6);
                String selectproinfoid = "select projectplan_name from tbProjectPlan where id='" + getidprojectplan + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectproinfoid);

                int getidstaff = rst.getInt(7);
                String selectstaffname = "select name from tbStaff where id='" + getidstaff + "'";
                Statement pssss = con.createStatement();
                ResultSet rssss = pssss.executeQuery(selectstaffname);

                while (rsss.next()) {
                    while (rssss.next()) {
                        model.addRow(new Object[]{rst.getString(1), rst.getString(2), rsss.getString(1), rssss.getString(1), rst.getString(4), rst.getString(5), rst.getString(3)});
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getProinfoNrefreshtableProjectPlan() {

        txtProjectPlanID.setText("");
        txtProjectPlanName.setText("");
        cboProjectPlanInfoName.removeAllItems();
        cboProjectPlanInfoName.addItem("select");
        cboProjectPlanInfoName.setSelectedItem("select");

        txtProjectPlanLocation.setText("");
        txtProjectPlanTimeLine.setDate(null);
        cboProjectPlanStatus.setSelectedItem("select");

        try {
            //get pro info
            String selectproinfo = "select file_name from tbProjectInformation";
            PreparedStatement ps = con.prepareStatement(selectproinfo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboProjectPlanInfoName.addItem(rs.getString(1));
            }

            //refreshtableProjectPlan
            String selectalltbProjectPlan = "select * from tbProjectPlan";
            PreparedStatement pst = con.prepareStatement(selectalltbProjectPlan);
            ResultSet rst = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbProjectPlan.setModel(model);

            model.addColumn("ID");
            model.addColumn("ProjectPlan Name");
            model.addColumn("Project Information");
            model.addColumn("Location");
            model.addColumn("Time Line");
            model.addColumn("Status");

            while (rst.next()) {
                int getids = rst.getInt(6);
                String selectproinfoname = "select file_name from tbProjectInformation where id='" + getids + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectproinfoname);
                while (rss.next()) {
                    model.addRow(new Object[]{rst.getString(1), rst.getString(2), rss.getString(1), rst.getString(3), rst.getString(5),
                        rst.getString(4)});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getroleIDNrefreshtablestaff() {

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

        try {

            //getroleID
            String selectroleid = "select position from tbRole";
            PreparedStatement pss = con.prepareStatement(selectroleid);
            ResultSet rsl = pss.executeQuery();
            while (rsl.next()) {
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

            while (rst.next()) {
                int getids = rst.getInt(11);
                String selectrolename = "select position from tbRole where id='" + getids + "'";
                Statement ps = con.createStatement();
                ResultSet rss = ps.executeQuery(selectrolename);
                while (rss.next()) {
                    model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
                        rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rss.getString(1), rst.getString(12)});
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getPaymentInfoNrefreshtablepayment() {

        cboInvoicePaymentID.removeAllItems();
        cboInvoicePaymentID.addItem("select");
        cboInvoicePaymentID.setSelectedItem("select");
        labelInvoicePaymentIDrequired.setText("");
        txtInvoiceDate.setDate(null);
        cboInvoicestaffrName.removeAllItems();
        cboInvoicestaffrName.addItem("select");
        cboInvoicestaffrName.setSelectedItem("select");

        try {
            //getpaymentid
            String selectidpayment = "select id from tbPayment";
            PreparedStatement ps = con.prepareStatement(selectidpayment);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboInvoicePaymentID.addItem(rs.getString(1));
            }

            //getstaffname
            String selectnamestaff = "select name from tbStaff";
            PreparedStatement pss = con.prepareStatement(selectnamestaff);
            ResultSet rss = pss.executeQuery();
            while (rss.next()) {
                cboInvoicestaffrName.addItem(rss.getString(1));
            }

            //refrash table Invoice
            String selectinvoice = "select * from tbInvoice";
            PreparedStatement psv = con.prepareStatement(selectinvoice);
            ResultSet rsv = psv.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbInvoice.setModel(model);

            model.addColumn("ID");
            model.addColumn("Payment ID");
            model.addColumn("Customer Name");
            model.addColumn("Total Amount");
            model.addColumn("Paid Amount");
            model.addColumn("Owes Amount");
            model.addColumn("Invoice Date");
            model.addColumn("Staff Name");

            while (rsv.next()) {
                int getcustomerid = rsv.getInt(7);
                System.out.println("Customer ID: " + rsv.getInt(6));
                String selectrolename = "select name from tbCustomer where id='" + getcustomerid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectrolename);

                int getstaffid = rsv.getInt(6);
                String selectstaffid = "select name from tbStaff where id='" + getstaffid + "'";
                Statement pssss = con.createStatement();
                ResultSet rssss = pssss.executeQuery(selectstaffid);

                while (rsss.next()) {
                    while (rssss.next()) {
                        System.out.println("ID: " + rsv.getString(1));
                        model.addRow(new Object[]{rsv.getString(1), rsv.getString(8), rsss.getString(1), rsv.getString(2), rsv.getInt(3), rsv.getString(4), rsv.getString(5), rssss.getString(1)});
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getcustomerstaffNrefreshtablepayment() {
        try {
            txtPaymentID.setText("");

            cboPaymentCutomerName.removeAllItems();
            cboPaymentCutomerName.addItem("select");
            cboPaymentCutomerName.setSelectedItem("select");

            cboPaymentCreatebystaff.removeAllItems();
            cboPaymentCreatebystaff.addItem("select");
            cboPaymentCreatebystaff.setSelectedItem("select");

            txtPaymentTotalAmount.setText("");
            txtPaymentPaidAmount.setText("");
            txtPaymentOwesAmount.setText("");
            txtPaymentDate.setDate(null);

            //customerName
            String selectcustomername = "select name from tbCustomer";
            PreparedStatement ps = con.prepareStatement(selectcustomername);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cboPaymentCutomerName.addItem(rs.getString(1));
            }

            //staff name
            String selectstaffname = "select name from tbStaff";
            PreparedStatement pss = con.prepareStatement(selectstaffname);
            ResultSet rss = pss.executeQuery();
            while (rss.next()) {
                cboPaymentCreatebystaff.addItem(rss.getString(1));
            }

            //refreshtablepayment
            String selectpayment = "select * from tbPayment";
            PreparedStatement psp = con.prepareStatement(selectpayment);
            ResultSet rsp = psp.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            tbPayment.setModel(model);

            model.addColumn("ID");
            model.addColumn("Customer Name");
            model.addColumn("Staff Name");
            model.addColumn("Total Amount");
            model.addColumn("Paid Amount");
            model.addColumn("Owes Amount");
            model.addColumn("Payment Date");

            while (rsp.next()) {
                int getcustomerid = rsp.getInt(6);
                String selectrolename = "select name from tbCustomer where id='" + getcustomerid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectrolename);

                int getstaffid = rsp.getInt(7);
                String selectstaffid = "select name from tbStaff where id='" + getstaffid + "'";
                Statement pssss = con.createStatement();
                ResultSet rssss = pssss.executeQuery(selectstaffid);
                while (rsss.next()) {
                    while (rssss.next()) {
                        model.addRow(new Object[]{rsp.getString(1), rsss.getString(1), rssss.getString(1), rsp.getString(2), rsp.getInt(3), rsp.getString(4), rsp.getString(5)});
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void getroleIDNrefreshtableworker() {
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

        try {

            //getroleID
            String selectroleid = "select position from tbRole";
            PreparedStatement pss = con.prepareStatement(selectroleid);
            ResultSet rss = pss.executeQuery();
            while (rss.next()) {
                cboworkerroleID.addItem(rss.getString(1));
            }

            //getstaffname
            String selectstaffnameinfo = "select name from tbStaff";
            PreparedStatement psss = con.prepareStatement(selectstaffnameinfo);
            ResultSet rsss = psss.executeQuery();
            while (rsss.next()) {
                cboworkercreatebystaff.addItem(rsss.getString(1));
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

            while (rst.next()) {
                int getidrole = rst.getInt(10);
                String selectrolename = "select position from tbRole where id='" + getidrole + "'";
                Statement pssa = con.createStatement();
                ResultSet rs = pssa.executeQuery(selectrolename);

                int getidstaff = rst.getInt(11);
                String selectstaffname = "select name from tbStaff where id='" + getidstaff + "'";
                Statement psr = con.createStatement();
                ResultSet rssa = psr.executeQuery(selectstaffname);

                while (rs.next()) {
                    while (rssa.next()) {
                        model.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
                            rst.getString(6), rst.getString(7), rst.getString(8), rs.getString(1), rssa.getString(1), rst.getString(12)});

                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void btnStaffNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffNewMouseClicked

        if (txtStaffName.getText().trim().isEmpty() && cboStaffGender.getSelectedItem() == "None" && txtStaffNationlity.getText().trim().isEmpty()
                && txtStaffBirthday.getDate() == null && txtStaffHiredDate.getDate() == null && txtStaffSalary.getText().trim().isEmpty()
                && txtStaffPhone.getText().trim().isEmpty() && txtStaffAddress.getText().trim().isEmpty() && cboStaffroleID.getSelectedItem() == "None"
                && cboStaffStatus.getSelectedItem() == "None") {

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
        } else if (txtStaffName.getText().trim().isEmpty()) {
            labelstaffNamerequired.setText("required.");
            txtStaffName.requestFocus();
        } else if (cboStaffGender.getSelectedItem() == "None") {
            labelstaffgenderrequired.setText("required.");
            cboStaffGender.requestFocus();
        } else if (txtStaffNationlity.getText().trim().isEmpty()) {
            labelstaffnatrequired.setText("required.");
            txtStaffNationlity.requestFocus();
        } else if (txtStaffBirthday.getDate() == null) {
            labelstaffbirthrequired.setText("required.");
            txtStaffBirthday.requestFocus();
        } else if (txtStaffHiredDate.getDate() == null) {
            labelstaffhirdrequired.setText("required.");
            txtStaffHiredDate.requestFocus();
        } else if (txtStaffSalary.getText().trim().isEmpty()) {
            labelstaffsarequired.setText("required.");
            txtStaffSalary.requestFocus();
        } else if (txtStaffPhone.getText().trim().isEmpty()) {
            labelstaffphonerequired.setText("required.");
            txtStaffPhone.requestFocus();
        } else if (txtStaffAddress.getText().trim().isEmpty()) {
            labelstaffaddrerequired.setText("required.");
            txtStaffAddress.requestFocus();
        } else if (cboStaffroleID.getSelectedItem() == "None") {
            labelstaffroleidrequired.setText("required.");
            cboStaffroleID.requestFocus();
        } else if (cboStaffStatus.getSelectedItem() == "None") {
            labelstaffstaturequired.setText("required.");
            cboStaffStatus.requestFocus();
        } else {

            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbStaff where name='" + txtStaffName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true) {
                    labelmessagestaff.setText("Staff Create already.");
                } else {
                    String querystaff = "insert into tbStaff(name,gender,nationality,birthday,hired_date,salary,phone,address,photo,role_id,status)values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(querystaff);

                    //pst.setString(1, txtstaffID.getText().toString().trim());
                    pst.setString(1, txtStaffName.getText().trim());
                    pst.setString(2, cboStaffGender.getSelectedItem().toString());
                    pst.setString(3, txtStaffNationlity.getText().trim());

                    pst.setString(4, ((JTextField) txtStaffBirthday.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, ((JTextField) txtStaffHiredDate.getDateEditor().getUiComponent()).getText());

                    pst.setString(6, txtStaffSalary.getText().trim());
                    pst.setString(7, txtStaffPhone.getText().trim());
                    pst.setString(8, txtStaffAddress.getText().trim());

                    InputStream img = new FileInputStream(new File(imagePath));
                    pst.setBlob(9, img);

                    // insert roleID
                    try {
                        String getstaffrole = cboStaffroleID.getSelectedItem().toString();
                        String selectroleid = "select id from tbRole where position='" + getstaffrole + "'";
                        Statement pss = con.createStatement();
                        ResultSet rss = pss.executeQuery(selectroleid);
                        while (rss.next()) {
                            int id = rss.getInt(1);
                            pst.setInt(10, id);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                    pst.setString(11, cboStaffStatus.getSelectedItem().toString());

                    pst.executeUpdate();
                    labelmessagestaff.setText("Create staff sucessfully.");
                    getroleIDNrefreshtablestaff();

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnStaffNewMouseClicked
    public ImageIcon resizePic(String picPath) {

        ImageIcon myImg = new ImageIcon(picPath);
        Image img = myImg.getImage().getScaledInstance(labelpictureStaff.getWidth(), labelpictureStaff.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    private void btnStaffChoosepictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffChoosepictureMouseClicked
        JFileChooser fc = new JFileChooser();
        //fc.showOpenDialog(null);

        //file extension
        FileNameExtensionFilter filefilter = new FileNameExtensionFilter("*image", "png", "jpg", "gif", "svg");
        fc.addChoosableFileFilter(filefilter);

        int fileState = fc.showSaveDialog(null);

        if (fileState == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imagePath = path;
            //display the image in the lablepicturestaff
            //labelpictureStaff.setIcon(new ImageIcon(path));

            labelpictureStaff.setIcon(resizePic(path));
        } //if the user cancel
        else if (fileState == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image Selected");
        }
        //ImageIcon staffpicture = new ImageIcon(f.getAbsolutePath());

    }//GEN-LAST:event_btnStaffChoosepictureMouseClicked

    private void btnStaffUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStaffUpdateMouseClicked

        int s = tbStaff.getSelectedRow();
        try {
            String value = (tbStaff.getModel().getValueAt(s, 0).toString());
            String updatestaff = "update tbStaff SET name=?, gender=?, nationality=?, birthday=?, hired_date=?, salary=?, phone=?, address=?, photo=?, role_id=?, status=?  where id=" + value;
            PreparedStatement psf = con.prepareStatement(updatestaff);

            psf.setString(1, txtStaffName.getText().trim());
            psf.setString(2, cboStaffGender.getSelectedItem().toString());
            psf.setString(3, txtStaffNationlity.getText().trim());

            psf.setString(4, ((JTextField) txtStaffBirthday.getDateEditor().getUiComponent()).getText());
            psf.setString(5, ((JTextField) txtStaffHiredDate.getDateEditor().getUiComponent()).getText());

            psf.setString(6, txtStaffSalary.getText().trim());
            psf.setString(7, txtStaffPhone.getText().trim());
            psf.setString(8, txtStaffAddress.getText().trim());

            InputStream img = new FileInputStream(new File(imagePath));
            psf.setBlob(9, img);

            // insert roleID
            String getstaffrole = cboStaffroleID.getSelectedItem().toString();
            String selectroleid = "select id from tbRole where position='" + getstaffrole + "'";
            Statement pss = con.createStatement();
            ResultSet rss = pss.executeQuery(selectroleid);
            while (rss.next()) {
                int id = rss.getInt(1);
                psf.setInt(10, id);
            }

            psf.setString(11, cboStaffStatus.getSelectedItem().toString());
            psf.executeUpdate();
            labelmessagestaff.setText("Update staff successfully.");
            getroleIDNrefreshtablestaff();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnStaffUpdateMouseClicked

    private void tbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaffMouseClicked
        try {
            int i = tbStaff.getSelectedRow();
            TableModel tm = tbStaff.getModel();
            txtstaffID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbStaff where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtstaffID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
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
                byte[] imbyte = im.getBytes(1, (int) im.length());
                InputStream in = new ByteArrayInputStream(imbyte);
                BufferedImage imgFromDb = ImageIO.read(in);
                Image scaledImage = imgFromDb.getScaledInstance(labelpictureStaff.getWidth(), labelpictureStaff.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                labelpictureStaff.setIcon(icon);

                String getid = rs.getString(11);
                String selectroleid = "select position from tbRole where id='" + getid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectroleid);
                while (rss.next()) {
                    cboStaffroleID.setSelectedItem(rss.getString(1));
                }

                cboStaffStatus.setSelectedItem(rs.getString(12));

            }
        } catch (Exception ex) {
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
        try {
            int i = tbworker.getSelectedRow();
            TableModel tm = tbworker.getModel();
            txtworkerID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbWorker where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtworkerID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtworkerName.setText(rs.getString(2));

                String getidstaff = rs.getString(11);
                String selectroleid = "select name from tbStaff where id='" + getidstaff + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectroleid);
                while (rss.next()) {
                    cboworkercreatebystaff.setSelectedItem(rss.getString(1));
                }

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
                byte[] imbyte = im.getBytes(1, (int) im.length());
                InputStream in = new ByteArrayInputStream(imbyte);
                BufferedImage imgFromDb = ImageIO.read(in);
                Image scaledImage = imgFromDb.getScaledInstance(labelpictureworker.getWidth(), labelpictureworker.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                labelpictureworker.setIcon(icon);

                String getidrole = rs.getString(10);
                String selectroleidrole = "select position from tbRole where id='" + getidrole + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectroleidrole);
                while (rsss.next()) {
                    cboworkerroleID.setSelectedItem(rsss.getString(1));
                }

                cboworkerStatus.setSelectedItem(rs.getString(12));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbworkerMouseClicked

    private void btnworkerNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerNewMouseClicked
        if (txtworkerName.getText().trim().isEmpty() && cboworkercreatebystaff.getSelectedItem() == "select" && cboworkerGender.getSelectedItem() == "select"
                && txtworkerAddress.getText().trim().isEmpty() && txtworkerBirthday.getDate() == null && txtworkerHiredDate.getDate() == null && txtworkerSalary.getText().trim().isEmpty()
                && txtworkerPhone.getText().trim().isEmpty() && cboworkerroleID.getSelectedItem() == "select" && cboworkerStatus.getSelectedItem() == "select") {

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

        } else if (txtworkerName.getText().trim().isEmpty()) {
            labelworkerNamerequired.setText("required.");
            txtworkerName.requestFocus();
        } else if (cboworkercreatebystaff.getSelectedItem() == "select") {
            labelworkercreatebystaff.setText("required.");
            cboworkercreatebystaff.requestFocus();
        } else if (cboworkerGender.getSelectedItem() == "select") {
            labelworkergenderrequired.setText("required.");
            cboworkerGender.requestFocus();
        } else if (txtworkerAddress.getText().trim().isEmpty()) {
            labelworkeraddrerequired.setText("required.");
            txtworkerAddress.requestFocus();
        } else if (txtworkerBirthday.getDate() == null) {
            labelworkerbirthrequired.setText("required.");
            txtworkerBirthday.requestFocus();
        } else if (txtworkerHiredDate.getDate() == null) {
            labelworkerhirdrequired.setText("required.");
            txtworkerHiredDate.requestFocus();
        } else if (txtworkerPhone.getText().trim().isEmpty()) {
            labelworkerphonerequired.setText("required.");
            txtworkerPhone.requestFocus();
        } else if (cboworkerroleID.getSelectedItem() == "None") {
            labelworkerroleidrequired.setText("required.");
            cboworkerroleID.requestFocus();
        } else if (cboworkerStatus.getSelectedItem() == "None") {
            labelworkerstaturequired.setText("required.");
            cboworkerStatus.requestFocus();
        } else {

            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbWorker where name='" + txtworkerName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true) {
                    labelmessageworker.setText("worker Create already.");
                } else {
                    String queryworker = "insert into tbWorker(name,gender,birthday,hired_date,salary,phone,address,photo,role_id,staff_id,status)values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(queryworker);

                    pst.setString(1, txtworkerName.getText().trim());
                    pst.setString(2, cboworkerGender.getSelectedItem().toString());

                    pst.setString(3, ((JTextField) txtworkerBirthday.getDateEditor().getUiComponent()).getText());
                    pst.setString(4, ((JTextField) txtworkerHiredDate.getDateEditor().getUiComponent()).getText());

                    pst.setString(5, txtworkerSalary.getText().trim());
                    pst.setString(6, txtworkerPhone.getText().trim());
                    pst.setString(7, txtworkerAddress.getText().trim());

                    pst.setBytes(8, worker_image);

                    String position = cboworkerroleID.getSelectedItem().toString();
                    String selectroleid = "select id from tbRole where position='" + position + "'";
                    Statement pss = con.createStatement();
                    ResultSet rss = pss.executeQuery(selectroleid);

                    String staffname = cboworkercreatebystaff.getSelectedItem().toString();
                    String selectstaffname = "select id from tbStaff where name='" + staffname + "'";
                    Statement psss = con.createStatement();
                    ResultSet rsss = psss.executeQuery(selectstaffname);

                    while (rss.next()) {
                        pst.setString(9, rss.getString(1));
                    }

                    while (rsss.next()) {
                        pst.setString(10, rsss.getString(1));

                    }

                    pst.setString(11, cboworkerStatus.getSelectedItem().toString());

                    pst.executeUpdate();
                    labelmessageworker.setText("Create worker sucessfully.");
                    getroleIDNrefreshtableworker();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnworkerNewMouseClicked

    private void btnworkerUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerUpdateMouseClicked

        int s = tbworker.getSelectedRow();
        try {
            String value = (tbworker.getModel().getValueAt(s, 0).toString());
            String updateworker = "update tbWorker SET name=?, gender=?, birthday=?, hired_date=?, salary=?, phone=?, address=?, photo=?, role_id=?,staff_id=?, status=?  where id=" + value;
            PreparedStatement psf = con.prepareStatement(updateworker);

            psf.setString(1, txtworkerName.getText().trim());
            psf.setString(2, cboworkerGender.getSelectedItem().toString());

            psf.setString(3, ((JTextField) txtworkerBirthday.getDateEditor().getUiComponent()).getText());
            psf.setString(4, ((JTextField) txtworkerHiredDate.getDateEditor().getUiComponent()).getText());

            psf.setString(5, txtworkerSalary.getText().trim());
            psf.setString(6, txtworkerPhone.getText().trim());
            psf.setString(7, txtworkerAddress.getText().trim());

            psf.setBytes(8, worker_image);

            String getposition = cboworkerroleID.getSelectedItem().toString();
            String selectroleid = "select id from tbRole where position='" + getposition + "'";
            Statement pss = con.createStatement();
            ResultSet rss = pss.executeQuery(selectroleid);

            String getstaffname = cboworkercreatebystaff.getSelectedItem().toString();
            String selectstaffname = "select id from tbStaff where name='" + getstaffname + "'";
            Statement psss = con.createStatement();
            ResultSet rsss = psss.executeQuery(selectstaffname);

            while (rss.next()) {
                psf.setString(9, rss.getString(1));
            }
            while (rsss.next()) {
                psf.setString(10, rsss.getString(1));
            }

            psf.setString(11, cboworkerStatus.getSelectedItem().toString());
            psf.executeUpdate();
            labelmessageworker.setText("Update worker successfully.");
            getroleIDNrefreshtableworker();
        } catch (Exception ex) {
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
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(labelpictureworker.getWidth(), labelpictureworker.getHeight(), Image.SCALE_SMOOTH));
        labelpictureworker.setIcon(imageIcon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            worker_image = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnWorkerChoosepictureMouseClicked

    private void btnWorkerChoosepictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkerChoosepictureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWorkerChoosepictureActionPerformed

    private void tbPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPaymentMouseClicked
        try {
            int i = tbPayment.getSelectedRow();
            TableModel tm = tbPayment.getModel();
            txtPaymentID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbPayment where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtPaymentID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtPaymentTotalAmount.setText(rs.getString(2));
                txtPaymentPaidAmount.setText(rs.getString(3));
                txtPaymentOwesAmount.setText(rs.getString(4));

                String str = rs.getString(5);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date pdate = formatter.parse(str);
                txtPaymentDate.setDate(pdate);

                String getcustomerid = rs.getString(6);
                String selectcustomerid = "select name from tbCustomer where id='" + getcustomerid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectcustomerid);

                String getstaffid = rs.getString(7);
                String selectstaffid = "select name from tbStaff where id='" + getstaffid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectstaffid);

                while (rss.next()) {
                    cboPaymentCutomerName.setSelectedItem(rss.getString(1));
                }
                while (rsss.next()) {
                    cboPaymentCreatebystaff.setSelectedItem(rsss.getString(1));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbPaymentMouseClicked

    private void btnPaymentclearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentclearMouseClicked
        getcustomerstaffNrefreshtablepayment();
    }//GEN-LAST:event_btnPaymentclearMouseClicked

    private void btnPaymentUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentUpdateMouseClicked
        int s = tbPayment.getSelectedRow();
        try {
            String value = (tbPayment.getModel().getValueAt(s, 0).toString());
            String updatpayment = "update tbPayment SET total_amount=?, paid_amount=?,owes_amount=? , payment_date=?, customer_id=?, staff_id=?  where id=" + value;
            PreparedStatement psp = con.prepareStatement(updatpayment);

            psp.setString(1, txtPaymentTotalAmount.getText().trim());
            psp.setString(2, txtPaymentPaidAmount.getText().trim());
            psp.setString(3, txtPaymentOwesAmount.getText().trim());
            psp.setString(4, ((JTextField) txtPaymentDate.getDateEditor().getUiComponent()).getText());

            String getcustomerid = cboPaymentCutomerName.getSelectedItem().toString();
            String selectcustomerid = "select id from tbCustomer where name='" + getcustomerid + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectcustomerid);

            String getstaffname = cboPaymentCreatebystaff.getSelectedItem().toString();
            String selectstaffname = "select id from tbStaff where name='" + getstaffname + "'";
            Statement pss = con.createStatement();
            ResultSet rss = pss.executeQuery(selectstaffname);

            while (rs.next()) {
                psp.setInt(5, rs.getInt(1));
            }
            while (rss.next()) {
                psp.setInt(6, rss.getInt(1));
            }

            psp.executeUpdate();
            labelpaymentresult.setText("Update Payment successfully.");
            getcustomerstaffNrefreshtablepayment();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnPaymentUpdateMouseClicked

    private void btnPaymentNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentNewMouseClicked

        if (cboPaymentCutomerName.getSelectedItem() == "select" && cboPaymentCreatebystaff.getSelectedItem() == "select" && txtPaymentPaidAmount.getText().trim().isEmpty()
                && txtPaymentDate.getDate() == null && txtPaymentTotalAmount.getText().trim().isEmpty() && txtPaymentOwesAmount.getText().trim().isEmpty()) {
            labelpaymentstaffrequire.setText("require");
            labelpaymentCustomerrequired.setText("require");
            labelpaymentPaidrequired.setText("require");
            labelpaymentPaymentrequired.setText("require");
            labelpaymentTotalrequired.setText("require");
            labelpaymentOwesrequired.setText("require");

            cboPaymentCutomerName.requestFocus();
        } else if (cboPaymentCutomerName.getSelectedItem() == "select") {
            labelpaymentCustomerrequired.setText("require");
            cboPaymentCutomerName.requestFocus();
        } else if (cboPaymentCreatebystaff.getSelectedItem() == "select") {
            labelpaymentstaffrequire.setText("require");
            cboPaymentCreatebystaff.requestFocus();
        } else if (txtPaymentPaidAmount.getText().trim().isEmpty()) {
            labelpaymentPaidrequired.setText("require");
            txtPaymentPaidAmount.requestFocus();
        } else if (txtPaymentDate.getDate() == null) {
            labelpaymentPaymentrequired.setText("require");
            txtPaymentDate.requestFocus();
        } else if (txtPaymentTotalAmount.getText().trim().isEmpty()) {
            labelpaymentTotalrequired.setText("require");
            txtPaymentTotalAmount.requestFocus();
        } else if (txtPaymentOwesAmount.getText().trim().isEmpty()) {
            labelpaymentOwesrequired.setText("require");
            txtPaymentOwesAmount.requestFocus();
        } else {

            try {
                String querypayment = "insert into tbPayment(customer_id,staff_id,total_amount,paid_amount,owes_amount,payment_date)values(?,?,?,?,?,?)";
                PreparedStatement psp = con.prepareStatement(querypayment);

                String getcustomername = cboPaymentCutomerName.getSelectedItem().toString();
                String selectcustomername = "select id from tbCustomer where name='" + getcustomername + "'";
                Statement ps = con.createStatement();
                ResultSet rs = ps.executeQuery(selectcustomername);

                String staffname = cboPaymentCreatebystaff.getSelectedItem().toString();
                String selectstaffname = "select id from tbStaff where name='" + staffname + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffname);

                while (rs.next()) {
                    psp.setString(1, rs.getString(1));
                }

                while (rss.next()) {
                    psp.setString(2, rss.getString(1));

                }

                psp.setString(3, txtPaymentTotalAmount.getText().trim());
                psp.setString(4, txtPaymentPaidAmount.getText().trim());
                psp.setString(5, txtPaymentOwesAmount.getText().trim());
                psp.setString(6, ((JTextField) txtPaymentDate.getDateEditor().getUiComponent()).getText());

                psp.executeUpdate();
                labelpaymentresult.setText("Create payment sucessfully.");
                getcustomerstaffNrefreshtablepayment();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnPaymentNewMouseClicked

    private void tbInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvoiceMouseClicked
        try {
            int i = tbInvoice.getSelectedRow();
            TableModel tm = tbInvoice.getModel();
            txtInvoiceId.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbInvoice where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtInvoiceId.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cboInvoicePaymentID.setSelectedItem(rs.getString(8));

                String str = rs.getString(5);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date pdate = formatter.parse(str);
                txtInvoiceDate.setDate(pdate);

                String getstaffid = rs.getString(6);
                String selectstaffid = "select name from tbStaff where id='" + getstaffid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectstaffid);

                while (rsss.next()) {
                    cboInvoicestaffrName.setSelectedItem(rsss.getString(1));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbInvoiceMouseClicked

    private void btnInvoiceNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceNewMouseClicked
        if (cboInvoicePaymentID.getSelectedItem() == "select" && 
            txtInvoiceDate.getDate() == null && 
            cboInvoicestaffrName.getSelectedItem() == "select" ) {
            
            labelInvoicePaymentIDrequired.setText("require");
            labelInvoiceDatterequired.setText("require");
            labelInvoicestaffrequired.setText("require");
            cboInvoicePaymentID.requestFocus();
            
        } else if (cboInvoicePaymentID.getSelectedItem() == "select") {
            labelInvoicePaymentIDrequired.setText("require");
            cboInvoicePaymentID.requestFocus();
        } else if (txtInvoiceDate.getDate() == null) {
            labelInvoiceDatterequired.setText("require");
            txtInvoiceDate.requestFocus();
        } else if (cboInvoicestaffrName.getSelectedItem() == "select") {
            labelInvoicestaffrequired.setText("require");
            cboInvoicestaffrName.requestFocus();
        } else {
            try {
                String queryinvoice = "insert into tbInvoice(payment_id,customer_id,total_amount,paid_amount,owes_amount,invoice_date,staff_id)values(?,?,?,?,?,?,?)";
                PreparedStatement psv = con.prepareStatement(queryinvoice);

                String getpyment = cboInvoicePaymentID.getSelectedItem().toString();
                int p = Integer.parseInt(getpyment);
                psv.setInt(1, p);

                String getcustomername = txtInvoiceCustomer.getText().trim();
                String selectcustomername = "select id from tbCustomer where name='" + getcustomername + "'";
                Statement ps = con.createStatement();
                ResultSet rs = ps.executeQuery(selectcustomername);
                while (rs.next()) {
                    psv.setString(2, rs.getString(1));
                }

                psv.setString(3, txtInvoiceTotalAmount.getText().trim());
                psv.setString(4, txtInvoicePaidAmount.getText().trim());
                psv.setString(5, txtInvoiceOwesAmount.getText().trim());
                psv.setString(6, ((JTextField) txtInvoiceDate.getDateEditor().getUiComponent()).getText());

                String staffname = cboInvoicestaffrName.getSelectedItem().toString();
                String selectstaffname = "select id from tbStaff where name='" + staffname + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffname);
                while (rss.next()) {
                    psv.setString(7, rss.getString(1));

                }

                psv.executeUpdate();
                labelInvoiceResult.setText("Create Invoice sucessfully.");
                getPaymentInfoNrefreshtablepayment();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnInvoiceNewMouseClicked

    private void btnInvoiceUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceUpdateMouseClicked
        int s = tbInvoice.getSelectedRow();
        try {
            String value = (tbInvoice.getModel().getValueAt(s, 0).toString());
            String updatinvoice = "update tbInvoice SET payment_id=?,customer_id=? , total_amount=?, paid_amount=?,owes_amount=? , invoice_date=?, staff_id=? where id=" + value;
            PreparedStatement psi = con.prepareStatement(updatinvoice);

            psi.setString(1, cboInvoicePaymentID.getSelectedItem().toString());

            String getcutomername = txtInvoiceCustomer.getText().trim();
            String selectcustomername = "select id from tbCustomer where name='" + getcutomername + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectcustomername);
            while (rs.next()) {
                psi.setInt(2, rs.getInt(1));
            }

            psi.setString(3, txtInvoiceTotalAmount.getText().trim());
            psi.setString(4, txtInvoicePaidAmount.getText().trim());
            psi.setString(5, txtInvoiceOwesAmount.getText().trim());
            psi.setString(6, ((JTextField) txtInvoiceDate.getDateEditor().getUiComponent()).getText());

            String getstaffname = cboInvoicestaffrName.getSelectedItem().toString();
            String selectstaffname = "select id from tbStaff where name='" + getstaffname + "'";
            Statement pss = con.createStatement();
            ResultSet rss = pss.executeQuery(selectstaffname);

            while (rss.next()) {
                psi.setInt(7, rss.getInt(1));
            }

            psi.executeUpdate();
            labelInvoiceResult.setText("Update Invoice successfully.");
            getPaymentInfoNrefreshtablepayment();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnInvoiceUpdateMouseClicked

    private void btnInvoiceCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvoiceCancelMouseClicked
        getPaymentInfoNrefreshtablepayment();
    }//GEN-LAST:event_btnInvoiceCancelMouseClicked

    private void tbProjectPlanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjectPlanMouseClicked
        try {
            int i = tbProjectPlan.getSelectedRow();
            TableModel tm = tbProjectPlan.getModel();
            txtProjectPlanID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbProjectPlan where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtProjectPlanID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtProjectPlanName.setText(rs.getString(2));
                txtProjectPlanLocation.setText(rs.getString(3));
                cboProjectPlanStatus.setSelectedItem(rs.getString(4));

                String str = rs.getString(5);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date pdate = formatter.parse(str);
                txtProjectPlanTimeLine.setDate(pdate);

                int getidproinfo = rs.getInt(6);
                String selectproinfo = "select file_name from tbProjectInformation where id='" + getidproinfo + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectproinfo);

                while (rss.next()) {
                    cboProjectPlanInfoName.setSelectedItem(rss.getString(1));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbProjectPlanMouseClicked

    private void btnProjectPlanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanMouseClicked
        if (txtProjectPlanName.getText().trim().isEmpty() && cboProjectPlanInfoName.getSelectedItem() == "select" && txtProjectPlanLocation.getText().trim().isEmpty()
                && txtProjectPlanTimeLine.getDate() == null && cboProjectPlanInfoName.getSelectedItem() == "select" && cboProjectPlanStatus.getSelectedItem() == "select") {
            labelProjectPlanName.setText("require");
            labelProjectPlanInfoName.setText("require");
            labelProjectPlanLocation.setText("require");
            labelProjectPlanTimeLine.setText("require");
            labelProjectPlanStatus.setText("require");
            txtProjectPlanName.requestFocus();
        } else if (txtProjectPlanName.getText().trim().isEmpty()) {
            labelProjectPlanName.setText("require");
            txtProjectPlanName.requestFocus();
        } else if (cboProjectPlanInfoName.getSelectedItem() == "select") {
            labelProjectPlanInfoName.setText("require");
            txtProjectPlanLocation.requestFocus();
        } else if (txtProjectPlanLocation.getText().trim().isEmpty()) {
            labelProjectPlanLocation.setText("require");
            txtProjectPlanLocation.requestFocus();
        } else if (txtProjectPlanTimeLine.getDate() == null) {
            labelProjectPlanTimeLine.setText("require");
            txtProjectPlanTimeLine.requestFocus();
        } else if (cboProjectPlanInfoName.getSelectedItem() == "select") {
            labelProjectPlanStatus.setText("require");
            txtProjectPlanName.requestFocus();
        } else if (cboProjectPlanStatus.getSelectedItem() == "select") {
            labelProjectPlanStatus.setText("require");
            cboProjectPlanStatus.requestFocus();
        } else {
            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbProjectPlan where projectplan_name='" + txtProjectPlanName.getText().trim() + "'";
                ResultSet rss = stat.executeQuery(selectquery);
                if (rss.next() == true) {
                    labelProjectPlanResult.setText("ProjectPlan Create already.");
                } else {
                    String queryprojectplan = "insert into tbProjectPlan(projectplan_name, projectinformation_id, location, timeline, status)values(?,?,?,?,?)";
                    PreparedStatement psp = con.prepareStatement(queryprojectplan);

                    psp.setString(1, txtProjectPlanName.getText().trim());

                    String getproinfoname = cboProjectPlanInfoName.getSelectedItem().toString();
                    String selectproinfoname = "select id from tbProjectInformation where file_name='" + getproinfoname + "'";
                    Statement ps = con.createStatement();
                    ResultSet rs = ps.executeQuery(selectproinfoname);
                    while (rs.next()) {
                        psp.setInt(2, rs.getInt(1));
                    }

                    psp.setString(3, txtProjectPlanLocation.getText().trim());
                    psp.setString(4, ((JTextField) txtProjectPlanTimeLine.getDateEditor().getUiComponent()).getText());
                    psp.setString(5, cboProjectPlanStatus.getSelectedItem().toString());

                    psp.executeUpdate();
                    labelProjectPlanResult.setText("Create ProjectPlan sucessfully.");
                    getProinfoNrefreshtableProjectPlan();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnProjectPlanMouseClicked

    private void btnProjectPlanUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanUpdateMouseClicked
        int s = tbProjectPlan.getSelectedRow();
        try {
            String value = (tbProjectPlan.getModel().getValueAt(s, 0).toString());
            String updatprojectplan = "update tbProjectPlan SET projectplan_name=?, projectinformation_id=?, location=?, timeline=?, status=?  where id=" + value;
            PreparedStatement psp = con.prepareStatement(updatprojectplan);

            psp.setString(1, txtProjectPlanName.getText().trim());

            String getproinfoname = cboProjectPlanInfoName.getSelectedItem().toString();
            String selectproinfoname = "select id from tbProjectInformation where file_name='" + getproinfoname + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectproinfoname);
            while (rs.next()) {
                psp.setInt(2, rs.getInt(1));
            }

            psp.setString(3, txtProjectPlanLocation.getText().trim());
            psp.setString(4, ((JTextField) txtProjectPlanTimeLine.getDateEditor().getUiComponent()).getText());
            psp.setString(5, cboProjectPlanStatus.getSelectedItem().toString());

            psp.executeUpdate();
            labelProjectPlanResult.setText("Update ProjectPlan sucessfully.");
            getProinfoNrefreshtableProjectPlan();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnProjectPlanUpdateMouseClicked

    private void btnProjectPlanClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanClearMouseClicked
        getProinfoNrefreshtableProjectPlan();
    }//GEN-LAST:event_btnProjectPlanClearMouseClicked

    private void tbProjectPlanListDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjectPlanListDetailMouseClicked
        try {
            int i = tbProjectPlanListDetail.getSelectedRow();
            TableModel tm = tbProjectPlanListDetail.getModel();
            txtProjectPlanDetailID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbProjectPlanListDetail where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtProjectPlanDetailID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtProjectPlanDetailName.setText(rs.getString(2));

                int getprojectlist = rs.getInt(4);
                String selectproinfo = "select projectplanlist_name from tbProjectPlanList where id='" + getprojectlist + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectproinfo);

                while (rss.next()) {
                    cboProjectPlanDetail_ListName.setSelectedItem(rss.getString(1));
                }

                String str = rs.getString(3);
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date pdate = formatter.parse(str);
                txtProjectPlanDetailDateline.setDate(pdate);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbProjectPlanListDetailMouseClicked

    private void btnProjectPlanListNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanListNewMouseClicked
        if (cboProjectPlanList_ProjectPlanName.getSelectedItem() == "select" && cboProjectPlanListStaff.getSelectedItem() == "select"
                && txtProjectPlanListName.getText().trim().isEmpty() && txtProjectPlanListStartDate.getDate() == null
                && txtProjectPlanListFinishDate.getDate() == null && cboProjectPlanListStatus.getSelectedItem() == "select") {

            labelPPLName.setText("*");
            labelPPL_PPName.setText("*");
            labelPPLStaff.setText("*");
            labelPPLStartDate.setText("*");
            labelPPLFinishDate.setText("*");
            labelPPLStatus.setText("*");
            cboProjectPlanList_ProjectPlanName.requestFocus();
        } else if (cboProjectPlanList_ProjectPlanName.getSelectedItem() == "select") {
            labelPPL_PPName.setText("*");
            cboProjectPlanList_ProjectPlanName.requestFocus();
        } else if (cboProjectPlanListStaff.getSelectedItem() == "select") {
            labelPPL_PPName.setText("*");
            cboProjectPlanListStaff.requestFocus();
        } else if (txtProjectPlanListName.getText().trim().isEmpty()) {
            labelPPLName.setText("*");
            txtProjectPlanListName.requestFocus();
        } else if (txtProjectPlanListStartDate.getDate() == null) {
            labelPPLStartDate.setText("*");
            txtProjectPlanListStartDate.requestFocus();
        } else if (txtProjectPlanListFinishDate.getDate() == null) {
            labelPPLFinishDate.setText("*");
            txtProjectPlanListFinishDate.requestFocus();
        } else if (cboProjectPlanListStatus.getSelectedItem() == "select") {
            labelPPLStatus.setText("*");
            cboProjectPlanListStatus.requestFocus();
        } else {
            try {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbProjectPlanList where projectplanlist_name='" + txtProjectPlanListName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true) {
                    labelProjectPlanResult.setText("ProjectPlanList Create already.");
                } else {
                    String queryprojectplanlist = "insert into tbProjectPlanList (projectplan_id, staff_id, projectplanlist_name ,start_date, finish_date, status)values(?,?,?,?,?,?)";
                    PreparedStatement psp = con.prepareStatement(queryprojectplanlist);

                    String getprojectplan = cboProjectPlanList_ProjectPlanName.getSelectedItem().toString();
                    String selectproinfoname = "select id from tbProjectPlan where projectplan_name='" + getprojectplan + "'";
                    Statement pss = con.createStatement();
                    ResultSet rss = pss.executeQuery(selectproinfoname);
                    while (rss.next()) {
                        psp.setInt(1, rss.getInt(1));
                    }

                    String getstaff = cboProjectPlanListStaff.getSelectedItem().toString();
                    String selectstattname = "select id from tbStaff where name='" + getstaff + "'";
                    Statement psss = con.createStatement();
                    ResultSet rsss = psss.executeQuery(selectstattname);
                    while (rsss.next()) {
                        psp.setInt(2, rsss.getInt(1));
                    }

                    psp.setString(3, txtProjectPlanListName.getText().trim());
                    psp.setString(4, ((JTextField) txtProjectPlanListStartDate.getDateEditor().getUiComponent()).getText());
                    psp.setString(5, ((JTextField) txtProjectPlanListFinishDate.getDateEditor().getUiComponent()).getText());
                    psp.setString(6, cboProjectPlanListStatus.getSelectedItem().toString());

                    psp.executeUpdate();
                    labelPPLResult.setText("Create ProjectPlanList sucessfully.");
                    getProPlanNrefreshtableProjectPlanList();
                    getProPlanDetailNrefreshtableProjectPlanListDetail();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }//GEN-LAST:event_btnProjectPlanListNewMouseClicked

    private void btnProjectPlanListUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanListUpdateMouseClicked
        int s = tbProjectPlanList.getSelectedRow();
        try {
            String value = (tbProjectPlanList.getModel().getValueAt(s, 0).toString());
            String updatprojectplanlist = "update tbProjectPlanList SET projectplanlist_name=?, projectplan_id=?, staff_id=?,start_date=?, finish_date=?, status=? where id=" + value;
            PreparedStatement psp = con.prepareStatement(updatprojectplanlist);

            psp.setString(1, txtProjectPlanListName.getText().trim());

            String getprojectlist = cboProjectPlanList_ProjectPlanName.getSelectedItem().toString();
            String selectprojectlist = "select id from tbProjectPlan where projectplan_name='" + getprojectlist + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectprojectlist);
            while (rs.next()) {
                psp.setInt(2, rs.getInt(1));
            }

            String getstaffid = cboProjectPlanListStaff.getSelectedItem().toString();
            String selectstaff = "select id from tbStaff where name='" + getstaffid + "'";
            Statement pss = con.createStatement();
            ResultSet rss = pss.executeQuery(selectstaff);
            while (rss.next()) {
                psp.setInt(3, rss.getInt(1));
            }

            psp.setString(4, ((JTextField) txtProjectPlanListStartDate.getDateEditor().getUiComponent()).getText());
            psp.setString(5, ((JTextField) txtProjectPlanListFinishDate.getDateEditor().getUiComponent()).getText());
            psp.setString(6, cboProjectPlanListStatus.getSelectedItem().toString());

            psp.executeUpdate();
            labelPPLResult.setText("Update ProjectPlanList sucessfully.");
            getProPlanNrefreshtableProjectPlanList();
            getProPlanDetailNrefreshtableProjectPlanListDetail();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnProjectPlanListUpdateMouseClicked

    private void btnProjectPlanListClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanListClearMouseClicked
        getProPlanNrefreshtableProjectPlanList();
    }//GEN-LAST:event_btnProjectPlanListClearMouseClicked

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

    private void tbProjectPlanListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjectPlanListMouseClicked
        try {
            int i = tbProjectPlanList.getSelectedRow();
            TableModel tm = tbProjectPlanList.getModel();
            txtProjectPlanListID.setText(tm.getValueAt(i, 0).toString());
            String viewqurey = "select * from tbProjectPlanList where id=?";
            PreparedStatement pst = con.prepareStatement(viewqurey);
            pst.setString(1, txtProjectPlanListID.getText().trim());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                txtProjectPlanListName.setText(rs.getString(2));

                int projectplanid = rs.getInt(6);
                System.out.println("get planid:" + projectplanid);
                String selectplanid = "select projectplan_name from tbProjectPlan where id='" + projectplanid + "'";
                Statement psss = con.createStatement();
                ResultSet rsss = psss.executeQuery(selectplanid);
                while (rsss.next()) {
                    System.out.println("Project");
                    cboProjectPlanList_ProjectPlanName.setSelectedItem(rsss.getString(1));
                }

                int staffid = rs.getInt(7);
                String selectstaffid = "select name from tbStaff where id='" + staffid + "'";
                Statement pss = con.createStatement();
                ResultSet rss = pss.executeQuery(selectstaffid);
                while (rss.next()) {
                    cboProjectPlanListStaff.setSelectedItem(rss.getString(1));
                }

                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

                String str = rs.getString(4);
                java.util.Date sdate = formatter.parse(str);
                txtProjectPlanListStartDate.setDate(sdate);

                String strs = rs.getString(5);
                java.util.Date fdate = formatter.parse(strs);
                txtProjectPlanListFinishDate.setDate(fdate);

                cboProjectPlanListStatus.setSelectedItem(rs.getString(3));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbProjectPlanListMouseClicked

    private void btnProjectPlanListDetailNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanListDetailNewMouseClicked
        try {
            if (txtProjectPlanDetailName.getText().trim().isEmpty() && cboProjectPlanDetail_ListName.getSelectedItem() == "select" && txtProjectPlanDetailDateline.getDate() == null) {
                labelPPLDDetailname.setText("*");
                labelPPLDProjectplanListName.setText("*");
                labelPPLDDateline.setText("*");
                cboProjectPlanDetail_ListName.requestFocus();
            } else if (txtProjectPlanDetailName.getText().trim().isEmpty()) {
                labelPPLDDetailname.setText("*");
                txtProjectPlanDetailName.requestFocus();
            } else if (cboProjectPlanDetail_ListName.getSelectedItem() == "select") {
                labelPPLDProjectplanListName.setText("*");
                cboProjectPlanDetail_ListName.requestFocus();
            } else if (txtProjectPlanDetailDateline.getDate() == null) {
                labelPPLDDateline.setText("*");
                txtProjectPlanDetailDateline.requestFocus();
            } else {
                Statement stat = con.createStatement();
                String selectquery = "Select * from tbProjectPlanListDetail where projectplanlistdetail_name='" + txtProjectPlanDetailName.getText().trim() + "'";
                ResultSet rs = stat.executeQuery(selectquery);
                if (rs.next() == true) {
                    labelPPLDResult.setText("ProjectPlanListDetail Create already.");
                } else {
                    String queryprojectplanlistdetail = "insert into tbProjectPlanListDetail (projectplanlistDetail_name, projectplanlist_id, dateline)values(?,?,?)";
                    PreparedStatement psp = con.prepareStatement(queryprojectplanlistdetail);

                    psp.setString(1, txtProjectPlanDetailName.getText().trim());

                    String getprojectplandetail = cboProjectPlanDetail_ListName.getSelectedItem().toString();
                    String selectprojectdetail = "select id from tbProjectPlanList where projectplanlist_name='" + getprojectplandetail + "'";
                    Statement pss = con.createStatement();
                    ResultSet rss = pss.executeQuery(selectprojectdetail);
                    while (rss.next()) {
                        psp.setInt(2, rss.getInt(1));
                    }

                    psp.setString(3, ((JTextField) txtProjectPlanDetailDateline.getDateEditor().getUiComponent()).getText());

                    psp.executeUpdate();
                    labelPPLDResult.setText("Create sucessfully.");
                    getProPlanDetailNrefreshtableProjectPlanListDetail();
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnProjectPlanListDetailNewMouseClicked

    private void btnProjectPlanDetailUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanDetailUpdateMouseClicked
        int s = tbProjectPlanListDetail.getSelectedRow();
        try {
            String value = (tbProjectPlanListDetail.getModel().getValueAt(s, 0).toString());
            String updatprojectplanlistdetail = "update tbProjectPlanListDetail SET projectplanlistDetail_name=?, projectplanlist_id=?, dateline=? where id=" + value;
            PreparedStatement psp = con.prepareStatement(updatprojectplanlistdetail);

            psp.setString(1, txtProjectPlanDetailName.getText().trim());

            String getprojectlistdetail = cboProjectPlanDetail_ListName.getSelectedItem().toString();
            String selectprojectlistdetail = "select id from tbProjectPlanList where projectplanlist_name='" + getprojectlistdetail + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(selectprojectlistdetail);
            while (rs.next()) {
                psp.setInt(2, rs.getInt(1));
            }

            psp.setString(3, ((JTextField) txtProjectPlanDetailDateline.getDateEditor().getUiComponent()).getText());

            psp.executeUpdate();
            labelPPLDResult.setText("Update sucessfully.");
            getProPlanDetailNrefreshtableProjectPlanListDetail();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnProjectPlanDetailUpdateMouseClicked

    private void btnProjectPlanDetailClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProjectPlanDetailClearMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProjectPlanDetailClearMouseClicked

    private void panelmenprojectplanlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlistMouseClicked
        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menutableprojectview.setVisible(false);
        menuprojectplanList.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("PROJECTPLAN LIST");

        getProPlanNrefreshtableProjectPlanList();
        getProPlanDetailNrefreshtableProjectPlanListDetail();
    }//GEN-LAST:event_panelmenprojectplanlistMouseClicked

    private void panelmenprojectplanlistMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanlistMousePressed
        setHideAllMenus(panelclicked8);
    }//GEN-LAST:event_panelmenprojectplanlistMousePressed

    private void cboInvoicePaymentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboInvoicePaymentIDActionPerformed
        try {
            if (cboInvoicePaymentID.getSelectedItem() == "select") {
                labelInvoicePaymentIDrequired.setText("Please select Payment ID");
                txtInvoiceCustomer.setText("");
                txtInvoiceTotalAmount.setText("");
                txtInvoicePaidAmount.setText("");
                txtInvoiceOwesAmount.setText("");
            } else if (cboInvoicePaymentID.getSelectedItem() == null) {

            } else {
                // getinfopayment customer, Total Amount, Paid Amount, Owes Amount
                labelInvoicePaymentIDrequired.setText("");

                String getpaymentid = cboInvoicePaymentID.getSelectedItem().toString();
                String selectinfopayment = "select * from tbPayment where id='" + getpaymentid + "'";
                PreparedStatement pss = con.prepareStatement(selectinfopayment);
                ResultSet rss = pss.executeQuery();
                while (rss.next()) {
                    //getcustomername
                    int getcustomerid = rss.getInt(6);
                    String selectcustomerid = "select name from tbCustomer where id='" + getcustomerid + "'";
                    PreparedStatement psss = con.prepareStatement(selectcustomerid);
                    ResultSet rsss = psss.executeQuery();
                    while (rsss.next()) {
                        txtInvoiceCustomer.setText(rsss.getString(1));
                    }
                    //gettotal amount
                    txtInvoiceTotalAmount.setText(rss.getString(2));
                    txtInvoicePaidAmount.setText(rss.getString(3));
                    txtInvoiceOwesAmount.setText(rss.getString(4));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_cboInvoicePaymentIDActionPerformed

    private void panelmenprojectplanviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanviewMouseClicked
        menuhome.setVisible(false);
        menuuser.setVisible(false);
        menutablestaff.setVisible(false);
        menustaff.setVisible(false);
        menutableworker.setVisible(false);
        menuworker.setVisible(false);
        menupayment.setVisible(false);
        menuinvoice.setVisible(false);
        menuprojectplan.setVisible(false);
        menuprojectplanList.setVisible(false);
        menutableprojectview.setVisible(true);

        showlableonclickedmenu.setText("");
        showlableonclickedmenu.setText("PROJECTPLAN VIEW");

        getProjectPlanName();
    }//GEN-LAST:event_panelmenprojectplanviewMouseClicked

    private void panelmenprojectplanviewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenprojectplanviewMousePressed
        setHideAllMenus(panelclicked9);

    }//GEN-LAST:event_panelmenprojectplanviewMousePressed

    private void cboViewProjectPlanNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViewProjectPlanNameActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        tbViewProjectPlanList.setModel(model);
        model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("ProjectPlanList Name");
        model.addColumn("Status");
        if (cboViewProjectPlanName.getSelectedItem() == "select") {
            cboViewProjectPlanName.requestFocus();
            model.setRowCount(0);
        } else if (cboViewProjectPlanName.getSelectedItem() == null) {
            model.setRowCount(0);
        } else {
            try {
                //get table ProjectPlanlist View
                String getprojectplanname = cboViewProjectPlanName.getSelectedItem().toString();
                String selectplanname = "select id from tbProjectPlan where projectplan_name='" + getprojectplanname + "'";
                PreparedStatement ps = con.prepareStatement(selectplanname);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int getidproplan = rs.getInt(1);
                    String selectproplanid = "select * from tbProjectPlanList where projectplan_id='" + getidproplan + "'";
                    PreparedStatement pss = con.prepareStatement(selectproplanid);
                    ResultSet rss = pss.executeQuery();

                    while (rss.next()) {

                        model.addRow(new Object[]{rss.getString(1), rss.getString(2), rss.getString(3)});
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }//GEN-LAST:event_cboViewProjectPlanNameActionPerformed

    private void tbViewProjectPlanListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViewProjectPlanListMouseClicked
        DefaultTableModel model = new DefaultTableModel();
        tbViewProjectPlanListDetail.setModel(model);
        model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("ProjectPlanListDetail Name");
        model.addColumn("Date Line");
        try {
            int index = tbViewProjectPlanList.getSelectedRow();
            TableModel models = tbViewProjectPlanList.getModel();
            String projectlistname = models.getValueAt(index, 1).toString();

            String getidprojectdetail = "select id from tbProjectPlanList where projectplanlist_name='" + projectlistname + "'";
            PreparedStatement ps = con.prepareStatement(getidprojectdetail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int getidprojectplandetail = rs.getInt(1);
                String selectprojectdetailname = "select * from tbProjectPlanListDetail where projectplanlist_id='" + getidprojectplandetail + "'";
                PreparedStatement pss = con.prepareStatement(selectprojectdetailname);
                ResultSet rss = pss.executeQuery();
                while (rss.next()) {
                    model.addRow(new Object[]{rss.getString(1), rss.getString(2), rss.getString(3)});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tbViewProjectPlanListMouseClicked

    private void panelmenImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenImportMouseClicked
        // TODO add your handling code here:
//        showList(import_list);
        import_list.setVisible(true);
        Import importList = new Import();
        importList.getImport(tbImport);

        lbBracImportList.setText("IMPORT / LIST ");

    }//GEN-LAST:event_panelmenImportMouseClicked

    private void panelmenImportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenImportMousePressed
        // TODO add your handling code here:
        setHideAllMenus(panelclicked10);
    }//GEN-LAST:event_panelmenImportMousePressed

    private void tbImport_formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImport_formMouseClicked
        ImportDetails imd = new ImportDetails();
        imd.clearImportDetail(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);
        
        ConstractionEquiment ce = new ConstractionEquiment();
        for (String ceList : ce.getAllCE()) {
            cbCEImportDetails.addItem(ceList);
        }

        Import im = new Import();
        im.getSelecttbImport(txtImportDate, cbStaffNameImport, cbSupplierNameImport, tbImport_form);
        
        im.getImportID(txtImportId_Detail, tbImport_form);
        
        ImportDetails importDetails = new ImportDetails();
        int importId = Integer.parseInt(txtImportId_Detail.getText());
        importDetails.getImportDetailsByImportId(importId, tbImport_form_detail);
       
    }//GEN-LAST:event_tbImport_formMouseClicked

    private void btnworkerCancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerCancel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnworkerCancel4MouseClicked

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
        // TODO add your handling code here:
        import_list.setVisible(false);
        import_form.setVisible(true);

        Import importObj = new Import();
        importObj.getImport(tbImport_form);

        bracImportForm.setText("IMPORT / NEW");

        Staff staff = new Staff();
        for (String staffList : staff.getAllStaff()) {
            cbStaffNameImport.addItem(staffList);
        }

        java.sql.Date importDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        txtImportDate.setText(importDate.toString());
        
        Supplier supplier = new Supplier();
        for (String supplierList : supplier.getAllSupplier()) {
            cbSupplierNameImport.addItem(supplierList);
        }
        ImportDetails imd = new ImportDetails();
        imd.clearImportDetail(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);
        
        ConstractionEquiment ce = new ConstractionEquiment();
        for (String ceList : ce.getAllCE()) {
            cbCEImportDetails.addItem(ceList);
        }
        
        
    }//GEN-LAST:event_btnImportMouseClicked

    private void btnEdittablestaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaff4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittablestaff4MouseClicked

    private void menuCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCustomerMouseClicked

        showList(customer_list);

//        Staff st = new Staff();
//        for (String stafflist : st.getAllStaff()){
//            cboCustomer_CreatebyStaff.addItem(stafflist);
//        }
        //list customer
        Customer customer = new Customer();
        customer.getCustomer(tbCustomer);

        lbBracCustomerList.setText("CUSTOMER / LIST ");

    }//GEN-LAST:event_menuCustomerMouseClicked

    private void menuCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCustomerMousePressed

        setHideAllMenus(panelclicked4);
    }//GEN-LAST:event_menuCustomerMousePressed

    private void menuSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSupplierMouseClicked
        // TODO add your handling code here:
        showList(supplier_list);

        showlableonclickedmenu.setText("");
        Supplier supplier = new Supplier();
        supplier.getSupplier(tbSupplier);

        lbBracSupplierList.setText("SUPPLIER / LIST");
    }//GEN-LAST:event_menuSupplierMouseClicked

    private void menuSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSupplierMousePressed
        // TODO add your handling code here:
        setHideAllMenus(panelclicked12);
    }//GEN-LAST:event_menuSupplierMousePressed

    private void menuUsageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsageMouseClicked

        showList(usage_list);

        Usage usage = new Usage();
        usage.getUsage(tbUsage);

        lbBracUsageList.setText("USAGE / LIST");
    }//GEN-LAST:event_menuUsageMouseClicked

    private void menuUsageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsageMousePressed

        setHideAllMenus(panelclicked13);
    }//GEN-LAST:event_menuUsageMousePressed

    private void panelclicked11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelclicked11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelclicked11MousePressed

    private void menuCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCEMouseClicked
        // TODO add your handling code here:
        showList(ce_list);

        ConstractionEquiment ce = new ConstractionEquiment();
        ce.getConstractionEquiment(tbCE);

        lbBracCEList.setText("CUSTACTION EQUIPMENT / LIST ");
    }//GEN-LAST:event_menuCEMouseClicked

    private void menuCEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCEMousePressed
        // TODO add your handling code here:
        setHideAllMenus(panelclicked11);
    }//GEN-LAST:event_menuCEMousePressed

    private void tbSupplier_formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplier_formMouseClicked
        Supplier sup = new Supplier();
        
        String getdender = sup.getSelecttbSupplier(txtSupplierId, txtSupplierName,gender, txtSupplierPhone, txtSupplierAddress, tbSupplier_form);
        System.out.println("Supplier ID: " + getdender);
        if (getdender.equals("male")) {
            male1.setSelected(true);
        } else {
            female1.setSelected(true);
        }
    }//GEN-LAST:event_tbSupplier_formMouseClicked

    private void btnSupplierNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierNewActionPerformed
        // TODO add your handling code here:
        Supplier supplier = new Supplier();
        supplier.createSupplier(txtSupplierName, gender, txtSupplierPhone, txtSupplierAddress, lbMessageSupplier, tbSupplier_form);
        
        supplier.clearSupplier(txtSupplierId,txtSupplierName, gender, txtSupplierPhone, txtSupplierAddress);

    }//GEN-LAST:event_btnSupplierNewActionPerformed

    private void btnSupplierClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierClearMouseClicked
        Supplier supplier = new Supplier();
        supplier.clearSupplier(txtSupplierId,txtSupplierName, gender, txtSupplierPhone, txtSupplierAddress);
    }//GEN-LAST:event_btnSupplierClearMouseClicked

    private void male1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_male1ActionPerformed
        // TODO add your handling code here:
        gender = "male";
    }//GEN-LAST:event_male1ActionPerformed

    private void female1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_female1ActionPerformed
        // TODO add your handling code here:
        gender = "felmale";
    }//GEN-LAST:event_female1ActionPerformed

    private void btnSupplierCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierCreateMouseClicked
        // TODO add your handling code here:
        supplier_list.setVisible(false);
        supplier_form.setVisible(true);

        Supplier supplier = new Supplier();
        supplier.getSupplier(tbSupplier_form);

        bracSupplierForm.setText("SUPPLIER / NEW ");
    }//GEN-LAST:event_btnSupplierCreateMouseClicked

    private void btnEdittablestaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaff2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittablestaff2MouseClicked

    private void tbCE_formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCE_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCE_formMouseClicked

    private void txtStockQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockQtyActionPerformed

    private void btnCENewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCENewMouseClicked

        ConstractionEquiment constractionEquiment = new ConstractionEquiment();
        constractionEquiment.create(txtCEName, tbCE_form);


    }//GEN-LAST:event_btnCENewMouseClicked

    private void btnECUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnECUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnECUpdateMouseClicked

    private void btnCECancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCECancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCECancelMouseClicked

    private void btnCECancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCECancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCECancelActionPerformed

    private void btnCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCEMouseClicked
        // TODO add your handling code here:
        ce_list.setVisible(false);
        ce_form.setVisible(true);

        ConstractionEquiment constractionEquiment = new ConstractionEquiment();
        constractionEquiment.getConstractionEquiment(tbCE_form);

        bracCEForm.setText("CUNSTRACTION EQUIPMENT / NEW ");
    }//GEN-LAST:event_btnCEMouseClicked

    private void btnEdittablestaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaff3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittablestaff3MouseClicked

    private void btnUsageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsageMouseClicked
        // TODO add your handling code here:
        usage_list.setVisible(false);
        usage_form.setVisible(true);

//        ConstractionEquiment ce = new ConstractionEquiment();
//        for (String ceList : ce.getAllCE()){
//            cbCEUsage.addItem(ceList);
//        }
//            
//         Staff staff = new Staff();
//        for (String staffList : staff.getAllStaff()) {
//            cbStaffUsage.addItem(staffList);
//        }
        Usage usage = new Usage();
        usage.ClearUsage(cbStaffUsage, cbCEUsage, txtTotalQtyUsae);
        
        java.sql.Date usageDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        txtDateUse.setText(usageDate.toString());

        
        usage.getUsage(tbUsage_form);
                     
//        for (String staffList : staff.get)

        bracUsageForm.setText("USAGE / NEW ");
    }//GEN-LAST:event_btnUsageMouseClicked

    private void btnEdittablestaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaff5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittablestaff5MouseClicked

    private void tbUsage_formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsage_formMouseClicked
        Usage us = new Usage();
        us.getSelectTableUsage(cbStaffUsage, cbCEUsage, txtDateUse, txtTotalQtyUsae, tbUsage_form);
    }//GEN-LAST:event_tbUsage_formMouseClicked

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
        // TODO add your handling code here:
        customer_list.setVisible(false);
        customer_form.setVisible(true);

        // list customer
        Customer customer = new Customer();
        customer.getCustomer(tbCustomer_form);

        //list project information
        ProjectInforamtion projectInformation = new ProjectInforamtion();
//        projectInformation.getProjectInformation(tbProjectInformation);

        bracCustomerForm.setText("CUSTOMER / NEW");

        customer.clear(txtCustomerId, txtCustomerName, gender, txtPhone, txtCustomerAddress, cboCustomer_CreatebyStaff);

        Staff st = new Staff();
        for (String stafflist : st.getAllStaff()) {
            cboCustomer_CreatebyStaff.addItem(stafflist);
        }

//        customer.clear(txtCode, txtName, gender, txtPhone,txtCustomerAddress, cboCustomer_CreatebyStaff);
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnEdittablestaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEdittablestaff1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdittablestaff1MouseClicked

    private void tbCustomer_formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomer_formMouseClicked
        Customer cu = new Customer();
        String getcu = cu.addCustomerSelect(txtCustomerId, txtCustomerName, txtPhone, txtCustomerAddress, cboCustomer_CreatebyStaff, tbCustomer_form);

        if (getcu.equals("Male")) {
            male.setSelected(true);
        } else {
            female.setSelected(true);
        }
    }//GEN-LAST:event_tbCustomer_formMouseClicked

    private void btnCustomerNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerNewActionPerformed
        // TODO add your handling code here:
        int staffID = 0;
        Customer customer = new Customer();
        Staff st = new Staff();
        staffID = st.getStaffIdByName(cboCustomer_CreatebyStaff);
        customer.create(txtCustomerName, gender, txtPhone, txtCustomerAddress, staffID, lbMessageCustomer, tbCustomer_form);

        customer.getCustomer(tbCustomer_form);
        customer.clear(txtCustomerId, txtCustomerName, gender, txtPhone, txtCustomerAddress, cboCustomer_CreatebyStaff);
        for (String stafflist : st.getAllStaff()) {
            cboCustomer_CreatebyStaff.addItem(stafflist);
        }
        
        

    }//GEN-LAST:event_btnCustomerNewActionPerformed

    private void btnUpdateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateCustomerMouseClicked
        Staff st = new Staff();
        Customer customer = new Customer();
        int staffID = st.getStaffIdByName(cboCustomer_CreatebyStaff);
        if (male.equals("Male")) {
            gender = "male";
        }
        else {
            gender = "female";
        }
        customer.update(txtCustomerName, gender, txtPhone, txtCustomerAddress, staffID, lbMessageCustomer, tbCustomer_form);

        customer.clear(txtCustomerId, txtCustomerName, gender, txtPhone, txtCustomerAddress, cboCustomer_CreatebyStaff);
        for (String stafflist : st.getAllStaff()) {
            cboCustomer_CreatebyStaff.addItem(stafflist);
        }
    }//GEN-LAST:event_btnUpdateCustomerMouseClicked

    private void btnworkerCancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerCancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnworkerCancel1MouseClicked

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        gender = "male";
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        gender = "felmale";
    }//GEN-LAST:event_femaleActionPerformed

    private void btnImportDetailsNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportDetailsNewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportDetailsNewMouseClicked

    private void btnImportDetialUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportDetialUpdateMouseClicked

        int ceID = 0;
        ConstractionEquiment ce = new ConstractionEquiment();
        ceID = ce.getCEByName(cbCEImportDetails);
        
        int importId = Integer.parseInt(txtImportId_Detail.getText());
        int importQtyImport = Integer.parseInt(txtImportQtyImportDetails.getText());
        int unitPrice = Integer.parseInt(txtUnitPriceImportDetails.getText());
        double amount = importQtyImport * unitPrice;
        
        ImportDetails importDetails = new ImportDetails();
        importDetails.update(importQtyImport, unitPrice, amount, importId, ceID, tbImport_form_detail);
        
        importDetails.clearImportDetail(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);
        for (String ceList : ce.getAllCE()) {
            cbCEImportDetails.addItem(ceList);
        }
        
        importDetails.getImportDetailsByImportId(importId, tbImport_form_detail);

    }//GEN-LAST:event_btnImportDetialUpdateMouseClicked

    private void btnworkerCancel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerCancel6MouseClicked
        ImportDetails imd = new ImportDetails();
        imd.clearImportDetail(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);
    }//GEN-LAST:event_btnworkerCancel6MouseClicked

    private void btnImportDetailsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportDetailsNewActionPerformed
        // TODO add your handling code here:
        int ceID = 0;
        ConstractionEquiment ce = new ConstractionEquiment();
        ceID = ce.getCEByName(cbCEImportDetails);
        
        int importId = Integer.parseInt(txtImportId_Detail.getText());
        int importQtyImport = Integer.parseInt(txtImportQtyImportDetails.getText());
        int unitPrice = Integer.parseInt(txtUnitPriceImportDetails.getText());
        double amount = importQtyImport * unitPrice;
        
        ImportDetails importDetails = new ImportDetails();
        importDetails.create(importQtyImport, unitPrice, amount, importId , ceID);
        
        importDetails.clearImportDetail(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);

        for (String ceList : ce.getAllCE()) {
            cbCEImportDetails.addItem(ceList);
        }
        
        importDetails.getImportDetailsByImportId(importId, tbImport_form_detail);
        
    }//GEN-LAST:event_btnImportDetailsNewActionPerformed

    private void tbImport_form_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImport_form_detailMouseClicked
        ImportDetails imd = new ImportDetails();
        imd.getSelectTableImportDetial(cbCEImportDetails, txtUnitPriceImportDetails, txtImportId_Detail, txtAmountImportDetails, txtImportQtyImportDetails, tbImport_form_detail);
    }//GEN-LAST:event_tbImport_form_detailMouseClicked

    private void btnImportNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportNewActionPerformed
        // TODO add your handling code here:
        int staffId = 0;
        int supplierId = 0;
        Import importObj = new Import();
        Supplier supplier = new Supplier();
        Staff st = new Staff();

        java.sql.Date importDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        staffId = st.getStaffIdByName(cbStaffNameImport);
        supplierId = supplier.getSupplierIdByName(cbSupplierNameImport);
        importObj.createImport(importDate, staffId, supplierId);
        importObj.getImport(tbImport_form);
        importObj.clear(txtImportDate, cbStaffNameImport, cbSupplierNameImport);

        Staff staff = new Staff();
        for (String staffList : staff.getAllStaff()) {
            cbStaffNameImport.addItem(staffList);
        }

        for (String supplierList : supplier.getAllSupplier()) {
            cbSupplierNameImport.addItem(supplierList);
        }

    }//GEN-LAST:event_btnImportNewActionPerformed

    private void btnImportUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportUpdateActionPerformed
        // TODO add your handling code here:
        
        int staffId = 0;
        int supplierId = 0;
        Import importObj = new Import();
        Supplier supplier = new Supplier();
        Staff st = new Staff();

        staffId = st.getStaffIdByName(cbStaffNameImport);
        supplierId = supplier.getSupplierIdByName(cbSupplierNameImport);
 
        importObj.update(staffId, supplierId, lbMessageCustomer, tbImport_form);
        importObj.getImport(tbImport_form);
        
    }//GEN-LAST:event_btnImportUpdateActionPerformed

    private void btnSupplierUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierUpdateActionPerformed
        Supplier su = new Supplier();
        
        if (male1.equals("Male")){
            gender = "male";
        }
        else{
            gender = "female";
        }
        su.updateSupplier(txtSupplierId, txtSupplierName, gender,txtSupplierPhone, txtSupplierAddress,lbMessageSupplier, tbSupplier_form);
        
        su.clearSupplier(txtSupplierId,txtSupplierName, gender, txtSupplierPhone, txtSupplierAddress);
    }//GEN-LAST:event_btnSupplierUpdateActionPerformed

    private void txtstaffIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtstaffIDMousePressed
        labelstaffidrequired.setText("");
    }//GEN-LAST:event_txtstaffIDMousePressed

    private void txtStaffNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffNameMousePressed
       labelstaffNamerequired.setText("");
       labelmessagestaff.setText("");
    }//GEN-LAST:event_txtStaffNameMousePressed

    private void cboStaffGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStaffGenderActionPerformed
        labelstaffgenderrequired.setText("");
    }//GEN-LAST:event_cboStaffGenderActionPerformed

    private void txtStaffNationlityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffNationlityMousePressed
        labelstaffnatrequired.setText("");
    }//GEN-LAST:event_txtStaffNationlityMousePressed

    private void txtStaffAddressMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffAddressMousePressed
        labelstaffaddrerequired.setText("");
    }//GEN-LAST:event_txtStaffAddressMousePressed

    private void txtStaffBirthdayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffBirthdayMousePressed
        labelstaffbirthrequired.setText("");
    }//GEN-LAST:event_txtStaffBirthdayMousePressed

    private void txtStaffHiredDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffHiredDateMousePressed
        labelstaffhirdrequired.setText("");
    }//GEN-LAST:event_txtStaffHiredDateMousePressed

    private void txtStaffSalaryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffSalaryMousePressed
        labelstaffsarequired.setText("");
    }//GEN-LAST:event_txtStaffSalaryMousePressed

    private void txtStaffPhoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffPhoneMousePressed
        labelstaffphonerequired.setText("");
    }//GEN-LAST:event_txtStaffPhoneMousePressed

    private void cboStaffroleIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboStaffroleIDMousePressed
        labelstaffroleidrequired.setText("");
    }//GEN-LAST:event_cboStaffroleIDMousePressed

    private void cboStaffStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboStaffStatusMousePressed
        labelstaffstaturequired.setText("");
    }//GEN-LAST:event_cboStaffStatusMousePressed

    private void txtworkerNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerNameMousePressed
        labelworkerNamerequired.setText("");
    }//GEN-LAST:event_txtworkerNameMousePressed

    private void cboworkercreatebystaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboworkercreatebystaffMousePressed
        labelworkercreatebystaff.setText("");
    }//GEN-LAST:event_cboworkercreatebystaffMousePressed

    private void cboworkerGenderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboworkerGenderMousePressed
        labelworkergenderrequired.setText("");
    }//GEN-LAST:event_cboworkerGenderMousePressed

    private void txtworkerAddressMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerAddressMousePressed
        labelworkeraddrerequired.setText("");
    }//GEN-LAST:event_txtworkerAddressMousePressed

    private void txtworkerBirthdayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerBirthdayMousePressed
        labelworkerbirthrequired.setText("");
    }//GEN-LAST:event_txtworkerBirthdayMousePressed

    private void txtworkerHiredDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerHiredDateMousePressed
        labelworkerhirdrequired.setText("");
    }//GEN-LAST:event_txtworkerHiredDateMousePressed

    private void labelworkersaryequiredMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelworkersaryequiredMousePressed
        labelworkerhirdrequired.setText("");
    }//GEN-LAST:event_labelworkersaryequiredMousePressed

    private void txtworkerPhoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerPhoneMousePressed
        labelworkerphonerequired.setText("");
    }//GEN-LAST:event_txtworkerPhoneMousePressed

    private void cboworkerroleIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboworkerroleIDMousePressed
        labelworkerroleidrequired.setText("");
    }//GEN-LAST:event_cboworkerroleIDMousePressed

    private void cboworkerStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboworkerStatusMousePressed
        labelworkerstaturequired.setText("");
    }//GEN-LAST:event_cboworkerStatusMousePressed

    private void txtworkerSalaryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtworkerSalaryMousePressed
        labelworkersaryequired.setText("");
    }//GEN-LAST:event_txtworkerSalaryMousePressed

    private void txtPaymentTotalAmountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaymentTotalAmountMousePressed
        labelpaymentTotalrequired.setText("");
    }//GEN-LAST:event_txtPaymentTotalAmountMousePressed

    private void txtPaymentPaidAmountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaymentPaidAmountMousePressed
        labelpaymentPaidrequired.setText("");
    }//GEN-LAST:event_txtPaymentPaidAmountMousePressed

    private void txtPaymentOwesAmountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaymentOwesAmountMousePressed
        labelpaymentOwesrequired.setText("");
    }//GEN-LAST:event_txtPaymentOwesAmountMousePressed

    private void txtPaymentDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaymentDateMouseClicked
        labelpaymentPaymentrequired.setText("");
    }//GEN-LAST:event_txtPaymentDateMouseClicked

    private void cboInvoicePaymentIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboInvoicePaymentIDMousePressed
        labelInvoicePaymentIDrequired.setText("");
    }//GEN-LAST:event_cboInvoicePaymentIDMousePressed

    private void cboInvoicestaffrNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboInvoicestaffrNameMousePressed
        labelInvoicestaffrequired.setText("");
    }//GEN-LAST:event_cboInvoicestaffrNameMousePressed

    private void txtProjectPlanLocationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanLocationMousePressed
        labelProjectPlanLocation.setText("");
    }//GEN-LAST:event_txtProjectPlanLocationMousePressed

    private void txtProjectPlanNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanNameMousePressed
        labelProjectPlanName.setText("");
    }//GEN-LAST:event_txtProjectPlanNameMousePressed

    private void txtProjectPlanTimeLineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanTimeLineMousePressed
       labelProjectPlanTimeLine.setText("");
    }//GEN-LAST:event_txtProjectPlanTimeLineMousePressed

    private void cboProjectPlanInfoNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanInfoNameMousePressed
        labelProjectPlanInfoName.setText("");
    }//GEN-LAST:event_cboProjectPlanInfoNameMousePressed

    private void cboProjectPlanStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanStatusMousePressed
        labelProjectPlanStatus.setText("");
    }//GEN-LAST:event_cboProjectPlanStatusMousePressed

    private void txtProjectPlanListNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanListNameMousePressed
        labelPPLName.setText("");
    }//GEN-LAST:event_txtProjectPlanListNameMousePressed

    private void cboProjectPlanListStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanListStatusMousePressed
        labelPPLStatus.setText("");
    }//GEN-LAST:event_cboProjectPlanListStatusMousePressed

    private void cboProjectPlanList_ProjectPlanNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanList_ProjectPlanNameMousePressed
        labelPPL_PPName.setText("");
    }//GEN-LAST:event_cboProjectPlanList_ProjectPlanNameMousePressed

    private void txtProjectPlanListStartDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanListStartDateMousePressed
        labelPPLStartDate.setText("");
    }//GEN-LAST:event_txtProjectPlanListStartDateMousePressed

    private void cboProjectPlanListStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanListStaffMousePressed
        labelPPLStaff.setText("");
    }//GEN-LAST:event_cboProjectPlanListStaffMousePressed

    private void txtProjectPlanListFinishDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanListFinishDateMousePressed
        labelPPLFinishDate.setText("");
    }//GEN-LAST:event_txtProjectPlanListFinishDateMousePressed

    private void cboProjectPlanDetail_ListNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProjectPlanDetail_ListNameMousePressed
        labelPPLDProjectplanListName.setText("");
    }//GEN-LAST:event_cboProjectPlanDetail_ListNameMousePressed

    private void txtProjectPlanDetailNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanDetailNameMousePressed
        labelPPLDDetailname.setText("");
    }//GEN-LAST:event_txtProjectPlanDetailNameMousePressed

    private void txtProjectPlanDetailDatelineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProjectPlanDetailDatelineMousePressed
        labelPPLDDateline.setText("");
    }//GEN-LAST:event_txtProjectPlanDetailDatelineMousePressed

    private void txtTotalQtyUsaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalQtyUsaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalQtyUsaeActionPerformed

    private void btnNewUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUsageActionPerformed
        // TODO add your handling code here:
        int ceID = 0;
        int staffId = 0;
        ConstractionEquiment ce = new ConstractionEquiment();
        ceID = ce.getCEByName(cbStaffUsage);

        Staff staff = new Staff();
        staff.getStaffIdByName(cbStaffUsage);

        java.sql.Date usageDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        int totalQty =  Integer.parseInt(txtTotalQtyUsae.getText());

        Usage usage = new Usage();
        usage.create(usageDate, totalQty, staffId, ceID);

        usage.getUsage(tbUsage_form);
    }//GEN-LAST:event_btnNewUsageActionPerformed

    private void btnNewUsage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUsage1ActionPerformed
        // TODO add your handling code here:
        
        int ceID = 0;
        int staffId = 0;
        
        ConstractionEquiment ce = new ConstractionEquiment();
        ceID = ce.getCEByName(cbCEUsage);
        
        Staff staff = new Staff();
        staffId = staff.getStaffIdByName(cbStaffUsage);
        
        java.sql.Date usageDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        int totalQty =  Integer.parseInt(txtTotalQtyUsae.getText());
        
        Usage usage = new Usage();
        usage.create(usageDate, totalQty, staffId, ceID);
        usage.getUsage(tbUsage_form);
        usage.ClearUsage(cbStaffUsage, cbCEUsage, txtTotalQtyUsae);        
    }//GEN-LAST:event_btnNewUsage1ActionPerformed

    private void btnUpdateUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUsageActionPerformed
        // TODO add your handling code here:
        int ceID = 0;
        int staffId = 0;
        
        ConstractionEquiment ce = new ConstractionEquiment();
        ceID = ce.getCEByName(cbCEUsage);
        
        Staff staff = new Staff();
        staffId = staff.getStaffIdByName(cbStaffUsage);
        
        java.sql.Date usageDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        int totalQty =  Integer.parseInt(txtTotalQtyUsae.getText());
        
        Usage usage = new Usage();
        usage.upadte(usageDate, totalQty, staffId, ceID, tbUsage_form);
        usage.getUsage(tbUsage_form);
        usage.ClearUsage(cbStaffUsage, cbCEUsage, txtTotalQtyUsae);   
        
    }//GEN-LAST:event_btnUpdateUsageActionPerformed

    private void tbProjectInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjectInformationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbProjectInformationMouseClicked

    private void btnworkerNew2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnworkerNew2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnworkerNew2MouseClicked

    private void panelmenuuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuuserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenuuserMouseClicked

    private void panelmenuuserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelmenuuserMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelmenuuserMousePressed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JLabel bracCEForm;
    private javax.swing.JLabel bracCustomerForm;
    private javax.swing.JLabel bracImportForm;
    private javax.swing.JLabel bracSupplierForm;
    private javax.swing.JLabel bracUsageForm;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnCECancel;
    private javax.swing.JButton btnCENew;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnCustomerNew;
    private javax.swing.JButton btnECUpdate;
    private javax.swing.JButton btnEdittablestaff;
    private javax.swing.JButton btnEdittablestaff1;
    private javax.swing.JButton btnEdittablestaff2;
    private javax.swing.JButton btnEdittablestaff3;
    private javax.swing.JButton btnEdittablestaff4;
    private javax.swing.JButton btnEdittablestaff5;
    private javax.swing.JButton btnEdittableworker;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnImportDetailsNew;
    private javax.swing.JButton btnImportDetialUpdate;
    private javax.swing.JButton btnImportNew;
    private javax.swing.JButton btnImportUpdate;
    private javax.swing.JButton btnInvoiceCancel;
    private javax.swing.JButton btnInvoiceCancel3;
    private javax.swing.JButton btnInvoiceNew;
    private javax.swing.JButton btnInvoiceNew3;
    private javax.swing.JButton btnInvoiceUpdate;
    private javax.swing.JButton btnInvoiceUpdate3;
    private javax.swing.JButton btnNewUsage;
    private javax.swing.JButton btnNewUsage1;
    private javax.swing.JButton btnPaymentNew;
    private javax.swing.JButton btnPaymentUpdate;
    private javax.swing.JButton btnPaymentclear;
    private javax.swing.JButton btnProjectPlan;
    private javax.swing.JButton btnProjectPlanClear;
    private javax.swing.JButton btnProjectPlanDetailClear;
    private javax.swing.JButton btnProjectPlanDetailUpdate;
    private javax.swing.JButton btnProjectPlanListClear;
    private javax.swing.JButton btnProjectPlanListDetailNew;
    private javax.swing.JButton btnProjectPlanListNew;
    private javax.swing.JButton btnProjectPlanListUpdate;
    private javax.swing.JButton btnProjectPlanUpdate;
    private javax.swing.JButton btnProplanlistAddPlanDetail;
    private javax.swing.JButton btnProplanlistAddnew;
    private javax.swing.JButton btnProplanlistEdit;
    private javax.swing.JButton btnStaffCancel;
    private javax.swing.JButton btnStaffChoosepicture;
    private javax.swing.JButton btnStaffNew;
    private javax.swing.JButton btnStaffUpdate;
    private javax.swing.JButton btnSupplierClear;
    private javax.swing.JButton btnSupplierCreate;
    private javax.swing.JButton btnSupplierNew;
    private javax.swing.JButton btnSupplierUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JButton btnUpdateUsage;
    private javax.swing.JButton btnUsage;
    private javax.swing.JButton btnWorkerChoosepicture;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnopenmenustaffaddnew;
    private javax.swing.JButton btnopenmenuworker;
    private javax.swing.JButton btnsignin;
    private javax.swing.JButton btnworkerCancel;
    private javax.swing.JButton btnworkerCancel1;
    private javax.swing.JButton btnworkerCancel4;
    private javax.swing.JButton btnworkerCancel6;
    private javax.swing.JButton btnworkerNew;
    private javax.swing.JButton btnworkerNew2;
    private javax.swing.JButton btnworkerUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCEImportDetails;
    private javax.swing.JComboBox<String> cbCEUsage;
    private javax.swing.JComboBox<String> cbStaffNameImport;
    private javax.swing.JComboBox<String> cbStaffUsage;
    private javax.swing.JComboBox<String> cbSupplierNameImport;
    private javax.swing.JComboBox<String> cboCustomer_CreatebyStaff;
    private javax.swing.JComboBox<String> cboInvoicePaymentID;
    private javax.swing.JComboBox<String> cboInvoicestaffrName;
    private javax.swing.JComboBox<String> cboPaymentCreatebystaff;
    private javax.swing.JComboBox<String> cboPaymentCutomerName;
    private javax.swing.JComboBox<String> cboPaymentCutomerName9;
    private javax.swing.JComboBox<String> cboProjectPlanDetail_ListName;
    private javax.swing.JComboBox<String> cboProjectPlanInfoName;
    private javax.swing.JComboBox<String> cboProjectPlanListSelectProjectPlan;
    private javax.swing.JComboBox<String> cboProjectPlanListStaff;
    private javax.swing.JComboBox<String> cboProjectPlanListStatus;
    private javax.swing.JComboBox<String> cboProjectPlanList_ProjectPlanName;
    private javax.swing.JComboBox<String> cboProjectPlanStatus;
    private javax.swing.JComboBox cboProplanlistsearch;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JComboBox<String> cboStaffGender;
    private javax.swing.JComboBox<String> cboStaffStatus;
    private javax.swing.JComboBox<String> cboStaffroleID;
    private javax.swing.JComboBox cboViewProjectPlanName;
    private javax.swing.JComboBox<String> cboposition;
    private javax.swing.JComboBox<String> cbostaffName;
    private javax.swing.JComboBox<String> cboworkerGender;
    private javax.swing.JComboBox<String> cboworkerStatus;
    private javax.swing.JComboBox<String> cboworkercreatebystaff;
    private javax.swing.JComboBox<String> cboworkerroleID;
    private javax.swing.JInternalFrame ce_form;
    private javax.swing.JInternalFrame ce_list;
    private javax.swing.JLabel conpassworderror;
    private javax.swing.JInternalFrame customer_form;
    private javax.swing.JInternalFrame customer_list;
    private javax.swing.JRadioButton female;
    private javax.swing.JRadioButton female1;
    private javax.swing.JLabel homemenulable;
    private javax.swing.JInternalFrame import_form;
    private javax.swing.JInternalFrame import_list;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollImport;
    private javax.swing.JScrollPane jScrollImport1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelInvoiceDatterequired;
    private javax.swing.JLabel labelInvoicePaymentIDrequired;
    private javax.swing.JLabel labelInvoiceResult;
    private javax.swing.JLabel labelInvoicestaffrequired;
    private javax.swing.JLabel labelPPLDDateline;
    private javax.swing.JLabel labelPPLDDetailname;
    private javax.swing.JLabel labelPPLDProjectplanListName;
    private javax.swing.JLabel labelPPLDResult;
    private javax.swing.JLabel labelPPLFinishDate;
    private javax.swing.JLabel labelPPLName;
    private javax.swing.JLabel labelPPLResult;
    private javax.swing.JLabel labelPPLStaff;
    private javax.swing.JLabel labelPPLStartDate;
    private javax.swing.JLabel labelPPLStatus;
    private javax.swing.JLabel labelPPL_PPName;
    private javax.swing.JLabel labelProjectPlanInfoName;
    private javax.swing.JLabel labelProjectPlanLocation;
    private javax.swing.JLabel labelProjectPlanName;
    private javax.swing.JLabel labelProjectPlanResult;
    private javax.swing.JLabel labelProjectPlanStatus;
    private javax.swing.JLabel labelProjectPlanTimeLine;
    private javax.swing.JLabel labelclient;
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
    private javax.swing.JLabel labelmessageworker8;
    private javax.swing.JLabel labelpaymentCustomerrequired;
    private javax.swing.JLabel labelpaymentNamerequired4;
    private javax.swing.JLabel labelpaymentOwesrequired;
    private javax.swing.JLabel labelpaymentPaidrequired;
    private javax.swing.JLabel labelpaymentPaymentrequired;
    private javax.swing.JLabel labelpaymentTotalrequired;
    private javax.swing.JLabel labelpaymentcreatebystaff4;
    private javax.swing.JLabel labelpaymentgenderrequired10;
    private javax.swing.JLabel labelpaymentgenderrequired11;
    private javax.swing.JLabel labelpaymentgenderrequired12;
    private javax.swing.JLabel labelpaymentgenderrequired13;
    private javax.swing.JLabel labelpaymentgenderrequired14;
    private javax.swing.JLabel labelpaymentgenderrequired8;
    private javax.swing.JLabel labelpaymentresult;
    private javax.swing.JLabel labelpaymentstaffrequire;
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
    private javax.swing.JLabel labeltotalinvoice;
    private javax.swing.JLabel labeltotalpayment;
    private javax.swing.JLabel labeltotalprojectplan;
    private javax.swing.JLabel labeltotalstaff;
    private javax.swing.JLabel labeltotalworker;
    private javax.swing.JLabel labelworkerNamerequired;
    private javax.swing.JLabel labelworkeraddrerequired;
    private javax.swing.JLabel labelworkeraddrerequired3;
    private javax.swing.JLabel labelworkerbirthrequired;
    private javax.swing.JLabel labelworkerbirthrequired3;
    private javax.swing.JLabel labelworkercreatebystaff;
    private javax.swing.JLabel labelworkercreatebystaff3;
    private javax.swing.JLabel labelworkergenderrequired;
    private javax.swing.JLabel labelworkergenderrequired3;
    private javax.swing.JLabel labelworkerhirdrequired;
    private javax.swing.JLabel labelworkerphonerequired;
    private javax.swing.JLabel labelworkerphonerequired3;
    private javax.swing.JLabel labelworkerroleidrequired;
    private javax.swing.JLabel labelworkerroleidrequired1;
    private javax.swing.JLabel labelworkerroleidrequired3;
    private javax.swing.JLabel labelworkerroleidrequired4;
    private javax.swing.JLabel labelworkerroleidrequired5;
    private javax.swing.JLabel labelworkerroleidrequired8;
    private javax.swing.JLabel labelworkersaryequired;
    private javax.swing.JLabel labelworkersaryequired3;
    private javax.swing.JLabel labelworkerstaturequired;
    private javax.swing.JLabel labelworkerstaturequired3;
    private javax.swing.JLabel lablegidelineprojectplanlist;
    private javax.swing.JLabel lableshownamelogin;
    private javax.swing.JLabel lablewelcome;
    private javax.swing.JLabel lbBracCEList;
    private javax.swing.JLabel lbBracCustomerList;
    private javax.swing.JLabel lbBracImportList;
    private javax.swing.JLabel lbBracSupplierList;
    private javax.swing.JLabel lbBracUsageList;
    private javax.swing.JLabel lbMessageCustomer;
    private javax.swing.JLabel lbMessageSupplier;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton male1;
    private javax.swing.JPanel menuCE;
    private javax.swing.JPanel menuCustomer;
    private javax.swing.JPanel menuSupplier;
    private javax.swing.JPanel menuUsage;
    private javax.swing.JInternalFrame menuhome;
    private javax.swing.JInternalFrame menuinvoice;
    private javax.swing.JInternalFrame menupayment;
    private javax.swing.JInternalFrame menuprojectplan;
    private javax.swing.JInternalFrame menuprojectplanList;
    private javax.swing.JInternalFrame menustaff;
    private javax.swing.JInternalFrame menutableprojectview;
    private javax.swing.JInternalFrame menutableprojectview1;
    private javax.swing.JInternalFrame menutablestaff;
    private javax.swing.JInternalFrame menutableworker;
    private javax.swing.JInternalFrame menuuser;
    private javax.swing.JInternalFrame menuworker;
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelCustomer1;
    private javax.swing.JPanel panelCustomer2;
    private javax.swing.JPanel panelCustomer3;
    private javax.swing.JPanel panelCustomer4;
    private javax.swing.JPanel panelbar;
    private javax.swing.JPanel panelclicked1;
    private javax.swing.JPanel panelclicked10;
    private javax.swing.JPanel panelclicked11;
    private javax.swing.JPanel panelclicked12;
    private javax.swing.JPanel panelclicked13;
    private javax.swing.JPanel panelclicked15;
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
    private javax.swing.JPanel panelmenImport;
    private javax.swing.JPanel panelmenpayment;
    private javax.swing.JPanel panelmenprojectplan;
    private javax.swing.JPanel panelmenprojectplanlist;
    private javax.swing.JPanel panelmenprojectplanview;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JPanel panelmenuhome;
    private javax.swing.JPanel panelmenuinvoice;
    private javax.swing.JPanel panelmenustaff;
    private javax.swing.JPanel panelmenuuser;
    private javax.swing.JPanel panelmenworker;
    private javax.swing.JPanel panelproject;
    private javax.swing.JPanel panelstaff;
    private javax.swing.JPanel panelstaffinfomation;
    private javax.swing.JPanel panelstaffinfomation1;
    private javax.swing.JPanel panelstaffinfomation10;
    private javax.swing.JPanel panelstaffinfomation11;
    private javax.swing.JPanel panelstaffinfomation12;
    private javax.swing.JPanel panelstaffinfomation2;
    private javax.swing.JPanel panelstaffinfomation3;
    private javax.swing.JPanel panelstaffinfomation4;
    private javax.swing.JPanel panelstaffinfomation5;
    private javax.swing.JPanel panelstaffinfomation6;
    private javax.swing.JPanel panelstaffinfomation7;
    private javax.swing.JPanel panelstaffinfomation8;
    private javax.swing.JPanel panelstaffinfomation9;
    private javax.swing.JPanel panelstaffmenu;
    private javax.swing.JPanel panelstaffmenu1;
    private javax.swing.JPanel panelstaffmenu10;
    private javax.swing.JPanel panelstaffmenu2;
    private javax.swing.JPanel panelstaffmenu3;
    private javax.swing.JPanel panelstaffmenu4;
    private javax.swing.JPanel panelstaffmenu5;
    private javax.swing.JPanel panelstaffmenu6;
    private javax.swing.JPanel panelstaffmenu7;
    private javax.swing.JPanel panelstaffmenu8;
    private javax.swing.JPanel panelstaffmenu9;
    private javax.swing.JPanel panelsuppliers;
    private javax.swing.JPanel paneltableprojectplanlist;
    private javax.swing.JPanel paneltablestaff;
    private javax.swing.JPanel paneltablestaff1;
    private javax.swing.JLabel passworderror;
    private javax.swing.JLabel positionerror;
    private javax.swing.JLabel showlableonclickedmenu;
    private javax.swing.JLabel staffmenulable;
    private javax.swing.JLabel staffmenulable1;
    private javax.swing.JLabel staffmenulable10;
    private javax.swing.JLabel staffmenulable11;
    private javax.swing.JLabel staffmenulable12;
    private javax.swing.JLabel staffmenulable14;
    private javax.swing.JLabel staffmenulable2;
    private javax.swing.JLabel staffmenulable3;
    private javax.swing.JLabel staffmenulable5;
    private javax.swing.JLabel staffmenulable6;
    private javax.swing.JLabel staffmenulable7;
    private javax.swing.JLabel staffmenulable8;
    private javax.swing.JLabel staffmenulable9;
    private javax.swing.JLabel staffnamerror;
    private javax.swing.JLabel sucessfulllable;
    private javax.swing.JInternalFrame supplier_form;
    private javax.swing.JInternalFrame supplier_list;
    private javax.swing.JTable tbCE;
    private javax.swing.JTable tbCE_form;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTable tbCustomer_form;
    private javax.swing.JTable tbImport;
    private javax.swing.JTable tbImport_form;
    private javax.swing.JTable tbImport_form_detail;
    private javax.swing.JTable tbInvoice;
    private javax.swing.JTable tbInvoice3;
    private javax.swing.JTable tbPayment;
    private javax.swing.JTable tbProjectInformation;
    private javax.swing.JTable tbProjectPlan;
    private javax.swing.JTable tbProjectPlanList;
    private javax.swing.JTable tbProjectPlanListDetail;
    private javax.swing.JTable tbProjectplanlistview;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTable tbSupplier_form;
    private javax.swing.JTable tbUsage;
    private javax.swing.JTable tbUsage_form;
    private javax.swing.JTable tbViewProjectPlanList;
    private javax.swing.JTable tbViewProjectPlanListDetail;
    private javax.swing.JTable tbstaffview;
    private javax.swing.JTable tbviewuser;
    private javax.swing.JTable tbworker;
    private javax.swing.JTable tbworkerview;
    private javax.swing.JTextField txtAmountImportDetails;
    private javax.swing.JTextField txtCEName;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDateUse;
    private javax.swing.JTextField txtImportDate;
    private javax.swing.JTextField txtImportId_Detail;
    private javax.swing.JTextField txtImportQtyImportDetails;
    private javax.swing.JTextField txtInvoiceCustomer;
    private com.toedter.calendar.JDateChooser txtInvoiceDate;
    private javax.swing.JTextField txtInvoiceId;
    private javax.swing.JTextField txtInvoiceOwesAmount;
    private javax.swing.JTextField txtInvoicePaidAmount;
    private javax.swing.JTextField txtInvoiceTotalAmount;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff4;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff5;
    private javax.swing.JComboBox<String> txtPaymentCreatebystaff6;
    private com.toedter.calendar.JDateChooser txtPaymentDate;
    private com.toedter.calendar.JDateChooser txtPaymentDate4;
    private com.toedter.calendar.JDateChooser txtPaymentDate5;
    private javax.swing.JTextField txtPaymentID;
    private javax.swing.JTextField txtPaymentID10;
    private javax.swing.JTextField txtPaymentID11;
    private javax.swing.JTextField txtPaymentID7;
    private javax.swing.JTextField txtPaymentOwesAmount;
    private javax.swing.JTextField txtPaymentPaidAmount;
    private javax.swing.JTextField txtPaymentTotalAmount;
    private javax.swing.JTextField txtPhone;
    private com.toedter.calendar.JDateChooser txtProjectPlanDetailDateline;
    private javax.swing.JTextField txtProjectPlanDetailID;
    private javax.swing.JTextField txtProjectPlanDetailName;
    private javax.swing.JTextField txtProjectPlanID;
    private com.toedter.calendar.JDateChooser txtProjectPlanListFinishDate;
    private javax.swing.JTextField txtProjectPlanListID;
    private javax.swing.JTextField txtProjectPlanListName;
    private com.toedter.calendar.JDateChooser txtProjectPlanListStartDate;
    private javax.swing.JTextArea txtProjectPlanLocation;
    private javax.swing.JTextField txtProjectPlanName;
    private com.toedter.calendar.JDateChooser txtProjectPlanTimeLine;
    private javax.swing.JTextField txtStaffAddress;
    private com.toedter.calendar.JDateChooser txtStaffBirthday;
    private com.toedter.calendar.JDateChooser txtStaffHiredDate;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtStaffNationlity;
    private javax.swing.JTextField txtStaffPhone;
    private javax.swing.JTextField txtStaffSalary;
    private javax.swing.JTextField txtStockQty;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierId;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierPhone;
    private javax.swing.JTextField txtTotalQtyUsae;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtUnitPriceImportDetails;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtconfirmpassword;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtstaffID;
    private javax.swing.JTextField txtuserID;
    private javax.swing.JTextField txtworkerAddress;
    private com.toedter.calendar.JDateChooser txtworkerBirthday;
    private com.toedter.calendar.JDateChooser txtworkerHiredDate;
    private javax.swing.JTextField txtworkerID;
    private javax.swing.JTextField txtworkerName;
    private javax.swing.JTextField txtworkerPhone;
    private javax.swing.JTextField txtworkerSalary;
    private javax.swing.JInternalFrame usage_form;
    private javax.swing.JInternalFrame usage_list;
    private javax.swing.JLabel usernameerror;
    // End of variables declaration//GEN-END:variables

    private String gender;
}
