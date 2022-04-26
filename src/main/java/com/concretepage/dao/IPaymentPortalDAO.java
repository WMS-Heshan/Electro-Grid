package com.concretepage.dao;

import java.util.List;
import com.concretepage.entity.PaymentDetails;

public interface IPaymentPortalDAO {
	List<PaymentDetails> getAllPaymentDetails();
	PaymentDetails getPaymentDetailsById(int paymentId);
	void addPaymentDetails(PaymentDetails paymentdetails);
	void updatePaymentDetails(PaymentDetails paymentdetails);
	void deletePaymentDetails(int paymentId);
	boolean PaymentDetailsExists(String fullname, String email);
}
