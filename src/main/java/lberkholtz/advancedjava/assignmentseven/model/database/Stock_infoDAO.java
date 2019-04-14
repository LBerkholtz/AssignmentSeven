package lberkholtz.advancedjava.assignmentseven.model.database;


import org.hibernate.type.descriptor.java.BigDecimalTypeDescriptor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Models the stock table
 */
@Entity
@Table(name = "stock_info", schema = "", catalog = "stocks")
public class Stock_infoDAO implements DatabaseAccessObject {
    private int id;
    private Timestamp time;
    private BigDecimal price;
    private String symbol;

    public Stock_infoDAO() {
    }

    @Id
    @Column(name = "id",  nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Digits(integer=5, fraction=2)
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock_infoDAO stock_infoDAO = (Stock_infoDAO) o;

        if (id != stock_infoDAO.id) return false;
        if (price != stock_infoDAO.price) return false;
        if (time != null ? !time.equals(stock_infoDAO.time) : stock_infoDAO.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + price.hashCode();
        return result;
    }
}