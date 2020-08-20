package com.winkcoo.medx.admin.service;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.winkcoo.medx.admin.Utils.SessionManager;

import static com.winkcoo.medx.admin.service.AsyncTask.returnBitmap;


public class NotificationService extends FirebaseMessagingService {
    public NotificationService() {
    }
    String title = "No title";
    String body ="No Body";
    String intent = "no";
    String targetUserType = "no";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationHelper notificationHelper = new NotificationHelper(NotificationService.this);
        title = remoteMessage.getData().get("title").toString();
        body = remoteMessage.getData().get("body").toString();
        intent = remoteMessage.getData().get("intent").toString();
        targetUserType = remoteMessage.getData().get("targetUserType").toString();
       if (true) {

           if (remoteMessage.getData().get("image") != null && remoteMessage.getData().get("image").length() > 0) {
               String link = remoteMessage.getData().get("image");
               returnBitmap(link, new AsyncTask.downloadListener() {
                   @Override
                   public void onDownloaded(Bitmap bitmap) {
                       notificationHelper.createNotification(title,  body,intent, bitmap,targetUserType);


                   }
               });


           } else {
             //  notificationHelper.createNotification(title, "Body", intent, null);
               notificationHelper.createNotification(title,  body,intent, null,targetUserType);

           }
       }

    }
}
