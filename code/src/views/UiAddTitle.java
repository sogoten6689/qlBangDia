package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.TieuDe;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class UiAddTitle {

	private JFrame frmAddMove;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiAddTitle window = new UiAddTitle();
					window.getFrmAddMove().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UiAddTitle() {
		initialize(new TieuDe("adsf","asdf","okok",4,5,6));
	}
//	public UiAdd(ArrayList< > list) {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmAddMove(new JFrame());
		getFrmAddMove().setTitle("Add move");
		getFrmAddMove().setBounds(100, 100, 450, 300);
		getFrmAddMove().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmAddMove().getContentPane().setLayout(null);
		
		JLabel lblNewMove = new JLabel("New move");
		lblNewMove.setBounds(173, 11, 97, 14);
		getFrmAddMove().getContentPane().add(lblNewMove);
		
		JLabel lblIdTitle = new JLabel("Id Title:");
		lblIdTitle.setBounds(49, 33, 69, 14);
		getFrmAddMove().getContentPane().add(lblIdTitle);
		
		textField = new JTextField();
		textField.setBounds(151, 30, 167, 20);
		getFrmAddMove().getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 58, 167, 20);
		getFrmAddMove().getContentPane().add(textField_1);
		
		JLabel lblNameTitle = new JLabel("Name Title:");
		lblNameTitle.setBounds(49, 61, 69, 14);
		getFrmAddMove().getContentPane().add(lblNameTitle);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 89, 167, 20);
		getFrmAddMove().getContentPane().add(textField_2);
		
		JLabel lblNiDung = new JLabel("Nội dung");
		lblNiDung.setBounds(49, 92, 69, 14);
		getFrmAddMove().getContentPane().add(lblNiDung);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 120, 167, 20);
		getFrmAddMove().getContentPane().add(textField_3);
		
		JLabel lblReplica = new JLabel("Replica");
		lblReplica.setBounds(49, 123, 69, 14);
		getFrmAddMove().getContentPane().add(lblReplica);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 151, 167, 20);
		getFrmAddMove().getContentPane().add(textField_4);
		
		JLabel lblRented = new JLabel("Rented");
		lblRented.setBounds(49, 154, 69, 14);
		getFrmAddMove().getContentPane().add(lblRented);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(151, 182, 167, 20);
		getFrmAddMove().getContentPane().add(textField_5);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(49, 185, 69, 14);
		getFrmAddMove().getContentPane().add(lblPrice);
		
		JButton btnAddMove = new JButton("Add move");
		btnAddMove.setBounds(29, 210, 89, 23);
		getFrmAddMove().getContentPane().add(btnAddMove);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(161, 210, 89, 23);
		getFrmAddMove().getContentPane().add(btnReload);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIQuanlyThueTra window = new UIQuanlyThueTra();
				window.getFrmSearchMovie().setVisible(true);
				getFrmAddMove().dispose();
			}
		});
		btnBack.setBounds(291, 213, 89, 23);
		getFrmAddMove().getContentPane().add(btnBack);
	}

	private void initialize(TieuDe title) {
		setFrmAddMove(new JFrame());
		getFrmAddMove().setTitle("Update phim");
		getFrmAddMove().setBounds(100, 100, 450, 300);
		getFrmAddMove().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmAddMove().getContentPane().setLayout(null);
		
		JLabel lblNewMove = new JLabel("Update move");
		lblNewMove.setBounds(173, 11, 97, 14);
		getFrmAddMove().getContentPane().add(lblNewMove);
		
		JLabel lblIdTitle = new JLabel("Id Title:");
		lblIdTitle.setBounds(49, 33, 69, 14);
		getFrmAddMove().getContentPane().add(lblIdTitle);
		
		textField = new JTextField();
		textField.setBounds(151, 30, 167, 20);
		getFrmAddMove().getContentPane().add(title.getIdTitle(), textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 58, 167, 20);
		getFrmAddMove().getContentPane().add(textField_1);
		
		JLabel lblNameTitle = new JLabel("Name Title:");
		lblNameTitle.setBounds(49, 61, 69, 14);
		getFrmAddMove().getContentPane().add(lblNameTitle);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 89, 167, 20);
		getFrmAddMove().getContentPane().add(textField_2);
		
		JLabel lblNiDung = new JLabel("Nội dung");
		lblNiDung.setBounds(49, 92, 69, 14);
		getFrmAddMove().getContentPane().add(lblNiDung);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 120, 167, 20);
		getFrmAddMove().getContentPane().add(textField_3);
		
		JLabel lblReplica = new JLabel("Replica");
		lblReplica.setBounds(49, 123, 69, 14);
		getFrmAddMove().getContentPane().add(lblReplica);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 151, 167, 20);
		getFrmAddMove().getContentPane().add(textField_4);
		
		JLabel lblRented = new JLabel("Rented");
		lblRented.setBounds(49, 154, 69, 14);
		getFrmAddMove().getContentPane().add(lblRented);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(151, 182, 167, 20);
		getFrmAddMove().getContentPane().add(textField_5);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(49, 185, 69, 14);
		getFrmAddMove().getContentPane().add(lblPrice);
		
		JButton btnAddMove = new JButton("Add move");
		btnAddMove.setBounds(29, 210, 89, 23);
		getFrmAddMove().getContentPane().add(btnAddMove);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(161, 210, 89, 23);
		getFrmAddMove().getContentPane().add(btnReload);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIQuanlyThueTra window = new UIQuanlyThueTra();
				window.getFrmSearchMovie().setVisible(true);
				getFrmAddMove().dispose();
			}
		});
		btnBack.setBounds(291, 213, 89, 23);
		getFrmAddMove().getContentPane().add(btnBack);
	}

	public JFrame getFrmAddMove() {
		return frmAddMove;
	}

	public void setFrmAddMove(JFrame frmAddMove) {
		this.frmAddMove = frmAddMove;
	}

}
