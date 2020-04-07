package com.software2.foodtruckfinder.audit;

import com.software2.foodtruckfinder.secure.audit.UserDateAudit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDateAuditTest {
    UserDateAudit uda;

    @BeforeEach
    void init(){
        uda = new UserDateAudit() {
            @Override
            public Long getCreatedBy() {
                return super.getCreatedBy();
            }
        };
    }

    @Test
    @DisplayName("init Test")
    void initTest(){
        assertNotNull(uda);
    }

    @Test
    @DisplayName("createdBy test")
    void createdByTest(){
        uda.setCreatedBy(123l);
        assertEquals(123l, uda.getCreatedBy());
    }

    @Test
    @DisplayName("updatedBy test")
    void updatedBy(){
        uda.setUpdatedBy(321l);
        assertEquals(321l, uda.getUpdatedBy());
    }
}
