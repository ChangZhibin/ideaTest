package com.nuc.project.servlet.module;

import com.nuc.project.entity.Shopping;
import com.nuc.project.service.api.ShoppingService;
import com.nuc.project.service.impl.ShoppingServiceImpl;
import com.nuc.project.servlet.base.ModelBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author changzhibin
 * @create 2022-12-22-16:42
 * 有关购物车的相关操作
 */
public class ShoppingServlet extends ModelBaseServlet {

    ShoppingService shoppingService = new ShoppingServiceImpl();

    //展示购买信息
    protected void selectUserShoppingList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");

        List<Shopping> shoppingList = shoppingService.selectUserShoppingList(userId);

        request.setAttribute("shoppingList", shoppingList);

        //渲染视图
        String templateName = "shoppingbyuser-details";
        processTemplate(templateName,request,response);

    }

    //根据shoppingId删除购物车信息
    public void deleteShoppingByShoppingId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String shoppingId = request.getParameter("shoppingId");

        int i = shoppingService.deleteShoppingByShoppingId(shoppingId);

        String templateName = "success";
        processTemplate(templateName,request,response);

    }

    //管理员权限： 展示所有的订单信息
    public void showAllShopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        List<Shopping> shoppingList = shoppingService.showAllShopping();

        request.setAttribute("shoppingList", shoppingList);

        //渲染视图
        String templateName = "allShoppingList";
        processTemplate(templateName,request,response);
    }

    //在购物车支付购买
    public void buyShoppingByShoppingId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String shoppingId = request.getParameter("shoppingId");

        int i = shoppingService.buyShoppingByShoppingId(shoppingId);

        String templateName = "success-buy";
        processTemplate(templateName,request,response);

    }

    //添加商品到购物车
    public void buyGoodsToShopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //获取参数
        String goodsId = request.getParameter("goodsId");
        String buyerId = request.getParameter("buyerId");

        Shopping shopping = new Shopping(goodsId,buyerId);

        int i = shoppingService.buyGoodsToShopping(shopping);

        String templateName = "success-contain";
        processTemplate(templateName,request,response);
    }
}
