package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import businessLayer.userManagement.AllDishes;
import businessLayer.userManagement.Dishes;
import businessLayer.userManagement.Orders;

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
	String selectedDishes = "";
	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	JCheckBox rbtDishes;
	ArrayList<Dishes> dishArray ;
//	Dishes[] dishArray ; //= AllDishes.getDishes();
	private JCheckBox checkButtons[] ;//= new JRadioButton[5];
	JCheckBox chckbxLunch;
	JCheckBox chckbxDinner;
	Orders ordr =new Orders();
	AllDishes dis = new AllDishes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu frame = new UserMenu();
					frame.setVisible(true);
					frame.setTitle("User's Menu");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/*	public void setDishes() {
		dishArray = new Dishes[] { 
									new Dishes(1,"Pizza", false), 
									new Dishes(2,"Pasta", false), 
									new Dishes(3,"Rice", false),
									new Dishes(4,"Chicken", false),
									new Dishes(5,"Steak", false), 
									new Dishes(6,"Burger", false), 
									new Dishes(7,"Noddles", false),
									new Dishes(8,"Soup", false) 
								};

	} */

	/**
	 * Create the frame.
	 */
	public UserMenu() {
		//AllDishes.setDishes();
//		dishArray = AllDishes.getDishes();
		//dis.setDishes();
		dishArray = dis.getDishes();
		System.out.println(dishArray.size());
		checkButtons = new JCheckBox[dishArray.size()];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 446, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
     	int i = 0;
		for (Dishes d : dishArray) {
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
        
        chckbxLunch = new JCheckBox("Lunch");
        GridBagConstraints gbc_chckbxLunch = new GridBagConstraints();
        gbc_chckbxLunch.anchor = GridBagConstraints.WEST;
        gbc_chckbxLunch.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxLunch.gridx = 1;
        gbc_chckbxLunch.gridy = 3;
        //contentPane.add(chckbxLunch, gbc_chckbxLunch);
        
        chckbxDinner = new JCheckBox("Dinner");
        GridBagConstraints gbc_chckbxDinner = new GridBagConstraints();
        gbc_chckbxDinner.anchor = GridBagConstraints.WEST;
        gbc_chckbxDinner.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxDinner.gridx = 1;
        gbc_chckbxDinner.gridy = 4;
        //contentPane.add(chckbxDinner, gbc_chckbxDinner);
        
        
        JButton placeOrder = new JButton("PlaceOrder");
		GridBagConstraints gbc_placeOrder = new GridBagConstraints();
		gbc_placeOrder.insets = new Insets(0, 0, 0, 5);
		gbc_placeOrder.gridx = 1;
		gbc_placeOrder.gridy = 13;
		contentPane.add(placeOrder, gbc_placeOrder);
		
		
		JButton publishOrder = new JButton("PublishOrders");
		GridBagConstraints gbc_publishOrder = new GridBagConstraints();
		gbc_publishOrder.fill = GridBagConstraints.VERTICAL;
		gbc_publishOrder.gridx = 2;
		gbc_publishOrder.gridy = 13;
		//contentPane.add(publishOrder, gbc_publishOrder);
		
		placeOrder placeOdr = new placeOrder();
		placeOrder.addActionListener(placeOdr);
		publishOrder publishOdr = new publishOrder();	
		publishOrder.addActionListener(publishOdr);
					
	}
    
	public class placeOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = 0;
            String selectedDishes="";
            char orderType;
/*            if(chckbxLunch.isSelected() && chckbxDinner.isSelected())
            {
            	orderType='B';
            }
            else if(chckbxLunch.isSelected() && !chckbxDinner.isSelected())
            {
            	orderType='L';
            }
            else if(!chckbxLunch.isSelected() && chckbxDinner.isSelected())
            {
            	orderType='D';
            }
            else orderType='U';
*/            
            
			for (Dishes d : dishArray) {
				// System.out.println(radioButtons[i].getText() +
				// radioButtons[i].isSelected());
				if (checkButtons[i].getText() == d.getName() && checkButtons[i].isSelected()) {
					selectedDishes += d.getDishID()+",";
				}
				i++;				
			}
			ordr.placeorder(selectedDishes, contentPane);
			
		}
	}
	
	class publishOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = 0;
			for (Dishes d : dishArray) {
				// System.out.println(radioButtons[i].getText() +
				// radioButtons[i].isSelected());
				if (checkButtons[i].getText() == d.getName() && checkButtons[i].isSelected()) {
					selectedDishes += d.getName();
				}
				i++;
			}
			//Orders.placeorder(selectedDishes, contentPane);
			
		}
	}

}
