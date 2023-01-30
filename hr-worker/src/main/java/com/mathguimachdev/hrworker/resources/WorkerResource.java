package com.mathguimachdev.hrworker.resources;

import com.mathguimachdev.hrworker.entities.Worker;
import com.mathguimachdev.hrworker.services.WorkerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;

	@Autowired
	private WorkerService serv;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("config="+testConfig);

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = serv.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){

//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}

		logger.info("port="+env.getProperty("local.server.port"));

		Worker obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
