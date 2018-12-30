package com.wolfenterprisesllc.nremtbasicstudyquestions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rationale extends AppCompatActivity {

    protected DataHolder globalHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rationale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Rationale");
        setSupportActionBar(toolbar);

        globalHolder = ((DataHolder) getApplication());

        TextView question = (TextView) findViewById(R.id.txtQuestion);
        TextView theirAnswer = (TextView) findViewById(R.id.txtAnswer);
        TextView correctAnswer = (TextView) findViewById(R.id.txtCorrectAnswer);
        TextView rationale = (TextView) findViewById(R.id.txtRationale);

        theirAnswer.setText(globalHolder.getQuizTheirAnswer());
        question.setText(globalHolder.getTheQuestion());
        correctAnswer.setText(globalHolder.getQuizCorrect());
        rationale.setText(globalHolder.getRationale());
/*
try {
            if (globalHolder.getQuizTheirAnswer().equals(globalHolder.getQuizCorrect())) {
                globalHolder.setCounterCorrect(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        try {
            if (globalHolder.getQuizCorrect().equals(globalHolder.getQuizTheirAnswer())) {
                globalHolder.setCounterCorrect(1);
            }
        } catch (Exception e1) {
            e1.getMessage();
        }

        Button next = (Button) findViewById(R.id.btnNext);
        next.setTextColor(Color.WHITE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (globalHolder.getCounter()<Integer.valueOf(globalHolder.getNumberOfQuizQuestionsChosen())) {
                    globalHolder.setTheQuestion("");
                    globalHolder.setQuizCorrect("");
                    globalHolder.setRationale("");
                    Intent intent = new Intent(getBaseContext(), QuestionsQuiz.class);
                    startActivity(intent);
                } else {
                    globalHolder.setTheQuestion("");
                    globalHolder.setQuizCorrect("");
                    globalHolder.setRationale("");
                    Intent intent = new Intent(getBaseContext(),Summary.class);
                    startActivity(intent);
                }
            }
        });

        Button goBack = (Button) findViewById(R.id.btnBack);
        goBack.setTextColor(Color.WHITE);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalHolder.setTheQuestion("");
                globalHolder.setQuizCorrect("");
                globalHolder.setRationale("");

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button summary = (Button)findViewById(R.id.btnSummary);
        summary.setTextColor(Color.WHITE);
        summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Summary.class);
                startActivity(intent);
            }
        });
    }


    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rationale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            // to add the string to the toolbar menu you must add it to the layout menu!!!!  and to the layout strings!!!!!
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
                break;
            case R.id.website:
                goToUrl("http://fireladychicago.wix.com/wolf-nremt-p-review");
            case R.id.goHome:
                Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent1);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
