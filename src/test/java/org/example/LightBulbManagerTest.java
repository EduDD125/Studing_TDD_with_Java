package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LightBulbManagerTest {
    @Nested
    @DisplayName("Testing invalid equivalence classes")
    class TestingInvalidClasses{

        @Test
        @DisplayName("Shoul return false when input ins´t either 0 or 1")
        void ShoulReturnFalseWhenInputInstEitherZeroOr1() {
            int a = -1;
            int b = 0;
            int c = 1;
            int d = 2;
            LightBulbManager manager = new LightBulbManager();
            assertEquals(manager.isInputInvalid(a), false);
            assertEquals(manager.isInputInvalid(b), true);
            assertEquals(manager.isInputInvalid(c), true);
            assertEquals(manager.isInputInvalid(d), false);
        }

        @Test
        @DisplayName("Should return exception when input different from 0 or 1")
        void ShouldReturnExceptionWhenInputDifferentFrom0And1 () {
            int ia = -2;
            int ib = 0;
            int fa = 0;
            int fb = 100;

            Exception exception01 = assertThrows(IllegalArgumentException.class, () -> {
                new LightBulbManager(ia, ib, fa, fb);
            });

            assertEquals("Input must be either 0 or 1", exception01.getMessage());
        }

        @Test
        @DisplayName("Should only change state of ligth bulb 'A' when clicking the first switch")
        void ShouldOnlyChangeStateOfLigthBulbAWhenClickingTheFirstSwitch() {
            LightBulbManager manager = new LightBulbManager();
            LightBulbManager.setLightBulbA(0);
            LightBulbManager.clickFirstSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 1);
            LightBulbManager.clickFirstSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 0);
        }

        @Test
        @DisplayName("Should change state of the two ligth bulbs when clicking the second switch")
        void ShouldChangeStateOfLigthBulbsWhenClickingTheSecondSwitch() {
            LightBulbManager manager = new LightBulbManager();
            LightBulbManager.setLightBulbA(0);
            LightBulbManager.setLightBulbB(1);
            LightBulbManager.clickSecondSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 1);
            assertEquals(LightBulbManager.getLightBulbB, 0);

            LightBulbManager.clickSecondSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 0);
            assertEquals(LightBulbManager.getLightBulbB, 1);

            LightBulbManager.setLightBulbA(1);
            LightBulbManager.setLightBulbB(1);
            LightBulbManager.clickSecondSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 0);
            assertEquals(LightBulbManager.getLightBulbB, 0);

            LightBulbManager.clickSecondSwitch();
            assertEquals(LightBulbManager.getLightBulbA, 1);
            assertEquals(LightBulbManager.getLightBulbB, 1);
        }

    }
}
