package com.sih.dorec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.telecom.TelecomManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner fromId, toId;
    EditText enteredId;
    TextView searchBtn;
    ConstraintLayout root;

    ArrayList<AadharUtil> aadharList = new ArrayList<>();
    ArrayList<PanUtil> panList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromId = findViewById(R.id.fromId);
        toId = findViewById(R.id.toId);
        enteredId = findViewById(R.id.enteredId);
        searchBtn = findViewById(R.id.searchBtn);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        AadharUtil temp = new AadharUtil();
        temp.setAadhar("807223000000");
        temp.setFirstName("aakash");
        temp.setDob("29-06-1981");
        temp.setLastName("badhe");
        temp.setFatherName("deepak");
        temp.setCity("94 D;M.G. Railway Colony;Bengaluru");

        aadharList.add(temp);


        temp = new AadharUtil();
        temp.setAadhar("807223000001");
        temp.setFirstName("aakib");
        temp.setLastName("batliwalla");
        temp.setDob("03-04-1989");
        temp.setFatherName("bhura");
        temp.setCity("669;near LNUPE Camus;Kampoo;Gwalior");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000002");
        temp.setFirstName("aamir");
        temp.setLastName("bhushan");
        temp.setDob("07-11-1995");
        temp.setFatherName("ashish");
        temp.setCity("139 ;Chetak;Bhubaneshwar ");

        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000003");
        temp.setFirstName("aamir");
        temp.setLastName("ganatra");
        temp.setDob("29-10-1996");
        temp.setFatherName("sunil");
        temp.setCity("111 ; Bombay Talkies Company; Malad(w); Mumbai");

        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000004");
        temp.setFirstName("aanamika");
        temp.setLastName("chimalwar");
        temp.setDob("07-03-1996");
        temp.setFatherName("sukhbeer");
        temp.setCity("76 - 49; Parshva Nemji; Ebrahim Sahib Street; Bangalore");

        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000011");
        temp.setFirstName("aarti");
        temp.setLastName("handoo");
        temp.setDob("24-03-1997");
        temp.setFatherName("abdul");
        temp.setCity("268 B one tree hills;near SHN ;Delhi");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000009");
        temp.setFirstName("aarti");
        temp.setLastName("gopalan");
        temp.setDob("23-01-1997");
        temp.setFatherName("arvind");
        temp.setCity("123 ;Chetak;Bhubaneshwar ");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000010");
        temp.setFirstName("aarti");
        temp.setLastName("gulgule");
        temp.setDob("26-02-1997");
        temp.setFatherName("hajrat");
        temp.setCity("59 ;Kharkai Link Road;Jamshedpur;Jharkhand");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000007");
        temp.setFirstName("aarti");
        temp.setLastName("dikshit");
        temp.setDob("06-08-1996");
        temp.setFatherName("harsh");
        temp.setCity("123 ;Kharkai Link Road;Jamshedpur;Jharkhand");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000008");
        temp.setFirstName("aarti");
        temp.setLastName("ghoshal");
        temp.setDob("20-12-1996");
        temp.setFatherName("khemchand");
        temp.setCity("23 ; Aziz Mulk 7th Street; Thousand Lights; Chennai");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000006");
        temp.setFirstName("aarti");
        temp.setLastName("bajaj");
        temp.setDob("26-01-1983");
        temp.setFatherName("vakil");
        temp.setCity("66 ; Muniyappa Cplx; Agrahara Dasarahalli; Banglore");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000005");
        temp.setFirstName("aarti");
        temp.setLastName("bafna");
        temp.setDob("07-01-1982");
        temp.setFatherName("vinay");
        temp.setCity("98 ; Muniyappa Cplx; Agrahara Dasarahalli; Banglore");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000012");
        temp.setFirstName("aarti");
        temp.setLastName("hirlekar");
        temp.setDob("03-05-1997");
        temp.setFatherName("yogesh");
        temp.setCity("138; Nagdevi Street; Mandvi; Mumbai");


        aadharList.add(temp);

        temp = new AadharUtil();
        temp.setAadhar("807223000013");
        temp.setFirstName("aashiya");
        temp.setLastName("dhanoa");
        temp.setDob("11-07-1996");
        temp.setFatherName("pankaj");
        temp.setCity("612 Gaushalalane; Daftary Rd; Malad (east); Mumbai");


        aadharList.add(temp);

        //Pan

        PanUtil temp1 = new PanUtil();
        temp1.setPan("BZBP1002");
        temp1.setFistName("Aakis");
        temp1.setDob("11/11/1977");
        temp1.setLastName("Sharma");
        temp1.setFatherName("Bhura");
        temp1.setCity("Bhopal");

        panList.add(temp1);


        temp1 = new PanUtil();
        temp1.setPan("BZPY34893");
        temp1.setFistName("aakush");
        temp1.setLastName("bahe");
        temp1.setDob("29-06-1981");
        temp1.setFatherName("deepak");
        temp1.setCity("94 D;M.G. Railway Colony;Bengaluru");


        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("CTAS34977");
        temp1.setFistName("askib");
        temp1.setLastName("batliwlla");
        temp1.setDob("03-04-1989");
        temp1.setFatherName("bhura");
        temp1.setCity("669;near LNUPE Camus;Kampoo;Gwalior");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("JKJU35420");
        temp1.setFistName("amir");
        temp1.setLastName("bhugfshan");
        temp1.setDob("07-11-1995");
        temp1.setFatherName("ashish");
        temp1.setCity("139 ;Chetak;Bhubaneshwar ");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("DJNV35386");
        temp1.setFistName("aam");
        temp1.setLastName("ganata");
        temp1.setDob("29-10-1996");
        temp1.setFatherName("sunil");
        temp1.setCity("111 ; Bombay Talkies Company; Malad(w); Mumbai");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("STMK34823");
        temp1.setFistName("aanamik");
        temp1.setLastName("chimamwar");
        temp1.setDob("07-03-1996");
        temp1.setFatherName("sukhbeer");
        temp1.setCity("76 - 49; Parshva Nemji; Ebrahim Sahib Street; Bangalore");


        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("DJNV35224");
        temp1.setFistName("awrti");
        temp1.setLastName("bakna");
        temp1.setDob("07-01-1982");
        temp1.setFatherName("vinay");
        temp1.setCity("268 B one tree hills;near SHN ;Delhi");


        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BAGJ34712");
        temp1.setFistName("arti");
        temp1.setLastName("bahaj");
        temp1.setDob("26-01-1983");
        temp1.setFatherName("vakil");
        temp1.setCity("123 ;Chetak;Bhubaneshwar ");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("DJNV35260");
        temp1.setFistName("aarthi");
        temp1.setLastName("dekshit");
        temp1.setDob("06-08-1996");
        temp1.setFatherName("harsh");
        temp1.setCity("59 ;Kharkai Link Road;Jamshedpur;Jharkhand");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BAGJ34632");
        temp1.setFistName("arthi");
        temp1.setLastName("ghishal");
        temp1.setDob("20-12-1996");
        temp1.setFatherName("khemchand");
        temp1.setCity("123 ;Kharkai Link Road;Jamshedpur;Jharkhand");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BZPY34841");
        temp1.setFistName("artee");
        temp1.setLastName("gopalan");
        temp1.setDob("23-01-1987");
        temp1.setFatherName("arvind");
        temp1.setCity("23 ; Aziz Mulk 7th Street; Thousand Lights; Chennai");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("JKJU35481");
        temp1.setFistName("aartee");
        temp1.setLastName("gulgule");
        temp1.setDob("26-12-1997");
        temp1.setFatherName("hajrat");
        temp1.setCity("66 ; Muniyappa Cplx; Agrahara Dasarahalli; Banglore");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("TRTD35120");
        temp1.setFistName("aar");
        temp1.setLastName("handoo");
        temp1.setDob("04-03-1997");
        temp1.setFatherName("abdul");
        temp1.setCity("98 ; Muniyappa Cplx; Agrahara Dasarahalli; Banglore");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BZPY34883");
        temp1.setFistName("aartu");
        temp1.setLastName("hirlekar");
        temp1.setDob("13-05-1997");
        temp1.setFatherName("yogesh");
        temp1.setCity("138; Nagdevi Street; Mandvi; Mumbai");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BAGJ34633");
        temp1.setFistName("ashiya");
        temp1.setLastName("dhanoa");
        temp1.setDob("21-07-1996");
        temp1.setFatherName("pankaj");
        temp1.setCity("612 Gaushalalane; Daftary Rd; Malad (east); Mumbai");

        panList.add(temp1);

        temp1 = new PanUtil();
        temp1.setPan("BZPY34954");
        temp1.setFistName("aasmeen");
        temp1.setLastName("chabukswar");
        temp1.setDob("26-02-1995");
        temp1.setFatherName("gordhan");
        temp1.setCity("Gut No 608/2;Lavasa Road;Pune");

        panList.add(temp1);


        root = findViewById(R.id.root);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("DB1");
        spinnerArray.add("DB2");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.spinner_back, spinnerArray);

        adapter.setDropDownViewResource(R.layout.spinner_list);
        fromId.setAdapter(adapter);
        toId.setAdapter(adapter);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = enteredId.getText().toString();
                long from = fromId.getSelectedItemId();
                long to = toId.getSelectedItemId();

//                String elements[] = id.split(" ");
//
//                Toast.makeText(MainActivity.this, jaro_Winkler(elements[0], elements[1]) * 100 + "", Toast.LENGTH_SHORT).show();

//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                String url = "https://www.google.com";
//
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                enteredId.setText("Response is: " + response.substring(0,500));
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        enteredId.setText("That didn't work!");
//                    }
//                });
//
//// Add the request to the RequestQueue.
//                queue.add(stringRequest);



                if(from == 0 && to == 1){
                    int i;
                    for(i=0; i<aadharList.size(); i++){
                        if(aadharList.get(i).getAadhar().equals(id)){
                            break;
                        }
                    }
                    if(i==aadharList.size())
                        Toast.makeText(MainActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                    else
                        showPopup(i, true);

                }
                else if(from == 1 && to == 0){
                    int i;
                    for(i=0; i<panList.size(); i++){
                        if(panList.get(i).getPan().equals(id)){
                            break;
                        }
                    }
                    if(i==panList.size())
                        Toast.makeText(MainActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                    else
                        showPopup(i, false);
                }
                else{
                    Toast.makeText(MainActivity.this, "Select different Databases to Perform Search", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void showPopup(int i, boolean searchInSecond) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(root, Gravity.CENTER, 0, 0);

        RecyclerView resultRV = popupView.findViewById(R.id.resultRV);
        TextView id, fName, lName, dob, father, address;

        id = popupView.findViewById(R.id.idDb1);
        fName = popupView.findViewById(R.id.fNameDb1);
        lName = popupView.findViewById(R.id.lNameDb1);
        dob = popupView.findViewById(R.id.dobDb1);
        father = popupView.findViewById(R.id.fatherDb1);
        address = popupView.findViewById(R.id.cityDbName);

        ResultAdapter adapter;
        ResultAdapterPan adapterPan;

        resultRV.setHasFixedSize(true);
        resultRV.setLayoutManager(new LinearLayoutManager(this));

        if(searchInSecond) {
            id.setText(aadharList.get(i).getAadhar());
            fName.setText(aadharList.get(i).getFirstName());
            lName.setText(aadharList.get(i).getLastName());
            dob.setText(aadharList.get(i).getDob());
            father.setText(aadharList.get(i).getFatherName());
            address.setText(aadharList.get(i).getCity());
            adapter = new ResultAdapter(panList, aadharList.get(i), this.getApplicationContext());
            resultRV.setAdapter(adapter);
        }
        else {
            id.setText(panList.get(i).getPan());
            fName.setText(panList.get(i).getFistName());
            lName.setText(panList.get(i).getLastName());
            dob.setText(panList.get(i).getDob());
            father.setText(panList.get(i).getFatherName());
            address.setText(panList.get(i).getCity());
            adapterPan = new ResultAdapterPan(aadharList, panList.get(i), this.getApplicationContext());
            resultRV.setAdapter(adapterPan);
        }

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}