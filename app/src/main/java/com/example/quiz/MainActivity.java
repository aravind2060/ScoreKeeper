package com.example.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private int score=0;
    EditText name;
    RadioGroup question1,question2,question5;
    RadioButton ques1_option1,ques1_option2,ques1_option3,ques1_option4;
    RadioButton ques2_option1,ques2_option2,ques2_option3,ques2_option4;
    CheckBox   ques3_option1,ques3_option2,ques3_option3,ques3_option4;
    EditText ques4_response;
    RadioButton ques5_option1,ques5_option2;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.et_name);

        question1=findViewById(R.id.rg_ques1);
        question2=findViewById(R.id.rg_ques2);
        question5=findViewById(R.id.rg_ques5);

        ques1_option1=findViewById(R.id.rb_ques1_option_1);
        ques1_option2=findViewById(R.id.rb_ques1_option_2);
        ques1_option3=findViewById(R.id.rb_ques1_option_3);
        ques1_option4=findViewById(R.id.rb_ques1_option_4);

        ques2_option1=findViewById(R.id.rb_ques2_option_1);
        ques2_option2=findViewById(R.id.rb_ques2_option_2);
        ques2_option3=findViewById(R.id.rb_ques2_option_3);
        ques2_option4=findViewById(R.id.rb_ques2_option_4);

        ques3_option1=findViewById(R.id.cb_ques3_option1);
        ques3_option2=findViewById(R.id.cb_ques3_option2);
        ques3_option3=findViewById(R.id.cb_ques3_option3);
        ques3_option4=findViewById(R.id.cb_ques3_option4);

        ques4_response=findViewById(R.id.et_ques4);

        ques5_option1=findViewById(R.id.rb_ques5_option1);
        ques5_option2=findViewById(R.id.rb_ques5_option2);

        submit=findViewById(R.id.bn_submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bn_submit:
                showResult();
                break;
        }
    }

    public void showResult()
    {
        String user_name=name.getText().toString();
        int question1_option,question2_option,question5_option;
        question1_option=question1.getCheckedRadioButtonId();
        question2_option=question2.getCheckedRadioButtonId();
        question5_option=question5.getCheckedRadioButtonId();
        chkquestion1(question1_option);
        chkquestion2(question2_option);
        chkquestion5(question5_option);

        if ((ques3_option1.isChecked()) && (ques3_option3.isChecked())) {
            if ((ques3_option2.isChecked() == false) && (ques3_option4.isChecked() == false)) {
                score++;
            }
        }
        String response=ques4_response.getText().toString().toLowerCase().trim();
        if(response.contentEquals("gandhi"))
        {
            score++;
        }

        Toast.makeText(getApplicationContext(),user_name+" you have scored "+score,Toast.LENGTH_LONG).show();
        removeEverything(true);
    }
    public void chkquestion1(int id)
    {
        RadioButton radioButton=findViewById(id);
        if (radioButton==ques1_option1)
        {
           score++;
        }
    }
    public void chkquestion2(int id)
    {
        RadioButton radioButton=findViewById(id);
        if (radioButton==ques2_option1)
        {
            score++;
        }
    }
    public void chkquestion5(int id)
    {
        RadioButton radioButton=findViewById(id);
        if (radioButton==ques5_option1)
        {
            score++;
        }
    }
    public void removeEverything(boolean chk) {
        if (chk) {
            score = 0;
            question1.clearCheck();
            question2.clearCheck();
            question5.clearCheck();
            ques4_response.setText("");
            ques3_option1.setChecked(false);
            ques3_option2.setChecked(false);
            ques3_option3.setChecked(false);
            ques3_option4.setChecked(false);
            name.setText("");
        }

    }
}
