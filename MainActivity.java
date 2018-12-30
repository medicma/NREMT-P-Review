package com.wolfenterprisesllc.nremtbasicstudyquestions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected DataHolder globalHolder;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     * <p/>
     * Toast.makeText(this, , Toast.LENGTH_SHORT).show();         **************globalHoler.getCOunter is your counter
     */
    private GoogleApiClient client;

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void ThrowItAway() {
        final ParseQuery<ParseObject> queryGrabTest = ParseQuery.getQuery("Test");
        queryGrabTest.setLimit(1000);
        queryGrabTest.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.unpinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );

        final ParseQuery<ParseObject> queryGrabQuiz = ParseQuery.getQuery("Quiz");
        queryGrabQuiz.setLimit(1000);
        queryGrabQuiz.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.unpinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );

        final ParseQuery<ParseObject> queryGrabQuestions = ParseQuery.getQuery("Questions");
        queryGrabQuestions.setLimit(1000);
        queryGrabQuestions.findInBackground(new FindCallback<ParseObject>() {
                                                @Override
                                                public void done(List<ParseObject> list, ParseException e) {
                                                    if (e == null) {
                                                        ParseObject.unpinAllInBackground(list);
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            }
        );

        final ParseQuery<ParseObject> queryGrabType = ParseQuery.getQuery("Category");
        queryGrabType.setLimit(1000);
        queryGrabType.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.unpinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );
    }

    //////////////////////////---------------------------------------------------------------------------------------------/////////////////////////////////
    private void GrabEverything() {
        final ParseQuery<ParseObject> queryGrabTest = ParseQuery.getQuery("Test");
        queryGrabTest.setLimit(1000);
        queryGrabTest.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.pinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );

        final ParseQuery<ParseObject> queryGrabQuiz = ParseQuery.getQuery("Quiz");
        queryGrabQuiz.setLimit(1000);
        queryGrabQuiz.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.pinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );

        final ParseQuery<ParseObject> queryGrabQuestions = ParseQuery.getQuery("Questions");
        queryGrabQuestions.whereContains("Level", "BLS"); /////////******************
        queryGrabQuestions.setLimit(1000);
        queryGrabQuestions.findInBackground(new FindCallback<ParseObject>() {
                                                @Override
                                                public void done(List<ParseObject> list, ParseException e) {
                                                    if (e == null) {
                                                        ParseObject.pinAllInBackground(list);
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            }
        );

        final ParseQuery<ParseObject> queryGrabType = ParseQuery.getQuery("Category");
        queryGrabType.setLimit(1000);
        queryGrabType.findInBackground(new FindCallback<ParseObject>() {
                                           @Override
                                           public void done(List<ParseObject> list, ParseException e) {
                                               if (e == null) {
                                                   ParseObject.pinAllInBackground(list);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "Oops. There was an error. Please try again or contact us if the problem persists.  CS3", Toast.LENGTH_LONG).show();
                                               }
                                           }
                                       }
        );
        TheQueries();
    }

    /////////////////////////---------------------------------------------------------------------------------------//////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalHolder = ((DataHolder) getApplication());

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setWriteAccess(ParseUser.getCurrentUser(), false);
        ParseACL.setDefaultACL(defaultACL, true);

        try {
            if (globalHolder.getIsThere()) {
                TheQueries();
            } else {
                globalHolder.setIsThere(true);
                GrabEverything();
            }
        } catch (Exception e) {
            GrabEverything();
        }


        TextView intro = (TextView) findViewById(R.id.txtIntro3);
        intro.setTextSize(15);

        ImageButton website = (ImageButton) findViewById(R.id.imgBtn);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://fireladychicago.wix.com/wolf-nremt-p-review");
            }
        });

        Button exit = (Button) findViewById(R.id.btnExit);
        exit.setTextColor(Color.WHITE);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalHolder.setTestCorrect("");
                globalHolder.setQuizCorrect("");

                Toast toast = Toast.makeText(getApplicationContext(), " Thank You For Using \nWolf Basic NREMT Review", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }, 2000);
            }
        });

        try {
            TextView testScore = (TextView) findViewById(R.id.txtHighScore);
            testScore.setText("Your High Score Is: " + String.valueOf(String.format("%.1f", globalHolder.getHighScore() * 100)) + "%");
        } catch (Exception e) {
            e.getMessage();
        }

        Button game = (Button) findViewById(R.id.btnGame);
        game.setTextColor(Color.WHITE);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "This new feature will be added soon.  Check back soon.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
//***************Defer to parse cloud code.  User must be online to use this feature.  Must be written in Javascript
            }
        });

        Button history = (Button) findViewById(R.id.btnHIstory);
        history.setTextColor(Color.WHITE);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), History.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        TheQueries();
    }

    public void TheQueries() {
        final Spinner test = (Spinner) findViewById(R.id.sprTest);
        final ParseQuery<ParseObject> queryTest = ParseQuery.getQuery("Test");
        queryTest.fromLocalDatastore();
        queryTest.orderByAscending("NumberOfQuestions3");
        queryTest.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> testHolder = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            testHolder.add(list.get(i).getString("NumberOfQuestions3"));
                        } catch (Exception ex) {
                            ex.getMessage();
                        }
                    }
                    if (!testHolder.isEmpty()) {
                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, testHolder);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        test.setAdapter(adapter);

                    }
                } else {
                    e.getMessage();
                }
            }
        });
        test.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selection = test.getSelectedItemPosition();
                globalHolder.setCategorySelection(String.valueOf(selection));  //1=Cardiology, 2=
                if (selection == 0) {
                    selection = position;
                } else {
                    globalHolder.setNumberOfTestQuestionsChosen(parent.getItemAtPosition(position).toString());
                    globalHolder.setIsThere(true);
                    Intent intent = new Intent(getBaseContext(), Questions.class);
                    startActivity(intent);
                    //This sets the number of questions in DataHolder
                    test.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                test.setEnabled(false);
            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final Spinner quiz = (Spinner) findViewById(R.id.sprQuiz);
        final ParseQuery<ParseObject> queryQuiz = ParseQuery.getQuery("Quiz");
        queryQuiz.fromLocalDatastore();
        queryQuiz.orderByAscending("NumberOfQuestions2");
        queryQuiz.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> quizHolder = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            quizHolder.add(list.get(i).getString("NumberOfQuestions2"));
                        } catch (Exception ex) {
                            ex.getMessage();
                        }
                    }
                    if (!quizHolder.isEmpty()) {
                        ArrayAdapter<String> adapter33;
                        adapter33 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, quizHolder);
                        adapter33.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        quiz.setAdapter(adapter33);
                    }
                } else {
                    e.getMessage();
                }
            }
        });
        quiz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selection = quiz.getSelectedItemPosition();
                if (selection == 0) {
                    selection = position;
                } else {
                    globalHolder.setNumberOfQuizQuestionsChosen(parent.getItemAtPosition(position).toString());
                    globalHolder.setIsThere(true);//This sets the number of questions in DataHolder
                    Intent intent = new Intent(getBaseContext(), QuestionsQuiz.class);
                    startActivity(intent);
                    quiz.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                quiz.setEnabled(false);
            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final Spinner category = (Spinner) findViewById(R.id.sprCategory);
        final ParseQuery<ParseObject> queryCategory = ParseQuery.getQuery("Category");
        queryCategory.fromLocalDatastore();
        queryCategory.orderByAscending("NumberOfQuestions3");
        queryCategory.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    ArrayList<String> categoryHolder = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            categoryHolder.add(list.get(i).getString("NumberOfQuestions3"));
                        } catch (Exception ex) {
                            ex.getMessage();
                        }
                    }
                    if (!categoryHolder.isEmpty()) {
                        ArrayAdapter<String> adapter3;
                        adapter3 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, categoryHolder);
                        adapter3.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        category.setAdapter(adapter3);
                    }
                } else {
                    e.getMessage();
                }
            }
        });
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selection = category.getSelectedItemPosition();
                if (selection == 0) {
                    selection = position;
                } else {
                    globalHolder.setNumberOfQuizQuestionsChosen(parent.getItemAtPosition(position).toString());
                    globalHolder.setCategorySelection(parent.getItemAtPosition(position).toString());
                    globalHolder.setIsThere(true);
                    Intent intent = new Intent(getBaseContext(), CategoryQuiz.class);
                    startActivity(intent);
                    category.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                category.setEnabled(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            // BE SURE TO TAKE INFLATER ALSO!!!!!  to add the string to the toolbar menu you must add it as a layout menu!!!!  and to the layout strings!!!!! AND BE SURE YOU ADD THE CORRECT LAYOUT MENU!!!!
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
            case R.id.refresh:
                ThrowItAway();
                GrabEverything();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Sucessfully Updated!", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
                break;
            case R.id.website:
                goToUrl("http://fireladychicago.wix.com/wolf-nremt-p-review");
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.wolfenterprisesllc.nremtbasicstudyquestions/http/host/path")
        );
        // AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.wolfenterprisesllc.nremtbasicstudyquestions/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}