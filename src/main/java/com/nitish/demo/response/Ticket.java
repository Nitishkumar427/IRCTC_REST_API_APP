package com.nitish.demo.response;

import lombok.Data;

@Data
public class Ticket {
	
	private Integer ticketId;
	private String from;
	private String to;
	private String trainNum;
	private String txtCost;
	private String ticketStatus;

}
