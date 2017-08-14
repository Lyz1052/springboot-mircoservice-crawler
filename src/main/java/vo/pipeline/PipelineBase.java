package vo.pipeline;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by zly on 2017/8/3.
 */
public class PipelineBase {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-HH");

    public String path;

    File createFile(String path) throws IOException{
        File file = new File(path);

        if(!file.getParentFile().exists()) {
            if(!file.getParentFile().mkdirs()) {
                throw new IOException("创建文件失败");
            }
        }

        return file;
    }
}
