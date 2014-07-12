package com.anhvurz90.blacklisteddomain.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;

public class FileStorageDomainManagerImpl implements DomainManager {
	
	private String storageFile = "domain.txt";
	
	public List<Domain> domains;
	
	public FileStorageDomainManagerImpl() {
		domains = new ArrayList<Domain>();
		readDomainsFromFile();
	}

	@Override
  public void addDomain(Domain domain) {
		domains.add(domain);
		writeDomainsToFile();
  }

	@Override
  public void removeDomain(Domain domain) {
	  domains.remove(domain);
	  writeDomainsToFile();	  
  }

	@Override
  public void removeDomain(String domainName) {
	  domains.remove(new Domain(domainName));
	  writeDomainsToFile();
  }

	@Override
  public List<Domain> getAllDomains() {
	  return domains;
  }

	@Override
  public boolean isBlacklisted(String email) {
		return domains.contains(new Domain(email.substring(email.indexOf("@") + 1)));
  }
	
	public void clear() {
		domains.clear();
		writeDomainsToFile();
	}
	
	private void readDomainsFromFile() {
		try {
			BufferedReader br = new BufferedReader(
														new FileReader(storageFile));
			String data = null;
			while ((data = br.readLine()) != null) {
				domains.add(new Domain(data));
			}
			br.close();
		} catch (IOException e) {
			//Log -> file not found, can not load data, or read error
    }
	}
	
	private void writeDomainsToFile() {
		try {
			PrintWriter writer = new PrintWriter(
														new FileWriter(storageFile));
			for (Domain domain : domains) {
				writer.write(domain.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			//Log -> can not store data, or write error
		}
	}

}
