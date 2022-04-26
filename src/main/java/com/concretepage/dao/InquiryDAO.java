package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Inquiry;

@Transactional
@Repository
public class InquiryDAO implements IInquiryDAO {
	@PersistenceContext
	//Create Object for EntityManager
	private EntityManager entityManager;
//Get Inquiry By ID
	@Override
	public Inquiry getInquiryById(int inquiry_Id) {
		return entityManager.find(Inquiry.class, inquiry_Id);
	}
//Get All Inquiry Details
	@SuppressWarnings("unchecked")
	@Override
	public List<Inquiry> getAllInquiry() {
		String hql = "FROM Inquiry as inq ORDER BY inq.inquiry_Id";
		return (List<Inquiry>) entityManager.createQuery(hql).getResultList();
	}
//Add Inquiry Details
	@Override
	public void addInquiry(Inquiry inquiry) {
		entityManager.persist(inquiry);
	}
//Update Inquiry Details
	@Override
	public void updateInquiry(Inquiry inquiry) {
		Inquiry inqu = getInquiryById(inquiry.getInquiry_Id());
		inqu.setFull_name(inquiry.getFull_name());
		inqu.setPhone_no(inquiry.getPhone_no());
		inqu.setEmail(inquiry.getEmail());
		inqu.setAddress(inquiry.getAddress());
		inqu.setDescription(inquiry.getDescription());
		entityManager.flush();
	}
//Delete Inquiry Details
	@Override
	public void deleteInquiry(int inquiry_Id) {
		entityManager.remove(getInquiryById(inquiry_Id));
	}

	@Override
	public boolean inquiryExists(String full_name, String phone_no, String email, String address, String description) {
		String hql = "FROM Inquiry as inq WHERE inq.full_name = ? and  inq.phone_no = ? and inq.email = ? and inq.address = ? and inq.description = ?";
		int count = entityManager.createQuery(hql).setParameter(1, full_name).setParameter(2, phone_no)
				.setParameter(3, email).setParameter(4, address).setParameter(5, description).getResultList().size();
		return count > 0 ? true : false;
	}

}
