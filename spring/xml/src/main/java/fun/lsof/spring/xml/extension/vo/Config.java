package fun.lsof.spring.xml.extension.vo;

public class Config {

    String ip;
    String port;
    String path;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Config{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
