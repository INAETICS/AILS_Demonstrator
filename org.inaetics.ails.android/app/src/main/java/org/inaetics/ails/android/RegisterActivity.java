package org.inaetics.ails.android;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
 * @version 0.1.0
 * @since 19-01-2016
 */
public class RegisterActivity extends OSGiActivity {

    // Injected by Dependency Manager
    private volatile DeviceController deviceController;

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
        final LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        setContentView(content);

        TextView textView = new TextView(this);
        textView.setText("Welcome, new user. Please register your device");
        content.addView(textView);

        final EditText nameEditText = new EditText(this);
        content.addView(nameEditText);

        final Context applicationContext = this;

        Button registerButton = new Button(this);
        registerButton.setText("Register");
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String name = nameEditText.getText().toString();
                Log.d("RegisterActivity", "trying to register " + name);

                if (name.isEmpty()) {
                    Snackbar.make(content, "Please enter your name", Snackbar.LENGTH_LONG)
                            .show();

                } else {
                    Log.d("RegisterActivity", "perform register of " + name);
                    try {
                        deviceController.registerUser(name);
                        finish();

                    } catch (ServerUnavailableException e) {
                        Snackbar.make(content, "No connection could be established", Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
        content.addView(registerButton);
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
}
