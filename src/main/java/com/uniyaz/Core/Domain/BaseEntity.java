package com.uniyaz.Core.Domain;

import java.io.Serializable;

/**
 * Created by ipekg on 2021
 */
public abstract class BaseEntity implements Serializable {
    public abstract Long getId();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
