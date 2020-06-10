package co.com.apirest.rias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.apirest.rias.models.dao.ICandidateDAO;
import co.com.apirest.rias.models.entity.CandidateEntity;

@Service
public class CandidateServiceImpl implements ICandidateService{
	
	@Autowired
	private ICandidateDAO candidateDAO;

	@Override
	@Transactional(readOnly = true)
	public List<CandidateEntity> findAll() {
		return (List<CandidateEntity>) candidateDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CandidateEntity findById(Long id) {
		return candidateDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CandidateEntity save(CandidateEntity candidateEntity) {
		return candidateDAO.save(candidateEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		candidateDAO.deleteById(id);
		
	}

}
