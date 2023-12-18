package com.example.layeredarchitecture.DAO.impl;

import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOimpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        //Connection connection = DBConnection.getDbConnection().getConnection();

        ResultSet rst = SqlUtil.testQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> getAllitems=new ArrayList<>();
        while (rst.next()) {
            ItemDTO itemdto=new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
            getAllitems.add(itemdto) ;
        }
        return getAllitems;
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {

        return SqlUtil.testQuery("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SqlUtil.testQuery("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SqlUtil.testQuery("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {

      ResultSet rst = SqlUtil.testQuery("SELECT code FROM Item WHERE code=?",code);

        return rst.next();
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.testQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id= rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override
    public ItemDTO getallItemsBycodes(String code) throws SQLException, ClassNotFoundException {

        ResultSet rst= SqlUtil.testQuery("SELECT * FROM Item WHERE code=?",code);

        rst.next();
        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}
