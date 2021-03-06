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

import co.com.apirest.rias.models.entity.CandidateEntity;
import co.com.apirest.rias.models.services.ICandidateService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/candidate")
public class CandidateController {
	
	@Autowired
	private ICandidateService candidateService;
	
	@GetMapping("/all")
	public List<CandidateEntity> index(){
		return candidateService.findAll();
	}
	
	@GetMapping("/get")
	public CandidateEntity getCalls(@RequestBody CandidateEntity candidateEntity) {
		return candidateService.findById(candidateEntity.getCandidateid());
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public CandidateEntity save(@RequestBody CandidateEntity candidateEntity) {
		//callsEntity.setCreateAt(new Date());
		return candidateService.save(candidateEntity);		
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public CandidateEntity update(@RequestBody CandidateEntity candidateEntity) {
		CandidateEntity currentCandidate = candidateService.findById(candidateEntity.getCandidateid());
		
		currentCandidate.setName(candidateEntity.getName());
		currentCandidate.setLastName(candidateEntity.getLastName());
		currentCandidate.setSalaryAspiration(candidateEntity.getSalaryAspiration());
		
		return candidateService.save(currentCandidate);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody CandidateEntity candidateEntity) {
		try{
			candidateService.delete(candidateEntity.getCandidateid());
		}catch (Exception e) {
			ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
		}
	}

}
