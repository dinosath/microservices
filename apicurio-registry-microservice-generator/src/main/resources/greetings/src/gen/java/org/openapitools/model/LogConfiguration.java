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

@JsonTypeName("LogConfiguration")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class LogConfiguration  implements Serializable {
  private LogLevel level;

  /**
   **/
  public LogConfiguration level(LogLevel level) {
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
    LogConfiguration logConfiguration = (LogConfiguration) o;
    return Objects.equals(this.level, logConfiguration.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogConfiguration {\n");
    
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

