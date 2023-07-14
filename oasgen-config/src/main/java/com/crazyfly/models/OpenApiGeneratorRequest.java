package com.crazyfly.models;

import javax.validation.constraints.NotNull;

public record OpenApiGeneratorRequest(String configFilePath, @NotNull String openApiUrl) {
}
