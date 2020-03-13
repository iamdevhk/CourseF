package com.example.coursef;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class facsignupresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute
    public String freak=Second.url;
    public facsignupresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public String name=facsignup.name;
    public String email=facsignup.email;
    public String phnnum=facsignup.phnnum;
    public String password=facsignup.pass;
    public String dept=facsignup.dept;
   // public String sem=Signup.sem;

    public static String hk="";

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = freak+"api/faculty/signup?name="+ name+"&email="+ email+"&phnnum="+ phnnum+"&dept="+dept+"&pass="+ password;
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
        if(hk.equals("created")) {
            Log.v("Hk", response);

            Toast.makeText(this.context, "Account Successfully created", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(hk.equals("already")) {
            Log.v("Hk", response);

            Toast.makeText(this.context, "User already Created do login", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("de")) {


            Toast.makeText(this.context, "Please do try again", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("wp")) {


            Toast.makeText(this.context, "Weak Password", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("ie")) {


            Toast.makeText(this.context, "Invalid email!!", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }

    }

}

