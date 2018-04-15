package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.demo.controller.Controller;
import com.example.demo.service.AvivaService;

@RunWith(PowerMockRunner.class)
public class ControllerTest {
	
	@InjectMocks
	Controller controller;
	
	@Mock
	AvivaService avivaService;

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
    public void getOdd() throws Exception {
		List<Integer> a = new ArrayList<Integer>();
		List<String> mask = new ArrayList<String>();
		Mockito.when(avivaService.getOdd((100))).thenReturn(a);
		Mockito.when(avivaService.maskPrime((a))).thenReturn(mask);
		
        this.mockMvc.perform(get("/getOdd/num/100")    
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());  
        Assert.assertTrue(mask.size()==0);
    }

	@Test
    public void getPagination() throws Exception {
		List<Integer> a = new ArrayList<Integer>();
		List<String> mask = new ArrayList<String>();
		Mockito.when(avivaService.getOdd((100))).thenReturn(a);
		Mockito.when(avivaService.maskPrime((a))).thenReturn(mask);
		Mockito.when(avivaService.pagination(Mockito.anyList(), Mockito.anyInt(),  Mockito.anyInt())).thenReturn(mask);
		
        this.mockMvc.perform(get("/getOdd/num/100/pagination/0/1")    
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); 
        Assert.assertTrue(mask.size()==0);
    }
}
