package org.blueprint.springblueprints.service.impl;

import lombok.RequiredArgsConstructor;
import org.blueprint.springblueprints.config.ApplicationConfiguration;
import org.blueprint.springblueprints.dto.FileInfo;
import org.blueprint.springblueprints.service.CdnService;
import org.blueprint.springblueprints.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class FileServiceImpl implements FileService {

    private final Collection<CdnService> cdnServices;

    private final ApplicationConfiguration applicationConfiguration;

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<URI> upload(File file) {
        return cdnServices.stream()
                .map(service -> service.upload(file))
                .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<FileInfo> getFileInfo(String key) {
        return cdnServices.stream()
                .map(service -> service.getFileInfo(key))
                .toList();
    }
}
