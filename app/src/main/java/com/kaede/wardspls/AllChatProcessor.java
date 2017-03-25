package com.kaede.wardspls;

import android.util.Log;

import java.io.File;

import skadistats.clarity.processor.reader.OnMessage;
import skadistats.clarity.processor.runner.Context;
import skadistats.clarity.processor.runner.ControllableRunner;
import skadistats.clarity.source.MappedFileSource;
import skadistats.clarity.source.Source;
import skadistats.clarity.wire.s2.proto.S2UserMessages;

/**
 * Created by Shiro on 3/25/2017.
 */

public class AllChatProcessor {

    public String testrr;

    @OnMessage(S2UserMessages.CUserMessageSayText2.class)
    public void onMessage(Context ctx, S2UserMessages.CUserMessageSayText2 message) {
        testrr = message.getParam1() + ": " + message.getParam2();
        Log.d("WardsPls", message.getParam2() + " ");
    }
    public static void main(String[] args) throws Exception {
        // 1) create an input source from the replay
        Source source = new MappedFileSource(new File("2975960159.dem"));
        // 2) create a simple runner that will read the replay once
        ControllableRunner runner = new ControllableRunner(source);
        // 3) create an instance of your processor
        AllChatProcessor processor = new AllChatProcessor();
        // 4) and hand it over to the runner
        runner.runWith(processor);
    }

    public String msg(){
        return(testrr);
    }
}
