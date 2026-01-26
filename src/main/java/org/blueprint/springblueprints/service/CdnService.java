package org.blueprint.springblueprints.service;

import java.io.File;
import java.net.URI;

public interface CdnService {

    URI upload(File file);

}
