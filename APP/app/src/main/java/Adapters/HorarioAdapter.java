package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Models.Curso;
import exportkit.xd.R;

public class HorarioAdapter extends BaseAdapter {
    Context context;
    List<Curso> cursos;
    public HorarioAdapter (Context _context,List<Curso> _cursos){
        this.context = _context;
        this.cursos = _cursos;
        Log.d("cursos",cursos.size()+"");
    }
    @Override
    public int getCount() {
        return this.cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.cursos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflaterTipomarca = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemCursos= layoutInflaterTipomarca.inflate(R.layout.view_horarios,parent,false);
        TextView day = itemCursos.findViewById(R.id.day);
        TextView horario_nombre = itemCursos.findViewById(R.id.horario_nombre);
        day.setText(cursos.get(position).getDay());
        horario_nombre.setText(cursos.get(position).getCourse_name() + " \n " + cursos.get(position).getStart()+" - "+cursos.get(position).getFinish());
        return itemCursos;
    }
}
