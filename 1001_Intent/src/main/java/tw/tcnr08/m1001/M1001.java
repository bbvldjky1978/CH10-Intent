package tw.tcnr08.m1001;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class M1001 extends AppCompatActivity implements View.OnClickListener {

    private Button b001;
    private Button b002,b003;
    private Uri uri;
    private Intent it;
    private Button b004;
    private Button b005;
    private File f;
    private Button b006;
    private Button b007;
    private Uri uriPerson;
    private Button b008;
    private Button b009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableStrictMode(this);
        setContentView(R.layout.m1001);
        setupviewcomponent();
    }

    //**********************************************************
    private void enableStrictMode(Context context) {
        //-------------抓取遠端資料庫設定執行續------------------------------
        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder().
                detectDiskReads().
                detectDiskWrites().
                detectNetwork().
                penaltyLog().
                build());
        StrictMode.setVmPolicy(
                new
                        StrictMode.
                                VmPolicy.
                                Builder().
                        detectLeakedSqlLiteObjects().
                        penaltyLog().
                        penaltyDeath().
                        build());
    }

    //**********************************************************

    private void setupviewcomponent() {

        b001 = (Button) findViewById(R.id.m1001_b001);
        b001.setOnClickListener(this);

        b002 = (Button) findViewById(R.id.m1001_b002);
        b002.setOnClickListener(this);

        b003 = (Button) findViewById(R.id.m1001_b003);
        b003.setOnClickListener(this);

        b004 = (Button) findViewById(R.id.m1001_b004);
        b004.setOnClickListener(this);

        b005 = (Button) findViewById(R.id.m1001_b005);
        b005.setOnClickListener(this);

        b006 = (Button) findViewById(R.id.m1001_b006);
        b006.setOnClickListener(this);

        b007 = (Button) findViewById(R.id.m1001_b007);
        b007.setOnClickListener(this);

        b008 = (Button) findViewById(R.id.m1001_b008);
        b008.setOnClickListener(this);

        b009 = (Button) findViewById(R.id.m1001_b009);
        b009.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.m1001_b001:

                uri = Uri.parse("http://google.com");
              it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);


                break;
            case R.id.m1001_b002:

                 uri = Uri.parse("geo:24.166470793690777,120.579954929572");

                 it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);


//其他 geo URI 範例
//geo:latitude,longitude
//geo:latitude,longitude?z=zoom
//geo:0,0?q=my+street+address
//geo:0,0?q=business+near+city
//google.streetview:cbll=lat,lng&cbp=1,yaw,,pitch,zoom&mz=mapZoom



                break;


            case R.id.m1001_b003:
//            {"中區職訓", "24.172127,120.610313"},
                double startLat =24.172127;
                double startLng  =120.610313;

                double endLat =24.16639119576672;
                double endLng  =120.57991510080338;


                uri = Uri.parse("http://maps.google.com/maps?f=d&saddr="+
                        startLat+
                        "%20"+
                        startLng+
                        "&daddr="
                        +endLat+
                        "%20"+
                        endLng+
                        "&hl=en");
                 it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
//                    where startLat, startLng, endLat, endLng are a long with 6 decimals like: 50.123456
//                uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=起點位置&daddr=終點位置&hl=tw");



                break;


            case R.id.m1001_b004:

                 it = new Intent(Intent.ACTION_VIEW);
                 uri = Uri.parse("file:///Download/s01.mp3");
                it.setDataAndType(uri, "audio/mp3");
                startActivity(it);

                 uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
                 it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);


                break;
            case R.id.m1001_b005:
                Intent it = new Intent(Intent.ACTION_VIEW, Contacts.People.CONTENT_URI);

                startActivity(it);

                break;
            case R.id.m1001_b006:
                 uri = Uri.parse("mailto:xxx@abc.com");
                 it = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(it);

                 it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
                it.putExtra(Intent.EXTRA_TEXT, "The email body text");
                it.setType("text/plain");
                startActivity(Intent.createChooser(it, "Choose Email Client"));

                 it=new Intent(Intent.ACTION_SEND);
                String[] tos={"bbvldjky@hotmail.com"};
                String[] ccs={"bbvldjkyjp@gmail.com"};
                it.putExtra(Intent.EXTRA_EMAIL, tos);
                it.putExtra(Intent.EXTRA_CC, ccs);
                it.putExtra(Intent.EXTRA_TEXT, "The email body text");
                it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it, "Choose Email Client"));

                break;

            case R.id.m1001_b007:

                 uriPerson = ContentUris.withAppendedId(Contacts.People.CONTENT_URI, 5); //5 是朋友的 ID
                 it = new Intent(Intent.ACTION_VIEW, uriPerson);
                startActivity(it);


                break;
            case R.id.m1001_b008:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"中區職訓");
                startActivity(intent);

                break;
            case R.id.m1001_b009:
//                //叫出撥號程式
                 uri = Uri.parse("tel:0800000123");
                 it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);

////直接打電話出去
//                 uri = Uri.parse("tel:0800000123");
//                 it = new Intent(Intent.ACTION_CALL, uri);
//                startActivity(it);

//用這個，要在 AndroidManifest.xml 中，加上
//<uses-permission id="android.permission.CALL_PHONE" />


                break;

        }

    }
}