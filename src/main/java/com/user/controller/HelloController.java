package com.user.controller;

import com.user.domain.Account01;
import com.user.domain.Account02;
import com.user.domain.Student;
import com.user.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author zzq
 * 1.启动Tomcat服务器时，因为配置了load-on-startup 标签，所以会创建dispatcherServlet 和 springmvc.xml
 * 2.因为springmvc.xml开启了注解扫描，就会通过配置的包找到对应的Controller注解，将HelloController交给spring托管并创建
 * 3.index.jsp发送请求，请求会先到达DispatcherServlet核心控制器，根据配置的@RequestMapping注解找到要执行的具体方法，执行你的业务代码
 * 4.根据你的方法，找到对用的返回值，再根据配置的试图解析器，去指定的目录下找到指定的jsp文件
 * 5.Tomcat服务器渲染页面，做出响应
 *
 * RequestMapping注解：不知可以注解到方法，也可以注解到类上，如前端时user/hello,则可以在类上注解user，方法上注解hello
 *      属性：
 *          value: 用于只当请求的url，和path时一样的
 *          method: 用于指定请求的方法，他是枚举类的值
 *          params: 用于指定限制请求得参数条件, ! 和 = 限定参数值，!限定只能是不等于，=限定 只能是等于的，才能执行此方法  params = {"id!8"} params = {"id=8"}
 */
@Controller
@RequestMapping(path = "/user")
@SessionAttributes(value = {"username", "password"})
public class HelloController {

    /*@RequestMapping(path = "/hello", params = {"id"})
    public String sayHello(){
        System.out.println("SpringMVC hello");
        return "success";
    } */

    @RequestMapping(path = "/hello01")
    public String sayHello01(){
        System.out.println("SpringMVC hello");
        return "success";
    }


    /**
     * 方法的接收支持三种类型：
     *  1.基本类型和字符串类型
     *  2.实体类型（Bean）
     *  3.集合类型（list map）
     *
     * 基本类型和普通类型
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(path = "/login01")
    public String login01(String username, String password){
        System.out.println("SpringMVC hello");
        System.out.println(username+":"+password);
        return "success";
    }

    /**
     * 这里实体类接收参数，需要注意的是，参数名称和实体类的成员变量的名称要一致，否则匹配不上
     * 代替了   request.getParameters()方法获取参数
     *
     * 实体类类型，非嵌套
     * @param account01   非嵌套
     * @return
     */
    @RequestMapping(path = "/login02")
    public String login02(Account01 account01){
        System.out.println("login02 success");
        System.out.println(account01);
        return "success";
    }

    /**
     *
     * 实体类类型，嵌套（级联）
     * @param account01     嵌套（级联）
     * @return
     */
    @RequestMapping(path = "/login03")
    public String login03(Account01 account01){
        System.out.println("login03 success");
        System.out.println(account01);
        return "success";
    }

    /**
     * 集合类型
     *
     * @param account02
     * @return
     */
    @RequestMapping(path = "/login04")
    public String login04(Account02 account02){
        System.out.println("login04 success");
        System.out.println(account02);
        return "success";
    }

    /**
     * 有的参数类型，框架会给你自动的进行转换，如 int类型 以前要通过 Integer.parseInt(request.getParameters())进行类型转换
     * 但是有的类型不可以自动给你转换，如日期类型2020/01/01可以抓换，而2020-02-02就不能转换
     * @param student
     * @return
     */
    @RequestMapping(path = "/login05")
    public String login05(Student student){
        System.out.println("login05 success");
        System.out.println(student);
        return "success";
    }

    /**
     * 原生态的方法进行开发    原本的方法都可以使用
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(path = "/httpServlet")
    public String httpServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("date"));

/*        request.setAttribute();
        request.getRequestDispatcher();
        request.setCharacterEncoding();*/

        return "success";
    }


    /**
     * 存入session   如果是一次请求的话，不设置@SessionAttributes也能取到，如果是一次以上则不行
     * @param model
     * @return
     */
    @RequestMapping(path = "/testPut")
    public String testPut(Model model){
        System.out.println("开始存入");
        model.addAttribute("username","test");
        model.addAttribute("password","123");
        model.addAttribute("age", 18);
        return "success";
    }

    /**
     * 从session中取出数据
     * @param modelMap
     * @return
     */
    @RequestMapping(path = "/testGet")
    public String testGet(ModelMap modelMap){
        System.out.println("开始获取");
        System.out.println(modelMap.get("username") + "/" + modelMap.get("password") + "/" + modelMap.get("age"));
        return "success";
    }


    /**
     * 从session中清除数据
     * @param sessionStatus
     * @return
     */
    @RequestMapping(path = "/testClean")
    public String testClean(SessionStatus sessionStatus){
        System.out.println("开始清除");
       sessionStatus.setComplete();
       return "success";
    }

    /**
     *  SpringMVC01/WEB-INF/pages/user/testVoid.jsp
     *  void 返回值  框架会自动到我们的视图解析器中找到和方法名相同的jsp页面
     */
    /*@RequestMapping(path = "/testVoid")
    public void testVoid(){
        System.out.println("执行了testVoid方法");
    }*/


    /**
     * 使用void的方法： 1. 创建同名jsp页面  2. 使用HttpServletRequest请求转发
     */
    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        System.out.println("执行了testVoid方法");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        response.sendRedirect(request.getContextPath()+"/success.jsp");
    }



    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //添加视图  即跳转到success.jsp页面
        modelAndView.setViewName("success");
        User user = new User();
        user.setUsername("zs");
        user.setAge(20);
        modelAndView.addObject("user", user);
        return modelAndView;
    }



}
