package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DsKhachHang;
import model.KhachHang;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UiThemKhach {

	private JFrame frmAddMove;
	private JTextField textFieldTen;
	private JTextField textFieldsoDT;
	private JTextField textFielddiaChi;
	private final JScrollPane scrollPaneKhachHang = new JScrollPane();
	JTable tableKhachHang = new JTable();
	private DsKhachHang dsKhachHang = new DsKhachHang();
	JButton btnCapNhat = new JButton("Cap nhat");
	KhachHang khachHang;
	private ArrayList<KhachHang> listAllKhachHang = dsKhachHang.taiDsKhachHang();
	private DefaultTableModel defaultTableModeKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiThemKhach window = new UiThemKhach();
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
	public UiThemKhach() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setFrmAddMove(new JFrame());
		getFrmAddMove().setTitle("Quản lý khách hàng");
		getFrmAddMove().setBounds(100, 100, 704, 391);
		getFrmAddMove().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmAddMove().getContentPane().setLayout(null);

		JLabel lblNewMove = new JLabel("Quản lý khách hàng");
		lblNewMove.setBounds(253, 11, 144, 14);
		getFrmAddMove().getContentPane().add(lblNewMove);

		textFieldTen = new JTextField();
		textFieldTen.setColumns(10);
		textFieldTen.setBounds(273, 36, 167, 20);
		getFrmAddMove().getContentPane().add(textFieldTen);

		JLabel lblNameTitle = new JLabel("*Tên khách:");
		lblNameTitle.setBounds(171, 39, 69, 14);
		getFrmAddMove().getContentPane().add(lblNameTitle);

		textFieldsoDT = new JTextField();
		textFieldsoDT.setColumns(10);
		textFieldsoDT.setBounds(273, 67, 167, 20);
		getFrmAddMove().getContentPane().add(textFieldsoDT);

		JLabel lblNiDung = new JLabel("*Số điện thoại:");
		lblNiDung.setBounds(171, 70, 92, 14);
		getFrmAddMove().getContentPane().add(lblNiDung);

		textFielddiaChi = new JTextField();
		textFielddiaChi.setColumns(10);
		textFielddiaChi.setBounds(273, 98, 167, 20);
		getFrmAddMove().getContentPane().add(textFielddiaChi);

		JLabel lblReplica = new JLabel("Địa chỉ:");
		lblReplica.setBounds(181, 101, 69, 14);
		getFrmAddMove().getContentPane().add(lblReplica);

		JButton btnThemKH = new JButton("Them khach");
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldsoDT.getText().equals("") && !textFieldTen.getText().equals("")
						&& textFieldsoDT.getText().matches("\\d+") && textFieldsoDT.getDocument().getLength() == 10) {
					int check = 0;
					for (KhachHang hang : listAllKhachHang) {
						if (textFieldsoDT.getText().equals(hang.getsoDT()))
							check = 1;
					}
					if (check == 0) {
						khachHang = new KhachHang(textFieldsoDT.getText(), textFielddiaChi.getText(),
								textFieldTen.getText(), textFieldsoDT.getText());
						dsKhachHang.taoKhachHang(khachHang);
						frmAddMove.dispose();
						JOptionPane.showMessageDialog(null, "Da thue thanh cong!");
						UiThemKhach window = new UiThemKhach();
						window.getFrmAddMove().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Trung so dien thoai!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Loi so dien thoai hoac ten khach hang!");
				}
			}

		});
		btnThemKH.setBounds(513, 35, 118, 23);
		getFrmAddMove().getContentPane().add(btnThemKH);

		JButton btnTaiLai = new JButton("Tai lai");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddMove.dispose();
				UiThemKhach window = new UiThemKhach();
				window.getFrmAddMove().setVisible(true);
			}
		});
		btnTaiLai.setBounds(513, 97, 118, 23);
		getFrmAddMove().getContentPane().add(btnTaiLai);

		JButton btnBack = new JButton("Tro ve");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.frmThuaSi.setVisible(true);
				getFrmAddMove().dispose();
			}
		});
		btnBack.setBounds(420, 318, 89, 23);
		getFrmAddMove().getContentPane().add(btnBack);

		JButton btnChonKH = new JButton("Chon khach");
		btnChonKH.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int select = -1;
				select = tableKhachHang.getSelectedRow();
				if (!tableKhachHang.isRowSelected(select)) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khach hang bat ki!");
				} else {
					String tenKH = (String) tableKhachHang.getValueAt(select, 1);
					String soDT = (String) tableKhachHang.getValueAt(select, 2);
					String diaChi = (String) tableKhachHang.getValueAt(select, 3);
					textFielddiaChi.setText(diaChi);
					textFieldsoDT.setText(soDT);
					textFieldsoDT.setEditable(false);
					textFieldTen.setText(tenKH);
					btnThemKH.setEnabled(false);
					btnCapNhat.setEnabled(true);
				}
			}
		});
		btnChonKH.setBounds(174, 318, 118, 23);
		frmAddMove.getContentPane().add(btnChonKH);

		btnCapNhat.setEnabled(false);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldTen.getText().equals("")) {
					if (dsKhachHang.CapNhatKH(textFieldsoDT.getText(), textFieldTen.getText(),
							textFielddiaChi.getText())) {
						frmAddMove.dispose();
						JOptionPane.showMessageDialog(null, "Cap nhat Thanh Cong!");
						UiThemKhach window = new UiThemKhach();
						window.getFrmAddMove().setVisible(true);
					}

					else {

						JOptionPane.showMessageDialog(null, "Khong cap nhat duoc!");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Ten khach hang loi!");
				}
			}
		});
		btnCapNhat.setBounds(513, 66, 118, 23);
		frmAddMove.getContentPane().add(btnCapNhat);
		scrollPaneKhachHang.setBounds(46, 136, 619, 171);

		frmAddMove.getContentPane().add(scrollPaneKhachHang);
		String[] rowKhachHang = { "Stt", "Ten Khach hang", "So dien thoai", "Dia chi", "Tre hen" };
		defaultTableModeKhachHang = new DefaultTableModel(null, rowKhachHang);
		AddDefaultTableModelKhachHang(listAllKhachHang);

		tableKhachHang.setModel(defaultTableModeKhachHang);
		scrollPaneKhachHang.setViewportView(tableKhachHang);

	}

	private void AddDefaultTableModelKhachHang(ArrayList<KhachHang> listKhachHang) {
		int stt = 1;
		for (KhachHang khachHangThem : listKhachHang) {
			Object[] rowdata = { stt, khachHangThem.gettenKH(), khachHangThem.getsoDT(), khachHangThem.getdiaChi(), 0 };
			defaultTableModeKhachHang.addRow(rowdata);
			stt++;
		}
	}

	private void RemoveDefaultTableModel(DefaultTableModel defaultTableModel) {
		for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--)
			defaultTableModel.removeRow(i);
	}

	public JFrame getFrmAddMove() {
		return frmAddMove;
	}

	public void setFrmAddMove(JFrame frmAddMove) {
		this.frmAddMove = frmAddMove;
	}
}
