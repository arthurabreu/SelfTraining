package com.intive.selftraining.selftraining.authentication

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.intive.selftraining.selftraining.R
import java.util.Arrays

class Authentication {

    private var providers: MutableList<AuthUI.IdpConfig> = Arrays.asList(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.PhoneBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    fun fireBaseSignIn() = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setTheme(R.style.LoginTheme)
        .setAvailableProviders(providers)
        .build()

    fun isCurrentUser() = FirebaseAuth.getInstance().currentUser != null
}