package kpi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JsonJava {
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();

        //JSON object and values
        String s = "Atul Rai";
        int i = 1;
        jsonObject.put("name", s);
        jsonObject.put("occupation", "" + "Blogger");
        jsonObject.put("location", i);
        jsonObject.put("website", "" + i);

        //JSON array and values
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Java");
        jsonArray.add("Struts");
        jsonArray.add("jQuery");
        jsonArray.add("JavaScript");
        jsonArray.add("Database");

        jsonObject.put("technology", jsonArray);

        // writing the JSONObject into a file(info.json)
        try {
            FileWriter fileWriter = new FileWriter("info.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
    }

}
