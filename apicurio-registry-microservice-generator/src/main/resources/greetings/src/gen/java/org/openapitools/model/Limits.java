package org.openapitools.model;

import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * List of limitations on used resources, that are applied on the current instance of Registry. Keys represent the resource type and are suffixed by the corresponding unit. Values are integers. Only non-negative values are allowed, with the exception of -1, which means that the limit is not applied.
 **/

@JsonTypeName("Limits")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class Limits  implements Serializable {
  private Long maxTotalSchemasCount;
  private Long maxSchemaSizeBytes;
  private Long maxArtifactsCount;
  private Long maxVersionsPerArtifactCount;
  private Long maxArtifactPropertiesCount;
  private Long maxPropertyKeySizeBytes;
  private Long maxPropertyValueSizeBytes;
  private Long maxArtifactLabelsCount;
  private Long maxLabelSizeBytes;
  private Long maxArtifactNameLengthChars;
  private Long maxArtifactDescriptionLengthChars;
  private Long maxRequestsPerSecondCount;

  /**
   **/
  public Limits maxTotalSchemasCount(Long maxTotalSchemasCount) {
    this.maxTotalSchemasCount = maxTotalSchemasCount;
    return this;
  }

  
  @JsonProperty("maxTotalSchemasCount")
  public Long getMaxTotalSchemasCount() {
    return maxTotalSchemasCount;
  }

  @JsonProperty("maxTotalSchemasCount")
  public void setMaxTotalSchemasCount(Long maxTotalSchemasCount) {
    this.maxTotalSchemasCount = maxTotalSchemasCount;
  }

  /**
   **/
  public Limits maxSchemaSizeBytes(Long maxSchemaSizeBytes) {
    this.maxSchemaSizeBytes = maxSchemaSizeBytes;
    return this;
  }

  
  @JsonProperty("maxSchemaSizeBytes")
  public Long getMaxSchemaSizeBytes() {
    return maxSchemaSizeBytes;
  }

  @JsonProperty("maxSchemaSizeBytes")
  public void setMaxSchemaSizeBytes(Long maxSchemaSizeBytes) {
    this.maxSchemaSizeBytes = maxSchemaSizeBytes;
  }

  /**
   **/
  public Limits maxArtifactsCount(Long maxArtifactsCount) {
    this.maxArtifactsCount = maxArtifactsCount;
    return this;
  }

  
  @JsonProperty("maxArtifactsCount")
  public Long getMaxArtifactsCount() {
    return maxArtifactsCount;
  }

  @JsonProperty("maxArtifactsCount")
  public void setMaxArtifactsCount(Long maxArtifactsCount) {
    this.maxArtifactsCount = maxArtifactsCount;
  }

  /**
   **/
  public Limits maxVersionsPerArtifactCount(Long maxVersionsPerArtifactCount) {
    this.maxVersionsPerArtifactCount = maxVersionsPerArtifactCount;
    return this;
  }

  
  @JsonProperty("maxVersionsPerArtifactCount")
  public Long getMaxVersionsPerArtifactCount() {
    return maxVersionsPerArtifactCount;
  }

  @JsonProperty("maxVersionsPerArtifactCount")
  public void setMaxVersionsPerArtifactCount(Long maxVersionsPerArtifactCount) {
    this.maxVersionsPerArtifactCount = maxVersionsPerArtifactCount;
  }

  /**
   **/
  public Limits maxArtifactPropertiesCount(Long maxArtifactPropertiesCount) {
    this.maxArtifactPropertiesCount = maxArtifactPropertiesCount;
    return this;
  }

  
  @JsonProperty("maxArtifactPropertiesCount")
  public Long getMaxArtifactPropertiesCount() {
    return maxArtifactPropertiesCount;
  }

  @JsonProperty("maxArtifactPropertiesCount")
  public void setMaxArtifactPropertiesCount(Long maxArtifactPropertiesCount) {
    this.maxArtifactPropertiesCount = maxArtifactPropertiesCount;
  }

  /**
   **/
  public Limits maxPropertyKeySizeBytes(Long maxPropertyKeySizeBytes) {
    this.maxPropertyKeySizeBytes = maxPropertyKeySizeBytes;
    return this;
  }

  
  @JsonProperty("maxPropertyKeySizeBytes")
  public Long getMaxPropertyKeySizeBytes() {
    return maxPropertyKeySizeBytes;
  }

  @JsonProperty("maxPropertyKeySizeBytes")
  public void setMaxPropertyKeySizeBytes(Long maxPropertyKeySizeBytes) {
    this.maxPropertyKeySizeBytes = maxPropertyKeySizeBytes;
  }

  /**
   **/
  public Limits maxPropertyValueSizeBytes(Long maxPropertyValueSizeBytes) {
    this.maxPropertyValueSizeBytes = maxPropertyValueSizeBytes;
    return this;
  }

  
  @JsonProperty("maxPropertyValueSizeBytes")
  public Long getMaxPropertyValueSizeBytes() {
    return maxPropertyValueSizeBytes;
  }

  @JsonProperty("maxPropertyValueSizeBytes")
  public void setMaxPropertyValueSizeBytes(Long maxPropertyValueSizeBytes) {
    this.maxPropertyValueSizeBytes = maxPropertyValueSizeBytes;
  }

  /**
   **/
  public Limits maxArtifactLabelsCount(Long maxArtifactLabelsCount) {
    this.maxArtifactLabelsCount = maxArtifactLabelsCount;
    return this;
  }

  
  @JsonProperty("maxArtifactLabelsCount")
  public Long getMaxArtifactLabelsCount() {
    return maxArtifactLabelsCount;
  }

  @JsonProperty("maxArtifactLabelsCount")
  public void setMaxArtifactLabelsCount(Long maxArtifactLabelsCount) {
    this.maxArtifactLabelsCount = maxArtifactLabelsCount;
  }

  /**
   **/
  public Limits maxLabelSizeBytes(Long maxLabelSizeBytes) {
    this.maxLabelSizeBytes = maxLabelSizeBytes;
    return this;
  }

  
  @JsonProperty("maxLabelSizeBytes")
  public Long getMaxLabelSizeBytes() {
    return maxLabelSizeBytes;
  }

  @JsonProperty("maxLabelSizeBytes")
  public void setMaxLabelSizeBytes(Long maxLabelSizeBytes) {
    this.maxLabelSizeBytes = maxLabelSizeBytes;
  }

  /**
   **/
  public Limits maxArtifactNameLengthChars(Long maxArtifactNameLengthChars) {
    this.maxArtifactNameLengthChars = maxArtifactNameLengthChars;
    return this;
  }

  
  @JsonProperty("maxArtifactNameLengthChars")
  public Long getMaxArtifactNameLengthChars() {
    return maxArtifactNameLengthChars;
  }

  @JsonProperty("maxArtifactNameLengthChars")
  public void setMaxArtifactNameLengthChars(Long maxArtifactNameLengthChars) {
    this.maxArtifactNameLengthChars = maxArtifactNameLengthChars;
  }

  /**
   **/
  public Limits maxArtifactDescriptionLengthChars(Long maxArtifactDescriptionLengthChars) {
    this.maxArtifactDescriptionLengthChars = maxArtifactDescriptionLengthChars;
    return this;
  }

  
  @JsonProperty("maxArtifactDescriptionLengthChars")
  public Long getMaxArtifactDescriptionLengthChars() {
    return maxArtifactDescriptionLengthChars;
  }

  @JsonProperty("maxArtifactDescriptionLengthChars")
  public void setMaxArtifactDescriptionLengthChars(Long maxArtifactDescriptionLengthChars) {
    this.maxArtifactDescriptionLengthChars = maxArtifactDescriptionLengthChars;
  }

  /**
   **/
  public Limits maxRequestsPerSecondCount(Long maxRequestsPerSecondCount) {
    this.maxRequestsPerSecondCount = maxRequestsPerSecondCount;
    return this;
  }

  
  @JsonProperty("maxRequestsPerSecondCount")
  public Long getMaxRequestsPerSecondCount() {
    return maxRequestsPerSecondCount;
  }

  @JsonProperty("maxRequestsPerSecondCount")
  public void setMaxRequestsPerSecondCount(Long maxRequestsPerSecondCount) {
    this.maxRequestsPerSecondCount = maxRequestsPerSecondCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Limits limits = (Limits) o;
    return Objects.equals(this.maxTotalSchemasCount, limits.maxTotalSchemasCount) &&
        Objects.equals(this.maxSchemaSizeBytes, limits.maxSchemaSizeBytes) &&
        Objects.equals(this.maxArtifactsCount, limits.maxArtifactsCount) &&
        Objects.equals(this.maxVersionsPerArtifactCount, limits.maxVersionsPerArtifactCount) &&
        Objects.equals(this.maxArtifactPropertiesCount, limits.maxArtifactPropertiesCount) &&
        Objects.equals(this.maxPropertyKeySizeBytes, limits.maxPropertyKeySizeBytes) &&
        Objects.equals(this.maxPropertyValueSizeBytes, limits.maxPropertyValueSizeBytes) &&
        Objects.equals(this.maxArtifactLabelsCount, limits.maxArtifactLabelsCount) &&
        Objects.equals(this.maxLabelSizeBytes, limits.maxLabelSizeBytes) &&
        Objects.equals(this.maxArtifactNameLengthChars, limits.maxArtifactNameLengthChars) &&
        Objects.equals(this.maxArtifactDescriptionLengthChars, limits.maxArtifactDescriptionLengthChars) &&
        Objects.equals(this.maxRequestsPerSecondCount, limits.maxRequestsPerSecondCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxTotalSchemasCount, maxSchemaSizeBytes, maxArtifactsCount, maxVersionsPerArtifactCount, maxArtifactPropertiesCount, maxPropertyKeySizeBytes, maxPropertyValueSizeBytes, maxArtifactLabelsCount, maxLabelSizeBytes, maxArtifactNameLengthChars, maxArtifactDescriptionLengthChars, maxRequestsPerSecondCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Limits {\n");
    
    sb.append("    maxTotalSchemasCount: ").append(toIndentedString(maxTotalSchemasCount)).append("\n");
    sb.append("    maxSchemaSizeBytes: ").append(toIndentedString(maxSchemaSizeBytes)).append("\n");
    sb.append("    maxArtifactsCount: ").append(toIndentedString(maxArtifactsCount)).append("\n");
    sb.append("    maxVersionsPerArtifactCount: ").append(toIndentedString(maxVersionsPerArtifactCount)).append("\n");
    sb.append("    maxArtifactPropertiesCount: ").append(toIndentedString(maxArtifactPropertiesCount)).append("\n");
    sb.append("    maxPropertyKeySizeBytes: ").append(toIndentedString(maxPropertyKeySizeBytes)).append("\n");
    sb.append("    maxPropertyValueSizeBytes: ").append(toIndentedString(maxPropertyValueSizeBytes)).append("\n");
    sb.append("    maxArtifactLabelsCount: ").append(toIndentedString(maxArtifactLabelsCount)).append("\n");
    sb.append("    maxLabelSizeBytes: ").append(toIndentedString(maxLabelSizeBytes)).append("\n");
    sb.append("    maxArtifactNameLengthChars: ").append(toIndentedString(maxArtifactNameLengthChars)).append("\n");
    sb.append("    maxArtifactDescriptionLengthChars: ").append(toIndentedString(maxArtifactDescriptionLengthChars)).append("\n");
    sb.append("    maxRequestsPerSecondCount: ").append(toIndentedString(maxRequestsPerSecondCount)).append("\n");
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

