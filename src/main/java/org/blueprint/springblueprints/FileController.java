package org.blueprint.springblueprints;

import org.blueprint.springblueprints.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.util.Collection;

@RestController
public class FileController {

    private final FileService fileService;
    private final Resource businessData;

    public FileController(FileService fileService,
                          @Value("classpath:business-data.json") Resource businessData) {
        this.fileService = fileService;
        this.businessData = businessData;
    }

    @PostMapping(path = "/upload")
    public Collection<URI> uploadFile() {
        try {
            return fileService.upload(businessData.getFile());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
