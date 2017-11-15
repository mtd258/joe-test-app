package test.expapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class DummyService extends Service {

    IDummyService.Stub mBinder = new IDummyService.Stub() {
        public String echo(String msg) {
            return msg;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
