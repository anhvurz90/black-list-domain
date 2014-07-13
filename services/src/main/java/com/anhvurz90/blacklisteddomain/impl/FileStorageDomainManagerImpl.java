package com.anhvurz90.blacklisteddomain.impl;

import java.io.BufferedReader;
import java.io.File;
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
	private String initFile = "init.txt";
	
	public List<Domain> domains;
	
	public FileStorageDomainManagerImpl() {
		domains = new ArrayList<Domain>();
		readDomainsFromFile();
	}

	@Override
  public void addDomain(Domain domain) {
		if (!domains.contains(domain)) {
			domains.add(domain);
			writeDomainsToFile();
		}
  }
	
  @Override
  public void addDomain(String domainName) {
  	addDomain(new Domain(domainName));
  }
  
  @Override
  public void setInitialDomains(List<String> domains) {
  	File file = new File(initFile);
  	if (file.exists()) return;
  	for (String domain : domains) {
  		addDomain(domain);
  	}
  	this.domains.clear();
  	readDomainsFromFile();
		try {
			PrintWriter writer = new PrintWriter(
														new FileWriter(initFile));
			writer.println("Initialized!");
			writer.close();
		} catch (IOException e) {
			//Log -> can not store data, or write error
		}
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
		new File(initFile).delete();
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
				writer.println(domain.getValue());
			}
			writer.close();
		} catch (IOException e) {
			//Log -> can not store data, or write error
		}
	}

}
