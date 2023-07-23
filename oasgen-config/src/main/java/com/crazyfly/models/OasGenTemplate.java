
package com.crazyfly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "oasgen_templates")
public class OasGenTemplate {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @Column(name = "id", nullable = false,updatable = false)
    @UuidGenerator
    private UUID id;

    public OasGenTemplate() {
    }


    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String name;

    @NotBlank
    private String downloadUrl;

    private String fileSubDirectory;

    @NotBlank
    private String image;

    @ElementCollection
    @NotNull
    private List<String> commands;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getFileSubDirectory() {
        return fileSubDirectory;
    }

    public void setFileSubDirectory(String fileSubDirectory) {
        this.fileSubDirectory = fileSubDirectory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
