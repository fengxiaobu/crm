package com.crm.service;

import com.crm.entity.Customer;
import com.crm.entity.PageBean;

import java.util.List;

/**
 * luopa 在 2017/3/1 创建.
 */
public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> findAll();

    Customer findByCid(Integer cid);

    void delCustomer(Customer exitCustomer);

    void updateCustomer(Customer customer);

    PageBean<Customer> pageBean(Integer currentPage);
}
