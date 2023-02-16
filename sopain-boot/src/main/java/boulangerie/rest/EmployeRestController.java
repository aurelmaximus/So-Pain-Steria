package boulangerie.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import boulangerie.model.Employe;
import boulangerie.model.Views;
import boulangerie.repository.EmployeRepository;

@RestController
@RequestMapping("/employe")
public class EmployeRestController {

	
	

		
		
			@Autowired
			private EmployeRepository employeRepository;

			@GetMapping("")
			@JsonView(Views.ViewEmploye.class)
			public List<Employe> findAll() {
				List<Employe> employes = employeRepository.findAll();

				return employes;
			}

			@GetMapping("/{id}")
			@JsonView(Views.ViewEmploye.class)
			public Employe findById(@PathVariable Integer id) {
				Optional<Employe> optEmploye = employeRepository.findById(id);

				if (optEmploye.isEmpty()) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}

				return optEmploye.get();
			}

			
			
			
			@PostMapping("")
			@JsonView(Views.ViewEmploye.class)
			public Employe create(@RequestBody Employe employe) {
				employe = employeRepository.save(employe);

				return employe;
			}

			@PutMapping("/{id}")
			@JsonView(Views.ViewEmploye.class)
			public Employe update(@RequestBody Employe employe, @PathVariable Integer id) {
				if (id != employe.getId()) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
				}

				if (!employeRepository.existsById(id)) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				}

				employe = employeRepository.save(employe);

				return employe;
			}

			@DeleteMapping("/{id}")
			public void delete(@PathVariable Integer id) {
				employeRepository.deleteById(id);
			}

		}

		



