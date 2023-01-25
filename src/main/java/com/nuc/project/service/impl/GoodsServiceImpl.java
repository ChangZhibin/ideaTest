package com.nuc.project.service.impl;

import com.nuc.project.dao.api.GoodsDao;
import com.nuc.project.dao.impl.GoodsDaoImpl;
import com.nuc.project.entity.Goods;
import com.nuc.project.service.api.GoodsService;

import java.util.List;

/**
 * @author 武士琦
 * @create 2022-12-22-10:53
 */
public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao = new GoodsDaoImpl();

    //获取所有的商品list集合
    public List<Goods> getAllGoodsList() {
        return goodsDao.getAllGoodsList();
    }

    public List<Goods> getSelectGoodsByName(String name) {
        return goodsDao.getSelectGoodsByName(name);
    }

    public List<Goods> getSelectGoodsByVariety(String variety) {
        return goodsDao.getSelectGoodsByVariety(variety);
    }

    public List<Goods> getGoodsBySellerId(String sellerId) {
        return goodsDao.getGoodsBySellerId(sellerId);
    }

    public int deleteGoodsByGoodsId(String goodsId) {
        return goodsDao.deleteGoodsByGoodsId(goodsId);
    }

    public int addGoods(Goods goods) {

         goodsDao.addGoods(goods);
         goodsDao.addRelationship(goods);
         return 1;
    }

    //添加商品
    public int addGoodsForSelect(){
        return 0;
    }

}
