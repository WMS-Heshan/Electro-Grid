package com.concretepage.dao;

import java.util.List;
import com.concretepage.entity.Bill;

public interface BillDAO {
	List<Bill> getAllBills();
    Bill getBillById(int billId);
    void addBill(Bill bill);
    void updateBill(Bill bill);
    void deleteBill(int billid);
    boolean billExists(String billno, String custid);

}
