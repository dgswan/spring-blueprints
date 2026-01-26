package org.blueprint.springblueprints.service.impl;

import lombok.SneakyThrows;
import org.blueprint.springblueprints.annotations.GDPRCompliantCdn;
import org.blueprint.springblueprints.service.CdnService;
import org.blueprint.springblueprints.service.GDPRFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.io.File;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = GDPRFileServiceImpl.class)
class GDPRFileServiceImplTest {

    @GDPRCompliantCdn
    @MockitoBean(name = "azureCdnServiceImpl")
    private CdnService azureCdnService;

    @MockitoBean(name = "tencentCdnServiceImpl")
    private CdnService tencentCdnService;

    @MockitoBean(name = "cloudFrontCdnServiceImpl")
    private CdnService cloudFrontCdnService;

    @Autowired
    private GDPRFileService underTest;

    @Test
    @SneakyThrows
    void testCheck() {
        when(azureCdnService.download(anyString())).thenReturn(File.createTempFile("test", ".txt"));
        underTest.check(File.createTempFile("test", ".txt"));
        verify(azureCdnService).download(anyString());
        verifyNoInteractions(cloudFrontCdnService);
        verifyNoInteractions(tencentCdnService);
    }

}
