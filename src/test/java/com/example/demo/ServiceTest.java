package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import com.example.demo.service.AvivaService;

@RunWith(PowerMockRunner.class)
public class ServiceTest {
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void getOdd() throws Exception {
		AvivaService avivaService = new AvivaService();
		List<Integer> a = 	avivaService.getOdd(100);
        Assert.assertTrue(a.size()!=0);
    }

	@Test
    public void maskPrime() throws Exception {
		List<Integer> odd = new ArrayList<Integer>();
		AvivaService avivaService = new AvivaService();
		List<String> mask = 	avivaService.maskPrime(odd);
        Assert.assertTrue(mask.size()==0);
    }
	
	@Test(expected=Exception.class)
    public void getPagination() throws Exception {
		List<String> mask = new ArrayList<String>();
		AvivaService avivaService = new AvivaService();
		List<String> p = 	avivaService.pagination(mask, -1, 1);
    }
}
