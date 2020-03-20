package com.zx.demo.dao.es;

import com.zx.demo.bean.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Title: StudentRepository
 * Description: StudentRepository
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/3/20 11:16
 */
@Component
public interface StudentRepository extends ElasticsearchRepository<Student, Long> {

    /**
     * @param name name
     * @return
     * @author: zhengxin-3@thunisoft.com
     * date: 20-03-20 11:39
     * @version 1.0
     */
    Student findByName(String name);
}
