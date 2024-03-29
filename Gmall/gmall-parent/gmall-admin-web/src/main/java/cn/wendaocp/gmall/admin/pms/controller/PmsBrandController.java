package cn.wendaocp.gmall.admin.pms.controller;

import cn.wendaocp.gmall.admin.pms.vo.PmsBrandParam;
import cn.wendaocp.gmall.pms.service.BrandService;
import cn.wendaocp.gmall.to.CommonResult;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.wendaocp.gmall.admin.pms.vo.PmsBrandParam;
import cn.wendaocp.gmall.pms.entity.Brand;
import cn.wendaocp.gmall.pms.service.BrandService;
import cn.wendaocp.gmall.to.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌功能Controller
 */
@RestController
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {
    @Reference
    private BrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @GetMapping(value = "/listAll")
    public Object getList() {

        //TODO 获取全部品牌列表  brandService.listAll()
        return new CommonResult().success(null);
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping(value = "/create")
    public Object create(@Validated @RequestBody PmsBrandParam pmsBrand, BindingResult result) {
        CommonResult commonResult = new CommonResult();
        //TODO 添加品牌

        return commonResult;
    }

    @ApiOperation(value = "更新品牌")
    @PostMapping(value = "/update/{id}")
    public Object update(@PathVariable("id") Long id,
                              @Validated @RequestBody PmsBrandParam pmsBrandParam,
                              BindingResult result) {
        CommonResult commonResult = new CommonResult();

        //TODO 更新品牌

        return commonResult;
    }

    @ApiOperation(value = "删除品牌")
    @GetMapping(value = "/delete/{id}")
    public Object delete(@PathVariable("id") Long id) {
        CommonResult commonResult = new CommonResult();

        //TODO 删除品牌

        return commonResult;
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @GetMapping(value = "/list")
    public Object getList(@RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult commonResult = new CommonResult();

        //TODO 根据品牌名称分页获取品牌列表


        return commonResult;
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable("id") Long id) {
        CommonResult commonResult = new CommonResult();
        //TODO 根据编号查询品牌信息


        return commonResult;
    }

    @ApiOperation(value = "批量删除品牌")
    @PostMapping(value = "/delete/batch")
    public Object deleteBatch(@RequestParam("ids") List<Long> ids) {
        CommonResult commonResult = new CommonResult();
        //TODO 批量删除品牌


        return commonResult;
    }

    @ApiOperation(value = "批量更新显示状态")
    @PostMapping(value = "/update/showStatus")
    public Object updateShowStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("showStatus") Integer showStatus) {
        CommonResult commonResult = new CommonResult();
        //TODO 批量更新显示状态


        return commonResult;
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @PostMapping(value = "/update/factoryStatus")
    public Object updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("factoryStatus") Integer factoryStatus) {
        CommonResult commonResult = new CommonResult();
        //TODO 批量更新厂家制造商状态


        return commonResult;
    }
}
