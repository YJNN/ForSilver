package com.example.user.silver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by user on 2016-12-11.
 */
public class Silvermarket extends Activity {

    Handler handler = new Handler();
    String url3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silvermarket);
       url3=new String();


       //�μ����Ϸ�����
        Button button = (Button) findViewById(R.id.adbuy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast toast = Toast.makeText(getApplicationContext(),url3, Toast.LENGTH_LONG);
               // toast.show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url3.trim()));
                startActivity(intent);
            }
        });

        //��
        Button button2 = (Button) findViewById(R.id.buy);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Silvermarket.this, shopping.class);
                startActivity(intent);
            }
        });
       /////////////////////
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuffer sb = new StringBuffer();

                try {
                    URL url = new URL("http://202.30.23.51/~sap16t7/adsite.html");
                    HttpURLConnection conn =
                            (HttpURLConnection)url.openConnection();// 접속
                    if (conn != null) {
                        conn.setConnectTimeout(2000);
                        conn.setUseCaches(false);
                        if (conn.getResponseCode()
                                ==HttpURLConnection.HTTP_OK){
                            //    데이터 읽기
                            BufferedReader br
                                    = new BufferedReader(new InputStreamReader
                                    (conn.getInputStream(),"euc-kr"));//"utf-8"
                            while(true) {
                                String line = br.readLine();
                                if (line == null) break;
                                sb.append(line+"\n");
                            }
                            br.close(); // 스트림 해제
                        }
                        conn.disconnect(); // 연결 끊기
                    }
                    // 값을 출력하기
                    Log.d("test", sb.toString());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String url=new String();
                            String realurl;
                            String realurl2;
                            String[] temp;
                            String[] temp2;
                            url=sb.toString();
                            temp=url.split(">");
                            realurl=temp[3];
                            temp2=realurl.split("<");
                            realurl2=temp2[0];
                            url3=realurl2;
                            //          Toast toast = Toast.makeText(getApplicationContext(),realurl2, Toast.LENGTH_LONG);
                            //        toast.show();

                            //         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(realurl2));
                            //         startActivity(intent);


                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start(); // 쓰레드 시작




        //////////////제휴 이미지
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    // 걍 외우는게 좋다
                    final ImageView iv = (ImageView)findViewById(R.id.ad);
                    URL url = new URL("http://202.30.23.51/~sap16t7/ad.PNG");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm); //비트맵 객체로 보여주기
                } catch(Exception e){

                }

            }
        });

        t.start();

    }






}
