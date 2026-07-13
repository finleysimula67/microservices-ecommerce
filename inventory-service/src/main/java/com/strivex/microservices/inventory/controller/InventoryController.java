package com.strivex.microservices.inventory.controller;

import com.strivex.microservices.inventory.service.InventoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryServices inventoryServices;

    @GetMapping
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryServices.isInStock(skuCode, quantity));
    }
}
