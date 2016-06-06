package com.au.springdemo.dao;

import java.util.List;

import com.au.springdemo.model.CartInfo;
import com.au.springdemo.model.OrderDetailInfo;
import com.au.springdemo.model.OrderInfo;
import com.au.springdemo.model.PaginationResult;

public interface OrderDAO {

	public void saveOrder(CartInfo cartInfo);

	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

	public OrderInfo getOrderInfo(String orderId);

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}