package com.example.layeredarchitecture.DAO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    String genarateOrderId() throws SQLException, ClassNotFoundException;
    boolean existId(String orderId) throws SQLException, ClassNotFoundException;
    boolean saveOrders(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
