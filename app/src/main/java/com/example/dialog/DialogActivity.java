package com.example.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5;
    int selectedMenu = 0;   //checkeditem 기본값을 0번으로 세
    String menu[] = {"치킨", "피자", "마라탕"};
    boolean checked[] = {true, true, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        init();

    }

    private void init(){
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1){
            displayDialog();
        }
        if(v.getId() == R.id.btn2){
            displayDialog2();
        }
        if(v.getId() == R.id.btn3){
            displayDialog3();
        }
        if(v.getId() == R.id.btn4){
            displayDialog4();
        }
        if(v.getId() == R.id.btn5){
            showDatePicker();
        }


    }

    public void showDatePicker() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string +
                "/" + year_string);

        Toast.makeText(this, "Date: " + dateMessage,
                Toast.LENGTH_SHORT).show();
    }


    private void displayDialog4() {
        //dialog.xml을 view로 만들어줌
        View view = View.inflate(this, R.layout.dialog, null);
        final EditText editText = view.findViewById(R.id.etMsg); //전역변수 처럼 사용

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정의 대화상자 4 ");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(view);

        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("입력한 메세지: " + editText.getText().toString());
            }
        });
        dlg.setPositiveButton("Cancle", null);
        dlg.show();
    }

    private void displayDialog3() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("체크박스 대화상자 3 ");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });

        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String list ="";
                for(int i = 0; i<checked.length; i++){
                    if(checked[i])
                        list = list +" " + menu[i];
                    displayToast(list + " 선택 되었습니다! ");
                }
            }
        });
        dlg.show();
    }

    private void displayDialog2() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("라디오 대화상자 2 ");
        dlg.setSingleChoiceItems(menu, selectedMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedMenu = which;
            }
        });    //피자가 선택되어있음
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu] + " 선택 되었습니다! ");
            }
        });
        dlg.show();
    }

    private void displayDialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본 대화상자 1 ");
        dlg.setMessage("대화상자 메세지 입니다.");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(null);
            }
        });
        dlg.show();
    }

    private void displayToast(String msg) {
        if(msg == null){
            msg = "ok! click!";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}