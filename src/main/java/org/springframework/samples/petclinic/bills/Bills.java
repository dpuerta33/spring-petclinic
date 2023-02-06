package org.springframework.samples.petclinic.bills;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Bills {

	private List<Bill> bills;

	@XmlElement
	public List<Bill> getBillList() {
		if (bills == null) {
			bills = new ArrayList<>();
		}
		return bills;
	}

}
