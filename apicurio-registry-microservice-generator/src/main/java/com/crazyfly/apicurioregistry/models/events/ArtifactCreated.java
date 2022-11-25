package com.crazyfly.apicurioregistry.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ArtifactCreated(

	@JsonProperty("groupId")
	String groupId,

	@JsonProperty("artifactId")
	String artifactId,

	@JsonProperty("type")
	String type,

	@JsonProperty("version")
	String version
) {
}
