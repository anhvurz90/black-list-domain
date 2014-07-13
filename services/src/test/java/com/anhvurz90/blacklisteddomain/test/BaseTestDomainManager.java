package com.anhvurz90.blacklisteddomain.test;

import java.util.Arrays;

import junit.framework.TestCase;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;

public abstract class BaseTestDomainManager<T extends DomainManager> extends TestCase {
	
	protected T domainManager_;
	
	@Override
	protected void setUp() {
		createDomainManager();

		Domain domain1 = new Domain("yahoo.com");
		Domain domain2 = new Domain("google.com");
		domainManager_.addDomain(domain1);
		domainManager_.addDomain(domain2);
	}
	
	@Override
	protected void tearDown() {
		domainManager_.clear();
	}
	
	protected abstract void createDomainManager();

	public void testAddDomain() {
		Domain domain1 = new Domain("microsoft.com");
		domainManager_.addDomain(domain1);

		assertEquals("Wrong number of domain!", 3, domainManager_.getAllDomains().size());
	}
	
	public void testAddDomainValue() {
		domainManager_.addDomain("microsoft.com");

		assertEquals("Wrong number of domain!", 3, domainManager_.getAllDomains().size());
	}
	
	public void testSetInitialDomains() {
		domainManager_.setInitialDomains(Arrays.asList(new String[]{"microsoft.com", "vnn.vn", "alibaba.com"}));

		assertEquals("Wrong number of domain!", 5, domainManager_.getAllDomains().size());
	}
	
	public void testRemoveDomain() {
		Domain domain1 = new Domain("yahoo.com");
		domainManager_.removeDomain(domain1);
		
		assertEquals("Wrong number of domain!", 1, domainManager_.getAllDomains().size());
	}
	
	public void testRemoveDomailByValue() {
		domainManager_.removeDomain("yahoo.com");
		
		assertEquals("Wrong number of domain!", 1, domainManager_.getAllDomains().size());
	}
	
	public void testGetAllDomains() {
		assertEquals("Wrong number of domain!", 2, domainManager_.getAllDomains().size());
	}

	public void testIsBlackList() {
		assertEquals("Blacklisted check failure: ", true, domainManager_.isBlacklisted("anhvu@yahoo.com"));
	}
	
	public void testClear() {
		domainManager_.clear();
		assertEquals("Domains can not be cleared!", 0, domainManager_.getAllDomains().size());
	}
}
