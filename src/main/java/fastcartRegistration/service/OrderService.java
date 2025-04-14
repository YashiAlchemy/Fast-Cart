package fastcartRegistration.service;

import fastcartRegistration.dto.OrderItemRequest;
import fastcartRegistration.dto.OrderItemResponse;
import fastcartRegistration.dto.OrderRequest;
import fastcartRegistration.dto.OrderResponse;
import fastcartRegistration.entity.Order;
import fastcartRegistration.entity.OrderItem;
import fastcartRegistration.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus("PLACED");

        // Convert LocalDateTime to Timestamp before setting orderDate
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        order.setOrderDate(timestamp); 

        List<OrderItem> itemList = new ArrayList<>();
        double total = 0;

        for (OrderItemRequest itemReq : request.getItems()) {
            OrderItem item = new OrderItem();
            item.setProductId(itemReq.getProductId());
            item.setQuantity(itemReq.getQuantity());
            item.setPrice(itemReq.getPrice());
            item.setOrder(order);

            total += itemReq.getQuantity() * itemReq.getPrice();
            itemList.add(item);
        }

        order.setTotal(total);
        order.setItems(itemList);

        Order savedOrder = orderRepo.save(order);
        return mapToOrderResponse(savedOrder);
    }

    public OrderResponse getOrderById(Integer id) {
        Optional<Order> orderOpt = orderRepo.findById(id);
        if (orderOpt.isPresent()) {
            return mapToOrderResponse(orderOpt.get());
        } else {
            // Handle "not found" scenario, return null or throw custom exception as needed
            return null; // or throw custom exception
        }
    }

    private OrderResponse mapToOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getId());
        response.setUserId(order.getUserId());
        response.setTotal(order.getTotal());
        response.setStatus(order.getStatus());
        response.setOrderDate(order.getOrderDate());

        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            OrderItemResponse itemResp = new OrderItemResponse();
            itemResp.setProductId(item.getProductId());
            itemResp.setQuantity(item.getQuantity());
            itemResp.setPrice(item.getPrice());
            itemResponses.add(itemResp);
        }
        response.setItems(itemResponses);
        return response;
    }
    
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepo.findByUserId(userId);
        List<OrderResponse> responseList = new ArrayList<>();

        for (Order order : orders) {
            responseList.add(mapToOrderResponse(order));
        }

        return responseList;
    }
}
