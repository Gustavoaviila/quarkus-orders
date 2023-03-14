package org.acme.client;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.acme.dto.CustomerDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/customer")
@RegisterRestClient
@ApplicationScoped
public interface CustomerClient {

  @GET
  @Path("/{id}")
  CustomerDTO getCustumerById(@PathParam("id") Long id);
}
