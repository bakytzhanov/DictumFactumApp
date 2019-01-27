package com.android.jack.dictumfactum;

import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.android.jack.dictumfactum.Model.User;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileChangeActivity extends AppCompatActivity {



    String[] androidVersionNames = {
            "Айдабул",
            "Акколь",
            "Аксу",
            "Алексеевка",
            "Атбасар",
            "Баймурза",
            "Бурабай",
            "Державинск",
            "Ерейментау",
            "Запорожье",
            "Зеренда",
            "Кабанбай Батыр",
            "Кокшетау",
            "Куйгенжар",
            "Курское",
            "Макинск",
            "Максимовка",
            "Малиновка",
            "Новочеркаское",
            "Степногорск",
            "Талапкер",
            "Шортанды",
            "Щучинск",
            "Актобе",
            "Алга",
            "Батамшинский",
            "Кандыагаш",
            "Каргалинское",
            "Мартук",
            "Хромтау",
            "Шалкар",
            "Шубаркудук",
            "Эмба",
            "Абай",
            "Азат",
            "Актерек",
            "Алатау",
            "Алгабас",
            "Алгабас",
            "Алдабергенов",
            "Алмалыбак",
            "Байсерке",
            "Бахтыбай",
            "Бесагаш",
            "Боралдай",
            "Булакты",
            "Декабрь",
            "Екпенды",
            "Екпенды",
            "Енбекши",
            "Ерменсай",
            "Есик",
            "Жана-Арна",
            "Жаркент",
            "Кабанбай",
            "Каменка",
            "Капчагай",
            "Карабулак",
            "Каскелен",
            "Кемиртоган",
            "Кендала",
            "Кербулак",
            "Ключи",
            "Косозен",
            "Маловодное",
            "Мамыр",
            "Мерке",
            "Мухаметжан Туймебаева",
            "Отеген Батыр",
            "Мерей",
            "Ынтымак",
            "Первомайка",
            "Бастобе",
            "Саймасай",
            "Сарыозек",
            "Талгар",
            "Талдыкорган",
            "Текели",
            "Теректы",
            "Туздыбастау",
            "Узынагаш",
            "Умбеталы",
            "Ушарал",
            "Ушконыр (Шамалган)",
            "Уштобе",
            "Фабричный",
            "Чемолган",
            "Чимбулак",
            "Чунджа",
            "Шелек",
            "Шенгельды",
            "Шынты",
            "Алматы",
            "Курылысши",
            "Астана",
            "Акколь",
            "Атырау",
            "Ганюшкино",
            "Жаскайрат",
            "Кульсары",
            "Махамбет",
            "Тенгиз",
            "Асу-Булак",
            "Атыбай",
            "Аягоз",
            "Глубоков",
            "Зайсан",
            "Зыряновск",
            "Кабалтау",
            "Курчатов",
            "Маканчи",
            "Новая согра",
            "Ново-Хайрузовка",
            "Первомайский",
            "Риддер",
            "Семей",
            "Семипалатинск",
            "Серебрянск",
            "Солнечное",
            "Теремшамка",
            "Тугул",
            "Усть-Каменогорск",
            "Шар",
            "Шемонаиха",
            "Айша-Биби",
            "Айша-Биби",
            "Ерназар",
            "Жанатас",
            "Каратау",
            "Кордай",
            "Кулан",
            "Мерке",
            "Б.Момышулы",
            "Степное",
            "Тараз",
            "Шу",
            "Шынты",
            "Аксай",
            "Актау",
            "Жангала",
            "Зачаганск",
            "Казталовка",
            "Каменка",
            "Переметное",
            "Переметное",
            "Сайхин",
            "Тайпак",
            "Трекино",
            "Уральск",
            "Федоровка",
            "Абай",
            "Агадырь",
            "Актау",
            "Балхаш",
            "Дубовка",
            "Жезды",
            "Жезказган",
            "Караганда",
            "Каражал",
            "Каркаралинск",
            "Осакаровка",
            "Сарань",
            "Сатпаев",
            "Темиртау",
            "Топар",
            "Шахтинск",
            "Шашубай",
            "Аманкарагай",
            "Аркалык",
            "Аулиеколь",
            "Жалгыскан",
            "Житикара",
            "Затобольск",
            "Камысты",
            "Карабалык",
            "Костанай",
            "Кушмурун",
            "Лисаковск",
            "Приозёрный",
            "Раздольный",
            "Рудный",
            "Садовое",
            "Сарыколь",
            "Силантьевка",
            "Тарановское",
            "Узунколь",
            "Федоровка",
            "Айтеке Би",
            "Аральск",
            "Жанакорган",
            "Жосалы",
            "Казалинск",
            "Кызылорда",
            "Макпалколь",
            "Теренозек",
            "Торебай Би",
            "Шиели",
            "Актау",
            "Актобе",
            "Бейнеу",
            "Жанаозен",
            "Умирзак",
            "Форт-Шевченко",
            "Шетпе",
            "Акжар",
            "Аксу",
            "Актогай",
            "Ефремовка",
            "Калкаман",
            "Коктобе",
            "Майкаин",
            "Павлодар",
            "Шидерты",
            "Экибастуз",
            "Бишкуль",
            "Булаево",
            "Имантау",
            "Ленинградское",
            "Мамлютка",
            "Новоишимское",
            "Петропавловск",
            "Саратов",
            "Саумалколь",
            "Тайынша",
            "Аксукент",
            "Арысь",
            "Асык Ата",
            "Атакент",
            "Жетысай",
            "Казыбек би",
            "Кентау",
            "Коктерек",
            "Кызылсай",
            "Ленгер",
            "Ошакты",
            "Шубар",
            "Сайрам",
            "Сарыагаш",
            "Тайынша",
            "Туркестан",
            "Чилик",
            "Шардара",
            "Шымкент",
            "Акмолинская область",
            "Актюбинская область",
            "Алматинская область",
            "Атырауская область",
            "Восточно-Казахстанская область",
            "Жамбылская область",
            "Западно-Казахстанская область",
            "Карагандинская область",
            "Костанайская область",
            "Туркестанская область",
            "Кызылординская область",
            "Мангистауская область",
            "Павлодарская область",
            "Северо-Казахстанская область",
            "Южно-Казахстанская область"};

    TextView t2;
    TextView t3;
    TextView t4;

    EditText e2;

    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    CheckBox ch5;
    CheckBox ch6;
    CheckBox ch7;
    CheckBox ch8;

    TextView textViewRed1;
    TextView textViewRed2;
    TextView textViewRed3;
    TextView textViewRed4;
    TextView textViewRed5;
    TextView textViewRed6;
    TextView textViewRed7;
    TextView textViewRed8;

    MultiAutoCompleteTextView simpleMultiAutoCompleteTextView;

    Button btn_save_profile;

    String txt_ch;

    DatabaseReference reference;
    FirebaseUser fuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_change);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Изменение профиля");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

        e2 = findViewById(R.id.e2);

        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);
        ch7 = findViewById(R.id.ch7);
        ch8 = findViewById(R.id.ch8);

        textViewRed1 = findViewById(R.id.textViewRed1);
        textViewRed2 = findViewById(R.id.textViewRed2);
        textViewRed3 = findViewById(R.id.textViewRed3);
        textViewRed4 = findViewById(R.id.textViewRed4);
        textViewRed5 = findViewById(R.id.textViewRed5);
        textViewRed6 = findViewById(R.id.textViewRed6);
        textViewRed7 = findViewById(R.id.textViewRed7);
        textViewRed8 = findViewById(R.id.textViewRed8);


        simpleMultiAutoCompleteTextView = findViewById(R.id.simpleMultiAutoCompleteTextView);

        btn_save_profile = findViewById(R.id.btn_save_profile);


        // initiate a MultiAutoCompleteTextView
        //   MultiAutoCompleteTextView simpleMultiAutoCompleteTextView = (MultiAutoCompleteTextView) view.findViewById(R.id.simpleMultiAutoCompleteTextView);
// set adapter to fill the data in suggestion list
        ArrayAdapter<String> versionNames = new ArrayAdapter<String>(ProfileChangeActivity.this, android.R.layout.simple_list_item_1, androidVersionNames);
        simpleMultiAutoCompleteTextView.setAdapter(versionNames);

// set threshold value 1 that help us to start the searching from first character
        simpleMultiAutoCompleteTextView.setThreshold(1);
// set tokenizer that distinguish the various substrings by comma
        simpleMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());



        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);


                if(user.getLawyer_status().equals("lawyer")){
                    t2.setText("Расскажите пользователям о себе:");
                    t3.setText("Выберите свою специализацию:");
                    t4.setText("Выберите место деятельности:");

                }else{
                    t2.setText("Задайте свой вопрос:");
                    t3.setText("Выберите интересующую вас область:");
                    t4.setText("Место (область, город где необходима помощь):");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_e2 = e2.getText().toString();
                String txt_simpleMultiAutoCompleteTextView = simpleMultiAutoCompleteTextView.getText().toString();

                String txt_ch1;
                String txt_ch2;
                String txt_ch3;
                String txt_ch4;
                String txt_ch5;
                String txt_ch6;
                String txt_ch7;
                String txt_ch8;
/*

                if(ch1.isChecked() == true){
                    txt_ch1 = textViewRed1.getText().toString();
                }else if(ch1.isChecked() == false){
                    txt_ch1 = "";
                }else if(ch2.isChecked() == true){
                    txt_ch2 = textViewRed2.getText().toString();
                }else if(ch2.isChecked() == false){
                    txt_ch2 = "";
                }else if(ch3.isChecked() == true){
                    txt_ch3 = textViewRed3.getText().toString();
                }else if(ch3.isChecked() == false){
                    txt_ch3 = "";
                }else if(ch4.isChecked() == true){
                    txt_ch4 = textViewRed4.getText().toString();
                }else if(ch4.isChecked() == false){
                    txt_ch4 = "";
                }else if(ch5.isChecked() == true){
                    txt_ch5 = textViewRed5.getText().toString();
                }else if(ch5.isChecked() == false){
                    txt_ch5 = "";
                }else if(ch6.isChecked() == true){
                    txt_ch6 = textViewRed6.getText().toString();
                }else if(ch6.isChecked() == false){
                    txt_ch6 = "";
                }else if(ch7.isChecked() == true){
                    txt_ch7 = textViewRed7.getText().toString();
                }else if(ch7.isChecked() == false){
                    txt_ch7 = "";
                }else if(ch8.isChecked() == true){
                    txt_ch8 = textViewRed8.getText().toString();
                }else if(ch8.isChecked() == false){
                    txt_ch8 = "";
                }*/

                if(ch1.isChecked()){
                    txt_ch1 = textViewRed1.getText().toString();
                }else{
                    txt_ch1 = "";
                    ch1.setChecked(false);
                }
                if(ch2.isChecked()){
                    txt_ch2 = textViewRed2.getText().toString();
                }else{
                    txt_ch2 = "";
                    ch2.setChecked(false);
                }
                if(ch3.isChecked()){
                    txt_ch3 = textViewRed3.getText().toString();
                }else{
                    txt_ch3 = "";
                    ch3.setChecked(false);
                }
                if(ch4.isChecked()){
                    txt_ch4 = textViewRed4.getText().toString();
                }else{
                    txt_ch4 = "";
                    ch4.setChecked(false);
                }
                if(ch5.isChecked()){
                    txt_ch5 = textViewRed5.getText().toString();
                }else{
                    txt_ch5 = "";
                    ch5.setChecked(false);
                }
                if(ch6.isChecked()){
                    txt_ch6 = textViewRed6.getText().toString();
                }else{
                    txt_ch6 = "";
                    ch6.setChecked(false);
                }
                if(ch7.isChecked()){
                    txt_ch7 = textViewRed7.getText().toString();
                }else{
                    txt_ch7 = "";
                    ch7.setChecked(false);
                }
                if(ch8.isChecked()){
                    txt_ch8 = textViewRed8.getText().toString();
                }else{
                    txt_ch8 = "";
                    ch8.setChecked(false);
                }



                txt_ch = txt_ch1 + " " + txt_ch2 + " " + txt_ch3 + " " + txt_ch4 + " " + txt_ch5 + " " + txt_ch6 + " " + txt_ch7 + " " + txt_ch8;

                //  Toast.makeText(getActivity(),txt_ch, Toast.LENGTH_SHORT).show();



                reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("e2", txt_e2);
                hashMap.put("ch", txt_ch);
                hashMap.put("autoc", txt_simpleMultiAutoCompleteTextView);

                reference.updateChildren(hashMap);

                finish();
            }
        });

    }
}
