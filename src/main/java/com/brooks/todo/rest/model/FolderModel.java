package com.brooks.todo.rest.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FolderModel extends RepresentationModel<FolderModel> {
    private Long id;
    private String name;
    private String description;

}
