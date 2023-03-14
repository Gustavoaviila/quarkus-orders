package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import org.acme.client.CustomerClient;
import org.acme.client.ProductClient;
import org.acme.dto.CustomerDTO;
import org.acme.dto.OrderDTO;
import org.acme.entity.OrderEntity;
import org.acme.repository.OrderRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class OrderService {

  @Inject
  private OrderRepository repository;

  @Inject
  @RestClient
  private CustomerClient customerClient;

  @Inject
  @RestClient
  private ProductClient productClient;

  public List<OrderDTO> findAll(){
    List<OrderDTO> orders = new ArrayList<>();

    repository.findAll().stream().forEach(item ->{
      orders.add(mapEntityToDTO(item));
    });
    return orders;
  }

  public void saveOrder(OrderDTO orderDTO){

    CustomerDTO customerDTO = customerClient.getCustumerById(orderDTO.getCustomerId());

    if(customerDTO.getName().equals(orderDTO.getCustomerName())
        && productClient.getProductById(orderDTO.getProductId()) != null){
      repository.persist(mapDTOToEntity(orderDTO));
    }else{
      throw new NotFoundException();
    }
  }

  private OrderDTO mapEntityToDTO(OrderEntity entity){

    OrderDTO dto = new OrderDTO();

    dto.setOrderValue(entity.getOrderValue());
    dto.setCustomerId(entity.getCustomerId());
    dto.setCustomerName(entity.getCustomerName());
    dto.setProductId(entity.getProductId());

    return dto;
  }

  private OrderEntity mapDTOToEntity(OrderDTO dto){

    OrderEntity entity = new OrderEntity();

    entity.setOrderValue(dto.getOrderValue());
    entity.setCustomerId(dto.getCustomerId());
    entity.setCustomerName(dto.getCustomerName());
    entity.setProductId(dto.getProductId());

    return entity;
  }
}
