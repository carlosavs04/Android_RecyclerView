package com.example.recyclerview.Adaptadores;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.Modelos.Persona;
import com.example.recyclerview.R;
import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.viewholder> {

    List<Persona> LP;

    public PersonaAdaptador(List<Persona> LP) {
        this.LP = LP;
    }

    @NonNull
    @Override
    public PersonaAdaptador.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.viewholder holder, int position) {
        holder.setData(LP.get(position));
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNombre;
        TextView txtTelefono;
        Persona personaHolder;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);
            itemView.setOnClickListener(this);
        }

        public void setData(Persona p){
            personaHolder = p;
            txtNombre.setText(personaHolder.getNombre());
            txtTelefono.setText(personaHolder.getTelefono());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), personaHolder.getNombre(), Toast.LENGTH_SHORT);

            if(ContextCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            {
                llamar();
            }

            else {
                ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }

        private void llamar() {
            Intent llamada = new Intent(Intent.ACTION_CALL);
            llamada.setData(Uri.parse("tel:" + personaHolder.getTelefono()));
            itemView.getContext().startActivity(llamada);
        }
    }
}
