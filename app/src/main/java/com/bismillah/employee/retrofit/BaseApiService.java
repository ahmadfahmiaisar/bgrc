package com.bismillah.employee.retrofit;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//untuk perintah berkomunikasi dengan API seperti GET POST UPDATE DELETE
public interface BaseApiService {
    @FormUrlEncoded
    @POST("userLogin.php")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("level") JSONObject level);
 /*   @GET("login.php")
    Call login(@Path("username") String username, @Path("password") String password);*/
}
