package chuque.com.notes;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rafael on 08/11/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private ArrayList<Note> notes;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes, Context context) {

        this.notes = notes;
        this.context = context;
    }

    @Override //2 - pra cada item da lista, entra nesse metodo que cria o item na RecyclerView, inflando-o
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);

        return new MyViewHolder(view);
    }

    @Override //3 - esse método pega os atributos da lista notes e faz o bind com os atributos da view
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(note.getDescription());

        String[] stringArray = context.getResources().getStringArray(R.array.card_colors);
        Random random = new Random();
        String color = stringArray[random.nextInt(3)];
        holder.linear.setBackgroundColor(Color.parseColor(color));
    }

    @Override //1 - conta a quantidade de itens na lista
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        View linear;
        TextView textViewTitle;
        TextView textViewDescription;

        public MyViewHolder(View itemView) {
            super(itemView);

            linear = itemView.findViewById(R.id.note_card);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
