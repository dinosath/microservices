
package com.crazyfly.models;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import org.openapitools.codegen.api.TemplateDefinition;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "oasgen_config")
public class OasGeneratorConfig {
    @NotBlank
    private String name;
    private JsonNode spec;
    private Map<String, String> options;
    private String openAPIUrl;
    private AuthorizationValue authorizationValue;

    private List<TemplateDefinition> templateDefinitionList = new ArrayList<>();

    public AuthorizationValue getAuthorizationValue() {
        return authorizationValue;
    }

    public void setAuthorizationValue(AuthorizationValue authorizationValue) {
        this.authorizationValue = authorizationValue;
    }

    public JsonNode getSpec() {
        return spec;
    }

    public void setSpec(JsonNode spec) {
        this.spec = spec;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public String getOpenAPIUrl() {
        return openAPIUrl;
    }

    public void setOpenAPIUrl(String url) {
        this.openAPIUrl = url;
    }

    public List<TemplateDefinition> getTemplateDefinitionList() {
        return templateDefinitionList;
    }

    public void setTemplateDefinitionList(List<TemplateDefinition> templateDefinitionList) {
        this.templateDefinitionList = templateDefinitionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
