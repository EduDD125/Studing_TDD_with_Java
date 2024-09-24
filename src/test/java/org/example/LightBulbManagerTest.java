package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static junit.framework.Assert.*;
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
            assertFalse(manager.isInputInvalid(a));
            assertTrue(manager.isInputInvalid(b));
            assertTrue(manager.isInputInvalid(c));
            assertFalse(manager.isInputInvalid(d));
        }

        @Test
        @DisplayName("Should return exception when input different from 0 or 1")
        void ShouldReturnExceptionWhenInputDifferentFrom0And1 () {
            int ia = -2;
            int ib = 0;
            int fa = 0;
            int fb = 100;

            Exception exception01 = assertThrows(IllegalArgumentException.class, () ->
                new LightBulbManager(ia, ib, fa, fb));

            assertEquals("Input must be either 0 or 1", exception01.getMessage());
        }

        @Test
        @DisplayName("Should only change state of ligth bulb 'A' when clicking the first switch")
        void ShouldOnlyChangeStateOfLigthBulbAWhenClickingTheFirstSwitch() {
            LightBulbManager manager = new LightBulbManager();
            manager.setLightBulbA(0);
            manager.clickFirstSwitch();
            assertEquals(manager.getLightBulbA(), 1);
            manager.clickFirstSwitch();
            assertEquals(manager.getLightBulbA(), 0);
        }

        @Test
        @DisplayName("Should change state of the two ligth bulbs when clicking the second switch")
        void ShouldChangeStateOfLigthBulbsWhenClickingTheSecondSwitch() {
            LightBulbManager manager = new LightBulbManager();
            manager.setLightBulbA(0);
            manager.setLightBulbB(1);
            manager.clickSecondSwitch();
            assertEquals(manager.getLightBulbA(), 1);
            assertEquals(manager.getLightBulbB(), 0);

            manager.clickSecondSwitch();
            assertEquals(manager.getLightBulbA(), 0);
            assertEquals(manager.getLightBulbB(), 1);

            manager.setLightBulbA(1);
            manager.setLightBulbB(1);
            manager.clickSecondSwitch();
            assertEquals(manager.getLightBulbA(), 0);
            assertEquals(manager.getLightBulbB(), 0);

            manager.clickSecondSwitch();
            assertEquals(manager.getLightBulbA(), 1);
            assertEquals(manager.getLightBulbB(), 1);
        }

        @Test
        @DisplayName("Should return if lamp A is in correct configuration")
        void ShouldReturnIfLampAIsInCorrectConfiguration() {
            LightBulbManager manager = new LightBulbManager(0 ,0,1,1);
            assertFalse(manager.isLampACorrect());
            manager.clickFirstSwitch();
            assertTrue(manager.isLampACorrect());
        }

        @Test
        @DisplayName("Should return if lamp B is in correct configuration")
        void ShouldReturnIfLampBIsInCorrectConfiguration() {
            LightBulbManager manager = new LightBulbManager(1 ,1,0,0);
            assertFalse(manager.isLampBCorrect());
            manager.clickSecondSwitch();
            assertTrue(manager.isLampBCorrect());
        }
    }
}
