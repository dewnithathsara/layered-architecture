package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public boolean saveOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
