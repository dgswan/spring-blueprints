package org.blueprint.springblueprints.service;

import java.io.File;

/**
 * The service to check files for GDPR compliance.
 */
public interface GDPRFileService {

    void check(File file);

}
