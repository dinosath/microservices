package org.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.SearchedVersion;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Describes the response received when searching for artifacts.
 **/

@JsonTypeName("VersionSearchResults")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class VersionSearchResults  implements Serializable {
  private Integer count;
  private List<SearchedVersion> versions = new ArrayList<>();

  /**
   * The total number of versions that matched the query (may be more than the number of versions returned in the result set).
   **/
  public VersionSearchResults count(Integer count) {
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

  /**
   * The collection of artifact versions returned in the result set.
   **/
  public VersionSearchResults versions(List<SearchedVersion> versions) {
    this.versions = versions;
    return this;
  }

  
  @JsonProperty("versions")
  public List<SearchedVersion> getVersions() {
    return versions;
  }

  @JsonProperty("versions")
  public void setVersions(List<SearchedVersion> versions) {
    this.versions = versions;
  }

  public VersionSearchResults addVersionsItem(SearchedVersion versionsItem) {
    if (this.versions == null) {
      this.versions = new ArrayList<>();
    }

    this.versions.add(versionsItem);
    return this;
  }

  public VersionSearchResults removeVersionsItem(SearchedVersion versionsItem) {
    if (versionsItem != null && this.versions != null) {
      this.versions.remove(versionsItem);
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
    VersionSearchResults versionSearchResults = (VersionSearchResults) o;
    return Objects.equals(this.count, versionSearchResults.count) &&
        Objects.equals(this.versions, versionSearchResults.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionSearchResults {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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

