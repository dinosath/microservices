package org.openapitools.model;

import org.openapitools.model.RuleType;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 **/

@JsonTypeName("Rule")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class Rule  implements Serializable {
  private String config;
  private RuleType type;

  /**
   **/
  public Rule config(String config) {
    this.config = config;
    return this;
  }

  
  @JsonProperty("config")
  public String getConfig() {
    return config;
  }

  @JsonProperty("config")
  public void setConfig(String config) {
    this.config = config;
  }

  /**
   **/
  public Rule type(RuleType type) {
    this.type = type;
    return this;
  }

  
  @JsonProperty("type")
  public RuleType getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(RuleType type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rule rule = (Rule) o;
    return Objects.equals(this.config, rule.config) &&
        Objects.equals(this.type, rule.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rule {\n");
    
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

