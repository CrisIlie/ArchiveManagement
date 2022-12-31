package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Document;
import org.example.exception.BusinessException;
import org.example.mapper.DocumentMapper;
import org.example.model.document.*;
import org.example.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DocumentService {
    private final DocumentRepository documentRepository;

    private final DocumentMapper documentMapper;

    public DocumentResponse createDocument(DocumentRequest documentRequest) {
        Document document = documentMapper.map(documentRequest);
        return documentMapper.map(documentRepository.save(document));
    }

    public List<DocumentResponse> findAll(){
        return documentMapper.map(documentRepository.findAll());
    }

    public DocumentResponse findById(Integer id){
        return documentMapper.map(documentRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Document not found")
        ));
    }

    public void updateArchivingDate(Integer id, RequestUpdateArchivingDateDocument requestUpdateArchivingDateDocument){
        Document documentArchivingDateToUpdate = documentRepository.findById(id).orElseThrow(
                ()-> new BusinessException(String.format("Document with id: %s not found", id))
        );
        documentArchivingDateToUpdate.setArchivingDate(requestUpdateArchivingDateDocument.getArchivingDate());
    }

    public void updateDocumentDescription(Integer id, RequestUpdateDocumentDescription requestUpdateDocumentDescription){
        Document documentDescriptionToUpdate = documentRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Document with id: %s not found", id))
        );
        documentDescriptionToUpdate.setDocumentDescription(requestUpdateDocumentDescription.getDocumentDescription());
    }

    public void updateDocumentTitle(Integer id, RequestUpdateDocumentTitle requestUpdateDocumentTitle){
        Document documentTitleToUpdate = documentRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Document with id: %s not found", id))
        );
        documentTitleToUpdate.setDocumentTitle(requestUpdateDocumentTitle.getDocumentTitle());
    }
}
