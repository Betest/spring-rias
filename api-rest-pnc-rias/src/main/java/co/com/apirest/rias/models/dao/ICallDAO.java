package co.com.apirest.rias.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.apirest.rias.models.entity.CallEntity;

public interface ICallDAO extends CrudRepository<CallEntity, Long>{

}
