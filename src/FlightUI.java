import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import java.awt.List;
import javax.swing.JTextField;

public class FlightUI extends JFrame{
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightUI frame = new FlightUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FlightUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 1102, 661);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Arrival");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(903, 267, 117, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Departure");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartureInterface depUI = new DepartureInterface();
				//setEnabled(false);
			}
		});
		btnNewButton_1.setBounds(110, 267, 133, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Restaurant");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(601, 148, 117, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Finances");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(502, 148, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Shop");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_2.setBounds(403, 148, 89, 23);
		contentPane.add(btnNewButton_2_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Amsterdam", "Athens", "Bangkok", "Cairo", "Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Lisbon", "London", "Madrid", "Marrakesh", "Mexico City", "Moscow", "New York", "Paris", "Rome", "S\u00E3o Paulo", "Stockholm", "Sydney", "Texas", "Tokyo", "Toronto"}));
		comboBox.setBounds(110, 311, 133, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("res\\images\\BCA Logo.png"));
		lblNewLabel.setBounds(405, 12, 294, 110);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Amsterdam", "Athens", "Bangkok", "Cairo", "Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Lisbon", "London", "Madrid", "Marrakesh", "Mexico City", "Moscow", "New York", "Paris", "Rome", "S\u00E3o Paulo", "Stockholm", "Sydney"}));
		comboBox_1.setBounds(903, 311, 117, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("From:");
		lblNewLabel_1.setBounds(58, 315, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To:");
		lblNewLabel_2.setBounds(841, 315, 41, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Departure Times:");
		lblNewLabel_3.setBounds(10, 382, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Date:");
		lblNewLabel_5.setBounds(58, 348, 42, 14);
		contentPane.add(lblNewLabel_5);
		
		JList list = new JList();
		list.setBounds(110, 551, 78, -39);
		contentPane.add(list);
		
		JLabel lblNewLabel_6 = new JLabel("Date:");
		lblNewLabel_6.setBounds(829, 348, 53, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(864, 25, 185, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Passenger First Name:");
		lblNewLabel_7.setBounds(709, 29, 164, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Arrival Times:");
		lblNewLabel_5_1_1.setBounds(788, 382, 105, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(864, 56, 185, 23);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_7_1 = new JLabel("Passenger Last Name:");
		lblNewLabel_7_1.setBounds(709, 60, 164, 14);
		contentPane.add(lblNewLabel_7_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01/08/2021", "02/08/2021", "03/08/2021", "04/08/2021", "05/08/2021", "06/08/2021", "07/08/2021", "08/08/2021", "09/08/2021", "10/08/2021", "11/08/2021", "12/08/2021", "13/08/2021", "14/08/2021", "15/08/2021", "16/08/2021", "17/08/2021", "18/08/2021", "19/08/2021", "20/08/2021", "21/08/2021", "22/08/2021", "23/08/2021", "24/08/2021", "25/08/2021", "26/08/2021", "27/08/2021", "28/08/2021", "29/08/2021", "30/08/2021", "31/08/2021", "01/09/2021", "02/09/2021", "03/09/2021", "04/09/2021", "05/09/2021", "06/09/2021", "07/09/2021", "08/09/2021", "09/09/2021", "10/09/2021", "11/09/2021", "12/09/2021", "13/09/2021", "14/09/2021", "15/09/2021", "16/09/2021", "17/09/2021", "18/09/2021", "19/09/2021", "20/09/2021", "21/09/2021", "22/09/2021", "23/09/2021", "24/09/2021", "25/09/2021", "26/09/2021", "27/09/2021", "28/09/2021", "29/09/2021", "30/09/2021", "01/10/2021", "02/10/2021", "03/10/2021", "04/10/2021", "05/10/2021", "06/10/2021", "07/10/2021", "08/10/2021", "09/10/2021", "10/10/2021", "11/10/2021", "12/10/2021", "13/10/2021", "14/10/2021", "15/10/2021", "16/10/2021", "17/10/2021", "18/10/2021", "19/10/2021", "20/10/2021", "21/10/2021", "22/10/2021", "23/10/2021", "24/10/2021", "25/10/2021", "26/10/2021", "27/10/2021", "28/10/2021", "29/10/2021", "30/10/2021", "31/10/2021", "01/11/2021", "02/11/2021", "03/11/2021", "04/11/2021", "05/11/2021", "06/11/2021", "07/11/2021", "08/11/2021", "09/11/2021", "10/11/2021", "11/11/2021", "12/11/2021", "13/11/2021", "14/11/2021", "15/11/2021", "16/11/2021", "17/11/2021", "18/11/2021", "19/11/2021", "20/11/2021", "21/11/2021", "22/11/2021", "23/11/2021", "24/11/2021", "25/11/2021", "26/11/2021", "27/11/2021", "28/11/2021", "29/11/2021", "30/11/2021", "01/12/2021", "02/12/2021", "03/12/2021", "04/12/2021", "05/12/2021", "06/12/2021", "07/12/2021", "08/12/2021", "09/12/2021", "10/12/2021", "11/12/2021", "12/12/2021", "13/12/2021", "14/12/2021", "15/12/2021", "16/12/2021", "17/12/2021", "18/12/2021", "19/12/2021", "20/12/2021", "21/12/2021", "22/12/2021", "23/12/2021", "24/12/2021", "25/12/2021", "26/12/2021", "27/12/2021", "28/12/2021", "29/12/2021", "30/12/2021", "31/12/2021", "01/01/2022", "02/01/2022", "03/01/2022", "04/01/2022", "05/01/2022", "06/01/2022", "07/01/2022", "08/01/2022", "09/01/2022", "10/01/2022", "11/01/2022", "12/01/2022", "13/01/2022", "14/01/2022", "15/01/2022", "16/01/2022", "17/01/2022", "18/01/2022", "19/01/2022", "20/01/2022", "21/01/2022", "22/01/2022", "23/01/2022", "24/01/2022", "25/01/2022", "26/01/2022", "27/01/2022", "28/01/2022", "29/01/2022", "30/01/2022", "31/01/2022", "01/02/2022", "02/02/2022", "03/02/2022", "04/02/2022", "05/02/2022", "06/02/2022", "07/02/2022", "08/02/2022", "09/02/2022", "10/02/2022", "11/02/2022", "12/02/2022", "13/02/2022", "14/02/2022", "15/02/2022", "16/02/2022", "17/02/2022", "18/02/2022", "19/02/2022", "20/02/2022", "21/02/2022", "22/02/2022", "23/02/2022", "24/02/2022", "25/02/2022", "26/02/2022", "27/02/2022", "28/02/2022", "01/03/2022", "02/03/2022", "03/03/2022", "04/03/2022", "05/03/2022", "06/03/2022", "07/03/2022", "08/03/2022", "09/03/2022", "10/03/2022", "11/03/2022", "12/03/2022", "13/03/2022", "14/03/2022", "15/03/2022", "16/03/2022", "17/03/2022", "18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", "23/03/2022", "24/03/2022", "25/03/2022", "26/03/2022", "27/03/2022", "28/03/2022", "29/03/2022", "30/03/2022", "31/03/2022", "01/04/2022", "02/04/2022", "03/04/2022", "04/04/2022", "05/04/2022", "06/04/2022", "07/04/2022", "08/04/2022", "09/04/2022", "10/04/2022", "11/04/2022", "12/04/2022", "13/04/2022", "14/04/2022", "15/04/2022", "16/04/2022", "17/04/2022", "18/04/2022", "19/04/2022", "20/04/2022", "21/04/2022", "22/04/2022", "23/04/2022", "24/04/2022", "25/04/2022", "26/04/2022", "27/04/2022", "28/04/2022", "29/04/2022"}));
		comboBox_2.setBounds(110, 344, 133, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"01/08/2021", "02/08/2021", "03/08/2021", "04/08/2021", "05/08/2021", "06/08/2021", "07/08/2021", "08/08/2021", "09/08/2021", "10/08/2021", "11/08/2021", "12/08/2021", "13/08/2021", "14/08/2021", "15/08/2021", "16/08/2021", "17/08/2021", "18/08/2021", "19/08/2021", "20/08/2021", "21/08/2021", "22/08/2021", "23/08/2021", "24/08/2021", "25/08/2021", "26/08/2021", "27/08/2021", "28/08/2021", "29/08/2021", "30/08/2021", "31/08/2021", "01/09/2021", "02/09/2021", "03/09/2021", "04/09/2021", "05/09/2021", "06/09/2021", "07/09/2021", "08/09/2021", "09/09/2021", "10/09/2021", "11/09/2021", "12/09/2021", "13/09/2021", "14/09/2021", "15/09/2021", "16/09/2021", "17/09/2021", "18/09/2021", "19/09/2021", "20/09/2021", "21/09/2021", "22/09/2021", "23/09/2021", "24/09/2021", "25/09/2021", "26/09/2021", "27/09/2021", "28/09/2021", "29/09/2021", "30/09/2021", "01/10/2021", "02/10/2021", "03/10/2021", "04/10/2021", "05/10/2021", "06/10/2021", "07/10/2021", "08/10/2021", "09/10/2021", "10/10/2021", "11/10/2021", "12/10/2021", "13/10/2021", "14/10/2021", "15/10/2021", "16/10/2021", "17/10/2021", "18/10/2021", "19/10/2021", "20/10/2021", "21/10/2021", "22/10/2021", "23/10/2021", "24/10/2021", "25/10/2021", "26/10/2021", "27/10/2021", "28/10/2021", "29/10/2021", "30/10/2021", "31/10/2021", "01/11/2021", "02/11/2021", "03/11/2021", "04/11/2021", "05/11/2021", "06/11/2021", "07/11/2021", "08/11/2021", "09/11/2021", "10/11/2021", "11/11/2021", "12/11/2021", "13/11/2021", "14/11/2021", "15/11/2021", "16/11/2021", "17/11/2021", "18/11/2021", "19/11/2021", "20/11/2021", "21/11/2021", "22/11/2021", "23/11/2021", "24/11/2021", "25/11/2021", "26/11/2021", "27/11/2021", "28/11/2021", "29/11/2021", "30/11/2021", "01/12/2021", "02/12/2021", "03/12/2021", "04/12/2021", "05/12/2021", "06/12/2021", "07/12/2021", "08/12/2021", "09/12/2021", "10/12/2021", "11/12/2021", "12/12/2021", "13/12/2021", "14/12/2021", "15/12/2021", "16/12/2021", "17/12/2021", "18/12/2021", "19/12/2021", "20/12/2021", "21/12/2021", "22/12/2021", "23/12/2021", "24/12/2021", "25/12/2021", "26/12/2021", "27/12/2021", "28/12/2021", "29/12/2021", "30/12/2021", "31/12/2021", "01/01/2022", "02/01/2022", "03/01/2022", "04/01/2022", "05/01/2022", "06/01/2022", "07/01/2022", "08/01/2022", "09/01/2022", "10/01/2022", "11/01/2022", "12/01/2022", "13/01/2022", "14/01/2022", "15/01/2022", "16/01/2022", "17/01/2022", "18/01/2022", "19/01/2022", "20/01/2022", "21/01/2022", "22/01/2022", "23/01/2022", "24/01/2022", "25/01/2022", "26/01/2022", "27/01/2022", "28/01/2022", "29/01/2022", "30/01/2022", "31/01/2022", "01/02/2022", "02/02/2022", "03/02/2022", "04/02/2022", "05/02/2022", "06/02/2022", "07/02/2022", "08/02/2022", "09/02/2022", "10/02/2022", "11/02/2022", "12/02/2022", "13/02/2022", "14/02/2022", "15/02/2022", "16/02/2022", "17/02/2022", "18/02/2022", "19/02/2022", "20/02/2022", "21/02/2022", "22/02/2022", "23/02/2022", "24/02/2022", "25/02/2022", "26/02/2022", "27/02/2022", "28/02/2022", "01/03/2022", "02/03/2022", "03/03/2022", "04/03/2022", "05/03/2022", "06/03/2022", "07/03/2022", "08/03/2022", "09/03/2022", "10/03/2022", "11/03/2022", "12/03/2022", "13/03/2022", "14/03/2022", "15/03/2022", "16/03/2022", "17/03/2022", "18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", "23/03/2022", "24/03/2022", "25/03/2022", "26/03/2022", "27/03/2022", "28/03/2022", "29/03/2022", "30/03/2022", "31/03/2022", "01/04/2022", "02/04/2022", "03/04/2022", "04/04/2022", "05/04/2022", "06/04/2022", "07/04/2022", "08/04/2022", "09/04/2022", "10/04/2022", "11/04/2022", "12/04/2022", "13/04/2022", "14/04/2022", "15/04/2022", "16/04/2022", "17/04/2022", "18/04/2022", "19/04/2022", "20/04/2022", "21/04/2022", "22/04/2022", "23/04/2022", "24/04/2022", "25/04/2022", "26/04/2022", "27/04/2022", "28/04/2022", "29/04/2022"}));
		comboBox_2_1.setBounds(903, 344, 117, 22);
		contentPane.add(comboBox_2_1);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_2_2.setBounds(110, 378, 133, 22);
		contentPane.add(comboBox_2_2);
		
		JComboBox comboBox_2_3 = new JComboBox();
		comboBox_2_3.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_2_3.setBounds(903, 378, 117, 22);
		contentPane.add(comboBox_2_3);
	}
	

}

