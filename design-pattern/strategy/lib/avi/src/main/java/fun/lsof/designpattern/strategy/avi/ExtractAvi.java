package fun.lsof.designpattern.strategy.avi;

import fun.lsof.designpattern.strategy.avi.extractcommon.HandleType;
import fun.lsof.designpattern.strategy.avi.extractcommon.IExtract;

@HandleType("avi")
public class ExtractAvi implements IExtract {

    @Override
    public byte[] getVoice(byte[] file) {
        System.out.printf("avi extract");
        return new byte[0];
    }
}
