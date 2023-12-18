package com.example.layeredarchitecture.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
   public static Connection connection=null;
    public static  boolean setAutoCommitFalse() throws SQLException {
        connection.setAutoCommit(false);
        return false;
    }
    public static boolean setAutoCommitTrue() throws SQLException {
        connection.setAutoCommit(true);
        return true;
    }
    public static boolean rollback() throws SQLException {
        connection.rollback();
        return true;
    }
}
