package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.BoxRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoxService {

    private final BoxRepository boxRepository;

}

