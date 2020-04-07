package com.software2.foodtruckfinder.audit;

import com.software2.foodtruckfinder.secure.audit.DateAudit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void Test(){
        assertNotNull(da);
    }

    @Test
    void setCreatedAtTest(){
        Instant in = Instant.now();
        da.setCreatedAt(in);

        assertEquals(in, da.getCreatedAt());
    }

    @Test
    void setUpdatedAtTest(){
        Instant in = Instant.now();
        da.setUpdatedAt(in);

        assertEquals(in, da.getUpdatedAt());
    }
}
