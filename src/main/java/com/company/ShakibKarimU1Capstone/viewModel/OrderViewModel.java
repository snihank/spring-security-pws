package com.company.ShakibKarimU1Capstone.viewModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class OrderViewModel {

    private int invoiceId;
    @NotEmpty(message = "Please enter customer name.")
    private String name;
    @NotEmpty(message = "Please enter customer street.")
    private String street;
    @NotEmpty(message = "Please enter customer city.")
    private String city;
    @NotEmpty(message = "Please enter customer state.")
    @Size(max = 2, message = "State must be 2 characters")
    private String state;
    @NotEmpty(message = "Please enter customer zip code.")
    private String zipCode;
    @NotEmpty(message = "Please enter invoice item type.")
    private String itemType;
    @NotNull(message = "Please enter item id.")
    @Min(value = 0, message = "ID cannot be negative.")
    private int itemId;
    @NotNull(message = "Please enter item's unit price")
    @Min(value = 0, message = "Quantity cannot be negative.")
    private int quantity;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
        OrderViewModel that = (OrderViewModel) o;
        return invoiceId == that.invoiceId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipCode.equals(that.zipCode) &&
                itemType.equals(that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipCode, itemType, itemId, quantity);
    }
}
