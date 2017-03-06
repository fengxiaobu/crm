package com.crm.dao;

import com.crm.entity.Customer;

import java.util.List;

/**
 * luopa 在 2017/3/1 创建.
 */
public interface CustomerDao {

    void saveCustomer(Customer customer);

    List<Customer> findAll();

    void delCustomer(Customer exitCustomer);

    Customer findByCid(Integer cid);

    void updateCustomer(Customer customer);

    Integer getCount();

    List<Customer> findByPage(Integer begin, Integer pageSize);
}
