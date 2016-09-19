/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnector.ConnectorDB;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Женя
 */
public abstract class AbstractDAO<T> {

    protected ConnectorDB connector;

    public abstract void insert(T value);

    public abstract void delete(T value);

    public abstract List<T> getAll();

    public void close() {
        connector.closeConnection();
    }

    protected void closeStatement(Statement statement) {
        connector.closeStatement(statement);
    }

}
