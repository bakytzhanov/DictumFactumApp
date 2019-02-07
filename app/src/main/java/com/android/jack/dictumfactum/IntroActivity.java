package com.android.jack.dictumfactum;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.color1)
                        .buttonsColor(R.color.btncolor)
                        .image(com.android.jack.dictumfactum.R.drawable.sh_law)
                        .title("Раздел Правоотношения")
                        .description("Содержит в себе определения и понятия различных правоотношений, а также полезные советы и часто задаваемые вопросы.")
                        .build()
                );

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.color2)
                .buttonsColor(R.color.btncolor)
                .image(com.android.jack.dictumfactum.R.drawable.sh_users)
                .title("Раздел Новостная лента")
                .description("Позволит Вам просматривать актуальную информацию о той или иной сфере правоотношений.")
                .build()
        );

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.color3)
                .buttonsColor(R.color.btncolor)
                .image(com.android.jack.dictumfactum.R.drawable.sh_chat)
                .title("Раздел Чаты")
                .description("Обеспечивает Вас возможностью взаимодействовать с юристом/пользователем.")
                .build()
        );

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.color4)
                .buttonsColor(R.color.btncolor)
                .image(com.android.jack.dictumfactum.R.drawable.sh_profile)
                .title("Раздел Профиль")
                .description("Служит для размещения своего вопроса или информации о себе.")
                .build()
        );

    }
}
