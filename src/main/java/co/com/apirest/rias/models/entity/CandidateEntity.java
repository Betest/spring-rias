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
	private Long id;
	
	@Column(name = "detailid")
	private Long detailId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "salaryaspiration")
	private Float salaryAspiration;
	
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "candidates_calls",
			joinColumns = @JoinColumn(name="candidate_id"),
			inverseJoinColumns = @JoinColumn(name="call_id"))	
	private List<CallEntity> calls ;
	
	public void addCall(CallEntity call) {
		
	}

	public CandidateEntity() {
		super();
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
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
