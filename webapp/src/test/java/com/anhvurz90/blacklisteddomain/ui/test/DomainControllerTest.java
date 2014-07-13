package com.anhvurz90.blacklisteddomain.ui.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.ui.DomainController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
//  @ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext-*.xml" }),
  @ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/BlackListedDomain-servlet.xml" })
})
public class DomainControllerTest {
	
	@Mock
	private DomainManager domainManager;
	
	@InjectMocks
	private DomainController domainController;
	
	private MockMvc mockMvc;
	
	@Before
  public void setup() {
      MockitoAnnotations.initMocks(this);
      this.mockMvc = MockMvcBuilders.standaloneSetup(domainController).build();
  }
	
	@Test
	public void testIndex() throws Exception {
	 
	    domainManager.removeDomain(any(String.class));
	    when(domainManager.getAllDomains()).thenReturn(null);
	    
	    this.mockMvc.perform(get("/"))
	            .andExpect(forwardedUrl("listDomain"));

//	    this.mockMvc.perform(get("deleteDomain").
//	    										 param("domainName", "test.com"))
//	    										 .andExpect(forwardedUrl("listDomain"));
	}	
  
}
