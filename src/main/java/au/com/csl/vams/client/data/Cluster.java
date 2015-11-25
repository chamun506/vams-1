package au.com.csl.vams.client.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Cluster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String clusterName;
	private String planedFinishDate;
	private Double guidedPrice;
	private Double minimumPrice;
	private List<SupportItem> supportItems;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	@JsonFormat(pattern="dd-MM-yyyy")
	public String getPlanedFinishDate() {
		return planedFinishDate;
	}
	public void setPlanedFinishDate(String planedFinishDate) {
		this.planedFinishDate = planedFinishDate;
	}
	public Double getGuidedPrice() {
		return guidedPrice;
	}
	public void setGuidedPrice(Double guidedPrice) {
		this.guidedPrice = guidedPrice;
	}
	public Double getMinimumPrice() {
		return minimumPrice;
	}
	public void setMinimumPrice(Double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}
	public List<SupportItem> getSupportItems() {
		return supportItems;
	}
	public void setSupportItems(List<SupportItem> supportItems) {
		this.supportItems = supportItems;
	}
		

}
