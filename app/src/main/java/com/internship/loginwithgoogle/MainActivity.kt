package com.internship.loginwithgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import androidx.activity.result.ActivityResultLauncher
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.internship.loginwithgoogle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var signInLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an ActivityResultLauncher which registers a callback for the FirebaseUI Activity result contract:
        signInLauncher =
            registerForActivityResult(FirebaseAuthUIActivityResultContract()) { res ->
                this.onSignInResult(res)
            }

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            binding.txtName.text = user.email
            Toast.makeText(this, user.displayName + " already exists", Toast.LENGTH_SHORT).show()
            binding.btnLogActions.text = getString(R.string.logout)
        }

        binding.btnLogActions.setOnClickListener {
            if (binding.btnLogActions.text == getText(R.string.logout)) {
                FirebaseAuth.getInstance().signOut() // user?.delete() deletes the user (not removing from firebase but in this app). thus when we login again we have to give email, name and pass instead of just email and pass
                binding.txtName.text = getString(R.string.none)
                binding.btnLogActions.text = getString(R.string.login)
            }
            else if (binding.btnLogActions.text == getText(R.string.login)) {
                signInRequest()
            }
        }
    }

    private fun signInRequest() {
        // To kick off the FirebaseUI sign in flow, create a sign in intent with your preferred sign-in methods:
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.TwitterBuilder().build(),
            AuthUI.IdpConfig.GitHubBuilder().build(),
//            AuthUI.IdpConfig.FacebookBuilder().build(), // for login with fb, import fb sdk for developers and get app id and app secret from developers.facebook.com
        )

        // Create and launch sign-in intent
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setTheme(R.style.Base_Theme_LoginWithGoogle) // by not setting theme it shows its own with a title bar. but now it won't bec our theme doesn't contain any title bar
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    // When the sign-in flow is complete, you will receive the result in onSignInResult:
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val user = FirebaseAuth.getInstance().currentUser
        Toast.makeText(this, user?.displayName, Toast.LENGTH_SHORT).show()

        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            binding.txtName.text = user?.email
            binding.btnLogActions.text = getString(R.string.logout)
        } else {
            // Sign in failed. If response is null the user canceled the. sign-in flow using the back button. Otherwise check response.getError().getErrorCode() and handle the error.

            binding.txtName.text = result.toString() // result.idpResponse?.error?.message
        }
    }
}