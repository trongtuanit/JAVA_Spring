package com.hit.controller;

import java.util.LinkedList;
import java.util.List;
//import java.util.Optional;

//import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dao.Province;
import com.hit.dto.ProvinceDTO;
import com.hit.exceptions.DuplicateExceptions;
import com.hit.exceptions.NotFoundException;
import com.hit.repositories.ProvinceRepository;
import com.hit.utils.ConvertObject;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH })
public class ProvinceController {

	@Autowired
	private ProvinceRepository provinceRepos;
	
	@GetMapping
	public ResponseEntity<?> findAllProvinces() {
		List<Province> listProvince = provinceRepos.findAll();
		if(listProvince.size()==0)
			throw new NotFoundException("No content");
		return ResponseEntity.status(HttpStatus.OK).body(listProvince);
	}
	
	@GetMapping("/{provinceCode}")
	public ResponseEntity<?> findProvinceByCode(@PathVariable("provinceCode") String provinceCode) {
		Province province = provinceRepos.findByCode(provinceCode.toString());
		
		if(province==null)
			throw new NotFoundException("No content");
		return ResponseEntity.status(HttpStatus.OK).body(province);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createNewProvince(@RequestBody ProvinceDTO provinceDto) {
		Province oldProvince = provinceRepos.findByCode(provinceDto.getCode());
		if(oldProvince!=null)
			throw new DuplicateExceptions("Province has already exist");
		if(Integer.parseInt(provinceDto.getCode()) > 63 || Integer.parseInt(provinceDto.getCode()) <0 )
			throw new DuplicateExceptions("Province code error");
		
		Province province = ConvertObject.provinceDtoToDao(provinceDto);
		Province newProvince = provinceRepos.save(province);
		
		return ResponseEntity.status(HttpStatus.OK).body(newProvince);
	}
	
	@PostMapping("/provinces-collection")
	public ResponseEntity<?> createNewProvinces(@RequestBody List<ProvinceDTO> provinceDTOs) {
		List<Province> provincesDAO = new LinkedList<Province>();
		for(int i = 0; i < provinceDTOs.size(); i++) {
			Province province = new Province();
			province = ConvertObject.provinceDtoToDao(provinceDTOs.get(i));
			provincesDAO.add(province);
		}
		List<Province> newProvinces = provinceRepos.saveAll(provincesDAO);
		
		return ResponseEntity.status(HttpStatus.OK).body(newProvinces);
	}
	
	
	
	
}
