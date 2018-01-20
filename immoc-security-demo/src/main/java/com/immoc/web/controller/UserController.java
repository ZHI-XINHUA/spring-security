package com.immoc.web.controller;

import com.immoc.dto.User;
import com.immoc.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhixinhua on 18/1/21.
 */
@RestController
public class UserController {

    /**
     * 查询用户
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(page = 1,size = 10,sort = "username,asc") Pageable pageable){

        //打印查询对象
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        //打印分页信息
        System.out.println("page="+pageable.getPageNumber()+" size="+pageable.getPageSize()+" sort="+pageable.getSort());
        List<User> users = new ArrayList<User>();
        users.add(new User());
        users.add(new User());
        return users;
    }
}
