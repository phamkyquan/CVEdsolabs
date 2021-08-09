package com.edsolabs.CVEdso.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edsolabs.CVEdso.converter.DtoToEntity;
import com.edsolabs.CVEdso.dto.CvDTO;
import com.edsolabs.CVEdso.dto.CvLastDTO;
import com.edsolabs.CVEdso.entity.CvEntity;
import com.edsolabs.CVEdso.entity.HistoryEntity;
import com.edsolabs.CVEdso.service.impl.CvService;
import com.edsolabs.CVEdso.service.impl.HistoryService;

@RestController
@CrossOrigin
public class CvAPI {

	@Autowired
	CvService cvService;
	
	@Autowired
	DtoToEntity dtoToEntity;
	
	@Autowired
	HistoryService historyService;

	@PostMapping("/cv")
	public List<CvEntity> createCV(@Valid @RequestBody CvDTO cv, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return null;
		} else {
			CvEntity cvEntity = dtoToEntity.cvDtoConvertCvEntity(cv);
			cvService.saveCv(cvEntity);
			HistoryEntity historyEntity = dtoToEntity.cvEntityConvertHistoryEntity(cvEntity);
			historyEntity.setAction("Thêm mới");
			historyService.saveCv(historyEntity);
			return cvService.getAllCv();
		}
	}

	@GetMapping("/cv")
	public List<CvEntity> getCV() {
		return cvService.getAllCv();
	}

	@PutMapping("/cv")
	public List<CvEntity> updateCV(@RequestParam("id") Long id, @Valid @RequestBody CvDTO cv) {
		Optional<CvEntity> cvEdit = cvService.findCvById(id);
		CvEntity oldCv = cvEdit.get();
		HistoryEntity historyEntity = dtoToEntity.cvEntityConvertHistoryEntity(oldCv);
		historyEntity.setAction("Sửa");
		historyService.saveCv(historyEntity);
		CvEntity cvEntity = dtoToEntity.cvDtoConvertCvEntity(cv);
		cvEntity.setId(id);
		cvService.saveCv(cvEntity);
		return cvService.getAllCv();
	}

	@DeleteMapping("/cv")
	public List<CvEntity> deleteCV(@RequestBody List<Long> ids) {
		for (Long id : ids) {
			Optional<CvEntity> cvEdit = cvService.findCvById(id);
			CvEntity cvEntity = cvEdit.get();
			HistoryEntity historyEntity = dtoToEntity.cvEntityConvertHistoryEntity(cvEntity);
			historyEntity.setAction("Xóa");
			historyService.saveCv(historyEntity);
			cvService.deleteCv(id);
		}
		return cvService.getAllCv();
	}

	@PostMapping("/url_cv")
	public List<CvEntity> updateUrlCV(@RequestParam("id") Long id, @RequestParam("fileName") String fileName) {
		InputStream inStream = null;
		OutputStream outStream = null;
		String urlCv = "D:\\Eclipse\\CVEdso\\src\\main\\resources\\SERVER\\" + fileName;
		try {
			inStream = new FileInputStream(new File("C:\\Users\\PC1\\OneDrive\\Máy tính\\XinViec\\" + fileName));
			outStream = new FileOutputStream(new File(urlCv));
			int length;
			byte[] buffer = new byte[1024];

			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		Optional<CvEntity> cvEdit = cvService.findCvById(id);
		CvEntity cvEntity = cvEdit.get();
		HistoryEntity historyEntity = dtoToEntity.cvEntityConvertHistoryEntity(cvEntity);
		historyEntity.setAction("Upload url");
		historyService.saveCv(historyEntity);
		cvEntity.setUrlCV(urlCv);
		cvService.saveCv(cvEntity);
		return cvService.getAllCv();
	}
	
	@PutMapping("/cv/last")
	public List<CvEntity> updateCvLast(@RequestBody CvLastDTO cvLast,@RequestParam("id") Long id){
		Optional<CvEntity> cvEdit = cvService.findCvById(id);
		CvEntity cvEntity = cvEdit.get();
		HistoryEntity historyEntity = dtoToEntity.cvEntityConvertHistoryEntity(cvEntity);
		historyEntity.setAction("Cập nhật");
		historyService.saveCv(historyEntity);
		cvService.saveCv(dtoToEntity.cvLastDtoConvertCvEntity(cvEntity, cvLast));
		return cvService.getAllCv();
	}
	
	@GetMapping("/history")
	public List<HistoryEntity> getHistory(){
		return historyService.getAllHistory();
	}
}
