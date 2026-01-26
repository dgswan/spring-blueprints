package org.blueprint.springblueprints.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.blueprint.springblueprints.annotations.ConditionalOnEnabledCdnProvider;
import org.blueprint.springblueprints.service.CdnService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;

@Service
@Slf4j
@ConditionalOnEnabledCdnProvider(value = "tencent")
class TencentCdnServiceImpl implements CdnService {

    /**
     * {@inheritDoc}
     */
    @Override
    public URI upload(File file) {
        log.info("Upload the file {} to Tencent CDN", file.getName());
        return URI.create("https://spring-blueprints-bucket.tencent.com/" + file.getName());
    }
}
