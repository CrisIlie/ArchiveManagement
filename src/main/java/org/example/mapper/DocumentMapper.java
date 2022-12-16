package org.example.mapper;

import org.example.entity.Document;
import org.example.model.document.*;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface DocumentMapper {

    Document map(DocumentRequest documentRequest);

    DocumentResponse map(Document document);

    List<DocumentResponse> map(List<Document> allDocuments);

    Document map(RequestUpdateDocumentTitle requestUpdateTitle);

    Document map(RequestUpdateDocumentDescription requestUpdateDocumentDescription);

    Document map(RequestUpdateArchivingDateDocument requestUpdateArchivingDateDocument);

}
