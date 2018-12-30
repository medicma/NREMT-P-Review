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
import android.widget.RadioButton;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Random;

public class CategoryQuiz extends AppCompatActivity {
    protected DataHolder globalHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quiz By Category ");
        setSupportActionBar(toolbar);

        globalHolder = ((DataHolder) getApplication());

        final TextView text = (TextView) findViewById(R.id.txtQuestionQuiz);
        final RadioButton A1 = (RadioButton) findViewById(R.id.rbA1);
        final RadioButton A2 = (RadioButton) findViewById(R.id.rbA2);
        final RadioButton A3 = (RadioButton) findViewById(R.id.rbA3);
        final RadioButton A4 = (RadioButton) findViewById(R.id.rbA4);
        final RadioButton A5 = (RadioButton) findViewById(R.id.rbA5);
        Button next = (Button) findViewById(R.id.btnNext);

        ParseQuery<ParseObject> queryCategoryQuestions;
        queryCategoryQuestions = ParseQuery.getQuery("Questions");
        queryCategoryQuestions.fromLocalDatastore();
        Random r = new Random();
        int i1 = r.nextInt(2);
        queryCategoryQuestions.whereContains("QuestionNumber",String.valueOf(i1)); /////////******************

         //put the last question number - 1
        queryCategoryQuestions.whereContains("QuestionNumber", String.valueOf(i1));
        queryCategoryQuestions.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(final ParseObject object, ParseException e) {
                if (e == null) {
                    globalHolder.setTheQuestion(object.getString("Question"));
                    globalHolder.setQuizCorrect(object.getString("Answer"));
                    globalHolder.setRationale(object.getString("Rationale"));

                    text.setText(object.getString("Question"));
                    A1.setText(object.getString("A1"));
                    A2.setText(object.getString("A2"));
                    A3.setText(object.getString("A3"));
                    A4.setText(object.getString("A4"));
                    A5.setText(object.getString("A5"));
                }
                A1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        A2.setChecked(false);
                        A3.setChecked(false);
                        A4.setChecked(false);
                        A5.setChecked(false);
                        //DataHolder.TheirQuizAnswer.add(object.getString("A1"));
                        globalHolder.setQuizTheirAnswer(object.getString("A1"));
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
                      //  DataHolder.TheirQuizAnswer.add(object.getString("A2"));
                        globalHolder.setQuizTheirAnswer(object.getString("A2"));
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
                      //  DataHolder.TheirQuizAnswer.add(object.getString("A3"));
                        globalHolder.setQuizTheirAnswer(object.getString("A3"));
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
                      //  DataHolder.TheirQuizAnswer.add(object.getString("A4"));
                        globalHolder.setQuizTheirAnswer(object.getString("A4"));
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
                      //  DataHolder.TheirQuizAnswer.add(object.getString("A5"));
                        globalHolder.setQuizTheirAnswer(object.getString("A5"));
                        globalHolder.setCounter(100);
                    }
                });
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

        next.setTextColor(Color.WHITE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RationaleCatagory.class);
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
        getMenuInflater().inflate(R.menu.menu_category, menu);
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
