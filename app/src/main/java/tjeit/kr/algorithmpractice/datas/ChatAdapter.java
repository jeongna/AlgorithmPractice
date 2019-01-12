package tjeit.kr.algorithmpractice.datas;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import tjeit.kr.algorithmpractice.R;
import tjeit.kr.algorithmpractice.datas.Chat;

public class ChatAdapter extends ArrayAdapter<Chat> {

    Context mContext;
    List<Chat> mList;
    LayoutInflater inf;

    public ChatAdapter(Context context, List<Chat> list){
        super(context, R.layout.chat_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.chat_list_item, null);
        }

        LinearLayout computerMsgLayout = row.findViewById(R.id.computerMsgLayout);
        TextView computerMsgTxt = row.findViewById(R.id.computerMsgTxt);
        LinearLayout userMsgLayout = row.findViewById(R.id.userMsgLayout);
        TextView userMsgTxt = row.findViewById(R.id.userMsgTxt);

        Chat data = mList.get(position);

//        data가 가진 sender를 봤을때 computer / user 두가지 경우가 존재

        if (data.getSender().equals("user")){
//            사용자가 입력한 메세지
            computerMsgLayout.setVisibility(View.GONE);
            userMsgLayout.setVisibility(View.VISIBLE);

            userMsgTxt.setText(data.getMessage());
        }
        else {
//            컴퓨터가 입력한 메세지
            userMsgLayout.setVisibility(View.GONE);
            computerMsgLayout.setVisibility(View.VISIBLE);

            computerMsgTxt.setText(data.getMessage());
        }

        return row;
    }
}
