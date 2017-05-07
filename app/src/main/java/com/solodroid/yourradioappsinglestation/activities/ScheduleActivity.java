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
        Program program1 = new Program("00:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program1);
        Program program2 = new Program("02:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program2);
        Program program3 = new Program("03:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program3);
        Program program4 = new Program("05:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program4);
        Program program5 = new Program("10:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program5);
        Program program6 = new Program("12:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program6);
        Program program7 = new Program("14:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program7);
        Program program8 = new Program("17:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program8);
        Program program9 = new Program("19:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program9);
        Program program10 = new Program("21:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program10);
        Program program11 = new Program("23:00", "DEMO PROGRAMA 2017", "L");
        programListLunes.add(program11);
        weekProgramList.add(programListLunes);


        //Set programs for Martes//
        programListMartes = new ArrayList<>();
        Program program12 = new Program("00:00", "DEMO PROGRAMA 2017", "L");
        programListMartes.add(program12);
        Program program13 = new Program("02:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program13);
        Program program14 = new Program("03:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program14);
        Program program15 = new Program("05:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program15);
        Program program16 = new Program("10:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program16);
        Program program17 = new Program("12:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program17);
        Program program18 = new Program("14:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program18);
        Program program19 = new Program("17:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program19);
        Program program20 = new Program("19:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program20);
        Program program21 = new Program("21:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program21);
        Program program22 = new Program("23:00", "DEMO PROGRAMA 2017", "M");
        programListMartes.add(program22);
        weekProgramList.add(programListMartes);



        //Set programs for Miercoles//
        programListMierc = new ArrayList<>();
        Program program23 = new Program("00:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program23);
        Program program24 = new Program("02:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program24);
        Program program25 = new Program("03:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program25);
        Program program26 = new Program("05:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program26);
        Program program27 = new Program("10:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program27);
        Program program28 = new Program("12:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program28);
        Program program29 = new Program("14:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program29);
        Program program30 = new Program("17:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program30);
        Program program31 = new Program("19:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program31);
        Program program32 = new Program("21:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program32);
        Program program33 = new Program("23:00", "DEMO PROGRAMA 2017", "X");
        programListMierc.add(program33);
        weekProgramList.add(programListMierc);

        //Set programs for Jueves// // Have a long list just for see the scrolling//
        programListJueves = new ArrayList<>();
        Program program34 = new Program("00:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program34);
        Program program35 = new Program("02:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program35);
        Program program36 = new Program("03:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program36);
        Program program37 = new Program("05:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program37);
        Program program38 = new Program("10:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program38);
        Program program39 = new Program("12:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program39);
        Program program40 = new Program("14:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program40);
        Program program41 = new Program("17:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program41);
        Program program42 = new Program("19:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program42);
        Program program43 = new Program("21:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program43);
        Program program44 = new Program("23:00", "DEMO PROGRAMA 2017", "J");
        programListJueves.add(program44);
        weekProgramList.add(programListJueves);

        //Set programs for Viernes//
        programListViernes = new ArrayList<>();
        Program program45 = new Program("00:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program45);
        Program program46 = new Program("02:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program46);
        Program program47 = new Program("03:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program47);
        Program program48 = new Program("05:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program48);
        Program program49 = new Program("10:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program49);
        Program program50 = new Program("12:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program50);
        Program program51 = new Program("14:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program51);
        Program program52 = new Program("17:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program52);
        Program program53 = new Program("19:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program53);
        Program program54 = new Program("21:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program54);
        Program program55 = new Program("23:00", "DEMO PROGRAMA 2017", "V");
        programListViernes.add(program55);
        weekProgramList.add(programListViernes);

        //Set programs for Sabado//
        programListSabado = new ArrayList<>();
        Program program56 = new Program("00:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program56);
        Program program57 = new Program("02:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program57);
        Program program58 = new Program("03:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program58);
        Program program59 = new Program("05:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program59);
        Program program60 = new Program("10:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program60);
        Program program61 = new Program("12:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program61);
        Program program62 = new Program("14:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program62);
        Program program63 = new Program("17:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program63);
        Program program64 = new Program("19:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program64);
        Program program65 = new Program("21:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program65);
        Program program66 = new Program("23:00", "DEMO PROGRAMA 2017", "S");
        programListSabado.add(program66);
        weekProgramList.add(programListSabado);

        //Set programs for Domingo//
        programListDomingo = new ArrayList<>();
        Program program67 = new Program("00:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program67);
        Program program68 = new Program("02:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program68);
        Program program69 = new Program("03:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program69);
        Program program70 = new Program("05:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program70);
        Program program71 = new Program("10:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program71);
        Program program72 = new Program("12:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program72);
        Program program73 = new Program("14:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program73);
        Program program74 = new Program("17:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program74);
        Program program75 = new Program("19:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program75);
        Program program76 = new Program("21:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program76);
        Program program77 = new Program("23:00", "DEMO PROGRAMA 2017", "D");
        programListDomingo.add(program77);
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
