package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IConnectionDAO;
import com.concretepage.entity.Connection;
@Service
public class ConnectionService implements IConnectionService {
	@Autowired
	private IConnectionDAO connectionDAO;
	@Override
	public Connection getConnectionById(int connectionId) {
		Connection obj = connectionDAO.getConnectionById(connectionId);
		return obj;
	}	
	@Override
	public List<Connection> getAllConnections(){
		return connectionDAO.getAllConnections();
	}
	@Override
	public synchronized boolean addConnection(Connection connection){
       if (connectionDAO.connectionExists(connection.getConnectionType(), connection.getConnectionName())) {
    	   return false;
       } else {
    	   connectionDAO.addConnection(connection);
    	   return true;
       }
	}
	@Override
	public void updateConnection(Connection connection) {
		connectionDAO.updateConnection(connection);
	}
	@Override
	public void deleteConnection(int connectionId) {
		connectionDAO.deleteConnection(connectionId);
	}
}
