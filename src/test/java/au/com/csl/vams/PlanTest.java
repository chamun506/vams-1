package au.com.csl.vams;

import org.junit.Test;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import au.com.csl.vams.client.data.Plan;

public class PlanTest {
	
	@Test
	public void testplan() throws Exception
	{
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("user");
        resourceDetails.setPassword("password");
        resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
        resourceDetails.setClientId("acme");
        resourceDetails.setClientSecret("acmesecret");
        resourceDetails.setGrantType("password");
       

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        Plan plan = restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getPlan?planId=1", Plan.class);
        System.out.println("Result is>>>>>:"+plan.getId() + plan.getStatus());
	}

}
