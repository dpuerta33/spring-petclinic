package org.springframework.samples.petclinic.bills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BillService {

	@Autowired
	private BillRepository billRep;

	private String addPaginationModel(int page, Page<Bill> paginated, Model model) {
		List<Bill> listBills = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listBills", listBills);
		return "bills/billsList";
	}

	private Page<Bill> findPaginated(int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return billRep.findAll(pageable);
	}

	public String showBillList(@RequestParam(defaultValue = "1") int page, Model model) {
		Bills bills = new Bills();
		Page<Bill> paginated = findPaginated(page);
		bills.getBillList().addAll(paginated.toList());
		return addPaginationModel(page, paginated, model);
	}
}
