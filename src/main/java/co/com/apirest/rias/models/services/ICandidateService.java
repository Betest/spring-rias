package co.com.apirest.rias.models.services;

import java.util.List;

import co.com.apirest.rias.models.entity.CandidateEntity;

public interface ICandidateService {
	
	public List<CandidateEntity> findAll();
	
	public CandidateEntity findById(Long id);
	
	public CandidateEntity save (CandidateEntity candidateEntity);
	
	public void delete(Long id);

}
