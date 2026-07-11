package com.ripan.bharatpayops.order.service;

import com.ripan.bharatpayops.order.dto.CreateOrderRequest;
import com.ripan.bharatpayops.order.dto.OrderResponse;
import com.ripan.bharatpayops.order.entity.OrderEntity;
import com.ripan.bharatpayops.order.exception.OrderNotFoundException;
import com.ripan.bharatpayops.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest order) {
        OrderEntity orderEntity = new OrderEntity(
                order.getCustomerId(),
                order.getMerchantId(),
                order.getAmount(),
                order.getCurrency()
        );

        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return OrderResponse.from(savedOrderEntity);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrder(UUID orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderNotFoundException(orderId)
        );
        return OrderResponse.from(orderEntity);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                // findAll gives List<OrderEntity>
                .stream()
                /* shorthand for .map(order -> OrderResponse.from(order))
                 This is called Method reference => OrderResponse::from
                And we converted each OrderEntity to OrderResponse by calling from method*/
                .map(OrderResponse::from)
                .toList();
    }
}
