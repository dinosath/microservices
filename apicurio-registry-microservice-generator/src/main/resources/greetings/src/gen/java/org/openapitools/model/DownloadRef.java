package org.openapitools.model;

import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Models a download &#39;link&#39;.  Useful for browser use-cases.
 **/

@JsonTypeName("DownloadRef")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class DownloadRef  implements Serializable {
  private String downloadId;
  private String href;

  /**
   **/
  public DownloadRef downloadId(String downloadId) {
    this.downloadId = downloadId;
    return this;
  }

  
  @JsonProperty("downloadId")
  public String getDownloadId() {
    return downloadId;
  }

  @JsonProperty("downloadId")
  public void setDownloadId(String downloadId) {
    this.downloadId = downloadId;
  }

  /**
   **/
  public DownloadRef href(String href) {
    this.href = href;
    return this;
  }

  
  @JsonProperty("href")
  public String getHref() {
    return href;
  }

  @JsonProperty("href")
  public void setHref(String href) {
    this.href = href;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadRef downloadRef = (DownloadRef) o;
    return Objects.equals(this.downloadId, downloadRef.downloadId) &&
        Objects.equals(this.href, downloadRef.href);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downloadId, href);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadRef {\n");
    
    sb.append("    downloadId: ").append(toIndentedString(downloadId)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
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

