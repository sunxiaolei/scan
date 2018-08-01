package sun.xiaolei.scan;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.google.zxing.Result;

import sun.xiaolei.scanlib.ScanerActivity;

public class MainActivity extends ScanerActivity {


    @Override
    public ScanConfig initConfig() {
        ScanConfig config = new ScanConfig();
        config.showLocalImage = true;
        config.showFlash = false;
        config.vibrator = true;
        return config;
    }

    @Override
    public void handleResult(Result result) {
        if (result != null) {
            if (result.getText().equals("123")) {
                Toast.makeText(this, result.getText(), Toast.LENGTH_LONG).show();
            } else {
                new AlertDialog.Builder(this)
                        .setMessage(result.getText())
                        .setCancelable(false)
                        .setPositiveButton("重试", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                restartRreview();
                            }
                        })
                        .create()
                        .show();
            }
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
        }
    }
}
