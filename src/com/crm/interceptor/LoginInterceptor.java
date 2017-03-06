package com.crm.interceptor;

import com.crm.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * luopa 在 2017/3/1 创建.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object userAction = ActionContext.getContext().getSession().get("exitUser");
        System.out.println((User)userAction);
        if (userAction == null) {
            return "Login_failed";
        }
        return actionInvocation.invoke();
    }
}
