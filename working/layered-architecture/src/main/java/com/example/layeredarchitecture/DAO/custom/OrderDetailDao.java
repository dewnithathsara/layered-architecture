package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao extends CrudDAO<OrderDetailDTO> {
    boolean savedOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException;

}
