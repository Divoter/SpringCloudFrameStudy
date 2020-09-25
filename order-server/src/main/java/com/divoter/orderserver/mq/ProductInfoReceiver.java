package com.divoter.orderserver.mq;

import com.divoter.productserver.model.ProductInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProductInfoReceiver
 * @Description
 * @Authour Divoter
 * @Date 2020/9/25 14:24
 * @Version 1.0
 */
@Component
public class ProductInfoReceiver {
    private static final Logger logger = LoggerFactory.getLogger(ProductInfoReceiver.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        try {
            List<ProductInfo> productInfoList = new ObjectMapper().readValue(message,new TypeReference<List<ProductInfo>>(){});
            logger.info("从队列{}接收到商品服务消息：{}","productInfo",productInfoList);
            for (ProductInfo productInfo : productInfoList) {
                //存储到redis
                stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfo.getProductId()),String.valueOf(productInfo.getProductStock()));
            }
        } catch (JsonProcessingException e) {
            logger.info("从队列{}接收到商品服务消息：{},由于参数异常，数据存储redis失败","productInfo",message);

        }



    }
}
