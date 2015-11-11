package org.inaetics.ails.impl.client.learning_controller;

import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.factory.RawLocationProfileFactory;
import org.inaetics.ails.api.client.learning_controller.LearningService;

/**
 * The LearningServiceImpl class provides an implementation of the {@link LearningService
 * LearningService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LearningServiceImpl implements LearningService {
    
    private volatile RawLocationProfileFactory rawLocationProfileFactory;
    
    private Timer timer;
    private TimerTask task;
    
    @Override
    public void startLearningMode() {
        timer = new Timer();
        task = new TimerTask() {
            
            @Override
            public void run() {
                rawLocationProfileFactory.getProfile();
                
            }
        };
        
        timer.schedule(task, 0, 60000);
    }

    @Override
    public void stopLearningMode() {
        task.cancel();
        timer.cancel();
    }
}
