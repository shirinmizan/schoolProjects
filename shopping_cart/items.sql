CREATE database store;

use store;

CREATE table items (
	
	itemCode INT NOT NULL,
	
	itemName VARCHAR(40)  NOT NULL,
	
	Price DOUBLE,
	
	PRIMARY KEY (itemCode));
