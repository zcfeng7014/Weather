package com.zcfeng.weather.speech;

import android.content.Context;
import android.widget.Toast;

import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class SpeechManager  {
    private SpeechSynthesizer mSpeechSynthesizer;
    Context content;
    private  static  SpeechManager speechmanager =null;
    public static SpeechManager newInstance(Context context){
        if(speechmanager==null){
            synchronized (SpeechManager.class){
                if(speechmanager==null){
                    speechmanager=new SpeechManager(context);
                }
            }
        }
        return speechmanager;
    }
    private SpeechManager(Context content){
        this.content=content;
        mSpeechSynthesizer = SpeechSynthesizer.getInstance();
        mSpeechSynthesizer.setContext(content);
        mSpeechSynthesizer.setSpeechSynthesizerListener(new SpeechSynthesizerListener() {
            @Override
            public void onSynthesizeStart(String s) {

            }

            @Override
            public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {

            }

            @Override
            public void onSynthesizeFinish(String s) {

            }

            @Override
            public void onSpeechStart(String s) {

            }

            @Override
            public void onSpeechProgressChanged(String s, int i) {

            }

            @Override
            public void onSpeechFinish(String s) {

            }

            @Override
            public void onError(String s, SpeechError speechError) {

            }
        });
        mSpeechSynthesizer.setApiKey("flMcsi1Te3F9ra2X6jknLC0P", "MmEcG4Id6szR5HHgWlkkzrwYlZ8tLLLX");
        mSpeechSynthesizer.setAppId("10049858");
        AuthInfo authInfo = mSpeechSynthesizer.auth(TtsMode.ONLINE);
        if (authInfo.isSuccess()) {
            mSpeechSynthesizer.initTts(TtsMode.ONLINE);

        } else {

            Toast.makeText(content,"授权失败",Toast.LENGTH_SHORT).show();
        }
    }
    public void speak(String text) {
        int result = this.mSpeechSynthesizer.speak(text);
        if (result < 0) {
            System.out.println("error,please look up error code in doc or URL:http://yuyin.baidu.com/docs/tts/122 ");
        }
    }
}
