/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.services.VetService;
import org.springframework.samples.petclinic.entities.Vets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {

	@Autowired
	VetService vetService;

	@GetMapping("/vets.html")
	public String showVetList (@RequestParam(defaultValue = "1") int page, Model model){
		return vetService.showVetList(page, model);
	}

	@GetMapping({ "/vets" })
	public @ResponseBody Vets showResourcesVetList() {
		return vetService.showResourcesVetList();
	}

	/* Esta función crea un veterinario y lo añade a la base de datos.
	Contiene datos de prueba. La vista de momento no existe. */
	@GetMapping({ "/newvet" })
	public void createVet() {
		vetService.setVet(vetService.nuevoVet("Pepe","Perez"));
	}
}
