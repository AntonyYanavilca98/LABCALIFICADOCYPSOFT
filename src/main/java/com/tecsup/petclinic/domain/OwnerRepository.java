package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
		List<Owner> findByFirstName(String first_name);

		List<Owner> findByLastName(String last_name);

		List<Owner> findByCity(String city);
}
