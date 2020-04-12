package com.zx.java.designpattern.adapterpattern.mediaplayer;

/**
 * Title: AdvanceMediaPlayer
 * Description: TODO 媒体播放器
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 16:13
 */
public interface AdvanceMediaPlayer {

    void playVlc(String fileName);

    void playMp4(String fileName);
}
