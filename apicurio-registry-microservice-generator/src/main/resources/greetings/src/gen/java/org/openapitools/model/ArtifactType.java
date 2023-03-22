package org.openapitools.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public enum ArtifactType {
  
  AVRO("AVRO"),
  
  PROTOBUF("PROTOBUF"),
  
  JSON("JSON"),
  
  OPENAPI("OPENAPI"),
  
  ASYNCAPI("ASYNCAPI"),
  
  GRAPHQL("GRAPHQL"),
  
  KCONNECT("KCONNECT"),
  
  WSDL("WSDL"),
  
  XSD("XSD"),
  
  XML("XML");

  private String value;

  ArtifactType(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static ArtifactType fromString(String s) {
      for (ArtifactType b : ArtifactType.values()) {
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
  public static ArtifactType fromValue(String value) {
    for (ArtifactType b : ArtifactType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


