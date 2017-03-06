package com.crm.service.serviceimpl;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;
import com.crm.entity.PageBean;
import com.crm.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * luopa 在 2017/3/1 创建.
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findByCid(Integer cid) {
        return customerDao.findByCid(cid);
    }

    @Override
    public void delCustomer(Customer exitCustomer) {
    customerDao.delCustomer(exitCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public PageBean<Customer> pageBean(Integer currentPage) {
        PageBean<Customer> pageBean=new PageBean<Customer>();
        pageBean.setCurrentPage(currentPage);
        Integer pageSize=10;
        pageBean.setPageSize(pageSize);
        Integer totalCount=customerDao.getCount();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
            if(totalCount%pageSize==0){
                totalPage=totalCount/pageSize;
            }else {
                totalPage=totalCount/pageSize+1;
            }
            pageBean.setTotalPage(totalPage);
        Integer begin = (currentPage - 1) * pageSize;
        List<Customer> list=customerDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
