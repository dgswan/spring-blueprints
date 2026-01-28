package org.blueprint.springblueprints.service;

import org.blueprint.springblueprints.dto.FileInfo;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.util.Random;

public interface CdnService {

    Random RANDOM = new Random();

    URI upload(File file);

    default FileInfo getFileInfo(String fileKey) {
        return new FileInfo(fileKey, RANDOM.nextLong(), "payload");
    }

    default File download(String fileKey) {
        try {
            return File.createTempFile("downloaded-", fileKey);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
