package co.com.apirest.rias.models.services;

import java.util.List;

import co.com.apirest.rias.models.entity.CallEntity;

public interface ICallService {
	
	public List<CallEntity> findAll();
	
	public CallEntity findById(Long id);
	
	public CallEntity save (CallEntity callsEntity);
	
	public void delete(Long id);
	
	

}
