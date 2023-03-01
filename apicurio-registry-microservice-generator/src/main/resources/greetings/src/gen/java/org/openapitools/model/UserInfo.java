package org.openapitools.model;

import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Information about a single user.
 **/

@JsonTypeName("UserInfo")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class UserInfo  implements Serializable {
  private String username;
  private String displayName;
  private Boolean admin;
  private Boolean developer;
  private Boolean viewer;

  /**
   **/
  public UserInfo username(String username) {
    this.username = username;
    return this;
  }

  
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  @JsonProperty("username")
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  public UserInfo displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty("displayName")
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   **/
  public UserInfo admin(Boolean admin) {
    this.admin = admin;
    return this;
  }

  
  @JsonProperty("admin")
  public Boolean getAdmin() {
    return admin;
  }

  @JsonProperty("admin")
  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }

  /**
   **/
  public UserInfo developer(Boolean developer) {
    this.developer = developer;
    return this;
  }

  
  @JsonProperty("developer")
  public Boolean getDeveloper() {
    return developer;
  }

  @JsonProperty("developer")
  public void setDeveloper(Boolean developer) {
    this.developer = developer;
  }

  /**
   **/
  public UserInfo viewer(Boolean viewer) {
    this.viewer = viewer;
    return this;
  }

  
  @JsonProperty("viewer")
  public Boolean getViewer() {
    return viewer;
  }

  @JsonProperty("viewer")
  public void setViewer(Boolean viewer) {
    this.viewer = viewer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.username, userInfo.username) &&
        Objects.equals(this.displayName, userInfo.displayName) &&
        Objects.equals(this.admin, userInfo.admin) &&
        Objects.equals(this.developer, userInfo.developer) &&
        Objects.equals(this.viewer, userInfo.viewer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, displayName, admin, developer, viewer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
    sb.append("    developer: ").append(toIndentedString(developer)).append("\n");
    sb.append("    viewer: ").append(toIndentedString(viewer)).append("\n");
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

