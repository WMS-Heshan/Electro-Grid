package com.concretepage.service;

import java.util.List;
import com.concretepage.entity.Inquiry;

public interface IInquiryService {
	//API Actions
	List<Inquiry> getAllInquiry();

	Inquiry getInquiryById(int inquiry_Id);

	boolean addInquiry(Inquiry inquiry);

	void updateInquiry(Inquiry inquiry);

	void deleteInquiry(int inquiry_Id);
}
