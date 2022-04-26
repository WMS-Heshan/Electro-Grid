/*
 * package com.concretepage.service;
 * 
 * public class  {
 * 
 * }
 */
package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.concretepage.dao.IPaymentPortalDAO;

import com.concretepage.entity.PaymentDetails;
@Service
public class PaymentPortalService implements IPaymentPortalService {
	@Autowired
	private IPaymentPortalDAO paymentportalDAO;
	@Override
	public PaymentDetails getPaymentDetailsById(int paymentId) {
		PaymentDetails obj = paymentportalDAO.getPaymentDetailsById(paymentId);
		return obj;
	}	
	@Override
	public List<PaymentDetails> getAllPaymentDetails(){
		return paymentportalDAO.getAllPaymentDetails();
	}
	@Override
	public synchronized boolean addPaymentDetails(PaymentDetails paymentdetails){
       if (paymentportalDAO.PaymentDetailsExists(paymentdetails.getFullname(), paymentdetails.getEmail())) {
    	   return false;
       } else {
    	   paymentportalDAO.addPaymentDetails(paymentdetails);
    	   return true;
       }
	}
	@Override
	public void updatePaymentDetails(PaymentDetails paymentdetails) {
		paymentportalDAO.updatePaymentDetails(paymentdetails);
	}
	@Override
	public void deletePaymentDetails(int paymentId) {
		paymentportalDAO.deletePaymentDetails(paymentId);
	}
}
