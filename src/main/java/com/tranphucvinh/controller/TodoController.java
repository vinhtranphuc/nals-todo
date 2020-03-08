package com.tranphucvinh.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tranphucvinh.exception.BadRequestException;
import com.tranphucvinh.jpa.model.Work;
import com.tranphucvinh.payload.WorkRequest;
import com.tranphucvinh.security.JwtTokenProvider;
import com.tranphucvinh.service.TodoService;
import com.tranphucvinh.utils.Utils;

@RestController
@RequestMapping(value = "api/todo")
public class TodoController {
	
	protected Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	private TodoService todoService;
    
	@Autowired
	JwtTokenProvider tokenProvider;
	 
	@RequestMapping(value = "/works", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String,Object>> getWorks(@RequestParam Map<String,Object> param, Authentication authentication) {
		
		Map<String,Object> result;
		try {
			result = todoService.getWorks(param);
		} catch (Exception e) {
			logger.error("Excecption : {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().body(Utils.responseERROR(e.getMessage()));
		}
		
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok().body(Utils.responseOK(result,jwt));
	}

	@RequestMapping(value = "/create-work", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String,Object>> createWork(@Valid @RequestBody WorkRequest workRequest, Authentication authentication) {
		try {
			Work work = new Work(workRequest.getWork_name(),workRequest.getDescription(),workRequest.getStart_date(),workRequest.getEnd_date());
			todoService.saveWork(work);
		} catch (Exception e) {
		
			logger.error("Excecption : {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().body(Utils.responseERROR(e.getMessage()));
		}
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok().body(Utils.responseOK(null,jwt));
	}

	@RequestMapping(value = "/edit-work", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String,Object>> editWork(@Valid @RequestBody WorkRequest workRequest, Authentication authentication) {
		try {
			if(StringUtils.isEmpty(workRequest.getId()+"")) {
				throw new BadRequestException("work_id canot not empty");
			}
			if(!todoService.isNotEmptyUserId(workRequest.getId())) {
				throw new BadRequestException("work_id not exits !");
			}
			Work work = new Work(workRequest.getId(),workRequest.getWork_name(),workRequest.getDescription(),workRequest.getStart_date(),workRequest.getEnd_date());
			todoService.updateWork(work);
		} catch (Exception e) {

			logger.error("Excecption : {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().body(Utils.responseERROR(e.getMessage()));
		}
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok().body(Utils.responseOK(null,jwt,"Edit a work sucessfully"));
	}

	@RequestMapping(value = "/delete-work/{work_id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String,Object>> deleteWork(@PathVariable(name="work_id") Long workId, Authentication authentication) {
		try {
			todoService.deleteWorkById(workId);
		} catch (Exception e) {
			logger.error("Excecption : {}", ExceptionUtils.getStackTrace(e));
			return ResponseEntity.badRequest().body(Utils.responseERROR(e.getMessage()));
		}
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok().body(Utils.responseOK(null,jwt,"Delete a work sucessfully"));
	}
}
