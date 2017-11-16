package com.yf.yyshop.service.impl;

import com.yf.yyshop.dao.YyUserMapper;
import com.yf.yyshop.pojo.po.YyUser;
import com.yf.yyshop.pojo.po.YyUserExample;
import com.yf.yyshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private YyUserMapper yyUserDao;

    @Override
    public YyUser findByUsername(YyUser yyUser) {
        YyUser yyUser1=null;
        try{
            YyUserExample example=new YyUserExample();
            YyUserExample.Criteria criteria=example.createCriteria();
            criteria.andUsernameEqualTo(yyUser.getUsername());
            //执行查询
            List<YyUser> list = yyUserDao.selectByExample(example);

            if (list!=null && list.size()>0){
                yyUser1=list.get(0);

            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return yyUser1;
    }
}
