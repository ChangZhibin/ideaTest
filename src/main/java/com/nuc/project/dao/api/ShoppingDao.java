package com.nuc.project.dao.api;

import com.nuc.project.entity.Shopping;

import java.util.List;

/**
 * @author 贾戎戈
 * @create 2022-12-22-18:40
 */
public interface ShoppingDao {

    //查询用户的购物车信息
    List<Shopping> selectUserShoppingList(String userId);

    //根据shoppingId删除该购物信息
    int deleteShoppingByShoppingId(String shoppingId);

    //查询所有的订单信息
    List<Shopping> showAllShopping();

    //将订单的支付未付款状态转为已支付
    int buyShoppingByShoppingId(String shoppingId);

    //添加购物车,默认count为1
    int buyGoodsToShopping(Shopping shopping);
}
