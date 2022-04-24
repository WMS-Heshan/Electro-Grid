package com.concretepage.service;

import java.util.List;


import com.concretepage.entity.Bill;

public interface BillService {
	 List<Bill> getAllArticles();
	 boolean addBill(Bill bill);
	 Bill getBillById(int billId);
	 void updateBill(Bill billId);
     void deleteBill(int billId);
     

}
