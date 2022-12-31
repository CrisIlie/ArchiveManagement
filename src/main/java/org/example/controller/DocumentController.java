package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.document.*;
import org.example.repository.DocumentRepository;
import org.example.service.DocumentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("document")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class DocumentController {
    private final DocumentService documentService;

    private final DocumentRepository documentRepository;

    @PostMapping("create")
    public DocumentResponse createDocument(@RequestBody @Valid DocumentRequest documentRequest) {
        return documentService.createDocument(documentRequest);
    }

    @GetMapping("find/{id}")
    public DocumentResponse findById(@PathVariable Integer id) {
        return documentService.findById(id);
    }

    @GetMapping
    public List<DocumentResponse> findAll(){
        return documentService.findAll();
    }

    @PostMapping("update-document-achiving-date/{id}")
    public void updateArchivingDateDocument(@PathVariable Integer id, @RequestBody @Valid RequestUpdateArchivingDateDocument requestUpdateArchivingDateDocument){
        documentService.updateArchivingDate(id, requestUpdateArchivingDateDocument);
    }

    @PostMapping("update-document-description/{id}")
    public void updateDocumentDescription(@PathVariable Integer id, @RequestBody @Valid RequestUpdateDocumentDescription requestUpdateDocumentDescription){
        documentService.updateDocumentDescription(id, requestUpdateDocumentDescription);
    }

    @PostMapping("update-document-title/{id}")
    public void updateDocumentTitle(@PathVariable Integer id, @RequestBody @Valid RequestUpdateDocumentTitle requestUpdateDocumentTitle){
        documentService.updateDocumentTitle(id, new RequestUpdateDocumentTitle());
    }
}
