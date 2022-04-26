package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Article;
import com.concretepage.entity.Bill;

@Transactional
@Repository
public class BillDAOimpl implements BillDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Bill> getAllBills() {
		// get all bills
		String hql = "FROM Bill as bill ORDER BY bill.billId";
		return (List<Bill>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Bill getBillById(int billId) {
		return entityManager.find(Bill.class, billId);
		
	}

	@Override
	public void addBill(Bill bill) {
		// addbills
		entityManager.persist(bill);

	}

	@Override
	public void updateBill(Bill bill) {
		Bill bil = getBillById(bill.getBillId());
		bil.setBillno(bill.getBillno());
		bil.setCustid(bill.getCustid());
		bil.setUnittype(bill.getUnittype());
		bil.setNounits(bill.getNounits());
		bil.setMonth(bill.getMonth());
		bil.setCostPer_month(bill.getCostPer_month());
		entityManager.flush();
	}

	@Override
	public void deleteBill(int billid) {
		entityManager.remove(getBillById(billid));

	}

	@Override
	public boolean billExists(String billno, String custid) {
		String hql = "FROM Bill as bill WHERE bill.billno = ? and bill.custid = ?";
		int count = entityManager.createQuery(hql).setParameter(1, billno).setParameter(2, custid).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
