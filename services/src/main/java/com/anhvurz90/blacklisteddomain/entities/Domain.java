package com.anhvurz90.blacklisteddomain.entities;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Owner on 7/11/14.
 */
public class Domain {
    private int id;
    private String value;
    
    public Domain(String value) {
    	this.value = value;
    	this.id = (int)(Math.random() * 10000);
    }
    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public int hashCode() {
			return value == null ? 0 : value.hashCode();
		}
		
		public boolean equals(Object other) {
			if (other == null || !(other instanceof Domain)) return false;
			return StringUtils.equals(value, ((Domain)other).getValue());
		}
}
