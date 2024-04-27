package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sg.edu.np.mad.mad_prac2.R;

public class MainActivity extends AppCompatActivity {

    // Define the TAG variable at the class level
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize a new User object
        User user = new User("John Doe", "MAD Developer",1,false);

        // Get the TextViews and buttons from the layout
        TextView tvName = findViewById(R.id.textView); // Update to match the ID in your layout
        TextView tvDescription = findViewById(R.id.textView1); // Update to match the ID in your layout
        Button btnFollow = findViewById(R.id.button1);

        // Set the TextViews with the user's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("FOLLOW");

        // Set the click listener for the button
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the current text of the button
                String buttonText = btnFollow.getText().toString();

                // Toggle between "Follow" and "Unfollow"
                if (buttonText.equals("FOLLOW")) {
                    btnFollow.setText("Unfollow");
                    Log.i(TAG, "Unfollow"); // Use the TAG variable defined in the class
                } else {
                    btnFollow.setText("FOLLOW");
                    Log.i(TAG, "Follow"); // Use the TAG variable defined in the class
                }
            }
        });
    }
}