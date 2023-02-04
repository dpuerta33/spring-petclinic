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

package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */

@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication {
	/*
		TAREA 1:
		1.Crear un objeto Vet sin Speciality.
		2.Persistir el objeto Vet en BBDD.
		3.Consultar por ID y comprobar que se ha creado correctamente.
		4.Editar el elemento recién creado para añadir una Speciality concreta.
		5.Listar todos los veterinarios existentes.
		6. Subir a un repo público de Github.

		TAREA 2:
		1 Obtener una lista de Vets filtrando por lastName.
		2 Obtener una lista de Vets filtrando por firstName y lastName.
		3 Obtener una lista de Vets buscando en firstName o lastName.
		Crearemos un service para implementar la capa de lógica de negocio:
		(PetRepository y SpecialityRepository).

		TAREAS EXTRA:
		4 Obtener las mascotas nacidas en 2010 ordenadas por fecha de nacimiento ascendente.
		5 Crear 3 visitas nuevas para diferentes mascotas.
		6 Obtener todas las visitas para una mascota.
		7 Obtener las 4 visitas más recientes de todo el sistema.
	*/
	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);

		//createVet("Juan","Perez");
	}

}
