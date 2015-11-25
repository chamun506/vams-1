package au.com.csl.vams.client.data;

import java.io.Serializable;

public class SupportItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String referenceNo;
	private String description;
	private Double price;
	private String unit;
	private Boolean quoteRequired;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Boolean getQuoteRequired() {
		return quoteRequired;
	}
	public void setQuoteRequired(Boolean quoteRequired) {
		this.quoteRequired = quoteRequired;
	}
	
	

}
