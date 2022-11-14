require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /hello
        random:
            a: Добрый день! Я могу рассказать вам о погоде или курсе валют.
            a: Привет-привет. Я могу предоставить информацию о погоде или курсе валют.
            a: Здравствуйте! Я могу помочь вам узнать о погоде или курсе валют.
        go!: /Сhoice
        
    state: Choice
        a: Что бы вы хотели узнать?
        buttons:
            "Прогноз погоды"
            "Курс валют"
        
        state: Weather
            intent!: /weather
            random:
                a: Прогноз погоды на сегодня: солнечно, без осадков, ветер 5 м/с, +20 градусов по цельсия 
                a: Прогноз погоды на сегодня: ливень, ветер 3 м/с, +8 градусов по цельсия 
                a: Прогноз погоды на сегодня: переменная облачность, местами дожди, +3 градусов по цельсия 
        
        state: Money
            intent!: /currancy
            random:
                a: Доллар - 70 рублей, евро - 86 рублей
                a: Доллар - 75 рублей, евро - 90 рублей
                a: Доллар - 69 рублей, евро - 84 рублей
                
        state: LocalCatchALL
            event: noMatch
            a: Такого функционала у меня нет.
            go!: .. 
        

    state: NoMatch || noContext = true
        event!: noMatch
        a: Простите, я вас не понял. 
