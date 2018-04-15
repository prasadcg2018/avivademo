package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class AvivaService {
	
	private Logger logger = Logger.getLogger("AvivaService");
	
	public List<Integer> getPrime(int num) {
		List<Integer> a = new ArrayList<Integer>();
		for(int n=2; n<=num; n++) {
			if(chechPrime(n)) a.add(n);
		}
		
		logger.info("In AvivaService getPrime() ");
		return a;
		
	}
	
	public List<Integer> getOdd(int num) {
		List<Integer> odd = new ArrayList<Integer>();
		for(int n=2; n<=num; n++) {
			if(n%2!=0) odd.add(n);
		}
		logger.info("In AvivaService getOdd() ");
		return odd;
	}
	
	public List<String> maskPrime(List<Integer> num) {
		logger.info("In AvivaService maskPrime() ");
		List <String> m = new ArrayList<String>();
		for(int i=0; i<num.size(); i++) {
			int temp = (int) num.get(i);
			if(temp%3==0 && temp%5==0) {
				m.add("Z");
			}
			else if(temp%5==0) {
				m.add("Y");
			}
			else if(temp%3==0) {
				m.add("X");
			}
			else {
				m.add(""+temp);
			}
		}
		return m;
	}
	
	public List<String> pagination(List<String> n, int l, int h) throws Exception {
		logger.info("In AvivaService pagination() ");
		List <String> p =  new ArrayList<String>(); 
		l= l*20;
		h=(h-1)*20;
		for(int i=l; i<h;i++) {
			if(i<n.size())
				p.add(n.get(i));
			else {
				logger.info("Exception Thrown");
			throw new Exception("Exceed limit");
			 
			}
		}
		
		return p;
	}
	
	private boolean chechPrime(int num) {
		int count = 0;
		for(int n=2; n<num; n++) {
			if(num%n==0) count++;
			if(count>0) break;
		}
		if(count==0)
			return true;
		else
			return false;
	}

}
