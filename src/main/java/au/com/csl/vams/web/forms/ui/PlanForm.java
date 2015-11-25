package au.com.csl.vams.web.forms.ui;



import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import au.com.csl.vams.client.data.Plan;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;



@ManagedBean(name ="planForm")
@ViewScoped
public class PlanForm extends AbstractMaintenanceForm<String, Plan>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 211925158489349108L;
	private String id;
	private Plan selectedPlan;
	private List<Plan> filteredPlans;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Plan getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(Plan selectedPlan) {
		this.selectedPlan = selectedPlan;
	}
		
	public List<Plan> getFilteredPlans() {
		return filteredPlans;
	}

	public void setFilteredPlans(List<Plan> filteredPlans) {
		this.filteredPlans = filteredPlans;
	}

	public void searchByIDOrName() {
		ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("user");
		resourceDetails.setPassword("password");
		resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
		resourceDetails.setClientId("acme");
		resourceDetails.setClientSecret("acmesecret");
		resourceDetails.setGrantType("implicit");

		OAuth2AccessToken accessToken = provider.obtainAccessToken(resourceDetails, new DefaultAccessTokenRequest());
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails,
				new DefaultOAuth2ClientContext(accessToken));
		Plan p =restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getPlan?planId="+id, Plan.class);
		List<Plan> planLst = new ArrayList<>();
		planLst.add(p);
		getSessionModel().setResults(planLst);
	}
	
	

	public void onRowSelect(SelectEvent event) {
		Plan p = (Plan) event.getObject();
		getSessionModel().setModel(p);
		viewOne(p);
		
	}

	@Override
	public Plan getNewOne() {
		return new Plan();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> getDefaultSearchResults() {
		ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("user");
		resourceDetails.setPassword("password");
		resourceDetails.setAccessTokenUri("http://ndisauthserver.mybluemix.net/uaa/oauth/token");
		resourceDetails.setClientId("acme");
		resourceDetails.setClientSecret("acmesecret");
		resourceDetails.setGrantType("implicit");

		OAuth2AccessToken accessToken = provider.obtainAccessToken(resourceDetails, new DefaultAccessTokenRequest());
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails,
				new DefaultOAuth2ClientContext(accessToken));
		List<Plan> p =restTemplate.getForObject("http://ndisplanservice.mybluemix.net/getAllPlans", List.class);
		System.out.println("plan***"+p);
		ObjectMapper mapper = new ObjectMapper();
		List<Plan> myObjects = mapper.convertValue(p, new TypeReference<List<Plan>>() { });
		
		return myObjects;
	}

	@Override
	public String getEntityBusinessName() {
		return "plan";
	}

	@Override
	public IService getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
