package views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import controller.DsPhieuTre;
import controller.DsTieuDe;
import model.ChiTietPhieuThue;
import model.KhachHang;
import model.PhieuDat;
import model.PhieuThue;
import model.PhieuTre;
import model.TieuDe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.awt.event.ItemEvent;

public class UiQuanLyTra {
	int bienTre=0;
//phamquantri@iuh.edu.vn
	// 1. word script database,code

	private DsPhieuThue dsPhieuThue = new DsPhieuThue();
	private ArrayList<PhieuThue> listAllPhieuThue = dsPhieuThue.taiPhieuThue();
	private DsPhieuDat dsPhieuDat = new DsPhieuDat();
	ArrayList<PhieuDat> listAllPhieuDat = dsPhieuDat.taiPhieuDat();
	private DsPhieuTre dsPhieuTre = new DsPhieuTre(); 
	private ArrayList<PhieuTre> listAllPhieuTre = dsPhieuTre.taiPhieuTre();
	private DsDia dsDia = new DsDia(); 
	private DsCtPhieuThue dsCtPhieuThue = new  DsCtPhieuThue();
	private ArrayList<ChiTietPhieuThue> listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThueTra();
	private DsKhachHang dsKhachHang = new DsKhachHang();
	private ArrayList<KhachHang> listAllKhachHang = dsKhachHang.taiDsKhachHang();
	private JFrame frmTraDia;
	private JTextField textFieldSearch;
	public JPanel contentPane;
	private DefaultTableModel defaultTableModelCTPT;
	private DsTieuDe titleListall = new DsTieuDe();
	private ArrayList<TieuDe> listall = titleListall.loadDataTra();
	JTable JTableTieuDe = new JTable();
	private final JButton btnTra = new JButton("Trả đĩa này!");
	PhieuThue phieuThue ;
	ChiTietPhieuThue chiTietPhieuThue = new ChiTietPhieuThue();
	private final JLabel lblTmKhchHng = new JLabel("Trả theo khách hàng");
	private JComboBox<String> comboBox = new JComboBox<String>();

	private final JLabel lblDanhScha = new JLabel("Danh sách đĩa đã thuê");
	private final JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
	private final JTextField textFieldTenKhach = new JTextField();
	private final JLabel lblAnhch = new JLabel("Anh/chị:");
	private final JLabel lblSinThoi = new JLabel("Số điện thoại:");
	private final JTextField textFieldSdtKhach = new JTextField();
	private final JLabel lblaCh = new JLabel("Địa chỉ:");
	private final JTextField textFieldDiachiKhach = new JTextField();
	private final JButton btnTrTrHn = new JButton("Tra tien dia nay!");
	private final JButton btnQuanr = new JButton("Quản lý Thuê");
	private final JLabel lblTienNo = new JLabel("Tien no:");
	private final JTextField textFieldTienNo = new JTextField();
	private final JButton btnThoat = new JButton("Thoat");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiQuanLyTra window = new UiQuanLyTra();
					window.frmTraDia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getfrmTraDia() {
		return frmTraDia;
	}

	public void setfrmTraDia(JFrame frmTraDia) {
		this.frmTraDia = frmTraDia;
	}

	/**
	 * Create the application.
	 */
	public UiQuanLyTra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textFieldTienNo.setEditable(false);
		textFieldTienNo.setBounds(715, 177, 146, 20);
		textFieldTienNo.setColumns(10);
		textFieldTenKhach.setEditable(false);
		textFieldTenKhach.setBounds(714, 74, 146, 20);
		textFieldTenKhach.setColumns(10);
		frmTraDia = new JFrame();
		frmTraDia.setTitle("Quản lý trả đĩa");
		frmTraDia.setBounds(100, 100, 902, 420);
		frmTraDia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTraDia.getContentPane().setLayout(null);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(295, 36, 89, 23);
		frmTraDia.getContentPane().add(btnSearch);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 37, 264, 20);
		frmTraDia.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		// load table Title here
		JScrollPane JScrollPaneTieuDe = new JScrollPane();
		JScrollPaneTieuDe.setBounds(10, 70, 607, 300);
		frmTraDia.getContentPane().add(JScrollPaneTieuDe);

		String[] tab = { "Ma dia ", "Ten CD","SDT Khach", "Ngay thue", "Thue","Da thue","Da tre","Tien no","MCTPT" };
		defaultTableModelCTPT = new DefaultTableModel(null, tab);
		AddDefaultTableModelCTPT(listAllCTPhieuThue);

		JTableTieuDe.setModel(defaultTableModelCTPT);

		JScrollPaneTieuDe.setViewportView(JTableTieuDe);
		
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				int select = -1;
				select = JTableTieuDe.getSelectedRow();
				if (!JTableTieuDe.isRowSelected(select)) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một đĩa muốn trả!");
				} else {
					if(Float.parseFloat((String) JTableTieuDe.getValueAt(select, 7))>0) {
						JOptionPane.showMessageDialog(null, "Vui lòng thanh toán trễ hẹn!");
					}else {
						String mactpt = (String) JTableTieuDe.getValueAt(select, 8);
						String madia = (String) JTableTieuDe.getValueAt(select, 0);
						String matieuDe = removeCharAt(madia, madia.length()-1);
//						CheckDatTruoc( matieuDe, madia);
						String maDatTruoc =CheckDatTruoc( matieuDe, madia);
						if(dsCtPhieuThue.TraDia(mactpt)&&!maDatTruoc.equals("loi")){
							
							dsPhieuDat.CapNhatPhieuDatXong(maDatTruoc);

							JOptionPane.showMessageDialog(null, "da gan dia");
							
						}
						else {
//							JOptionPane.showMessageDialog(null, "Gan dia cho khach bi bug! Vui long doi......");
						}
						dsDia.CapNhatDiaDaThue(madia, 0);
						titleListall.CapNhatTieuDeDaTra(matieuDe);
						listAllCTPhieuThue.clear();
						if(!textFieldDiachiKhach.getText().equals("")) {

							listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThueTra(textFieldSdtKhach.getText());
						}
						else {
							listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThueTra();
							
						}
						
						RemoveDefaultTableModel(defaultTableModelCTPT);
						AddDefaultTableModelCTPT(listAllCTPhieuThue);
						
					}
					
				
				}
			}

		});
		btnTra.setBounds(677, 249, 146, 23);

		frmTraDia.getContentPane().add(btnTra);



		frmTraDia.getContentPane().add(lblTmKhchHng);
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
							RemoveDefaultTableModel(defaultTableModelCTPT);
							 listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThueTra(khachHangTim.getsoDT());
							AddDefaultTableModelCTPT(listAllCTPhieuThue);
							btnTrTrHn.setEnabled(true);
						}
					}
				}
			}
		});
		comboBox.setBounds(677, 11, 163, 22);

		frmTraDia.getContentPane().add(comboBox);
		lblDanhScha.setBounds(109, 11, 135, 14);

		frmTraDia.getContentPane().add(lblDanhScha);
		lblNewLabel.setBounds(702, 50, 126, 19);

		frmTraDia.getContentPane().add(lblNewLabel);

		frmTraDia.getContentPane().add(textFieldTenKhach);
		lblAnhch.setBounds(634, 80, 77, 14);

		frmTraDia.getContentPane().add(lblAnhch);
		lblSinThoi.setBounds(634, 111, 77, 14);

		frmTraDia.getContentPane().add(lblSinThoi);
		textFieldSdtKhach.setEditable(false);
		textFieldSdtKhach.setColumns(10);
		textFieldSdtKhach.setBounds(714, 105, 146, 20);

		frmTraDia.getContentPane().add(textFieldSdtKhach);
		lblaCh.setBounds(634, 139, 77, 14);

		frmTraDia.getContentPane().add(lblaCh);
		textFieldDiachiKhach.setEditable(false);
		textFieldDiachiKhach.setColumns(10);
		textFieldDiachiKhach.setBounds(714, 133, 146, 20);

		frmTraDia.getContentPane().add(textFieldDiachiKhach);
		btnTrTrHn.setEnabled(false);
		btnTrTrHn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = -1;
				select = JTableTieuDe.getSelectedRow();
				if (!JTableTieuDe.isRowSelected(select)) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn một đĩa muốn thanh toán!");
				} else {
					if(Float.parseFloat((String) JTableTieuDe.getValueAt(select, 7))==0) {
						JOptionPane.showMessageDialog(null, "Hay thue dia de duoc thanh toan!");
					}else {
						String mactpt = (String) JTableTieuDe.getValueAt(select, 8);
						
						int maTre = listAllPhieuTre.size()+bienTre;
						maTre++;
						PhieuTre phieuTre = new PhieuTre("XPT500"+maTre, textFieldTenKhach.getText(), (String)JTableTieuDe.getValueAt(select, 7), Float.parseFloat((String) JTableTieuDe.getValueAt(select, 7)));
						dsPhieuTre.taoPhieuTre(phieuTre);
						bienTre++;
						if(dsCtPhieuThue.TraNoDia(mactpt)){
							listAllCTPhieuThue.clear();
							listAllCTPhieuThue = dsCtPhieuThue.taiDsCTPhieuThueTra(textFieldSdtKhach.getText());
							
							RemoveDefaultTableModel(defaultTableModelCTPT);
							AddDefaultTableModelCTPT(listAllCTPhieuThue);

							JOptionPane.showMessageDialog(null, "Thanh toan thanh cong!");
						}
						else {
							System.out.println("loik the tra no");
						}
						
					}
					
				
				}
			}

		});
		btnTrTrHn.setBounds(677, 285, 146, 23);
		
		frmTraDia.getContentPane().add(btnTrTrHn);
		btnQuanr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIQuanlyThueTra window = new UIQuanlyThueTra();
				window.getFrmSearchMovie().setVisible(true);
				getfrmTraDia().dispose();
			}
		});
		btnQuanr.setBounds(627, 330, 111, 23);
		
		frmTraDia.getContentPane().add(btnQuanr);
		lblTienNo.setBounds(657, 180, 48, 14);
		
		frmTraDia.getContentPane().add(lblTienNo);
		
		frmTraDia.getContentPane().add(textFieldTienNo);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.frmThuaSi.setVisible(true);
				frmTraDia.dispose();
			}
		});
		btnThoat.setBounds(748, 330, 128, 23);
		
		frmTraDia.getContentPane().add(btnThoat);

	}

	private void AddDefaultTableModelCTPT(ArrayList<ChiTietPhieuThue> dsChiTiet) {
		float tienNo=0;
		for (ChiTietPhieuThue chiTietPhieuThue : dsChiTiet) {
			int ngaytre = 0;
			float tienTre =0;
			int ngayda=0;
			long tinhngay=0;
			String name="Loi";
			 tinhngay= chiTietPhieuThue.getNgayTra().getTime()-chiTietPhieuThue.getNgayThue().getTime();
			ngayda = (int) (tinhngay / (1000*60*60*24));
			if(ngayda>chiTietPhieuThue.getSoNgayThue()) {
				ngaytre=ngayda-chiTietPhieuThue.getSoNgayThue();
				tienTre = chiTietPhieuThue.getGia()*ngaytre;
				
			}
			for (TieuDe title : listall) {
				String namecheck = chiTietPhieuThue.getMaDia();
				namecheck = removeCharAt(namecheck, namecheck.length() - 1);
				if (namecheck.equals(title.getIdTitle())) {
					name = title.getName();
					break;
				}

			}
			tienNo+=tienTre;
			Object[] rowdata = {chiTietPhieuThue.getMaDia(),name,chiTietPhieuThue.getMaKH(),chiTietPhieuThue.getNgayThue(),
					chiTietPhieuThue.getSoNgayThue()+" Ngay", ngayda + " Ngay",ngaytre+" Ngay",tienTre+"",chiTietPhieuThue.getMaCT()};
			defaultTableModelCTPT.addRow(rowdata);

		}
		textFieldTienNo.setText(tienNo+"");
		if(tienNo!=0) {
			JOptionPane.showMessageDialog(null, "Tien tre hen: "+tienNo+" Hay khac phuc!");
		}
	}
//	String[] tab = { "Ma dia ", "Ten CD", "Ngay thue", "Ngay tra", "Da thue", "Tien no" };
	private void RemoveDefaultTableModel(DefaultTableModel defaultTableModel) {
		for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--)
			defaultTableModel.removeRow(i);
	}
	// check dat
	public String CheckDatTruoc(String maTieuDe,String madiacu) {
		for(PhieuDat dat : listAllPhieuDat) {
			if(dat.getTrangThai()==0) {
				if(dat.getMaTieuDe().equals(maTieuDe)) {
					int matam = listAllPhieuThue.size() + 1;
					String mapt = "PT00" + matam;
					PhieuThue phieuThueMoi = new PhieuThue(mapt, textFieldSdtKhach.getText(),
							new Date(System.currentTimeMillis()), dat.getGia()*dat.getSoNgayThue());
					dsPhieuThue.taoPhieuThue(phieuThueMoi);

					int matamct = listAllCTPhieuThue.size() + 1;
					String mactpt = "CTPT00" + matamct;
					ChiTietPhieuThue chiTietPhieuThueMoi = new ChiTietPhieuThue(mactpt, mapt, dat.getMaKH(),
							new Date(System.currentTimeMillis()),
							null, dat.getSoNgayThue(), dat.getGia(),madiacu,0);
					dsCtPhieuThue.taoChiTietPhieuThue(chiTietPhieuThueMoi);
					return dat.getMaPhieuDat();
				}
			}
				
		}
//		System.out.println("loi check dat");
		return "loi";
	}
	// cat chuoi
	public static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}
}
