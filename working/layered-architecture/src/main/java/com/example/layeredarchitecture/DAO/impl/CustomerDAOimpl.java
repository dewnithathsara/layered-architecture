package com.example.layeredarchitecture.DAO.impl;

import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {


    ResultSet rst = SqlUtil.testQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO>  getallcustomers=new ArrayList<>();
        while(rst.next()){
            CustomerDTO customerDTO=new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            getallcustomers.add(customerDTO);
        }
       return getallcustomers;
}
    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
       // PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
    return  SqlUtil.testQuery("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());

    }
    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

      return SqlUtil.testQuery("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());

    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
      ResultSet  rst= SqlUtil.testQuery("SELECT id FROM Customer WHERE id=?",id);
      return rst.next();
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.testQuery("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.testQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
           String id= rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

    }
    @Override
    public CustomerDTO getAllcusromersById(String id) throws SQLException, ClassNotFoundException {

       ResultSet rst= SqlUtil.testQuery("SELECT * FROM Customer WHERE id=?",id);

       rst.next();
      return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));

    }

}
