package com.edsolabs.CVEdso.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CVEdso")
public class CvEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String hoTen; 
	@NotBlank
	private String gioiTinh;
	@NotBlank
	private String ngaySinh;
	@NotBlank
	private String queQuan;
	@NotBlank
	private String truongHoc;
	@NotBlank
	private String viTriApp;
	private String nguonLayCV;
	private String nguoiNhanCV;
	private String urlCV;
	private String nguoiGioiThieu;
	private String nguoiPhongVan;
	private String ghiChuPhongVan;
	private String ketQuaPhongVan;
	private String boPhanTiepNhan;
	public void setId(Long id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getTruongHoc() {
		return truongHoc;
	}
	public void setTruongHoc(String truongHoc) {
		this.truongHoc = truongHoc;
	}
	public String getViTriApp() {
		return viTriApp;
	}
	public void setViTriApp(String viTriApp) {
		this.viTriApp = viTriApp;
	}
	public String getNguonLayCV() {
		return nguonLayCV;
	}
	public void setNguonLayCV(String nguonLayCV) {
		this.nguonLayCV = nguonLayCV;
	}
	public String getNguoiNhanCV() {
		return nguoiNhanCV;
	}
	public void setNguoiNhanCV(String nguoiNhanCV) {
		this.nguoiNhanCV = nguoiNhanCV;
	}
	public String getUrlCV() {
		return urlCV;
	}
	public void setUrlCV(String urlCV) {
		this.urlCV = urlCV;
	}
	public String getNguoiGioiThieu() {
		return nguoiGioiThieu;
	}
	public void setNguoiGioiThieu(String nguoiGioiThieu) {
		this.nguoiGioiThieu = nguoiGioiThieu;
	}
	public String getNguoiPhongVan() {
		return nguoiPhongVan;
	}
	public void setNguoiPhongVan(String nguoiPhongVan) {
		this.nguoiPhongVan = nguoiPhongVan;
	}
	public String getGhiChuPhongVan() {
		return ghiChuPhongVan;
	}
	public void setGhiChuPhongVan(String ghiChuPhongVan) {
		this.ghiChuPhongVan = ghiChuPhongVan;
	}
	public String getKetQuaPhongVan() {
		return ketQuaPhongVan;
	}
	public void setKetQuaPhongVan(String ketQuaPhongVan) {
		this.ketQuaPhongVan = ketQuaPhongVan;
	}
	public Long getId() {
		return id;
	}
	public String getBoPhanTiepNhan() {
		return boPhanTiepNhan;
	}
	public void setBoPhanTiepNhan(String boPhanTiepNhan) {
		this.boPhanTiepNhan = boPhanTiepNhan;
	}
	
	
}
