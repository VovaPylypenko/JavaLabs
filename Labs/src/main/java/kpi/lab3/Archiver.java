package kpi.lab3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalTime;
import java.util.Iterator;

class Archiver {

    private Logger2 logger;

    public Archiver(Logger2 logger) {
        this.logger = logger;
    }

    TrainsDB readArchive() throws Exception2 {
        JSONParser jsonParser = new JSONParser();
        TrainsDB trainsDB = new TrainsDB(logger);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("DB.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert fileReader != null;
            if (fileReader.ready())
                new Exception2("can't read from file.", logger);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(fileReader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONArray trainsJson = (JSONArray) jsonObject.get("trains");

        Iterator<JSONObject> iterator = trainsJson.iterator();
        while (iterator.hasNext()) {
            JSONObject trainJson = iterator.next();
            JSONObject seatsJson = (JSONObject) trainJson.get("seats");
            Train train = new Train(
                    Place.valueOf(trainJson.get("destination").toString()),
                    Integer.parseInt((String) trainJson.get("train")),
                    LocalTime.of(
                            Integer.parseInt((String) trainJson.get("departure time hour")),
                            Integer.parseInt((String) trainJson.get("departure time min"))),
                    Integer.parseInt((String) seatsJson.get("common")), Integer.parseInt((String) seatsJson.get("coupe")),
                    Integer.parseInt((String) seatsJson.get("placard")), Integer.parseInt((String) seatsJson.get("CB")),
                    logger);
            trainsDB.addTrain(train);
        }
        if (trainsDB.isEmpty()) {
            throw new Exception2("empty train`s DB.", logger);
        }
        return trainsDB;
    }

    @SuppressWarnings("unchecked")
    void archived(TrainsDB trains) {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonObject.put("archive time", String.valueOf(LocalTime.now()));

        for (Train train :
                trains.getAllTrains()) {
            jsonArray.add(archived(train));
        }
        jsonObject.put("trains", jsonArray);
        writeInFile(jsonObject);
    }

    private JSONObject archived(Train train) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("train", String.valueOf(train.getNumber()));
        jsonObject.put("destination", String.valueOf(train.getDestination()));
        jsonObject.put("departure time hour", String.valueOf(train.getDate().getHour()));
        jsonObject.put("departure time min", String.valueOf(train.getDate().getMinute()));
        JSONObject seats = new JSONObject();
        seats.put("common", String.valueOf(train.getSeatsCommon()));
        seats.put("coupe", String.valueOf(train.getSeatsCoupe()));
        seats.put("placard", String.valueOf(train.getSeatsPlacard()));
        seats.put("CB", String.valueOf(train.getSeatsCB()));
        jsonObject.put("seats", seats);

        return jsonObject;
    }

    private void writeInFile(JSONObject obj) {
        try (FileWriter file = new FileWriter("DB.json")) {
            file.write(obj.toJSONString());
            file.flush();
            logger.getLogger().info("write in file.Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
