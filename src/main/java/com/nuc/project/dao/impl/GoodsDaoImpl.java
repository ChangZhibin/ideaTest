package com.nuc.project.dao.impl;

import com.nuc.project.dao.BaseDao;
import com.nuc.project.dao.api.GoodsDao;
import com.nuc.project.entity.Goods;

import java.util.List;

/**
 * @author 武士琦
 * @create 2022-12-22-10:52
 */
public class GoodsDaoImpl extends BaseDao<Goods> implements GoodsDao {

    ////获取所有的商品list集合
    public List<Goods> getAllGoodsList() {

        //写sql语句
        String sql = "select goods.goods_id goodsId, " +
                "goods_name goodsName, price, count, details," +
                " seller_id sellerId, varieties_name goodsVariety\n" +
                "from goods, relationship\n" +
                "where goods.goods_id = relationship.goods_id";

        return super.getBeanList(sql, Goods.class);
    }

    public List<Goods> getSelectGoodsByName(String name) {

        String sql = "select goods.goods_id goodsId, goods_name goodsName, price, count, details, seller_id, varieties_name goodsVariety\n" +
                "from goods, relationship\n" +
                "where goods.goods_id = relationship.goods_id\n" +
                "and goods_name like ?";
        name = "%" + name +"%";
        return super.getBeanList(sql,Goods.class,name);

    }

    public List<Goods> getSelectGoodsByVariety(String variety) {
        String sql = "select goods.goods_id goodsId, goods_name goodsName, price, count, details, seller_id, varieties_name goodsVariety\n" +
                "from goods, relationship\n" +
                "where goods.goods_id = relationship.goods_id\n" +
                "and varieties_name like ?";
        variety = "%" + variety +"%";
        return super.getBeanList(sql,Goods.class,variety);
    }

    public List<Goods> getGoodsBySellerId(String sellerId) {
        String sql = "select goods.goods_id goodsId,\n" +
                "goods_name goodsName, price, `count`, details,\n" +
                "seller_id sellerId, varieties_name goodsVariety\n" +
                "from goods, relationship\n" +
                "where goods.goods_id = relationship.goods_id\n" +
                "and seller_id = ?";

        return super.getBeanList(sql,Goods.class, sellerId);
    }

    public int deleteGoodsByGoodsId(String goodsId) {
        String sql = "delete from goods where goods_id = ?";

        return super.update(sql,goodsId);
    }

    //添加商品，例如：蔬菜类
    public int addGoods(Goods goods) {
        String sql = "insert into goods(goods_id,goods_name,price,`count`,details,seller_id)\n" +
                "values (?,?,?,?,?,?);";

        return super.update(sql,goods.getGoodsId(),goods.getGoodsName(),goods.getPrice(),
                goods.getCount(),goods.getDetails(),goods.getSellerId());
    }

    public int addRelationship(Goods goods) {
        String sql = "insert into relationship values(2,'蔬菜类',?);";
        return super.update(sql,goods.getSellerId());
    }


}
