package com.mycp.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * 绑定配置文件中 以prefix开头的
 *
 * @author lq
 * create 2019-12-19 11:57
 */
@ConfigurationProperties(prefix = "mycp.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    @Override
    public String toString() {
        return "HelloProperties{" +
                "prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }


}
