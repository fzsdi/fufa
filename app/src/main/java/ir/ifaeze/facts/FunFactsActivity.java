package ir.ifaeze.facts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ir.ifaeze.facts.FactBook.*;
import android.widget.TextView;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    // Declare our view variables

    TextView mfactTextView;
    Button mfactButton;
    ConstraintLayout mConstraintLayout;

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

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
            }
        };

        mfactButton.setOnClickListener(showFactsListener);
    }
}
