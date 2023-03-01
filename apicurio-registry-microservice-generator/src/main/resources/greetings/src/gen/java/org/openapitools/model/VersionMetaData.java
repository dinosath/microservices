package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.model.ArtifactState;
import org.openapitools.model.ArtifactType;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 **/

@JsonTypeName("VersionMetaData")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class VersionMetaData  implements Serializable {
  private String version;
  private String name;
  private String description;
  private String createdBy;
  private OffsetDateTime createdOn;
  private ArtifactType type;
  private Long globalId;
  private ArtifactState state;
  private String id;
  private List<String> labels = null;
  private Map<String, String> properties = null;
  private String groupId;
  private Long contentId;

  /**
   **/
  public VersionMetaData version(String version) {
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
  public VersionMetaData name(String name) {
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
  public VersionMetaData description(String description) {
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
  public VersionMetaData createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  
  @JsonProperty("createdBy")
  public String getCreatedBy() {
    return createdBy;
  }

  @JsonProperty("createdBy")
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   **/
  public VersionMetaData createdOn(OffsetDateTime createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  
  @JsonProperty("createdOn")
  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }

  @JsonProperty("createdOn")
  public void setCreatedOn(OffsetDateTime createdOn) {
    this.createdOn = createdOn;
  }

  /**
   **/
  public VersionMetaData type(ArtifactType type) {
    this.type = type;
    return this;
  }

  
  @JsonProperty("type")
  public ArtifactType getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(ArtifactType type) {
    this.type = type;
  }

  /**
   * 
   **/
  public VersionMetaData globalId(Long globalId) {
    this.globalId = globalId;
    return this;
  }

  
  @JsonProperty("globalId")
  public Long getGlobalId() {
    return globalId;
  }

  @JsonProperty("globalId")
  public void setGlobalId(Long globalId) {
    this.globalId = globalId;
  }

  /**
   **/
  public VersionMetaData state(ArtifactState state) {
    this.state = state;
    return this;
  }

  
  @JsonProperty("state")
  public ArtifactState getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(ArtifactState state) {
    this.state = state;
  }

  /**
   * The ID of a single artifact.
   **/
  public VersionMetaData id(String id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  /**
   * 
   **/
  public VersionMetaData labels(List<String> labels) {
    this.labels = labels;
    return this;
  }

  
  @JsonProperty("labels")
  public List<String> getLabels() {
    return labels;
  }

  @JsonProperty("labels")
  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  public VersionMetaData addLabelsItem(String labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<>();
    }

    this.labels.add(labelsItem);
    return this;
  }

  public VersionMetaData removeLabelsItem(String labelsItem) {
    if (labelsItem != null && this.labels != null) {
      this.labels.remove(labelsItem);
    }

    return this;
  }
  /**
   * User-defined name-value pairs. Name and value must be strings.
   **/
  public VersionMetaData properties(Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  
  @JsonProperty("properties")
  public Map<String, String> getProperties() {
    return properties;
  }

  @JsonProperty("properties")
  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public VersionMetaData putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }

    this.properties.put(key, propertiesItem);
    return this;
  }

  public VersionMetaData removePropertiesItem(String propertiesItem) {
    if (propertiesItem != null && this.properties != null) {
      this.properties.remove(propertiesItem);
    }

    return this;
  }
  /**
   * An ID of a single artifact group.
   **/
  public VersionMetaData groupId(String groupId) {
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
   * 
   **/
  public VersionMetaData contentId(Long contentId) {
    this.contentId = contentId;
    return this;
  }

  
  @JsonProperty("contentId")
  public Long getContentId() {
    return contentId;
  }

  @JsonProperty("contentId")
  public void setContentId(Long contentId) {
    this.contentId = contentId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionMetaData versionMetaData = (VersionMetaData) o;
    return Objects.equals(this.version, versionMetaData.version) &&
        Objects.equals(this.name, versionMetaData.name) &&
        Objects.equals(this.description, versionMetaData.description) &&
        Objects.equals(this.createdBy, versionMetaData.createdBy) &&
        Objects.equals(this.createdOn, versionMetaData.createdOn) &&
        Objects.equals(this.type, versionMetaData.type) &&
        Objects.equals(this.globalId, versionMetaData.globalId) &&
        Objects.equals(this.state, versionMetaData.state) &&
        Objects.equals(this.id, versionMetaData.id) &&
        Objects.equals(this.labels, versionMetaData.labels) &&
        Objects.equals(this.properties, versionMetaData.properties) &&
        Objects.equals(this.groupId, versionMetaData.groupId) &&
        Objects.equals(this.contentId, versionMetaData.contentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, name, description, createdBy, createdOn, type, globalId, state, id, labels, properties, groupId, contentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionMetaData {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    contentId: ").append(toIndentedString(contentId)).append("\n");
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

