package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.PageBean;
import com.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * luopa 在 2017/3/1 创建.
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private CustomerService customerService;
    private Customer customer = new Customer();
    private List<Customer> list;
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    跳转到添加页面
    public String toAddPage() {
        return "toAddPage";
    }

    //    添加客户
    public String saveCustomer() {
        if (customer != null) {
            customerService.saveCustomer(customer);
            return "saveCustomer";
        }
        return "error";

    }

    //查找所有客户信息
    public String findAll() {
        list = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("list", list);
        return "list";
    }

    //删除客户信息
    public String delCustomer() {
        Integer cid = customer.getCid();
        Customer exitCustomer = customerService.findByCid(cid);
        customerService.delCustomer(exitCustomer);
        return "delCustomer";
    }

    //显示详情信息
    public String showCustomer() {
        Integer cid = customer.getCid();
        Customer exitCustomer = customerService.findByCid(cid);
        ServletActionContext.getRequest().setAttribute("customer", exitCustomer);
        return "showCustomer";
    }

    //修改客户信息
    public String updateCustomer() {
        if (customer != null) {
            customerService.updateCustomer(customer);
            return "updateCustomer";
        }
        return "error";
    }

    //分页显示
    public String pageCustomer() {
        PageBean<Customer> pageBean = customerService.pageBean(currentPage);
        ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
        return "pagelist";
    }

}
