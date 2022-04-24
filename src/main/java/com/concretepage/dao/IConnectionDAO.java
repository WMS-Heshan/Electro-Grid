package com.concretepage.dao;
import java.util.List;
import com.concretepage.entity.Connection;
public interface IConnectionDAO {
    List<Connection> getAllConnections();
    Connection getConnectionById(int connectionId);
    void addConnection(Connection connection);
    void updateConnection(Connection connection);
    void deleteConnection(int connectionId);
    boolean connectionExists(String connectionType,String connectionName);
}
 