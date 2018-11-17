package ca.mcgill.ecse321.eventregistration.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ca.mcgill.ecse321.eventregistration.model.user.Admin;
import ca.mcgill.ecse321.eventregistration.model.user.Driver;
import ca.mcgill.ecse321.eventregistration.model.user.Passenger;
import ca.mcgill.ecse321.eventregistration.repository.UserRepository;

@Controller
public class UserController{
	
	@Autowired UserRepository userRepository;
	
	
	@PostMapping("/register/{role}")
	public String createUser(@PathVariable("role") String role, 
			@RequestParam(name="name") String name,
			@RequestParam(name="phone") String phone,
			@RequestParam(name="pwd") String pwd,
			@RequestParam(name="repwd") String repwd,			
			@RequestParam(name="age") String age,
			@RequestParam(name="sex") String sex
			) {
		Map<String, Object> retMap = new ConcurrentHashMap<>();
		
		//backend confirmation of input information
		if(StringUtils.isEmpty(phone)) {
			retMap.put("errorMessage", "Please enter phone number.");
			return JSON.toJSONString(retMap);
		}
		
		if(!Pattern.matches("[1-9]\\d{9}$", phone)) {
			retMap.put("errorMessage", "Please enter valid phone number.");
			return JSON.toJSONString(retMap);
		}
		
		if(StringUtils.isEmpty(pwd)) {
			retMap.put("errorMessage", "Please enter password.");
			return JSON.toJSONString(retMap);
		}
		
		if(StringUtils.isEmpty(repwd)) {
			retMap.put("errorMessage", "Please confirm password.");
			return JSON.toJSONString(retMap);
		}
		
		if(!StringUtils.equals(pwd, repwd)) {
			retMap.put("errorMessage", "Password is not consistent.");
			return JSON.toJSONString(retMap);
		}

		if(StringUtils.isEmpty(sex)) {
			retMap.put("errorMessage", "Please enter gender.");
			return JSON.toJSONString(retMap);
		}
		
		if(StringUtils.isEmpty(age)) {
			retMap.put("errorMessage", "Please enter age.");
			return JSON.toJSONString(retMap);
		}
		
		//------------------ check if the user existed -----------------//

		if ("0".equals(role)) {
			//admin
			Admin admin = userRepository.getAdminByPhone(phone);
			if (admin == null) {
				try {
					admin = new Admin();
					admin.setAge(age);
					admin.setName(name);
					admin.setPhone(phone);
					admin.setPwd(pwd);
					admin.setSex(sex);
					System.out.println(admin);
						
					String msg = userRepository.createAdmin(admin);
					
					//after register, go back to the login page.
					return msg;
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else {
				retMap.put("errorMessage","The phone number has already been registered.");
				return JSON.toJSONString(retMap);
			}
			return JSON.toJSONString(retMap);
		} else if ("1".equals(role)) {
			Driver driver = userRepository.getDriverByPhone(phone);
			// Check whether we already have this phone registered
			if (driver == null) {
				try {
					driver = new Driver();
					driver.setAge(age);
					driver.setName(name);
					driver.setPhone(phone);
					driver.setPwd(pwd);
					driver.setSex(sex);
						
					String msg = userRepository.createDriver(driver);
					return msg;
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else {
				retMap.put("errorMessage","The phone number has already been registered.");
				return JSON.toJSONString(retMap);
			}
		} else if ("2".equals(role)) {
			Passenger passenger = userRepository.getPassengerByPhone(phone);
			// Check whether we already have this phone registered
			if (passenger == null) {
				try {
					passenger = new Passenger();
					passenger.setAge(age);
					passenger.setName(name);
					passenger.setPhone(phone);
					passenger.setPwd(repwd);
					passenger.setSex(sex);
						
					String msg = userRepository.createPassenger(passenger);
					return msg;
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else {
				retMap.put("errorMessage","The phone number has already been registered.");
				return JSON.toJSONString(retMap);
			}
			
			
		}
		return JSON.toJSONString(retMap);
	}



}

