package com.zx.java.designpattern.adapterpattern.player;

import com.zx.java.designpattern.adapterpattern.mediaplayer.AdvanceMediaPlayer;
import com.zx.java.designpattern.adapterpattern.mediaplayer.Mp4Player;
import com.zx.java.designpattern.adapterpattern.mediaplayer.VlcPlayer;

/**
 * Title: MediaAdapter
 * Description: TODO 媒体适配器（视频）
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 16:18
 */
public class MediaAdapter implements MediaPlayer {

    private AdvanceMediaPlayer advanceMediaPlayer;

    MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advanceMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
