package com.concretepage.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.concretepage.endpoint.InquiryEndPoint;

@Component
@ApplicationPath("/spring-app")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(InquiryEndPoint.class);
	}
}
