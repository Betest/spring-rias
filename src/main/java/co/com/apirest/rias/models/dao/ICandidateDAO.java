package co.com.apirest.rias.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.apirest.rias.models.entity.CandidateEntity;

public interface ICandidateDAO extends CrudRepository<CandidateEntity, Long>{

}
