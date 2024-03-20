package com.suraj.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
@Id	
int ticketid;
int userid;
int trainid;


public Ticket(int ticketid, int userid, int trainid) {
	super();
	this.ticketid = ticketid;
	this.userid = userid;
	this.trainid = trainid;
}

public Ticket() {
	super();
	// TODO Auto-generated constructor stub
}





public int getTicketid() {
	return ticketid;
}


public void setTicketid(int ticketid) {
	this.ticketid = ticketid;
}


public int getUserid() {
	return userid;
}


public void setUserid(int userid) {
	this.userid = userid;
}


public int getTrainid() {
	return trainid;
}


public void setTrainid(int trainid) {
	this.trainid = trainid;
}

}




