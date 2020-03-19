
package com.xmall.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mapper层代码生成
 *
 * @author zhouxufu
 */
public class XmallMapperGenerator {

    public static InputStream getResourceAsStream(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    /**
     * 未来计划
     * 代码生成
     * 1.采用代码进行灵活配置,选择工程进行生成代码
     * 2.生成代码不仅仅是mapper
     *
     * <p>
     * sqlMapGeneratorConfiguration  —> mapper XML 文件
     * javaModelGeneratorConfiguration -> entity (PO)
     * javaClientGeneratorConfiguration -> mapper.java
     * tableConfigurations -> tableConfiguration
     * <p>
     * TableConfiguration
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        String configPath = "userGeneratorConfig.xml";

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        org.mybatis.generator.config.Configuration config =
                cp.parseConfiguration(getResourceAsStream(configPath));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }


}
