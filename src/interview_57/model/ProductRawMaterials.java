package interview_57.model;

import java.io.Serializable;

/**
 * Created on 2019/3/6.
 * 产品原材料
 *
 * @author DuanJiaNing
 */
public class ProductRawMaterials implements Serializable {

    private String rawMaterialId;

    private Integer count;

    public ProductRawMaterials() {
    }

    public ProductRawMaterials(String rawMaterialId, Integer count) {
        this.rawMaterialId = rawMaterialId;
        this.count = count;
    }

    public String getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(String rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
