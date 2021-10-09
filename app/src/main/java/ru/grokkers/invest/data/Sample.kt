package ru.grokkers.invest.data

import ru.grokkers.invest.R
import ru.grokkers.invest.data.model.Education

/**
 * @author Onanov Aleksey (@onanov)
 */
object Sample {

    val education = listOf<Education>(
        Education(
            id = 0,
            title = "Первые шаги во вклады",
            level = 0,
            description = "Первые шаги во вкладах для начинающих",
            content = "<blockquote>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"0\" data-line-end=\"5\">В России мало кто умеет грамотно распоряжаться деньгами. В большинстве<br>\n" +
                    "случаев люди покупают валюту, открывают депозит в банке или просто<br>\n" +
                    "собирают деньги в конверт — копят. Многие считают, что этого<br>\n" +
                    "достаточно. В результате инфляция или обвалившийся курс валюты могут<br>\n" +
                    "обесценить сбережения и человек потеряет свои деньги.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 class=\"code-line\" data-line-start=6 data-line-end=7 ><a id=\"_____6\"></a>Почему нельзя надеяться на депозит</h2>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"8\" data-line-end=\"9\">С начала 2019 года Центральный Банк Российской Федерации постепенно снижает ключевую ставку. Из-за этого проценты по депозитам упали почти в 2 раза — вместо 6−7 %, как в прошлом году, сейчас банки предлагают 3−4 %. А инфляция растёт — за 9 месяцев 2020 года она составила 3,67 %, а за последние 5 лет — 22,13 %. Это значит, что если бы вы 5 лет назад отложили 1 млн ₽, то сегодня эта сумма была бы эквивалентна 800 000 ₽, так как цены выросли. То есть вы просто так, на пустом месте, потеряли бы 200 000 ₽.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"10\" data-line-end=\"11\"><em><strong>Вот так растёт инфляция в России</strong></em></p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"12\" data-line-end=\"13\">Если бы вы положили этот миллион на депозит, то деньги бы не потеряли, но и ничего не заработали — процент по вкладу чуть больше инфляции. То есть депозит работает, скорее, как простое сбережение денег.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"14\" data-line-end=\"15\">Инвестиции позволяют получить доход больше, чем по вкладу. Например, вот данные по доходности за 10 лет:</p>\n" +
                    "<ul>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"16\" data-line-end=\"17\">депозиты — 6,3 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"17\" data-line-end=\"18\">государственные облигации — 9,8 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"18\" data-line-end=\"19\">акции США — 15,3 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"19\" data-line-end=\"21\">российские акции — 24,8 % годовых.</li>\n" +
                    "</ul>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"21\" data-line-end=\"22\">Гораздо выгодней, чем депозиты.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=23 data-line-end=24 ><a id=\"___23\"></a>Зачем нужно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"25\" data-line-end=\"26\">Инвестиции помогают накопить на обучение, путешествия, новую машину, дом в Испании, пенсию и на что угодно ещё. Чем раньше вы начнёте инвестировать, тем быстрее достигнете своей финансовой цели.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"27\" data-line-end=\"28\">Инвестировать можно не только для того, чтобы получить доход. Грамотные инвестиции в разных валютах могут обезопасить вас от того, что конкретно в вашей стране произойдет кризис. Если в такой ситуации у вас наличные деньги — вы их потеряете. А если сбережения, например, в акциях иностранных компаний, то вы более защищены, так как вложили в экономику другой страны.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=29 data-line-end=30 ><a id=\"____29\"></a>Во что можно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"31\" data-line-end=\"32\">Инвестировать можно в разные вещи: в недвижимость, золото, акции, облигации или собственный бизнес. Если инвестиции принесли доход, значит это было успешное вложение денег, если дохода нет — инвестиции оказались убыточными.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"33\" data-line-end=\"34\">Некоторые люди инвестируют в бизнес — собственный или друзей и знакомых. Это может быть рискованно. Например, Всеволод создал стартап: молекулярное молоко для веганов. Вы подумали, что это перспективная тема, и решили вложить 50 000 ₽. Но веганы с подозрением отнеслись к этой затее, стартап провалился, а вы потеряли деньги.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"35\" data-line-end=\"36\">Бизнес сталкивается с риском прогореть практически ежедневно, да и забрать свою долю в нужный момент зачастую затруднительно.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"37\" data-line-end=\"38\">В России чаще всего инвестируют в недвижимость или просто кладут деньги на депозит — а это сложно назвать инвестициями. Часто таким способом можно просто сохранить деньги, но не приумножить их. Цены на недвижимость, вопреки распространенному мнению, не всегда растут. Например, в конце 2014 года цены на недвижимость резко выросли, а потом  <a href=\"https://www.irn.ru/gd/?class=all&amp;type=1&amp;period=0&amp;grnum=1&amp;currency=0&amp;select=period\">снижались</a>  2−3 года. В итоге к прежним ценам недвижимость вернулась только в 2020 году.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"39\" data-line-end=\"40\">Вложившись в конце 2014 года, вы бы просто сохранили свои средства, но ничего не заработали за 5−6 лет. Опять же, если вдруг понадобятся деньги, недвижимость не так просто продать, да и частично изъять деньги не получится.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"41\" data-line-end=\"42\">Самые доступные способы инвестиций — акции, облигации и фонды. Их ещё называют  <em>ценными бумагами</em>  или  <em>активами</em>. Раньше это были настоящие бумаги — с печатями и водяными знаками. Сейчас всё цифровое — покупают и продают активы через интернет, причем сделать это можно в любой момент. За ценными бумагами стоит реальный бизнес — фабрики,заводы, транспорт, персонал и многое другое. Надёжность такого бизнеса не сравнить, например, с овощной палаткой, которую могут закрыть в любой момент.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"43\" data-line-end=\"44\"><strong>Акции</strong> — это часть компании, доля в её капитале. Когда вы покупаете акцию, вы становитесь совладельцем компании и имеете право на часть её прибыли.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"45\" data-line-end=\"46\"><strong>Облигации</strong> — это когда вы даёте кредит компании или государству.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"47\" data-line-end=\"48\">А <strong>фонды</strong> — это готовые наборы ценных бумаг. Вы просто выбираете тот набор, который вам подходит. Покупать золото, например, можно через фонды. Обо всех инструментах будем говорить подробно на уроке 3.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=49 data-line-end=50 ><a id=\"____49\"></a>Как заработать на инвестициях</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"51\" data-line-end=\"52\">Заработать на инвестициях можно по-разному, доход зависит от выбранного инструмента. Цена акций может увеличиться, тогда можно продать их и получить прибыль от разницы в стоимости между покупкой и продажей. Часто по акциям компания платит дивиденды — часть прибыли. Обычно это какой-то процент, например: стоимость акции «Газпрома» — 166 ₽, дивидендная доходность — 8 %, значит, доход акционера 13,28 ₽.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"53\" data-line-end=\"54\">По облигациям платят купон — обычно это фиксированный процент, но бывает и плавающая ставка.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"55\" data-line-end=\"56\">Заработать можно больше, если доход от инвестиций не тратить, а снова инвестировать — покупать другие ценные бумаги или фонды. Это называется  <em>реинвестирование</em>. Получается накопительный эффект — когда накопленные проценты прибавляются к сумме вклада и на эту увеличенную сумму уже начисляют новый процент. Вклад постоянно растёт, и сумма процентов, соответственно, тоже.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"57\" data-line-end=\"58\">Если постоянно выводить полученный доход, то накопительного эффекта не будет. Даже если не брать в расчёт инвестиции, а посмотреть на вклад с невысокими процентами, то получается вот так:</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"59\" data-line-end=\"60\">Если выводить доход с инвестиций каждый год, то сложного процента не будет, а прибыль будет как минимум в 2 раза ниже, чем могла бы быть.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=61 data-line-end=62 ><a id=\"_____61\"></a>На какой срок можно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"63\" data-line-end=\"64\">Инвестировать можно на разный срок, хоть на день, хоть на 20 лет — зависит от вашей финансовой цели. Но от срока зависит, куда вкладывать, — чем больше срок, тем меньше риск и тем больше потенциальная доходность и эффект сложного процента. Например, облигации подойдут для краткосрочных вложений, на год-три, а акции — для долгосрочных, 10−20−30 лет.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=65 data-line-end=66 ><a id=\"__65\"></a>Как начать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"67\" data-line-end=\"68\">Чтобы начать инвестировать, не нужно иметь сразу несколько десятков тысяч рублей. Все гораздо проще — начать можно с нескольких сотен и постепенно увеличивать вложения.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"69\" data-line-end=\"70\">Начинать лучше прямо сейчас. Каждый день в инвестициях — это деньги, и терять их — неразумно. Если начать сейчас, то уже через 10−20 лет у вас будет накоплен капитал, которым вы сможете распорядиться так, как считаете нужным. Например, купить автодом, путешествовать и жить на проценты. Или отправить учиться в Англию сына. Когда есть деньги — открывается много возможностей. И лучше ими воспользоваться раньше, чем никогда.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"71\" data-line-end=\"72\">Начинать лучше с профессиональным брокером. Человек, который только начинает разбираться в инвестициях, может совершить ошибки и потерять деньги. Хороший брокер предложит вам обучающие сервисы, прогнозы по тому, будут ли ценные бумаги расти или падать, и даже личные рекомендации, — это называется инвестиционным консультированием. Это поможет вам не допустить банальных ошибок и успешно начать инвестировать.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"73\" data-line-end=\"74\">Кроме того, без брокера вы не сможете инвестировать — все сделки на бирже может совершать только он.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"75\" data-line-end=\"76\">В следующем уроке поговорим о том, что такое биржа, как выбрать брокера, открыть брокерский счёт и наконец-то сделать свою первую инвестицию.</p>",
            thumb = R.drawable.ic_deposit,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 1,
            title = "Привет, инвестирование!",
            level = 0,
            description = "Первые шаги на бирже для начинающих",
            content = "<blockquote>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"0\" data-line-end=\"5\">В России мало кто умеет грамотно распоряжаться деньгами. В большинстве<br>\n" +
                    "случаев люди покупают валюту, открывают депозит в банке или просто<br>\n" +
                    "собирают деньги в конверт — копят. Многие считают, что этого<br>\n" +
                    "достаточно. В результате инфляция или обвалившийся курс валюты могут<br>\n" +
                    "обесценить сбережения и человек потеряет свои деньги.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 class=\"code-line\" data-line-start=6 data-line-end=7 ><a id=\"_____6\"></a>Почему нельзя надеяться на депозит</h2>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"8\" data-line-end=\"9\">С начала 2019 года Центральный Банк Российской Федерации постепенно снижает ключевую ставку. Из-за этого проценты по депозитам упали почти в 2 раза — вместо 6−7 %, как в прошлом году, сейчас банки предлагают 3−4 %. А инфляция растёт — за 9 месяцев 2020 года она составила 3,67 %, а за последние 5 лет — 22,13 %. Это значит, что если бы вы 5 лет назад отложили 1 млн ₽, то сегодня эта сумма была бы эквивалентна 800 000 ₽, так как цены выросли. То есть вы просто так, на пустом месте, потеряли бы 200 000 ₽.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"10\" data-line-end=\"11\"><em><strong>Вот так растёт инфляция в России</strong></em></p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"12\" data-line-end=\"13\">Если бы вы положили этот миллион на депозит, то деньги бы не потеряли, но и ничего не заработали — процент по вкладу чуть больше инфляции. То есть депозит работает, скорее, как простое сбережение денег.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"14\" data-line-end=\"15\">Инвестиции позволяют получить доход больше, чем по вкладу. Например, вот данные по доходности за 10 лет:</p>\n" +
                    "<ul>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"16\" data-line-end=\"17\">депозиты — 6,3 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"17\" data-line-end=\"18\">государственные облигации — 9,8 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"18\" data-line-end=\"19\">акции США — 15,3 % годовых;</li>\n" +
                    "<li class=\"has-line-data\" data-line-start=\"19\" data-line-end=\"21\">российские акции — 24,8 % годовых.</li>\n" +
                    "</ul>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"21\" data-line-end=\"22\">Гораздо выгодней, чем депозиты.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=23 data-line-end=24 ><a id=\"___23\"></a>Зачем нужно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"25\" data-line-end=\"26\">Инвестиции помогают накопить на обучение, путешествия, новую машину, дом в Испании, пенсию и на что угодно ещё. Чем раньше вы начнёте инвестировать, тем быстрее достигнете своей финансовой цели.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"27\" data-line-end=\"28\">Инвестировать можно не только для того, чтобы получить доход. Грамотные инвестиции в разных валютах могут обезопасить вас от того, что конкретно в вашей стране произойдет кризис. Если в такой ситуации у вас наличные деньги — вы их потеряете. А если сбережения, например, в акциях иностранных компаний, то вы более защищены, так как вложили в экономику другой страны.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=29 data-line-end=30 ><a id=\"____29\"></a>Во что можно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"31\" data-line-end=\"32\">Инвестировать можно в разные вещи: в недвижимость, золото, акции, облигации или собственный бизнес. Если инвестиции принесли доход, значит это было успешное вложение денег, если дохода нет — инвестиции оказались убыточными.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"33\" data-line-end=\"34\">Некоторые люди инвестируют в бизнес — собственный или друзей и знакомых. Это может быть рискованно. Например, Всеволод создал стартап: молекулярное молоко для веганов. Вы подумали, что это перспективная тема, и решили вложить 50 000 ₽. Но веганы с подозрением отнеслись к этой затее, стартап провалился, а вы потеряли деньги.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"35\" data-line-end=\"36\">Бизнес сталкивается с риском прогореть практически ежедневно, да и забрать свою долю в нужный момент зачастую затруднительно.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"37\" data-line-end=\"38\">В России чаще всего инвестируют в недвижимость или просто кладут деньги на депозит — а это сложно назвать инвестициями. Часто таким способом можно просто сохранить деньги, но не приумножить их. Цены на недвижимость, вопреки распространенному мнению, не всегда растут. Например, в конце 2014 года цены на недвижимость резко выросли, а потом  <a href=\"https://www.irn.ru/gd/?class=all&amp;type=1&amp;period=0&amp;grnum=1&amp;currency=0&amp;select=period\">снижались</a>  2−3 года. В итоге к прежним ценам недвижимость вернулась только в 2020 году.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"39\" data-line-end=\"40\">Вложившись в конце 2014 года, вы бы просто сохранили свои средства, но ничего не заработали за 5−6 лет. Опять же, если вдруг понадобятся деньги, недвижимость не так просто продать, да и частично изъять деньги не получится.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"41\" data-line-end=\"42\">Самые доступные способы инвестиций — акции, облигации и фонды. Их ещё называют  <em>ценными бумагами</em>  или  <em>активами</em>. Раньше это были настоящие бумаги — с печатями и водяными знаками. Сейчас всё цифровое — покупают и продают активы через интернет, причем сделать это можно в любой момент. За ценными бумагами стоит реальный бизнес — фабрики,заводы, транспорт, персонал и многое другое. Надёжность такого бизнеса не сравнить, например, с овощной палаткой, которую могут закрыть в любой момент.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"43\" data-line-end=\"44\"><strong>Акции</strong> — это часть компании, доля в её капитале. Когда вы покупаете акцию, вы становитесь совладельцем компании и имеете право на часть её прибыли.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"45\" data-line-end=\"46\"><strong>Облигации</strong> — это когда вы даёте кредит компании или государству.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"47\" data-line-end=\"48\">А <strong>фонды</strong> — это готовые наборы ценных бумаг. Вы просто выбираете тот набор, который вам подходит. Покупать золото, например, можно через фонды. Обо всех инструментах будем говорить подробно на уроке 3.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=49 data-line-end=50 ><a id=\"____49\"></a>Как заработать на инвестициях</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"51\" data-line-end=\"52\">Заработать на инвестициях можно по-разному, доход зависит от выбранного инструмента. Цена акций может увеличиться, тогда можно продать их и получить прибыль от разницы в стоимости между покупкой и продажей. Часто по акциям компания платит дивиденды — часть прибыли. Обычно это какой-то процент, например: стоимость акции «Газпрома» — 166 ₽, дивидендная доходность — 8 %, значит, доход акционера 13,28 ₽.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"53\" data-line-end=\"54\">По облигациям платят купон — обычно это фиксированный процент, но бывает и плавающая ставка.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"55\" data-line-end=\"56\">Заработать можно больше, если доход от инвестиций не тратить, а снова инвестировать — покупать другие ценные бумаги или фонды. Это называется  <em>реинвестирование</em>. Получается накопительный эффект — когда накопленные проценты прибавляются к сумме вклада и на эту увеличенную сумму уже начисляют новый процент. Вклад постоянно растёт, и сумма процентов, соответственно, тоже.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"57\" data-line-end=\"58\">Если постоянно выводить полученный доход, то накопительного эффекта не будет. Даже если не брать в расчёт инвестиции, а посмотреть на вклад с невысокими процентами, то получается вот так:</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"59\" data-line-end=\"60\">Если выводить доход с инвестиций каждый год, то сложного процента не будет, а прибыль будет как минимум в 2 раза ниже, чем могла бы быть.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=61 data-line-end=62 ><a id=\"_____61\"></a>На какой срок можно инвестировать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"63\" data-line-end=\"64\">Инвестировать можно на разный срок, хоть на день, хоть на 20 лет — зависит от вашей финансовой цели. Но от срока зависит, куда вкладывать, — чем больше срок, тем меньше риск и тем больше потенциальная доходность и эффект сложного процента. Например, облигации подойдут для краткосрочных вложений, на год-три, а акции — для долгосрочных, 10−20−30 лет.</p>\n" +
                    "<h3 class=\"code-line\" data-line-start=65 data-line-end=66 ><a id=\"__65\"></a>Как начать</h3>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"67\" data-line-end=\"68\">Чтобы начать инвестировать, не нужно иметь сразу несколько десятков тысяч рублей. Все гораздо проще — начать можно с нескольких сотен и постепенно увеличивать вложения.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"69\" data-line-end=\"70\">Начинать лучше прямо сейчас. Каждый день в инвестициях — это деньги, и терять их — неразумно. Если начать сейчас, то уже через 10−20 лет у вас будет накоплен капитал, которым вы сможете распорядиться так, как считаете нужным. Например, купить автодом, путешествовать и жить на проценты. Или отправить учиться в Англию сына. Когда есть деньги — открывается много возможностей. И лучше ими воспользоваться раньше, чем никогда.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"71\" data-line-end=\"72\">Начинать лучше с профессиональным брокером. Человек, который только начинает разбираться в инвестициях, может совершить ошибки и потерять деньги. Хороший брокер предложит вам обучающие сервисы, прогнозы по тому, будут ли ценные бумаги расти или падать, и даже личные рекомендации, — это называется инвестиционным консультированием. Это поможет вам не допустить банальных ошибок и успешно начать инвестировать.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"73\" data-line-end=\"74\">Кроме того, без брокера вы не сможете инвестировать — все сделки на бирже может совершать только он.</p>\n" +
                    "<p class=\"has-line-data\" data-line-start=\"75\" data-line-end=\"76\">В следующем уроке поговорим о том, что такое биржа, как выбрать брокера, открыть брокерский счёт и наконец-то сделать свою первую инвестицию.</p>",
            thumb = R.drawable.ic_deposit,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 2,
            title = "Здраствуй, кредитование",
            level = 0,
            description = "Первые шаги в кредитовании для начинающих",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_deposit,
            category = "Вклад",
            favourite = false,
            price = 1000
        ),
        Education(
            id = 4,
            title = "Фьючерс - это ... репер?",
            level = 0,
            description = "Расскажем, что такое фьючерсы и научим ими пользоватся.",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_stock,
            category = "Биржа",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 5,
            title = "Страхование вкладов",
            level = 0,
            description = "Расскажем, что такое страхование вкладов и почему стоит выбирать именно такие вклады.",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_deposit,
            category = "Вклад",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 6,
            title = "Потреб или целевой кредит",
            level = 0,
            description = "Какой кредит выбрать и что проще получить?",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_credit,
            category = "Кредитование",
            favourite = false,
            price = 5000
        ),
        Education(
            id = 10,
            title = "Шорты",
            level = 1,
            description = "Что такое «шорты» или как заработать на падении акций",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_stock,
            category = "Биржа",
            favourite = false,
            price = 10000
        ),
        Education(
            id = 11,
            title = "Рефинансирование",
            level = 1,
            description = "Выплатить до конца или взять еще денег, как поступить?",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_credit,
            category = "Кредитование",
            favourite = false,
            price = 10000
        ),
        Education(
            id = 22,
            title = "Причины инфляции",
            level = 2,
            description = "Почему же все дорожает?",
            content = "Какой крутой контент",
            thumb = R.drawable.ic_deposit,
            category = "Вклад",
            favourite = false,
            price = 100000
        ),
    )

}