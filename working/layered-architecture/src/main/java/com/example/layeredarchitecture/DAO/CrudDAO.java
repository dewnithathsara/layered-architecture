package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T object) throws SQLException, ClassNotFoundException;
    boolean update(T object) throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;


}
