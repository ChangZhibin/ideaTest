package com.nuc.project.service.api;

import com.nuc.project.entity.Goods;

import java.util.List;

/**
 * @author 武士琦
 * @create 2022-12-22-10:53
 */
public interface GoodsService {
    ////获取所有的商品list集合
    List<Goods> getAllGoodsList();

    //模糊查询，根据商品名称
    List<Goods> getSelectGoodsByName(String name);

    //模糊查询，根据商品品类
    List<Goods> getSelectGoodsByVariety(String variety);

    //根据seller_id进行查询管理的商品
    List<Goods> getGoodsBySellerId(String sellerId);

    //根据goods_id删除商品信息
    int deleteGoodsByGoodsId(String goodsId);

    //添加商品
    int addGoods(Goods goods);
}
