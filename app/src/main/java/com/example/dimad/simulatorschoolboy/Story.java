package com.example.dimad.simulatorschoolboy;

/**
 * Created by dimad on 21.12.2017.
 */

public class Story {

    private  Situation start_story;
    public  Situation current_situation;

    Story () {
        start_story = new Situation(
                "подготовка к школе", "Ты проснулся на полу, рядом с кроватью."
                            +"В комнате жуткий бардак, у тебя ужасно болит голова./n"
                            +"Вчера хорошо повеселились. Но уже 16 часов, тебе скоро в школу./n"
                            +"Найдя обрывок дневника, ты понимаешь, что сегодня последнее занятие"
                            +"в первой четверти, а это значит, что нужно готовиться к контрольной по математике./n"
                            +"Ты можешь попытаться подготовиться к работе или взломать электронный дневник", 4, 0,0);
        start_story.direction[0] = new Situation (
                "юный хакер", "Ты успешно взломал электронный дневник./n"
                            +"Теперь ты сам можешь ставить и исправлять любые оценки./n"
                            +"Главное – не спались.", 0, +20, 0);
        start_story.direction[1] =  new Situation (
                "не надо было прогуливать информатику", "Ты не смог взломать электронный дневник./n"
                +"Учителя обо всем узнают и будут топить тебя на контрольной.", 0,0, -20);
        start_story.direction[2] = new Situation (
                "и так сойдет", "Ты повторил часть материала./n"
                +"Если повезет, ты хорошо напишешь работу.", 0, 0, +20 );
        start_story.direction[3] = new Situation (
                "что-то пошло не так", "Ты в ужасном состоянии./n"
                +"Больная голова отказывается что-либо запоминать. Контрольную, скорее всего, ты завалишь.", 0, 0, -20 );
    }
    public void go(int num){
        if (num <=current_situation.direction.length)
            current_situation = current_situation.direction[num-1];

            //else вы можете выбрать из 4 вариантов
    }

    public boolean isEnd(){
        return current_situation.direction.length == 0;
    }
}
