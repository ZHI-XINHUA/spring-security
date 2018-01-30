package social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import social.qq.aip.QQ;
import social.qq.aip.QQImpl;

/**
 * Created by zhixinhua on 18/1/29.
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    //获取Authorization Code,引导用户登录授权页面
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    //通过Authorization Code获取Access Token，用户确认后获取授权码
    private static final String URL_ACCESS_TOKEN="https://graph.qq.com/oauth2.0/token";



    public QQServiceProvider(String appId,String appSecret) {
        super(new OAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    }

    @Override
    public QQ getApi(String accessToken) {
        return  new QQImpl(accessToken,appId);
    }
}
