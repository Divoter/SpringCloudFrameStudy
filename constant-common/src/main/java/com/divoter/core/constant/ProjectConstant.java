package com.divoter.core.constant;

/**
 * @ClassName ProjectConstant
 * @Descripition 项目常量
 * @Authour Divoter
 * @Date 2020/9/2 10:11
 * @Version 1.0
 */
public interface ProjectConstant {

    public static final String BASE_PACKAGE="com.divoter";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE+".core.Mapper";

    /**
     * 微服务生成的Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE+".core.model";


    //----------------------订单服务端 代码生成相关 start-------------//
    /**
     * 微服务基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String ORDER_SERVER_BASE_PACKAGE = BASE_PACKAGE+".orderserver";
    /**
     * 微服务生成的Mapper所在包
     */
    public static final String ORDER_SERVER_MAPPER_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".dao";
    /**
     * 微服务生成的Service所在包
     */
    public static final String ORDER_SERVER_SERVICE_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".service";
    /**
     * 微服务生成的ServiceImpl所在包
     */
    public static final String ORDER_SERVER_SERVICE_IMPL_PACKAGE = ORDER_SERVER_SERVICE_PACKAGE + ".impl";
    /**
     * 微服务生成的Controller所在包
     */
    public static final String ORDER_SERVER_CONTROLLER_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".controller";
    //----------------------订单服务端 代码生成相关 end-------------//

    //----------------------商品服务端 代码生成相关 start-------------//
    /**
     * 微服务基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String PRODUCT_SERVER_BASE_PACKAGE = BASE_PACKAGE+".productserver";
    /**
     * 微服务生成的Mapper所在包
     */
    public static final String PRODUCT_SERVER_MAPPER_PACKAGE = PRODUCT_SERVER_BASE_PACKAGE + ".dao";
    /**
     * 微服务生成的Service所在包
     */
    public static final String PRODUCT_SERVER_SERVICE_PACKAGE = PRODUCT_SERVER_BASE_PACKAGE + ".service";
    /**
     * 微服务生成的ServiceImpl所在包
     */
    public static final String PRODUCT_SERVER_SERVICE_IMPL_PACKAGE = PRODUCT_SERVER_SERVICE_PACKAGE + ".impl";
    /**
     * 微服务生成的Controller所在包
     */
    public static final String PRODUCT_SERVER_CONTROLLER_PACKAGE = PRODUCT_SERVER_BASE_PACKAGE + ".controller";
    //----------------------商品服务端 代码生成相关 end-------------//






}
