package org.openapitools.model;

import org.openapitools.model.LogLevel;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 **/

@JsonTypeName("NamedLogConfiguration")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class NamedLogConfiguration  implements Serializable {
  private String name;
  private LogLevel level;

  /**
   * 
   **/
  public NamedLogConfiguration name(String name) {
    this.name = name;
    return this;
  }

  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public NamedLogConfiguration level(LogLevel level) {
    this.level = level;
    return this;
  }

  
  @JsonProperty("level")
  public LogLevel getLevel() {
    return level;
  }

  @JsonProperty("level")
  public void setLevel(LogLevel level) {
    this.level = level;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NamedLogConfiguration namedLogConfiguration = (NamedLogConfiguration) o;
    return Objects.equals(this.name, namedLogConfiguration.name) &&
        Objects.equals(this.level, namedLogConfiguration.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NamedLogConfiguration {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

