package doanjavacoban;

public class Phim {
	public String tenPhim;
	public String daoDien;
	public String theLoai;
	public String hangSanXuat;
	public String quocGia;
	public Ngay ngayChieu;
	public int giaVeVND;
	public Phim(String tenPhim, String daoDien, String theLoai, String hangSanXuat, String quocGia,
			Ngay ngayChieu, int giaVeVND) {
		this.tenPhim = tenPhim;
		this.daoDien = daoDien;
		this.theLoai = theLoai;
		this.hangSanXuat = hangSanXuat;
		this.quocGia = quocGia;
		this.ngayChieu = ngayChieu;
		this.giaVeVND = giaVeVND;
	}
	
	
}
