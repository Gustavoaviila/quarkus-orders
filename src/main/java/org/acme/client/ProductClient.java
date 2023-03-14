package org.acme.client;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.acme.dto.ProductDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/products")
@RegisterRestClient
@ApplicationScoped
public interface ProductClient {

  @GET
  @Path("/{id}")
  ProductDTO getProductById(@PathParam("id") Long id);
}
