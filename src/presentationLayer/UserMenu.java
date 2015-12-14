package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import businessLayer.userManagement.AllDishes;
import businessLayer.userManagement.Dish;
import businessLayer.userManagement.UserOrders;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	private String selectedDishes = "";
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private JCheckBox rbtDishes;
	private ArrayList<Dish> dishArray;
	// Dishes[] dishArray ; //= AllDishes.getDishes();
	private JCheckBox checkButtons[];// = new JRadioButton[5];
	// privateJCheckBox chckbxLunch;
	// JCheckBox chckbxDinner;
	private UserOrders ordr = new UserOrders();
	private AllDishes dis = new AllDishes();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserMenu frame = new UserMenu();
//					frame.setVisible(true);
//					frame.setTitle("User's Menu");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/*
	 * public void setDishes() { dishArray = new Dishes[] { new
	 * Dishes(1,"Pizza", false), new Dishes(2,"Pasta", false), new
	 * Dishes(3,"Rice", false), new Dishes(4,"Chicken", false), new
	 * Dishes(5,"Steak", false), new Dishes(6,"Burger", false), new
	 * Dishes(7,"Noddles", false), new Dishes(8,"Soup", false) };
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public UserMenu() {
		// AllDishes.setDishes();
		// dishArray = AllDishes.getDishes();
		// dis.setDishes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		if (ordr.getCurrUserOrderdDishes().size() == 0) {
			populateUI();
		} else {
			JLabel orderLabel = new JLabel();
			orderLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			String orders = "<html>Your Orders are: ";
			for (Dish d : ordr.getCurrUserOrderdDishes()) {
				orders = orders + " <BR> " + d.getName();
			}
			orders = orders + "</html>";
			System.out.println(orders);
			orderLabel.setText(orders);

			contentPane.add(orderLabel);
		}

	}

	public class placeOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = 0;
			String selectedDishes = "";
			char orderType;
			/*
			 * if(chckbxLunch.isSelected() && chckbxDinner.isSelected()) {
			 * orderType='B'; } else if(chckbxLunch.isSelected() &&
			 * !chckbxDinner.isSelected()) { orderType='L'; } else
			 * if(!chckbxLunch.isSelected() && chckbxDinner.isSelected()) {
			 * orderType='D'; } else orderType='U';
			 */

			for (Dish d : dishArray) {
				// System.out.println(radioButtons[i].getText() +
				// radioButtons[i].isSelected());
				if (checkButtons[i].getText() == d.getName() && checkButtons[i].isSelected()) {
					selectedDishes += d.getDishID() + ",";
				}
				i++;
			}
			ordr.placeorder(selectedDishes, contentPane);
			contentPane.removeAll();
			
			JLabel orderLabel = new JLabel();
			orderLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			String orders = "<html>Your Orders are: ";
			for (Dish d : ordr.getCurrUserOrderdDishes()) {
				orders = orders + " <BR> " + d.getName();
			}
			orders = orders + "</html>";
			System.out.println(orders);
			orderLabel.setText(orders);

			contentPane.add(orderLabel);
			contentPane.revalidate();
			repaint();
		}
	}

	// class publishOrder implements ActionListener {
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// int i = 0;
	// for (Dishes d : dishArray) {
	// // System.out.println(radioButtons[i].getText() +
	// // radioButtons[i].isSelected());
	// if (checkButtons[i].getText() == d.getName() &&
	// checkButtons[i].isSelected()) {
	// selectedDishes += d.getName();
	// }
	// i++;
	// }
	// // Orders.placeorder(selectedDishes, contentPane);
	//
	// }
	// }

	private void populateUI() {
		dishArray = dis.getCurrDishes();
		System.out.println(dishArray.size());
		checkButtons = new JCheckBox[dishArray.size()];
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 446, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		int i = 0;
		for (Dish d : dishArray) {
			// JLabel lblDishes = new JLabel(d.name);
			GridBagConstraints gbc_lblNewDishes = new GridBagConstraints();
			gbc_lblNewDishes.anchor = GridBagConstraints.WEST;
			gbc_lblNewDishes.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewDishes.gridx = x;
			gbc_lblNewDishes.gridy = y;
			rbtDishes = new JCheckBox(d.getName());
			checkButtons[i] = rbtDishes;
			contentPane.add(checkButtons[i], gbc_lblNewDishes);
			y++;
			i++;
		}
		JLabel lblHeading = new JLabel("Welcome to the Ordering page.");
		GridBagConstraints gbc_lblHeading = new GridBagConstraints();
		gbc_lblHeading.gridheight = 2;
		gbc_lblHeading.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeading.gridx = 1;
		gbc_lblHeading.gridy = 0;
		contentPane.add(lblHeading, gbc_lblHeading);

		// chckbxLunch = new JCheckBox("Lunch");
		// GridBagConstraints gbc_chckbxLunch = new GridBagConstraints();
		// gbc_chckbxLunch.anchor = GridBagConstraints.WEST;
		// gbc_chckbxLunch.insets = new Insets(0, 0, 5, 5);
		// gbc_chckbxLunch.gridx = 1;
		// gbc_chckbxLunch.gridy = 3;
		// contentPane.add(chckbxLunch, gbc_chckbxLunch);
		//
		// chckbxDinner = new JCheckBox("Dinner");
		// GridBagConstraints gbc_chckbxDinner = new GridBagConstraints();
		// gbc_chckbxDinner.anchor = GridBagConstraints.WEST;
		// gbc_chckbxDinner.insets = new Insets(0, 0, 5, 5);
		// gbc_chckbxDinner.gridx = 1;
		// gbc_chckbxDinner.gridy = 4;
		// contentPane.add(chckbxDinner, gbc_chckbxDinner);

		JButton placeOrder = new JButton("Place Order");
		GridBagConstraints gbc_placeOrder = new GridBagConstraints();
		gbc_placeOrder.insets = new Insets(0, 0, 0, 5);
		gbc_placeOrder.gridx = 1;
		gbc_placeOrder.gridy = 13;
		contentPane.add(placeOrder, gbc_placeOrder);

		// JButton publishOrder = new JButton("PublishOrders");
		// GridBagConstraints gbc_publishOrder = new GridBagConstraints();
		// gbc_publishOrder.fill = GridBagConstraints.VERTICAL;
		// gbc_publishOrder.gridx = 2;
		// gbc_publishOrder.gridy = 13;
		// contentPane.add(publishOrder, gbc_publishOrder);

		placeOrder placeOdr = new placeOrder();
		placeOrder.addActionListener(placeOdr);
		// publishOrder publishOdr = new publishOrder();
		// publishOrder.addActionListener(publishOdr);
	}

}
