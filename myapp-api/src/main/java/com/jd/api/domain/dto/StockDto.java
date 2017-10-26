package com.jd.api.domain.dto;

/**
 * Created by zhaogang3 on 2017/7/12.
 */
public class StockDto {
    private String skuId;
    private String stockQty;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getStockQty() {
        return stockQty;
    }

    public void setStockQty(String stockQty) {
        this.stockQty = stockQty;
    }
}
