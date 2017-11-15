package test.expapp;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class DummyServiceTest {
    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    @Test
    public void testService() throws Exception {
        Intent serviceIntent = new Intent(InstrumentationRegistry.getTargetContext(), DummyService.class);

        IBinder serviceBinder = mServiceRule.bindService(serviceIntent);

        Assert.assertNotNull(serviceBinder);

        IDummyService service = IDummyService.Stub.asInterface(serviceBinder);

        for (String s : new String[] {"foo", "bar", "hello world", "winter is coming"}) {
            assertEquals(s, service.echo(s));
        }
    }
}

