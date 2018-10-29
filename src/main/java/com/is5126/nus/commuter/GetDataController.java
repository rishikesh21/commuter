package com.is5126.nus.commuter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

@RestController
public class GetDataController {

    public void getDataFiles(){
        //Create the Rest Template
        RestTemplate restTemplate = new RestTemplate();

        //Create the Headers with Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("AccountKey","<<PUT YOUR API KEY>>");
        HttpEntity entity=new HttpEntity(headers);


        //get the DATA MALL URL for all the months needed

        for(int month=1;month<=1;month++) {

            //adjusting the iteration according to file name
            String monthIter;
            if(month<10){
                monthIter="0"+month;
            }
            else{
                monthIter=""+month;
            }
            System.out.println(monthIter);
            String got_url = "<Insert the Data Mall API  >"+monthIter;
            System.out.println(got_url);
            //ResponseEntity<String> response = restTemplate.exchange(got_url, HttpMethod.GET, entity, String.class);

            //String res = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //JsonNode jsonNode = objectMapper.readTree(res);
                //String FILE_URL = jsonNode.get("value").get(0).get("Link").asText();
                String FILE_URL = got_url;

                String FILE_NAME = "origin_destination_train_20180"+month+".csv";
//                BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
//                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
//                byte dataBuffer[] = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//                    fileOutputStream.write(dataBuffer, 0, bytesRead);
//                }


                //writing the file into local repo
                ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
                FileChannel fileChannel = fileOutputStream.getChannel();
                fileOutputStream.getChannel()
                        .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);




            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




}
