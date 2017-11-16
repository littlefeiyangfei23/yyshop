package com.yf.yyshop.service;

import com.yf.yyshop.pojo.po.YyUser;
import org.springframework.stereotype.Service;


public interface UserService {
    YyUser findByUsername(YyUser yyUser);
}
