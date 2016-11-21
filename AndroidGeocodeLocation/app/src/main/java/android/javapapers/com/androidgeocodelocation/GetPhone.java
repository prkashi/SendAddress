package android.javapapers.com.androidgeocodelocation;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class GetPhone extends AppCompatActivity {

    EditText motherphone, fatherphone, sisterphone, brotherphone,wifephone,husbandphone,othersphone;
    String mp, bp, fp, sp,wp,hp,op;
    Button save;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_phone);

        motherphone = (EditText) findViewById(R.id.mothernumber);
        sisterphone = (EditText) findViewById(R.id.sisternumber);
        fatherphone = (EditText) findViewById(R.id.fathernumber);
        brotherphone = (EditText) findViewById(R.id.brothernumber);
        wifephone = (EditText) findViewById(R.id.wifenumber);
        husbandphone = (EditText) findViewById(R.id.husbandnumber);
        othersphone = (EditText) findViewById(R.id.othersnumber);

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mp = motherphone.getText().toString();
                bp = brotherphone.getText().toString();
                fp = fatherphone.getText().toString();
                bp = brotherphone.getText().toString();
                wp = wifephone.getText().toString();
                hp = husbandphone.getText().toString();
                op = othersphone.getText().toString();

                if(db.getContactsCount()==0) {
                    db.addContact(new Contact("Father", null));
                    db.addContact(new Contact("Mother", null));
                    db.addContact(new Contact("Sister", null));
                    db.addContact(new Contact("Brother", null));
                    db.addContact(new Contact("Wife", null));
                    db.addContact(new Contact("Husband", null));
                    db.addContact(new Contact("Other", null));
                    Log.d("Insert: ", "Inserting ..");
                }
              // db.deleteAll(new Contact());
                         else{
                    if(db.getContact(1)== null)
                        db.addContact(new Contact("Father", fp));
                    else{
                        db.updateContact(new Contact(1,"Father",fp));
                    }
                    if(db.getContact(2)==null)
                        db.addContact(new Contact("Mother", mp));
                    else{
                        db.updateContact(new Contact(2,"Mother",mp));
                    }
                    if(db.getContact(3)==null)
                        db.addContact(new Contact("Sister", sp));
                    else{
                        db.updateContact(new Contact(3,"Sister",sp));
                    }
                    if(db.getContact(4)==null)
                        db.addContact(new Contact("Brother", bp));
                    else{
                        db.updateContact(new Contact(4,"Brother",bp));
                    }
                    if(db.getContact(5)==null)
                        db.addContact(new Contact("Wife", wp));
                    else{
                        db.updateContact(new Contact(5,"Wife",wp));
                    }
                    if(db.getContact(6)==null)
                        db.addContact(new Contact("Husband", hp));
                    else{
                        db.updateContact(new Contact(6,"Husband",hp));
                    }
                    if(db.getContact(7)==null)
                        db.addContact(new Contact("Other", op));
                    else{
                        db.updateContact(new Contact(7,"Other",op));
                    }

                }

                //db.deleteContact(new Contact(4,"Father",fp));
               // db.deleteAll(new Contact());



                Log.d("Reading: ", "Reading all contacts..");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }
            }
            });

    }
    public void destLogin(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }
}
