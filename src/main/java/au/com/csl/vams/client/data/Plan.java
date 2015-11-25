package au.com.csl.vams.client.data;

import java.util.Date;
import java.util.List;
import au.com.csl.vams.scaffold.AbstractMasterEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Plan extends AbstractMasterEntity<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private List<Cluster> clusters;
	private List<Approval> approvals;
	private Long participantId;
	private String validUntil;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Cluster> getClusters() {
		return clusters;
	}
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	public List<Approval> getApprovals() {
		return approvals;
	}
	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}
	public Long getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}
	
	@JsonFormat(pattern="dd-MM-yyyy")
	public String getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
