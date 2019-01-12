package tjeit.kr.algorithmpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private android.widget.Button question01Btn;
    private Button question02Btn;
    private Button question03Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        question01Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Question01Activity.class);
                startActivity(intent);
            }
        });

        question02Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext , Question02Activity.class);
                startActivity(intent);
            }
        });

        question03Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Question03Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.question03Btn = (Button) findViewById(R.id.question03Btn);
        this.question02Btn = (Button) findViewById(R.id.question02Btn);
        this.question01Btn = (Button) findViewById(R.id.question01Btn);
    }
}
