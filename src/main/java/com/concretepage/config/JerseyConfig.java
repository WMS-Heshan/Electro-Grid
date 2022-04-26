package com.concretepage.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.concretepage.endpoint.BillEndPoint;
import com.concretepage.endpoint.ConnectionEndpoint;
import com.concretepage.endpoint.CustomerEndpoint;
import com.concretepage.endpoint.EmployeeEndpoint;
import com.concretepage.endpoint.InquiryEndPoint;
import com.concretepage.endpoint.PaymentEndpoint;

@Component
@ApplicationPath("/Electro-grid")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(BillEndPoint.class);
		register(ConnectionEndpoint.class);
		register(CustomerEndpoint.class);
		register(EmployeeEndpoint.class);
		register(InquiryEndPoint.class);
		register(PaymentEndpoint.class);
	}
}
