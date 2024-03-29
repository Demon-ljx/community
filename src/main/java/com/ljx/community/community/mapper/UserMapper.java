package com.ljx.community.community.mapper;

import com.ljx.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified) values (#{accountID},#{name},#{token},#{gmCreate},#{gmModified})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token")String token);
}
