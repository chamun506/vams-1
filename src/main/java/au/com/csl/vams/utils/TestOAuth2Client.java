package au.com.csl.vams.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import au.com.csl.vams.client.data.Approval;
import au.com.csl.vams.client.data.Cluster;
import au.com.csl.vams.client.data.Plan;
import au.com.csl.vams.client.data.SupportItem;

public class TestOAuth2Client {

	public static void main(String args[]) throws Exception
	{
		
		/*ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("user");
        resourceDetails.setPassword("password");
        resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
        resourceDetails.setClientId("acme");
        resourceDetails.setClientSecret("acmesecret");
        resourceDetails.setGrantType("password");
       

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        Plan result = restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getPlan?planId=6", Plan.class);
        System.out.println("Result is:"+result);*/
		
		//To post data
		
	   /* Plan p = new Plan();
	    p.setParticipantId(100L);
	    p.setStatus("approved");
	    p.setValidUntil("30/11/2015");
	    
	    Cluster cluster1 = new Cluster();
	    cluster1.setClusterName("Assistance with daily personal activities");
	    cluster1.setGuidedPrice(Double.valueOf("300"));
	    cluster1.setMinimumPrice(Double.valueOf("150"));
	    cluster1.setPlanedFinishDate("30/11/2015");
	    
	    SupportItem sItem= new SupportItem();
	    sItem.setDescription("Assisting with, and/or supervising personal tasks of daily life to develop skills of the participant to live as autonomously as possible");
	    sItem.setName("assistance with self-care activities during daytime weekdays");
	    sItem.setPrice(Double.valueOf("33.54"));
	    sItem.setQuoteRequired(Boolean.FALSE);
	    sItem.setReferenceNo("1.05");
	    sItem.setUnit("Hour");
	    
	   
	    SupportItem sItem2= new SupportItem();
	    sItem2.setDescription("Assisting with, and/or supervising, personal tasks of daily life to develop skills of the participant to live as autonomously as possible.");
	    sItem2.setName("active overnight assistance with self-care");
	    sItem2.setPrice(Double.valueOf("38.55"));
	    sItem2.setQuoteRequired(Boolean.FALSE);
	    sItem2.setReferenceNo("1.05");
	    sItem2.setUnit("Hour");
	    
	    SupportItem sItem3= new SupportItem();
	    sItem3.setDescription("Assisting with, and/or supervising, personal tasks of daily life to develop skills of the participant to live as autonomously as possible");
	    sItem3.setName("assistance with self- care activities on Sundays");
	    sItem3.setPrice(Double.valueOf("58.70"));
	    sItem3.setQuoteRequired(Boolean.FALSE);
	    sItem3.setReferenceNo("1.05");
	    sItem3.setUnit("Hour");
	    	    	    
	    
	    List<SupportItem> sl = new ArrayList<SupportItem>();
	    sl.add(sItem);
	    sl.add(sItem2);
	    sl.add(sItem3);
	    cluster1.setSupportItems(sl);
	    
	 	    	    
	    List<Cluster> cl = new ArrayList<Cluster>();
	    cl.add(cluster1);
	    p.setClusters(cl);
	    
	    
	    Approval apprval = new Approval();
	    apprval.setApprovedBy("Planner");
	    apprval.setApprovedDate("16/11/2015");
	    
	    List<Approval> al = new ArrayList<Approval>();
	    al.add(apprval);
	    p.setApprovals(al);
	    
	    
	    ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("user");
		resourceDetails.setPassword("password");
		resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
		resourceDetails.setClientId("acme");
		resourceDetails.setClientSecret("acmesecret");
		resourceDetails.setGrantType("password");
		
		OAuth2AccessToken accessToken = provider.obtainAccessToken(resourceDetails, new DefaultAccessTokenRequest());
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails,new DefaultOAuth2ClientContext(accessToken));
		
		
        String pl=restTemplate.postForObject("http://ndisplanservice.mybluemix.net/createPlan",p,String.class);
		System.out.println(pl);
		*/
		// to update
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("user");
        resourceDetails.setPassword("password");
        resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
        resourceDetails.setClientId("acme");
        resourceDetails.setClientSecret("acmesecret");
        resourceDetails.setGrantType("password");
       

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        Plan plan = restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getPlan?planId=6", Plan.class);
        System.out.println("plan***"+plan);
        
        plan.getApprovals().get(0).setApprovedBy("Luke Bryan");
        
      /* Approval apprval = new Approval();
	    apprval.setApprovedBy("XYZ");
	    apprval.setApprovedDate("16/11/2015");
	    
	    List<Approval> al = new ArrayList<Approval>();
	    al.add(apprval);
        
        
        plan.getApprovals().addAll(al);*/
        
       /* Cluster cluster = new Cluster();
	    cluster.setClusterName("Therapeutic supports");
	    cluster.setGuidedPrice(Double.valueOf("600"));
	    cluster.setMinimumPrice(Double.valueOf("320"));
	    cluster.setPlanedFinishDate("30-12-2015");
	    
	    SupportItem sItem= new SupportItem();
	    sItem.setDescription("Delivery of Physiotherapy support in a group setting to develop or relearn postural and movement skills and functional movement patterns, seating and mobility support, positioning and movement in daily activities.");
	    sItem.setName("Physiotherapy (group)");
	    sItem.setPrice(Double.valueOf("54.67"));
	    sItem.setQuoteRequired(Boolean.FALSE);
	    sItem.setReferenceNo("2.01");
	    sItem.setUnit("Hour");
	    
	    
	    SupportItem sItem1= new SupportItem();
	    sItem1.setDescription("Evaluation and treatment of disorders of the eye musculature");
	    sItem1.setName("Orthoptic services to an individual");
	    sItem1.setPrice(Double.valueOf("164"));
	    sItem1.setQuoteRequired(Boolean.FALSE);
	    sItem1.setReferenceNo("2.07");
	    sItem1.setUnit("Hour");
	    
	    SupportItem sItem2= new SupportItem();
	    sItem2.setDescription("Assessment, selection of adapted foot ware or therapy related to foot, ankle and leg impairments.");
	    sItem2.setName("Podiatry");
	    sItem2.setPrice(Double.valueOf("164"));
	    sItem2.setQuoteRequired(Boolean.FALSE);
	    sItem2.setReferenceNo("2.01");
	    sItem2.setUnit("Hour");
	    
	    
	   SupportItem sItem3= new SupportItem();
	    sItem3.setDescription("Speech and language pathology to optimise ability to understand information, express thoughts/ needs and communicate; enhance environment to ensure safe and effective mealtime support for participants with difficulty feeding/swallowing.");
	    sItem3.setName("Speech and Language Pathology in a group");
	    sItem3.setPrice(Double.valueOf("54.67"));
	    sItem3.setQuoteRequired(Boolean.FALSE);
	    sItem3.setReferenceNo("2.01");
	    sItem3.setUnit("Hour");
	    
	    SupportItem sItem4= new SupportItem();
	    sItem4.setDescription("Implementation of a therapeutic intervention that has been planned by a professional therapist and is delivered by a therapy assistance under the direction of the therapist.");
	    sItem4.setName("therapeutic program delivered by Therapy Assistant");
	    sItem4.setPrice(Double.valueOf("38.23"));
	    sItem4.setQuoteRequired(Boolean.FALSE);
	    sItem4.setReferenceNo("2.01");
	    sItem4.setUnit("Hour");
	    
	    
	    
	    
	    List<SupportItem> sl = new ArrayList<SupportItem>();
	    sl.add(sItem);
	    sl.add(sItem1);
	    sl.add(sItem2);
	    sl.add(sItem3);
	    sl.add(sItem4);
	    
	    cluster.setSupportItems(sl);
	    
	    List<Cluster> cl = new ArrayList<Cluster>();
	    cl.add(cluster);
	   
        
        
        plan.getClusters().addAll(cl);*/
        
       
	    
	    String pl=restTemplate.postForObject("http://ndisplanservice.mybluemix.net/updatePlan",plan,String.class);
		System.out.println(pl);
	    
		
	}



}
