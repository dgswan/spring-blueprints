package org.blueprint.springblueprints.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.blueprint.springblueprints.annotations.ConditionalOnEnabledCdnProvider;
import org.blueprint.springblueprints.service.CdnService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
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
        try {
            val content = FileCopyUtils.copyToByteArray(file);
            log.info("{} bytes uploaded.", content.length);
            return URI.create("https://spring-blueprints-bucket.tencent.com/" + file.getName());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
