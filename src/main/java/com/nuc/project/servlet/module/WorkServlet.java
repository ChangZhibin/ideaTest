package com.nuc.project.servlet.module;

import com.nuc.project.entity.Goods;
import com.nuc.project.service.api.GoodsService;
import com.nuc.project.service.impl.GoodsServiceImpl;
import com.nuc.project.servlet.base.ModelBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author changzhibin
 * @create 2022-12-22-1:51
 * 商品相关的servlet
 */
public class WorkServlet extends ModelBaseServlet {

    GoodsService goodsService = new GoodsServiceImpl();

    //展示商品信息
    public void showGoodsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //调用service方法
        List<Goods> goodsList = goodsService.getAllGoodsList();

        //将查询到的数据存入请求域
        request.setAttribute("goodsList", goodsList);

        //渲染视图
        String templateName = "goods-list";
        processTemplate(templateName,request,response);
    }


    //根据商品名称搜索进行模糊查询
    public void selectGoodsByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectName = request.getParameter("selectName");

        List<Goods> goodsList = goodsService.getSelectGoodsByName(selectName);

        request.setAttribute("goodsList",goodsList);

        String templateName = "goods-list";
        processTemplate(templateName,request,response);
    }

    //根据商品品类搜索进行模糊查询
    public void selectGoodsByVariety(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectVariety = request.getParameter("selectVariety");

        List<Goods> goodsList = goodsService.getSelectGoodsByVariety(selectVariety);

        request.setAttribute("goodsList",goodsList);

        String templateName = "goods-list";
        processTemplate(templateName,request,response);
    }

    //根据用户id进行查询所管理的产品
    public void selectGoodsBySellerId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectSellerId = request.getParameter("selectSellerId");

        List<Goods> myGoodsList = goodsService.getGoodsBySellerId(selectSellerId);

        request.setAttribute("myGoodsList",myGoodsList);

        String templateName = "my-goods-lists";
        processTemplate(templateName,request,response);
    }

    //根据Seller_id删除该用户管理的信息
    public void deleteGoodsBySellerId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String goodsId = request.getParameter("goodsId");

        int i = goodsService.deleteGoodsByGoodsId(goodsId);


        String templateName = "success";
        processTemplate(templateName,request,response);

    }

    //添加商品
    public void addGoods(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String goodsId = request.getParameter("goodsId");
        String goodsName = request.getParameter("goodsName");
        String goodsVariety = request.getParameter("goodsVariety");
        String price = request.getParameter("price");
        String count = request.getParameter("count");
        String details = request.getParameter("details");
        String sellerId = request.getParameter("sellerId");

        Goods goods = new Goods(goodsId,goodsName,price,count,details,sellerId,goodsVariety);
        int i = goodsService.addGoods(goods);

        String templateName = "success-add";
        processTemplate(templateName,request,response);


    }

}
