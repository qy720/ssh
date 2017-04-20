package cn.itcast.shop.user.action;

import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.user.vo.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户执行的Action
 * Created by Administrator on 2017/3/17.
 */
public class UserAction extends ActionSupport implements ModelDriven<UserEntity>{
    //模型驱动使用的对象
    private UserEntity user = new UserEntity();

    @Override
    public UserEntity getModel() {
        return user;
    }

    //注入UserService
    @Resource
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转到注册页面的执行方法
     * @return
     */
    public String registPage(){
        return "registPage";
    }

    /**
     * AJAX进行异步校验用户名的执行方法
     * @return
     * @throws IOException
     */
    public String findByName() throws IOException {
        //调用Service进行查询
        UserEntity existUser = userService.findByUsername(user.getUsername());
        //获得response对象。向页面输出
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        //判断
        if(existUser != null){
            //查询到该用户:用户名已经存在
            response.getWriter().println("<font color='red'>用户名已存在</font>");
        }else {
            //没有查询到该用户:用户名可以使用
            response.getWriter().println("<font color='green'>用户名可以使用</font>");
        }
        return NONE;
    }

    /**
     * 用户注册方法
     * @return
     */
    public String regist(){
        // 判断验证码程序:
        // 从session中获得验证码的值:
        String codes = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
        HttpServletRequest request = ServletActionContext.getRequest();
        String checkcode = request.getParameter("captcha");
        System.out.println(checkcode);
        if(!checkcode.equalsIgnoreCase(codes)){
            this.addActionError("验证码错误！");
            return "checkcodeFail";
        }
        userService.save(user);
        this.addActionMessage("注册成功，请去邮箱激活");
        return "msg";
    }
    /**
     * 用户激活
     * @return
     */
    public String active(){
        //根据激活码查询用户
        UserEntity existUser = userService.findByCode(user.getCode());
        if(existUser == null){
            //激活码错误
            this.addActionMessage("激活失败：激活码错误");
        }else {
            //激活成功
            existUser.setState(1);
            existUser.setCode(null);
            userService.update(existUser);
            this.addActionMessage("激活成功：请去登录");
        }
        return "msg";
    }
    public String loginPage(){
        return "loginPage";
    }

    /**
     * 用户登录
     * @return
     */
    public String login(){
        UserEntity existUser = userService.login(user);
        //从session中获取验证码
        String codes = ServletActionContext.getRequest().getSession().getAttribute("checkcode").toString();
        //获取页面输入的验证码
        String checkcode = ServletActionContext.getRequest().getParameter("captcha");
        if(!checkcode.equalsIgnoreCase(codes)){
            //验证码错误
            this.addActionError("验证码输入错误");
            return LOGIN;
        }
        if (existUser == null){
            //登录失败
            this.addActionError("登录失败:用户名或密码错误或用户未激活");
            return LOGIN;
        }else{
            //登录成功
            //将用户信息存入到session中
            ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
            return "loginSuccess";
        }
    }

    /**
     * 用户退出
     * @return
     */
    public String quit(){
        //销毁session
        ServletActionContext.getRequest().getSession().invalidate();
        return "quit";
    }
}
