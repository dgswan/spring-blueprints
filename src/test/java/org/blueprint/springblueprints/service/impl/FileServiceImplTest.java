package org.blueprint.springblueprints.service.impl;

import lombok.SneakyThrows;
import org.blueprint.springblueprints.service.CdnService;
import org.blueprint.springblueprints.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.io.File;
import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FileServiceImpl.class)
class FileServiceImplTest {

    @MockitoBean
    private CdnService azureCdnService;

    @Autowired
    private FileService fileService;

    @Test
    @SneakyThrows
    void testFileUpload() {
        when(azureCdnService.upload(any(File.class))).thenReturn(URI.create("https://cdn.example.com/test.txt"));
        assertThat(fileService.upload(File.createTempFile("test", ".txt")))
                .hasSize(1)
                .first()
                .isEqualTo(URI.create("https://cdn.example.com/test.txt"));
    }

}
