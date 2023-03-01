package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.RuleViolationCause;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("RuleViolationError_allOf")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class RuleViolationErrorAllOf  implements Serializable {
  private List<RuleViolationCause> causes = new ArrayList<>();

  /**
   * List of rule violation causes.
   **/
  public RuleViolationErrorAllOf causes(List<RuleViolationCause> causes) {
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

  public RuleViolationErrorAllOf addCausesItem(RuleViolationCause causesItem) {
    if (this.causes == null) {
      this.causes = new ArrayList<>();
    }

    this.causes.add(causesItem);
    return this;
  }

  public RuleViolationErrorAllOf removeCausesItem(RuleViolationCause causesItem) {
    if (causesItem != null && this.causes != null) {
      this.causes.remove(causesItem);
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleViolationErrorAllOf ruleViolationErrorAllOf = (RuleViolationErrorAllOf) o;
    return Objects.equals(this.causes, ruleViolationErrorAllOf.causes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(causes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleViolationErrorAllOf {\n");
    
    sb.append("    causes: ").append(toIndentedString(causes)).append("\n");
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

