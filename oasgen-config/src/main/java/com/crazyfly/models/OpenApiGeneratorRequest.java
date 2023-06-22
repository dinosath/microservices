package com.crazyfly.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public record OpenApiGeneratorRequest(String configFilePath,@NotNull String openApiUrl) {}
