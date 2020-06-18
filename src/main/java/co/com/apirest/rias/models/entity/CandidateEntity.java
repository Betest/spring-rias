package co.com.apirest.rias.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class CandidateEntity implements Serializable{

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625993977632946468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long candidateid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "salary_aspiration")
	private Float salaryAspiration;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "call_candidate",
			joinColumns = @JoinColumn(name="candidate_id"),
			inverseJoinColumns = @JoinColumn(name="call_id"))	
	private List<CallEntity> calls ;
	
	public void addCall(CallEntity call) {
		
	}

	public CandidateEntity() {
		super();
	}

	


	public Long getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(Long candidateid) {
		this.candidateid = candidateid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getSalaryAspiration() {
		return salaryAspiration;
	}

	public void setSalaryAspiration(Float salaryAspiration) {
		this.salaryAspiration = salaryAspiration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
