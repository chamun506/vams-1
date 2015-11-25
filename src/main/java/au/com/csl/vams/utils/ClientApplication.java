package au.com.csl.vams.utils;


import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import au.com.csl.vams.client.data.Plan;


public class ClientApplication {
	
	public void getPlanRestService(){
	try{
		ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("user");
        resourceDetails.setPassword("password");
        resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
        resourceDetails.setClientId("acme");
        resourceDetails.setClientSecret("acmesecret");
        resourceDetails.setGrantType("password");
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
       

        //DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2AccessToken accessToken = provider.obtainAccessToken(resourceDetails, new DefaultAccessTokenRequest());
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext(accessToken));
        Plan plan = restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getPlan?planId=1", Plan.class);
        System.out.println("Result is>>>>>:"+plan.getId());
			
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
