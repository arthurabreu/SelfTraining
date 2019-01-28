package com.intive.selftraining.selftraining.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.utils.FIREBASE_SIGN_IN
import java.util.Arrays

class LoginActivity : AppCompatActivity() {

    var providers = Arrays.asList(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.PhoneBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        fireBaseSigIn()
    }

    fun fireBaseSigIn() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        } else {
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setTheme(R.style.LoginTheme)
                    .setAvailableProviders(providers)
                    .build(),
                FIREBASE_SIGN_IN
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FIREBASE_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                // ...
            } else {
                Toast.makeText(this, "Failed to sign in", Toast.LENGTH_SHORT).show()
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}
