package interview_57;

import java.io.Serializable;

/**
 * Created on 2019/3/6.
 *
 * @author DuanJiaNing
 */
public class Product implements Serializable {

    private String id;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
