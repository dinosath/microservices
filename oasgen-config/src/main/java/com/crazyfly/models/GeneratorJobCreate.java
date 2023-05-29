package com.crazyfly.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public class GeneratorJobCreate {

    @NotNull
    private UUID oasGenConfigId;
    @NotNull
    @Size(min = 1)
    private List<Artifact> artifacts;

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public UUID getOasGenConfigId() {
        return oasGenConfigId;
    }

    public void setOasGenConfigId(UUID oasGenConfigId) {
        this.oasGenConfigId = oasGenConfigId;
    }
}
