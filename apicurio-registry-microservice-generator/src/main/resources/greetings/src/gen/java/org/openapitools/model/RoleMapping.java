package org.openapitools.model;

import org.openapitools.model.RoleType;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The mapping between a user/principal and their role.
 **/

@JsonTypeName("RoleMapping")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class RoleMapping  implements Serializable {
  private String principalId;
  private RoleType role;
  private String principalName;

  /**
   * 
   **/
  public RoleMapping principalId(String principalId) {
    this.principalId = principalId;
    return this;
  }

  
  @JsonProperty("principalId")
  public String getPrincipalId() {
    return principalId;
  }

  @JsonProperty("principalId")
  public void setPrincipalId(String principalId) {
    this.principalId = principalId;
  }

  /**
   **/
  public RoleMapping role(RoleType role) {
    this.role = role;
    return this;
  }

  
  @JsonProperty("role")
  public RoleType getRole() {
    return role;
  }

  @JsonProperty("role")
  public void setRole(RoleType role) {
    this.role = role;
  }

  /**
   * A friendly name for the principal.
   **/
  public RoleMapping principalName(String principalName) {
    this.principalName = principalName;
    return this;
  }

  
  @JsonProperty("principalName")
  public String getPrincipalName() {
    return principalName;
  }

  @JsonProperty("principalName")
  public void setPrincipalName(String principalName) {
    this.principalName = principalName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleMapping roleMapping = (RoleMapping) o;
    return Objects.equals(this.principalId, roleMapping.principalId) &&
        Objects.equals(this.role, roleMapping.role) &&
        Objects.equals(this.principalName, roleMapping.principalName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(principalId, role, principalName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleMapping {\n");
    
    sb.append("    principalId: ").append(toIndentedString(principalId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    principalName: ").append(toIndentedString(principalName)).append("\n");
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

