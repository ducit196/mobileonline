package core.dto.model.order;

import java.util.Date;

public class Coupon {
    private int id;
    private String code;
    private float sale;
    private Date startDate;
    private Date endDate;

    public Coupon() {
    }

    public Coupon(int id, String code, float sale, Date startDate, Date endDate) {
        this.id = id;
        this.code = code;
        this.sale = sale;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
