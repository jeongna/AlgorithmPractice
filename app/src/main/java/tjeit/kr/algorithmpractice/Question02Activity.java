package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 2번 문제 : 4가지 형태의 별찍기
 *
 **
 ***


 */

public class Question02Activity extends BaseActivity {

    private android.widget.EditText lineNumEdt;
    private android.widget.Button printStart01Btn;
    private android.widget.Button printStart02Btn;
    private android.widget.Button printStart03Btn;
    private android.widget.Button printStart04Btn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question02);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        printStart01Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStart01();
            }
        });

        printStart02Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStart02();
            }
        });

    }

    void printStart01() {
//        만약 줄수가 4줄

//        *  i : 0  / j :1
//        ** i : 1 / j : 2까지
//        ***
//        ****

        int inputLineNum = Integer.parseInt(lineNumEdt.getText().toString());
        String resultString = "";

        for (int i=0 ; i < inputLineNum ; i++ ) {
            for (int j=0 ; j < i+1 ; j++) {
                resultString += "*";
            }
            resultString += "\n";
        }

        resultTxt.setText(resultString);


    }

    void printStart02() {
//        4줄
//           *  i : 0 / 띄어쓰기 3 (lineNum -1) - i , * 1 (i+1)
//          **  i : 1 / 띄어쓰기 2, * 2
//         ***  i : 2 / 띄어쓰기 1, * 3
//        ****  i : 3 / 띄어쓰기 0, * 4

        int inputLineNum = Integer.parseInt(lineNumEdt.getText().toString());
        String resultString = "";


        for (int i=0 ; i < inputLineNum ; i++) {

//            먼저 띄어쓰기.
            for (int j=0 ; j < inputLineNum -1 -i ; j++) {
                resultString += " ";
            }

//            띄어쓰기가 끝나면 *

            for (int j=0 ; j < i+1 ; j++) {
                resultString += "*";
            }


            resultString += "\n";
        }

        resultTxt.setText(resultString);

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.printStart04Btn = (Button) findViewById(R.id.printStart04Btn);
        this.printStart03Btn = (Button) findViewById(R.id.printStart03Btn);
        this.printStart02Btn = (Button) findViewById(R.id.printStart02Btn);
        this.printStart01Btn = (Button) findViewById(R.id.printStart01Btn);
        this.lineNumEdt = (EditText) findViewById(R.id.lineNumEdt);
    }
}
