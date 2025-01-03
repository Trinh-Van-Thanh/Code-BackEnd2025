package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.service.BuidingServicer;

import Model.BuiDingDTO;
import customexception.FielRequedException;

@RestController
public class NewAPI {
	@Autowired
	private BuidingServicer buidingServicer;
	@PostMapping(value = "/test")
	
//	public BuiDingDTO getBuillDing(@RequestParam(value = "name", required = false) String name,
//								@RequestParam(value = "number", required = false) Integer number) {
//		// xử lý xong dưới DB Xong Rồi
//		BuiDingDTO result = new BuiDingDTO();
//		result.setName(name);
//		result.setNumberOfBasement(number);
//		return result;
//	}
//	public Object getBuillDing(@RequestParam(value = "name", required = false) String name,
//										@RequestParam(value = "number", required = false) Integer number) {
//		// xử lý xong dưới DB Xong Rồi
//		
//		try {
//			System.out.print(5/0);
//		} catch (Exception e) {
//			ErroReponseDTO erroReponseDTO = new ErroReponseDTO();
//			erroReponseDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("Số Nguyên Làm Sao Chia Cho 0 Được?");
//			erroReponseDTO.setDateil(details);
//			return erroReponseDTO;
//		}
//		List<BuiDingDTO> listBuiding = new ArrayList<>();		
//		BuiDingDTO buidingDTO1 = new BuiDingDTO();
//		buidingDTO1.setName("Thanh");
//		buidingDTO1.setNumberOfBasement(3);
//		buidingDTO1.setWard("Bắc Từ Liêm");
//		BuiDingDTO buidingDTO2 = new BuiDingDTO();
//		buidingDTO2.setName("Hoa");
//		buidingDTO2.setNumberOfBasement(6);
//		buidingDTO2.setWard("Nam Từ Liêm");
//		listBuiding.add(buidingDTO1);
//		listBuiding.add(buidingDTO2);
//		return listBuiding;
//	}
	public Object getBuillDing(@RequestParam(name = "name", required = false) String name,
							@RequestParam(name = "districtid",required = false) Long district,
							@RequestParam(name = "typeCode",required = false) List<String> typeCode) {
// xử lý xong dưới DB Xong Rồi
//
//		try {
//			System.out.print(5/0);
//			valiDate(buiDingDTO);
//		} catch (FielRequedException e) {
//			ErroReponseDTO erroReponseDTO = new ErroReponseDTO();
//			erroReponseDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("Check lại name hoặc NumberOfBasement bởi vì đang bị null đó!");
//			erroReponseDTO.setDateil(details);
//			return erroReponseDTO;
//		}
		List<BuiDingDTO> result = buidingServicer.findAll(name,district);
		return result;
	}
		public void valiDate(BuiDingDTO buiDingDTO) throws FielRequedException {
			if(buiDingDTO.getName() == null || buiDingDTO.getName().equals("") || buiDingDTO.getNumberOfBasement() == null) {
				throw new FielRequedException("name or NumberOfBasement is null");
			}
	}

//	@RequestMapping(value = "/test" ,method = RequestMethod.POST)
//	public void getBuillDing1(@RequestBody BuiDingDTO buiDingDTO) {
//		System.out.print("OK");
//	}
//	@RequestMapping(value = "/test" ,method = RequestMethod.POST)
//	public BuiDingDTO getBuillDing2(@RequestBody BuiDingDTO buiDing) {
//		
//		return buiDing;
//	}
	@DeleteMapping(value = "/test/{id}/{name}")
	public void deleteBuiDing(@PathVariable Integer id, @PathVariable String name) {
		System.out.print("Đã Xóa Tòa Nhà Có ID Là 1" + id + " " + name);
	}
}
