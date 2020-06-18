package co.com.apirest.rias.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "steps")
public class StepEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8213679943445461618L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "step_id")
	private Long stepid;
	
	@Column(name = "call_idfk")
	private int callidfk;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "comment")
	private String comment;
	
	

	public int getCallidfk() {
		return callidfk;
	}

	public void setCallidfk(int callidfk) {
		this.callidfk = callidfk;
	}

	public Long getStepid() {
		return stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
