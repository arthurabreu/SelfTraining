package com.intive.selftraining.selftraining.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.authentication.AuthenticationNavigation
import com.intive.selftraining.selftraining.authentication.AuthenticationUserInfo
import com.intive.selftraining.selftraining.utils.FIREBASE_SIGN_IN
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var authenticationUserInfo: AuthenticationUserInfo

    @Inject
    lateinit var authenticationNavigation: AuthenticationNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()
        fireBaseSignIn()
    }

    private fun fireBaseSignIn() {
        if (authenticationUserInfo.isCurrentUser()) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        } else {
            authenticationNavigation.navigateToSignIn()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FIREBASE_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to sign in", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
