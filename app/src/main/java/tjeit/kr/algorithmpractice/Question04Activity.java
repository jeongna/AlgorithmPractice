package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question04Activity extends BaseActivity {


    long currentNumber = 0;

    private android.widget.TextView resultTxt;
    private android.widget.Button oneBtn;
    private android.widget.Button twoBtn;
    private android.widget.Button threeBtn;
    private android.widget.Button fourBtn;
    private android.widget.Button fiveBtn;
    private android.widget.Button sixBtn;
    private android.widget.Button sevenBtn;
    private android.widget.Button eightBtn;
    private android.widget.Button nineBtn;
    private android.widget.Button clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question04);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                숫자들을 누르면 기존 숫자의 마지막 자리에 해당 숫자를 이어붙임.
//                11 에서 5를 누름 => 115가 출력.
//                현재 입력된 숫자가 몇인지를 멤버변수로 기록

//                현재값 * 10 + 입력된숫자

                String clickedNumStr = v.getTag().toString();
                long clickedNum = Long.parseLong(clickedNumStr);

                currentNumber = currentNumber * 10 + clickedNum;

                resultTxt.setText(String.valueOf(currentNumber));
            }
        };

        oneBtn.setOnClickListener(numberClickListener);
        twoBtn.setOnClickListener(numberClickListener);
        threeBtn.setOnClickListener(numberClickListener);
        fourBtn.setOnClickListener(numberClickListener);
        fiveBtn.setOnClickListener(numberClickListener);
        sixBtn.setOnClickListener(numberClickListener);
        sevenBtn.setOnClickListener(numberClickListener);
        eightBtn.setOnClickListener(numberClickListener);
        nineBtn.setOnClickListener(numberClickListener);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                초기화 버튼이 눌리면, 현재 입력된 숫자를 0으로 변환.

                currentNumber = 0;

//                화면에도 초기 입력상태로 변경.
                resultTxt.setText("버튼을 눌러 숫자 입력");

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.clearBtn = (Button) findViewById(R.id.clearBtn);
        this.nineBtn = (Button) findViewById(R.id.nineBtn);
        this.eightBtn = (Button) findViewById(R.id.eightBtn);
        this.sevenBtn = (Button) findViewById(R.id.sevenBtn);
        this.sixBtn = (Button) findViewById(R.id.sixBtn);
        this.fiveBtn = (Button) findViewById(R.id.fiveBtn);
        this.fourBtn = (Button) findViewById(R.id.fourBtn);
        this.threeBtn = (Button) findViewById(R.id.threeBtn);
        this.twoBtn = (Button) findViewById(R.id.twoBtn);
        this.oneBtn = (Button) findViewById(R.id.oneBtn);
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
    }
}
