package tjeit.kr.algorithmpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Question05Activity extends BaseActivity {

//    컴퓨터가 출제한 문제 (3개의 숫자가 저장)
    int[] questionIntArray = new int[3];

//    사용자가 몇번이나 정답을 시도했는지
    int userTryCount = 0;


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

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserNumber();
            }
        });

    }

//    ?S ?B인지 체크하는 메쏘드
    void checkUserNumber() {

//        시도 횟수를 1 증가.
        userTryCount++;

//        세자리가 아닐경우 다시 입력하게 Toast

        if (numInputEdt.length() != 3) {
            Toast.makeText(mContext, "3자리 숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }

//        사용자가 입력한 숫자를 저장할 세칸짜리 배열.
//        152 => [1],[5],[2]
        int[] userInputIntArray = new int[3];

//        사용자가 입력한 값을 String으로 따내자.
        String inputStr = numInputEdt.getText().toString();

//        배열에 각 자리의 숫자를 집어넣기.

//        먼저, String -> 숫자로 변경. "512" => 512 % 100 / 10 = 12 /10 = 1
        int inputNumber = Integer.parseInt(inputStr);

//        0번칸 : 맨 앞자리를 대입하는 방법?
        userInputIntArray[0] = inputNumber / 100;

//        1번칸 : 가운데 자리를 따내는 방법?
        userInputIntArray[1] = inputNumber % 100 / 10;

//        2번칸 : 맨 뒷자리를 따내는 방법?
        userInputIntArray[2] = inputNumber % 10;


//        숫자를 다 집어넣었으면, 실제로 정답과 비교해서 ?S ?B인지 계산.

        // ?S인지 저장될 변수
        int strikeCount = 0;
//        ?B인지 저장될 변수
        int ballCount = 0;

//        i : 사용자가 입력한 값을 담당하는 index
        for (int i=0 ; i < 3; i++) {

//            j : 정답지를 돌아보는 index
            for (int j=0 ; j<3 ; j++) {

//                숫자가 같은걸 발견!
                if (userInputIntArray[i] == questionIntArray[j]) {
                    if (i == j) {
//                        위치도 같다! strike 갯수 증가
                        strikeCount++;
                    }
                    else {
//                        숫자는 같지만, 위치는 다르다!
//                        ball 카운트를 증가.

                        ballCount++;
                    }

                }

            }

        }

//        임시로 토스트에 S/B 출력
        String temp = String.format("%d S %d B 입니다.", strikeCount, ballCount);
        Toast.makeText(mContext, temp, Toast.LENGTH_SHORT).show();


        if (strikeCount == 3) {
            Toast.makeText(mContext, "정답입니다.!", Toast.LENGTH_SHORT).show();
            Toast.makeText(mContext, userTryCount+"번 만에 맞췄습니다.", Toast.LENGTH_SHORT).show();
        }

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
