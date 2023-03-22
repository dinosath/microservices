package org.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.ArtifactReference;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 **/

@JsonTypeName("ContentCreateRequest")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class ContentCreateRequest  implements Serializable {
  private String content;
  private List<ArtifactReference> references = new ArrayList<>();

  /**
   * Raw content of the artifact or a valid (and accessible) URL where the content can be found.
   **/
  public ContentCreateRequest content(String content) {
    this.content = content;
    return this;
  }

  
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  @JsonProperty("content")
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Collection of references to other artifacts.
   **/
  public ContentCreateRequest references(List<ArtifactReference> references) {
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

  public ContentCreateRequest addReferencesItem(ArtifactReference referencesItem) {
    if (this.references == null) {
      this.references = new ArrayList<>();
    }

    this.references.add(referencesItem);
    return this;
  }

  public ContentCreateRequest removeReferencesItem(ArtifactReference referencesItem) {
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
    ContentCreateRequest contentCreateRequest = (ContentCreateRequest) o;
    return Objects.equals(this.content, contentCreateRequest.content) &&
        Objects.equals(this.references, contentCreateRequest.references);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, references);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentCreateRequest {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

