package com.brooks.todo.rest.model;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemModel extends RepresentationModel<ItemModel> {
    private Long id;
    private Long folderId;
    private String description;
    private Date createdDate;
    private Date completedDate;
}
