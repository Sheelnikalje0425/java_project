package com.erp.businessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.businessmanagement.entity.order;

public interface OrderRepository extends JpaRepository<order, Integer>{

}

