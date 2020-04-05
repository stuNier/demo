package com.zx.demo.dao.es;

import com.zx.demo.bean.es.Star;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Title: StarRepository
 * Description: StarRepository
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/20 11:16
 */
@Component
public interface StarRepository extends ElasticsearchRepository<Star, Long> {

}
