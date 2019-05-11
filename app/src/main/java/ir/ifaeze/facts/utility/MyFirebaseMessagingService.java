package ir.ifaeze.facts.utility;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingServ";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String notificationBody = "";
        String notificationTitle = "";
        String notificationData = "";
        try {
            notificationData = remoteMessage.getData().toString();
            notificationTitle = remoteMessage.getNotification().getTitle();
            notificationBody = remoteMessage.getNotification().getBody();
        } catch (NullPointerException e) {
            Log.e(TAG, "onMessageReceived: NullPointerException: " + e.getMessage());
        }
        Log.d(TAG, "onMessageReceived: data: " + notificationData);
        Log.d(TAG, "onMessageReceived: notification body: " + notificationBody);
        Log.d(TAG, "onMessageReceived: notification title: " + notificationTitle);
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }
}
