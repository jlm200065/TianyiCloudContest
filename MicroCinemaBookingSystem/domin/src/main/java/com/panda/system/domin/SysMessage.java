package com.panda.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysMessage implements Serializable {
    private final static Long serialVersionUID = 1L;
    //消息id
    private Long messageId;

    //发送用户的id
    private Long fromId;

    //接收用户的id
    private Long toId;

    private String content;

    private Date createTime;

    private int haveSeen;


}
