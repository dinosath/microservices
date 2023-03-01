package org.openapitools.model;

import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A reference to a different artifact. Typically used with artifact types that can have dependencies like Protobuf.
 **/

@JsonTypeName("ArtifactReference")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class ArtifactReference  implements Serializable {
  private String groupId;
  private String artifactId;
  private String version;
  private String name;

  /**
   **/
  public ArtifactReference groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  
  @JsonProperty("groupId")
  public String getGroupId() {
    return groupId;
  }

  @JsonProperty("groupId")
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  /**
   **/
  public ArtifactReference artifactId(String artifactId) {
    this.artifactId = artifactId;
    return this;
  }

  
  @JsonProperty("artifactId")
  public String getArtifactId() {
    return artifactId;
  }

  @JsonProperty("artifactId")
  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  /**
   **/
  public ArtifactReference version(String version) {
    this.version = version;
    return this;
  }

  
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  @JsonProperty("version")
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   **/
  public ArtifactReference name(String name) {
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
    ArtifactReference artifactReference = (ArtifactReference) o;
    return Objects.equals(this.groupId, artifactReference.groupId) &&
        Objects.equals(this.artifactId, artifactReference.artifactId) &&
        Objects.equals(this.version, artifactReference.version) &&
        Objects.equals(this.name, artifactReference.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, artifactId, version, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtifactReference {\n");
    
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    artifactId: ").append(toIndentedString(artifactId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

