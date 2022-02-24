package com.vobi.bank.repository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vobi.bank.domain.Customer;
import com.vobi.bank.domain.DocumentType;



@SpringBootTest
class CustomerRepositoryIT {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	DocumentTypeRepository documentTypeRepository;
	
	@Test
	void debeValidarLasDependencias() {
		assertNotNull(customerRepository);
		assertNotNull(documentTypeRepository);
	}
	
	@Test
	void debeCrearUnCustomer(){
		//Arrange
		Integer idDocumentType=1;
		Integer idCustomer=14836554;
		
		Customer customer=null;
		DocumentType documentType = documentTypeRepository.findById(idDocumentType).get();
		
		customer = new Customer();
		customer.setAddress("Avenida siempre aprendiendo");
		customer.setCustId(idCustomer);
		customer.setDocumentType(documentType);
		customer.setEmail("homer@gmail.com");
		customer.setEnable("Y");
		customer.setName("ole olw");
		customer.setPhone("333333");
		customer.setToken("dfwefwe3243");
		
		// Act
		
		customer=customerRepository.save(customer);
		
		//Assert
		
		assertNotNull(customer, "El customer es nulo no se puede grabar");
	}

}
