package com.jacqui.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jacqui.gadsleaderboard.APIs.LeaderboardServiceBuilder;
import com.jacqui.gadsleaderboard.APIs.SubmitFormAPI;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitForm extends AppCompatActivity {

    private static final String TAG = "SubmitProject";

    private Dialog dialog;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmailAddress;
    private EditText editTextGithubLink;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String gitHubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_form);

        editTextFirstName = findViewById(R.id.editFirstName);
        editTextLastName = findViewById(R.id.editLastName);
        editTextEmailAddress = findViewById(R.id.editEmailAddress);
        editTextGithubLink = findViewById(R.id.editProjectLink);
        getFormData();

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: Validate form data before creating popup
                if (isValidFormData()) {
                    // Create dialog to confirm submit
                    createSubmitConfirmationDialog();
                }
            }
        });
    }

    public void createSubmitConfirmationDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.submit_dialog_window);
        // Cancel imageButton
        ImageButton closeIBtn = dialog.findViewById(R.id.cancellationButton);
        // Yes Button
        Button continueBtn = dialog.findViewById(R.id.confirmationButton);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        closeIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitFormAPI submitService = LeaderboardServiceBuilder.buildApiService(SubmitFormAPI.class);
                Call<Void> submitFormData = submitService.submitForm(
                        "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse",
                        firstName,
                        lastName,
                        emailAddress,
                        gitHubLink
                );
                submitFormData.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                        // Calls method to create and show success message dialog
                        createResponseDialog(R.drawable.check_circle, R.string.submission_successful);

                        if (response.isSuccessful()) {
                            clearFormEntry();
                            //Log.e(TAG, "post-onResponse: " + response.message() + "\n\n" + response.body() + "\n\n" + response.errorBody());
                            Toast.makeText(SubmitForm.this, "Success " + response.message(), Toast.LENGTH_LONG).show();

                        }
                        else{
                            //createResponseDialog(R.drawable.ic_baseline_warning_24, R.string.submission_failure);
                            Toast.makeText(SubmitForm.this, "Response Error" + response.errorBody(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                        // Calls method to create and show failure message dialog
                        createResponseDialog(R.drawable.warning_image, R.string.submission_failed);
                        Toast.makeText(SubmitForm.this, t.getMessage(), Toast.LENGTH_LONG).show();

                }
        });
            }
        });
    }

    private void clearFormEntry() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        editTextEmailAddress.setText("");
        editTextGithubLink.setText("");
    }

    public void createResponseDialog(int responseImage, int responseText) {
        dialog.dismiss();

        dialog = new Dialog(SubmitForm.this);
        dialog.setContentView(R.layout.dialog_window);
        ImageView responseImg = dialog.findViewById(R.id.responseWindowImage);
        TextView responseTV = dialog.findViewById(R.id.responseWindowText);

        //populate with appropriate content base on response message
        responseImg.setImageResource(responseImage);
        responseTV.setText(getString(responseText));
        dialog.show();
    }

    
    public boolean isValidFormData(){
        getFormData();

        boolean isValid = false;

        if (firstName.trim().isEmpty()) {
            editTextFirstName.requestFocus();
            editTextFirstName.setError("First Name Required!");
        } else if (lastName.trim().isEmpty()) {
            editTextLastName.requestFocus();
            editTextLastName.setError("Last Name Required!");
        } else if (emailAddress.trim().isEmpty()) {
            editTextEmailAddress.requestFocus();
            editTextEmailAddress.setError("Email Required!");
        } else if (gitHubLink.trim().isEmpty()) {
            editTextGithubLink.requestFocus();
            editTextGithubLink.setError("Project Link Required!");
        } else {
            isValid = true;
        }

        return isValid;
    }

    private void getFormData() {

        firstName = editTextFirstName.getText().toString();
        lastName = editTextLastName.getText().toString();
        emailAddress = editTextEmailAddress.getText().toString();
        gitHubLink = editTextGithubLink.getText().toString();
    }
}