package com.concretepage.dao;

import java.util.List;
import com.concretepage.entity.Inquiry;

public interface IInquiryDAO {
	//API Actions
	List<Inquiry> getAllInquiry();

	Inquiry getInquiryById(int inquiry_Id);

	void addInquiry(Inquiry inquiry);

	void updateInquiry(Inquiry inquiry);

	void deleteInquiry(int inquiry_Id);

	boolean inquiryExists(String full_name, String phone_no, String email, String address, String description);

}
