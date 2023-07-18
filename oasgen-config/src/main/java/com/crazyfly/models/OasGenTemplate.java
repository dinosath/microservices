
package com.crazyfly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oasgen_templates")
public class OasGenTemplate {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private int id;

    @Column(name = "name",unique = true)
    @NotBlank
    private String name;

    private String downloadUrl;

    @NotBlank
    private String outputDirectory;

    @NotBlank
    private String image;

    @ElementCollection
    @NotNull
    private List<String> commands;
}
