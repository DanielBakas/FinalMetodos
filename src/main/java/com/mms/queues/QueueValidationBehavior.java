package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `QueueCalculationBehavior.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 25, 2022
 * =============================================================================
 */

import java.math.BigDecimal;

public interface QueueValidationBehavior {
    boolean isValid(BigDecimal value);
}