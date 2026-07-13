package com.strivex.microservices.inventory_service;

import com.strivex.microservices.inventory.InventoryServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
