package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLayer.userManagement.AllDishes;
import businessLayer.userManagement.AllOrder;
import businessLayer.userManagement.Dish;
import presentationLayer.UserMenu.placeOrder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtCount;
	private JTextField txtCountId[];
	ArrayList<Dish> dishArray;
	private JLabel lblDishes;
	private JLabel lblDishesID[];
	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	private JTextField txtDishname;
	private JButton btnPublishMenu;
	AllDishes dis = new AllDishes();
	AllOrder ordr = new AllOrder();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminMenu frame = new AdminMenu();
//					frame.setVisible(true);
//					frame.setTitle("Today's total Order");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminMenu() {
		// dis.setDishes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		populateUI();

	}

	private void populateUI() {
		dishArray = dis.getAllDishes();
		txtCountId = new JTextField[dishArray.size()];
		lblDishesID = new JLabel[dishArray.size()];

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		int i = 0;
		for (Dish d : dishArray) {
			lblDishes = new JLabel(d.getName(),SwingConstants.RIGHT);
			GridBagConstraints gbc_lblDishes = new GridBagConstraints();
			gbc_lblDishes.anchor = GridBagConstraints.WEST;
			gbc_lblDishes.insets = new Insets(0, 0, 5, 5);
			gbc_lblDishes.gridx = 0;
			gbc_lblDishes.gridy = y + 1;
			lblDishesID[i] = lblDishes;
			contentPane.add(lblDishes, gbc_lblDishes);

			txtCount = new JTextField();
			txtCount.setColumns(3);
			GridBagConstraints gbc_txtCount = new GridBagConstraints();
			gbc_txtCount.insets = new Insets(0, 0, 5, 5);
			gbc_txtCount.fill = GridBagConstraints.WEST;
			gbc_txtCount.gridx = 1;
			gbc_txtCount.gridy = y + 1;
			txtCountId[i] = txtCount;
			contentPane.add(txtCount, gbc_txtCount);
			// txtCount.setColumns(1);
			i++;
			y++;
		}

		JButton btnTotalOrders = new JButton("Total Orders");
		GridBagConstraints gbc_btnTotalOrders = new GridBagConstraints();
		gbc_btnTotalOrders.insets = new Insets(0, 0, 5, 5);
		gbc_btnTotalOrders.gridx = 2;
		gbc_btnTotalOrders.gridy = dishArray.size() + 3;
		contentPane.add(btnTotalOrders, gbc_btnTotalOrders);

		txtDishname = new JTextField();
		txtDishname.setText("DishName");
		GridBagConstraints gbc_txtDishname = new GridBagConstraints();
		gbc_txtDishname.insets = new Insets(0, 0, 0, 5);
		gbc_txtDishname.fill = GridBagConstraints.WEST;
		gbc_txtDishname.gridx = 1;
		gbc_txtDishname.gridy = dishArray.size() + 4;
		// contentPane.add(txtDishname, gbc_txtDishname);
		txtDishname.setColumns(10);

		btnPublishMenu = new JButton("Start taking Orders");
		GridBagConstraints gbc_btnPublishMenu = new GridBagConstraints();
		gbc_btnPublishMenu.gridx = 2;
		gbc_btnPublishMenu.gridy = dishArray.size() + 4;
		contentPane.add(btnPublishMenu, gbc_btnPublishMenu);

		TotalOrder TotalOdr = new TotalOrder();
		btnTotalOrders.addActionListener(TotalOdr);

		PublishMenu PublishMenu = new PublishMenu();
		btnPublishMenu.addActionListener(PublishMenu);
	}

	private void populateDishCount() {
		int i = 0;
		for (Dish d : dishArray) {

			txtCountId[i].setText(String.valueOf(ordr.getOrders(d.getName())));
			i++;
		}
	}

	class TotalOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			populateDishCount();
		}
	}

	class PublishMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// char enable='Y';
			if (btnPublishMenu.getText() == "Start taking Orders") {

				ordr.showMenu('Y');
				
				btnPublishMenu.setText("Stop taking Orders");
				populateDishCount();

			} else {
				int response = JOptionPane.showConfirmDialog(null,
						"You are about to cancel further Orders and the exisitng counter will be set to Zero. \nPlease retain the Exisitng Count.\n Do you Want to continue?",
						"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					ordr.resetOrders();
					ordr.showMenu('N');
					btnPublishMenu.setText("Start taking Orders");
					populateDishCount();
				}
				
			}

		}
	}

}
