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

import co.com.apirest.rias.models.entity.CallEntity;
import co.com.apirest.rias.models.services.ICallService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value ="/api/call")
public class CallController {
	
	@Autowired
	private ICallService callsService;
	
	@GetMapping("/all")
	public List<CallEntity> index(){		
		return callsService.findAll();		
	}
	
	
	@GetMapping("/get")
	public CallEntity getCalls(@RequestBody CallEntity callsEntity) {
		return callsService.findById(callsEntity.getCallid());
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public CallEntity save(@RequestBody CallEntity callsEntity) {
		//callsEntity.setCreateAt(new Date());
		return callsService.save(callsEntity);		
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public CallEntity update(@RequestBody CallEntity callsEntity) {
		CallEntity currentCall = callsService.findById(callsEntity.getCallid());
		
		currentCall.setName(callsEntity.getName());
		currentCall.setDescription(callsEntity.getDescription());
		currentCall.setCallStatus(callsEntity.isCallStatus());
		currentCall.setSalary(callsEntity.getSalary());
		
		return callsService.save(currentCall);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody CallEntity callsEntity) {
		try {
			callsService.delete(callsEntity.getCallid());			
		}catch (Exception e) {
			ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
		}
		
	}

}
