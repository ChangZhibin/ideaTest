package com.nuc.project.service.impl;

import com.nuc.project.dao.api.ShoppingDao;
import com.nuc.project.dao.impl.ShoppingDaoImpl;
import com.nuc.project.entity.Shopping;
import com.nuc.project.service.api.ShoppingService;
import com.nuc.project.service.api.UserService;

import java.util.List;

/**
 * @author 贾戎戈
 * @create 2022-12-22-18:41
 */
public class ShoppingServiceImpl implements ShoppingService {

    private ShoppingDao shoppingDao = new ShoppingDaoImpl();

    public List<Shopping> selectUserShoppingList(String userId) {
        return shoppingDao.selectUserShoppingList(userId);
    }

    public int deleteShoppingByShoppingId(String shoppingId) {
        return shoppingDao.deleteShoppingByShoppingId(shoppingId);
    }

    public List<Shopping> showAllShopping() {
        return shoppingDao.showAllShopping();
    }

    public int buyShoppingByShoppingId(String shoppingId) {
        return shoppingDao.buyShoppingByShoppingId(shoppingId);
    }

    public int buyGoodsToShopping(Shopping shopping) {
        return shoppingDao.buyGoodsToShopping(shopping);
    }
}
