package com.sergiopz.xpathquerytool.gui;

import com.sergiopz.xpathquerytool.XPathQueryTool;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class MainWindow extends JFrame {
  private XPathQueryTool xqt = null;
  
  private JButton chooseFile_btn;
  
  private JLabel chooseFile_lbl;
  
  private JButton clear_btn;
  
  private JButton copyAll_btn;
  
  private JCheckBox distinct_chkBox;
  
  private JFileChooser fileChooser_Window;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JScrollPane jScrollPane1;
  
  private JScrollPane jScrollPane2;
  
  private JTextArea message_txtArea;
  
  private JTextField queryTextField;
  
  private JButton query_btn;
  
  private JTextArea result_txtArea;
  
  private JComboBox<String> returnType_Cmb;
  
  public MainWindow() {
    initComponents();
    loadReturnType_cmb_Items();
    this.xqt = new XPathQueryTool();
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public void loadReturnType_cmb_Items() {
    this.returnType_Cmb.removeAllItems();
    this.returnType_Cmb.addItem("BOOLEAN");
    this.returnType_Cmb.addItem("NODESET");
    this.returnType_Cmb.addItem("NODE");
    this.returnType_Cmb.addItem("NUMBER");
    this.returnType_Cmb.addItem("STRING");
    this.returnType_Cmb.setSelectedIndex(1);
  }
  
  private void initComponents() {
    this.fileChooser_Window = new JFileChooser();
    this.jPanel1 = new JPanel();
    this.chooseFile_btn = new JButton();
    this.chooseFile_lbl = new JLabel();
    this.queryTextField = new JTextField();
    this.clear_btn = new JButton();
    this.query_btn = new JButton();
    this.jPanel2 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.result_txtArea = new JTextArea();
    this.returnType_Cmb = new JComboBox<>();
    this.copyAll_btn = new JButton();
    this.distinct_chkBox = new JCheckBox();
    this.jScrollPane2 = new JScrollPane();
    this.message_txtArea = new JTextArea();
    this.fileChooser_Window.setCurrentDirectory(new File("C:\\Users\\Sergio\\Desktop"));
    this.fileChooser_Window.setFileFilter(new MyCustomFilter());
    this.fileChooser_Window.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.fileChooser_WindowActionPerformed(evt);
          }
        });
    setDefaultCloseOperation(3);
    this.chooseFile_btn.setText("File...");
    this.chooseFile_btn.setActionCommand("chooseFile_btn");
    this.chooseFile_btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.chooseFile_btnActionPerformed(evt);
          }
        });
    this.chooseFile_lbl.setFont(new Font("Tahoma", 1, 13));
    this.chooseFile_lbl.setText("No file selected");
    this.queryTextField.setBackground(new Color(51, 51, 51));
    this.queryTextField.setFont(new Font("Lucida Sans", 1, 14));
    this.queryTextField.setForeground(new Color(255, 255, 102));
    this.queryTextField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.queryTextFieldActionPerformed(evt);
          }
        });
    this.clear_btn.setText("Clear");
    this.clear_btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.clear_btnActionPerformed(evt);
          }
        });
    this.query_btn.setText("Query");
    this.query_btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.query_btnActionPerformed(evt);
          }
        });
    this.result_txtArea.setBackground(new Color(51, 51, 51));
    this.result_txtArea.setColumns(20);
    this.result_txtArea.setFont(new Font("Lucida Sans", 0, 13));
    this.result_txtArea.setForeground(new Color(255, 255, 102));
    this.result_txtArea.setRows(5);
    this.jScrollPane1.setViewportView(this.result_txtArea);
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
          .addComponent(this.jScrollPane1, -2, 637, -2)
          .addGap(0, 0, 32767)));
    jPanel2Layout.setVerticalGroup(jPanel2Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jScrollPane1, -1, 439, 32767));
    this.returnType_Cmb.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    this.returnType_Cmb.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.returnType_CmbActionPerformed(evt);
          }
        });
    this.copyAll_btn.setText("Copy All");
    this.copyAll_btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainWindow.this.copyAll_btnActionPerformed(evt);
          }
        });
    this.distinct_chkBox.setText("Distinct values");
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jPanel2, -1, -1, 32767)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.chooseFile_btn)
                  .addGap(10, 10, 10)
                  .addComponent(this.chooseFile_lbl, -1, -1, 32767))
                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addComponent(this.queryTextField)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.returnType_Cmb, -2, 117, -2)))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.distinct_chkBox)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(this.query_btn)
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(this.clear_btn))))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(this.copyAll_btn)
              .addGap(0, 0, 32767)))
          .addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.chooseFile_btn)
            .addComponent(this.chooseFile_lbl)
            .addComponent(this.distinct_chkBox))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.queryTextField, -2, -1, -2)
            .addComponent(this.query_btn)
            .addComponent(this.clear_btn)
            .addComponent(this.returnType_Cmb, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.jPanel2, -1, -1, 32767)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(this.copyAll_btn)
          .addContainerGap()));
    this.message_txtArea.setColumns(20);
    this.message_txtArea.setRows(5);
    this.jScrollPane2.setViewportView(this.message_txtArea);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel1, -1, -1, 32767)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.jScrollPane2)
          .addContainerGap()));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(this.jPanel1, -2, -1, -2)
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
          .addComponent(this.jScrollPane2, -2, -1, -2)
          .addContainerGap()));
    pack();
  }
  
  private void chooseFile_btnActionPerformed(ActionEvent evt) {
    fileChooser_WindowActionPerformed(evt);
  }
  
  private void fileChooser_WindowActionPerformed(ActionEvent evt) {
    int returnVal = this.fileChooser_Window.showOpenDialog(this);
    if (returnVal == 0) {
      File file = this.fileChooser_Window.getSelectedFile();
      try {
        this.result_txtArea.read(new FileReader(file.getAbsolutePath()), (Object)null);
        this.chooseFile_lbl.setText(file.getAbsolutePath());
      } catch (IOException ex) {
        System.out.println("problem accessing file" + file.getAbsolutePath());
      } 
    } else {
      System.out.println("File access cancelled by user.");
    } 
  }
  
  private void queryTextFieldActionPerformed(ActionEvent evt) {}
  
  private void clear_btnActionPerformed(ActionEvent evt) {
    this.result_txtArea.setText("");
    this.queryTextField.setText("");
    try {
      this.result_txtArea.read(new FileReader(this.chooseFile_lbl.getText()), (Object)null);
    } catch (IOException ex) {
      System.out.println("problem accessing file" + this.chooseFile_lbl.getText());
    } 
  }
  
  private void query_btnActionPerformed(ActionEvent evt) {
    try {
      String queryStr = this.queryTextField.getText();
      QName returnType = null;
      this.message_txtArea.setText("");
      switch (this.returnType_Cmb.getSelectedIndex()) {
        case 0:
          returnType = XPathConstants.BOOLEAN;
          break;
        case 1:
          returnType = XPathConstants.NODESET;
          break;
        case 2:
          returnType = XPathConstants.NODE;
          break;
        case 3:
          returnType = XPathConstants.NUMBER;
          break;
        case 4:
          returnType = XPathConstants.STRING;
          break;
      } 
      this.xqt.launchQuery(queryStr, this.fileChooser_Window.getSelectedFile().getAbsolutePath(), returnType, this.result_txtArea, this.distinct_chkBox);
    } catch (ParserConfigurationException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
      this.message_txtArea.setText(ex.getMessage());
    } catch (SAXException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
      this.message_txtArea.setText(ex.getMessage());
    } catch (IOException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
      this.message_txtArea.setText(ex.getMessage());
    } catch (XPathExpressionException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
      this.message_txtArea.setText(ex.getMessage());
    } 
  }
  
  private void returnType_CmbActionPerformed(ActionEvent evt) {
    switch (this.returnType_Cmb.getSelectedIndex()) {
      case 0:
        this.distinct_chkBox.setEnabled(false);
        break;
      case 1:
        this.distinct_chkBox.setEnabled(true);
        break;
      case 2:
        this.distinct_chkBox.setEnabled(false);
        break;
      case 3:
        this.distinct_chkBox.setEnabled(false);
        break;
      case 4:
        this.distinct_chkBox.setEnabled(false);
        break;
    } 
  }
  
  private void copyAll_btnActionPerformed(ActionEvent evt) {
    StringSelection stringSelection = new StringSelection(this.result_txtArea.getText());
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new MainWindow()).setVisible(true);
          }
        });
  }
}
