package co.com.apirest.rias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.apirest.rias.models.dao.ICallDAO;
import co.com.apirest.rias.models.entity.CallEntity;

@Service
public class CallServiceImpl implements ICallService{
	
	@Autowired
	private ICallDAO callsDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<CallEntity> findAll() {
		return (List<CallEntity>) callsDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CallEntity findById(Long id) {
		return callsDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CallEntity save(CallEntity callsEntity) {
		return callsDAO.save(callsEntity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		callsDAO.deleteById(id);
	}

}
