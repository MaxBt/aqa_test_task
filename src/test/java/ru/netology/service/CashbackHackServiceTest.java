package ru.netology.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    private CashbackHackService cashbackHackService;

    @BeforeEach
    void setUp() {
        //given
        cashbackHackService = new CashbackHackService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_should_not_suggest_when_sum_aliquot_to_1000() {
        //when
        int upsellAmount = cashbackHackService.remain(3000);

        //then
        Assertions.assertEquals(0, upsellAmount);
    }

    @Test
    void test_should_suggest_when_sum_is_zero() {
        //when
        int upsellAmount = cashbackHackService.remain(0);

        //then
        Assertions.assertEquals(1000, upsellAmount);
    }

    @Test
    void test_should_suggest_minimal_amount() {
        //when
        int upsellAmount = cashbackHackService.remain(999);

        //then
        Assertions.assertEquals(1, upsellAmount);
    }

    @Test
    void test_should_not_suggest_when_amount_is_negative() {
        //when //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cashbackHackService.remain(-1500);
        });
    }

    @Test
    void test_should_suggest_maximal_amount() {
        //when
        int upsellAmount = cashbackHackService.remain(Integer.MAX_VALUE);

        //then
        Assertions.assertEquals(353, upsellAmount);
    }

}