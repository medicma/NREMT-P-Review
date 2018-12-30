package com.wolfenterprisesllc.nremtbasicstudyquestions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Summary extends AppCompatActivity {
    protected DataHolder globalHolder;
    Date date = (new Date());
    CharSequence s = DateFormat.format("MMMM d, yyyy HH:mm:ss", date.getTime());

    //THIS IS ALL QUIZ!!!!!!!!!!          **************globalHolder.getCounter is your counter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("This Quiz Breakdown");
        setSupportActionBar(toolbar);
        globalHolder = ((DataHolder) getApplication());
        globalHolder.setDate(date);

        Button finish = (Button) findViewById(R.id.btnReturn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalHolder.setTheQuestion("");
                globalHolder.setQuizCorrect("");
                globalHolder.setRationale("");
                DataHolder.totalArray.clear();
                DataHolder.TheirQuizAnswer.clear();
                DataHolder.quizCorrectArray.clear();
                globalHolder.setCounter(0);
                globalHolder.setCounterCorrect(0);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        TextView theCore = (TextView) findViewById(R.id.txtQuizSummaryXml);
        ArrayList<String> quizHolder = new ArrayList<>();
        for (int i = 0; i < DataHolder.TheirQuizAnswer.size(); i++) {
            quizHolder.add("The Question: " + DataHolder.totalArray.get(i) + "\n\tYour Answer: " + DataHolder.TheirQuizAnswer.get(i) + "\n\tThe Correct Answer: " + DataHolder.quizCorrectArray.get(i) + "\n\n");
        }
        String text = String.valueOf(quizHolder).replace("[", "").replace("]", "").replace(",", "").trim();
        theCore.setText(text);

        Double score;
        score = Double.valueOf(globalHolder.getCounterCorrect()) / Double.valueOf(globalHolder.getCounter());
        globalHolder.setHighScore(score);
        String message = "Your Quiz Score Is: " + String.format("%.1f", (score * 100)) + "%";
        TextView score2 = (TextView) findViewById(R.id.txtScoreQuiz);
        score2.setText(message);
        globalHolder.sendToCard("Date: " + String.valueOf(date) + ", Quiz Score: " + String.format("%.1f", (score * 100)) + "%" + "\n\n");
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary, menu);
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
                String[] TO = {"wolfnremtreview@yahoo.com"};
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
