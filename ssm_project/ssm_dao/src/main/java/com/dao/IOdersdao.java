package com.dao;

import com.domain.Member;
import com.domain.Orders;
import com.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IOdersdao {
    @Select("select *from orders")
    @Results({
            //column为数据库字段名，porperty为实体类属性名
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one= @One(select="com.dao.IProductdao.findById"))

    })
    List<Orders> findAll(int page,int size);

    //多表操作
    @Select("select *from orders where id=#{ordersId}")
    @Results({
            //column为数据库字段名，porperty为实体类属性名
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one= @One(select="com.dao.IProductdao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.dao.IMemberdao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.dao.ITravellerdao.findByOrderId"))

    })
    Orders findById(String ordersId);
}
