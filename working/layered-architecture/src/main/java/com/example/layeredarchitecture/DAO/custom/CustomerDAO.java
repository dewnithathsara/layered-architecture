package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {

    CustomerDTO getAllcusromersById(String id) throws SQLException, ClassNotFoundException;
}
