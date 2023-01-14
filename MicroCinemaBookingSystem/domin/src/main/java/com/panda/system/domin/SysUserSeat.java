package com.panda.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysUserSeat implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;

    private Integer seatRow;

    private Integer seatCol;

    private Long userId;

    private Long sessionId;


}
