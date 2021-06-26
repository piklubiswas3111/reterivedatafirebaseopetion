package westbengal.book;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adapter extends FirebaseRecyclerAdapter<Modal, Adapter.Holder> {


    public Adapter(@NonNull FirebaseRecyclerOptions<Modal> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Adapter.Holder holder, int position, @NonNull Modal model) {

        holder.pdftext.setText(model.getPdfname());
        holder.pdflink.setText(model.getPdflink());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra("pdfn", model.getPdfname());
                intent.putExtra("url", model.getPdflink());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row, parent, false);
        return new Holder(view);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView pdftext, pdflink;

        public Holder(@NonNull View itemView) {
            super(itemView);
            pdftext = (TextView) itemView.findViewById(R.id.class1pdfname);
            pdflink = (TextView) itemView.findViewById(R.id.class1pdfdownload);
        }
    }
}
