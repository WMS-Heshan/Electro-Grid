package com.concretepage.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.concretepage.entity.Inquiry;

public class JerseyClient {
	// Get Inquiry Details List
	public void getInquiryDetails() {
		Client client = ClientBuilder.newClient();
		//URL for get All Inquiry Details
		WebTarget base = client.target("http://localhost:8080/Electro-grid/inquiry");
		WebTarget details = base.path("inqdetails");
		List<Inquiry> list = details.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Inquiry>>() {
		});

		list.stream()
				.forEach(inquiry -> System.out.println(
						inquiry.getInquiry_Id() + ", " + inquiry.getFull_name() + ", " + inquiry.getPhone_no() + ", "
								+ inquiry.getEmail() + ", " + inquiry.getAddress() + "," + inquiry.getDescription()));

		client.close();
	}

//Get Inquiry Details By Id
	public void getInquiryById(int inquiry_Id) {
		Client client = ClientBuilder.newClient();
		//URL for get Inquiry Details By Id
		WebTarget base = client.target("http://localhost:8080/Electro-grid/inquiry");
		WebTarget inquiryById = base.path("{id}").resolveTemplate("id", inquiry_Id);
		Inquiry inquiry = inquiryById.request(MediaType.APPLICATION_JSON).get(Inquiry.class);

		System.out.println(inquiry.getInquiry_Id() + ", " + inquiry.getFull_name() + ", " + inquiry.getPhone_no() + ", "
				+ inquiry.getEmail() + ", " + inquiry.getAddress() + "," + inquiry.getDescription());

		client.close();
	}

//Add Inquiry Details
	public void addInquiry(Inquiry inquiry) {
		Client client = ClientBuilder.newClient();
		//URL for Add Inquiry Details
		WebTarget base = client.target("http://localhost:8080/Electro-grid/inquiry");
		WebTarget add = base.path("inqadd");
		Response response = add.request(MediaType.APPLICATION_JSON).post(Entity.json(inquiry));

		System.out.println("Response Http Status: " + response.getStatus());
		System.out.println(response.getLocation());
		

		client.close();
	}
//Update Inquiry Details
	public void updateInquiry(Inquiry inquiry) {
		Client client = ClientBuilder.newClient();
		//URL for Update Inquiry Details
		WebTarget base = client.target("http://localhost:8080/Electro-grid/inquiry");
		WebTarget update = base.path("inqupdate");
		Response response = update.request(MediaType.APPLICATION_JSON).put(Entity.json(inquiry));

		System.out.println("Response Http Status: " + response.getStatus());
		Inquiry inq = response.readEntity(Inquiry.class);
		System.out.println(inq.getInquiry_Id() + ", " + inq.getFull_name() + ", " + inq.getPhone_no() + ", "
				+ inq.getEmail() + ", " + inq.getAddress() + "," + inq.getDescription());
		

		client.close();
	}
//Delete Inquiry Details
	public void deleteInquiry(int inquiry_Id) {
		Client client = ClientBuilder.newClient();
		//URL for Delete Inquiry Details
		WebTarget base = client.target("http://localhost:8080/Electro-grid/inquiry");
		WebTarget deleteById = base.path("{id}").resolveTemplate("id", inquiry_Id);
		Response response = deleteById.request(MediaType.APPLICATION_JSON).delete();

		System.out.println("Response Http Status: " + response.getStatus());
		if (response.getStatus() == 204) {
			System.out.println("Data deleted successfully.");
		}

		client.close();
	}

	public static void main(String[] args) {
		JerseyClient jerseyClient = new JerseyClient();
		jerseyClient.getInquiryDetails();
		// jerseyClient.getArticleById(102);

		Inquiry inquiry = new Inquiry();
		inquiry.setFull_name("Spring REST Security using Hibernate2");
		inquiry.setPhone_no("Spring");
		inquiry.setEmail("REST");
		inquiry.setAddress("Address");
		inquiry.setDescription("Description");
		// jerseyClient.addInquiry(inquiry);

		inquiry.setInquiry_Id(105);
		// jerseyClient.updateInquiry(inquiry);

		// jerseyClient.deleteInquiry(105);
	}
}
