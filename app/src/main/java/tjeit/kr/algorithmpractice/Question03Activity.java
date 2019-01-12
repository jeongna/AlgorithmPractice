package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question03Activity extends BaseActivity {

    private android.widget.Button twoBtn;
    private android.widget.Button threeBtn;
    private android.widget.Button fourBtn;
    private android.widget.Button fiveBtn;
    private android.widget.Button sixBtn;
    private android.widget.Button sevenBtn;
    private android.widget.Button eightBtn;
    private android.widget.Button nineBtn;
    private android.widget.Button totalBtn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question03);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2 * 1 = 2
                // ...
                // 2 * 9 = 18 까지를 resultTxt에 출력.

//                이 String 변수를 가공해서 최종 결과를 resultTxt의 text로 지정
                String gugudanStr = "";

                for (int i=1 ; i <= 9 ; i++) {
                    gugudanStr += String.format("%d * %d = %d\n" , 2, i, 2*i);
                }

                resultTxt.setText(gugudanStr);

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.totalBtn = (Button) findViewById(R.id.totalBtn);
        this.nineBtn = (Button) findViewById(R.id.nineBtn);
        this.eightBtn = (Button) findViewById(R.id.eightBtn);
        this.sevenBtn = (Button) findViewById(R.id.sevenBtn);
        this.sixBtn = (Button) findViewById(R.id.sixBtn);
        this.fiveBtn = (Button) findViewById(R.id.fiveBtn);
        this.fourBtn = (Button) findViewById(R.id.fourBtn);
        this.threeBtn = (Button) findViewById(R.id.threeBtn);
        this.twoBtn = (Button) findViewById(R.id.twoBtn);
    }
}
