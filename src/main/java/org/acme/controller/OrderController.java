package org.acme.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.dto.OrderDTO;
import org.acme.service.OrderService;

@Path("/api/orders")
public class OrderController {

  @Inject
  private OrderService service;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<OrderDTO> findAll(){
    return service.findAll();
  }

  @POST
  @Transactional
  public Response saveOrder(OrderDTO order){
    try {
      service.saveOrder(order);
      return Response.ok().build();
    }catch (Exception e ){
      e.printStackTrace();
      return Response.serverError().build();
    }
  }
}
