package com.zx.java.designpattern.adapterpattern.player;

import lombok.extern.slf4j.Slf4j;

/**
 * Title: AudioPlayer
 * Description: 音视频播放器（高级）
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 16:18
 */
@Slf4j
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if(audioType.equalsIgnoreCase("mp3")){
            log.info("this is audio player, start...paly "+fileName);
        }
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            log.info("not supported!!!");
        }
    }
}
