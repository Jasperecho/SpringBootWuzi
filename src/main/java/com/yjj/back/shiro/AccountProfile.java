package com.yjj.back.shiro;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

}
