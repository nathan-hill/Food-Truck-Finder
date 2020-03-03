package com.software2.foodtruckfinder.audit;

import com.software2.foodtruckfinder.secure.audit.DateAudit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class DateAuditTest {

    private DateAudit da;

    @BeforeEach
    void init() {
        da = new DateAudit() {
            @Override
            public Instant getCreatedAt() {
                return super.getCreatedAt();
            }
        };
    }

    @Test
    @DisplayName("getCreatedAt test")
    void getCreatedAtTest(){
        System.out.println(da.getCreatedAt());
    }
}
