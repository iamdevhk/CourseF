package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
public class htEmoticons extends AppCompatActivity implements SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener {
    private static final String TAG = "htEmoticons";
    public static String ans1,ans2,ans3,course;
    private SmileRating mSmileRating,nSmileRating,oSmileRating,pSmileRating,qSmileRating;
    public int a=0,b=0,c=0,d=0,e=0;
    public static float total=0;
    public static float avg=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht_emoticons);
        TextView txtProduct = (TextView) findViewById(R.id.coursename);

        String passedArg = getIntent().getExtras().getString("course");
        course=passedArg;
        // displaying selected product name
        txtProduct.setText(passedArg);
        mSmileRating = (SmileRating) findViewById(R.id.smile_rating);
        nSmileRating = (SmileRating) findViewById(R.id.smile_rating1);
        oSmileRating = (SmileRating) findViewById(R.id.smile_rating2);
        pSmileRating = (SmileRating) findViewById(R.id.smile_rating3);
        qSmileRating = (SmileRating) findViewById(R.id.smile_rating4);

       // mSmileRating.setOnSmileySelectionListener(this);
        //mSmileRating.setOnRatingSelectedListener(this);
       // nSmileRating.setOnSmileySelectionListener(this);
        //nSmileRating.setOnRatingSelectedListener(this);
        mSmileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                a=0;
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        a=2;
                        break;
                    case SmileRating.GOOD:
                        a=4;
                        break;
                    case SmileRating.GREAT:
                        a=5;
                        break;
                    case SmileRating.OKAY:
                        a=3;
                        break;
                    case SmileRating.TERRIBLE:
                        a=1;
                        break;
                    case SmileRating.NONE:
                        a=0;
                        break;
                }
               // total=total+a;
            }
        });
        nSmileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                b=0;
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        b=2;
                        break;
                    case SmileRating.GOOD:
                        b=4;
                        break;
                    case SmileRating.GREAT:
                        b=5;
                        break;
                    case SmileRating.OKAY:
                        b=3;
                        break;
                    case SmileRating.TERRIBLE:
                        b=1;
                        break;
                    case SmileRating.NONE:
                        b=0;
                        break;
                }
                //total=total+b;
            }
        });
        oSmileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                c=0;
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        c=2;
                        break;
                    case SmileRating.GOOD:
                        c=4;
                        break;
                    case SmileRating.GREAT:
                        c=5;
                        break;
                    case SmileRating.OKAY:
                        c=3;
                        break;
                    case SmileRating.TERRIBLE:
                        c=1;
                        break;
                    case SmileRating.NONE:
                        c=0;
                        break;
                }
                // total=total+a;
            }
        });
        pSmileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                d=0;
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        d=2;
                        break;
                    case SmileRating.GOOD:
                        d=4;
                        break;
                    case SmileRating.GREAT:
                        d=5;
                        break;
                    case SmileRating.OKAY:
                        d=3;
                        break;
                    case SmileRating.TERRIBLE:
                        d=1;
                        break;
                    case SmileRating.NONE:
                        d=0;
                        break;
                }
                // total=total+a;
            }
        });
        qSmileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                e=0;
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        e=2;
                        break;
                    case SmileRating.GOOD:
                        e=4;
                        break;
                    case SmileRating.GREAT:
                        e=5;
                        break;
                    case SmileRating.OKAY:
                        e=3;
                        break;
                    case SmileRating.TERRIBLE:
                        e=1;
                        break;
                    case SmileRating.NONE:
                        e=0;
                        break;
                }
                // total=total+a;
            }
        });


    }

    @Override
    public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
        switch (smiley) {
            case SmileRating.BAD:
                Log.i(TAG, "Bad");
                break;
            case SmileRating.GOOD:
                Log.i(TAG, "Good");
                break;
            case SmileRating.GREAT:
                Log.i(TAG, "Great");
                break;
            case SmileRating.OKAY:
                Log.i(TAG, "Okay");
                break;
            case SmileRating.TERRIBLE:
                Log.i(TAG, "Terrible");
                break;
            case SmileRating.NONE:
                Log.i(TAG, "None");
                break;
        }
    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {
        Log.i(TAG, "Rated as: " + level + " - " + reselected);
    }
    public void login(View view) {
        Log.i(TAG, "Rated as: "+a);
        Log.i(TAG, "Rated as: "+b);
        Log.i(TAG, "Rated as: "+c);
        Log.i(TAG, "Rated as: "+d);
        Log.i(TAG, "Rated as: "+e);

        total=a+b+c+d+e;
        avg=total/5;

        Log.i(TAG, "Rated as: "+total);
        Log.i(TAG, "Rated as: "+avg);
        if(a>=1&&b>=1&&c>=1&&d>=1&&e>=1){
        emoticonsresponse hu = new emoticonsresponse(this.getApplicationContext());
        hu.execute();}
        else{
            Toast.makeText(this, "Please Rate for all the questions", Toast.LENGTH_SHORT).show();

        }

    }
}



