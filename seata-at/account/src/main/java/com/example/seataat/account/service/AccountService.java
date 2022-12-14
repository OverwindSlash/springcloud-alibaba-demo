package com.example.seataat.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void reduce(String userId, int money) {
        jdbcTemplate.update("update account_tbl set money = " +
                "money - ? where user_id = ?", new Object[] {money, userId});
    }
}
