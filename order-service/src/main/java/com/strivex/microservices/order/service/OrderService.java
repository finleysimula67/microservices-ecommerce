package com.strivex.microservices.order.service;

import com.strivex.microservices.order.client.InventoryClient;
import com.strivex.microservices.order.dto.OrderRequest;
import com.strivex.microservices.order.dto.OrderResponse;
import com.strivex.microservices.order.model.Order;
import com.strivex.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            Order savedOrder = orderRepository.save(order);

            return new OrderResponse(savedOrder.getId(), savedOrder.getOrderNumber(),
                    savedOrder.getSkuCode(), savedOrder.getPrice(),
                    savedOrder.getQuantity());
        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getOrderNumber(),
                        order.getSkuCode(),
                        order.getPrice(),
                        order.getQuantity()
                ))
                .toList();
    }
}
