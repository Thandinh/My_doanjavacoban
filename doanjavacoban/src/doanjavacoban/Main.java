package doanjavacoban;

import java.util.Scanner;

public class Main {
	
	static final int SOLUONGMAX = 100;
	static int soBoPhim; //số bô phim hiện tại
	
	public static void main(String[] args) {
		Phim[] phim = new Phim[SOLUONGMAX];
		soBoPhim = 0;
		while(true) {
			int chon = menu();
			if(chon == 0) {
				System.out.println("Chương trình đã dừng !");
				break;
			}
			switch(chon) {
			case 1:
				System.out.println("Bạn đã chọn chức năng nhập thông tin cho phim");
				nhapThongTin(phim);
				break;
			case 2:
				xuatThongTin(phim);
				break;
			case 3:
				System.out.println("Bạn đã chọn chức năng thêm 1 bộ phim vào danh sách");
				phim[soBoPhim] = themPhim();
				break;
			case 4:
				timKiemPhim(phim);
				break;
			case 5:
				System.out.println("Bạn đã chọn chức năng xóa phim ");
				phim = xoaPhim(phim);
				break;
			case 6:
				sapXep(phim);
				break;
			default:
				System.out.println("Vui lòng chọn từ 0 - 9");
			}
		}
	}
	
	
//	MENU
	public static int menu() {
		System.out.println(" ____________________________________________________________");
		System.out.println("║                                                            ║");
		System.out.println("║____________ CHƯƠNG TRÌNH QUẢN LÝ CÁC BỘ PHIM ______________║");
		System.out.println("║                                                            ║");
		System.out.println("║   | 1 |  Nhập thông tin phim                               ║");
		System.out.println("║   | 2 |  Hiển thị thông tin các bộ phim có trong danh sách ║");
		System.out.println("║   | 3 |  Thêm 1 bộ phim vào danh sách                      ║");
		System.out.println("║   | 4 |  Tìm kiếm phim theo tên                            ║");
		System.out.println("║   | 5 |  Xóa 1 bộ phim theo tên                            ║");
		System.out.println("║   | 6 |  Sắp xếp theo giá                                  ║");
		System.out.println("║   | 0 |  Dừng chương trình                                 ║");
		System.out.println("║____________________________________________________________║");
		System.out.println();
		System.out.print(" >>>>> Chọn chức năng: ");
		Scanner sc = new Scanner(System.in);
		int chon = sc.nextInt();
		System.out.println();
		return chon;
	}
	
//	Hàm nhập thông tin
	public static void nhapThongTin(Phim[] phim) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng bộ phim: ");
		int soLuong = Integer.parseInt(sc.nextLine());
		Ngay[] ngay = new Ngay[soLuong];
		for(int i = 0; i < soLuong; i++) {
			System.out.println("Nhập thông tin cho Phim thứ " + (i + 1));
			System.out.print("Tên phim: "); String tenPhim = sc.nextLine();
			System.out.print("Đạo diễn: "); String tenDaoDien = sc.nextLine();
			System.out.print("Thể loại: "); String theLoai = sc.nextLine();
			System.out.print("Nhập hãng sản xuất: "); String hangSX = sc.nextLine();
			System.out.print("Nhập quốc gia: "); String quocGia = sc.nextLine();
			System.out.print("Nhập ngày chiếu: "); int ngayChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập tháng chiếu: "); int thangChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập năm chiếu: "); int namChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập giá vé(VND): "); int giaVe = Integer.parseInt(sc.nextLine());
			Ngay n = new Ngay(ngayChieu, thangChieu, namChieu);
			phim[i]  = new Phim(tenPhim, tenDaoDien, theLoai, hangSX, quocGia, n, giaVe);
		}
		soBoPhim = soLuong;
		System.out.println("Đã nhập thông tin thành công");
	}
	
//	Hàm thêm 1 bộ phim
	public static Phim themPhim() {
		if(soBoPhim < SOLUONGMAX) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Tên phim: "); String tenPhim = sc.nextLine();
			System.out.print("Đạo diễn: "); String tenDaoDien = sc.nextLine();
			System.out.print("Thể loại: "); String theLoai = sc.nextLine();
			System.out.print("Nhập hãng sản xuất: "); String hangSX = sc.nextLine();
			System.out.print("Nhập quốc gia: "); String quocGia = sc.nextLine();
			System.out.print("Nhập ngày chiếu: "); int ngayChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập tháng chiếu: "); int thangChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập năm chiếu: "); int namChieu = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập giá vé(VND): "); int giaVe = Integer.parseInt(sc.nextLine());
			Ngay n = new Ngay(ngayChieu, thangChieu, namChieu);
			Phim p = new Phim(tenPhim, tenDaoDien, theLoai, hangSX, quocGia, n, giaVe);
			soBoPhim++;
			System.out.println("Đã thêm phim!");
			System.out.println("");
			return p;
		}else {
			 System.out.println("Danh sách phim đã đầy, không thể thêm phim mới.");
			 return null;
        }
	}
	
	
//	Hàm xuất thông tin
	public static void xuatThongTin(Phim[] p) {
		if (soBoPhim == 0) {
	        System.out.println("Danh sách phim đang rỗng");
	        return;
	    }
	    System.out.println("DANH SÁCH PHIM");
	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-20s | %-18s | %-15s | %-15s | %-12s | %-13s | %-10s |\n", 
	                       "Tên phim", "Đạo diễn", "Thể loại", "Hãng sản xuất", "Quốc gia", "Ngày chiếu", "Giá vé");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

	    for (int i = 0; i < soBoPhim; i++) {
	        System.out.printf("| %-20s | %-18s | %-15s | %-15s | %-12s | %-3d/%-3d/%-7d | %-10d |\n", 
	                          p[i].tenPhim , p[i].daoDien, p[i].theLoai, 
	                          p[i].hangSanXuat, p[i].quocGia, p[i].ngayChieu.ngay, p[i].ngayChieu.thang, 
	                          p[i].ngayChieu.nam, p[i].giaVeVND);
	    }

	    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	   
	}
	
//	Hàm xóa 1 bộ phim theo tên
	public static Phim[] xoaPhim(Phim[] p) {
		if(soBoPhim == 0) {
			System.out.println("Danh sách phim đang rỗng");
			return null;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên của phim cần xóa: "); String tenPhim = sc.nextLine();
		boolean timThay = false;
		for(int i = 0; i < soBoPhim; i++) {
			if(p[i].tenPhim.equalsIgnoreCase(tenPhim)) {
				for(int j = i; j < soBoPhim - 1; j++) {
					p[j] = p[j + 1];
				}
				p[soBoPhim - 1] = null;
				soBoPhim--;
				timThay = true;
				System.out.println("Phim đã được xóa thành công");
				break;
			}
		}
		if(!timThay) {
			System.out.println("Không tìm thấy phim");
		}
		return p;
	}
	
	
	public static void timKiemPhim(Phim[] p) {
		if(soBoPhim == 0) {
			System.out.println("Danh sách phim đang rỗng");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên của phim cần tìm kiếm: "); String tenPhim = sc.nextLine();
		boolean timThay = false;
		System.out.println("PHIM BẠN CẦN TÌM KIẾM");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-20s | %-18s | %-15s | %-15s | %-12s | %-13s | %-10s |\n", 
	                       "Tên phim", "Đạo diễn", "Thể loại", "Hãng sản xuất", "Quốc gia", "Ngày chiếu", "Giá vé");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < soBoPhim; i++) {
			if(p[i].tenPhim.equalsIgnoreCase(tenPhim)) {
				 System.out.printf("| %-20s | %-18s | %-15s | %-15s | %-12s | %-3d/%-3d/%-7d | %-10d |\n", 
                         p[i].tenPhim , p[i].daoDien, p[i].theLoai, 
                         p[i].hangSanXuat, p[i].quocGia, p[i].ngayChieu.ngay, p[i].ngayChieu.thang, 
                         p[i].ngayChieu.nam, p[i].giaVeVND);
			}
		}
	}
	
	
	
	public static void sapXep(Phim[] p) {
		System.out.println(" ______ Các chức năng sắp xếp ________");
		System.out.println("║                                     ║");
        System.out.println("║  1. Sắp xếp giảm dần theo giá       ║");
        System.out.println("║  2. Thêm xếp tăng dần theo giá      ║");
        System.out.println("║_____________________________________║");
        System.out.println("");
		System.out.print(">> Nhập lựa chọn(1-2): ");
		Scanner sc = new Scanner(System.in);
		int c = Integer.parseInt(sc.nextLine());
		switch(c) {
		case 1:
			System.out.println("Chức năng sắp xếp tăng dần");
			System.out.println("");
			sapXepTangDanTheoGia(p);
			break;
		case 2:
			System.out.println("Chức năng sắp xếp giảm dần");
			System.out.println("");
			sapXepGiamDanTheoGia(p);
			break;
		default:
			System.out.println("Nhập sai dữ liệu");
		}
	}

	public static void sapXepGiamDanTheoGia(Phim[] p) {
		for(int i = 0; i < soBoPhim - 1; i++) {
			for(int j = i + 1; j < soBoPhim; j++) {
				if(p[i].giaVeVND < p[j].giaVeVND) {
					Phim tmp = p[i];
					p[i] = p[j];
					p[j] = tmp;
				}
			}
		}
		xuatThongTin(p);
	}
	
	
	public static void sapXepTangDanTheoGia(Phim[] p) {
		for(int i = 0; i < soBoPhim - 1; i++) {
			for(int j = i + 1; j < soBoPhim; j++) {
				if(p[i].giaVeVND > p[j].giaVeVND) {
					Phim tmp = p[i];
					p[i] = p[j];
					p[j] = tmp;
				}
			}
		}
		xuatThongTin(p);
	}
	
	public static void thongKeTheoGia(Phim p) {
		
	}
	
}


	




