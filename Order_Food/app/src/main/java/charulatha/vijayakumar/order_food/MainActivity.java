package charulatha.vijayakumar.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPay, btnSaveLater, btnPlus1, btnPlus2, btnPlus3, btnPlus4, btnPlus5, btnPlus6, btnPlus7, btnMinus1, btnMinus2, btnMinus3, btnMinus4, btnMinus5, btnMinus6, btnMinus7;
    TextView tvQty1, tvQty2, tvQty3, tvQty4, tvQty5, tvQty6, tvQty7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus1 = findViewById(R.id.btnPlus1);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnPlus3 = findViewById(R.id.btnPlus3);
        btnPlus4 = findViewById(R.id.btnPlus4);
        btnPlus5 = findViewById(R.id.btnPlus5);
        btnPlus6 = findViewById(R.id.btnPlus6);
        btnPlus7 = findViewById(R.id.btnPlus7);

        btnMinus1 = findViewById(R.id.btnMinus1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnMinus3 = findViewById(R.id.btnMinus3);
        btnMinus4 = findViewById(R.id.btnMinus4);
        btnMinus5 = findViewById(R.id.btnMinus5);
        btnMinus6 = findViewById(R.id.btnMinus6);
        btnMinus7 = findViewById(R.id.btnMinus7);

        btnPay = findViewById(R.id.btnPay);
        btnSaveLater = findViewById(R.id.btnSave);


        btnPlus1.setOnClickListener(this);
        btnPlus2.setOnClickListener(this);
        btnPlus3.setOnClickListener(this);
        btnPlus4.setOnClickListener(this);
        btnPlus5.setOnClickListener(this);
        btnPlus6.setOnClickListener(this);
        btnPlus7.setOnClickListener(this);
        btnMinus1.setOnClickListener(this);
        btnMinus2.setOnClickListener(this);
        btnMinus3.setOnClickListener(this);
        btnMinus4.setOnClickListener(this);
        btnMinus5.setOnClickListener(this);
        btnMinus6.setOnClickListener(this);
        btnMinus7.setOnClickListener(this);










    }

    @Override
    public void onClick(View v) {
        String currQty;
        switch (v.getId()){
            case R.id.btnPlus1:
                tvQty1=findViewById(R.id.fQuantity1);
                currQty = tvQty1.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty1.setText(currQty);
                break;

            case R.id.btnPlus2:
                tvQty2=findViewById(R.id.fQuantity2);
                currQty = tvQty2.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty2.setText(currQty);
                break;

            case R.id.btnPlus3:
                tvQty3=findViewById(R.id.fQuantity3);
                currQty = tvQty3.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty3.setText(currQty);
                break;

            case R.id.btnPlus4:
                tvQty4=findViewById(R.id.fQuantity4);
                currQty = tvQty4.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty4.setText(currQty);
                break;

            case R.id.btnPlus5:
                tvQty5=findViewById(R.id.fQuantity5);
                currQty = tvQty5.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty5.setText(currQty);
                break;
            case R.id.btnPlus6:
                tvQty6=findViewById(R.id.fQuantity6);
                currQty = tvQty6.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty6.setText(currQty);
                break;
            case R.id.btnPlus7:
                tvQty7=findViewById(R.id.fQuantity7);
                currQty = tvQty7.getText().toString();
                currQty= String.valueOf((Integer.parseInt(currQty))+1);
                tvQty7.setText(currQty);
                break;

            case R.id.btnMinus1:
                tvQty1=findViewById(R.id.fQuantity1);
                currQty = tvQty1.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty1.setText(currQty);
                break;

            case R.id.btnMinus2:
                tvQty2=findViewById(R.id.fQuantity2);
                currQty = tvQty2.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty2.setText(currQty);
                break;

            case R.id.btnMinus3:
                tvQty3=findViewById(R.id.fQuantity3);
                currQty = tvQty3.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty3.setText(currQty);
                break;

            case R.id.btnMinus4:
                tvQty4=findViewById(R.id.fQuantity4);
                currQty = tvQty4.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty4.setText(currQty);
                break;

            case R.id.btnMinus5:
                tvQty5=findViewById(R.id.fQuantity5);
                currQty = tvQty5.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty5.setText(currQty);
                break;
            case R.id.btnMinus6:
                tvQty6=findViewById(R.id.fQuantity6);
                currQty = tvQty6.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty6.setText(currQty);
                break;
            case R.id.btnMinus7:
                tvQty7=findViewById(R.id.fQuantity7);
                currQty = tvQty7.getText().toString();
                if(!(currQty.contentEquals("0"))){
                    currQty= String.valueOf((Integer.parseInt(currQty))-1);
                }
                tvQty7.setText(currQty);
                break;
        }
    }
}