package com.concretepage.service;

import java.util.List;
import com.concretepage.entity.Bill;

public interface BillService {
	 List<Bill> getAllArticles();
	 boolean addBill(Bill bill);
     

}
