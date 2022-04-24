package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.PaymentDetails;
@Transactional
@Repository
public class PaymentPortalDAO implements IPaymentPortalDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public PaymentDetails getPaymentDetailsById(int paymentId) {
		return entityManager.find(PaymentDetails.class, paymentId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		String hql = "FROM PaymentDetails as atcl ORDER BY atcl.paymentId";
		return (List<PaymentDetails>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addPaymentDetails(PaymentDetails paymentdetails) {
		entityManager.persist(paymentdetails);
	}
	@Override
	public void updatePaymentDetails(PaymentDetails paymentdetails) {
		PaymentDetails payment = getPaymentDetailsById(paymentdetails.getPaymentId());
		payment.setFullname(paymentdetails.getFullname());
		payment.setEmail(paymentdetails.getEmail());
		entityManager.flush();
	}
	@Override
	public void deletePaymentDetails(int paymentId) {
		entityManager.remove(getPaymentDetailsById(paymentId));
	}
	@Override
	public boolean PaymentDetailsExists(String fullname, String email) {
		String hql = "FROM PaymentDetails as atcl WHERE atcl.fullname = ? and atcl.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, fullname)
		              .setParameter(2, email).getResultList().size();
		return count > 0 ? true : false;
	}
}
