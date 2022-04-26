package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.PaymentDetails;

public interface IPaymentPortalService {
	List<PaymentDetails> getAllPaymentDetails();
	PaymentDetails getPaymentDetailsById(int paymentId);
	boolean addPaymentDetails(PaymentDetails paymentdetails);
	void updatePaymentDetails(PaymentDetails paymentdetails);
	void deletePaymentDetails(int paymentId);
}
