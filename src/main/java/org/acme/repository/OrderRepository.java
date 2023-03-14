package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.OrderEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<OrderEntity> {
}
