package com.test.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.demo.madel.DistrictDetails;

@Service
public class DistrictService {

	private List<DistrictDetails> ditrict = new ArrayList<>(Arrays.asList(new DistrictDetails("Delhi", "1998", 198650),
			new DistrictDetails("Dholpur", "1980", 198655), new DistrictDetails("Kailash", "1998", 198650),
			new DistrictDetails("Agra", "1966", 198651), new DistrictDetails("Mumbai", "1955", 198652),
			new DistrictDetails("Solapur", "1999", 198653)));

	public List<DistrictDetails> getDistrictList() {
		return ditrict;
	}

	public DistrictDetails getDistrict(String name) {
		return ditrict.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addDistrict(DistrictDetails districtDetails) {
		
		ditrict.add(districtDetails);
	}

	public void updateDistrict(DistrictDetails district, String name) {
		for (int i = 0; i < ditrict.size(); i++) {
			DistrictDetails d= ditrict.get(i);
			if(d.getName().equals(name)){
				ditrict.set(i,district);
				return;
			}
		}
		
	}

	public void deleteDistrict(String name) {
		ditrict.removeIf(t->t.getName().equals(name));
	}
}
