package com.au.springdemo.dao;

import com.au.springdemo.entity.Account;

public interface AccountDAO {

	public Account findAccount(String userName);

}