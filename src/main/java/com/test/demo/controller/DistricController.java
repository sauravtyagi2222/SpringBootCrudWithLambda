package com.test.demo.controller;

import java.lang.invoke.MethodType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.madel.DistrictDetails;
import com.test.demo.service.DistrictService;

@RestController
public class DistricController {

	@Autowired
	private DistrictService districtService;

	@RequestMapping("district")
	public List<DistrictDetails> getDistrict() {
		return districtService.getDistrictList();
	}

	@RequestMapping("district/{name}")
	public DistrictDetails getDistrict(@PathVariable String name) {
		System.out.println(name);
		return districtService.getDistrict(name);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/district")
	public void addDistrict(@RequestBody DistrictDetails districtDetails) {
		districtService.addDistrict(districtDetails);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/district/{name}")
	public void updateDistrict(@RequestBody DistrictDetails district,@PathVariable String name){
		districtService.updateDistrict(district,name);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/district/{name}")
	public void deleteDistrict(@PathVariable String name){
		districtService.deleteDistrict(name);
	}
}
