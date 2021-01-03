package net.inete.tgpsi.jcarvalho.abnd_project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_score);

      TextView lblMsg = (TextView) findViewById(R.id.lbl_congrats);
      RatingBar rtbGrade = (RatingBar) findViewById(R.id.rtb_grade);

      Intent i = getIntent();
      int grade = i.getIntExtra("final_grade", 0);

      String msg = "You had " + grade + " points.\n";
      if (grade < 5) {
         msg += "Try again!";
         lblMsg.setTextColor(Color.argb(255, 195, 24, 91));
      }
      else {
         if (grade <= 9) {
            msg += "Congratulations! Now, try the perfect score.";
         }
         else {
            msg += "Congratulations! Perfect score!!";
            lblMsg.setTextColor(Color.argb(255, 0, 105, 92));
         }
      }

      lblMsg.setText(msg);
      rtbGrade.setRating(grade / 2.0F);

      // REQUIRED: Toast with the results of the quiz
      Toast toast = Toast.makeText(getApplicationContext(), "You had " + grade + " points in 10.", Toast.LENGTH_LONG);
      toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 24);
      toast.show();

   }
}