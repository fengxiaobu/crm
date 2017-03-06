package com.crm.action;

import com.crm.entity.User;
import com.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * luopa 在 2017/2/28 创建.
 */
public class UserAction extends ActionSupport {
    private String username;
    private String password;
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User exitUser = userService.login(user);
        if (exitUser != null) {
            ActionContext context = ActionContext.getContext();
            Map<String, Object> session = context.getSession();
            session.put("exitUser", exitUser);
            return "Log_in_by";
        } else {
            return "Login_failed";
        }
    }
}
