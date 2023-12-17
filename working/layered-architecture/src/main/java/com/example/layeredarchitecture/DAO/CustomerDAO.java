package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    boolean saveCustomers(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean updateCustomers(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    CustomerDTO getAllcusromersById(String id) throws SQLException, ClassNotFoundException;
}
