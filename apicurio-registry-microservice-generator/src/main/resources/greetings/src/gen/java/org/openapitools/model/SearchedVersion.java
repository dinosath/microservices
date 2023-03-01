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
 * Models a single artifact from the result set returned when searching for artifacts.
 **/

@JsonTypeName("SearchedVersion")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class SearchedVersion  implements Serializable {
  private String name;
  private String description;
  private OffsetDateTime createdOn;
  private String createdBy;
  private ArtifactType type;
  private List<String> labels = null;
  private ArtifactState state;
  private Long globalId;
  private String version;
  private Map<String, String> properties = null;
  private Long contentId;
  private List<ArtifactReference> references = new ArrayList<>();

  /**
   * 
   **/
  public SearchedVersion name(String name) {
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
   * 
   **/
  public SearchedVersion description(String description) {
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
   * 
   **/
  public SearchedVersion createdOn(OffsetDateTime createdOn) {
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
   * 
   **/
  public SearchedVersion createdBy(String createdBy) {
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
  public SearchedVersion type(ArtifactType type) {
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
  public SearchedVersion labels(List<String> labels) {
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

  public SearchedVersion addLabelsItem(String labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<>();
    }

    this.labels.add(labelsItem);
    return this;
  }

  public SearchedVersion removeLabelsItem(String labelsItem) {
    if (labelsItem != null && this.labels != null) {
      this.labels.remove(labelsItem);
    }

    return this;
  }
  /**
   **/
  public SearchedVersion state(ArtifactState state) {
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
  public SearchedVersion globalId(Long globalId) {
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
   * 
   **/
  public SearchedVersion version(String version) {
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
   * User-defined name-value pairs. Name and value must be strings.
   **/
  public SearchedVersion properties(Map<String, String> properties) {
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

  public SearchedVersion putPropertiesItem(String key, String propertiesItem) {
    if (this.properties == null) {
      this.properties = new HashMap<>();
    }

    this.properties.put(key, propertiesItem);
    return this;
  }

  public SearchedVersion removePropertiesItem(String propertiesItem) {
    if (propertiesItem != null && this.properties != null) {
      this.properties.remove(propertiesItem);
    }

    return this;
  }
  /**
   * 
   **/
  public SearchedVersion contentId(Long contentId) {
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
  public SearchedVersion references(List<ArtifactReference> references) {
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

  public SearchedVersion addReferencesItem(ArtifactReference referencesItem) {
    if (this.references == null) {
      this.references = new ArrayList<>();
    }

    this.references.add(referencesItem);
    return this;
  }

  public SearchedVersion removeReferencesItem(ArtifactReference referencesItem) {
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
    SearchedVersion searchedVersion = (SearchedVersion) o;
    return Objects.equals(this.name, searchedVersion.name) &&
        Objects.equals(this.description, searchedVersion.description) &&
        Objects.equals(this.createdOn, searchedVersion.createdOn) &&
        Objects.equals(this.createdBy, searchedVersion.createdBy) &&
        Objects.equals(this.type, searchedVersion.type) &&
        Objects.equals(this.labels, searchedVersion.labels) &&
        Objects.equals(this.state, searchedVersion.state) &&
        Objects.equals(this.globalId, searchedVersion.globalId) &&
        Objects.equals(this.version, searchedVersion.version) &&
        Objects.equals(this.properties, searchedVersion.properties) &&
        Objects.equals(this.contentId, searchedVersion.contentId) &&
        Objects.equals(this.references, searchedVersion.references);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, createdOn, createdBy, type, labels, state, globalId, version, properties, contentId, references);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchedVersion {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    globalId: ").append(toIndentedString(globalId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

