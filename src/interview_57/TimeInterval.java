package interview_57;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2019/3/6.
 * 时间区间
 *
 * @author DuanJiaNing
 */
public class TimeInterval implements Serializable {

    private Date startTime;

    private Date endTime;

    public TimeInterval() {
    }

    public TimeInterval(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
