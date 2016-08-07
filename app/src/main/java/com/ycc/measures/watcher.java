package com.ycc.measures;


import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigDecimal;

public class watcher implements TextWatcher {
    private CharSequence charSequence;
    private int editStart;
    private int editEnd;
    private int ID;
    private EditText et1,et2,et3,et4,et5;
    private Double ss;
    private String str1;




     watcher(EditText et1,EditText et2,EditText et3,int ID){
         this.et1=et1;
         this.et2=et2;
         this.et3=et3;
         this.ID=ID;
    }

    watcher(EditText et1,EditText et2,EditText et3,EditText et4,EditText et5,int ID){
        this.et1=et1;
        this.et2=et2;
        this.et3=et3;
        this.et4=et4;
        this.et5=et5;
        this.ID=ID;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        charSequence = s;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Double temp1;
        Double temp2;
        BigDecimal a;
        BigDecimal b;
        str1 = et1.getText().toString();
        if (str1.equals("")&&ID<3){
            et2.setText("");
            et3.setText("");
        }else if (str1.equals("")&&ID>2){
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
        }else {
            switch(ID){
                case 0:
                    ss = Double.parseDouble(str1);
                    a = new BigDecimal(ss*0.03);
                    temp2 = (ss*0.3+7);
                    temp1 = a.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                    et2.setText(String.valueOf(temp1));
                    et3.setText(String.valueOf(Math.round(temp2)));
                break;
                case 1:
                    ss = Double.parseDouble(str1);
                    a = new BigDecimal(ss/0.03);
                    temp2 = ss+7;
                    temp1 = a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                    et2.setText(String.valueOf(temp1));
                    et3.setText(String.valueOf(Math.round(temp2)));
                break;
                case 2:
                    ss = Double.parseDouble(str1);
                    a = new BigDecimal((ss-7)/0.3);
                    b = new BigDecimal((ss-7)/10);
                    temp1 = a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                    temp2 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                    et2.setText(String.valueOf(temp1));
                    et3.setText(String.valueOf(temp2));
                    break;
                case 3:
                    ss = Double.parseDouble(str1);
                        if(ss>=230){
                            et2.setText(String.valueOf(ss/10-18));
                            et3.setText(String.valueOf(ss/5-10));
                            et4.setText(String.valueOf(ss/10-18.5));
                            et5.setText(String.valueOf(ss/10));
                        }
                    break;
                case 4:
                    ss = Double.parseDouble(str1);
                    if(ss>=5){
                        et2.setText(String.valueOf((ss+18)*10));
                    et3.setText(String.valueOf((ss+18)*2-10));
                    et4.setText(String.valueOf(ss-0.5));
                    et5.setText(String.valueOf(ss+18));}
                    break;
                case 5:
                    ss = Double.parseDouble(str1);
                    if(ss>=38){
                    et2.setText(String.valueOf((ss+10)*5));
                    et3.setText(String.valueOf(ss/2-13));
                    et4.setText(String.valueOf(ss/2-13.5));
                    et5.setText(String.valueOf(ss-15));}
                    break;
                case 6:
                    ss = Double.parseDouble(str1);
                    if(ss>=4.5){
                        et2.setText(String.valueOf((ss+18.5)*10));
                    et3.setText(String.valueOf(ss+0.5));
                    et4.setText(String.valueOf((ss+18.5)*2-10));
                    et5.setText(String.valueOf(ss+18.5));}
                    break;
                case 7:
                    ss = Double.parseDouble(str1);
                    if(ss>=23){
                        et2.setText(String.valueOf(ss*10));
                    et3.setText(String.valueOf(ss-18));
                    et4.setText(String.valueOf(ss*2-10));
                    et5.setText(String.valueOf(ss-18.5));}
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
/*        editStart = et1.getSelectionStart();
        editEnd = et1.getSelectionEnd();

        if (charSequence.length() > 6) {
            Toast.makeText(cview, "你输入的字数已经超过了限制！",
                    Toast.LENGTH_SHORT).show();
            s.delete(editStart - 1, editEnd);
            et1.setTextColor(Color.RED);
        }*/
    }

}
