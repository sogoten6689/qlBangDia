package views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DsCtPhieuThue;
import controller.DsDia;
import controller.DsKhachHang;
import controller.DsPhieuDat;
import controller.DsPhieuThue;
import controller.DsTieuDe;
import model.ChiTietPhieuThue;
import model.Dia;
import model.KhachHang;
import model.PhieuDat;
import model.PhieuThue;
import model.TieuDe;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UIQuanlyThueTra {
	int bienDat=0;
	int biendem = 0;
	private DsPhieuDat dsPhieuDat = new DsPhieuDat();
	ArrayList<PhieuDat> listAllPhieuDat = dsPhieuDat.taiPhieuDat();
	private DsDia dsDia = new DsDia();
	private ArrayList<Dia> listDia = dsDia.taiDsDiaRanh();
	private DsPhieuThue dsPhieuThue = new DsPhieuThue();
	private ArrayList<PhieuThue> listAllPhieuThue = dsPhieuThue.taiPhieuThue();
	private DsCtPhieuThue dsCtPhieuThue = new DsCtPhieuThue();
	private ArrayList<ChiTietPhieuThue> listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThue();
	private DsKhachHang dsKhachHang = new DsKhachHang();
	private ArrayList<KhachHang> listAllKhachHang = dsKhachHang.taiDsKhachHang();
	private JFrame frmSearchMovie;
	private JTextField textFieldSearch;
	public JPanel contentPane;
	private DefaultTableModel defaultTableModelTitle;
	private DefaultTableModel defaultTableModelCtPhieuThue;
	private DsTieuDe titleList = new DsTieuDe();
	private ArrayList<TieuDe> list = titleList.loadData();
	private DsTieuDe titleListall = new DsTieuDe();
	private ArrayList<TieuDe> listall = titleListall.loadData();
	private DsCtPhieuThue ctPhieuThue = new DsCtPhieuThue();
	private ArrayList<ChiTietPhieuThue> listCtPhieuThue = ctPhieuThue.taiDsCTPhieuThue();
	JTable JTableTieuDe = new JTable();
	private final JButton btnThue = new JButton("Thêm");
	private final JButton btnTra = new JButton("Trả đĩa cũ");
	private final JScrollPane scrollPanePhieuThue = new JScrollPane();
	JTable JTablePhieuThue = new JTable();
	PhieuThue phieuThue;
	ChiTietPhieuThue chiTietPhieuThue = new ChiTietPhieuThue();
	private final JLabel lblTmKhchHng = new JLabel("Tìm khách hàng:");
	private JComboBox<String> comboBox = new JComboBox<String>();

	private final JLabel lblDanhScha = new JLabel("Danh sách đĩa");
	private final JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
	private final JTextField textFieldTenKhach = new JTextField();
	private final JLabel lblAnhch = new JLabel("Anh/chị:");
	private final JLabel lblSinThoi = new JLabel("Số điện thoại:");
	private final JTextField textFieldSdtKhach = new JTextField();
	private final JLabel lblaCh = new JLabel("Địa chỉ:");
	private final JTextField textFieldDiachiKhach = new JTextField();
	private final JButton btnB = new JButton("Bỏ");
	private final JButton btnThuNgay = new JButton("Thuê ngay!");
	private final JButton btnTrNTr = new JButton("Trả nợ trễ");
	private final JLabel lblTngTin = new JLabel("Tổng tiền:");
	private final JTextField textFieldTongTien = new JTextField();
	private final JButton btnHome = new JButton("Home");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIQuanlyThueTra window = new UIQuanlyThueTra();
					window.frmSearchMovie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrmSearchMovie() {
		return frmSearchMovie;
	}

	public void setFrmSearchMovie(JFrame frmSearchMovie) {
		this.frmSearchMovie = frmSearchMovie;
	}

	/**
	 * Create the application.
	 */
	public UIQuanlyThueTra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setBounds(578, 348, 158, 20);
		textFieldTongTien.setColumns(10);
		textFieldTenKhach.setEditable(false);
		textFieldTenKhach.setBounds(590, 34, 146, 20);
		textFieldTenKhach.setColumns(10);
		frmSearchMovie = new JFrame();
		frmSearchMovie.setTitle("Quản lý thuê trả");
		frmSearchMovie.setBounds(100, 100, 902, 420);
		frmSearchMovie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearchMovie.getContentPane().setLayout(null);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textSearch = textFieldSearch.getText();
				RemoveDefaultTableModel(defaultTableModelTitle);
				list.clear();
				if (textSearch.equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy viết tên đĩa cần thuê!", "Err",
							JOptionPane.INFORMATION_MESSAGE);

					list = titleList.loadData();
				} else {
					list = titleList.loadData(textSearch);
				}
				for (ChiTietPhieuThue chiTietPhieuThuecheck : listCtPhieuThue) {
					String checkma = chiTietPhieuThuecheck.getMaDia();
					checkma = removeCharAt(checkma, checkma.length() - 1);
					checkListTieuDe(checkma);
				}
				AddDefaultTableModelTieuDe(list);
				JTableTieuDe.setModel(defaultTableModelTitle);
			}
		});
		btnSearch.setBounds(295, 96, 89, 23);
		frmSearchMovie.getContentPane().add(btnSearch);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 97, 264, 20);
		frmSearchMovie.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		// load table Title here
		JScrollPane JScrollPaneTieuDe = new JScrollPane();
		JScrollPaneTieuDe.setBounds(10, 128, 374, 242);
		frmSearchMovie.getContentPane().add(JScrollPaneTieuDe);

		String[] tab = { "Ma dia", "Ten dia", "Noi dung", "Ban sao", "Da thue", "Gia" };
		defaultTableModelTitle = new DefaultTableModel(null, tab);
		AddDefaultTableModelTieuDe(list);

		JTableTieuDe.setModel(defaultTableModelTitle);

		JScrollPaneTieuDe.setViewportView(JTableTieuDe);
		btnThue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				int select = -1;
				select = JTableTieuDe.getSelectedRow();
				if (!textFieldSdtKhach.getText().equals("")) {

					if (!JTableTieuDe.isRowSelected(select)) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn một đĩa muốn thêm!");
					} else {
						if (Integer.parseInt((String) JTableTieuDe.getValueAt(select, 4)) == Integer
								.parseInt((String) JTableTieuDe.getValueAt(select, 3))) {
							int i = okcancel("Dia da het! Ban muon dat dia k ?");
							System.out.println(i);
							if (i == 0) {
								String a;
								String maTieuDe = "";
								float gia = 0;
								int count = 1;
								try {
									do {
										a = JOptionPane.showInputDialog(null, "Nhập số ngay can thue khi nhan dia");
										if (a.matches("\\d+")) {
											count = Integer.valueOf(a);
											maTieuDe = (String) JTableTieuDe.getValueAt(select, 0);
											gia = Float.parseFloat((String) JTableTieuDe.getValueAt(select, 5));

										} else {
											JOptionPane.showMessageDialog(null, "Nhập sai! Vui long nhap lai so ngay!");
										}
									} while (!a.matches("\\d+") || count == 0);
								} catch (NullPointerException e1) {
									JOptionPane.showMessageDialog(null, "Lỗi");
								}
								int maPhieuDat =listAllPhieuDat.size()+bienDat;
								bienDat++;
								
								PhieuDat dat = new PhieuDat("MPDAT600"+maPhieuDat, maTieuDe, textFieldSdtKhach.getText(), count,0, gia*count);
								if(!dsPhieuDat.taoPhieuDat(dat))
									JOptionPane.showMessageDialog(null, "K dat dc!");
								frmSearchMovie.dispose();
								JOptionPane.showMessageDialog(null, "Da dat thanh cong!");
								UIQuanlyThueTra window = new UIQuanlyThueTra();
								window.getFrmSearchMovie().setVisible(true);
							}

						} else {
							if (JTableTieuDe.isRowSelected(select)/**/) {

								String a;
								String madia = "";
								String maTieuDe = "";
								float gia = 0;
								int count = 1;
								try {
									do {
										a = JOptionPane.showInputDialog(null, "Nhập số ngay can thue");
										if (a.matches("\\d+")) {
											count = Integer.valueOf(a);
											maTieuDe = (String) JTableTieuDe.getValueAt(select, 0);
											madia = getMaDia(maTieuDe);

											float matamdia = Float
													.parseFloat((String) JTableTieuDe.getValueAt(select, 4));
											int intmadia = (int) matamdia + 1;
											madia = maTieuDe + intmadia;
											gia = Float.parseFloat((String) JTableTieuDe.getValueAt(select, 5));

										} else {
											JOptionPane.showMessageDialog(null, "Nhập sai! Vui long nhap lai so ngay!");
										}
									} while (!a.matches("\\d+") || count == 0);

								} catch (NullPointerException e1) {
									JOptionPane.showMessageDialog(null, "Lỗi");
								}
								if (!maTieuDe.equals("")) {
									int matam = listAllPhieuThue.size() + 1;
									String mapt = "PT00" + matam;
									matam = listAllCTPhieuThue.size() + 1 + biendem;
									String mactpt = "CTPT00" + matam;
									chiTietPhieuThue = new ChiTietPhieuThue(mactpt, mapt, textFieldSdtKhach.getText(),
											new Date(System.currentTimeMillis()), null, count, gia, madia, 0);
									listCtPhieuThue.add(chiTietPhieuThue);
									RemoveDefaultTableModel(defaultTableModelCtPhieuThue);
									AddDefaultTableModelPhieuThue(listCtPhieuThue);
									checkListTieuDe(maTieuDe);
									RemoveDefaultTableModel(defaultTableModelTitle);
									AddDefaultTableModelTieuDe(list);
									biendem++;

								}
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Chọn khách trước!");
				}
			}
		});
		btnThue.setBounds(394, 145, 77, 23);

		frmSearchMovie.getContentPane().add(btnThue);
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UiQuanLyTra window = new UiQuanLyTra();
				window.getfrmTraDia().setVisible(true);
				frmSearchMovie.dispose();
			}
		});
		btnTra.setBounds(756, 33, 101, 23);

		frmSearchMovie.getContentPane().add(btnTra);
		scrollPanePhieuThue.setBounds(481, 128, 395, 205);

		frmSearchMovie.getContentPane().add(scrollPanePhieuThue);

		String[] hangtenCtPhieuThue = { "ma dia", "ten Tieu De", "So ngay thue", "Gia", "Thanh Tien" };
		defaultTableModelCtPhieuThue = new DefaultTableModel(null, hangtenCtPhieuThue);
		listCtPhieuThue = new ArrayList<ChiTietPhieuThue>();
		AddDefaultTableModelPhieuThue(listCtPhieuThue);
		JTablePhieuThue.setModel(defaultTableModelCtPhieuThue);
		scrollPanePhieuThue.setViewportView(JTablePhieuThue);
		lblTmKhchHng.setBounds(10, 15, 117, 14);

		frmSearchMovie.getContentPane().add(lblTmKhchHng);
		comboBox.addItem("Chọn số điện thoại khách");
		for (KhachHang khachHangTen : listAllKhachHang) {
			comboBox.addItem(khachHangTen.getMaKh());
		}
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object item = event.getItem();
					for (KhachHang khachHangTim : listAllKhachHang) {
						if (khachHangTim.getMaKh().equals(item)) {
							textFieldTenKhach.setText(khachHangTim.gettenKH());
							textFieldSdtKhach.setText(khachHangTim.getsoDT());
							textFieldDiachiKhach.setText(khachHangTim.getdiaChi());
							list = titleList.loadData();
							listCtPhieuThue.clear();
							RemoveDefaultTableModel(defaultTableModelCtPhieuThue);
							AddDefaultTableModelPhieuThue(listCtPhieuThue);
							RemoveDefaultTableModel(defaultTableModelTitle);
							AddDefaultTableModelTieuDe(list);
						}
					}
				}
			}
		});
		comboBox.setBounds(149, 11, 235, 22);

		frmSearchMovie.getContentPane().add(comboBox);
		lblDanhScha.setBounds(119, 51, 108, 14);

		frmSearchMovie.getContentPane().add(lblDanhScha);
		lblNewLabel.setBounds(578, 10, 126, 19);

		frmSearchMovie.getContentPane().add(lblNewLabel);

		frmSearchMovie.getContentPane().add(textFieldTenKhach);
		lblAnhch.setBounds(483, 37, 77, 14);

		frmSearchMovie.getContentPane().add(lblAnhch);
		lblSinThoi.setBounds(483, 68, 77, 14);

		frmSearchMovie.getContentPane().add(lblSinThoi);
		textFieldSdtKhach.setEditable(false);
		textFieldSdtKhach.setColumns(10);
		textFieldSdtKhach.setBounds(590, 65, 146, 20);

		frmSearchMovie.getContentPane().add(textFieldSdtKhach);
		lblaCh.setBounds(483, 96, 77, 14);

		frmSearchMovie.getContentPane().add(lblaCh);
		textFieldDiachiKhach.setEditable(false);
		textFieldDiachiKhach.setColumns(10);
		textFieldDiachiKhach.setBounds(590, 93, 146, 20);

		frmSearchMovie.getContentPane().add(textFieldDiachiKhach);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = -1;
				select = JTablePhieuThue.getSelectedRow();
				if (!JTablePhieuThue.isRowSelected(select)) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một đĩa muốn bỏ!");
				} else {

					String madia = (String) JTablePhieuThue.getValueAt(select, 0);

					if (!madia.equals("")) {
						checkListPhieuThue(madia);
						RemoveDefaultTableModel(defaultTableModelCtPhieuThue);
						AddDefaultTableModelPhieuThue(listCtPhieuThue);
						RemoveDefaultTableModel(defaultTableModelTitle);
						list = titleList.loadData();
						AddDefaultTableModelTieuDe(list);
					} else {
						System.out.println("madia loi");
					}
				}
			}
		});
		btnB.setBounds(394, 199, 77, 23);

		frmSearchMovie.getContentPane().add(btnB);
		btnThuNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textFieldSdtKhach.getText().equals("") && listCtPhieuThue.size() != 0) {
					int matam = listAllPhieuThue.size() + 1;
					String mapt = "PT00" + matam;
					PhieuThue phieuThueMoi = new PhieuThue(mapt, textFieldSdtKhach.getText(),
							new Date(System.currentTimeMillis()), Float.parseFloat(textFieldTongTien.getText()));
					dsPhieuThue.taoPhieuThue(phieuThueMoi);
					dsCtPhieuThue.taoChiTietPhieuThue(listCtPhieuThue);
					for (ChiTietPhieuThue ctptCapNhat : listCtPhieuThue) {
						String maDiaCapNhat = ctptCapNhat.getMaDia();
						dsDia.CapNhatDiaDaThue(maDiaCapNhat, 1);
						maDiaCapNhat = removeCharAt(maDiaCapNhat, maDiaCapNhat.length() - 1);
						titleList.CapNhatTieuDeDaThue(maDiaCapNhat);

					}
					frmSearchMovie.dispose();
					JOptionPane.showMessageDialog(null, "Da thue thanh cong!");
					UIQuanlyThueTra window = new UIQuanlyThueTra();
					window.getFrmSearchMovie().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Phai chon khach hang va chon phim day du!");
				}
			}
		});
		btnThuNgay.setBounds(756, 347, 117, 23);

		frmSearchMovie.getContentPane().add(btnThuNgay);
		btnTrNTr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chuc nang nay vao form Tra dia!", "Err",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTrNTr.setBounds(756, 94, 101, 23);

		frmSearchMovie.getContentPane().add(btnTrNTr);
		lblTngTin.setBounds(501, 344, 77, 26);

		frmSearchMovie.getContentPane().add(lblTngTin);

		frmSearchMovie.getContentPane().add(textFieldTongTien);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.frmThuaSi.setVisible(true);
				frmSearchMovie.dispose();

			}
		});
		btnHome.setBounds(402, 347, 89, 23);

		frmSearchMovie.getContentPane().add(btnHome);

	}

	private void RemoveDefaultTableModel(DefaultTableModel defaultTableModel) {
		for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--)
			defaultTableModel.removeRow(i);
	}

	private void AddDefaultTableModelTieuDe(ArrayList<TieuDe> dsTieuDe) {
		for (TieuDe title : dsTieuDe) {
			Object[] rowdata = { title.getIdTitle() + "", title.getName() + "", title.getNoiDung() + "",
					title.getReplica() + "", title.getRented() + "", title.getPrice() + "" };
			defaultTableModelTitle.addRow(rowdata);

		}
	}

	// cat chuoi
	public static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}

	private void AddDefaultTableModelPhieuThue(ArrayList<ChiTietPhieuThue> dsPhieuThue) {
		float tongTien = 0;
		if (list.size() > 0) {

			String name = "";
			for (ChiTietPhieuThue ctPhieuThue : dsPhieuThue) {
				tongTien += ctPhieuThue.getGia() * ctPhieuThue.getSoNgayThue();
				for (TieuDe title : listall) {
					String namecheck = ctPhieuThue.getMaDia();
					namecheck = removeCharAt(namecheck, namecheck.length() - 1);
					if (namecheck.equals(title.getIdTitle())) {
						name = title.getName();
						break;
					}

				}
				Object[] rowdata = { ctPhieuThue.getMaDia(), name, ctPhieuThue.getSoNgayThue(), ctPhieuThue.getGia(),
						ctPhieuThue.getGia() * ctPhieuThue.getSoNgayThue() };
				defaultTableModelCtPhieuThue.addRow(rowdata);

			}
		}

		textFieldTongTien.setText(tongTien + "");

	}

	private void checkListTieuDe(String maTieuDe) {
		for (TieuDe de : list) {
			if (de.getIdTitle().equals(maTieuDe)) {
				list.remove(de);
				return;

			}
		}
	}

	private void checkListPhieuThue(String madia) {
		for (ChiTietPhieuThue ue : listCtPhieuThue) {
			if (ue.getMaDia().equals(madia)) {
				listCtPhieuThue.remove(ue);
				return;
			}
		}
	}

	private String getMaDia(String maTieuDe) {
		for (Dia diaTim : listDia) {
			if (diaTim.getMaTieuDe().equals(maTieuDe))
				return diaTim.getMaDia();
		}
		return "maloi";
	}

	public static int okcancel(String theMessage) {
		int result = JOptionPane.showConfirmDialog((Component) null, theMessage, "alert", JOptionPane.OK_CANCEL_OPTION);
		return result;
	}

}
