package net.inete.tgpsi.jcarvalho.abnd_project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   int score = 0;    // final score

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      // Set the question header numbers
      setQuestionHeaders();
   }

   public void btnSubmitOnClick(View view) {
      // reset grade
      score = 0;
      // validate if the user answered the question 1
      if (validateAnswerQ1() == false) {
         return;
      }
      // validate if the user answered the question 2
      if (validateAnswerQ2() == false) {
         return;
      }
      // validate if the user answered the question 3
      if (validateAnswerQ3() == false) {
         return;
      }
      // validate if the user answered the question 4
      if (validateAnswerQ4() == false) {
         return;
      }
      // validate if the user answered the question 5
      if (validateAnswerQ5() == false) {
         return;
      }
      // validate if the user answered the question 6
      if (validateAnswerQ6() == false) {
         return;
      }
      // validate if the user answered the question 7
      if (validateAnswerQ7() == false) {
         return;
      }
      // validate if the user answered the question 8
      if (validateAnswerQ8() == false) {
         return;
      }


      // Grading the quiz
      score += gradeQ1(); // grade question 1
      score += gradeQ2(); // grade question 2
      score += gradeQ3(); // grade question 3
      score += gradeQ4(); // grade question 4
      score += gradeQ5(); // grade question 5
      score += gradeQ6(); // grade question 6
      score += gradeQ7(); // grade question 7
      score += gradeQ8(); // grade question 8

      // call the score activity with the final score
      Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
      i.putExtra("final_grade", score);
      startActivity(i);

      // clean all options (to another try...)
      // for testing purpose comment the following line
      cleanAllAnswers();
   }

   /**
    * Set the header questions.
    */
   private void setQuestionHeaders() {
      TextView lblQt = (TextView) findViewById(R.id.lbl_qt1);
      lblQt.setText(getResources().getString(R.string.str_question) + " 1:");
      lblQt = (TextView) findViewById(R.id.lbl_qt2);
      lblQt.setText(getResources().getString(R.string.str_question) + " 2:");
      lblQt = (TextView) findViewById(R.id.lbl_qt3);
      lblQt.setText(getResources().getString(R.string.str_question) + " 3:");
      lblQt = (TextView) findViewById(R.id.lbl_qt4);
      lblQt.setText(getResources().getString(R.string.str_question) + " 4:");
      lblQt = (TextView) findViewById(R.id.lbl_qt5);
      lblQt.setText(getResources().getString(R.string.str_question) + " 5:");
      lblQt = (TextView) findViewById(R.id.lbl_qt6);
      lblQt.setText(getResources().getString(R.string.str_question) + " 6:");
      lblQt = (TextView) findViewById(R.id.lbl_qt7);
      lblQt.setText(getResources().getString(R.string.str_question) + " 7:");
      lblQt = (TextView) findViewById(R.id.lbl_qt8);
      lblQt.setText(getResources().getString(R.string.str_question) + " 8:");
   }

   /**
    * Clean all selections and answer made by the user
    */
   private void cleanAllAnswers() {
      CheckBox chkOption;
      RadioButton rdbOption;
      EditText txtAnswer;

      // clean selections on question 1
      chkOption = (CheckBox) findViewById(R.id.chk_opt1_1);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt1_2);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt1_3);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt1_4);
      chkOption.setChecked(false);
      // clean answer on question 2
      txtAnswer = (EditText) findViewById(R.id.txt_opt2_1);
      txtAnswer.setText("");
      // clean the selection on question 3
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_1);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_2);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_3);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_4);
      rdbOption.setChecked(false);
      // clean selections on question 4
      chkOption = (CheckBox) findViewById(R.id.chk_opt4_1);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt4_2);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt4_3);
      chkOption.setChecked(false);
      chkOption = (CheckBox) findViewById(R.id.chk_opt4_4);
      chkOption.setChecked(false);
      // clean the selection on question 5
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_1);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_2);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_3);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_4);
      rdbOption.setChecked(false);
      // clean the selection on question 6
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_1);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_2);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_3);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_4);
      rdbOption.setChecked(false);
      // clean the selection on question 7
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_1);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_2);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_3);
      rdbOption.setChecked(false);
      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_4);
      rdbOption.setChecked(false);
      // clean answers on question 8
      txtAnswer = (EditText) findViewById(R.id.txt_opt8_1);
      txtAnswer.setText("");
      txtAnswer = (EditText) findViewById(R.id.txt_opt8_2);
      txtAnswer.setText("");
   }

   /**
    * Validate the quantity of options selected (Checkbox type).
    *
    * @return true if the user selected correctly the options.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ1() {
      int qtySelected = 0;

      // count the selected options
      CheckBox chkOption = (CheckBox) findViewById(R.id.chk_opt1_1);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt1_2);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt1_3);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt1_4);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      // check the quantity of selected options
      if (qtySelected != 2) {
         Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error2) + " 1.", Toast.LENGTH_LONG).show();
         return false;
      }
      else {
         return true;
      }
   }

   /**
    * Validate if the user wrote something (EditText type).
    *
    * @return true if the user answered. Otherwise, return false.
    */
   private boolean validateAnswerQ2() {
      // count the selected options
      EditText txtAnswer = (EditText) findViewById(R.id.txt_opt2_1);
      if (txtAnswer.getText().toString().isEmpty()) {
         Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error_text2) + " 2.", Toast.LENGTH_LONG).show();
         return false;
      }
      else {
         return true;
      }
   }

   /**
    * Validate the user selected on option (RadioButton type).
    *
    * @return true if the user selected one option.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ3() {
      // check if one option is selected
      RadioButton rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_1);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_2);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_3);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt3_4);
      if (rdbOption.isChecked()) {
         return true;
      }

      // if we are here then no option has been selected
      Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error1) + " 3.", Toast.LENGTH_LONG).show();
      return false;
   }

   /**
    * Validate the quantity of options selected (Checkbox type).
    *
    * @return true if the user selected correctly the options.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ4() {
      int qtySelected = 0;

      // count the selected options
      CheckBox chkOption = (CheckBox) findViewById(R.id.chk_opt4_1);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt4_2);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt4_3);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      chkOption = (CheckBox) findViewById(R.id.chk_opt4_4);
      if (chkOption.isChecked()) {
         qtySelected++;
      }

      // check the quantity of selected options
      if (qtySelected != 3) {
         Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error3) + " 4.", Toast.LENGTH_LONG).show();
         return false;
      }
      else {
         return true;
      }
   }

   /**
    * Validate the user selected on option (RadioButton type).
    *
    * @return true if the user selected one option.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ5() {
      // check if one option is selected
      RadioButton rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_1);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_2);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_3);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt5_4);
      if (rdbOption.isChecked()) {
         return true;
      }

      // if we are here then no option has been selected
      Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error1) + " 5.", Toast.LENGTH_LONG).show();
      return false;
   }

   /**
    * Validate the user selected on option (RadioButton type).
    *
    * @return true if the user selected one option.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ6() {
      // check if one option is selected
      RadioButton rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_1);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_2);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_3);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt6_4);
      if (rdbOption.isChecked()) {
         return true;
      }

      // if we are here then no option has been selected
      Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error1) + " 6.", Toast.LENGTH_LONG).show();
      return false;
   }

   /**
    * Validate the user selected on option (RadioButton type).
    *
    * @return true if the user selected one option.
    * Otherwise, return false.
    */
   private boolean validateAnswerQ7() {
      // check if one option is selected
      RadioButton rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_1);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_2);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_3);
      if (rdbOption.isChecked()) {
         return true;
      }

      rdbOption = (RadioButton) findViewById(R.id.rdb_opt7_4);
      if (rdbOption.isChecked()) {
         return true;
      }

      // if we are here then no option has been selected
      Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error1) + " 7.", Toast.LENGTH_LONG).show();
      return false;
   }

   /**
    * Validate if the user write something (EditText type).
    *
    * @return true if the user answered. Otherwise, return false.
    */
   private boolean validateAnswerQ8() {
      String word1, word2;
      EditText txtAnswer = (EditText) findViewById(R.id.txt_opt8_1);
      word1 = txtAnswer.getText().toString();

      txtAnswer = (EditText) findViewById(R.id.txt_opt8_2);
      word2 = txtAnswer.getText().toString();
      if (word1.isEmpty() || word2.isEmpty()) {
         Toast.makeText(getApplicationContext(), getResources().getString(R.string.str_error_text8) + " 8.", Toast.LENGTH_LONG).show();
         return false;
      }
      else {
         return true;
      }
   }

   /**
    * Grade the question 1 (Checkbox type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ1() {
      int grade = 0;

      CheckBox chkOption1 = (CheckBox) findViewById(R.id.chk_opt1_1);
      CheckBox chkOption2 = (CheckBox) findViewById(R.id.chk_opt1_2);
      CheckBox chkOption3 = (CheckBox) findViewById(R.id.chk_opt1_3);
      CheckBox chkOption4 = (CheckBox) findViewById(R.id.chk_opt1_4);

      // correct answer: option 1 and 3
      if (chkOption1.isChecked() && chkOption3.isChecked()) {
         grade = 1;
      }
      // if other option is selected, the answer is incorrect (not necessary, just for clarification)
      if (chkOption2.isChecked() || chkOption4.isChecked()) {
         grade = 0;
      }

      return grade;
   }

   /**
    * Grade the question 5 (EditText type)
    *
    * @return 2 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ2() {
      EditText txtAnswer = (EditText) findViewById(R.id.txt_opt2_1);
      // correct answer: 255.255.248.0
      if (txtAnswer.getText().toString().trim().equals("255.255.248.0")) {
         return 2;
      }
      else {
         return 0;
      }
   }

   /**
    * Grade the question 3 (RadioButton type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ3() {
      RadioButton rdbOption3 = (RadioButton) findViewById(R.id.rdb_opt3_3);
      // correct answer: option 3
      if (rdbOption3.isChecked()) {
         return 1;
      }
      else {
         return 0;
      }
   }

   /**
    * Grade the question 4 (Checkbox type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ4() {
      int grade = 0;

      CheckBox chkOption1 = (CheckBox) findViewById(R.id.chk_opt4_1);
      CheckBox chkOption2 = (CheckBox) findViewById(R.id.chk_opt4_2);
      CheckBox chkOption3 = (CheckBox) findViewById(R.id.chk_opt4_3);
      CheckBox chkOption4 = (CheckBox) findViewById(R.id.chk_opt4_4);

      // correct answer: option 1, 2 and 3
      if (chkOption1.isChecked() && chkOption2.isChecked() && chkOption3.isChecked()) {
         grade = 1;
      }
      // if other the option is selected, the answer is incorrect (not necessary, just for clarification)
      if (chkOption4.isChecked()) {
         grade = 0;
      }

      return grade;
   }

   /**
    * Grade the question 5 (RadioButton type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ5() {
      RadioButton rdbOption4 = (RadioButton) findViewById(R.id.rdb_opt5_4);
      // correct answer: option 1
      if (rdbOption4.isChecked()) {
         return 1;
      }
      else {
         return 0;
      }
   }

   /**
    * Grade the question 6 (RadioButton type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ6() {
      RadioButton rdbOption1 = (RadioButton) findViewById(R.id.rdb_opt6_1);
      // correct answer: option 1
      if (rdbOption1.isChecked()) {
         return 1;
      }
      else {
         return 0;
      }
   }

   /**
    * Grade the question 7 (RadioButton type)
    *
    * @return 1 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ7() {
      RadioButton rdbOption3 = (RadioButton) findViewById(R.id.rdb_opt7_3);
      // correct answer: option 3
      if (rdbOption3.isChecked()) {
         return 1;
      }
      else {
         return 0;
      }
   }

   /**
    * Grade the question 8 (EditText type)
    *
    * @return 2 if the answer is correct. Otherwise, return 0.
    */
   private int gradeQ8() {
      int grade = 0;
      String answer;
      // possibles answers to network layer
      String[] net = {"IP address", "Routing"};
      // possibles answers to transport layer
      String[] transport = {"UDP protocol", "Segments"};

      // get the answer in uppercase to compare
      EditText txtAnswer1 = (EditText) findViewById(R.id.txt_opt8_1);
      answer = txtAnswer1.getText().toString().trim().toUpperCase();
      // find if the user selected one of the correct words
      for (int idx = 0; idx < net.length; idx++) {
         if (answer.equals(net[idx].toUpperCase())) {
            grade++;
            break;
         }
      }

      // get the answer in uppercase to compare
      EditText txtAnswer2 = (EditText) findViewById(R.id.txt_opt8_2);
      answer = txtAnswer2.getText().toString().trim().toUpperCase();
      // find if the user selected one of the correct words
      for (int idx = 0; idx < transport.length; idx++) {
         if (answer.equals(transport[idx].toUpperCase())) {
            grade++;
            break;
         }
      }
      return grade;
   }
}