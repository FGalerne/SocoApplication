package com.flo.socoapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 02/07/17.
 */

public class RegisterRequest extends StringRequest  {

    private static final String REGISTER_REQUEST_URL ="https://testsoco2.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String email, String employeeNumber, String password, Response.Listener<String> listener){

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("employeeNumber", employeeNumber);
        params.put("password", password);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
