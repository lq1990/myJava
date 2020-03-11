package cn.wendaocp.gmall.admin.pms.vo;


import cn.wendaocp.gmall.pms.entity.ProductCategory;
import cn.wendaocp.gmall.pms.entity.ProductCategory;
import lombok.Data;

import java.util.List;

/**
 */
@Data
public class PmsProductCategoryWithChildrenItem extends ProductCategory {
    private List<ProductCategory> children;

}
