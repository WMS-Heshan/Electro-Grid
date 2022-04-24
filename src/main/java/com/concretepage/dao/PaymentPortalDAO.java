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
		payment.setTitle(paymentdetails.getTitle());
		payment.setCategory(paymentdetails.getCategory());
		entityManager.flush();
	}
	@Override
	public void deletePaymentDetails(int articleId) {
		entityManager.remove(getPaymentDetailsById(articleId));
	}
	@Override
	public boolean PaymentDetailsExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
