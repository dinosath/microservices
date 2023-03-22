package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.model.ArtifactReference;
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

@JsonTypeName("ArtifactMetaData")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class ArtifactMetaData  implements Serializable {
  private String name;
  private String description;
  private String createdBy;
  private OffsetDateTime createdOn;
  private String modifiedBy;
  private OffsetDateTime modifiedOn;
  private String id;
  private String version;
  private ArtifactType type;
  private Long globalId;
  private ArtifactState state;
  private List<String> labels = null;
  private Map<String, String> properties = null;
  private String groupId;
  private Long contentId;
  private List<ArtifactReference> references = null;

  /**
   **/
  public ArtifactMetaData name(String name) {
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
  public ArtifactMetaData description(String description) {
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
  public ArtifactMetaData createdBy(String createdBy) {
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
  public ArtifactMetaData createdOn(OffsetDateTime createdOn) {
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
  public ArtifactMetaData modifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
    return this;
  }

  
  @JsonProperty("modifiedBy")
  public String getModifiedBy() {
    return modifiedBy;
  }

  @JsonProperty("modifiedBy")
  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  /**
   **/
  public ArtifactMetaData modifiedOn(OffsetDateTime modifiedOn) {
    this.modifiedOn = modifiedOn;
    return this;
  }

  
  @JsonProperty("modifiedOn")
  public OffsetDateTime getModifiedOn() {
    return modifiedOn;
  }

  @JsonProperty("modifiedOn")
  public void setModifiedOn(OffsetDateTime modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  /**
   * The ID of a single artifact.
   **/
  public ArtifactMetaData id(String id) {
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
  public ArtifactMetaData version(String version) {
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
  public ArtifactMetaData type(ArtifactType type) {
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
  public ArtifactMetaData globalId(Long globalId) {
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
  public ArtifactMetaData state(ArtifactState state) {
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
   * 
   **/
  public ArtifactMetaData labels(List<String> labels) {
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

  public ArtifactMetaData addLabelsItem(String labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<>();
    }

    this.labels.add(labelsItem);
    return this;
  }

  public ArtifactMetaData removeLabelsItem(String labelsItem) {
    if (labelsItem != null && this.labels != null) {
      this.labels.remove(labelsItem);
    }

    return this;
  }
  /**
   * User-defined name-value pairs. Name and value must be strings.
   **/
  public ArtifactMetaData properties(Map<String, String> properties) {
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

  public ArtifactMetaData putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }

    this.properties.put(key, propertiesItem);
    return this;
  }

  public ArtifactMetaData removePropertiesItem(String propertiesItem) {
    if (propertiesItem != null && this.properties != null) {
      this.properties.remove(propertiesItem);
    }

    return this;
  }
  /**
   * An ID of a single artifact group.
   **/
  public ArtifactMetaData groupId(String groupId) {
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
  public ArtifactMetaData contentId(Long contentId) {
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

  /**
   * 
   **/
  public ArtifactMetaData references(List<ArtifactReference> references) {
    this.references = references;
    return this;
  }

  
  @JsonProperty("references")
  public List<ArtifactReference> getReferences() {
    return references;
  }

  @JsonProperty("references")
  public void setReferences(List<ArtifactReference> references) {
    this.references = references;
  }

  public ArtifactMetaData addReferencesItem(ArtifactReference referencesItem) {
    if (this.references == null) {
      this.references = new ArrayList<>();
    }

    this.references.add(referencesItem);
    return this;
  }

  public ArtifactMetaData removeReferencesItem(ArtifactReference referencesItem) {
    if (referencesItem != null && this.references != null) {
      this.references.remove(referencesItem);
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
    ArtifactMetaData artifactMetaData = (ArtifactMetaData) o;
    return Objects.equals(this.name, artifactMetaData.name) &&
        Objects.equals(this.description, artifactMetaData.description) &&
        Objects.equals(this.createdBy, artifactMetaData.createdBy) &&
        Objects.equals(this.createdOn, artifactMetaData.createdOn) &&
        Objects.equals(this.modifiedBy, artifactMetaData.modifiedBy) &&
        Objects.equals(this.modifiedOn, artifactMetaData.modifiedOn) &&
        Objects.equals(this.id, artifactMetaData.id) &&
        Objects.equals(this.version, artifactMetaData.version) &&
        Objects.equals(this.type, artifactMetaData.type) &&
        Objects.equals(this.globalId, artifactMetaData.globalId) &&
        Objects.equals(this.state, artifactMetaData.state) &&
        Objects.equals(this.labels, artifactMetaData.labels) &&
        Objects.equals(this.properties, artifactMetaData.properties) &&
        Objects.equals(this.groupId, artifactMetaData.groupId) &&
        Objects.equals(this.contentId, artifactMetaData.contentId) &&
        Objects.equals(this.references, artifactMetaData.references);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, createdBy, createdOn, modifiedBy, modifiedOn, id, version, type, globalId, state, labels, properties, groupId, contentId, references);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtifactMetaData {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    modifiedOn: ").append(toIndentedString(modifiedOn)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    contentId: ").append(toIndentedString(contentId)).append("\n");
    sb.append("    references: ").append(toIndentedString(references)).append("\n");
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

