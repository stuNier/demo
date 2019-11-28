package com.zx.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Title: PageController
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/25 17:30
 */
@Controller
public class PageController {

    private Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/page/{page}")
    public ModelAndView toPage(@PathVariable String page, HttpServletRequest request){
        Map<String, String[]> paramsMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramsMap.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        logger.info(request.getParameter("url"));
        return new ModelAndView(page);
    }
}
