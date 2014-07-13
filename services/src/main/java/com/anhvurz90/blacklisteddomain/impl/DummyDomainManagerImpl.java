package com.anhvurz90.blacklisteddomain.impl;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 7/11/14.
 */
public class DummyDomainManagerImpl implements DomainManager {

    private List<Domain> domains_;
    private List<String> initialDomains;

    public DummyDomainManagerImpl() {
        domains_ = new ArrayList<Domain>();
    }

    @Override
    public void addDomain(Domain domain) {
    		if (!domains_.contains(domain)) {
    			domains_.add(domain);
    		}
    }
    
    @Override
    public void addDomain(String domainName) {
    	addDomain(new Domain(domainName));
    }
    
    @Override
    public void setInitialDomains(List<String> domains) {
    	for (String domain : domains) {
    		addDomain(domain);
    	}
    }

    @Override
    public void removeDomain(Domain domain) {
        domains_.remove(domain);
    }

    @Override
    public List<Domain> getAllDomains() {
        return domains_;
    }

		@Override
    public void removeDomain(String domainName) {
			domains_.remove(new Domain(domainName));
    }
		
		public boolean isBlacklisted(String email) {
			return domains_.contains(new Domain(email.substring(email.indexOf("@") + 1)));
		}
		
		public void clear() {
			domains_.clear();
		}
		
}