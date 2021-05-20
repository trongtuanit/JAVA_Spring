package com.hit.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dao.District;
import com.hit.dao.Province;
import com.hit.dto.DistrictDTO;

import com.hit.exceptions.DuplicateExceptions;
import com.hit.exceptions.NotFoundException;
import com.hit.repositories.DistrictRepository;
import com.hit.repositories.ProvinceRepository;
import com.hit.utils.ConvertObject;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH })
public class DistrictController {

	@Autowired
	private ProvinceRepository provinceRepos;

	@Autowired
	private DistrictRepository districtRepos;

	@GetMapping
	public ResponseEntity<?> findAllDistricts() {
		List<District> listDistrict = districtRepos.findAll();
		if (listDistrict.size() == 0)
			throw new NotFoundException("No content");
		return ResponseEntity.status(HttpStatus.OK).body(listDistrict);
	}

	@PostMapping
	public ResponseEntity<?> createNewDistrict(@RequestBody DistrictDTO districtDTO) {
		District isNewDistrictExist = districtRepos.findByCode(districtDTO.getCode());
		if (isNewDistrictExist != null)
			throw new DuplicateExceptions("District has already exist");
		
		
		System.out.println(districtDTO.getParentCode());
		
		Province provinceOfDistrict = provinceRepos.findByCode(districtDTO.getParentCode().toString());
		System.out.println("is province null ? - "+ provinceOfDistrict);
		District district = new District();
//		System.out.println(district);
		System.out.println("log here: " + provinceOfDistrict.getName());
		district.setName(districtDTO.getName());
		
		if (districtDTO.getType().compareToIgnoreCase("huyen") == 0)
			district.setType("Huyện");
		else
			district.setType("Thành phố");

		district.setSlug(ConvertObject.slugify(districtDTO.getName()));
		district.setNameWithType(district.getType() + " " + districtDTO.getName());
		district.setPath(districtDTO.getName() + ", " + provinceOfDistrict.getName());
		district.setPathWithType(provinceOfDistrict.getType() + " " + provinceOfDistrict.getName() + ", " + district.getType()
				+ " " + districtDTO.getName());
		district.setCode(districtDTO.getCode());
		district.setParentCode(districtDTO.getParentCode());
		district.setProvince(provinceOfDistrict);
		District newDistrict = districtRepos.save(district);
		return ResponseEntity.status(HttpStatus.OK).body(newDistrict);
	}

	@PostMapping("/districts-collection")
	public ResponseEntity<?> createNewDistricts(@RequestBody List<DistrictDTO> districtDTOs) {
		List<District> listDistrictDAO = new LinkedList<District>();

		for (int i = 0; i < districtDTOs.size(); i++) {
				
			
			District district = new District();
			District isNewDistrictExist = districtRepos.findByCode(districtDTOs.get(i).getCode());
			if (isNewDistrictExist != null)
				throw new DuplicateExceptions("District " + districtDTOs.get(i).getName() + " has already exist");

			Province provinceOfDistrict = provinceRepos.findByCode(districtDTOs.get(i).getParentCode().toString());
			
			district.setName(districtDTOs.get(i).getName());
			if (districtDTOs.get(i).getType().compareToIgnoreCase("huyen") == 0)
				district.setType("Huyện");
			else
				district.setType("Thành phố");

			district.setSlug(ConvertObject.slugify(district.getName()));
			district.setNameWithType(district.getType() + " " + districtDTOs.get(i).getName());
			district.setPath(district.getName() + "," + provinceOfDistrict.getName());
			district.setPathWithType(provinceOfDistrict.getType() + provinceOfDistrict.getName() + ", "
					+ district.getType() + districtDTOs.get(i).getName());
			district.setCode(districtDTOs.get(i).getCode());
			district.setParentCode(districtDTOs.get(i).getParentCode());
			district.setProvince(provinceOfDistrict);
			listDistrictDAO.add(district);
			
		}
		List<District> newDistrticts = districtRepos.saveAll(listDistrictDAO);
		return ResponseEntity.status(HttpStatus.OK).body(newDistrticts);
	}
	
	
	@PostMapping("/test")
	public ResponseEntity<?> test(@RequestBody DistrictDTO a) {
		System.out.println(a.getParentCode().toString());
		a.setParentCode(a.getParentCode());
		return ResponseEntity.status(200).body(a);
	}

}
