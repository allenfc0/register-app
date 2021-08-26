package org.perscholas.springapp.dao;

import org.perscholas.springapp.models.OrderDetails;
import org.perscholas.springapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface IOrderDetailsRepo extends JpaRepository<OrderDetails, Long>{
    ArrayList<OrderDetails> findAllProductsByOrderId(long id);
}
