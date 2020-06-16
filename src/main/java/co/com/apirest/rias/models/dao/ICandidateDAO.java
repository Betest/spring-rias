package co.com.apirest.rias.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.apirest.rias.models.entity.CandidateEntity;

@Repository
public interface ICandidateDAO extends CrudRepository<CandidateEntity, Long>{

}
