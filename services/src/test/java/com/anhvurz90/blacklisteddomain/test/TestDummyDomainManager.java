package com.anhvurz90.blacklisteddomain.test;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;
import com.anhvurz90.blacklisteddomain.impl.DummyDomainManagerImpl;

import junit.framework.TestCase;

public class TestDummyDomainManager extends TestCase {
	
	private DomainManager domainManager_;
	
	@Override
	protected void setUp() {
		domainManager_ = new DummyDomainManagerImpl();
		Domain domain1 = new Domain("yahoo.com");
		Domain domain2 = new Domain("google.com");
		domainManager_.addDomain(domain1);
		domainManager_.addDomain(domain2);
	}
	
	@Override
	protected void tearDown() {
		domainManager_.getAllDomains().clear();
	}

	public void testAddDomain() {
		Domain domain1 = new Domain("microsoft.com");
		domainManager_.addDomain(domain1);

		assertEquals("Wrong number of domain!", 3, domainManager_.getAllDomains().size());
	}
	
	public void testRemoveDomain() {
		Domain domain1 = new Domain("yahoo.com");
		domainManager_.removeDomain(domain1);
		
		assertEquals("Wrong number of domain!", 1, domainManager_.getAllDomains().size());
	}
	
	public void testGetAllDomains() {
		assertEquals("Wrong number of domain!", 2, domainManager_.getAllDomains().size());
	}
}
