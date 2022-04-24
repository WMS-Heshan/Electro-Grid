package com.concretepage.service;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.concretepage.dao.IInquiryDAO;
import com.concretepage.entity.Inquiry;
@Service
public class InquiryService implements IInquiryService {
@Autowired
private IInquiryDAO inquiryDAO;
@Override
public Inquiry getInquiryById(int inquiry_Id) {
Inquiry obj = inquiryDAO.getInquiryById(inquiry_Id);
return obj;
}
@Override
public List<Inquiry> getAllInquiry(){
return inquiryDAO.getAllInquiry();
}
@Override
public synchronized boolean addInquiry(Inquiry inquiry){
if (inquiryDAO.inquiryExists(inquiry.getFull_name(), inquiry.getPhone_no(), inquiry.getEmail(), inquiry.getAddress(), inquiry.getDescription())) {
return false;
} else {
inquiryDAO.addInquiry(inquiry);
return true;
}
}
@Override
public void updateInquiry(Inquiry inquiry) {
inquiryDAO.updateInquiry(inquiry);
}
@Override
public void deleteInquiry(int inquiry_Id) {
inquiryDAO.deleteInquiry(inquiry_Id);
}
}