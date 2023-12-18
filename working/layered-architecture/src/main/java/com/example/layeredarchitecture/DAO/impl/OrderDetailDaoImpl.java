package com.example.layeredarchitecture.DAO.impl;

import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.DAO.custom.OrderDetailDao;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public boolean savedOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        boolean isSaved = false;
      //  ItemDAOimpl daoimpl = new ItemDAOimpl();



          //  connection.setAutoCommit(false);
            for (OrderDetailDTO detail : orderDetails) {
              isSaved=  SqlUtil.testQuery("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,detail.getItemCode(),detail.getUnitPrice(),detail.getQty());
            }


        return isSaved;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailDTO object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
