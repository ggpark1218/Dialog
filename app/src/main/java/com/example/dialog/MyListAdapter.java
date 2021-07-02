package com.example.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder>{

    Context context;
    ArrayList<String> data;

    MyListAdapter(Context context,ArrayList<String> data){
        this.context = context;
        this.data = data;
    }

    //뷰홀더 만들기
   @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewHolder = inflater.inflate(R.layout.list_item, null);
        return new MyListViewHolder(viewHolder);
    }

    //값 세팅
    //position 현재 몇번째 데이턴지 정보가 온다
    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListViewHolder holder, int position) {
        holder.tv.setText(data.get(position).toString());
    }

    //뷰홀더 만들고 값세팅 하는거 개수만큼 함
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvTitle);
            tv.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            tv.setText("Clicked! - "  + tv.getText().toString());
        }
    }
}
