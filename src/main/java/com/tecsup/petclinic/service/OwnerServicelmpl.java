package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.OwnerRepository;

import com.tecsup.petclinic.exception.OwnerNotFoundException;

@Service
public class OwnerServicelmpl implements OwnerService {
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerServicelmpl.class);
	@Autowired
	OwnerRepository ownerRepository;

	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) throws OwnerNotFoundException{

		Owner owner = findById(id);
		ownerRepository.delete(owner);

	}

	@Override
	public Owner findById(long id) throws OwnerNotFoundException {

		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Owner> findByFirstName(String first_name) {

		List<Owner> owners = ownerRepository.findByFirstName(first_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	@Override
	public List<Owner> findByLastName(String last_name) {

		List<Owner> owners = ownerRepository.findByLastName(last_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	public List<Owner> findByCity(String city) {

		List<Owner> owners = ownerRepository.findByCity(city);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	/**
	 * 
	 * @return
	 */
	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return ownerRepository.findAll();
	
	}

}
