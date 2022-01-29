/*
package com.example.infowindowadapterb;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class HttpManager {
    String url;

    public  HttpManager(String url){
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] GetFile (){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpclient.execute(request);
            if(response.getCode() == 200){

            }
            else {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
            }
           } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
*/
