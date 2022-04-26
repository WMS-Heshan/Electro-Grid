package com.concretepage.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.concretepage.endpoint.ArticleEndpoint;
import com.concretepage.endpoint.PaymentEndpoint;

@Component
@ApplicationPath("/Electro-grid")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ArticleEndpoint.class);
		register(PaymentEndpoint.class);
	}
}
