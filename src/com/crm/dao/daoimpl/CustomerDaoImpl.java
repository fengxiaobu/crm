package com.crm.dao.daoimpl;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * luopa 在 2017/3/1 创建.
 */
public class CustomerDaoImpl implements CustomerDao {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void saveCustomer(Customer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = (List<Customer>) hibernateTemplate.find("from Customer");
        return customerList;
    }

    @Override
    public void delCustomer(Customer exitCustomer) {

        hibernateTemplate.delete(exitCustomer);
    }

    @Override
    public Customer findByCid(Integer cid) {
        return hibernateTemplate.get(Customer.class, cid);
    }

    @Override
    public void updateCustomer(Customer customer) {
        hibernateTemplate.saveOrUpdate(customer);
    }

    @Override
    public Integer getCount() {
        List<Object> list = (List<Object>) hibernateTemplate.find("select count(*) from Customer");
            if(list!=null&&list.size()!=0){
                Object obj = list.get(0);
                Long l=(Long) obj;
                Integer count=l.intValue();
                return count;
            }
        return null;
    }

    @Override
    public List<Customer> findByPage(Integer begin, Integer pageSize) {
        //离线对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria, begin, pageSize);
        return list;
    }
}
