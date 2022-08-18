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

public class CursosAdapter extends BaseAdapter {
    Context context;
    List<Curso> cursos;
    public CursosAdapter(Context _context,List<Curso> _cursos){
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflaterTipomarca = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemCursos= layoutInflaterTipomarca.inflate(R.layout.view_cursos,parent,false);
        TextView cursonombre = itemCursos.findViewById(R.id.curso_nombre);
        TextView horario_nombre = itemCursos.findViewById(R.id.horario_nombre);
        cursonombre.setText(this.cursos.get(position).getCourse_name() + " " + this.cursos.get(position).getSection());
        horario_nombre.setText(this.cursos.get(position).getDay() + " " + this.cursos.get(position).getStart()+" - "+this.cursos.get(position).getFinish());
        Log.d("Adapter",this.cursos.get(position).getCourse_name());
        return itemCursos;
    }
}
