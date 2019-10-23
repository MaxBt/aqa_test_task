package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CashbackHackServiceTest {

    private CashbackHackService cashbackHackService =  new CashbackHackService();

    @ParameterizedTest
    @CsvFileSource(resources = "/cachbackedAmounts.csv", numLinesToSkip = 1)
    void test_should_suggest_exact_value(int sum, int expectedUpsell) {
        //when
        int actualUpsell = cashbackHackService.remain(sum);

        //then
        Assertions.assertEquals(expectedUpsell, actualUpsell);
    }

    @Test
    void test_should_not_suggest_when_sum_is_zero() {
        //when //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cashbackHackService.remain(0);
        });
    }

    @Test
    void test_should_not_suggest_when_amount_is_negative() {
        //when //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cashbackHackService.remain(-1500);
        });
    }
}