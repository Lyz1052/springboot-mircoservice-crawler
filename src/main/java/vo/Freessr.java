package vo;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by zly on 2017/8/3.
 * <div class="col-md-6 text-center" style="height: 223px;">
 <h4>服务器地址:s1.x3x.bid</h4>
 <h4>端口:1025</h4>
 <h4>密码:helloworld</h4>
 <h4>加密方式:aes-256-cfb</h4>
 <h4>状态:<font color="green">正常(7.26更新)</font></h4>
 <h4 class="show-qr"><button>点击生成二维码</button></h4>
 <h4><font color="#7266BA">注意：不定期更新账号</font></h4>
 </div>
 */
@TargetUrl("https://freessr.xyz/")
@HelpUrl("https://freessr.xyz/")

@ExtractBy(value="//div[@class='row']/div",multi = true)
public class Freessr {
    public static final String address = "https://freessr.xyz/";

    @ExtractBy(value = "//h4[1]/text()",notNull = true)
    private String ip;

    @ExtractBy("//h4[2]/text()")
    private String port;

    @ExtractBy("//h4[3]/text()")
    private String password;

    @ExtractBy("//h4[4]/text()")
    private String method;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
