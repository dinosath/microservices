package org.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.SearchedArtifact;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Describes the response received when searching for artifacts.
 **/

@JsonTypeName("ArtifactSearchResults")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class ArtifactSearchResults  implements Serializable {
  private List<SearchedArtifact> artifacts = new ArrayList<>();
  private Integer count;

  /**
   * The artifacts returned in the result set.
   **/
  public ArtifactSearchResults artifacts(List<SearchedArtifact> artifacts) {
    this.artifacts = artifacts;
    return this;
  }

  
  @JsonProperty("artifacts")
  public List<SearchedArtifact> getArtifacts() {
    return artifacts;
  }

  @JsonProperty("artifacts")
  public void setArtifacts(List<SearchedArtifact> artifacts) {
    this.artifacts = artifacts;
  }

  public ArtifactSearchResults addArtifactsItem(SearchedArtifact artifactsItem) {
    if (this.artifacts == null) {
      this.artifacts = new ArrayList<>();
    }

    this.artifacts.add(artifactsItem);
    return this;
  }

  public ArtifactSearchResults removeArtifactsItem(SearchedArtifact artifactsItem) {
    if (artifactsItem != null && this.artifacts != null) {
      this.artifacts.remove(artifactsItem);
    }

    return this;
  }
  /**
   * The total number of artifacts that matched the query that produced the result set (may be  more than the number of artifacts in the result set).
   **/
  public ArtifactSearchResults count(Integer count) {
    this.count = count;
    return this;
  }

  
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  @JsonProperty("count")
  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtifactSearchResults artifactSearchResults = (ArtifactSearchResults) o;
    return Objects.equals(this.artifacts, artifactSearchResults.artifacts) &&
        Objects.equals(this.count, artifactSearchResults.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artifacts, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtifactSearchResults {\n");
    
    sb.append("    artifacts: ").append(toIndentedString(artifacts)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

