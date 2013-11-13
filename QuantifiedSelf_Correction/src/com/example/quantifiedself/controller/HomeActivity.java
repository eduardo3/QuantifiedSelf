package com.example.quantifiedself.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qauntifiedself.model.Activity_;
import com.example.qauntifiedself.model.BMI;
import com.example.qauntifiedself.model.BloodPressure;
import com.example.qauntifiedself.model.BodyFat;
import com.example.qauntifiedself.model.Glucose;
import com.example.qauntifiedself.model.HeartRate;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.qauntifiedself.model.Weight;
import com.example.quantifiedself.R;

@SuppressLint("SimpleDateFormat")
public class HomeActivity extends Activity {

	private static final String BINARYFILE = "binaryFile";
	private QuantifiedSelf q;
	private Glucose g;
	private BloodPressure bp;
	private BMI bmi;
	private HeartRate hr;
	private Weight w;
	private Activity_ a;
	private BodyFat bodyF;
	private ListView lv;
	private ArrayList<String> lista;
	private ArrayAdapter<String> adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		lista = new ArrayList<String>();
		q = QuantifiedSelf.getInstance();

		readExternalBinary();
		

		lista.add("Glucose");
		lista.add("Blood Pressure");
		lista.add("BMI");
		lista.add("Activities");
		lista.add("Heart Rate");
		lista.add("Weight");
		lista.add("Body Fat");
		atualizarLista();

		registerForContextMenu(lv);
		lv.setOnCreateContextMenuListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Log.i("BB", "Entrei no metodo");

		if (featureId == Window.FEATURE_OPTIONS_PANEL) {
			if (item.getItemId() == R.id.profile) {
				Intent intent = new Intent(getApplicationContext(),
						PersonalInfoActivity.class);
				
				startActivity(intent);
			}
			
			else if(item.getItemId() == R.id.readExt){
				readExternalBinary();
			}
			else if(item.getItemId() == R.id.saveExt){
				Log.i("BB","ssssssssssssss");
				saveExternalBinary(); 
			}
			 
		}

		else if (featureId == Window.FEATURE_CONTEXT_MENU) {

			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			int position = info.position;

			Log.i("BB", "Entrei no metodo");

			if (item.getOrder() == 0 && position == 0) {
				Intent i = new Intent(getApplicationContext(),
						Glucose_Historic.class);
				startActivity(i);

			}
			if (item.getOrder() == 0 && position == 1) {
				Intent i = new Intent(getApplicationContext(),
						BloodPressure_Historic.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 2) {
				Intent i = new Intent(getApplicationContext(),
						BMI_Historic.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 3) {
				Intent i = new Intent(getApplicationContext(),
						Activity_Historic.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 4) {
				Intent i = new Intent(getApplicationContext(),
						HeartRateHistoric.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 5) {
				Intent i = new Intent(getApplicationContext(),
						WeightHistoric.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 6) {
				Intent i = new Intent(getApplicationContext(),
						BodyFatHistoric.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 7) {
				Intent i = new Intent(getApplicationContext(),
						Glucose_Historic.class);
				startActivity(i);
			}

			if (item.getOrder() == 1 && position == 0) {
				Intent i = new Intent(getApplicationContext(),
						Glucose_New.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 1) {
				Intent i = new Intent(getApplicationContext(),
						BloodPressureNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 2) {
				Intent i = new Intent(getApplicationContext(), BmiNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 3) {
				Intent i = new Intent(getApplicationContext(),
						ActivityNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 4) {
				Intent i = new Intent(getApplicationContext(),
						HeartRateNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 5) {
				Intent i = new Intent(getApplicationContext(), WeightNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 6) {
				Intent i = new Intent(getApplicationContext(), BodyFatNew.class);
				startActivity(i);
			}
			if (item.getOrder() == 1 && position == 7) {
				Intent i = new Intent(getApplicationContext(),
						Glucose_New.class);
				startActivity(i);
			}
		}

		return true;
	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lv);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lista);
		lv.setAdapter(adapter);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		menu.add(0, v.getId(), 0, "Historic");
		menu.add(0, v.getId(), 1, "New");

	}

	private static String actualLine;

	public void lerAssets() {

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					getAssets().open("leituras.txt")));

			String line = reader.readLine();

			// lê ficheiro por partes
			do {
				if (line.contains("{")) {
					Log.i("AA", "LER ASSETS" + line);
					do {
						parser2(IndicatorEnum.PERSON, line);
						line = reader.readLine();
					} while (!(line.startsWith("§ blood_glucose")));
				}
				if (line.contains("§ blood_glucose")) {
					parser(IndicatorEnum.BLOOD_GLUCOSE, reader);
					line = actualLine;
				}
				if (line.contains("§ blood_pressure")) {
					parser(IndicatorEnum.BLOOD_PRESSURE, reader);
					line = actualLine;
				}
				if (line.startsWith("§ bmi")) {
					parser(IndicatorEnum.BMI, reader);
					line = actualLine;
				}
				if (line.startsWith("§ body_fat")) {
					parser(IndicatorEnum.BODY_FAT, reader);
					line = actualLine;
				}
				if (line.startsWith("§ heart_rate")) {
					parser(IndicatorEnum.HEART_RATE, reader);
					line = actualLine;
				}
				if (line.contains("§ weight")) {
					parser(IndicatorEnum.WEIGHT, reader);
					line = actualLine;
				}
				if (line.startsWith("§ activities")) {
					parser(IndicatorEnum.ACTIVITIES, reader);
					line = actualLine;
				}

			} while (line == "§§");

		} catch (IOException e) {
		}

	}

	/*
	 * GLucose, BMI, Body_fat, heartRate, Weight
	 */
	public String[] getValuesToArray(String line) {
		String[] result = new String[4];
		result = line.trim().split("\\|");
		String id = result[0];
		String time = result[1];
		String value = result[2];
		String unit = result[3];
		Log.i("AA", id + "\t" + time + "\t" + value + "\t" + unit + "\n");
		return result;
	}

	public String[] getValuesToPerson(String line) {
		String[] result = new String[3];
		if (line != null) {
			String person;
			Log.i("AA", "Get Values to person " + line);
			person = line.substring(2, line.length() - 1);
			result = person.split("\\|");
		}
		return result;
	}

	public void parser2(IndicatorEnum ie, String line) {
		String[] strArray = null;
		switch (ie) {
		case PERSON:

			strArray = getValuesToPerson(line);
			q.setBirthDate(transformDatePerson(strArray[0]));
			q.setSex(strArray[1].trim().charAt(0));
			q.setHeight(transformDouble(strArray[2]));

			Log.i("AA", "PESSOA:  " + q);
			break;

		default:
			break;
		}
	}

	public void parser(IndicatorEnum ie, BufferedReader readerReceived) {
		String[] strArray = null;
		String line = null;
		switch (ie) {
		case BLOOD_GLUCOSE:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}

					strArray = getValuesToArray(line);

					g = new Glucose(Integer.parseInt(strArray[2].trim()),
							strArray[3], transformDate(strArray[1]));
					q.getListGlucose().add(g);

				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (line != null);
			break;

		case BLOOD_PRESSURE:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}
					String[] result = new String[5];
					result = line.trim().split("\\|");

					Log.i("AA", "BLOOD PRESSURE " + result[0] + "\t"
							+ result[1] + "\t" + result[2] + "\t" + result[3]
							+ result[4] + "\n");
					bp = new BloodPressure(Integer.parseInt(result[2].trim()),
							Integer.parseInt(result[3].trim()), result[4],
							transformDate(result[1]));
					q.getListBloodPressure().add(bp);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;
		case BMI:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}

					strArray = getValuesToArray(line);
					String a = strArray[2].replace(",", ".");
					Log.i("AA", "BMI : " + strArray[2] + "   " + strArray[3]
							+ " " + strArray[1]);
					bmi = new BMI(Double.parseDouble(a.trim()), strArray[3],
							transformDate(strArray[1]));
					q.getListBmi().add(bmi);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;

		case HEART_RATE:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}

					strArray = getValuesToArray(line);
					Log.i("AA", "HEART RATE : " + strArray[2] + "   "
							+ strArray[3] + " " + strArray[1]);
					hr = new HeartRate(Integer.parseInt(strArray[2].trim()),
							strArray[3], transformDate(strArray[1]));
					q.getHeartRateList().add(hr);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;
		case WEIGHT:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}

					strArray = getValuesToArray(line);
					Log.i("AA", "WEIGHT : " + strArray[2] + "   " + strArray[3]
							+ " " + strArray[1]);
					w = new Weight(Integer.parseInt(strArray[2].trim()),
							strArray[3], transformDate(strArray[1]));
					q.getListWeight().add(w);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;
		case ACTIVITIES:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}
					String[] result = new String[6];
					result = line.trim().split("\\|");
					Log.i("AA", "ACTIVITY  : " + result[1] + "   " + result[2]
							+ " " + result[3] + " " + result[4] + " "
							+ result[5]);
					a = new Activity_(transformDate(result[1]),
							transformDate(result[2]), result[3],
							Integer.parseInt(result[4].trim()), result[5]);
					q.getListActivity().add(a);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;
		case BODY_FAT:
			do {
				try {
					line = readerReceived.readLine();
					if (line.startsWith("id")) {
						line = readerReceived.readLine();
					}
					if (line.contains("§")) {
						actualLine = getLine(line);
						break;
					}

					strArray = getValuesToArray(line);
					Log.i("AA", "BMI : " + strArray[2] + "   " + strArray[3]
							+ " " + strArray[1]);
					bodyF = new BodyFat(Integer.parseInt(strArray[2].trim()),
							strArray[3], transformDate(strArray[1]));
					q.getBodyFatList().add(bodyF);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} while (line != null);
			break;
		default:
			break;

		}
	}

	@SuppressLint("SimpleDateFormat")
	public Date transformDate(String dateStr) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				Date finalDate = formatter.parse(dateStr);

				return finalDate;
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Date transformDatePerson(String dateStr) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			try {
				Date finalDate = formatter.parse(dateStr);

				return finalDate;
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double transformDouble(String doubleStr) {
		double finalDouble = Double.parseDouble(doubleStr.trim());

		return finalDouble;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1) {
			if (data != null
					&& data.getSerializableExtra("PERSON_EDITED") != null) {

				QuantifiedSelf finalPerson = (QuantifiedSelf) data
						.getSerializableExtra("PERSON_EDITED");
				q = finalPerson;

				Toast.makeText(getApplicationContext(),
						"1" + finalPerson.getSex(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	public String getLine(String line) {
		return line;
	}

	private void readExternalBinary() {

		FileInputStream input = null;
		ObjectInputStream inpStream = null;

		try {
			input = openFileInput(BINARYFILE);
			inpStream = new ObjectInputStream(input);
			q = (QuantifiedSelf) inpStream.readObject();

			q.setInstance(q);
			

		} catch (FileNotFoundException e) {
			lerAssets();
		} catch (StreamCorruptedException e) {
			lerAssets();
		} catch (IOException e) {
			lerAssets();
		} catch (ClassNotFoundException e) {
			lerAssets();
		} finally {
			try {
				if (inpStream != null)
					inpStream.close();
				if (input != null)
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveExternalBinary() {

		FileOutputStream output = null;
		ObjectOutputStream outStream = null;
		
		
		try {
			output = openFileOutput(BINARYFILE, Context.MODE_PRIVATE);
			outStream = new ObjectOutputStream(output);
			outStream.writeObject(q);
			Log.i("BB","gravei");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Log.i("BB","n gravei");
		} catch (IOException e) {
			e.printStackTrace();
			Log.i("BB","n gravei2");
		} finally {
			try {
				if (outStream != null)
					outStream.close();
				if (output != null)
					output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean onOptionsItemSelected(MenuItem item) { 
		switch(item.getItemId()) { 
		
		
	  default: return super.onOptionsItemSelected(item); } }
}
