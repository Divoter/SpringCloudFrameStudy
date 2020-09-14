package com.divoter.core.constant;

/**
 * @ClassName ProjectConstant
 * @Descripition 项目常量
 * @Authour Divoter
 * @Date 2020/9/2 10:11
 * @Version 1.0
 */
public interface ProjectConstant {

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = "com.divoter.core.Mapper";

    //----------------------网关微服务 代码生成相关 start-------------//
    /**
     * 网关微服务基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String ZUUL_BASE_PACKAGE = "com.divoter.zuul";
    /**
     * 网关微服务生成的Model所在包
     */
    public static final String ZUUL_MODEL_PACKAGE = ZUUL_BASE_PACKAGE + ".model";
    /**
     * 网关微服务生成的Mapper所在包
     */
    public static final String ZUUL_MAPPER_PACKAGE = ZUUL_BASE_PACKAGE + ".dao";
    /**
     * 网关微服务生成的Service所在包
     */
    public static final String ZUUL_SERVICE_PACKAGE = ZUUL_BASE_PACKAGE + ".service";
    /**
     * 网关微服务生成的ServiceImpl所在包
     */
    public static final String ZUUL_SERVICE_IMPL_PACKAGE = ZUUL_SERVICE_PACKAGE + ".impl";
    /**
     * 网关微服务生成的Controller所在包
     */
    public static final String ZUUL_CONTROLLER_PACKAGE = ZUUL_BASE_PACKAGE + ".controller";
    //----------------------网关微服务 代码生成相关 end-------------//

    //----------------------登录微服务 代码生成相关 start-------------//
    /**
     * 登录微服务基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String AUTH_BASE_PACKAGE = "com.divoter.zuul";
    /**
     * 登录微服务生成的Model所在包
     */
    public static final String AUTH_MODEL_PACKAGE = AUTH_BASE_PACKAGE + ".model";
    /**
     * 登录微服务生成的Mapper所在包
     */
    public static final String AUTH_MAPPER_PACKAGE = AUTH_BASE_PACKAGE + ".dao";
    /**
     * 登录微服务生成的Service所在包
     */
    public static final String AUTH_SERVICE_PACKAGE = AUTH_BASE_PACKAGE + ".service";
    /**
     * 登录微服务生成的ServiceImpl所在包
     */
    public static final String AUTH_SERVICE_IMPL_PACKAGE = AUTH_SERVICE_PACKAGE + ".impl";
    /**
     * 登录微服务生成的Controller所在包
     */
    public static final String AUTH_CONTROLLER_PACKAGE = AUTH_BASE_PACKAGE + ".controller";
    //----------------------登录微服务 代码生成相关 end-------------//

    //----------------------鉴权微服务 代码生成相关 start-------------//
    /**
     * 鉴权微服务基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String PERMISSION_BASE_PACKAGE = "com.divoter.permission";
    /**
     * 鉴权微服务生成的Model所在包
     */
    public static final String PERMISSION_MODEL_PACKAGE = PERMISSION_BASE_PACKAGE + ".model";
    /**
     * 鉴权微服务生成的Mapper所在包
     */
    public static final String PERMISSION_MAPPER_PACKAGE = PERMISSION_BASE_PACKAGE + ".dao";
    /**
     * 鉴权微服务生成的Service所在包
     */
    public static final String PERMISSION_SERVICE_PACKAGE = PERMISSION_BASE_PACKAGE + ".service";
    /**
     * 鉴权微服务生成的ServiceImpl所在包
     */
    public static final String PERMISSION_SERVICE_IMPL_PACKAGE = PERMISSION_SERVICE_PACKAGE + ".impl";
    /**
     * 鉴权微服务生成的Controller所在包
     */
    public static final String PERMISSION_CONTROLLER_PACKAGE = PERMISSION_BASE_PACKAGE + ".controller";
     //----------------------鉴权微服务 代码生成相关 end-------------//


    //----------------------微服务1 代码生成相关 start-------------//
    /**
     * 微服务1基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String ADMIN_BASE_PACKAGE = "com.divoter.admin";
    /**
     * 微服务1生成的Model所在包
     */
    public static final String ADMIN_MODEL_PACKAGE = ADMIN_BASE_PACKAGE + ".model";
    /**
     * 微服务1生成的Mapper所在包
     */
    public static final String ADMIN_MAPPER_PACKAGE = ADMIN_BASE_PACKAGE + ".dao";
    /**
     * 微服务1生成的Service所在包
     */
    public static final String ADMIN_SERVICE_PACKAGE = ADMIN_BASE_PACKAGE + ".service";
    /**
     * 微服务1生成的ServiceImpl所在包
     */
    public static final String ADMIN_SERVICE_IMPL_PACKAGE = ADMIN_SERVICE_PACKAGE + ".impl";
    /**
     * 微服务1生成的Controller所在包
     */
    public static final String ADMIN_CONTROLLER_PACKAGE = ADMIN_BASE_PACKAGE + ".controller";
    //----------------------微服务1 代码生成相关 end-------------//


    //----------------------订单服务端 代码生成相关 start-------------//
    /**
     * 微服务1基础包名称 可根据自己公司的项目修改
     *（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    public static final String ORDER_SERVER_BASE_PACKAGE = "com.divoter.orderserver";
    /**
     * 微服务1生成的Model所在包
     */
    public static final String ORDER_SERVER_MODEL_PACKAGE = "com.divoter.core.model";
    /**
     * 微服务1生成的Mapper所在包
     */
    public static final String ORDER_SERVER_MAPPER_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".dao";
    /**
     * 微服务1生成的Service所在包
     */
    public static final String ORDER_SERVER_SERVICE_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".service";
    /**
     * 微服务1生成的ServiceImpl所在包
     */
    public static final String ORDER_SERVER_SERVICE_IMPL_PACKAGE = ORDER_SERVER_SERVICE_PACKAGE + ".impl";
    /**
     * 微服务1生成的Controller所在包
     */
    public static final String ORDER_SERVER_CONTROLLER_PACKAGE = ORDER_SERVER_BASE_PACKAGE + ".controller";
    //----------------------微服务1 代码生成相关 end-------------//








}
