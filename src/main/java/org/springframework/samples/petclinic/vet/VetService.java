package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VetService {

	@Autowired
	private VetRepository vetRep;

	public Collection<Vet> getVet() {
		return (Collection<Vet>) vetRep.findAll();
	}

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

}
