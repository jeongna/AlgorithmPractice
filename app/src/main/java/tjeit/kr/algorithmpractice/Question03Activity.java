package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

//        2~9단까지는 똑같은 행위를 하는데 숫자만 다른 상황.
//        그 달라지는 숫자를 태그에 메모해두고, 찾아서 활용 이벤트.

        View.OnClickListener guguListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 2 * 1 = 2
                // ...
                // 2 * 9 = 18 까지를 resultTxt에 출력.

//                2단만 출력하는게 아니라, 버튼에 달려있는 Tag를 활용해서
//                상황에 맞는 단을 출력.
//                v가 가지고 있는 태그를 조회하면, 몇단이 눌렸는지 유추 가능.
//                XML에 적은 태그는 기본적으로 String 형태로 뽑힘.

                String danStr = v.getTag().toString();
//                Toast.makeText(mContext, danStr, Toast.LENGTH_SHORT).show();

//                Tag : String -> for : int 로 변환.
//                Integer 클래스를 활용 : String을 int로 변환.
                int dan = Integer.parseInt(danStr);



//                이 String 변수를 가공해서 최종 결과를 resultTxt의 text로 지정
                String gugudanStr = "";

                for (int i=1 ; i <= 9 ; i++) {
                    gugudanStr += String.format("%d * %d = %d\n" , dan, i, dan*i);
                }

                resultTxt.setText(gugudanStr);

            }
        };

        twoBtn.setOnClickListener(guguListener);
        threeBtn.setOnClickListener(guguListener);
        fourBtn.setOnClickListener(guguListener);
        fiveBtn.setOnClickListener(guguListener);
        sixBtn.setOnClickListener(guguListener);
        sevenBtn.setOnClickListener(guguListener);
        eightBtn.setOnClickListener(guguListener);
        nineBtn.setOnClickListener(guguListener);


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
