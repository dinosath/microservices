package org.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.RuleViolationCause;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * All error responses, whether &#x60;4xx&#x60; or &#x60;5xx&#x60; will include one of these as the response body.
 **/

@JsonTypeName("RuleViolationError")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class RuleViolationError  implements Serializable {
  private List<RuleViolationCause> causes = new ArrayList<>();
  private String message;
  private Integer errorCode;
  private String detail;
  private String name;

  /**
   * List of rule violation causes.
   **/
  public RuleViolationError causes(List<RuleViolationCause> causes) {
    this.causes = causes;
    return this;
  }

  
  @JsonProperty("causes")
  public List<RuleViolationCause> getCauses() {
    return causes;
  }

  @JsonProperty("causes")
  public void setCauses(List<RuleViolationCause> causes) {
    this.causes = causes;
  }

  public RuleViolationError addCausesItem(RuleViolationCause causesItem) {
    if (this.causes == null) {
      this.causes = new ArrayList<>();
    }

    this.causes.add(causesItem);
    return this;
  }

  public RuleViolationError removeCausesItem(RuleViolationCause causesItem) {
    if (causesItem != null && this.causes != null) {
      this.causes.remove(causesItem);
    }

    return this;
  }
  /**
   * The short error message.
   **/
  public RuleViolationError message(String message) {
    this.message = message;
    return this;
  }

  
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * The server-side error code.
   **/
  public RuleViolationError errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  
  @JsonProperty("error_code")
  public Integer getErrorCode() {
    return errorCode;
  }

  @JsonProperty("error_code")
  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * Full details about the error.  This might contain a server stack trace, for example.
   **/
  public RuleViolationError detail(String detail) {
    this.detail = detail;
    return this;
  }

  
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  @JsonProperty("detail")
  public void setDetail(String detail) {
    this.detail = detail;
  }

  /**
   * The error name - typically the classname of the exception thrown by the server.
   **/
  public RuleViolationError name(String name) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleViolationError ruleViolationError = (RuleViolationError) o;
    return Objects.equals(this.causes, ruleViolationError.causes) &&
        Objects.equals(this.message, ruleViolationError.message) &&
        Objects.equals(this.errorCode, ruleViolationError.errorCode) &&
        Objects.equals(this.detail, ruleViolationError.detail) &&
        Objects.equals(this.name, ruleViolationError.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(causes, message, errorCode, detail, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleViolationError {\n");
    
    sb.append("    causes: ").append(toIndentedString(causes)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

