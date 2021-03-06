package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLayer.userManagement.User;
import businessLayer.userManagement.UsersOperation;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextField uNameField;
	private JPasswordField passField;
	private JPasswordField conformPassField;
	private static JFrame mLogin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistrationForm frame = new RegistrationForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("New User Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("           First Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		fNameField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		contentPane.add(fNameField, gbc_textField);
		fNameField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		lNameField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(lNameField, gbc_textField_1);
		lNameField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("User Name:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		uNameField = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		contentPane.add(uNameField, gbc_textField_2);
		uNameField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		passField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 5;
		contentPane.add(passField, gbc_passwordField);

		JLabel lblNewLabel_5 = new JLabel("Confirm Password:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		conformPassField = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.gridwidth = 2;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 2;
		gbc_passwordField_1.gridy = 6;
		contentPane.add(conformPassField, gbc_passwordField_1);

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char fNameChkFlag = 'n';
				char lNameChkFlag = 'n';
				char uNameChkFlag = 'n';
				char chkPassFlag = 'n';
				char uniqUnameChk = 'n';
				
				String uName = uNameField.getText().trim().toLowerCase();
				String fname= fNameField.getText().trim();
				String lname= lNameField.getText().trim(); 
				String passwrd= passField.getText().trim();
				String cPasswrd= conformPassField.getText().trim();
				
				// if(e.getSource()==textField)
				{
					String h = fNameField.getText();
					int length = h.length();
					char ch;

					for (int i = 0; i < length; i++) {
						ch = h.charAt(i);
						if (ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f' || ch == 'g'
								|| ch == 'h' || ch == 'i' || ch == 'j' || ch == 'k' || ch == 'l' || ch == 'm'
								|| ch == 'n' || ch == 'o' || ch == 'p' || ch == 'q' || ch == 'r' || ch == 's'
								|| ch == 't' || ch == 'u' || ch == 'v' || ch == 'w' || ch == 'x' || ch == 'y'
								|| ch == 'z' || ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E'
								|| ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K'
								|| ch == 'L' || ch == 'M' || ch == 'N' || ch == 'O' || ch == 'P' || ch == 'Q'
								|| ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U' || ch == 'V' || ch == 'W'
								|| ch == 'X' || ch == 'Y' || ch == 'Z' || ch == ' ') {
							fNameChkFlag = 'y';
						} else {
							fNameChkFlag = 'n';
							break;
						}
					}
				}
				// if(textField.getText()=="")
				// if(e.getSource()==textField_1)
				{
					String h = lNameField.getText();
					int length = h.length();
					char ch;
					// flag1='n';
					for (int i = 0; i < length; i++) {
						ch = h.charAt(i);
						if (ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f' || ch == 'g'
								|| ch == 'h' || ch == 'i' || ch == 'j' || ch == 'k' || ch == 'l' || ch == 'm'
								|| ch == 'n' || ch == 'o' || ch == 'p' || ch == 'q' || ch == 'r' || ch == 's'
								|| ch == 't' || ch == 'u' || ch == 'v' || ch == 'w' || ch == 'x' || ch == 'y'
								|| ch == 'z' || ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E'
								|| ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K'
								|| ch == 'L' || ch == 'M' || ch == 'N' || ch == 'O' || ch == 'P' || ch == 'Q'
								|| ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U' || ch == 'V' || ch == 'W'
								|| ch == 'X' || ch == 'Y' || ch == 'Z') {
							lNameChkFlag = 'y';
						} else {
							lNameChkFlag = 'n';
							break;
						}

					}
				}

				
					String h = uNameField.getText();
					int length = h.length();
					char ch;
					// char flag='n';
					for (int i = 0; i < length; i++) {
						ch = h.charAt(i);
						if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6'
								|| ch == '7' || ch == '8' || ch == '9' || ch == 'a' || ch == 'b' || ch == 'c'
								|| ch == 'd' || ch == 'e' || ch == 'f' || ch == 'g' || ch == 'h' || ch == 'i'
								|| ch == 'j' || ch == 'k' || ch == 'l' || ch == 'm' || ch == 'n' || ch == 'o'
								|| ch == 'p' || ch == 'q' || ch == 'r' || ch == 's' || ch == 't' || ch == 'u'
								|| ch == 'v' || ch == 'w' || ch == 'x' || ch == 'y' || ch == 'z' || ch == 'A'
								|| ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F' || ch == 'G'
								|| ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K' || ch == 'L' || ch == 'M'
								|| ch == 'N' || ch == 'O' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S'
								|| ch == 'T' || ch == 'U' || ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y'
								|| ch == 'Z') {
							uNameChkFlag = 'y';
						} else {
							uNameChkFlag = 'n';
							break;
						}

					}
				
				if (passwrd.equals(cPasswrd) && passwrd.length()>0 ){
					chkPassFlag = 'y';
				}
				if (UsersOperation.isValidUser(uName)){
					uniqUnameChk = 'y';
				}
				
				
				if (lNameChkFlag == 'y' && fNameChkFlag == 'y' && chkPassFlag == 'y' && uNameChkFlag == 'y' && uniqUnameChk == 'y') {
					// JOptionPane.showMessageDialog(null, "successfully
					// registered");

					User u = new User();
					u.setFirstName(fname);
					u.setLastName(lname);
					u.setPassword(passwrd);
					u.setUserName(uName);

					UsersOperation uo = new UsersOperation();
					uo.insertUserToDB(u);

					JOptionPane.showMessageDialog(null, "User Successfully Registered");
					RegistrationForm.this.setVisible(false);
					RegistrationForm.this.dispose();
					mLogin.setVisible(true);

				} 
				
				else {
					String errMsg = "";
					if (fNameChkFlag == 'n'){
						errMsg = errMsg + "Invalid First Name.";
					}
					if (lNameChkFlag == 'n'){
						errMsg = errMsg + "\nInvalid Last Name.";
					}
					if (chkPassFlag == 'n'){
						errMsg = errMsg + "\nPassword Mismatch.";
					}
					if (uNameChkFlag == 'y'){
						if(uniqUnameChk=='n'){
							errMsg = errMsg + "\nUser Name Already exists.";
						}
					}
					else {
						errMsg = errMsg + "\nInvalid User Name.";
					}
					JOptionPane.showMessageDialog(null, errMsg);
				}
//				else if (!(flag == 'y') && flag1 == 'y' && flag3 == 'y' && flag2 == 'y')
//					JOptionPane.showMessageDialog(null, "Please Insert valid First name");
//				else if (!(flag1 == 'y') && flag == 'y' && flag3 == 'y' && flag2 == 'y')
//					JOptionPane.showMessageDialog(null, "Please Insert valid last name");
//				else if (!(flag2 == 'y') && flag == 'y' && flag1 == 'y' && flag3 == 'y')
//					{
//					JOptionPane.showMessageDialog(null, "Please insert valid User name");
//					}
//				
//				else if (!(flag3 == 'y'))
//					JOptionPane.showMessageDialog(null, "Passwords Dont Match");
//				else
//					JOptionPane.showMessageDialog(null, "Try to insert valid inputs");

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(registerButton, gbc_btnNewButton);
	}

	public void setLoginForm(JFrame login) {
		mLogin = login;
	}

}
