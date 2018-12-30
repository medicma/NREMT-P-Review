package com.wolfenterprisesllc.nremtbasicstudyquestions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Random;

public class Questions extends AppCompatActivity {

    protected DataHolder globalHolder;
    private Chronometer chronometer;

//THIS IS ALL TEST    **************globalHolder.getCounter is your counter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        doIt();
        final long time = 0;
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setTextColor(Color.WHITE);
        chronometer.setBase(SystemClock.elapsedRealtime() - time);
        chronometer.start();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Test Questions");
        setSupportActionBar(toolbar);

        globalHolder = ((DataHolder) getApplication());

        Toast toast = Toast.makeText(getApplicationContext(), "Good Luck!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        final RadioButton A1 = (RadioButton) findViewById(R.id.rbA1);
        final RadioButton A2 = (RadioButton) findViewById(R.id.rbA2);
        final RadioButton A3 = (RadioButton) findViewById(R.id.rbA3);
        final RadioButton A4 = (RadioButton) findViewById(R.id.rbA4);
        final RadioButton A5 = (RadioButton) findViewById(R.id.rbA5);


        Button exit = (Button) findViewById(R.id.btnExit);
        exit.setTextColor(Color.WHITE);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chronoText = chronometer.getText().toString();  //this shows the final time
                globalHolder.setFinalTime(chronoText);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
                Intent intent = new Intent(getBaseContext(), SummaryTest.class);
                startActivity(intent);
            }
        });

        Button back = (Button) findViewById(R.id.btnBack);
        back.setTextColor(Color.WHITE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.btnNext);
        next.setTextColor(Color.WHITE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalHolder.getCounter() < Integer.valueOf(globalHolder.getNumberOfTestQuestionsChosen())) {
                    A1.setChecked(false);
                    A2.setChecked(false);
                    A3.setChecked(false);
                    A4.setChecked(false);
                    A5.setChecked(false);
                    doIt();
                } else {
                    Intent intent = new Intent(getBaseContext(), SummaryTest.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void doIt() {
        final TextView text = (TextView) findViewById(R.id.txtQuestion);
        final RadioButton A1 = (RadioButton) findViewById(R.id.rbA1);
        final RadioButton A2 = (RadioButton) findViewById(R.id.rbA2);
        final RadioButton A3 = (RadioButton) findViewById(R.id.rbA3);
        final RadioButton A4 = (RadioButton) findViewById(R.id.rbA4);
        final RadioButton A5 = (RadioButton) findViewById(R.id.rbA5);

        ParseQuery<ParseObject> queryTestQuestions;
        queryTestQuestions = ParseQuery.getQuery("Questions");

        Random r = new Random();
        int i1 = r.nextInt(3);   //**************************************put this as the last question number - 1

        queryTestQuestions.whereContains("QuestionNumber", String.valueOf(i1));
        queryTestQuestions.fromLocalDatastore();
        queryTestQuestions.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(final ParseObject object, ParseException e) {
                if (e == null) {
                    DataHolder.testCorrectArray.add(object.getString("Answer"));
                    DataHolder.totalArray.add(object.getString("Question"));
                    // globalHolder.setTheQuestion(object.getString("Question"));
                    globalHolder.setTestCorrect(object.getString("Answer"));

                    text.setText(object.getString("Question"));
                    A1.setText(object.getString("A1"));
                    A2.setText(object.getString("A2"));
                    A3.setText(object.getString("A3"));
                    A4.setText(object.getString("A4"));
                    A5.setText(object.getString("A5"));

                    A1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            A2.setChecked(false);
                            A3.setChecked(false);
                            A4.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A1"));
                            globalHolder.setTestTheirAnswer(object.getString("A1"));
                            globalHolder.setCounter(100);
                        }
                    });
                    A2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            A1.setChecked(false);
                            A3.setChecked(false);
                            A4.setChecked(false);
                            A5.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A2"));
                            globalHolder.setTestTheirAnswer(object.getString("A2"));
                            globalHolder.setCounter(100);
                        }
                    });
                    A3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            A1.setChecked(false);
                            A2.setChecked(false);
                            A4.setChecked(false);
                            A5.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A3"));
                            globalHolder.setTestTheirAnswer(object.getString("A3"));
                            globalHolder.setCounter(100);
                        }
                    });
                    A4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            A1.setChecked(false);
                            A2.setChecked(false);
                            A3.setChecked(false);
                            A5.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A4"));
                            globalHolder.setTestTheirAnswer(object.getString("A4"));
                            globalHolder.setCounter(100);
                        }
                    });
                    A5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            A1.setChecked(false);
                            A2.setChecked(false);
                            A3.setChecked(false);
                            A4.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A5"));
                            globalHolder.setTestTheirAnswer(object.getString("A5"));
                            globalHolder.setCounter(100);
                        }
                    });
                }
            }
        });
        try {
            if (globalHolder.getTestTheirAnswer().equals(globalHolder.getTestCorrect())) {
                globalHolder.setCounterCorrect(1);
            }
        } catch (Exception e1) {
            e1.getMessage();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.contact:
                String[] TO = {"wolfnremtreview@yahoo.com"}; //CHANGE THIS To NEW EMAIL ADDRESS!!!!!!!!!!!!!!
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client to use:"));
                break;

            case R.id.action_settings:
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.goHome:
                Intent intent2 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.website:
                goToUrl("http://fireladychicago.wix.com/wolf-nremt-p-review");
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
