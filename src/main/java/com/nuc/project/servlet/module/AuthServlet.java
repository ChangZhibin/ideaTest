package com.nuc.project.servlet.module;

import com.nuc.project.entity.User;
import com.nuc.project.exception.LoginFailedException;
import com.nuc.project.service.impl.UserServiceImpl;
import com.nuc.project.servlet.base.ModelBaseServlet;
import com.nuc.project.util.ImperialCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author changzhibin
 * @create 2022-12-21-21:48
 * 关于用户登录，注册，退出
 * 用户具体信息， 管理用户信息
 */
public class AuthServlet extends ModelBaseServlet {

    UserServiceImpl userService = new UserServiceImpl();

    //登录方法login
    protected void login(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1、获取请求参数
            String loginAccount = request.getParameter("loginAccount");
            String loginPassword = request.getParameter("loginPassword");

            // 2、调用 UserService 方法执行登录逻辑

            User user = userService.selectUserByLoginAccount(loginAccount, loginPassword);

            // 3、通过 request 获取 HttpSession 对象
            HttpSession session = request.getSession();

            // 4、将查询到的 user 对象存入 Session 域
            session.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME, user);

            // 5、前往指定页面视图
            // 前往临时页面
//             String templateName = "temp";
//             processTemplate(templateName, request, response);

            // 前往正式的目标地址
            response.sendRedirect(request.getContextPath() + "/work?method=showGoodsList");

        } catch (Exception e) {
            e.printStackTrace();

            // 6、判断此处捕获到的异常是否是登录失败异常
            if (e instanceof LoginFailedException) {
                // 7、如果是登录失败异常则跳转回登录页面
                // ①将异常信息存入请求域
                request.setAttribute("message", e.getMessage());

                // ②处理视图：index
                processTemplate("index", request, response);

            }else {
                // 8、如果不是登录异常则封装为运行时异常继续抛出
                throw new RuntimeException(e);

            }

        }

    }


    //用户注册
    protected void register(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException{

        // 1、获取请求参数
        String registerAccount = request.getParameter("userId");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");


        //2.调用userService进行判断registerAccount是否进行过注册
        if(userService.selectUserByRegisterAccount(registerAccount)){
            //如果存在，则进行抛出异常
            throw new LoginFailedException(ImperialCourtConst.REGISTER_EMP_ATTR_NAME);
        }else{
            //3 如果不存在，则进行注册操作
            User user = new User(userId, password, name, sex, phone);
            int result = userService.registerUser(user);
        }

        // 4、前往指定页面视图
        // 前往登录页面
        String templateName = "index";
        processTemplate(templateName, request, response);

    }


    //退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1、通过 request 对象获取 HttpSession 对象
        HttpSession session = request.getSession();

        // 2、将 HttpSession 对象强制失效
        session.invalidate();

        // 3、回到首页
        String templateName = "index";
        processTemplate(templateName, request, response);
    }




    //用户具体信息展示
    protected void showUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取请求参数userId
        String userId = request.getParameter("userId");

        //根据userId从UserService中查询user对象
        User user = userService.getUserByUserId(userId);

        //将user对象放在请求域中
        request.setAttribute("user",user);

        //解析渲染视图
        String templateName = "user-details";
        processTemplate(templateName,request,response);
    }

    //展示所有用户
    protected void showAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<User> userList = userService.showAllUser();

        request.setAttribute("userList",userList);

        String templateName = "all-user-list";
        processTemplate(templateName,request,response);
    }

    //根据id删除用户
    public void deleteUserByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");

        int i = userService.deleteUserByUserId(userId);

        String templateName = "success";
        processTemplate(templateName,request,response);

    }

    //改id的用户是0，普通用户改为管理员
    public void updateState0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");

        int i = userService.updateState0(userId);

        String templateName = "success-update";
        processTemplate(templateName,request,response);

    }
    //改id的用户是0，用户改为普通用户
    public void updateState1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");

        int i = userService.updateState1(userId);

        String templateName = "success-update";
        processTemplate(templateName,request,response);
    }

}
