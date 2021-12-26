package com.example.gazingfocus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;


@RestController
public class GazingController {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloSpringBoot(){
        return "Hello SpringBoot!";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/qaupload",produces = "application/json;charset=UTF-8")
    public String Test(@RequestBody String qaInfo){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        byte[] outputBytes = qaInfo.getBytes(StandardCharsets.UTF_8);
        try {
            String filename = timestamp.toString() + "qa-upload.json";
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(qaInfo);
            out.close();
            System.out.println("File successfully written! Filaname： " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            return "1";
        }
        System.out.println(qaInfo);
        return "0";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("recording")
    @ResponseBody
    public String addProduct(@RequestParam("Data") String recordingDescription,@RequestParam("Recording") MultipartFile recording) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String filename = timestamp.toString() + "-recording-" +recording.getOriginalFilename();
        try{
            if(!recording.isEmpty()){
                byte [] bytes = recording.getBytes();
                BufferedOutputStream bufferedOutputStream = new
                        BufferedOutputStream(new FileOutputStream(new File(filename)));
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            String dataFilename = timestamp.toString() + "data-recprdomg.json";
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(recordingDescription);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

}



