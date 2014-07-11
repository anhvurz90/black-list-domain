package com.anhvurz90.blacklisteddomain.api;

import com.anhvurz90.blacklisteddomain.entities.Domain;

import java.util.List;

/**
 * Created by Owner on 7/11/14.
 */
public interface DomainManager {

    public void addDomain(Domain domain);

    public void removeDomain(Domain domain);

    public List<Domain> getAllDomains();

}
