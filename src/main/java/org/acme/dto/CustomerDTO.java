package org.acme.dto;

import io.quarkus.arc.All;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class CustomerDTO {

  private Long id;
  private String name;
  private String phone;
  private String email;
  private String address;
  private Long age;
}
