package interview_57.model;

import java.util.List;

/**
 * Created on 2019/3/6.
 * A 类产品
 *
 * @author DuanJiaNing
 */
public class ProductA extends Product {

    private List<ProductRawMaterials> productRawMaterials;

    public ProductA() {
    }

    public ProductA(String id, List<ProductRawMaterials> productRawMaterials) {
        super(id);
        this.productRawMaterials = productRawMaterials;
    }

    public List<ProductRawMaterials> getProductRawMaterials() {
        return productRawMaterials;
    }

    public void setProductRawMaterials(List<ProductRawMaterials> productRawMaterials) {
        this.productRawMaterials = productRawMaterials;
    }
}
