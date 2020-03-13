package com.example.coursef;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class response extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute
    public int vj = Second.user;
    public String url="";
    public String freak=Second.url;
    public response(Context context) {
        this.context = context;
    }


    public static String response="";

    public String e_mail=loginscreen.emails;
    public String password=loginscreen.password;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response

        if(vj==1){
        url = freak+"api/student/login?e_mail="+ e_mail+"&pass="+ password;}
        else if(vj==0){
             url = freak+"api/faculty/login?e_mail="+ e_mail+"&pass="+ password;
        }
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("msg");
                Log.v("po", response);

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

        if(response.equals("v")) {


            Toast.makeText(this.context, "Logged in Successfully", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("nv")) {


            Toast.makeText(this.context, "Check your Email for the verification link", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("de")) {


            Toast.makeText(this.context, "Please do try again", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("ns")) {


            Toast.makeText(this.context, "Rethink your first step", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("ae")) {


            Toast.makeText(this.context, "Authentication error!!", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }

    }

}

