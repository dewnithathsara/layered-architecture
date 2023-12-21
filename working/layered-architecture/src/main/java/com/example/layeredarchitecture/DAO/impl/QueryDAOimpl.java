package com.example.layeredarchitecture.DAO.impl;

import com.example.layeredarchitecture.DAO.QueryDAO;
import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOimpl implements QueryDAO {
    @Override
    public void getDetails() {
        try {
            ResultSet rst = SqlUtil.testQuery(" SELECT * FROM Item i RIGHT JOIN OrderDetails od ON i.code = od.itemCode");

            while (rst.next()) {

            }

            System.out.println(rst);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
