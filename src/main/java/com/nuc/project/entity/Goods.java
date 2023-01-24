package com.nuc.project.entity;

/**
 * @author 赵梓博
 * @create 2022-12-21-17:19
 * 商品实体
 */
public class Goods {
    private String goodsId;
    private String goodsName;
    private String price;
    private String count;
    private String details;
    private String sellerId;
    private String goodsVariety;

    public Goods() {
    }

    public Goods(String goodsId, String goodsName, String price, String count, String details, String sellerId, String goodsVariety) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.count = count;
        this.details = details;
        this.sellerId = sellerId;
        this.goodsVariety = goodsVariety;
    }

    public String getGoodsVariety() {
        return goodsVariety;
    }

    public void setGoodsVariety(String goodsVariety) {
        this.goodsVariety = goodsVariety;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", details='" + details + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
