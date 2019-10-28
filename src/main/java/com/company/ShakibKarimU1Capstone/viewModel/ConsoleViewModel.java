package com.company.ShakibKarimU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    private int consoleId;
    @NotEmpty(message = "Must provide the console's model.")
    private String model;
    @NotEmpty(message = "Must provide the console's manufacturer.")
    private String manufacturer;
    @NotEmpty(message = "Must provide the console's memory amount.")
    private String memoryAmount;
    @NotEmpty(message = "Must provide the console's processor.")
    private String processor;
    @NotNull(message = "Must provide the console's price.")
    @PositiveOrZero(message = "Price must be 0 and positive")
    @DecimalMax(value = "9999.99", inclusive = true)
    private BigDecimal price;
    @Positive(message = "Must be positive number")
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return consoleId == that.consoleId &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                memoryAmount.equals(that.memoryAmount) &&
                processor.equals(that.processor) &&
                price.equals(that.price) &&
                quantity == that.quantity ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
