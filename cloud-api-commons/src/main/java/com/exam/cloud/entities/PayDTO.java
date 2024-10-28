package com.exam.cloud.entities;;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "t_pay")
//@Schema(title = "支付交易表")
public class PayDTO implements Serializable {

    private Integer id;
//    @Schema(title = "支付流水号")
    private String payNo;
//    @Schema(title = "订单流水号")
    private String orderNo;
//    @Schema(title = "用户账户id")
    private Integer userId;
//    @Schema(title = "交易金额")
    private BigDecimal amount;
}
