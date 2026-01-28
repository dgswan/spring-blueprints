package org.blueprint.springblueprints.service;

import org.blueprint.springblueprints.dto.FileInfo;

import java.io.File;
import java.net.URI;
import java.util.Collection;

/**
 * The service interface to upload / download files to/from a remote location.
 */
public interface FileService {

    Collection<URI> upload(File file);

    Collection<FileInfo> getFileInfo(String key);

}
