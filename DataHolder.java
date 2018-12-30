package com.wolfenterprisesllc.nremtbasicstudyquestions;

import android.app.Application;
import android.os.Environment;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Leslye on 2/18/2016.
 */
public class DataHolder extends Application {
    public void sendToCard(String d) {
        try {
            File myFile = new File(Environment.getExternalStorageDirectory().getPath() + "/Scores.txt");////File myFile = new File(Environment.getExternalStorageDirectory().getPath()+"/summary.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(d + "\n");
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    String rationale;
    String theQuestion;
    String quizCorrect;
    String testCorrect;
    String testTheirAnswer;
    String quizTheirAnswer;
    Integer counterTotal;
    Integer storeTotal = 0;
    Integer counterCorrect;
    Integer storeCorrect = 0;
    String numberOfTestQuestionsChosen;
    String numberOfQuizQuestionsChosen;
    Date date;
    String finalTime;
    Double highScore;
    Double storageScore = 0.0;
    String categorySelection;
    Boolean IsThere;

    public Boolean getIsThere() {
        return IsThere;
    }

    public void setIsThere(Boolean isThere) {
        IsThere = isThere;
    }

    public String getCategorySelection() {
        return categorySelection;
    }

    public void setCategorySelection(String categorySelection) {
        this.categorySelection = categorySelection;
    }

    public Double getHighScore() {
        return storageScore;
    }

    public void setHighScore(Double highScore) {
        this.highScore = highScore;
        if (highScore > storageScore) {
            storageScore = highScore;
        }
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public final static ArrayList<String> totalArray = new ArrayList<>();
    public final static ArrayList<String> testCorrectArray = new ArrayList<>(); //testCorrect
    public final static ArrayList<String> RationaleArray = new ArrayList<>(); //Rationale
    public final static ArrayList<String> quizCorrectArray = new ArrayList<>(); //quiz correct
    public final static ArrayList<String> TheirTestAnswer = new ArrayList<>();  //ParseID
    public final static ArrayList<String> TheirQuizAnswer = new ArrayList<>();  //ParseID
    public final static ArrayList<String> ParseIDArray = new ArrayList<>();  //ParseID


    Double Score2;

    public Double getScore2() {
        return Score2;
    }

    public void setScore2(Double score2) { // score2 is what is bong passed in.  Score2 is going out.
        if (score2 > Score2) {
            score2 = Score2;
        }
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getNumberOfTestQuestionsChosen() {
        return numberOfTestQuestionsChosen;
    }

    public void setNumberOfTestQuestionsChosen(String numberOfTestQuestionsChosen) {
        this.numberOfTestQuestionsChosen = numberOfTestQuestionsChosen;
    }


    public String getNumberOfQuizQuestionsChosen() {
        return numberOfQuizQuestionsChosen;
    }

    public void setNumberOfQuizQuestionsChosen(String numberOfQuizQuestionsChosen) {
        this.numberOfQuizQuestionsChosen = numberOfQuizQuestionsChosen;
    }


    public Integer getCounterCorrect() {
        return storeCorrect;
    }

    public void setCounterCorrect(Integer counterCorrect) {
        this.counterCorrect = counterCorrect;
        if (counterCorrect == 1) {
            storeCorrect = storeCorrect + 1;
        } else if (counterCorrect == 0) {
            storeCorrect = 0;
        }
    }


    public Integer getCounter() {
        return storeTotal;
    }

    public void setCounter(Integer counter) {
        this.counterTotal = counter;
        if (counterTotal == 100) {
            storeTotal = storeTotal + 1;
        } else if (counterTotal == 0) {
            storeTotal = 0;
        }
    }


    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
        RationaleArray.add(rationale);
    }


    public String getTheQuestion() {
        return theQuestion;
    }

    public void setTheQuestion(String theQuestion) {
        this.theQuestion = theQuestion;
        totalArray.add(theQuestion);
    }


    public String getQuizCorrect() {
        return quizCorrect;
    }

    public void setQuizCorrect(String quizCorrect) {
        this.quizCorrect = quizCorrect;
        quizCorrectArray.add(quizCorrect);
    }


    public String getTestCorrect() {
        return testCorrect;
    }

    public void setTestCorrect(String testCorrect) {
        this.testCorrect = testCorrect;
      //  testCorrectArray.add(testCorrect);
    }


    public String getQuizTheirAnswer() {
        return quizTheirAnswer;
    }

    public void setQuizTheirAnswer(String quizTheirAnswer) {
        this.quizTheirAnswer = quizTheirAnswer;
        TheirQuizAnswer.add(quizTheirAnswer);
    }


    public String getTestTheirAnswer() {
        return testTheirAnswer;
    }

    public void setTestTheirAnswer(String testTheirAnswer) {
        this.testTheirAnswer = testTheirAnswer;
       // TheirTestAnswer.add(testTheirAnswer);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "L3aYHyaFUnBALA1WomN5U3ZiN1UJZLC3XOKQlXeK", "HDPgDm52IUwP8KfLWn5bEJ62u1dDO58F2XXr7cSF");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

}
