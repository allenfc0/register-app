package org.perscholas.springapp.dao;

import org.perscholas.springapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepo extends JpaRepository<Order, Long>{
    Order findByOrderId(long id);
    Order deleteByOrderId(long id);
}
