package co.com.apirest.rias.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.apirest.rias.models.entity.StepEntity;

public interface IStepDAO extends CrudRepository<StepEntity, Long> {

}
