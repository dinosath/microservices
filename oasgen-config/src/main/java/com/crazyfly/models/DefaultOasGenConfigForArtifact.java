package com.crazyfly.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultOasGenConfigForArtifact{

	@JsonProperty("groupId")
	private String groupId;

	@JsonProperty("artifactId")
	private String artifactId;

	@JsonProperty("type")
	private String type;

	@JsonProperty("version")
	private String version;

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setArtifactId(String artifactId){
		this.artifactId = artifactId;
	}

	public String getArtifactId(){
		return artifactId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}
}
