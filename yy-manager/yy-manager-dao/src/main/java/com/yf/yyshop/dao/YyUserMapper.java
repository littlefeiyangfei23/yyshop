package com.yf.yyshop.dao;

import com.yf.yyshop.pojo.po.YyUser;
import com.yf.yyshop.pojo.po.YyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YyUserMapper {
    int countByExample(YyUserExample example);

    int deleteByExample(YyUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YyUser record);

    int insertSelective(YyUser record);

    List<YyUser> selectByExample(YyUserExample example);

    YyUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YyUser record, @Param("example") YyUserExample example);

    int updateByExample(@Param("record") YyUser record, @Param("example") YyUserExample example);

    int updateByPrimaryKeySelective(YyUser record);

    int updateByPrimaryKey(YyUser record);
}