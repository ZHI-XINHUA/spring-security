package social.qq.aip;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Created by zhixinhua on 18/1/29.
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    //获取openid（用户的ID，与QQ号码一一对应）的地址
    private static final String URL_GET_OPENID="https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO="https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    //用于j转化java对象的工具类
    private ObjectMapper objectMapper= new ObjectMapper();

    public QQImpl(String accessToken,String appId){
        //TokenStrategy.ACCESS_TOKEN_PARAMETER 把accessToken通过查询参数挂在请求url中
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        this.appId = appId;

        String url = String.format(URL_GET_OPENID,accessToken);
        String appIdStr = getRestTemplate().getForObject(url,String.class);

        this.openId = StringUtils.substringBetween(appIdStr,"'openid'","}");
    }



    @Override
    public QQUserInfo getQQUserInfo()  throws Exception{
        String url = String.format(URL_GET_USERINFO,appId,openId);
        String result = getRestTemplate().getForObject(url,String.class);
        System.out.println(result);
        return objectMapper.readValue(result,QQUserInfo.class);
    }


}
