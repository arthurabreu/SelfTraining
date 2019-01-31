package com.intive.selftraining.selftraining.authentication

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.activity.LoginActivity
import com.intive.selftraining.selftraining.utils.FIREBASE_SIGN_IN
import java.util.Arrays

class AuthenticationUserInfo {

    fun isCurrentUser() = FirebaseAuth.getInstance().currentUser != null
}

class AuthenticationNavigation(
    val activity: LoginActivity
) {

    private var providers: MutableList<AuthUI.IdpConfig> = Arrays.asList(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.PhoneBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    fun navigateToSignIn() {
        activity.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme(R.style.LoginTheme)
                .setAvailableProviders(providers)
                .build(), FIREBASE_SIGN_IN
        )
    }
}