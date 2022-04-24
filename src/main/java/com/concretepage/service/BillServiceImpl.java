package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.BillDAO;
import com.concretepage.entity.Bill;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillDAO billDAO;
	
	@Override
	public List<Bill> getAllArticles() {
		// TODO Auto-generated method stub
		return billDAO.getAllBills();
	}

	@Override
	public boolean addBill(Bill bill) {
		 if (billDAO.billExists(bill.getBillno(),bill.getCustid())) {
	    	   return false;
	       } else {
	    	   billDAO.addBill(bill);
	    	   return true;
	       }
	}

	@Override
	public Bill getBillById(int billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBill(Bill billId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBill(int billId) {
		
		billDAO.deleteBill(billId);
	}

	

}