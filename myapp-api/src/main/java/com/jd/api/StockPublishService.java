package com.jd.api;

import com.jd.api.domain.dto.StockDto;
import com.jd.api.domain.vo.StockVo;

import java.util.List;

/**
 * Created by zhaogang3 on 2017/7/12.
 */
public interface StockPublishService {

    List<StockDto> queryAllStockScroll(StockVo vo);

}
