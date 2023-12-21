package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {

    public static <T>T testQuery(String sql,Object...objects) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
            for(int i=0;i< objects.length;i++){
                pstm.setObject(i+1,objects[i]);
            }
        if(sql.startsWith("SELECT")){
          return (T) pstm.executeQuery();
        }else{
          return (T)(Boolean ) (pstm.executeUpdate()>0);
        }
    }
}
