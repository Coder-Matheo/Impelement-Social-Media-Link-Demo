package rob.impelementsocialmedialinkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    ImageView whatsappImageView;
    ImageView instagramImageView;
    ImageView facebookImageView;
    ImageView twitterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsappImageView = findViewById(R.id.whatsappImageView);
        instagramImageView = findViewById(R.id.instagramImageView);
        facebookImageView = findViewById(R.id.facebookImageView);
        twitterImageView = findViewById(R.id.twitterImageView);


        whatsappImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Initialize mobile number with country code
                String sNumber = "+4917657692752";
                //Initialize uri
                Uri uri = Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s", sNumber));
                //Initialize Intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Set Data
                intent.setData(uri);
                //set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Start activity
                startActivity(intent);
            }
        });

        facebookImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String sAppLink = "fb://page/237564710351658";
                String sPackage = "com.facebook.katana";
                String sWebLink = "https://www.facebook.com/12H1rDeveloper";

                openLink(sAppLink, sPackage, sWebLink);
            }
        });

        instagramImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize link and Package
                String sAppLink = "https://www.instagram.com/androidcoding_";
                String sPackage = "com.instagram.android";
                //Call methode
                openLink(sAppLink, sPackage, sAppLink);
            }
        });

        twitterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize link and Package
                String sAppLink = "twitter://user?screen_name=AndroidCoding_";
                String sPackage = "com.twitter.android";
                String sWebLink = "https://twitter.com/AndroidCoding_";
                //Call Method
                openLink(sAppLink, sPackage, sWebLink);
            }
        });
    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        //Use try Catch
        try {
            //"When application is installed
            //Initialize uri
            Uri uri = Uri.parse(sAppLink);
            //Initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //set data
            intent.setData(uri);
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start activity
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            //Open link in browser
            //Initialize Uri
            Uri uri = Uri.parse(sWebLink);
            //Initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Set data
            intent.setData(uri);
            //set Flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
        }
    }
}