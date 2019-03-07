package interview_57.model;

import java.io.Serializable;

/**
 * Created on 2019/3/6.
 * 供应时间、数量信息
 *
 * @author DuanJiaNing
 */
public class SupplyTimeIntervalAndQTY implements Serializable {

    private TimeInterval timeInterval;

    private Integer count;

    private String productId;

    public SupplyTimeIntervalAndQTY() {
    }

    public SupplyTimeIntervalAndQTY(String productId, TimeInterval timeInterval, Integer count) {
        this.timeInterval = timeInterval;
        this.productId = productId;
        this.count = count;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "SupplyTimeIntervalAndQTY{" +
                "timeInterval=" + timeInterval +
                ", count=" + count +
                ", productId='" + productId + '\'' +
                '}';
    }
}
