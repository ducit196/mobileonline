package core.dao.order;

import core.dto.model.order.OrderDetail;

public interface OrderDetailDao {
    void insert(int orderId, OrderDetail orderDetail);
}
