package org.springframework.samples.petclinic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.repositories.VetRepository;
import org.springframework.samples.petclinic.entities.Vet;
import org.springframework.samples.petclinic.entities.Vets;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Service
public class VetService {

	@Autowired
	private VetRepository vetRep;

	public Collection<Vet> getVet() {
		return (Collection<Vet>) vetRep.findAll();
	}

	/***************/
	public void setVet(Vet vet) {
		vetRep.save(vet);
	}


	public Vet nuevoVet(String nombre, String apellido) {
		Vet vet = new Vet();
		vet.setFirstName(nombre);
		vet.setLastName(apellido);

		System.out.println(vet.getFirstName() + " " + vet.getLastName());

		return vet;
	}
	/****************/

	public void VetController(VetRepository clinicService) {
		this.vetRep = clinicService;
	}

	public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for Object-Xml mapping
		Vets vets = new Vets();
		Page<Vet> paginated = findPaginated(page);
		vets.getVetList().addAll(paginated.toList());
		return addPaginationModel(page, paginated, model);

	}

	private String addPaginationModel(int page, Page<Vet> paginated, Model model) {
		List<Vet> listVets = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listVets", listVets);
		return "vets/vetList";
	}

	private Page<Vet> findPaginated(int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return vetRep.findAll(pageable);
	}

	public @ResponseBody Vets showResourcesVetList() {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects so it is simpler for JSon/Object mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetRep.findAll());
		return vets;
	}

	// Método que se comunica con el repositorio para obtener una lista de veterinarios filtrados por apellido.
	// Terminar de implementar.
	public String showVetListByLastName() {
		return ("lista de vets");
	}

	// Método que se comunica con el repositorio para obtener una lista de veterinarios filtrados por nombre.
	// Terminar de implementar.
	public String showVetListByFirstName() {
		return ("lista de vets");
	}

}
