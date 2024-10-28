package com.exam.cloud.apis;

import com.exam.cloud.resp.ResultCodeEnum;
import com.exam.cloud.resp.ResultData;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi{
    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.error(ResultCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
