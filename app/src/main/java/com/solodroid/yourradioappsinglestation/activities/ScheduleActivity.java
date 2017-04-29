package com.solodroid.yourradioappsinglestation.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.nex3z.togglebuttongroup.ToggleButtonGroup;
import com.solodroid.yourradioappsinglestation.R;
import com.solodroid.yourradioappsinglestation.adapters.ProgramsAdapter;
import com.solodroid.yourradioappsinglestation.models.Program;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ScheduleActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.weekdays)
    SingleSelectToggleGroup weekdays;
    @BindView(R.id.programs_list)
    RecyclerView programsList;

    private ProgramsAdapter programsAdapter;
    private List<Program> programListLunes;
    private List<Program> programListMartes;
    private List<Program> programListMierc;
    private List<Program> programListJueves;
    private List<Program> programListViernes;
    private List<Program> programListSabado;
    private List<Program> programListDomingo;

    private List<List<Program>> weekProgramList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_layout);
        ButterKnife.bind(this);
        setupToolbar();
        setupCurrentDay();
        setupLists();
        setupProgramList();
        setupListenerButtonsDay();

    }

    private void setupToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.drawer_programming));
        }
    }

    /**
     *  Aca se va a cargar la lista de programas con horario, título y día
     */
    private void setupLists() {
        //TODO borrar los programas hardcodeados de abajo

        weekProgramList = new  ArrayList<>();

        //Set programs for Lunes//
        programListLunes = new ArrayList<>();
        Program program1 = new Program("00:00", "TITLE 1", "L");
        programListLunes.add(program1);
        Program program2 = new Program("10:00", "Title 2", "L");
        programListLunes.add(program2);
        weekProgramList.add(programListLunes);


        //Set programs for Martes//
        programListMartes = new ArrayList<>();
        Program program3 = new Program("14:10", "TITLE 3", "M");
        programListMartes.add(program3);
        Program program4 = new Program("10:00", "Title 4", "M");
        programListMartes.add(program4);
        weekProgramList.add(programListMartes);

        //Set programs for Miercoles//
        programListMierc = new ArrayList<>();
        weekProgramList.add(programListMierc);

        //Set programs for Jueves// // Have a long list just for see the scrolling//
        programListJueves = new ArrayList<>();
        Program program5 = new Program("00:00", "TITLE 1", "L");
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        programListJueves.add(program5);
        weekProgramList.add(programListJueves);

        //Set programs for Viernes//
        programListViernes = new ArrayList<>();
        weekProgramList.add(programListViernes);

        //Set programs for Sabado//
        programListSabado = new ArrayList<>();
        weekProgramList.add(programListSabado);

        //Set programs for Domingo//
        programListDomingo = new ArrayList<>();
        weekProgramList.add(programListDomingo);


    }

    private void setupProgramList() {

        programsAdapter = new ProgramsAdapter(weekProgramList.get(getSelectedDay ()));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        programsList.setLayoutManager(mLayoutManager);
        programsList.setItemAnimator(new DefaultItemAnimator());
        programsList.setAdapter(programsAdapter);

        programsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    private int getSelectedDay() {
        Set<Integer> selectedDayId = weekdays.getCheckedPositions();
        int result = 0;
        for( Integer i : selectedDayId){
            result = i;
        }

        return result;

    }

    private void setupListenerButtonsDay() {
        weekdays.setOnCheckedChangeListener(new ToggleButtonGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChange(int position, boolean isChecked) {
                setupProgramList();
            }
        });
    }

    private void setupCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {

            case Calendar.MONDAY:
                weekdays.setCheckedAt(0,true);
                break;
            case Calendar.TUESDAY:
                weekdays.setCheckedAt(1,true);
                break;
            case Calendar.WEDNESDAY:
                weekdays.setCheckedAt(2,true);
                break;
            case Calendar.THURSDAY:
                weekdays.setCheckedAt(3,true);
                break;
            case Calendar.FRIDAY:
                weekdays.setCheckedAt(4,true);
                break;
            case Calendar.SATURDAY:
                weekdays.setCheckedAt(5,true);
                break;
            case Calendar.SUNDAY:
                weekdays.setCheckedAt(6,true);
                break;
        }
    }

}
