package com.software2.foodtruckfinder.config;

import com.software2.foodtruckfinder.secure.config.AuditingConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.data.domain.AuditorAware;

import static org.junit.jupiter.api.Assertions.*;

public class AuditConfigTest {

    @DisplayName("AuditConfig Test")
    @Test
    void auditConfigTest(){
        AuditingConfig ac = new AuditingConfig();
        assertNotNull(ac.auditorProvider());
    }
}
