package org.openapitools.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public enum LogLevel {
  
  DEBUG("DEBUG"),
  
  TRACE("TRACE"),
  
  WARN("WARN"),
  
  ERROR("ERROR"),
  
  SEVERE("SEVERE"),
  
  WARNING("WARNING"),
  
  INFO("INFO"),
  
  CONFIG("CONFIG"),
  
  FINE("FINE"),
  
  FINER("FINER"),
  
  FINEST("FINEST");

  private String value;

  LogLevel(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static LogLevel fromString(String s) {
      for (LogLevel b : LogLevel.values()) {
        // using Objects.toString() to be safe if value type non-object type
        // because types like 'int' etc. will be auto-boxed
        if (java.util.Objects.toString(b.value).equals(s)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static LogLevel fromValue(String value) {
    for (LogLevel b : LogLevel.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


