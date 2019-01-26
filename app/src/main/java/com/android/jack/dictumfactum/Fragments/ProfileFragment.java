package com.android.jack.dictumfactum.Fragments;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ArrayAdapter;

import com.android.jack.dictumfactum.Model.User;
import com.android.jack.dictumfactum.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class ProfileFragment extends Fragment {


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

    CircleImageView image_profile;
    TextView username;
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


    StorageReference storageReference;
    private static final int IMAGE_REQUEST = 1;
    private Uri imageUri;
    private StorageTask uploadTask;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        image_profile = view.findViewById(R.id.profile_image);
        username = view.findViewById(R.id.username);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);
        t4 = view.findViewById(R.id.t4);

        e2 = view.findViewById(R.id.e2);

        ch1 = view.findViewById(R.id.ch1);
        ch2 = view.findViewById(R.id.ch2);
        ch3 = view.findViewById(R.id.ch3);
        ch4 = view.findViewById(R.id.ch4);
        ch5 = view.findViewById(R.id.ch5);
        ch6 = view.findViewById(R.id.ch6);
        ch7 = view.findViewById(R.id.ch7);
        ch8 = view.findViewById(R.id.ch8);

        textViewRed1 = view.findViewById(R.id.textViewRed1);
        textViewRed2 = view.findViewById(R.id.textViewRed2);
        textViewRed3 = view.findViewById(R.id.textViewRed3);
        textViewRed4 = view.findViewById(R.id.textViewRed4);
        textViewRed5 = view.findViewById(R.id.textViewRed5);
        textViewRed6 = view.findViewById(R.id.textViewRed6);
        textViewRed7 = view.findViewById(R.id.textViewRed7);
        textViewRed8 = view.findViewById(R.id.textViewRed8);


        simpleMultiAutoCompleteTextView = view.findViewById(R.id.simpleMultiAutoCompleteTextView);

        btn_save_profile = view.findViewById(R.id.btn_save_profile);




        // initiate a MultiAutoCompleteTextView
     //   MultiAutoCompleteTextView simpleMultiAutoCompleteTextView = (MultiAutoCompleteTextView) view.findViewById(R.id.simpleMultiAutoCompleteTextView);
// set adapter to fill the data in suggestion list
        ArrayAdapter<String> versionNames = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, androidVersionNames);
        simpleMultiAutoCompleteTextView.setAdapter(versionNames);

// set threshold value 1 that help us to start the searching from first character
        simpleMultiAutoCompleteTextView.setThreshold(1);
// set tokenizer that distinguish the various substrings by comma
        simpleMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());






        storageReference = FirebaseStorage.getInstance().getReference("uploads");

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    image_profile.setImageResource(R.mipmap.ic_launcher);
                }else {
                    Glide.with(getContext()).load(user.getImageURL()).into(image_profile);
                }

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


            }
        });

        image_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImage();
            }
        });

        return view;
    }

    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }


    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContext().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }


    private void uploadImage(){
        final ProgressDialog pd = new ProgressDialog(getContext());
        pd.setMessage("Загружается");
        pd.show();


        if(imageUri != null){
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis()
            +"."+getFileExtension(imageUri));

            uploadTask = fileReference.putFile(imageUri);
            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot,Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {

                    if(task.isSuccessful()){
                        Uri downloadUri = task.getResult();
                        String mUri = downloadUri.toString();

                        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("imageURL", mUri);
                        reference.updateChildren(map);

                        pd.dismiss();
                    }else{
                        Toast.makeText(getContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
            });
        }else{
            Toast.makeText(getContext(), "Не выбран рисунок", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();



            if(uploadTask != null && uploadTask.isInProgress()){
                Toast.makeText(getContext(), "Загрузка", Toast.LENGTH_SHORT).show();
            }else{
                uploadImage();
            }
        }

    }
}
