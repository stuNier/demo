package com.zx.java.designPattern.adapterPattern.mediaPlayer;

/**
 * Title: VlcPlayer
 * Description: TODO Vlc播放器
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 16:14
 */
public class VlcPlayer implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("this is Vlc player,start...play"+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("this is Vlc player,cannot play Mp4");
    }
}
