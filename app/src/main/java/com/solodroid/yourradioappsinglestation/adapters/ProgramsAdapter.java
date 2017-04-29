package com.solodroid.yourradioappsinglestation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solodroid.yourradioappsinglestation.R;
import com.solodroid.yourradioappsinglestation.models.Program;

import java.util.List;

/**
 * Created by leandro.luis.cuvelo on 4/25/2017.
 */

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.MyViewHolder> {

    private List<Program> programsList;

    public ProgramsAdapter(List<Program> programsList) {
        this.programsList = programsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.radio_program_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Program program = programsList.get(position);
        holder.hs.setText(program.getHours());
        holder.title.setText(program.getTitle());
    }

    @Override
    public int getItemCount() {
        return programsList.size();

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView hs, title;

        public MyViewHolder(View view) {
            super(view);
            hs = (TextView) view.findViewById(R.id.hs_program);
            title = (TextView) view.findViewById(R.id.title_program);
        }


    }

}
