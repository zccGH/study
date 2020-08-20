package com.zcc.study.utils.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.FormattedLogger;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @ClassName P6spyLogger
 * @Description: p6spy 日志实现类
 * @Author chengcheng.zhao01
 * @Date 2020/8/19
 * @Version V1.0
 **/
@Configuration
public class P6spyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String s4) {
        return !"".equals(sql.trim()) ? "[ " + LocalDateTime.now() + " ] --- | took "
                + elapsed + "ms | " + category + " | connection " + connectionId + "\n "
                + sql + ";" : "";
    }
}
