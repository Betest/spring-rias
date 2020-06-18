package co.com.apirest.rias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import co.com.apirest.rias.models.entity.StepEntity;
import co.com.apirest.rias.models.services.IStepService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/step")
public class StepController {
	
	@Autowired
	private IStepService stepService;
	
	@GetMapping("/all")
	public List<StepEntity> index(){		
		return stepService.findAll();		
	}
	
	@GetMapping("/get")
	public StepEntity getStep(@RequestBody StepEntity stepEntity) {
		return stepService.findById(stepEntity.getStepid());
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public StepEntity save(@RequestBody StepEntity stepEntity) {
		//callsEntity.setCreateAt(new Date());
		return stepService.save(stepEntity);		
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public StepEntity update(@RequestBody StepEntity stepEntity) {
		StepEntity currentStep = stepService.findById(stepEntity.getStepid());
		
		currentStep.setName(stepEntity.getName());
		currentStep.setCallidfk(stepEntity.getCallidfk());
		currentStep.setDescription(stepEntity.getDescription());
		currentStep.setComment(stepEntity.getComment());
		
		return stepService.save(currentStep);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody StepEntity stepEntity) {
		try{
			stepService.delete(stepEntity.getStepid());
		}catch (Exception e) {
			ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
		}
	}

}
