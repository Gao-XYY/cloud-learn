package com.gao.springcloud.controller;


import com.gao.springcloud.entites.CommonResult;
import com.gao.springcloud.entites.Payment;
import com.gao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("********插入结果: " + result);
        if (result > 0){
            return new CommonResult(200, "插入数据库成功", result);
        }else {
            return new CommonResult(444, "插入数据库失败" , null);
        }


    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("********插入结果: " + payment);
        if (payment != null){
            return new CommonResult(200, "查询成功", payment);
        }else {
            return new CommonResult(444, "没有对应记录，查询ID: " + id, null);
        }


    }

}