package westbengal.book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.class1recyleview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        try {
            FirebaseRecyclerOptions<Modal> options =
                    new FirebaseRecyclerOptions.Builder<Modal>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Post"), Modal.class)
                            .build();
            adpter = new Adapter(options);
        } catch (Exception e) {
            e.printStackTrace();
        }


        recyclerView.setAdapter(adpter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adpter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adpter.stopListening();
    }
}