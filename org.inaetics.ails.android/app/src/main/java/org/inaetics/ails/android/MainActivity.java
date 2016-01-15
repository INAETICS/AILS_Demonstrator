package org.inaetics.ails.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;

/**
 * The main activity (i.e. Activity that is created at startup).
 *
 * This activity can use Apache Felix's dependency manager for dependency injections,
 * due to its superclass OSGiActivity.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 09-12-2015
 */
public class MainActivity extends OSGiActivity {

    private volatile WiFiProfileFactory wiFiProfileFactory;
    private volatile UserService userService;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        manager.add(manager.createComponent()
                        .setInterface(Activity.class.getName(), null)
                        .setImplementation(this)
                        .add(manager.createServiceDependency()
                                .setService(WiFiProfileFactory.class)
                                .setRequired(true))
                        .add(manager.createServiceDependency()
                                .setService(UserService.class)
                                .setRequired(false))
        );
    }

    @Override
    void start() {
        final Context applicationContext = this;

        LinearLayout content = new LinearLayout(applicationContext);
        content.setOrientation(LinearLayout.VERTICAL);
        setContentView(content);

        TextView textView = new TextView(applicationContext);
        StringBuilder textBuilder = new StringBuilder("Main activity\n");
        textView.setText(textBuilder.toString());
        content.addView(textView);

        Button nextActivityButton = new Button(applicationContext);
        nextActivityButton.setText("Next activity");
        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(applicationContext, SecondActivity.class));
            }
        });
        content.addView(nextActivityButton);

        // Check WiFiProfileFactory dependency
        if (isServiceAvailable(WiFiProfileFactory.class)) {
            textBuilder.append("Wifi profile factory available\n");
        } else {
            textBuilder.append("Wifi profile factory not available\n");
        }

        // Check UserService dependency
        if (isServiceAvailable(UserService.class)) {
            textBuilder.append("User service available\n");
        } else {
            textBuilder.append("User service not available\n");
        }

        textView.setText(textBuilder.toString());
    }

    @Override
    void stop() {

    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

}
