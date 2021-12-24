package com.hitchsavan.supplybase.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class AvailabilityId implements Serializable {
    
    @Column(name = "available_id")
    @Getter @Setter long available_id;

    @Column(name = "product_id")
    @Getter @Setter long product_id;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AvailabilityId)) {
            return false;
        }
        AvailabilityId availabilityId = (AvailabilityId) o;
        return available_id == availabilityId.available_id && product_id == availabilityId.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(available_id, product_id);
    }
}
