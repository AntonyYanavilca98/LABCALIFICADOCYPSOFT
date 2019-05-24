package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	@Autowired
	private OwnerService OwnerService;
	
	@Test
	public void testFindOwnerByFirstName() {

		String ENCONTRAR_NAME = "Harold";
		int SIZE_EXPECTED = 1;

		List<Owner> o = OwnerService.findByFirstName(ENCONTRAR_NAME);

		assertEquals(SIZE_EXPECTED, o.size());
	}
	
	@Test
	public void testFindOwnerByLastName() {

		String LAST_NAME = "Black";
		Owner owner;
		List<Owner> owners = OwnerService.findByLastName(LAST_NAME);
		owner = owners.get(0);
		
		assertEquals(LAST_NAME, owner.getLastName());
		logger.info("Apellido del dueño '" + LAST_NAME + "' encontrado.");
	}
	
	@Test
	public void testFindOwnerByCity() {

		String CITY = "Madison";
		int SIZE_EXPECTED = 4;
		
		List<Owner> O = OwnerService.findByCity(CITY);
		
		assertEquals(SIZE_EXPECTED, O.size());
		logger.info("Owner with city '" + CITY + "' found.");
	}

	@Test
	public void testDeleteOwner() throws OwnerNotFoundException {
		
		String FIRST_NAME = "Antony";
		String LAST_NAME = "Yanavilca";
		String CITY = "Lima";

		Owner O = new Owner(FIRST_NAME, LAST_NAME, CITY);
		O = OwnerService.create(O);
		logger.info("Owner create: " + O);

		try {
			OwnerService.delete(O.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			OwnerService.findById(O.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		} 
				

	}
	
	@Test
	public void testCreateAndCheckOwner() {
		
		String FIRST_NAME = "Antony";
		String LAST_NAME = "Yanavilca";
		String CITY = "Lima";
		
		Owner O = new Owner(FIRST_NAME, LAST_NAME, CITY);
		O = OwnerService.create(O);
		
		try {
			Owner ownerFound = OwnerService.findById(O.getId());
			logger.info("Existe Oner");
		}catch (OwnerNotFoundException e) {
			logger.info("Dueño no ha sido creado");
		}
		
		Iterable<Owner> own = OwnerService.findAll();
		
		while(own.iterator().hasNext()) {
			try {
				Owner ownerFound = OwnerService.findById(O.getId());
				logger.info("Dueño con el ID: "+ ownerFound.getId() + " si existe");
				break;
			}catch (OwnerNotFoundException e) {
				logger.info("El Dueño no existe");
			}
		}
	}
}







