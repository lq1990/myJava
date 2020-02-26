package cn.wendaocp.gmall.pms.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * SpringBoot引入某个场景，这个场景的组件就会自动配置好。
 *
 * @author lq
 * @since 2020-02-25 11:51
 */
@Configuration // 这是一个配置类
public class PmsDataSourceConfig {

    /**
     * 自定义配置数据源
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        File file = ResourceUtils.getFile("classpath:sharding-jdbc.yml");

        DataSource ds = MasterSlaveDataSourceFactory.createDataSource(file);

        return ds;
    }

}
