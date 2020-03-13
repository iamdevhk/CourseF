package com.example.coursef;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class emoticonsresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public emoticonsresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public float avg=htEmoticons.avg;
    public String coursename=htEmoticons.course;
    public String email = loginscreen.emails;
    public static String hk="";
    public String freak=Second.url;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = freak+"api/emoticons?email="+email+"&avg="+avg+"&course="+coursename;
        //hk=0;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                response = jsonObj.getString("msg");
                Log.v("Hk", response);
                hk=response;

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.v("Hk", response);
        if(hk.equals("done")) {
            Log.v("Hk", response);

            Toast.makeText(this.context, "Feedback Submitted! Thanks for your time.", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, coursesdynamic.class));//the website should return the samed number if theres no entry for it
        }
        if(hk.equals("fail")) {
            Log.v("Hk", response);

            Toast.makeText(this.context, "Feedback Failed!Please Re-do.", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }


    }

}

