package web;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import po.User;
import services.UserService;
import vo.ResultInfo;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;

@WebServlet("/user")
public class UserServelet extends HttpServlet {

    private UserService userService =null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring.xml");
         userService = (UserService) beanFactory.getBean("userService");
        String actionName = req.getParameter("actionName");
        if("login".equals(actionName)){
            LogIn(req,resp);
        }

    }

    ResultInfo resultInfo = null;
    public void LogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        ResultInfo<User> resultInfo = userService.checkLoginInfo(userName,userPwd);
        boolean isLoginCorrect = (resultInfo.getCode() == 100);
        if(isLoginCorrect){
            request.getSession().setAttribute("user",resultInfo.getResult());

            String rem = request.getParameter("rem");
            if("1".equals(rem)){
                Cookie cookie = new Cookie("user",userName+"-"+userPwd);
                cookie.setMaxAge(3*24*60*60);//设置浏览器cookie缓存为3天
                response.addCookie(cookie);
            }else {
                Cookie cookie = new Cookie("user",null);
                cookie.setMaxAge(0);//设置浏览器cookie缓存为3天
                response.addCookie(cookie);
            }
            response.sendRedirect("index.jsp");
        }else {
            request.setAttribute("resultInfo",resultInfo);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
