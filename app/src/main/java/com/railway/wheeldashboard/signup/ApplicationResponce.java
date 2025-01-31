package com.railway.wheeldashboard.signup;

import java.util.List;

public class ApplicationResponce {

    private List<Error> error;
    private Object data;

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
