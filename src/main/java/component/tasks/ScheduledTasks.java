package component.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import vo.Freessr;
import vo.IShadowx;
import vo.pipeline.FreessrPipeline;
import vo.pipeline.IShadowPipeline;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by zly on 2017/8/2.
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    private static String path = null;

    private static final int sleepTime = 10000;

    //每天记录一次
    //不爬页面
    @Scheduled(fixedRate = 24*3600*1000)
    private void scheduledTask(){


        OOSpider.create(Site.me().setSleepTime(sleepTime), new IShadowPipeline(path), IShadowx.class)
                .addUrl(IShadowx.address)
                .thread(1)
                .run();

        OOSpider.create(Site.me().setSleepTime(sleepTime), new FreessrPipeline(path), Freessr.class)
                .addUrl(Freessr.address)
                .thread(1)
                .run();

    }

    static{
        //放在用户目录下
        path = System.getProperty("user.home")+ File.separator +"ssrSpider" + File.separator;
    }
}
