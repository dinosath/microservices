package com.crazyfly.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GenerateClientRequest(

	@JsonProperty("openAPIUrl")
	String openAPIUrl
) {
}
