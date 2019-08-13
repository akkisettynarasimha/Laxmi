package com.strsar.laxmi.updateapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.strsar.laxmi.BuildConfig;
import com.strsar.laxmi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateApp extends AppCompatActivity {


        private static  String url = "https://milk365.in/api/get_versions";
        String VersionUpdate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_app);


            new VersionCheck().execute();
        }


        private class VersionCheck extends AsyncTask<Void, Void, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();


            }

            @Override
            protected Void doInBackground(Void... arg0) {
                HttpHandler sh = new HttpHandler();


                String jsonStr = sh.makeServiceCall(url);

                if (jsonStr != null){
                    try {

                        JSONArray version = new JSONArray(jsonStr);
                        for (int i = 0; i < version.length(); i++){

                            JSONObject v = version.getJSONObject(i);

                            VersionUpdate = v.getString("versionname");
                            System.out.println("nananaana"+VersionUpdate);
                        }









                    }catch (final JSONException e) {
                        // Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }
                } else {
                    //Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }


                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);


                String VersionName = BuildConfig.VERSION_NAME;

                  System.out.println("versionname"+VersionName);
                if (VersionUpdate.equals(VersionName)){

                    //Do Nothing
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdateApp.this);
                    builder.setTitle("Our App got Update");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setCancelable(false);
                    builder.setMessage("New version available, select update to update our app")
                            .setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    final String appName = getPackageName();

                                    try {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appName)));
                                    } catch (android.content.ActivityNotFoundException anfe) {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appName)));
                                    }

                                    finish();

                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();


                }


            }
        }
    }
