package com.example.transaction;

import com.example.transaction.dto.FlightBookingAcknowledgement;
import com.example.transaction.dto.FlightBookingRequest;
import com.example.transaction.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TransactionApplication {

	@Autowired
	private FlightBookingService service;
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookflightTicket(request);
	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
