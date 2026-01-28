package org.blueprint.springblueprints.service.impl;

import lombok.SneakyThrows;
import org.blueprint.springblueprints.config.ApplicationConfiguration;
import org.blueprint.springblueprints.dto.FileInfo;
import org.blueprint.springblueprints.service.CdnService;
import org.blueprint.springblueprints.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FileServiceImpl.class)
@EnableConfigurationProperties(ApplicationConfiguration.class)
@Import(JacksonAutoConfiguration.class)
class FileServiceImplTest {

    @Value("classpath:file-info.json")
    private Resource fileInfo;

    @MockitoBean(name = "azureCdnServiceImpl")
    private CdnService azureCdnService;

    @MockitoBean(name = "tencentCdnServiceImpl")
    private CdnService tencentCdnService;

    @MockitoBean(name = "cloudFrontCdnServiceImpl")
    private CdnService cloudFrontCdnService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileService underTest;

    @Test
    @SneakyThrows
    void testFileUpload() {
        when(azureCdnService.upload(any(File.class))).thenReturn(URI.create("https://example.azure.com/test.txt"));
        when(tencentCdnService.upload(any(File.class))).thenReturn(URI.create("https://example.tencent.com/test.txt"));
        when(cloudFrontCdnService.upload(any(File.class))).thenReturn(URI.create("https://example.cloud-front.com/test.txt"));
        assertThat(underTest.upload(File.createTempFile("test", ".txt")))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        URI.create("https://example.azure.com/test.txt"),
                        URI.create("https://example.tencent.com/test.txt"),
                        URI.create("https://example.cloud-front.com/test.txt")
                );
    }

    @Test
    @SneakyThrows
    void testFileInfo() {
        when(azureCdnService.getFileInfo(anyString())).thenReturn(new FileInfo("test.txt", 1024L, "payload"));
        assertThat(underTest.getFileInfo("test.txt"))
                .isNotNull()
                .anySatisfy(fi -> assertThat(objectMapper.writeValueAsString(fi))
                        .isEqualToIgnoringWhitespace(fileInfo.getContentAsString(StandardCharsets.UTF_8)));
    }

}
