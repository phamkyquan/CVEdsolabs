package com.edsolabs.CVEdso.converter;

import org.springframework.stereotype.Component;

import com.edsolabs.CVEdso.dto.CvDTO;
import com.edsolabs.CVEdso.dto.CvLastDTO;
import com.edsolabs.CVEdso.entity.CvEntity;
import com.edsolabs.CVEdso.entity.HistoryEntity;

@Component
public class DtoToEntity {
	public CvEntity cvDtoConvertCvEntity(CvDTO cvDto) {
		CvEntity cvEntity = new CvEntity();
		cvEntity.setHoTen(cvDto.getHoTen());
		cvEntity.setGioiTinh(cvDto.getGioiTinh());
		cvEntity.setNgaySinh(cvDto.getNgaySinh());
		cvEntity.setQueQuan(cvDto.getQueQuan());
		cvEntity.setTruongHoc(cvDto.getTruongHoc());
		cvEntity.setViTriApp(cvDto.getViTriApp());
		cvEntity.setNguonLayCV(cvDto.getNguonLayCV());
		return cvEntity;
	}
	
	public CvEntity cvLastDtoConvertCvEntity(CvEntity cvEntity, CvLastDTO last) {
		cvEntity.setNguoiNhanCV(last.getNguoiNhanCV());
		cvEntity.setNguoiPhongVan(last.getNguoiPhongVan());
		cvEntity.setNguoiGioiThieu(last.getNguoiGioiThieu());
		cvEntity.setGhiChuPhongVan(last.getGhiChuPhongVan());
		cvEntity.setKetQuaPhongVan(last.getKetQuaPhongVan());
		cvEntity.setBoPhanTiepNhan(last.getBoPhanTiepNhan());
		return cvEntity;
	}
	
	public HistoryEntity cvEntityConvertHistoryEntity(CvEntity cvEntity) {
		HistoryEntity historyEntity = new HistoryEntity();
		historyEntity.setId(cvEntity.getId());
		historyEntity.setHoTen(cvEntity.getHoTen());
		historyEntity.setGioiTinh(cvEntity.getGioiTinh());
		historyEntity.setNgaySinh(cvEntity.getNgaySinh());
		historyEntity.setQueQuan(cvEntity.getQueQuan());
		historyEntity.setTruongHoc(cvEntity.getTruongHoc());
		historyEntity.setViTriApp(cvEntity.getViTriApp());
		historyEntity.setNguonLayCV(cvEntity.getNguonLayCV());
		historyEntity.setNguoiPhongVan(cvEntity.getNguoiPhongVan());
		historyEntity.setNguoiNhanCV(cvEntity.getNguoiNhanCV());
		historyEntity.setNguoiGioiThieu(cvEntity.getNguoiGioiThieu());
		historyEntity.setGhiChuPhongVan(cvEntity.getGhiChuPhongVan());
		historyEntity.setKetQuaPhongVan(cvEntity.getKetQuaPhongVan());
		historyEntity.setBoPhanTiepNhan(cvEntity.getBoPhanTiepNhan());
		return historyEntity;
	}
}
