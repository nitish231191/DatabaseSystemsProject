package SwingUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dml.DML;

public class DataBaseUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private String operation=null;
	private boolean Availability =false;
	private boolean designation = false;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private DML dml;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBaseUI frame = new DataBaseUI();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	protected Component makeTextPanel(String text) {
	    JPanel panel = new JPanel(false);
	    JLabel filler = new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(filler);
	    return panel;
	    
	    
	}

	private boolean writeDB(String op, String tableName, String[] values, String[] newValues) {
		tableName = "test";
		System.out.println(op+":"+tableName+":"+values.length+":"+newValues.length);
		boolean isSuccess = false;
		try {
			if(op.equals("Create"))
				isSuccess = dml.create(tableName, values);
			else if(op.equals("Update"))
				isSuccess = dml.update(tableName, values, newValues);
			else if(op.equals("Delete"))
				isSuccess = dml.delete(tableName, values);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}

	private ResultSet readDB(String tableName, String[] values) {
		tableName = "test";
		System.out.println(":"+tableName+":"+values.toString());
		try {
			return dml.read(tableName, values);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DataBaseUI() throws ClassNotFoundException, SQLException {
		dml = new DML();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,470,514);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// yes and no radio button of update option
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setEnabled(false);
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setEnabled(false);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 500);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		getContentPane().add(tabbedPane);
		
		ButtonGroup bgyesorno = new ButtonGroup();
		ButtonGroup operation = new ButtonGroup();
		ButtonGroup updateop = new ButtonGroup();
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Books", null, panel, null);
		panel.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(95, 10, 53, 16);
		panel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 5, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIsbnNumber = new JLabel("ISBN Number");
		lblIsbnNumber.setBounds(57, 40, 90, 16);
		panel.add(lblIsbnNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 35, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(79, 82, 61, 16);
		panel.add(lblAuthor);
		
		textField_7 = new JTextField();
		textField_7.setBounds(183, 73, 130, 26);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblIsAvailable = new JLabel("is Available");
		lblIsAvailable.setBounds(57, 120, 83, 16);
		panel.add(lblIsAvailable);
		
		JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBounds(172, 116, 61, 23);
		panel.add(rdbtnYes_1);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(231, 116, 61, 23);
		panel.add(rdbtnNo);
		bgyesorno.add(rdbtnNo);
		bgyesorno.add(rdbtnYes_1);
		
		JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setVisible(false);
		rdbtnYes_2.setBounds(151, 357, 69, 23);
		panel.add(rdbtnYes_2);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setVisible(false);
		rdbtnNo_1.setBounds(231, 357, 69, 23);
		panel.add(rdbtnNo_1);
		
		
		
		JLabel lblNewName = new JLabel("New Name");
		lblNewName.setBounds(79, 223, 69, 16);
		lblNewName.setVisible(false);
		panel.add(lblNewName);
		
		textField_8 = new JTextField();
		textField_8.setVisible(false);
		textField_8.setBounds(183, 218, 130, 26);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewIsbnNumber = new JLabel("New ISBN Number");
		lblNewIsbnNumber.setBounds(35, 269, 113, 16);
		lblNewIsbnNumber.setVisible(false);
		panel.add(lblNewIsbnNumber);
		
		textField_9 = new JTextField();
		textField_9.setVisible(false);
		textField_9.setBounds(183, 264, 130, 21);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewAuthor = new JLabel("New Author");
		lblNewAuthor.setBounds(57, 314, 91, 16);
		
	    lblNewAuthor.setVisible(false);
		panel.add(lblNewAuthor);
		
		textField_10 = new JTextField();
		textField_10.setVisible(false);
		textField_10.setBounds(183, 309, 130, 26);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblIsAvailable_1 = new JLabel("Is Available");
		lblIsAvailable_1.setBounds(57, 361, 83, 16);
		lblIsAvailable_1.setVisible(false);
		panel.add(lblIsAvailable_1);
		
		JRadioButton rdbtnSelect = new JRadioButton("Select");
		rdbtnSelect.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnSelect.isSelected()){
					lblNewName.setVisible(false);
					textField_8.setVisible(false);
					lblIsAvailable_1.setVisible(false);
					lblNewAuthor.setVisible(false);
					lblNewIsbnNumber.setVisible(false);
					textField_9.setVisible(false);
					textField_10.setVisible(false);
					rdbtnYes_2.setVisible(false);
					rdbtnNo_1.setVisible(false);
					
					
				}
			}
		});
		rdbtnSelect.setBounds(6, 163, 69, 23);
		panel.add(rdbtnSelect);
		
		JRadioButton rdbtnCreate = new JRadioButton("Create");
		rdbtnCreate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(rdbtnCreate.isSelected()){
					lblNewName.setVisible(false);
					textField_8.setVisible(false);
					lblIsAvailable_1.setVisible(false);
					lblNewAuthor.setVisible(false);
					lblNewIsbnNumber.setVisible(false);
					textField_9.setVisible(false);
					textField_10.setVisible(false);
					rdbtnYes_2.setVisible(false);
					rdbtnNo_1.setVisible(false);
					
					
				}
			}
		});
		rdbtnCreate.setBounds(95, 163, 76, 23);
		panel.add(rdbtnCreate);
		
		JRadioButton rdbtnUpdate = new JRadioButton("Update");
		rdbtnUpdate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnUpdate.isSelected()){
					lblNewName.setVisible(true);
					textField_8.setVisible(true);
					lblIsAvailable_1.setVisible(true);
					lblNewAuthor.setVisible(true);
					lblNewIsbnNumber.setVisible(true);
					textField_9.setVisible(true);
					textField_10.setVisible(true);
					rdbtnYes_2.setVisible(true);
					rdbtnNo_1.setVisible(true);
					
					
				}
			}
		});
		rdbtnUpdate.setBounds(188, 163, 83, 23);
		panel.add(rdbtnUpdate);
		
		JRadioButton rdbtnDelete = new JRadioButton("Delete");
		rdbtnDelete.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDelete.isSelected()){
					lblNewName.setVisible(false);
					textField_8.setVisible(false);
					lblIsAvailable_1.setVisible(false);
					lblNewAuthor.setVisible(false);
					lblNewIsbnNumber.setVisible(false);
					textField_9.setVisible(false);
					textField_10.setVisible(false);
					rdbtnYes_2.setVisible(false);
					rdbtnNo_1.setVisible(false);
					
				}
			}
		});
	
		rdbtnDelete.setBounds(294, 163, 83, 23);
		panel.add(rdbtnDelete);
		
		operation.add(rdbtnDelete);
		operation.add(rdbtnUpdate);
		operation.add(rdbtnCreate);
		operation.add(rdbtnSelect);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				JPanel newsubmit = new JPanel();
				int index = tabbedPane.getSelectedIndex();
				tabbedPane.setComponentAt(index, newsubmit);
				tabbedPane.repaint();
				tabbedPane.validate();
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(71, 52, 308, 271);
				
				
				newsubmit.setLayout(null);
				
				JButton exit = new JButton("Back");
				exit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setComponentAt(index, panel);
						tabbedPane.repaint();
						tabbedPane.validate();
						
						
						// TODO Auto-generated method stub
						
					}
					
				});
				
				newsubmit.add(exit);
				newsubmit.add(textArea_1);
				exit.setBounds(132, 358, 117, 29);

				{
					String isAvl = "";
					if(rdbtnYes_1.isSelected())
						isAvl = "Yes";
					else if(rdbtnNo.isSelected())
						isAvl = "No";
	
					String isAvlN = "";
					if(rdbtnYes_2.isSelected())
						isAvlN = "Yes";
					else if(rdbtnNo_1.isSelected())
						isAvlN = "No";
	
					String[] values = {textField_1.getText(), textField_7.getText(), textField_2.getText(), isAvl};
					String[] newValues = {textField_8.getText(), textField_10.getText(), textField_9.getText(), isAvlN};
					String tableName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
					
					for(Enumeration<AbstractButton> buttons = operation.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
			            if (button.isSelected()) {
			            	if(button.getText().equals("Select"))
			            		readDB(tableName, values);
			            	else
			            		writeDB(button.getText(), tableName, values, newValues);
			            }
					}
				}
			}
		});
		btnSubmit.setBounds(57, 405, 117, 29);
		panel.add(btnSubmit);
		
	
		
		updateop.add(rdbtnNo_1);
		updateop.add(rdbtnYes_2);
		
		JButton button = new JButton("Show Different Books");
		button.setBounds(205, 405, 179, 29);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("People", null, panel_1, null);
		panel_1.setLayout(null);
		
		ButtonGroup peopledesig = new ButtonGroup();
		ButtonGroup peopleoperation = new ButtonGroup();
		ButtonGroup peoplenewdesig = new ButtonGroup();
		
		
		
		JLabel lblUin = new JLabel("UIN");
		lblUin.setBounds(63, 21, 61, 16);
		panel_1.add(lblUin);
		
		textField_11 = new JTextField();
		textField_11.setBounds(162, 16, 130, 26);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(63, 49, 61, 26);
		panel_1.add(lblName_1);
		
		textField_12 = new JTextField();
		textField_12.setBounds(162, 49, 130, 26);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(36, 87, 88, 16);
		panel_1.add(lblDesignation);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(125, 87, 88, 23);
		panel_1.add(rdbtnStudent);
		
		JRadioButton rdbtnFaculty = new JRadioButton("Faculty");
		rdbtnFaculty.setBounds(200, 87, 101, 23);
		panel_1.add(rdbtnFaculty);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setBounds(306, 87, 106, 23);
		panel_1.add(rdbtnStaff);
		
		peopledesig.add(rdbtnStaff);
		peopledesig.add(rdbtnFaculty);;
		peopledesig.add(rdbtnStudent);
		
		
		
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(36, 132, 112, 16);
		panel_1.add(lblContactNumber);
		
		textField_13 = new JTextField();
		textField_13.setBounds(171, 127, 130, 26);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		ButtonGroup bgnewpeople = new ButtonGroup();
		
		JLabel lblContactNumber_1 = new JLabel("Contact Number");
		lblContactNumber_1.setVisible(false);
		JRadioButton rdbtnStaff_1 = new JRadioButton("Staff");
		rdbtnStaff_1.setVisible(false);
		JRadioButton rdbtnFaculty_1 = new JRadioButton("Faculty");
		rdbtnFaculty_1.setVisible(false);
		JRadioButton rdbtnStudent_1 = new JRadioButton("Student");
		rdbtnStudent_1.setVisible(false);
		
		bgnewpeople.add(rdbtnStaff_1);
		bgnewpeople.add(rdbtnFaculty_1);
		bgnewpeople.add(rdbtnStudent_1);
		
		
		JLabel lblNewUin = new JLabel("New UIN");
		lblNewUin.setBounds(63, 230, 61, 16);
		lblNewUin.setVisible(false);
		panel_1.add(lblNewUin);
		
		textField_14 = new JTextField();
		textField_14.setVisible(false);
		textField_14.setBounds(162, 225, 130, 26);
		panel_1.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewName_1 = new JLabel("New Name");
		lblNewName_1.setVisible(false);
		lblNewName_1.setBounds(63, 276, 74, 16);
		panel_1.add(lblNewName_1);
		
		textField_15 = new JTextField();
		textField_15.setVisible(false);
		textField_15.setBounds(162, 273, 130, 21);
		panel_1.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Designation");
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(49, 324, 88, 16);
		panel_1.add(lblNewLabel);
		
		
		rdbtnStudent_1.setBounds(137, 320, 93, 23);
		panel_1.add(rdbtnStudent_1);
		
		
		rdbtnFaculty_1.setBounds(229, 320, 88, 23);
		panel_1.add(rdbtnFaculty_1);
		
		
		rdbtnStaff_1.setBounds(329, 320, 69, 23);
		panel_1.add(rdbtnStaff_1);
		
		
		lblContactNumber_1.setBounds(36, 355, 112, 16);
		panel_1.add(lblContactNumber_1);
		
		textField_16 = new JTextField();
		textField_16.setVisible(false);
		textField_16.setBounds(171, 355, 130, 26);
		panel_1.add(textField_16);
		textField_16.setColumns(10);
		
		
		JRadioButton rdbtnSelect_1 = new JRadioButton("Select");
		rdbtnSelect_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnSelect_1.isSelected()){
					lblNewName_1.setVisible(false);
					lblNewUin.setVisible(false);
					lblContactNumber_1.setVisible(false);
					textField_16.setVisible(false);
					textField_14.setVisible(false);
					textField_15.setVisible(false);
					rdbtnStaff_1.setVisible(false);
					rdbtnFaculty_1.setVisible(false);
					rdbtnStudent_1.setVisible(false);
					lblNewLabel.setVisible(false);
				}
			}
		});
		rdbtnSelect_1.setBounds(18, 176, 69, 23);
		panel_1.add(rdbtnSelect_1);
		
		JRadioButton rdbtnCreate_1 = new JRadioButton("Create");
		rdbtnCreate_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnCreate_1.isSelected()){
					lblNewName_1.setVisible(false);
					lblNewUin.setVisible(false);
					lblContactNumber_1.setVisible(false);
					textField_16.setVisible(false);
					textField_14.setVisible(false);
					textField_15.setVisible(false);
					rdbtnStaff_1.setVisible(false);
					rdbtnFaculty_1.setVisible(false);
					rdbtnStudent_1.setVisible(false);
					lblNewLabel.setVisible(false);
				}
			}
		});
		rdbtnCreate_1.setBounds(112, 176, 74, 23);
		panel_1.add(rdbtnCreate_1);
		
		JRadioButton rdbtnUpdate_1 = new JRadioButton("Update");
		rdbtnUpdate_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnUpdate_1.isSelected()){
					lblContactNumber_1.setVisible(true);
					lblNewName_1.setVisible(true);
					lblNewUin.setVisible(true);
					textField_16.setVisible(true);
					textField_14.setVisible(true);
					textField_15.setVisible(true);
					rdbtnStaff_1.setVisible(true);
					rdbtnFaculty_1.setVisible(true);
					rdbtnStudent_1.setVisible(true);
					lblNewLabel.setVisible(true);
				}
			}
		});
		rdbtnUpdate_1.setBounds(204, 176, 88, 23);
		panel_1.add(rdbtnUpdate_1);
		
		JRadioButton rdbtnDelete_1 = new JRadioButton("Delete");
		rdbtnDelete_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDelete_1.isSelected()){
					lblNewName_1.setVisible(false);
					lblContactNumber_1.setVisible(false);
					lblNewUin.setVisible(false);
					textField_16.setVisible(false);
					textField_14.setVisible(false);
					textField_15.setVisible(false);
					rdbtnStaff_1.setVisible(false);
					rdbtnFaculty_1.setVisible(false);
					rdbtnStudent_1.setVisible(false);
					lblNewLabel.setVisible(false);
				}
			}
		});
		rdbtnDelete_1.setBounds(306, 176, 106, 23);
		panel_1.add(rdbtnDelete_1);
		
		peopleoperation.add(rdbtnDelete_1);
		peopleoperation.add(rdbtnUpdate_1);
		peopleoperation.add(rdbtnCreate_1);
		peopleoperation.add(rdbtnSelect_1);
		
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JPanel newsubmit = new JPanel();
				int index = tabbedPane.getSelectedIndex();
				tabbedPane.setComponentAt(index, newsubmit);
				tabbedPane.repaint();
				tabbedPane.validate();
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(71, 52, 308, 271);
				
				
				newsubmit.setLayout(null);
				
				JButton exit = new JButton("Back");
				exit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setComponentAt(index, panel_1);
						tabbedPane.repaint();
						tabbedPane.validate();
						
						
						// TODO Auto-generated method stub
						
					}
					
					
				});
				
				
				newsubmit.add(exit);
				newsubmit.add(textArea_1);
				exit.setBounds(132, 358, 117, 29);

				{
					String desig = "";	
					String desigN = "";
					
					for(Enumeration<AbstractButton> buttons = peopledesig.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
			            if (button.isSelected())
			            	desig = button.getText();
					}
					
					for(Enumeration<AbstractButton> buttons = bgnewpeople.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
			            if (button.isSelected())
			            	desigN = button.getText();
					}
	
					String[] values = {textField_11.getText(), textField_12.getText(), desig, textField_13.getText()};
					String[] newValues = {textField_14.getText(), textField_15.getText(), desigN, textField_16.getText()};
					String tableName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
					
					for(Enumeration<AbstractButton> buttons = peopleoperation.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
			            if (button.isSelected()) {
			            	if(button.getText().equals("Select"))
			            		readDB(tableName, values);
			            	else
			            		writeDB(button.getText(), tableName, values, newValues);
			            }
					}
				}
			}
		});
		btnSubmit_1.setBounds(130, 419, 117, 29);
		panel_1.add(btnSubmit_1);
		  
		// button group for Books yes or no
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Borrowers", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN ");
		lblNewLabel_1.setBounds(85, 32, 61, 16);
		panel_2.add(lblNewLabel_1);
		
		textField_17 = new JTextField();
		textField_17.setBounds(182, 27, 130, 26);
		panel_2.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblUin_1 = new JLabel("UIN");
		lblUin_1.setBounds(85, 65, 61, 26);
		panel_2.add(lblUin_1);
		
		textField_18 = new JTextField();
		textField_18.setBounds(182, 65, 130, 26);
		panel_2.add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblBorrowedDate = new JLabel("Borrowed date");
		lblBorrowedDate.setBounds(57, 121, 89, 16);
		panel_2.add(lblBorrowedDate);
		
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		
		String[] numbers ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		String [] year = {"2016","2017","2018"};
		
		
		
		JComboBox comboBox = new JComboBox(numbers);
		comboBox.setBounds(158, 117, 60, 27);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(months);
		comboBox_1.setBounds(230, 117, 82, 27);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(year);
		comboBox_2.setBounds(324, 117, 82, 27);
		panel_2.add(comboBox_2);
		
		JLabel lblReturningDat = new JLabel("Returning Date");
	
		lblReturningDat.setBounds(46, 166, 102, 16);
		panel_2.add(lblReturningDat);
		
		JComboBox comboBox_3 = new JComboBox(numbers);
		comboBox_3.setBounds(158, 162, 62, 27);
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(months);
		comboBox_4.setBounds(240, 162, 72, 27);
		panel_2.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(year);
		comboBox_5.setBounds(324, 162, 82, 27);
		panel_2.add(comboBox_5);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setVisible(false);
		lblIsbn.setBounds(99, 259, 39, 16);
		panel_2.add(lblIsbn);
		
		textField_19 = new JTextField();
		textField_19.setVisible(false);
		textField_19.setBounds(182, 254, 130, 26);
		panel_2.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setVisible(false);
		textField_20.setBounds(182, 283, 130, 26);
		panel_2.add(textField_20);
		textField_20.setColumns(10);
		
		JLabel lblUin_2 = new JLabel("UIN");
		lblUin_2.setVisible(false);
		lblUin_2.setBounds(109, 288, 39, 16);
		panel_2.add(lblUin_2);
		
		JComboBox comboBox_6 = new JComboBox(numbers);
		comboBox_6.setVisible(false);
		comboBox_6.setBounds(158, 330, 60, 27);
		panel_2.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox(numbers);
		comboBox_7.setVisible(false);
		comboBox_7.setBounds(158, 369, 62, 27);
		panel_2.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(months);
		comboBox_8.setVisible(false);
		comboBox_8.setBounds(240, 330, 72, 27);
		panel_2.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox(months);
		comboBox_9.setVisible(false);
		comboBox_9.setBounds(240, 369, 72, 27);
		panel_2.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox(year);
		comboBox_10.setVisible(false);
		comboBox_10.setBounds(324, 330, 82, 27);
		panel_2.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox(year);
		comboBox_11.setVisible(false);
		comboBox_11.setBounds(324, 369, 82, 27);
		panel_2.add(comboBox_11);
		
		JLabel lblBorrowed = new JLabel("Borrowed Date");
		lblBorrowed.setBounds(52, 334, 61, 16);
		lblBorrowed.setVisible(false);
		panel_2.add(lblBorrowed);
		
		JLabel lblReturned = new JLabel("Returned date");
		lblReturned.setVisible(false);
		lblReturned.setBounds(57, 373, 61, 16);
		panel_2.add(lblReturned);
		
		JRadioButton rdbtnSelect_2 = new JRadioButton("Select");
		rdbtnSelect_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if(rdbtnSelect_2.isSelected()){
					lblIsbn.setVisible(false);
					lblUin_2.setVisible(false);
					lblBorrowed.setVisible(false);
					lblReturned.setVisible(false);
					textField_19.setVisible(false);
					comboBox_6.setVisible(false);
					comboBox_7.setVisible(false);
					comboBox_8.setVisible(false);
					comboBox_9.setVisible(false);
					comboBox_10.setVisible(false);
					comboBox_11.setVisible(false);
					textField_20.setVisible(false);
				}
			}
		});
		rdbtnSelect_2.setBounds(5, 215, 69, 23);
		panel_2.add(rdbtnSelect_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Create");
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNewRadioButton.isSelected()){
					lblIsbn.setVisible(false);
					lblUin_2.setVisible(false);
					lblBorrowed.setVisible(false);
					lblReturned.setVisible(false);
					textField_19.setVisible(false);
					comboBox_6.setVisible(false);
					comboBox_7.setVisible(false);
					comboBox_8.setVisible(false);
					comboBox_9.setVisible(false);
					comboBox_10.setVisible(false);
					comboBox_11.setVisible(false);
					textField_20.setVisible(false);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(89, 215, 82, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDelete_2 = new JRadioButton("Delete");
		rdbtnDelete_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDelete_2.isSelected()){
					lblIsbn.setVisible(false);
					lblUin_2.setVisible(false);
					lblBorrowed.setVisible(false);
					lblReturned.setVisible(false);
					textField_19.setVisible(false);
					comboBox_6.setVisible(false);
					comboBox_7.setVisible(false);
					comboBox_8.setVisible(false);
					comboBox_9.setVisible(false);
					comboBox_10.setVisible(false);
					comboBox_11.setVisible(false);
					textField_20.setVisible(false);
				}
			}
		});
		rdbtnDelete_2.setBounds(203, 215, 89, 23);
		panel_2.add(rdbtnDelete_2);
		
		JRadioButton rdbtnUpdate_2 = new JRadioButton("Update");
		rdbtnUpdate_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnUpdate_2.isSelected()){
					lblIsbn.setVisible(true);
					lblUin_2.setVisible(true);
					lblBorrowed.setVisible(true);
					lblReturned.setVisible(true);
					textField_19.setVisible(true);
					comboBox_6.setVisible(true);
					comboBox_7.setVisible(true);
					comboBox_8.setVisible(true);
					comboBox_9.setVisible(true);
					comboBox_10.setVisible(true);
					comboBox_11.setVisible(true);
					textField_20.setVisible(true);
				}
			}
		});
		rdbtnUpdate_2.setBounds(301, 215, 89, 23);
		panel_2.add(rdbtnUpdate_2);
		
		ButtonGroup bgborrow = new ButtonGroup();
		bgborrow.add(rdbtnDelete_2);
		bgborrow.add(rdbtnSelect_2);
		bgborrow.add(rdbtnNewRadioButton);
		bgborrow.add(rdbtnUpdate_2);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel newsubmit = new JPanel();
				int index = tabbedPane.getSelectedIndex();
				tabbedPane.setComponentAt(index, newsubmit);
				tabbedPane.repaint();
				tabbedPane.validate();
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(71, 52, 308, 271);
				
				
				newsubmit.setLayout(null);
				
				JButton exit = new JButton("Back");
				exit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setComponentAt(index, panel_2);
						tabbedPane.repaint();
						tabbedPane.validate();
						
						
						// TODO Auto-generated method stub
						
					}
					
					
				});
				
				
				newsubmit.add(exit);
				newsubmit.add(textArea_1);
				exit.setBounds(132, 358, 117, 29);
				
				{
					String bDate = (comboBox_2.getSelectedIndex()+2016) + "/" + (comboBox_1.getSelectedIndex()+1) + "/" + (comboBox.getSelectedIndex()+1);	
					String dDate = (comboBox_5.getSelectedIndex()+2016) + "/" + (comboBox_4.getSelectedIndex()+1) + "/" + (comboBox_3.getSelectedIndex()+1);
					String bDateN = (comboBox_10.getSelectedIndex()+2016) + "/" + (comboBox_8.getSelectedIndex()+1) + "/" + (comboBox_6.getSelectedIndex()+1);	
					String dDateN = (comboBox_11.getSelectedIndex()+2016) + "/" + (comboBox_9.getSelectedIndex()+1) + "/" + (comboBox_7.getSelectedIndex()+1);
	
					String[] values = {textField_17.getText(), textField_18.getText(), bDate, dDate};
					String[] newValues = {textField_19.getText(), textField_20.getText(), bDateN, dDateN};
					String tableName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
					
					for(Enumeration<AbstractButton> buttons = bgborrow.getElements(); buttons.hasMoreElements();) {
						AbstractButton button = buttons.nextElement();
			            if (button.isSelected()) {
			            	if(button.getText().equals("Select"))
			            		readDB(tableName, values);
			            	else
			            		writeDB(button.getText(), tableName, values, newValues);
			            }
					}
				}
			}
		});
		btnSubmit_2.setBounds(152, 408, 117, 29);
		panel_2.add(btnSubmit_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("SQL Query", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblSelect = new JLabel("Select ");
		lblSelect.setBounds(22, 17, 61, 16);
		panel_3.add(lblSelect);
		
		JLabel lblFrom = new JLabel("From ");
		lblFrom.setBounds(22, 145, 61, 16);
		panel_3.add(lblFrom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 18, 135, 129);
		panel_3.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(317, 28, 106, 146);
		panel_3.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		DefaultListModel listmodel_1 = new DefaultListModel();
		
		String [] attributes_Book = {"Book_Name","Author","Availabilty","ISBN"};
		
		String [] attributes_people = {"Student_Name","UIN","Designation","Contact"};
		
		String [] attributes_Borrowed = {"Return Date","Due Date"};
		
		String [] emptylist = {};
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(305, 289, 92, 83);
		panel_3.add(scrollPane_3);
		
		JList list_3 = new JList();
		scrollPane_3.setViewportView(list_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(103, 299, 92, 77);
		panel_3.add(scrollPane_2);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		DefaultListModel listmodel = new DefaultListModel();
		
		JCheckBox chckbxBooks = new JCheckBox("Books");
		chckbxBooks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int begin=0;
				if(e.getStateChange() == ItemEvent.SELECTED){
					begin = listmodel.size();
					
					for(int i=0;i<attributes_Book.length;i++){
						listmodel.addElement(attributes_Book[i]);
					}
					list.setModel(listmodel);
					
					
				}
				else{
					int end = listmodel.size();
					
					
					
					for(int i= begin;i<end;i++){
						listmodel.removeElement(attributes_Book[i]);
						
					}
						
					
					
					list.setModel(listmodel);
					
				}
			}
		});
	
		
		chckbxBooks.setBounds(19, 173, 78, 23);
		panel_3.add(chckbxBooks);
		
		JCheckBox chckbxPeople = new JCheckBox("People");
		chckbxPeople.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			
				
				if(e.getStateChange() == ItemEvent.SELECTED){
					
					
					for(int i=0;i<attributes_Book.length;i++){
						listmodel.addElement(attributes_people[i]);
					}
					list.setModel(listmodel);
				}
				if(e.getStateChange()==ItemEvent.DESELECTED){
					
					for(int i=0;i<attributes_people.length;i++){
						listmodel.removeElement(attributes_people[i]);
					}
					
					list.setModel(listmodel);
					
				}
			}
			
		});
		
		chckbxPeople.setBounds(103, 173, 84, 23);
		panel_3.add(chckbxPeople);
		
		JCheckBox chckbxBorrowers = new JCheckBox("Borrowers");
		chckbxBorrowers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange()==ItemEvent.SELECTED){
					for(int i=0;i<attributes_Borrowed.length;i++){
						listmodel.addElement(attributes_Borrowed[i]);
					}
						
				}
				else{
					for(int i=0;i<attributes_Borrowed.length;i++){
						listmodel.removeElement(attributes_Borrowed[i]);
					}
				}
			}
		});
		chckbxBorrowers.setBounds(196, 173, 110, 23);
		panel_3.add(chckbxBorrowers);
		
		JLabel lblWhere = new JLabel("Where ");
		lblWhere.setBounds(22, 219, 61, 16);
		panel_3.add(lblWhere);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 248, 149, 29);
		panel_3.add(textArea);
		
		String[] operator = {"operator",">","<","=",">=","<=","none"};
		
		JComboBox comboBox_12 = new JComboBox(operator);
		comboBox_12.setBounds(196, 244, 78, 27);
		panel_3.add(comboBox_12);
		
		textField_21 = new JTextField();
		textField_21.setBounds(295, 243, 130, 23);
		panel_3.add(textField_21);
		textField_21.setColumns(10);
		
		JLabel lblGroupBy = new JLabel("Group By");
		lblGroupBy.setBounds(19, 289, 61, 16);
		panel_3.add(lblGroupBy);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listmodel_1.addElement(list.getSelectedValue());
				list_1.setModel(listmodel_1);
			}
		});
		btnNewButton.setBounds(211, 12, 92, 29);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(!list_1.isSelectionEmpty()){
					listmodel_1.removeElement(list_1.getSelectedValue());
					System.out.println("Selected value "+list_1.getSelectedValue());
				}
				
			}
		});
		btnNewButton_1.setBounds(213, 90, 92, 29);
		panel_3.add(btnNewButton_1);
		
		
		DefaultListModel listmodel_groupby = new DefaultListModel();
		
		DefaultListModel listmodel_groupby_2 = new DefaultListModel();
		 
		
		String[] all_attributes={"Books_Name","Student_Name","UIN","ISBN","Avaialabilty","Author","Designation","ContactNumber","ReturnDate","DueDate"};
		
		for(int i=0;i<all_attributes.length;i++){
			listmodel_groupby.addElement(all_attributes[i]);
		}
			list_2.setModel(listmodel_groupby);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listmodel_groupby_2.addElement(list_2.getSelectedValue());
				list_3.setModel(listmodel_groupby_2);
				
				
			}
		});
		btnNewButton_2.setBounds(196, 289, 84, 29);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(!list_3.isSelectionEmpty()){
					listmodel_groupby_2.removeElement(list_3.getSelectedValue());
				}
			}
		});
		btnNewButton_3.setBounds(196, 343, 84, 29);
		panel_3.add(btnNewButton_3);
		
		
		
		JButton btnSubmit_3 = new JButton("Submit");
		btnSubmit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel newsubmit = new JPanel();
				int index = tabbedPane.getSelectedIndex();
				tabbedPane.setComponentAt(index, newsubmit);
				tabbedPane.repaint();
				tabbedPane.validate();
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(71, 52, 308, 271);
				
				
				newsubmit.setLayout(null);
				
				JButton exit = new JButton("Back");
				exit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setComponentAt(index, panel_3);
						tabbedPane.repaint();
						tabbedPane.validate();
						
						
						// TODO Auto-generated method stub
						
					}
					
					
				});
				
				
				newsubmit.add(exit);
				newsubmit.add(textArea_1);
				exit.setBounds(132, 358, 117, 29);
			}
		});
		btnSubmit_3.setBounds(131, 405, 117, 29);
		panel_3.add(btnSubmit_3);
	}
}
