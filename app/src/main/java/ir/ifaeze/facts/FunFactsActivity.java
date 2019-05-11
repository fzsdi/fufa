package ir.ifaeze.facts;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FunFactsActivity extends AppCompatActivity {
    // Declare our view variables

    private FirebaseAnalytics mFirebaseAnalytics;
    TextView mfactTextView;
    Button mfactButton;
    ConstraintLayout mConstraintLayout;

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        BatchHelper.initBatch(getApplication());
        BatchHelper.sendInstallEvent();

        // Assign the views from the layout file
        mfactTextView = findViewById(R.id.factTextView);
        mfactButton = findViewById(R.id.factButton);
        mConstraintLayout = findViewById(R.id.constraintLayout);

        View.OnClickListener showFactsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();
                // Update the text view with our dynamic fact
                mfactTextView.setText(fact);
                mConstraintLayout.setBackgroundColor(color);
                mfactButton.setTextColor(color);
                String btnName;
                Bundle bundle = new Bundle();
                bundle.putInt("Button_ID", mfactButton.getId());
                btnName = "button_fact_clicked";
                mFirebaseAnalytics.logEvent(btnName, bundle);
            }
        };

        mfactButton.setOnClickListener(showFactsListener);
    }
}
