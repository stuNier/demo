package com.zx.demo.javaee.io;

import com.zx.demo.util.FileUtils;

/**
 * Title: sql
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin-3@thunisoft.com
 * @version 1.0
 * date 2020/4/10 9:30
 */
public class Test {

    @org.junit.Test
    public void createTables() {
        String[] fileNames = {"fy_file_info.sql","fy_organ.sql","fy_casehandling.sql","fy_copies.sql","fy_respondent.sql","sft_lsxt_xfdb_ryxx.sql","sft_lsxt_xfdb_jgxx.sql","sft_gzfw_jalaw_lawyer_new.sql","sft_gzfw_jalaw_lawyer_business.sql","sft_gzfw_jalaw_lawyer_reward.sql","sft_gzfw_jalaw_lawyer_service.sql","sft_gzfw_jalaw_lawyer_entrust.sql","sft_gzfw_jamed_organization.sql","sft_gzfw_jagls_entrust.sql","sft_gzfw_jalaw_lawfirm_punish.sql","sft_gzfw_jalaw_lawfirm_reward.sql","sft_gzfw_jalaw_lawfirm_service.sql","sft_gzfw_jajudc_judicial_confirm.sql","sft_gzfw_jalaw_lawfirm.sql","sft_gzfw_jagls_staff.sql","sft_gzfw_jagls_service.sql","sft_gzfw_jagls_organization.sql","sft_gzfw_jagls_assessment.sql","sft_gzfw_jaeval_evaluate_item.sql","sft_gzfw_jaeval_evaluate.sql","sft_gzfw_jacst_consulation.sql","sft_gzfw_jacst_consult_login_record.sql","sft_gzfw_jaauth_staff.sql","sft_gzfw_jaauth_organization.sql","sft_gzfw_jaauth_business.sql","sft_gzfw_jaaid_staff.sql","sft_gzfw_jaaid_organization.sql","sft_gzfw_jaaid_apply.sql","sft_gzfw_jamed_apply.sql","sft_gzfw_lgav_tm_adviser.sql","sft_gzfw_lgav_cs_reply.sql","sft_gzfw_lgav_cs_legal.sql","sft_gzfw_jawko_work_order_log.sql","sft_gzfw_jawko_work_order.sql","sft_gzfw_japub_video.sql","sft_gzfw_japub_handle.sql","sft_gzfw_japub_activity.sql","sft_gzfw_janota_staff.sql","sft_gzfw_janota_organization.sql","sft_gzfw_janota_business.sql","sft_gzfw_janews_news.sql","sft_gzfw_jalaw_lawyer_punish.sql","sft_gzfw_jalaw_lawfirm_business.sql","sft_gzfw_jamed_staff_new.sql","sft_gzfw_lgav_cs_replyask.sql"};
        StringBuilder filePath = new StringBuilder("C:\\Users\\lenovo\\Desktop\\b北京华宇\\06_贵州大数据\\04数据\\现场表结构\\");
        StringBuilder result = new StringBuilder();
        for(String name : fileNames){
            filePath.append(name);
            result.append("-- ");
            result.append(name);
            result.append("\n");
            result.append(FileUtils.readFile(filePath.toString()));
            filePath.delete(filePath.indexOf(name),filePath.length());
        }
        System.out.println(result.toString());
    }

    /**
     * <!-- 人民调解案件 -->
     * <table>
     *         <source_table>t_rmtj_aj.sql</source_table>
     *         <target_table>db_ggflfw.t_rmtj_aj</target_table>
     *         <truncate>1</truncate>
     *         <compute>0</compute>
     * </table>
     */
    @org.junit.Test
    public void createSqlFile(){
        String[] fileNames = {"fy_file_info","fy_organ","fy_casehandling","fy_copies","fy_respondent","sft_lsxt_xfdb_ryxx","sft_lsxt_xfdb_jgxx","sft_gzfw_jalaw_lawyer_new","sft_gzfw_jalaw_lawyer_business","sft_gzfw_jalaw_lawyer_reward","sft_gzfw_jalaw_lawyer_service","sft_gzfw_jalaw_lawyer_entrust","sft_gzfw_jamed_organization","sft_gzfw_jagls_entrust","sft_gzfw_jalaw_lawfirm_punish","sft_gzfw_jalaw_lawfirm_reward","sft_gzfw_jalaw_lawfirm_service","sft_gzfw_jajudc_judicial_confirm","sft_gzfw_jalaw_lawfirm","sft_gzfw_jagls_staff","sft_gzfw_jagls_service","sft_gzfw_jagls_organization","sft_gzfw_jagls_assessment","sft_gzfw_jaeval_evaluate_item","sft_gzfw_jaeval_evaluate","sft_gzfw_jacst_consulation","sft_gzfw_jacst_consult_login_record","sft_gzfw_jaauth_staff","sft_gzfw_jaauth_organization","sft_gzfw_jaauth_business","sft_gzfw_jaaid_staff","sft_gzfw_jaaid_organization","sft_gzfw_jaaid_apply","sft_gzfw_jamed_apply","sft_gzfw_lgav_tm_adviser","sft_gzfw_lgav_cs_reply","sft_gzfw_lgav_cs_legal","sft_gzfw_jawko_work_order_log","sft_gzfw_jawko_work_order","sft_gzfw_japub_video","sft_gzfw_japub_handle","sft_gzfw_japub_activity","sft_gzfw_janota_staff","sft_gzfw_janota_organization","sft_gzfw_janota_business","sft_gzfw_janews_news","sft_gzfw_jalaw_lawyer_punish","sft_gzfw_jalaw_lawfirm_business","sft_gzfw_jamed_staff_new","sft_gzfw_lgav_cs_replyask"};
        StringBuilder filePath = new StringBuilder("C:\\Users\\lenovo\\Desktop\\b北京华宇\\06_贵州大数据\\04数据\\跑数\\gzdsj_zryssjcq\\import\\sql\\");
        StringBuilder sqlStr = new StringBuilder("select * from database_1395_kamsum.");
        StringBuilder importStr = new StringBuilder();
        for(String name : fileNames){
            importStr.append("\t<table>\n\t\t<source_table>");
            importStr.append(name);
            importStr.append(".sql</source_table>\n\t\t<target_table>database_1395_kamsum.");
            importStr.append(name);
            importStr.append("</target_table>\n\t\t<truncate>1</truncate>\n\t\t<compute>0</compute>\n\t</table>\n");

            sqlStr.append(name);
            filePath.append(name);
            filePath.append(".sql");
            /*//写文件
            FileUtils.write(filePath.toString(), sqlStr.toString());*/
            filePath.delete(filePath.indexOf(name),filePath.length());
            sqlStr.delete(sqlStr.indexOf(name),sqlStr.length());
        }
        System.out.println(importStr.toString());
    }

}
