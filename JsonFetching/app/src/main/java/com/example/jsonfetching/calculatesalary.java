
package com.example.jsonfetching;


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

class calculatesalary extends AsyncTask<Void, Void, Void> {
    String data = "";
    Double salary= Double.NaN;
    public static Double totalsalary=0.0;


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

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {

                //
                JSONObject jsonObject = (JSONObject) JA.get(i);
                salary = jsonObject.getDouble("salary");
                totalsalary= totalsalary+salary;


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        MainActivity.sal.setText("Total:"+this.totalsalary.toString());


    }
}

