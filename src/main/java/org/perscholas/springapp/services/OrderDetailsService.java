package org.perscholas.springapp.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springapp.dao.IOrderDetailsRepo;
import org.perscholas.springapp.models.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class OrderDetailsService {

    private IOrderDetailsRepo orderDetails;

    @Autowired
    public OrderDetailsService(IOrderDetailsRepo orderDetails) {
        this.orderDetails = orderDetails;
    }

    //this method will be tested
    public ArrayList<OrderDetails> findAllProductsByOrderId(long id) {
        return findAllProductsByOrderId(id);
    }

}
