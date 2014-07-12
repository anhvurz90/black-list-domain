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

    public DummyDomainManagerImpl() {
        domains_ = new ArrayList<Domain>();
    }

    @Override
    public void addDomain(Domain domain) {
        domains_.add(domain);
    }

    @Override
    public void removeDomain(Domain domain) {
        domains_.remove(domain);
    }

    @Override
    public List<Domain> getAllDomains() {
        return domains_;
    }
}