package com.nitish.demo.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitish.demo.request.Passenger;
import com.nitish.demo.response.Ticket;

@RestController
public class ErailRestController {

	private Map<Integer, Ticket> tickets = new HashMap<>();

	Random rand = new Random();

	@PostMapping(

			value = "/ticket", consumes = { "application/xml", "application/json" }, produces = { "application/xml",
					"application/json" }

	)

	public Ticket bookTicket(@RequestBody Passenger passenger) {
		Ticket ticket = new Ticket();

		int ticketId = rand.nextInt(100000000);

		ticket.setTicketId(ticketId);

		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());
		ticket.setTrainNum(passenger.getTrainNum());
		ticket.setTxtCost("1500.50 INR");
		ticket.setTicketStatus("CONFIRMED");

		tickets.put(ticketId, ticket);

		return ticket;
	}

	@GetMapping(

			value = "/ticket/{ticketId}", produces = { "application/xml", "application/json" }

	)

	public Ticket getticket(@PathVariable Integer ticketId) {
		if (tickets.containsKey(ticketId)) {
			return tickets.get(ticketId);
		}

		return null;
	}

}
