package com.example.windows10.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {

    /*EditText username, password;
    ProgressBar progressBar;*/

    Button btnLogin;

    private final static int LOGIN_PERMISSION=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.signInButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        AuthUI.getInstance().createSignInIntentBuilder()
                                .setAllowNewEmailAccounts(true).build(), LOGIN_PERMISSION
                );
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==LOGIN_PERMISSION){

            startNewActivity(resultCode,data);
        }
    }

    private void startNewActivity(int resultCode, Intent data) {

        if(resultCode==RESULT_OK){

            Intent intent= new Intent(MainActivity.this,ListOnline.class);
            startActivity(intent);
            finish();
        }

        else{

            Toast.makeText(this, "Login Failed!!", Toast.LENGTH_SHORT).show();
        }
    }



    /*username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);

        Button signInButton=(Button) findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFormValid()){
                    //perform SignIn
                    performSignIn();
                }

            }
        });

        Button registerButton =(Button) findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFormValid()){
                    //perform Registration
                    performRegistration();
                }

            }
        });

        //initializing progress Bar
        progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
    }

    private Boolean isFormValid()
    {
        if(username.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Username cannot be left Empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if(password.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Password cannot be left Empty",Toast.LENGTH_LONG).show();

            return false;
        }

        return  true;
    }

    private void performSignIn(){

      ApiManager.getApiInterface().login(new AuthenticationRequest(username.getText().toString().trim(),password.getText().toString().trim()))
              .enqueue(new Callback<MessageResponse>() {
                  @Override
                  public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                      if(response.isSuccessful()){
                          showAlert("Welcome",response.body().getMessage());
                      }else{
                          try {
                              String errorMessage =response.errorBody().string();

                              try{
                                   ErrorResponse errorResponse= new Gson().fromJson(errorMessage,ErrorResponse.class);
                                  showAlert("Sign in Failed!",errorResponse.getError());
                              }catch (JsonSyntaxException jsonException){
                                   jsonException.printStackTrace();
                                  showAlert("Sign in Failed!","Something went Wrong");
                              }
                          } catch (IOException e) {
                              e.printStackTrace();
                              showAlert("Sign in Failed!","Something went Wrong");
                          }
                      }
                  }

                  @Override
                  public void onFailure(Call<MessageResponse> call, Throwable t) {
                      showAlert("Sign in Failed!","Something went Wrong");
                  }
              });


    }

    private void performRegistration(){
        ApiManager.getApiInterface().registration(new AuthenticationRequest(username.getText().toString().trim(),password.getText().toString().trim()))
                .enqueue(new Callback<MessageResponse>() {
                    @Override
                    public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                        if(response.isSuccessful()){
                            //showAlert("Welcome",response.body().getMessage());
                            navigatetoschedule();
                        }else{
                            try {
                                String errorMessage =response.errorBody().string();

                                try{
                                    ErrorResponse errorResponse= new Gson().fromJson(errorMessage,ErrorResponse.class);
                                    showAlert("Registration Failed!",errorResponse.getError());
                                }catch (JsonSyntaxException jsonException){
                                    jsonException.printStackTrace();
                                    showAlert("Registration Failed!","Something went Wrong");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                showAlert("Registration Failed!","Something went Wrong");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MessageResponse> call, Throwable t) {
                        showAlert("Registration Failed!","Something went wrong");
                    }
                });


    }

    private void ShowProgressDialog(Boolean shouldShould){
        if(shouldShould){

        }

    }

    private void showAlert(String title,String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    class SignInTask extends AsyncTask<String, Void, Boolean >{

       // String mockusername="text";
        //String mockpassword="password";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if(aBoolean){
               showAlert("Welcome!!", "You have successfully Signed in");
            }
            else{
               showAlert("Failed!","Username/Password is incorrect");
            }
        }

        @Override
        protected Boolean doInBackground(String... strings) {
           String username=strings[0];
            String password=strings[1];
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return username.contentEquals(mockusername) && password.contentEquals(mockpassword);
        }
    }

    private void navigatetoschedule(){
        Intent intent = new Intent(this, ShowSchedule.class);
        startActivity(intent);
        finish();
    }
}*/
    }
