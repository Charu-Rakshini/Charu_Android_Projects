package charulatha.vijayakumar.diceroll;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int sideUp, numOfDice, numOfDiceId, numofSides, numofSidesId;
    TextView diceResult1, diceResult2,tvDice1Desc, tvDice2Desc, tvPrvRolls;
    RadioGroup diceTypeGroup, radioGroupNumDice;
    Button btnRollDice;
    RadioButton rdBtnCustom,rdBtn4, rdBtn6, rdBtn8, rdBtn10, rdBtn12, rdBtn20, rdBtn10x;
    EditText edTxtCustom;
    String currRolls, prvRolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRollDice = findViewById(R.id.btnRollDice);
        rdBtnCustom = findViewById(R.id.rBtnCustom);
        rdBtn4 = findViewById(R.id.rBtn4);
        rdBtn6 = findViewById(R.id.rBtn6);
        rdBtn8 = findViewById(R.id.rBtn8);
        rdBtn10 = findViewById(R.id.rBtn10);
        rdBtn12 = findViewById(R.id.rBtn12);
        rdBtn20 = findViewById(R.id.rBtn20);
        rdBtn10x = findViewById(R.id.rBtn10x);


        diceTypeGroup = (RadioGroup) findViewById(R.id.radioGroupDiceType);
        //diceTypeGroup.setOnClickListener(this);

        radioGroupNumDice = (RadioGroup) findViewById(R.id.radioGroupNumDice);

        btnRollDice.setOnClickListener(this);
        rdBtnCustom.setOnClickListener(this);
        rdBtn4.setOnClickListener(this);
        rdBtn6.setOnClickListener(this);
        rdBtn8.setOnClickListener(this);
        rdBtn10.setOnClickListener(this);
        rdBtn12.setOnClickListener(this);
        rdBtn20.setOnClickListener(this);
        rdBtn10x.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        diceTypeGroup =  (RadioGroup) findViewById(R.id.radioGroupDiceType);
        radioGroupNumDice = (RadioGroup) findViewById(R.id.radioGroupNumDice);
        rdBtnCustom = findViewById(R.id.rBtnCustom);
        edTxtCustom = findViewById(R.id.editTextCustomDice);
        numOfDiceId= radioGroupNumDice.getCheckedRadioButtonId();
        if (numOfDiceId==R.id.radioBtnOneDice){
            numOfDice=1;
        }
        else if(numOfDiceId==R.id.radioBtnTwoDice){
            numOfDice=2;
        }
        if(v.getId()==R.id.rBtnCustom){
            // previously invisible view
            View myView = findViewById(R.id.editTextCustomDice);

            // Check if the runtime version is at least Lollipop
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // get the center for the clipping circle
                int cx = myView.getWidth() / 2;
                int cy = myView.getHeight() / 2;

                // get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius);

                // make the view visible and start the animation
                myView.setVisibility(View.VISIBLE);
                anim.start();
            } else {
                // set the view to invisible without a circular reveal animation below Lollipop
                myView.setVisibility(View.INVISIBLE);
            }

           // edTxtCustom.setVisibility(View.VISIBLE);
        }
        else if((v.getId()==R.id.rBtn4)||(v.getId()==R.id.rBtn6)||(v.getId()==R.id.rBtn8)||(v.getId()==R.id.rBtn10)||(v.getId()==R.id.rBtn12)||(v.getId()==R.id.rBtn20)||(v.getId()==R.id.rBtn10x)){
            edTxtCustom.setVisibility(View.INVISIBLE);
        }

        numofSidesId= diceTypeGroup.getCheckedRadioButtonId();
        switch (numofSidesId){
            case R.id.rBtn4:
                numofSides=4;
                break;
            case R.id.rBtn6:
                numofSides=6;
                break;
            case R.id.rBtn8:
                numofSides=8;
                break;
            case R.id.rBtn10:
                numofSides=10;
                break;
            case R.id.rBtn12:
                numofSides=12;
                break;
            case R.id.rBtn20:
                numofSides=20;
                break;
            case R.id.rBtn10x:
                numofSides=100;
                break;
            case R.id.rBtnCustom:
                if(edTxtCustom.getVisibility()==View.VISIBLE){
                    String customSide = edTxtCustom.getText().toString();
                    if(!(customSide.isEmpty())){
                        numofSides=Integer.parseInt(customSide);
                    }
                    else{
                        numofSides=1;
                    }

                }

                break;
        }

        switch (v.getId()){
            case R.id.btnRollDice:
                if(numofSides==100){
                    roll1(10, true);
                }else{
                    roll1(numofSides,false);
                }

                if (numOfDice==2){
                    if(numofSides==100){
                        roll2(10, true);
                    }else{
                        roll2(numofSides,false);
                    }
                }
                else {
                    diceResult2 = findViewById(R.id.tvRollRes2);
                    diceResult2.setVisibility(View.INVISIBLE);
                    tvDice2Desc = findViewById(R.id.tvDice2Desc);
                    tvDice2Desc.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }


    public int roll1(int numSides, boolean flag10x){


        diceResult1 = findViewById(R.id.tvRollRes1);
        sideUp= 1+((int)(Math.random()*100) % numSides);
        if(flag10x){
            diceResult1.setText(String.valueOf(sideUp).toString()+"0");
            //updatePrevRolls(Integer.parseInt())
            updatePrevRolls(Integer.parseInt(String.valueOf(sideUp).toString()+"0"));
        }else{
            diceResult1.setText(String.valueOf(sideUp).toString());
            updatePrevRolls(sideUp);
        }

        tvDice1Desc = findViewById(R.id.tvDice1Desc);
        tvDice1Desc.setVisibility(View.VISIBLE);

        // previously invisible view
        View myView = findViewById(R.id.tvRollRes1);

// Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the final radius for the clipping circle
            float finalRadius = (float) Math.hypot(cx, cy);

            // create the animator for this view (the start radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius);

            // make the view visible and start the animation
            myView.setVisibility(View.VISIBLE);
            anim.start();
        } else {
            // set the view to invisible without a circular reveal animation below Lollipop
            myView.setVisibility(View.INVISIBLE);
        }

        return sideUp;
    }

    public int roll2(int numSides, boolean flag10x){

        diceResult2 = findViewById(R.id.tvRollRes2);
        sideUp= 1+((int)(Math.random()*100) % numSides);

        if(flag10x){
            diceResult2.setText(String.valueOf(sideUp).toString()+"0");
            updatePrevRolls(Integer.parseInt(String.valueOf(sideUp).toString()+"0"));
        }else{
            diceResult2.setText(String.valueOf(sideUp).toString());
            updatePrevRolls(sideUp);
        }
//        diceResult2.setText(String.valueOf(sideUp).toString());

        tvDice2Desc = findViewById(R.id.tvDice2Desc);
        tvDice2Desc.setVisibility(View.VISIBLE);
        // previously invisible view
        View myView = findViewById(R.id.tvRollRes2);

// Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the final radius for the clipping circle
            float finalRadius = (float) Math.hypot(cx, cy);

            // create the animator for this view (the start radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius);

            // make the view visible and start the animation
            myView.setVisibility(View.VISIBLE);
            anim.start();
        } else {
            // set the view to invisible without a circular reveal animation below Lollipop
            myView.setVisibility(View.INVISIBLE);
        }


        //System.out.println("The random value of the "+numSides+" side dice is "+sideUp);
        return sideUp;
    }

    public void updatePrevRolls(int currRoll){
        tvPrvRolls= findViewById(R.id.tvPrvRolls);
        prvRolls= tvPrvRolls.getText().toString();
        if(!(prvRolls.isEmpty())){
            //String[] rollArray=prvRolls.split(",");
            currRolls=prvRolls+", "+ String.valueOf(currRoll);
            tvPrvRolls.setText(currRolls.toString());
        }else {
            tvPrvRolls.setText(String.valueOf(currRoll).toString());
        }



    }

}