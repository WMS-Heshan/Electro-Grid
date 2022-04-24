package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Bill;

@Transactional
@Repository
public class BillDAOimpl implements BillDAO  {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Bill> getAllBills() {
		//get all bills
		String  hql ="FROM Bill as bill ORDER BY bill.billid";
		return (List<Bill>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Bill getBillById(int billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBill(Bill bill) {
		// addbills
		entityManager.persist(bill);
		
	}

	@Override
	public void updateBill(Bill bill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBill(int billid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean billExists(String billno, String custid) {
		String hql = "FROM Bill as bill WHERE bill.billno = ? and bill.custid = ?";
		int count = entityManager.createQuery(hql).setParameter(1,billno)
		              .setParameter(2, custid).getResultList().size();
		return count > 0 ? true : false;
	}

}
