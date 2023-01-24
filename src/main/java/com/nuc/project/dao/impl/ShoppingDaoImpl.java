package com.nuc.project.dao.impl;

import com.nuc.project.dao.BaseDao;
import com.nuc.project.dao.api.ShoppingDao;
import com.nuc.project.entity.Shopping;

import java.util.List;

/**
 * @author 贾戎戈
 * @create 2022-12-22-18:40
 */
public class ShoppingDaoImpl extends BaseDao implements ShoppingDao {

    public List<Shopping> selectUserShoppingList(String userId) {
        String sql = "select shopping_id shoppingId,\n" +
                " shoppingdata.goods_id goodsId, \n" +
                " goods.goods_name goodsName,\n" +
                " buyer_id buyerId ,\n" +
                " user.name buyerName,\n" +
                "  buy_count buyCount ,state\n" +
                "  from shoppingdata, goods, user\n" +
                "  where buyer_id = ?\n" +
                "  and shoppingdata.goods_id = goods.goods_id\n" +
                "  and buyer_id = user.user_id";

        return super.getBeanList(sql,Shopping.class,userId);
    }

    public int deleteShoppingByShoppingId(String shoppingId) {
        String sql = "delete from shoppingdata where shopping_id = ?";

        return super.update(sql,shoppingId);
    }

    public List<Shopping> showAllShopping() {

        String sql = "select shopping_id shoppingId,\n" +
                " shoppingdata.goods_id goodsId, \n" +
                " goods.goods_name goodsName,\n" +
                " buyer_id buyerId ,\n" +
                " user.name buyerName,\n" +
                "  buy_count buyCount ,state\n" +
                "  from shoppingdata, goods, user\n" +
                "  where shoppingdata.goods_id = goods.goods_id\n" +
                "  and buyer_id = user.user_id";

        return super.getBeanList(sql,Shopping.class);
    }

    public int buyShoppingByShoppingId(String shoppingId) {
        String sql = "update shoppingdata set state = 1 where shopping_id = ?";

        return super.update(sql,shoppingId);
    }

    public int buyGoodsToShopping(Shopping shopping) {
        String sql = "insert into shoppingdata(goods_id, buyer_id) values (?,?);";

        return super.update(sql,shopping.getGoodsId(),shopping.getBuyerId());
    }


}
