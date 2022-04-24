package com.concretepage.dao;

import java.util.List;
import com.concretepage.entity.PaymentDetails;

public interface IPaymentPortalDAO {
	List<PaymentDetails> getAllPaymentDetails();
	PaymentDetails getPaymentDetailsById(int articleId);
	void addPaymentDetails(PaymentDetails article);
	void updatePaymentDetails(PaymentDetails article);
	void deletePaymentDetails(int articleId);
	boolean PaymentDetailsExists(String title, String category);
}
