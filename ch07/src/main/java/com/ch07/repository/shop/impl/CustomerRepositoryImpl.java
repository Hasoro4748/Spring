package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerRepository 확장 인터페이스 구현 클래스
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    // Q도메인 클래스 선언
    private QCustomer qCustomer = QCustomer.customer;


    @Override
    public List<Customer> selectCustomers() {
        return queryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(String custId) {
        return queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {
        BooleanBuilder builder = new BooleanBuilder();
        if(nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }
        if(ageCondition > 0) {
            builder.and(qCustomer.age.goe(ageCondition)); // greater than or equal
        }

        return queryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {
        //동적 쿼리 Expression 생성
        BooleanExpression express = qCustomer.name
                .containsIgnoreCase(keyword)
                .or(qCustomer.addr.containsIgnoreCase(keyword));


        return queryFactory
                .selectFrom(qCustomer)
                .where(express)
                .fetch();
    }
}
