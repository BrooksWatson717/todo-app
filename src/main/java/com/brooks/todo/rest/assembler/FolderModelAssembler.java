package com.brooks.todo.rest.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.brooks.todo.definition.Folder;
import com.brooks.todo.rest.FolderController;
import com.brooks.todo.rest.model.FolderModel;

@Component
public class FolderModelAssembler extends RepresentationModelAssemblerSupport<Folder, FolderModel> {

    public FolderModelAssembler() {
        super(FolderController.class, FolderModel.class);
    }

    @Override
    public FolderModel toModel(Folder folder) {
        FolderModel folderModel = instantiateModel(folder);

        return folderModel;
    }

}
