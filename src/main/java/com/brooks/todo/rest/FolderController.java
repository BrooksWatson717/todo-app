package com.brooks.todo.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brooks.todo.definition.Folder;
import com.brooks.todo.repository.FolderRepository;
import com.brooks.todo.rest.assembler.FolderModelAssembler;
import com.brooks.todo.rest.model.FolderModel;

@RestController
@RequestMapping("/folders")
public class FolderController {

    private final FolderModelAssembler assembler;
    private final FolderRepository repository;

    public FolderController(FolderRepository repository, FolderModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping()
    public CollectionModel<FolderModel> all() {
        List<FolderModel> folders = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(folders, linkTo(methodOn(FolderController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public FolderModel one(@PathVariable Long id) {
        Folder folder = repository.findById(id).orElseThrow(null);

        return assembler.toModel(folder);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createFolder(Folder folder) throws URISyntaxException {
        Folder savedFolder = repository.save(folder);
        return ResponseEntity.created(new URI("/folders/" + savedFolder.getId())).body(savedFolder);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateFolder(@PathVariable Long id, @RequestBody Folder folder) {
        Folder currentFolder = repository.findById(id).orElseThrow(RuntimeException::new);
            
    }


}
