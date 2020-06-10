package co.com.apirest.rias.models.services;

import java.util.List;

import co.com.apirest.rias.models.entity.StepEntity;

public interface IStepService {
	
	public List<StepEntity> findAll();
	
	public StepEntity findById(Long id);
	
	public StepEntity save(StepEntity stepEntity);
	
	public void delete(Long id);
}
