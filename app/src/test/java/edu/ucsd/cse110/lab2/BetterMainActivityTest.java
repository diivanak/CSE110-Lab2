package edu.ucsd.cse110.lab2;

import static android.os.StrictMode.allowThreadDiskReads;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

    @Test
    public void test_one_plus_two_equals_three() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {

            Button one=activity.findViewById(R.id.btn_one);
            Button plus=activity.findViewById(R.id.btn_plus);
            Button two=activity.findViewById(R.id.btn_two);
            Button equals=activity.findViewById(R.id.btn_equals);

            assertTrue(one.performClick());
            assertTrue(plus.performClick());
            assertTrue(two.performClick());
            assertTrue(equals.performClick());
            TextView display = activity.findViewById(R.id.display);
            assertEquals(3,Integer.parseInt((String)display.getText()));

        });

    }


}
