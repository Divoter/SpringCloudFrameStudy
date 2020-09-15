package com.divoter.orderserver.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @Column(name = "detail_id")
    private String detailId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "product_id")
    private String productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 当前价格,单位分
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return detail_id
     */
    public String getDetailId() {
        return detailId;
    }

    /**
     * @param detailId
     */
    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return product_id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取当前价格,单位分
     *
     * @return product_price - 当前价格,单位分
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置当前价格,单位分
     *
     * @param productPrice 当前价格,单位分
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取数量
     *
     * @return product_quantity - 数量
     */
    public Integer getProductQuantity() {
        return productQuantity;
    }

    /**
     * 设置数量
     *
     * @param productQuantity 数量
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * 获取小图
     *
     * @return product_icon - 小图
     */
    public String getProductIcon() {
        return productIcon;
    }

    /**
     * 设置小图
     *
     * @param productIcon 小图
     */
    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}