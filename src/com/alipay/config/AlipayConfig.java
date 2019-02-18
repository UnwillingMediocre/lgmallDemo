package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500590443";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdciWfKc1pqCMrm3pV2Bd7AENTu9G1OcCUcIGIzwp+0dBR6mVjh+ihJqSTbtnqvUM5i/KDnrY+ll7G/Jk/cDj2fikwBCHD43Wnd7NGwHGgUQM5ijwV+nZnjS5q/VoY8yV3h4yzqIhc3hkwtCEbAWwKTxSriBhljOUjQ3xOQwTd60hOup6Ziip4DaRxfldDvpHYLvDPxZTxYOQ6NI+JCoejp7andvpCCoigrULtcMg1Exs/eEbut6N06HVRd7u0mQ0Z7yj1rqExlAcDERDGD+xcRqvRJXKbbDfQKR/0nnRdFWRXwxty2pbvMj6SJZ4fBWimsDFPw+UyTvQ2t3jUT0OlAgMBAAECggEAP97AeFLi64uzyMrn0883p0QyC9PTfKsS/qStR6yF23COC80EmF3X9xfQB6cea+WfUcb9+Hr3/2fMxvhNyrhhw0zmtH3YnLi3T9p1Nax368sxfbQgL+JNCjDxtaFVXW21s0mfwHoL53CJ04IfM+9dvsjZ38Pz8a44fhewY6c4YDWeEy+2eJrxS2jVhjC1NWjo5Baq1CuyfXxzErrYqOJmr7ng6t+osxEQXwrymDQAd1TcjSCQrV+dgPh3LDK25/JIqx8RoDY/cQgbIEV5pahr51znWOvYkPk4ep5up+8cK0hh3iOrVhzZm5U3INrdrz8BcNhnjMj25e/muVb3dOOwgQKBgQD1SIJkeoqVhuobUpQGBhFQWMhueteY2EntCMe4PhHQCqrqrz63/ZxTiZ5EayC/pM++lKEhwq1sUmf6k2i41OoAHkNKJ3F7IcniKl+fN1pQmH8f0mlQiNLN4FznAlrY98luYrDodQGllLlaG69o+/V4bcPivtLqtBWIRg8XPE2TEQKBgQCkUy179kXWPklA6WT1r6ByOw6f9k8KPc5gN1uDsgMj2NepH8o4poPb7F6cfiC6jgQyLwmfe1ezv9KnLx/8gx392hF4PjoSGQm2wzvQn+MZxgtPUGDfhwln5ZnyNQ3RVZOhAQ3fAijUJ1pXjKW2ZbVcNG/4x0h9tcvCPl4m+Rh/VQKBgQDdxonfP80+FZZmzet45tOQyjWvbvKxCB8Pavjp5XVFnd+cAoe65FwMTEoForchkGsl7k0isVsMrhXFwrLVK+3H3ZUJ31AD/TEEhTugQfQvGzMWGrGOV6gC7fISDVcHBkPiwukhxWmPxUEx8AZR7j6sfNK4mcEq5VjytiW+5I9fgQKBgDRceMreT6SUFl2DwXL0MqkTnnZkUw1NYnyQRy3wxEVg7F9szNA+Zxfl+sPdAOrRJA8lo+hYsjqJrkMtpgCdeyoPma96DKEFr224SlAREpl83M+6KhQwAFRF+kcOlseUgEU2g8gC9SWdIJFzNL6pLCAkaWWZgsTj7/iGTRQYHbE9AoGAUdthawBbv3mi5lXDj5L8XY0mCGJmiXjzbNZ7mu1jnaT4g1PBwn7KHq+f8D85Y97459gGXx70iJj0ybm+dmuFszD6vFv468Pj4Bo6QivdzJe64LdQCO7m9pZKvq0Cjym7T8sxupCCgUBfNTHG54eal3VvHclMGVYcC01SkjUV3TY=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArPOaAdIhonBF0gcOk4nzyfnNJRJwlStWeLUhn2F/zty1DUWxSW45o6vpewspfko7JNwL6kpPuIiz6zXCRLb/oHMHPKFJZ6n1vxvoH5Qa1tCQPz9hnfsP0CiL3N0+2GywT0LQWa53ugGij/5yAcYtBbC2a7Mqt/YOJn9KNWvj6FHlf0zhXswTXL5f9LkC+yTy5w2UyMK9BExQhGJOlBrRTw/SFUWHiYw802iuWDs2SgJj3j0nfTfptYrFA+CalfWqBnXkmfcl67na/wNmS2PJVHu+Va6clOXDF5Jcaim7xvYWKbU6pghRjkkQZkiU7E5257mQE0UvfN2eQfOFntbPXwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.stodger.club:8080/lgmall/paySuccess";
    	/*public static String notify_url = "http://localhost:8080/lgmall/pay_success.jsp";*/
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.stodger.club:8080/lgmall/paySuccess";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

