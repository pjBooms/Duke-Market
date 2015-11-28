package dukemarket.controllers;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class UploadControllerTest {

    static {
        System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.NoOpLog");
    }

    @Test
    public void testBundleUpload() throws Exception {

        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "error");
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(String.valueOf(new URL("http://localhost:8080/bundle")));

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("bundle", new File("/home/azhidkov/yd/Activities/HackDay40/Java-ReStart/apps/BrickBreaker.zip"));
        post.setEntity(builder.build());
        client.execute(post);

    }
}