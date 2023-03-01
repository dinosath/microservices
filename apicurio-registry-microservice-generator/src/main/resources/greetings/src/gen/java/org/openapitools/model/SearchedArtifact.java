package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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

@JsonTypeName("SearchedArtifact")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class SearchedArtifact  implements Serializable {
  private String id;
  private String name;
  private String description;
  private OffsetDateTime createdOn;
  private String createdBy;
  private ArtifactType type;
  private List<String> labels = null;
  private ArtifactState state;
  private OffsetDateTime modifiedOn;
  private String modifiedBy;
  private String groupId;

  /**
   * The ID of a single artifact.
   **/
  public SearchedArtifact id(String id) {
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
  public SearchedArtifact name(String name) {
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
  public SearchedArtifact description(String description) {
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
  public SearchedArtifact createdOn(OffsetDateTime createdOn) {
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
  public SearchedArtifact createdBy(String createdBy) {
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
  public SearchedArtifact type(ArtifactType type) {
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
  public SearchedArtifact labels(List<String> labels) {
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

  public SearchedArtifact addLabelsItem(String labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<>();
    }

    this.labels.add(labelsItem);
    return this;
  }

  public SearchedArtifact removeLabelsItem(String labelsItem) {
    if (labelsItem != null && this.labels != null) {
      this.labels.remove(labelsItem);
    }

    return this;
  }
  /**
   **/
  public SearchedArtifact state(ArtifactState state) {
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
  public SearchedArtifact modifiedOn(OffsetDateTime modifiedOn) {
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
   * 
   **/
  public SearchedArtifact modifiedBy(String modifiedBy) {
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
   * An ID of a single artifact group.
   **/
  public SearchedArtifact groupId(String groupId) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchedArtifact searchedArtifact = (SearchedArtifact) o;
    return Objects.equals(this.id, searchedArtifact.id) &&
        Objects.equals(this.name, searchedArtifact.name) &&
        Objects.equals(this.description, searchedArtifact.description) &&
        Objects.equals(this.createdOn, searchedArtifact.createdOn) &&
        Objects.equals(this.createdBy, searchedArtifact.createdBy) &&
        Objects.equals(this.type, searchedArtifact.type) &&
        Objects.equals(this.labels, searchedArtifact.labels) &&
        Objects.equals(this.state, searchedArtifact.state) &&
        Objects.equals(this.modifiedOn, searchedArtifact.modifiedOn) &&
        Objects.equals(this.modifiedBy, searchedArtifact.modifiedBy) &&
        Objects.equals(this.groupId, searchedArtifact.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, createdOn, createdBy, type, labels, state, modifiedOn, modifiedBy, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchedArtifact {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    modifiedOn: ").append(toIndentedString(modifiedOn)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
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

