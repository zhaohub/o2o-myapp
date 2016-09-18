package com.test.lang;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by zhaogang3 on 2016/9/5.
 */
public class IntegerTest {

    public static void main0(String[] args) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String url = "http://spider.o2o.test.com/api/solo/shopurl";
        String shopUrl = "http://waimai.meituan.com/restaurant/918496?pos=0";

        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("ref_url", "1111"));
        params.add(new BasicNameValuePair("city_id_daojia", "1111"));
        params.add(new BasicNameValuePair("name", "1111"));
        params.add(new BasicNameValuePair("orgCode", "1111"));
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");

        httpPost.setEntity(httpEntity);
        httpPost.setHeader("Content-Type", "application/json");
        HttpClient httpClient = new DefaultHttpClient();


        HttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            Map<String, Object> r = JSON.parseObject(result, HashMap.class);
            Object v = r.get("code");
            if (v != null && v.equals(0) || v.equals("0")) {
                map.put("code", 0);
                map.put("msg", "提交成功");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //callStorageApi();
        /*for (int i = 0; i < 100000000; i++) {
            int t = getInt();
            if (t > 6 || t < 1)
                System.out.println(t);
        }*/

        /*Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"yyyyy");
        System.out.println(map.get(1));*/
        System.out.println(Long.MAX_VALUE);
        long s = Long.parseLong("14207808324376472164");

    }

    private static int getInt() {
        Random random = new Random();
        int result = random.nextInt(6) + 1;
        return result;
    }

    /**
     * 调用存储 API
     *
     * @return true-成功；false-失败；
     * @throws IOException
     */
    private static boolean callStorageApi() throws IOException {
        URL obj = new URL("http://spider.o2o.test.com/api/solo/shopurl/");
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("POST");

        // Send post request
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        byte[] query = "{\"ref_url\":\"http://waimai.meituan.com/restaurant/918496?pos=0\",\"name\":\"宝岛小厨（武大店）\",\"org_code\":\"88888888\"}".getBytes("UTF-8");

        OutputStream os = conn.getOutputStream();
        os.write(query);
        os.close();

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        return false;
    }
}