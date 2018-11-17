package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	JFrame frmThuaSi;
	private final JLabel lblThuaSi = new JLabel("Chon chuc nang!");
	private final JButton btnThua = new JButton("Quản lý thuê trả");
	private final JButton btnQunLKhch = new JButton("Quản lý khách hàng");
	private final JButton btnQunLH = new JButton("Quản lý hồ sơ trả trễ");
	private final JButton btnQunTnKho = new JButton("Quản lý dat truoc");
	private final JButton btnBoThngK = new JButton("Cập nhật");
	private final JButton btnQunLTiu = new JButton("Quản lý tiêu đề");
	private final JButton button = new JButton("Báo thống kê");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmThuaSi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThuaSi = new JFrame();
		frmThuaSi.setTitle("Ung dung Bang Dia");
		frmThuaSi.setBounds(100, 100, 518, 300);
		frmThuaSi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThuaSi.getContentPane().setLayout(null);
		lblThuaSi.setBounds(208, 11, 103, 36);
		
		frmThuaSi.getContentPane().add(lblThuaSi);
		btnThua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThuaSi.dispose();
				UIQuanlyThueTra window = new UIQuanlyThueTra();
				window.getFrmSearchMovie().setVisible(true);
				
			}
		});
		btnThua.setBounds(50, 44, 167, 36);
		
		frmThuaSi.getContentPane().add(btnThua);
		btnQunLKhch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UiThemKhach window = new UiThemKhach();
				window.getFrmAddMove().setVisible(true);
				frmThuaSi.dispose();
			}
		});
		btnQunLKhch.setBounds(274, 44, 142, 36);
		
		frmThuaSi.getContentPane().add(btnQunLKhch);
		btnQunLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dang trong qua trinh XAY DUNG!", "Err",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQunLH.setBounds(50, 104, 167, 36);
		
		frmThuaSi.getContentPane().add(btnQunLH);
		btnQunTnKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dang trong qua trinh XAY DUNG!", "Err",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQunTnKho.setBounds(274, 104, 142, 36);
		
		frmThuaSi.getContentPane().add(btnQunTnKho);
		btnBoThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dang trong qua trinh XAY DUNG!", "Err",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnBoThngK.setBounds(50, 165, 167, 36);
		
		frmThuaSi.getContentPane().add(btnBoThngK);
		btnQunLTiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dang trong qua trinh XAY DUNG!", "Err",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnQunLTiu.setBounds(274, 165, 142, 36);
		
		frmThuaSi.getContentPane().add(btnQunLTiu);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Dang trong qua trinh XAY DUNG!", "Err",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBounds(189, 212, 135, 36);
		
		frmThuaSi.getContentPane().add(button);
	}
}
