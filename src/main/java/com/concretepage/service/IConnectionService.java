package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Connection;

public interface IConnectionService {
     List<Connection> getAllConnections();
     Connection getConnectionById(int connectionId);
     boolean addConnection(Connection connection);
     void updateConnection(Connection connection);
     void deleteConnection(int connectionId);
}
