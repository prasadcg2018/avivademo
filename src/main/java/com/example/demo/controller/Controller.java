package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AvivaService;

@RestController
public class Controller {
	
	@Autowired
	AvivaService avivaService;
	
	private Logger logger = Logger.getLogger("Controller");
	
	@RequestMapping(value="/getOdd/num/{num}",method=RequestMethod.GET)
	public ResponseEntity<?> getOdd(@PathVariable("num") int n) throws Exception{
		logger.info("In Controller getOdd method() ");
			List<Integer> s =  avivaService.getOdd(n);
			
			List<String> mask = avivaService.maskPrime(s);
			
	        return new ResponseEntity<List<String>>(mask, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getOdd/num/{num}/pagination/{lowPage}/{highPage}",method=RequestMethod.GET)
	public ResponseEntity<?> getPagination(@PathVariable("num") int n, @PathVariable("lowPage") int l, @PathVariable("highPage") int h) throws Exception{
			logger.info("In Controller getPagination method() ");
			List<Integer> s =  avivaService.getOdd(n);
			
			List<String> mask = avivaService.maskPrime(s);
			
			List<String> pagination= avivaService.pagination(mask, l, h);
			
	        return new ResponseEntity<List<String>>(pagination, HttpStatus.OK);
	}
	
	

}
