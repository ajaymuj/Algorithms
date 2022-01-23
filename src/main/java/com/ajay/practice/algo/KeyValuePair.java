package com.ajay.practice.algo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(builder = KeyValuePair.PatternBuilder.class)
public class KeyValuePair {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String key;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String value;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public KeyValuePair(@JsonProperty("key") String k, @JsonProperty("value") String v) {
		this.key=k;
		this.value=v;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public String toString() {
		return "KeyValuePair [key=" + key + ", value=" + value + "]";
	}
	
	static class PatternBuilder {
	    String key;
	    String value;
	    
	    PatternBuilder withKey(String key) {
	        this.key = key;
	        return this;
	    }
	    
	    PatternBuilder withValue(String value) {
	        this.value = value;
	        return this;
	    }
	    
	    public KeyValuePair build() {
	        return new KeyValuePair(key, value);
	    } 
	}
	
}
