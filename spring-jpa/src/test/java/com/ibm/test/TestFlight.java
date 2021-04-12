package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;
import com.ibm.repo.FlightRepositoryImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {

	@Autowired
	private FlightRepository repo;
	
	
	
	@Test
	public void testSave() {
		Flight f = new Flight("ID102", "Trivandrum", "Bangalore", "AirIndia");
		assertNotNull(repo.save(f));
	}
	
	@Test
	public void testFetch() {
		Flight f = repo.fetch("ID101");
		assertNotNull(f);
		System.out.println(f);
	}
	
	@Test
	public void testFetchAll() {
		List<Flight> flights = repo.fetchAll();
		assertNotNull(flights);
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testRemove() {
		assertTrue(repo.remove("ID101"));
	}
	
	@Test
	public void testUpdate() {
		Flight f = new Flight("ID101", "Trivandrum", "Bangalore", "Indigo");
		assertTrue(repo.update(f));
		System.out.println(f);
	}
	
	@Test
	public void testFindByCarrier() {
		List<Flight> flights = repo.findByCarrier("Indigo");
		assertNotNull(flights);
		flights.forEach(System.out::println);
	}
}
