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
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Random;

public class QuestionsQuiz extends AppCompatActivity {

    protected DataHolder globalHolder;
//THIS IS ALL QUIZ**************globalHoler.getCounter is your counter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_quiz);
        globalHolder = ((DataHolder) getApplication());

        final TextView text = (TextView) findViewById(R.id.txtQuestionQuiz);
        final RadioButton A1 = (RadioButton) findViewById(R.id.rbA1);
        final RadioButton A2 = (RadioButton) findViewById(R.id.rbA2);
        final RadioButton A3 = (RadioButton) findViewById(R.id.rbA3);
        final RadioButton A4 = (RadioButton) findViewById(R.id.rbA4);
        final RadioButton A5 = (RadioButton) findViewById(R.id.rbA5);

        ParseQuery<ParseObject> queryTestQuestions;
        queryTestQuestions = ParseQuery.getQuery("Questions");
        queryTestQuestions.fromLocalDatastore();

        Random r = new Random();
        int i1 = r.nextInt(3);//**************************************put the last question number - 1

        queryTestQuestions.whereContains("QuestionNumber", String.valueOf(i1));
        queryTestQuestions.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(final ParseObject object, ParseException e) {
                if (e == null) {
                    globalHolder.setTheQuestion(object.getString("Question"));
                    globalHolder.setQuizCorrect(object.getString("Answer"));
                    globalHolder.setRationale(object.getString("Rationale"));
                    //
                    // Toast.makeText(getApplicationContext(),globalHolder.getQuizCorrect() , Toast.LENGTH_SHORT).show();
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
                            A5.setChecked(false);
                            DataHolder.TheirTestAnswer.add(object.getString("A1"));
                            globalHolder.setQuizTheirAnswer(object.getString("A1")); //******this is wehre it is stopping.  Even when i move it into a seperate method.
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
                            DataHolder.TheirTestAnswer.add(object.getString("A3"));
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
                            DataHolder.TheirTestAnswer.add(object.getString("A4"));
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
                            DataHolder.TheirTestAnswer.add(object.getString("A5"));
                            globalHolder.setQuizTheirAnswer(object.getString("A5"));
                            globalHolder.setCounter(100);
                        }
                    });
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quiz Questions");
        setSupportActionBar(toolbar);

        Button back = (Button) findViewById(R.id.btnBack);
        back.setTextColor(Color.WHITE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button hint = (Button) findViewById(R.id.btnHint);
        hint.setTextColor(Color.WHITE);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), globalHolder.getRationale(), Toast.LENGTH_SHORT).show();
            }
        });

        Button next = (Button) findViewById(R.id.btnNext);
        next.setTextColor(Color.WHITE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Rationale.class);
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
        getMenuInflater().inflate(R.menu.menu_questions_quiz, menu);
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
