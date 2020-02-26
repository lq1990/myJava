package cn.wendaocp.gmall.pms;

import cn.wendaocp.gmall.pms.entity.Brand;
import cn.wendaocp.gmall.pms.entity.Product;
import cn.wendaocp.gmall.pms.service.BrandService;
import cn.wendaocp.gmall.pms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.pkcs11.Secmod;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
//        Product p = productService.getById(1);
//
//        System.out.println(p.getName());
//        System.out.println(p.getBrandName());

        // 测试
        // 增删改在主库，查 在从库
        // 如果主库里有添加，则就成功了。因为若是在从库中增，主库不会从从库里复制。
        Brand brand = new Brand();
        brand.setName("文刀");
        brandService.save(brand);
        System.out.println("保存成功");

        log.debug("");

        // 查询。为了测试，可以认为把从库里的某条记录修改，使得和主不同
        Brand bd = brandService.getById(53);
        System.out.println(bd.getName()); // 从库中查找



    }
}

