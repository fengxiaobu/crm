package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.Linkman;
import com.crm.service.CustomerService;
import com.crm.service.LinkmanService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * luopa 在 2017/3/3 创建.
 */
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {
    private LinkmanService linkmanService;
    private CustomerService customerService;
    private Linkman linkman=new Linkman();
    private File upfile;
    private String upfileFileName;

    public File getUpfile() {
        return upfile;
    }

    public void setUpfile(File upfile) {
        this.upfile = upfile;
    }

    public String getUpfileFileName() {
        return upfileFileName;
    }

    public void setUpfileFileName(String upfileFileName) {
        this.upfileFileName = upfileFileName;
    }

    @Override
    public Linkman getModel() {
        return linkman;
    }
    public void setLinkmanService(LinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String toAddPage(){
        List<Customer> customerList = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("customerList",customerList);
        return "toAddPage";
    }

    public  String addLinkman() throws IOException {
        if (upfile != null) {
            File file = new File("D:/fileipload/" + upfileFileName);
            FileUtils.copyFile(upfile,file);
        }
        linkmanService.addLinkman(linkman);
        return "addLinkman";
    }

    public String findLinkmanAll(){
        List<Linkman> linkmanList=linkmanService.findLinkmanAll();
        ServletActionContext.getRequest().setAttribute("linkmanList",linkmanList);
        return "findAll";
    }

    public String delLinkman(){
        Integer lkmid=linkman.getLkmId();
        Linkman linkman=linkmanService.findById(lkmid);
        linkmanService.delLnkman(linkman);

        return "dellinkman";
    }



}
