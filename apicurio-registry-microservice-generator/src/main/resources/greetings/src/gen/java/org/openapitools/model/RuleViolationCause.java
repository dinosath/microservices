package org.openapitools.model;

import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 **/

@JsonTypeName("RuleViolationCause")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class RuleViolationCause  implements Serializable {
  private String description;
  private String context;

  /**
   **/
  public RuleViolationCause description(String description) {
    this.description = description;
    return this;
  }

  
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  public RuleViolationCause context(String context) {
    this.context = context;
    return this;
  }

  
  @JsonProperty("context")
  public String getContext() {
    return context;
  }

  @JsonProperty("context")
  public void setContext(String context) {
    this.context = context;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleViolationCause ruleViolationCause = (RuleViolationCause) o;
    return Objects.equals(this.description, ruleViolationCause.description) &&
        Objects.equals(this.context, ruleViolationCause.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, context);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleViolationCause {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

