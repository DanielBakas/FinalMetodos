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

public interface QueueCalculationBehavior {
    BigDecimal calculateCn(BigDecimal n);

    BigDecimal calculateLambdaE();

    BigDecimal calculateLambdaN(BigDecimal n);

    BigDecimal calculateL();

    BigDecimal calculateLq();

    BigDecimal calculateMuN(BigDecimal n);

    BigDecimal calculatePn(BigDecimal n);

    BigDecimal calculateP0();

    BigDecimal calculateRho();

    BigDecimal calculateW();

    BigDecimal calculateWq();
}