package com.fmg.cart;

/**
 * @author fmg
 * @version 1.0.0
 * @className Sku
 * @description TODO
 * @date 2019-12-13 22:16
 **/
public class Sku {

    private Integer skuId;
    private String skuName;
    private Double skuPrice;
    private Integer skuTotalNum;
    private Double skuTotalPrice;
    private Enum skuCategory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer skuTotalNum, Double skuTotalPrice, Enum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.skuTotalNum = skuTotalNum;
        this.skuTotalPrice = skuTotalPrice;
        this.skuCategory = skuCategory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public Integer getSkuTotalNum() {
        return skuTotalNum;
    }

    public Double getSkuTotalPrice() {
        return skuTotalPrice;
    }

    public Enum getSkuCategory() {
        return skuCategory;
    }
}
