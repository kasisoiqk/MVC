/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.util;

import New.controller.CategoryDao;
import New.model.Category;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class bai9 extends JFrame{

    public bai9(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        addCompenent();
        getDanhMucSp();
        getCombox();
        addActionLister();
    }
   
 DefaultListModel<Category> listModelDmsp;
 JList listDmsp;
 CategoryDao cateDao;
 JComboBox<Category> cboCategory;
 public JButton btnNew ;
    private void addCompenent() {
        JMenuBar menu=new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        menu.add(fileMenu);
        this.setJMenuBar(menu);
        //Vung NOrth
        JPanel pnlTieude=new JPanel();
        JLabel lblTieude=new JLabel("Quản lý sản phẩm");
        lblTieude.setFont(new Font("Time New Woman",Font.BOLD,20));
        lblTieude.setForeground(Color.blue);
        pnlTieude.add(lblTieude);
        this.add(pnlTieude,BorderLayout.NORTH);
        
        //Vùng west
        JPanel pnlWest=new JPanel();
        JPanel pnlBorderWest=new JPanel(new BorderLayout());
        
        JPanel pnlList=new JPanel();
         listModelDmsp=new DefaultListModel<>();
         listDmsp=new JList(listModelDmsp);
         
         
        listDmsp.setPreferredSize(new Dimension(300,400));
        Border borderList=BorderFactory.createLineBorder(Color.red);
        TitledBorder titleBorderList=new TitledBorder(borderList, "Danh mục sản phẩm");
        listDmsp.setBorder(titleBorderList);
        pnlList.add(listDmsp);
        pnlBorderWest.add(pnlList,BorderLayout.CENTER);
       
        JPanel pnlButton=new JPanel();
        btnNew =new JButton("New");
        JButton btnUpdate =new JButton("Update");
        JButton btnRemove =new JButton("Remove");
        pnlButton.add(btnNew);
        pnlButton.add(btnUpdate);
        pnlButton.add(btnRemove);
        pnlBorderWest.add(pnlButton,BorderLayout.SOUTH);
        pnlWest.add(pnlBorderWest,BorderLayout.CENTER);
        this.add(pnlWest,BorderLayout.WEST);
        
        //vùng Center
        JPanel pnlCenter=new JPanel();
        pnlCenter.setLayout(new BoxLayout(pnlCenter,BoxLayout.Y_AXIS));
        
        //vùng bảng
        JPanel pnlCenterTable=new JPanel();
        
        JPanel pnlTitle=new JPanel();
        JLabel lblTitle=new JLabel("Thông tin chi tiết");
        lblTitle.setFont(new Font("Time New Woman",Font.BOLD,18));
        pnlTitle.add(lblTitle);
        pnlCenterTable.add(pnlTitle,BorderLayout.NORTH);
        
        
       
        String columnNames[]={"ProductID","ProductName","UnitPrice","Quantity","Description"};
        Object[][] rowData={{"p1","đèn huỳnh quang","888.0","1","đèn huỳnh quang"}};
        JTable tableSp=new JTable(rowData, columnNames);

        
        pnlCenterTable.add(new JScrollPane(tableSp),BorderLayout.CENTER);
        
        pnlCenter.add(pnlCenterTable);
        
        //vung nhap
        JPanel pnlFromInput =new JPanel(); 
        pnlFromInput.setLayout(new BoxLayout(pnlFromInput, BoxLayout.X_AXIS));
       
        JPanel pnlLabel =new JPanel(); 
        pnlLabel.setLayout(new BoxLayout(pnlLabel, BoxLayout.Y_AXIS));
        JLabel lblCategory=new JLabel("Category:");
        JLabel lblProductID=new JLabel("Product ID:");
        JLabel lblProductName=new JLabel("ProductName:");
        JLabel lblUnit=new JLabel("Unit Price:");
        JLabel lblQuantity=new JLabel("Quantity:");
        JLabel lblDescriptipn=new JLabel("Description:");
        //pnlLabel.add(Box.createVerticalStrut(10));
        pnlLabel.add(lblCategory);
        pnlLabel.add(Box.createVerticalStrut(10));
        pnlLabel.add(lblProductID);
        pnlLabel.add(Box.createVerticalStrut(15));
        pnlLabel.add(lblProductName);
        pnlLabel.add(Box.createVerticalStrut(20));
        pnlLabel.add(lblUnit);
        pnlLabel.add(Box.createVerticalStrut(10));
        pnlLabel.add(lblQuantity);
        pnlLabel.add(Box.createVerticalStrut(10));
        pnlLabel.add(lblDescriptipn);
        
        JPanel pnlText =new JPanel();
        pnlText.setLayout(new BoxLayout(pnlText, BoxLayout.Y_AXIS));
        cboCategory=new JComboBox<>();
//        cboCategory.addItem("Mặt hàng hóa chất");
//        cboCategory.addItem("Mặt hàng điện");
//        cboCategory.addItem("Mặt hàng nước");
        JTextField txtProductID=new JTextField(20);
        JTextField txtProductName=new JTextField(20);
        JTextField txtUnit=new JTextField(20);
        JTextField txtQuantity=new JTextField(20);
        JTextArea txtDescription=new JTextArea(3, 20);
        
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(cboCategory);
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(txtProductID);
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(txtProductName);
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(txtUnit);
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(txtQuantity);
        pnlText.add(Box.createVerticalStrut(10));
        pnlText.add(txtDescription);
        pnlFromInput.add(pnlLabel);
        pnlFromInput.add(pnlText);
        pnlCenter.add(pnlFromInput);
        
        JPanel pnlCenterButton=new JPanel();
        JButton btnCenterNew=new JButton("New");
        JButton btnCenterSave=new JButton("Save");
        JButton btnCenterRemove=new JButton("Remove");
        pnlCenterButton.add(btnCenterNew);
        pnlCenterButton.add(btnCenterSave);
        pnlCenterButton.add(btnCenterRemove);
        pnlCenter.add(pnlCenterButton);
        this.add(pnlCenter,BorderLayout.CENTER);
        
        
    }
    
    public void getDanhMucSp(){
    
         cateDao=new CategoryDao();
      List<Category> list=cateDao.getAll();
      listModelDmsp.clear();
        for (Category category : list) {
            listModelDmsp.addElement(category);
        }
        listDmsp.setModel(listModelDmsp);
    }
    public void getCombox(){
      cateDao=new CategoryDao();
      List<Category> list=cateDao.getAll();
      for (Category category : list) {
            cboCategory.addItem(category);
        }
       
    }
    private void addActionLister(){
       btnNew.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               new NewCategory().setVisible(true);
               new bai9("Quản lý sản phẩm").dispose();
           }
       });
    }
    public static void main(String[] args) {
        new bai9("Quản lý sản phẩm!").setVisible(true);
    }
    
}
