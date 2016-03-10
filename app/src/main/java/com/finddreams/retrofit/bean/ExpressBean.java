package com.finddreams.retrofit.bean;

import java.util.ArrayList;
import java.util.List;

/**
*物流信息
*@author finddreams
*@address http://blog.csdn.net/finddreams
*/
public class ExpressBean {

    private String status;
    private String msg;

    private ArrayList<ResultEntity> result;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(ArrayList<ResultEntity> result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public ArrayList<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String name;
        private String type;
        private String letter;
        private String tel;
        private String number;

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getLetter() {
            return letter;
        }

        public String getTel() {
            return tel;
        }

        public String getNumber() {
            return number;
        }
    }
}
