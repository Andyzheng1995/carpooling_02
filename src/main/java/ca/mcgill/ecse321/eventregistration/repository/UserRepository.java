package ca.mcgill.ecse321.eventregistration.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.model.user.Admin;
import ca.mcgill.ecse321.eventregistration.model.user.Driver;
import ca.mcgill.ecse321.eventregistration.model.user.Passenger;

@Repository
public class UserRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public String createAdmin(Admin admin) {
		entityManager.persist(admin);
		return "1";
	}

	@Transactional
	public Admin getAdminByPhone(String phone) {
		Admin admin = entityManager.find(Admin.class, phone);
		return admin;
	}
	
	@Transactional
	public String createDriver(Driver driver) {
		entityManager.persist(driver);
		return "1";
	}

	@Transactional
	public Driver getDriverByPhone(String phone) {
		Driver driver = entityManager.find(Driver.class, phone);
		return driver;
	}
	
	@Transactional
	public String createPassenger(Passenger passenger) {
		entityManager.persist(passenger);
		return "1";
	}

	@Transactional
	public Passenger getPassengerByPhone(String phone) {
		Passenger passenger = entityManager.find(Passenger.class, phone);
		return passenger;
	}
}
