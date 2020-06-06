package models.dao;

import java.sql.Connection;

public abstract class BaseDao {
    private Connection connection;

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
