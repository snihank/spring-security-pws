package com.company.ShakibKarimU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {
    private int tShirtId;
    @NotEmpty(message = "Please enter the T-shirt's size.")
    private String size;
    @NotEmpty(message = "Please enter the T-shirt's color.")
    private String color;
    @NotEmpty(message = "Please enter the T-shirt's description.")
    private String description;
    @NotNull(message = "Must provide the t-shirt's price.")
    @PositiveOrZero(message = "Price must be 0 and positive")
    @DecimalMax(value = "9999.99", inclusive = true)
    private BigDecimal price;
    @NotNull(message = "Must provide the tshirt quantity.")
    @Positive(message = "Must be positive number")
    private int quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TshirtViewModel that = (TshirtViewModel) o;
        return tShirtId == that.tShirtId &&
                quantity == that.quantity &&
                size.equals(that.size) &&
                color.equals(that.color) &&
                description.equals(that.description) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
