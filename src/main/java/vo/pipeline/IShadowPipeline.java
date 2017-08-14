package vo.pipeline;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import vo.IShadowx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zly on 2017/8/3.
 */
public class IShadowPipeline extends PipelineBase implements PageModelPipeline<IShadowx>  {

    private static Logger logger = LoggerFactory.getLogger(IShadowPipeline.class);

    public IShadowPipeline(String path) {
        this.path = path;
    }

    @Override
    public void process(IShadowx o, Task task) {
        String path = this.path  + task.getUUID() + File.separator ;
        String fullPath = path + "IShadow-"+dateFormat.format(new Date())+ ".json";
        try {
            o.setPort(o.getPort().replace("Port","").replace(":","").replace("：",""));
            o.setMethod(o.getPort().replace("Method","").replace(":","").replace("：",""));
            String content = JSON.toJSONString(o);

            File file = createFile(fullPath);

            //对IP进行判重
//            BufferedReader reader = new BufferedReader(new FileReader(fullPath));
//            StringBuffer buf = new StringBuffer();
//            String line = null;
//
//            while ((line = reader.readLine()) != null) {
//                buf.append(line);
//            }

            //不对IP进行判重
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            this.logger.warn("write file error", e);
        }
    }
}
