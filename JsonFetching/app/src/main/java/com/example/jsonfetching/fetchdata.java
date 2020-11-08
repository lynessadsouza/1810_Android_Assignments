
package com.example.jsonfetching;


import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static android.widget.Toast.LENGTH_LONG;

class fetchdata extends AsyncTask<Void, Void, Void> {
    String data = "";
    String sort = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.jsonbin.io/b/5f98044c30aaa01ce619982d");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray jsonArray = new JSONArray(data);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                arrayList.add("Emp Code: " + jsonObject.get("empCode")+"\n"+"Name: " + jsonObject.get("lastName") + " " + jsonObject.get("firstName") + "\n" +
                         "Salary :" + jsonObject.get("salary") + "\n");


            }
            Collections.sort(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                sort = sort + arrayList.get(i) + "\n";
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        MainActivity.data.setText(this.sort);


    }
}

