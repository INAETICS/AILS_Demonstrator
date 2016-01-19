package org.inaetics.ails.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.exceptions.ServerUnavailableException;
import org.osgi.framework.BundleContext;

/**
 * Activity that requires a user to register his name and device.
 *
 * Trying the back button causes the app to close.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 19-01-2016
 */
public class RegisterActivity extends OSGiActivity {

    // Injected by Dependency Manager
    private volatile DeviceController deviceController;

    // UI references.
    private EditText nameView;
    private View progressView;
    private View registerView;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        Log.d("RegisterActivity", "Configure Felix component");
        manager.add(manager.createComponent()
                .setInterface(Activity.class.getName(), null)
                .setImplementation(this)
                .add(manager.createServiceDependency()
                        .setService(DeviceController.class)
                        .setRequired(true)));
    }

    @Override
    void start() {
        Log.d("RegisterActivity", "Dependencies resolved");
        setContentView(R.layout.activity_register);

        // Set up the login form.
        nameView = (EditText) findViewById(R.id.name);

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

        registerView = findViewById(R.id.register_form);
        progressView = findViewById(R.id.register_progress);
    }

    @Override
    void stop() {

    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

    private void attemptRegister() {
        // Reset errors.
        nameView.setError(null);

        // Store values at the time of the login attempt.
        final String name = nameView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(name)) {
            nameView.setError(getString(R.string.error_field_required));
            focusView = nameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            Log.d("RegisterActivity", "Perform register");

            try {
                deviceController.registerUser(name);
                finish();

            } catch (ServerUnavailableException e) {
                showProgress(false);
                Snackbar.make(registerView, R.string.server_unavailable, Snackbar.LENGTH_LONG)
                        .show();
                Log.w("RegisterActivity", e);
            }
        }
    }

    /**
     * Shows the progress UI and hides the register form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            registerView.setVisibility(show ? View.GONE : View.VISIBLE);
            registerView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    registerView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            registerView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
