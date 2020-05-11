package fun.lsof.designpattern.strategy.avi.extractvoice;

import fun.lsof.designpattern.strategy.avi.extractcommon.IExtract;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Main {

    @BeforeClass
    public static void load() {
       Driver.init();
    }

    @Test
    public void testMp4() {

        IExtract mp4 = Driver.get("mp4");
        mp4.getVoice(null);
    }

    @Test
    public void testAvi() {

        IExtract mp4 = Driver.get("avi");
        mp4.getVoice(null);
    }

}
