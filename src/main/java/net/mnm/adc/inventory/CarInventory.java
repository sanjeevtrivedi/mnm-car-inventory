package net.mnm.adc.inventory;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class CarInventory {

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private Integer stock;

    public CarInventory(@NotNull @NotBlank final String model, @NotNull @NotBlank final Integer stock) {
        this.model = model;
        this.stock = stock;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(@NotNull @NotBlank final String model) {
        this.model = model;
    }

    @NotNull
    public Integer getStock() {
        return stock;
    }

    public void setStock(@NotNull @NotBlank final Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CarInventory that = (CarInventory) o;

        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return stock != null ? stock.equals(that.stock) : that.stock == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        return result;
    }

}
