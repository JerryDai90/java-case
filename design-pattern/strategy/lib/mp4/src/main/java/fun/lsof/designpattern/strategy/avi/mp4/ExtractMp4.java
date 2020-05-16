package fun.lsof.designpattern.strategy.avi.mp4;

import fun.lsof.designpattern.strategy.avi.extractcommon.HandleType;
import fun.lsof.designpattern.strategy.avi.extractcommon.IExtract;


@HandleType("mp4")
public class ExtractMp4 implements IExtract {

    public byte[] getVoice(byte[] file) {
        System.out.printf("mp4 extract");
        return new byte[0];
    }
}
