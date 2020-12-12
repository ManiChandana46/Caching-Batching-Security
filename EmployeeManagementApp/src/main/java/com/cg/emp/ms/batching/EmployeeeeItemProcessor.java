package com.cg.emp.ms.batching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.cg.emp.ms.model.Employeeee;

@Component
public class EmployeeeeItemProcessor implements ItemProcessor<Employeeee,Employeeee>{
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeeeItemProcessor.class);

	@Override
	public Employeeee process(final Employeeee Employeeee) throws Exception {
		System.out.println("Entering into processor");
		
		//just a processor (not compulsory)for lower case to uppercase
		final String firstName = Employeeee.getFirstName().toUpperCase();
		final String lastName = Employeeee.getLastName().toUpperCase();

		final Employeeee transformedEmployeeee = new Employeeee(Employeeee.getEmpId(), firstName, lastName, Employeeee.getEmail(), Employeeee.getSalary());

		log.info("Converting (" + Employeeee + ") into (" + transformedEmployeeee + ")");

		return transformedEmployeeee;
	}

}
