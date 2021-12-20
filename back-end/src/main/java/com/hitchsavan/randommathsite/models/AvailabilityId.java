package com.hitchsavan.randommathsite.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
public class AvailabilityId implements Serializable {
    
    @Column(name = "product_id")
    @Getter private long productId;
    
    @Column(name = "shop_id")
    @Getter private long shopId;

    public AvailabilityId() {}

    public AvailabilityId(long productId, long shopId) {
        this.productId = productId;
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvailabilityId)) return false;
        AvailabilityId that = (AvailabilityId) o;
        return Objects.equals(getProductId(), that.getProductId()) &&
                Objects.equals(getShopId(), that.getShopId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getShopId());
    }
}
