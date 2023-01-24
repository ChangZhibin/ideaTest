package com.nuc.project.entity;

/**
 * @author 赵梓博
 * @create 2022-12-22-18:38
 */
public class Shopping {
    private int shoppingId;
    private String goodsId;
    private String goodsName;
    private String buyerId;
    private String buyerName;
    private int buyCount;
    private int state;

    public Shopping() {
    }

    public Shopping(String goodsId, String goodsName, String buyerId, String buyerName, int buyCount, int state) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyCount = buyCount;
        this.state = state;
    }

    public Shopping(String goodsId,  String buyerId) {
        this.goodsId = goodsId;
        this.buyerId = buyerId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(int shoppingId) {
        this.shoppingId = shoppingId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shoppingId=" + shoppingId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyCount=" + buyCount +
                '}';
    }
}
