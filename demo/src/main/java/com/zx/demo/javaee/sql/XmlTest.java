package com.zx.demo.javaee.sql;

import org.junit.Test;

/**
 * Title: XmlTest
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/29 10:47
 */
public class XmlTest {

    private static String[] fields = {"c_bh","c_login","c_sjhm","c_wxid","c_qqid","c_password","c_email","c_sfzhm","c_zt","c_name","c_sex","d_csrq","c_tx","c_mz","c_xl","c_zy","c_zzmm","c_hyzk","c_lxdz","c_grjj","c_byyx","d_sccjgzrq","c_lxdh","c_sfzy","c_ssdw","c_zhjglx","dt_cjsj","dt_gxsj","c_cjjg","c_cjdw","c_zjdljgid","c_zjdljglx","c_mcpy","c_register","c_xw","n_nl"};

    private static String tableName = "db_uim.t_uim_user";

    @Test
    public void printSelect(){
        StringBuilder sb = new StringBuilder("\t  SELECT \n");
        for(String field : fields){
            sb.append("\t  ")
                    .append(field)
                    .append(",\n");
        }
        sb.delete(sb.length()-",\n".length(), sb.length());
        sb.append("\n\t  FROM ")
                .append(tableName);
        System.out.println(sb.toString());
    }

    @Test
    public void printValue(){
        StringBuilder sb = new StringBuilder();
        for(String field : fields){
            sb.append("\t  <value>")
                    .append(field)
                    .append("</value>\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void printValueName(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t  <key>\n\t\t<name>")
                .append(fields[0])
                .append("</name>\n\t\t<field>")
                .append(fields[0])
                .append("</field>\n\t\t<condition>=</condition>\n\t\t<name2/>\n\t  </key>\n");
        for(String field : fields){
            sb.append("\t  <value>\n\t\t<name>")
                    .append(field)
                    .append("</name>\n\t\t<rename>")
                    .append(field)
                    .append("</rename>\n\t\t<update>Y</update>\n\t  </value>\n");
        }
        System. out.println(sb.toString());
    }
}
