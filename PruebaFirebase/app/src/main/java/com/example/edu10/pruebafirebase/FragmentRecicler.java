package com.example.edu10.pruebafirebase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class FragmentRecicler extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView usersRecycler;
    List<Usuarios> userList = new ArrayList<>();
    MiAdapter miAdapter = new MiAdapter(userList);

    public FragmentRecicler() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRecicler.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRecicler newInstance(String param1, String param2) {
        FragmentRecicler fragment = new FragmentRecicler();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_recicler, container, false);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//Crear estas dos clases para el recicler, userViewHolder y MiAdapter
    public class UserViewHolder extends RecyclerView.ViewHolder{
        //Declaramos todo lo del xml que se tenga que mostrar y haya que modificar cada vez
            TextureView nomId;
            TextureView edadId;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            //aqui buscamos la referencia e el xml
            nomId=itemView.findViewById(R.id.edadIdD);
            edadId=itemView.findViewById(R.id.edadIdD);
    }
}


    public class MiAdapter extends RecyclerView.Adapter<MiAdapter.UserViewHolder>{


        List<Usuarios> userslistadapter = new ArrayList<>();

        public MiAdapter(List<Usuarios> userslistadapter) {
            this.userslistadapter = userslistadapter;
        }
        @NonNull
        @Override
        public MiAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemview = getLayoutInflater()
                    .inflate(R.layout.fragment_lista, viewGroup, false);
            return new MiAdapter((List<Usuarios>) itemview);
        }


        @Override
        public void onBindViewHolder(@NonNull MiAdapter.UserViewHolder userViewHolder, int i) {
            userViewHolder.nomId.setText(userlistadapter.get(i).getNombre);
            userViewHolder.EdadId.setText(userlistadapter.get(i).getEdad);
        }

        @Override
        public int getItemCount() {
            return userslistadapter.size();
        }


    }
    public void añadirAlaLista(Usuarios user){

        userList.add(user);
        miAdapter.notifyDataSetChanged();
    }
}
