package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.fallback.FootprintApiFallback;
import tech.wetech.weshop.user.po.Footprint;

import java.util.List;

@FeignClient(value = "weshop-user", path = "footprint", fallback = FootprintApiFallback.class)
public interface FootprintApi extends Api<Footprint> {

    @GetMapping("/queryGoodsFootprintByUserId")
    List<GoodsFootprintBO> queryGoodsFootprintByUserId(@RequestParam("id") Integer userId);
}
