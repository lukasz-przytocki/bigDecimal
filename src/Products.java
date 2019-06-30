import java.math.BigDecimal;

public class Products {
    private String name;
    private BigDecimal netPrice;
    private BigDecimal vatRate;

    public Products(String name, BigDecimal netPrice, BigDecimal vatRate) {
        this.name = name;
        this.netPrice = netPrice;
        this.vatRate = vatRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }



}
