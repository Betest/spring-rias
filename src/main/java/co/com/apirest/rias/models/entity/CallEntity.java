package co.com.apirest.rias.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "calls")
public class CallEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075401424776415866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "call_id")
	private Long callid;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "callstatus", nullable = false, columnDefinition = "TINYINT(1)")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean callStatus;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	/*
	 * @OneToMany(mappedBy = "calls", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private List<CandidateEntity> candidates;
	 */


	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}


	public Long getCallid() {
		return callid;
	}



	public void setCallid(Long callid) {
		this.callid = callid;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCallStatus() {
		return callStatus;
	}

	public void setCallStatus(boolean callStatus) {
		this.callStatus = callStatus;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}