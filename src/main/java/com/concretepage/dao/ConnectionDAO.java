package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Connection;
@Transactional
@Repository
public class ConnectionDAO implements IConnectionDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Connection getConnectionById(int connectionId) {
		return entityManager.find(Connection.class, connectionId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Connection> getAllConnections() {
		String hql = "FROM Connection as atcl ORDER BY atcl.connectionId";
		return (List<Connection>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addConnection(Connection connection) {
		entityManager.persist(connection);
	}
	@Override
	public void updateConnection(Connection connection) {
		Connection cncl = getConnectionById(connection.getConnectionId());
		cncl.setConnectionType(connection.getConnectionType());
		cncl.setConnectionName(connection.getConnectionName());
		cncl.setConnectionDesc(connection.getConnectionDesc());
		cncl.setConnectionDate(connection.getConnectionDate());
		cncl.setConnectionPrice(connection.getConnectionPrice());
		entityManager.flush();
	}
	@Override
	public void deleteConnection(int connectionId) {
		entityManager.remove(getConnectionById(connectionId));
	}
	@Override
	public boolean connectionExists(String connectionType,String connectionName) {
		String hql = "FROM Connection as atcl WHERE atcl.connectionType = ? and atcl.connectionName = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, connectionType)
		              .setParameter(2, connectionName).getResultList().size();
		return count > 0 ? true : false;
	}
}
