package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<ItemDTO> {

    ItemDTO getallItemsBycodes(String code) throws SQLException, ClassNotFoundException;

}
