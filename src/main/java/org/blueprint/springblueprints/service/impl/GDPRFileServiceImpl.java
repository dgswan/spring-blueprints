package org.blueprint.springblueprints.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.blueprint.springblueprints.annotations.GDPRCompliantCdn;
import org.blueprint.springblueprints.service.CdnService;
import org.blueprint.springblueprints.service.GDPRFileService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
class GDPRFileServiceImpl implements GDPRFileService {

    private final CdnService cdnService;

    public GDPRFileServiceImpl(@GDPRCompliantCdn CdnService cdnService) {
        this.cdnService = cdnService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void check(File file) {
        val checkedFile = cdnService.download(file.getName());
        log.info("Checking file {}", checkedFile.getAbsolutePath());
    }
}
