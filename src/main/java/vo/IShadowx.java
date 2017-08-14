package vo;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by zly on 2017/8/3.
 *
 * <h4>IP Address:<span id="ipusa">a.usip.pro</span>  <span class="copybtn" data-clipboard-target="#ipusa"><i class="fa fa-copy"></i></span></h4>
     <h4>Port：443</h4>
     <h4>Password:<span id="pwusa">90075341</span>  <span class="copybtn" data-clipboard-target="#pwusa"><i class="fa fa-copy"></i></span></h4>
     <h4>Method:aes-256-cfb</h4>
 */

@TargetUrl("http://ss.ishadowx.com")
@HelpUrl("http://ss.ishadowx.com")
@ExtractBy(value = "//div[@id='portfolio']//div[@class='row']//div[@class='hover-text']", type = ExtractBy.Type.XPath,multi = true)
public class IShadowx {
    public static final String address = "http://ss.ishadowx.com";

    @ExtractBy(value="//h4[1]/span[1]/text()",notNull = true)
    private String ip;

    @ExtractBy(value="//h4[2]/text()")//regex('(?<=Port[:|：]).+$')
    private String port;

    @ExtractBy(value="//h4[3]/span[1]/text()")
    private String password;

    @ExtractBy(value="//h4[4]/text()")//regex('(?<=Method[:|：]).+$')
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
