package com.computershop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.computershop.repositories.DeliveryRepository;
import com.computershop.repositories.SaleOrderRepository;

@RestController
@RequestMapping("/api/sale-orders")
public class SaleOrderController {
	@Autowired
	private SaleOrderRepository saleOrderRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	
	 @GetMapping
	    public ResponseEntity<?> getAllSaleOrders(@RequestParam(name = "search", required = false) Long saleOrderId,
	                                              @RequestParam(name = "deliveryId", required = false) Long deliveryId,
	                                              @RequestParam(name = "recent", required = false) String recent) {
	        if (recent != null) {
	            if (recent.compareTo("true") == 0) {
	                Delivery delivery = deliveryRepository.findByIndex("DaGiao");

	                if (delivery == null) {
	                    throw new NotFoundException("Not found delivery by index DaGiao");
	                }

	                List<SaleOrder> saleOrders = saleOrderRepository.findByDeliveryOrderByCreateAtDesc(delivery);
	                if (saleOrders.isEmpty()) {
	                    return ResponseEntity.status(204).build();
	                }

	                List<SaleOrderResponseDTO> saleOrdersResponseDTO = new LinkedList<>();

	                for (int i = 0; i < saleOrders.size(); i++) {
	                    SaleOrderResponseDTO saleOrderResponseDTO = new SaleOrderResponseDTO();
	                    saleOrderResponseDTO.setId(saleOrders.get(i).getId());
	                    saleOrderResponseDTO.setCreateAt(saleOrders.get(i).getCreateAt());
	                    saleOrderResponseDTO.setUpdateAt(saleOrders.get(i).getUpdateAt());
	                    saleOrderResponseDTO.setCustomerAddress(saleOrders.get(i).getCustomerAddress());
	                    saleOrderResponseDTO.setDelivery(saleOrders.get(i).getDelivery());
	                    saleOrderResponseDTO.setPhone(saleOrders.get(i).getPhone());
	                    saleOrderResponseDTO.setOrderItems(saleOrders.get(i).getOrderItems());
	                    saleOrderResponseDTO.setUser(saleOrders.get(i).getUser());
	                    saleOrderResponseDTO
	                            .setProductImage(saleOrders.get(i).getOrderItems().get(0).getProduct().getProductImages().get(0));
	                    saleOrdersResponseDTO.add(saleOrderResponseDTO);
	                }

	                return ResponseEntity.status(200).body(saleOrdersResponseDTO);
	            }
	        }
	        if (deliveryId != null) {
	            List<SaleOrder> saleOrders = saleOrderRepository.findByDeliveryId(deliveryId);
	            if (saleOrders.isEmpty()) {
	                return ResponseEntity.status(204).build();
	            }
	            return ResponseEntity.status(200).body(saleOrders);
	        }
	        if (saleOrderId != null) {
	            Optional<SaleOrder> saleOrders = saleOrderRepository.findById(saleOrderId);
	            if (!saleOrders.isPresent()) {
	                return ResponseEntity.status(204).build();
	            }
	            return ResponseEntity.status(200).body(Collections.singletonList(saleOrders.get()));
	        }
	        List<SaleOrder> saleOrders = saleOrderRepository.findAll();
	        if (saleOrders.isEmpty()) {
	            return ResponseEntity.status(204).build();
	        }

	        return ResponseEntity.status(200).body(saleOrders);
	    }
}
