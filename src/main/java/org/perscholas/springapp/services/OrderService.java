package org.perscholas.springapp.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springapp.dao.IOrdersRepo;
import org.perscholas.springapp.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class OrderService {

    private IOrdersRepo ordersRepo;

    @Autowired
    public OrderService(IOrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public Order findOrdersById(long id) {
        return this.ordersRepo.findByOrderId(id);
    }

    public Order deleteOrderById(long id) {
        return this.ordersRepo.deleteByOrderId(id);
    }


}
