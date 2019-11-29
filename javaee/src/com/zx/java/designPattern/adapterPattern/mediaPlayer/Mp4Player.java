package com.zx.java.designPattern.adapterPattern.mediaPlayer;

/**
 * Title: VlcPlayer
 * Description: TODO Mp4播放器
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 16:14
 */
public class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("this is Mp4 player,cannot play Vlc");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("this is Mp4 player, start...paly "+fileName);
    }
}
