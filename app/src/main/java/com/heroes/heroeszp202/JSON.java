package com.heroes.heroeszp202;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {
        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("results");

        return jsonArray;
    }

    public static ArrayList<Hero> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Hero> heroList = new ArrayList<Hero>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Hero hero = new Hero(
                    //public Cocktails(String id, String name, String category, String tags, String ingredient1, String ingredient2, String ingredient3)
                    json_data.getString("id"),
                    json_data.getString("name"),
                    json_data.getJSONObject("powerstats").getString("intelligence"),
                    json_data.getJSONObject("powerstats").getString("strength"),
                    json_data.getJSONObject("powerstats").getString("speed"),
                    json_data.getJSONObject("powerstats").getString("durability"),
                    json_data.getJSONObject("powerstats").getString("power")




            );
            heroList.add(hero);
        }
        return heroList;
    }

    public static ArrayList<Hero> getHerosListByQuery(ArrayList<Hero> herosList, String heroName) {
        ArrayList<Hero> herosListByQuery = new ArrayList<Hero>();
        for (Hero heros : herosList) {
            if (heros.getName().contains(heroName)) {
                herosListByQuery.add(heros);
            }
        }
        return herosListByQuery;
    }

}
