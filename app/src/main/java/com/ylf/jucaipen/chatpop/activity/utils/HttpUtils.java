package com.ylf.jucaipen.chatpop.activity.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Administrator on 2015/12/22.
 */
public class HttpUtils {


    public static String sendHttpGet(String path,Map<String,String> param) {
        try {
            StringBuffer buffer=new StringBuffer(path);
            if(param!=null&&param.size()>0){
                buffer.append("?");
                for(Map.Entry<String,String> p : param.entrySet()){
                    buffer.append(p.getKey());
                    buffer.append("=");
                    buffer.append(p.getValue());
                    buffer.append("&");
                }
                buffer.replace(buffer.length()-1,buffer.length(),"");
            }
            URL uri = new URL(buffer.toString());
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            // http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            conn.setConnectTimeout(1000 * 4);
            conn.setReadTimeout(1000 * 3);
            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            conn.setRequestProperty("Content-type", "application/x-java-serialized-object");
            // 设定请求的方法为"POST"，默认是GET
            conn.setRequestMethod("GET");
            int code=conn.getResponseCode();
            if(code== HttpsURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                byte bs[] = new byte[dis.available()];
                dis.read(bs);
                String result = new String(bs, "UTF-8");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
