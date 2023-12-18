package com.example.layeredarchitecture.DAO.impl;

import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAOimpl implements OrderDAO {
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.testQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
   public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        boolean isExists=false;
      ResultSet rst=SqlUtil.testQuery("SELECT oid FROM `Orders` WHERE oid=?",orderId);
       if (rst.next()) {
       }
       return isExists;
   }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {

      //ArrayList<OrderDetailDTO> dto=new ArrayList<>();
       //OrderDetailDaoImpl detailDao=new OrderDetailDaoImpl();
        return SqlUtil.testQuery("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,orderDate,customerId);
            // connection.setAutoCommit(false);




    }
}
