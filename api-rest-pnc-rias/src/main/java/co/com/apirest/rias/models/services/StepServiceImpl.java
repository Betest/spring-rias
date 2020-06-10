package co.com.apirest.rias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.apirest.rias.models.dao.IStepDAO;
import co.com.apirest.rias.models.entity.StepEntity;

@Service
public class StepServiceImpl implements IStepService{
	
	@Autowired
	private IStepDAO stepDAO;

	@Override
	@Transactional(readOnly = true)
	public List<StepEntity> findAll() {
		return (List<StepEntity>) stepDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public StepEntity findById(Long id) {
		return stepDAO.findById(id).orElse(null);
		
	}

	@Override
	@Transactional
	public StepEntity save(StepEntity stepEntity) {
		return stepDAO.save(stepEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		stepDAO.deleteById(id);
		
	}

}
