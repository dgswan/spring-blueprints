package org.blueprint.springblueprints.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;

public interface CdnService {

    URI upload(File file);

    default File download(String fileKey) {
        try {
            return File.createTempFile("downloaded-", fileKey);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
