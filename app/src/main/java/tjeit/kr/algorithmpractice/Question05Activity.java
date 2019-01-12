package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Question05Activity extends BaseActivity {

//    컴퓨터가 출제한 문제 (3개의 숫자가 저장)
    int[] questionIntArray = new int[3];


    private android.widget.ListView chatListView;
    private android.widget.EditText numInputEdt;
    private android.widget.Button okBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question05);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        화면을 키면 컴퓨터가 바로 문제를 출제.
        makeQuestionNumbers();

    }

    void makeQuestionNumbers() {
//        문제의 조건. 3자리 숫자를 생각.
//        1) 매번 그때그때 다른 값. => Math.Random()
//        2) 0은 사용하지 않을 생각. 1~9로만 구성.
//        3) 중복된 숫자가 있으면 안됨. 121 X.

//        문제를 만드는 방식
//        맨 앞자리를 1~9 사이의 숫자로 채움.
//        이 행위를 3번 반복. (앞, 가운데, 뒤)
//        만들어진 숫자를 봤을때 중복된 숫자가 있는지?
//        중복된 숫자가 있다면 3자리 숫자를 다시 생성.

//        조건을 만족시킬때까지 무한반복.
//        조건이 만족되면 break; 를 이용해 while문에서 탈출.
        while (true) {

//            앞 / 가운데 / 뒷자리 순서대로 랜덤값을 채우는 반복문.
            for (int i=0 ; i < 3 ; i++) {

//                Math.random() => 0.0+1 <= 랜덤숫자*9+1 < 9.0+1사이의 숫자가 랜덤으로 발생.
//                1~9 의 숫자를 랜덤으로 뽑아서 대입.
                questionIntArray[i] = (int) (Math.random() * 9 + 1);

            }

//            112, 211, 121 을 모두 피해야 중복이 아님.
            if ((questionIntArray[0] != questionIntArray[1])
                    && (questionIntArray[1] != questionIntArray[2])
                    && (questionIntArray[0] != questionIntArray[2])) {
//                무한반복을 탈출.
                break;
            }

        }

//        임시로 값을 확인
        String temp = String.format("%d%d%d", questionIntArray[0], questionIntArray[1], questionIntArray[2]);

        numInputEdt.setText(temp);

    }

    @Override
    public void bindViews() {

        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.numInputEdt = (EditText) findViewById(R.id.numInputEdt);
        this.chatListView = (ListView) findViewById(R.id.chatListView);
    }
}
