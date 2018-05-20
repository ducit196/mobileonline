package core.dto.model.order;

import core.dto.model.customer.Customer;
import core.dto.model.shipping.Shipping;
import core.dto.model.tax.Tax;

import java.util.Date;
import java.util.List;

/**
 * @author DucBa
 *
 */
public class Order {
    private int id;
    private Date dateOrderd;
    private int paymentType;
    private int status;
    List<OrderDetail> listOrderDetail;
    private Coupon coupon;
    private Shipping shipping;
    private Customer customer;
    private Tax tax;

    public Order() {
    }

    public Order(int id, Date dateOrderd, int paymentType, int status, Coupon coupon,
                 Shipping shipping, Customer customer, Tax tax) {
        this.id = id;
        this.dateOrderd = dateOrderd;
        this.paymentType = paymentType;
        this.status = status;
        this.coupon = coupon;
        this.shipping = shipping;
        this.customer = customer;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOrderd() {
        return dateOrderd;
    }

    public void setDateOrderd(Date dateOrderd) {
        this.dateOrderd = dateOrderd;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }
}
