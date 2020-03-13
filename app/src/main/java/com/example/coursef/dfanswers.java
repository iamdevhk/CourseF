package com.example.coursef;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;



        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class dfanswers extends AppCompatActivity {
    public ListView listView;
    public String email = loginscreen.emails;
    TextView textView;
    public String freak=Second.url;
    public String course="";
    public int ch=Component.choice;
    public String questionchose=discussion_forum.question;
    List<String> listItem=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    public String question;
    public int vj = Second.user;
    //String[] listItem;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfanswers);
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        if(vj==1)
        {
            course=coursesdynamic.course;
        }
        else if(vj==0)
        {
            course=faccoursesdynamic.course;
        }
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vj==1){
                Intent al = new Intent(dfanswers.this, postananswer.class);
                startActivity(al);}
                else if (vj==0){
                    Toast.makeText(dfanswers.this, "You dont have access to this section", Toast.LENGTH_SHORT).show();

                }
            }
        });
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        rq = Volley.newRequestQueue(this);
        sendRequest();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                question  = ((TextView) view).getText().toString();


            }
        });
    }
    public void sendRequest(){

        String request_url = freak+"api/getanswer?course="+course+"&ques="+questionchose;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    //Product personUtils = new Product();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        titl=jsonObject.getString("answer");
                        Log.v("h",titl);
                        // Product.getTitle(titl);
                        listItem.add(titl);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);


    }

}



